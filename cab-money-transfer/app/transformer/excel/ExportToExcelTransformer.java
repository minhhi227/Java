/*
 * Created on 16 mai 2012
 */
package transformer.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.dto.RemittanceReportDtoContainer;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * @author vichrak
 *
 */
public class ExportToExcelTransformer implements ExcelTransformer{
    
    private static Log LOG = LogFactory.getLog(ExportToExcelTransformer.class);
    
    /**
     * constructor
     */
    public ExportToExcelTransformer(){
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void transform(final String srcFilePath, final Map beanParams, final String destFilePath){
        XLSTransformer transformer = new XLSTransformer();
        try{
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);
        }
        catch(ParsePropertyException ppe){
            LOG.error(ppe.getMessage(), ppe);
        }
        catch(InvalidFormatException ife){
            LOG.error(ife.getMessage(), ife);
        }
        catch(IOException ioe){
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    @Override
    public void transformRemittanceReportDtoContainer(final RemittanceReportDtoContainer remittanceReportDtoContainer, final String srcFilePath,final  Map beanParams,final String destFilePath) {
        XLSTransformer transformer = new XLSTransformer();
        try{
            List<String> columnToHide = new ArrayList<String>();
            if(!remittanceReportDtoContainer.isShowSenderAddress()) {
                columnToHide.add("remittanceReportDto.getSenderAddress()");
            }
            if(!remittanceReportDtoContainer.isShowSenderDOB()) {
                columnToHide.add("remittanceReportDto.getFormattedSenderDateOfBirth()");
            }
            if(!remittanceReportDtoContainer.isShowSenderIdentityNo()) {
                columnToHide.add("remittanceReportDto.getSenderIdentityNo()");
            }
            if(!remittanceReportDtoContainer.isShowExpiredDate()) {
                columnToHide.add("remittanceReportDto.getFormattedSenderExpiredDate()");
            }
            transformer.setColumnPropertyNamesToHide(columnToHide.toArray(new String[columnToHide.size()]));
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);
        }
        catch(ParsePropertyException ppe){
            LOG.error(ppe.getMessage(), ppe);
        }
        catch(InvalidFormatException ife){
            LOG.error(ife.getMessage(), ife);
        }
        catch(IOException ioe){
            LOG.error(ioe.getMessage(), ioe);
        }
    }
    
}
