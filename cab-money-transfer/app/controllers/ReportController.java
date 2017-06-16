/**
 * Created on: 5/10/2014
 */
package controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import models.SenderReceiverTransaction;
import models.User;
import models.dto.RemittanceReportDto;
import models.dto.RemittanceReportDtoContainer;
import models.dto.datatable.RemittanceReportDataTableParams;

import org.apache.commons.collections.CollectionUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import play.cache.Cache;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Security;
import utils.CABConstantKeys;
import utils.DateUtils;
import utils.StringUtil;
import utils.excel.ExportToExcelUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.ConfigFactory;

import controllers.core.AbstractController;
import controllers.core.Secured;

/**
 * @author vichrak
 */
@Security.Authenticated(Secured.class)
public class ReportController extends AbstractController{
    
    private static final String CACHE_KEY_REMTTANCE_REPORT_DTO = "remittanceReportDto";
    private static final String EXCEL_REMITTANCE_REPORT_TEMPLATE = "templates\\jxls\\template-export-remittance-excel.xls";
    private static final String TARGET_DIRECTORY = System.getProperty("java.io.tmpdir");
    private static final String EXCEL_FILE_NAME = "remittance_";
    private static final String EXCEL_EXTENTION = ".xls";
    private static final String EXCEL_MIMETYPE = "application/vnd.ms-excel";
    private static User _user;
    
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        _user = User.findByLogin(request().username());
        Cache.set(CACHE_KEY_REMTTANCE_REPORT_DTO + getUsername(), null);
        final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
        final List<SenderReceiverTransaction> blockingRemittanceTransactions = SenderReceiverTransaction.getBlockingRemittanceTransaction(branchId, getUsername());
        final String notificationInterval = ConfigFactory.load().getString("NOTIFICATION_INTERVAL");
        return ok(views.html.reporter.report.render(_user, "report", blockingRemittanceTransactions, notificationInterval));
    }
    
    @Transactional(readOnly = true)
    public static Result exportExcel() throws Throwable{
        final StringBuilder destination = new StringBuilder(TARGET_DIRECTORY);
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat daysFormat = new SimpleDateFormat("dd");
        
        final StringBuilder fileName = new StringBuilder(EXCEL_FILE_NAME);
        fileName.append(calendar.get(Calendar.YEAR)).append(monthFormat.format(calendar.getTime()));
        fileName.append(daysFormat.format(calendar.getTime())).append(EXCEL_EXTENTION);
        
        destination.append(getUsername() + fileName);
        
        File file = JPA.withTransaction(new play.libs.F.Function0<File>(){
            
            @Override
            public File apply() throws Throwable{
                RemittanceReportDtoContainer remittanceReportDtoContainer = (RemittanceReportDtoContainer) Cache.get(CACHE_KEY_REMTTANCE_REPORT_DTO + getUsername());
                if(remittanceReportDtoContainer != null && CollectionUtils.isNotEmpty(remittanceReportDtoContainer.getRemittanceReportDtos())){
                    Map<String, RemittanceReportDtoContainer> beans = new HashMap<String, RemittanceReportDtoContainer>();
                    beans.put("remittanceReportDtoContainer", remittanceReportDtoContainer);
                    File destFile = File.createTempFile("Export-" + new Date().getTime(), EXCEL_EXTENTION);
                    ExportToExcelUtils.generateExcelForRemittanceReportDtoContainer(remittanceReportDtoContainer,CABConstantKeys.PATH_TEMPLATE_EXCEL + EXCEL_REMITTANCE_REPORT_TEMPLATE, beans, destFile.getPath());
                    return destFile;
                }
                else{
                    return null;
                }
            }
        });
        response().setHeader("Content-Disposition", "attachment; filename=\"" + fileName.toString() + "\"");
        return ok(file).as(EXCEL_MIMETYPE);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getRemittanceReport(){
        Map<String, String[]> params = request().queryString();
        RemittanceReportDataTableParams remittanceReportDataTableParams = new RemittanceReportDataTableParams(params);
        remittanceReportDataTableParams.setUsername(getUsername());
        List<RemittanceReportDto> remittanceReportDtos = getRemittanceReportDtos(remittanceReportDataTableParams);
        JSONArray[] jsonData = new JSONArray[remittanceReportDtos.size()];
        int i = 0;
        
        for(RemittanceReportDto remittanceReportDto : remittanceReportDtos){
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(i + 1);
            jsonArray.add(DateUtils.getDateLabel(remittanceReportDto.getMadeDate()));
            jsonArray.add(remittanceReportDto.getBankRef());
            jsonArray.add(remittanceReportDto.getSenderFullName());
            jsonArray.add(remittanceReportDto.getCBRef());
            jsonArray.add(remittanceReportDto.getSenderAddress());
            jsonArray.add(DateUtils.getDateLabel(remittanceReportDto.getSenderDateOfBirth()));
            jsonArray.add(remittanceReportDto.getSenderIdentityNo());
            jsonArray.add(DateUtils.getDateLabel(remittanceReportDto.getSenderExpiredDate()));
            jsonArray.add(remittanceReportDto.getAmountOutward());
            jsonArray.add(remittanceReportDto.getCurrencyName());
            jsonArray.add(remittanceReportDto.getExchangeRate());
            jsonArray.add(remittanceReportDto.getFee());
            jsonArray.add(remittanceReportDto.getCable());
            jsonArray.add(remittanceReportDto.getOther());
            jsonArray.add(remittanceReportDto.getReceiverAccountNo());
            jsonArray.add(remittanceReportDto.getReceiverFullName());
            jsonArray.add(remittanceReportDto.getPurpose());
            jsonData[i] = jsonArray;
            i++;
        }
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CABConstantKeys.SECHO, remittanceReportDataTableParams.getsEcho());
        jsonObject.put(CABConstantKeys.ITOTALRECORDS, remittanceReportDataTableParams.getiTotalRecords());
        jsonObject.put(CABConstantKeys.ITOTALDISPLAYRECORDS, remittanceReportDataTableParams.getiTotalRecords());
        jsonObject.put(CABConstantKeys.AADATA, jsonData);
        JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
        return ok(jsonNode);
    }
    
    @SuppressWarnings("unchecked")
    public static List<RemittanceReportDto> getRemittanceReportDtos(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        String queryString = buildRemittanceReportQuery(remittanceReportDataTableParams);
        queryString += buildOrderByClause(remittanceReportDataTableParams);
        Query query = JPA.em().createQuery(queryString);
        SenderReceiverTransaction.setParameterBuildWhereClauseByJQueryDataTableParam(query, remittanceReportDataTableParams);
        
        List<RemittanceReportDto> remittanceReportDtos = query.getResultList();
        remittanceReportDataTableParams.setiTotalRecords(remittanceReportDtos.size());
        for(RemittanceReportDto remittanceReportDto : remittanceReportDtos){
            remittanceReportDto.setFormattedMadeDate(DateUtils.getDateLabel(remittanceReportDto.getMadeDate()));
            remittanceReportDto.setFormattedSenderDateOfBirth(DateUtils.getDateLabel(remittanceReportDto.getSenderDateOfBirth()));
            remittanceReportDto.setFormattedSenderExpiredDate(DateUtils.getDateLabel(remittanceReportDto.getSenderExpiredDate()));
        }
        RemittanceReportDtoContainer remittanceReportDtoContainer = new RemittanceReportDtoContainer(remittanceReportDtos, remittanceReportDataTableParams.isShowSenderAddress(), remittanceReportDataTableParams.isShowSenderDOB(), remittanceReportDataTableParams.isShowSenderIdentityNo(), remittanceReportDataTableParams.isShowSenderExpiredDate());
        Cache.set(CACHE_KEY_REMTTANCE_REPORT_DTO + getUsername(), remittanceReportDtoContainer);
        
        query.setFirstResult(Integer.parseInt(remittanceReportDataTableParams.getiDisplayStart()));
        query.setMaxResults(Integer.parseInt(remittanceReportDataTableParams.getiDisplayLength()));
        
        return query.getResultList();
    }
    
    private static String buildOrderByClause(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        StringBuilder orderByClause = new StringBuilder();
        orderByClause.append(" ORDER BY ").append(getMapColumnSort(remittanceReportDataTableParams)).append(" ").append(remittanceReportDataTableParams.getSSortDir_0());
        return orderByClause.toString();
    }
    
    private static String getMapColumnSort(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        Map<String, String> columnNamesByIndex = new HashMap<String, String>();
        columnNamesByIndex.put(StringUtil.ZERO, "srt.id");
        columnNamesByIndex.put("1", "srt.dateTransaction");
        columnNamesByIndex.put("2", "srt.bankRef");
        columnNamesByIndex.put("3", "s.fullName");
        columnNamesByIndex.put("4", "s.accountNo");
        columnNamesByIndex.put("5", "s.address");
        columnNamesByIndex.put("6", "s.dateOfBirth");
        columnNamesByIndex.put("7", "s.identityNumber");
        columnNamesByIndex.put("8", "s.expiredDate");
        columnNamesByIndex.put("9", "srt.amount");
        columnNamesByIndex.put("10", "c.name");
        columnNamesByIndex.put("11", "srt.exchangeAmount");
        columnNamesByIndex.put("12", "srt.fee");
        columnNamesByIndex.put("13", "srt.cable");
        columnNamesByIndex.put("14", "srt.other");
        columnNamesByIndex.put("15", "r.accountNo");
        columnNamesByIndex.put("16", "r.fullName");
        columnNamesByIndex.put("17", "srt.purpose");
        return columnNamesByIndex.get(remittanceReportDataTableParams.getiSortCol_0());
    }
    
    private static String buildRemittanceReportQuery(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT new models.dto.RemittanceReportDto(");
        queryStr.append("srt.dateTransaction");
        queryStr.append(",srt.bankRef");
        queryStr.append(",s.fullName");
        queryStr.append(",s.companyName");
        queryStr.append(",s.accountNo"); // CBRef
        queryStr.append(",s.address");
        queryStr.append(",s.dateOfBirth");
        queryStr.append(",s.identityNumber");
        queryStr.append(",s.expiredDate");
        queryStr.append(",srt.amount"); // Amount Outward
        queryStr.append(",c.name");
        queryStr.append(",srt.exchangeAmount");
        queryStr.append(",srt.fee");
        queryStr.append(",srt.cable");
        queryStr.append(",srt.other"); // OUR
        queryStr.append(",r.accountNo");
        queryStr.append(",r.fullName");
        queryStr.append(",srt.purpose)");
        queryStr.append(" FROM SenderReceiverTransaction srt ");
        queryStr.append("INNER JOIN srt.sender s ");
        queryStr.append("INNER JOIN srt.receiver r ");
        queryStr.append("INNER JOIN srt.currency c ");
        queryStr.append("WHERE srt.branch.id=:branchId");
        queryStr.append(SenderReceiverTransaction.buildWhereClauseByJQueryDataTableParam(remittanceReportDataTableParams));
        return queryStr.toString();
    }
    
}
