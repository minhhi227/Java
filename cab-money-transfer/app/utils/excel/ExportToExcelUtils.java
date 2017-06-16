/*
 * Created on 25 Oct 2014
 */
package utils.excel;

import java.util.Map;

import models.dto.RemittanceReportDtoContainer;
import transformer.excel.ExportToExcelTransformer;

public class ExportToExcelUtils{
    
    /**
     * constructor
     */
    public ExportToExcelUtils(){
        super();
    }
    
    /**
     * @param srcFilePath
     * @param beanParams
     * @param destFilePath
     */
    public static void generateExcelFile(final String srcFilePath, final Map beanParams, final String destFilePath){
        ExportToExcelTransformer _exportToExcelTransformer = new ExportToExcelTransformer();
        _exportToExcelTransformer.transform(srcFilePath, beanParams, destFilePath);
    }
    
    public static void generateExcelForRemittanceReportDtoContainer(final RemittanceReportDtoContainer remittanceReportDtoContainer, final String srcFilePath, final Map beanParams, final String destFilePath){
        ExportToExcelTransformer _exportToExcelTransformer = new ExportToExcelTransformer();
        _exportToExcelTransformer.transformRemittanceReportDtoContainer(remittanceReportDtoContainer,srcFilePath, beanParams, destFilePath);
    }
    
}
