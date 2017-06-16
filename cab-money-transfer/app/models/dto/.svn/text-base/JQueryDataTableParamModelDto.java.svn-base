/**
 * created on 18/10/2014
 */
package models.dto;

import java.util.Date;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import utils.DateUtils;

/**
 * @author Chamnan
 *
 */
public class JQueryDataTableParamModelDto{
    
    private String _sEcho;
    private String _sSearch;
    private String _iDisplayLength;
    private String _iDisplayStart;
    private String _iColumns;
    private String _iSortingCols;
    private String _sColumns;
    private long _iTotalRecords;
    private String _iSortCol_0;
    private Date _dateDebut;
    private Date _dateFin;
    private String _searchAny;
    private String _sSortDir_0;
    /* For advanced search */
    private String _advSenderFullName;
    private String _advSenderAccountNo;
    private String _advSenderIdentityNo;
    private String _advIntermediaryBank;
    private String _advSwiftCode;
    private String _advReceiverAccountNo;
    private String _advReceiverFullName;
    private String _userName;
    
    /**
     * default constructor
     */
    public JQueryDataTableParamModelDto(){
        super();
    }
    
    public JQueryDataTableParamModelDto(Map<String, String[]> params){
        _sEcho = params.get("sEcho")[0];
        _sSearch = params.get("sSearch")[0];
        _iDisplayLength = params.get("iDisplayLength")[0];
        _iDisplayStart = params.get("iDisplayStart")[0];
        _iColumns = params.get("iColumns")[0];
        _iSortingCols = params.get("iSortingCols")[0];
        _sColumns = params.get("sColumns")[0];
        if(params.get("searchFromDate") != null && StringUtils.isNotBlank(params.get("searchFromDate")[0])){
            _dateDebut = DateUtils.getDate(params.get("searchFromDate")[0]);
        }
        if(params.get("searchToDate") != null && StringUtils.isNotBlank(params.get("searchToDate")[0])){
            _dateFin = DateUtils.getDate(params.get("searchToDate")[0]);
        }
        if(params.get("txtSearchAny") != null && StringUtils.isNotBlank(params.get("txtSearchAny")[0])){
            _searchAny = params.get("txtSearchAny")[0];
        }
        if(params.get("iSortCol_0") != null){
            _iSortCol_0 = params.get("iSortCol_0")[0];
        }
        if(params.get("sSortDir_0") != null){
            _sSortDir_0 = params.get("sSortDir_0")[0];
        }
        /* for advanced search remittance */
        if(params.get("advSenderFullName") != null && StringUtils.isNotBlank(params.get("advSenderFullName")[0])){
            _advSenderFullName = params.get("advSenderFullName")[0];
        }
        if(params.get("advSenderAccountNo") != null && StringUtils.isNotBlank(params.get("advSenderAccountNo")[0])){
            _advSenderAccountNo = params.get("advSenderAccountNo")[0];
        }
        if(params.get("advSenderIdentityNo") != null && StringUtils.isNotBlank(params.get("advSenderIdentityNo")[0])){
            _advSenderIdentityNo = params.get("advSenderIdentityNo")[0];
        }
        if(params.get("advIntermediaryBank") != null && StringUtils.isNotBlank(params.get("advIntermediaryBank")[0])){
            _advIntermediaryBank = params.get("advIntermediaryBank")[0];
        }
        
        if(params.get("advSwiftCode") != null && StringUtils.isNotBlank(params.get("advSwiftCode")[0])){
            _advSwiftCode = params.get("advSwiftCode")[0];
        }
        if(params.get("advReceiverAccountNo") != null && StringUtils.isNotBlank(params.get("advReceiverAccountNo")[0])){
            _advReceiverAccountNo = params.get("advReceiverAccountNo")[0];
        }
        if(params.get("advReceiverFullName") != null && StringUtils.isNotBlank(params.get("advReceiverFullName")[0])){
            _advReceiverFullName = params.get("advReceiverFullName")[0];
        }
    }
    
    /// Request sequence number sent by DataTable,
    /// same value must be returned in response
    public String getsEcho(){
        return _sEcho;
    }
    
    public void setsEcho(final String sEcho){
        _sEcho = sEcho;
    }
    
    /// Text used for filtering
    public String getsSearch(){
        return _sSearch;
    }
    
    public void setsSearch(final String sSearch){
        _sSearch = sSearch;
    }
    
    /// Number of records that should be shown in table
    public String getiDisplayLength(){
        return _iDisplayLength;
    }
    
    public void setiDisplayLength(final String iDisplayLength){
        _iDisplayLength = iDisplayLength;
    }
    
    /// First record that should be shown(used for paging)
    public String getiDisplayStart(){
        return _iDisplayStart;
    }
    
    public void setiDisplayStart(final String iDisplayStart){
        _iDisplayStart = iDisplayStart;
    }
    
    /// Number of columns in table
    public String getiColumns(){
        return _iColumns;
    }
    
    public void setiColumns(final String iColumns){
        _iColumns = iColumns;
    }
    
    /// Number of columns that are used in sorting
    public String getiSortingCols(){
        return _iSortingCols;
    }
    
    public void setiSortingCols(final String iSortingCols){
        _iSortingCols = iSortingCols;
    }
    
    /// Comma separated list of column names
    public String getsColumns(){
        return _sColumns;
    }
    
    public void setsColumns(final String sColumns){
        _sColumns = sColumns;
    }
    
    public long getiTotalRecords(){
        return _iTotalRecords;
    }
    
    public void setiTotalRecords(final long iTotalRecords){
        _iTotalRecords = iTotalRecords;
    }
    
    public String getiSortCol_0(){
        return _iSortCol_0;
    }
    
    public void setiSortCol_0(final String iSortCol_0){
        _iSortCol_0 = iSortCol_0;
    }
    
    /**
     * @return {@link Date}
     */
    public Date getDateDebut(){
        return _dateDebut;
    }
    
    /**
     * @param dateDebut
     */
    public void setDateDebut(final Date dateDebut){
        _dateDebut = dateDebut;
    }
    
    /**
     * @return {@link Date}
     */
    public Date getDateFin(){
        return _dateFin;
    }
    
    /**
     * @param dateFin
     */
    public void setDateFin(final Date dateFin){
        _dateFin = dateFin;
    }
    
    public String getSearchAny(){
        return _searchAny;
    }
    
    public void setSearchAny(final String searchAny){
        _searchAny = searchAny;
    }
    
    public String getSSortDir_0(){
        return _sSortDir_0;
    }
    
    public void setSSortDir_0(final String sSortDir_0){
        _sSortDir_0 = sSortDir_0;
    }
    
    /**
     * @return the advSenderFullName
     */
    public String getAdvSenderFullName(){
        return _advSenderFullName;
    }
    
    /**
     * @param advSenderFullName 
     * 			the advSenderFullName to set
     */
    public void setAdvSenderFullName(final String advSenderFullName){
        _advSenderFullName = advSenderFullName;
    }
    
    /**
     * @return the advSenderAccountNo
     */
    public String getAdvSenderAccountNo(){
        return _advSenderAccountNo;
    }
    
    /**
     * @param advSenderAccountNo 
     * 			the advSenderAccountNo to set
     */
    public void setAdvSenderAccountNo(final String advSenderAccountNo){
        _advSenderAccountNo = advSenderAccountNo;
    }
    
    /**
     * @return the advSenderIdentityNo
     */
    public String getAdvSenderIdentityNo(){
        return _advSenderIdentityNo;
    }
    
    /**
     * @param advSenderIdentityNo 
     * 			the advSenderIdentityNo to set
     */
    public void setAdvSenderIdentityNo(final String advSenderIdentityNo){
        _advSenderIdentityNo = advSenderIdentityNo;
    }
    
    /**
     * @return the advIntermediaryBank
     */
    public String getAdvIntermediaryBank(){
        return _advIntermediaryBank;
    }
    
    /**
     * @param advIntermediaryBank 
     * 			the advIntermediaryBank to set
     */
    public void setAdvIntermediaryBank(final String advIntermediaryBank){
        _advIntermediaryBank = advIntermediaryBank;
    }
    
    /**
     * @return the advSwiftCode
     */
    public String getAdvSwiftCode(){
        return _advSwiftCode;
    }
    
    /**
     * @param advSwiftCode 
     * 			the advSwiftCode to set
     */
    public void setAdvSwiftCode(final String advSwiftCode){
        _advSwiftCode = advSwiftCode;
    }
    
    /**
     * @return the advReceiverAccountNo
     */
    public String getAdvReceiverAccountNo(){
        return _advReceiverAccountNo;
    }
    
    /**
     * @param advReceiverAccountNo 
     * 			the advReceiverAccountNo to set
     */
    public void setAdvReceiverAccountNo(final String advReceiverAccountNo){
        _advReceiverAccountNo = advReceiverAccountNo;
    }
    
    /**
     * @return the advReceiverFullName
     */
    public String getAdvReceiverFullName(){
        return _advReceiverFullName;
    }
    
    /**
     * @param advReceiverFullName 
     * 			the advReceiverFullName to set
     */
    public void setAdvReceiverFullName(final String advReceiverFullName){
        _advReceiverFullName = advReceiverFullName;
    }
    
    /**
     * @return the userName
     */
    public String getUserName(){
        return _userName;
    }
    
    /**
     * @param userName the userName to set
     */
    public void setUserName(final String userName){
        _userName = userName;
    }
    
}
