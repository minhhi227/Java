/**
 * Created on Nov 18, 2014
 */
package models.dto.datatable;

import java.util.Map;

/**
 * @author Vichrak
 */
public abstract class AbstractDataTableParams{
    
    private String _sEcho;
    private String _sSearch;
    private String _iDisplayLength;
    private String _iDisplayStart;
    private String _iColumns;
    private String _iSortingCols;
    private String _sColumns;
    private long _iTotalRecords;
    private String _iSortCol_0;
    private String _sSortDir_0;
    private String _username;
    
    public AbstractDataTableParams(){
        super();
    }
    
    public AbstractDataTableParams(Map<String, String[]> params){
        _sEcho = params.get("sEcho")[0];
        _sSearch = params.get("sSearch")[0];
        _iDisplayLength = params.get("iDisplayLength")[0];
        _iDisplayStart = params.get("iDisplayStart")[0];
        _iColumns = params.get("iColumns")[0];
        _iSortingCols = params.get("iSortingCols")[0];
        _sColumns = params.get("sColumns")[0];
        if(params.get("iSortCol_0") != null){
            _iSortCol_0 = params.get("iSortCol_0")[0];
        }
        if(params.get("sSortDir_0") != null){
            _sSortDir_0 = params.get("sSortDir_0")[0];
        }
    }
    
    public String getsEcho(){
        return _sEcho;
    }
    
    public void setsEcho(final String sEcho){
        _sEcho = sEcho;
    }
    
    public String getsSearch(){
        return _sSearch;
    }
    
    public void setsSearch(final String sSearch){
        _sSearch = sSearch;
    }
    
    public String getiDisplayLength(){
        return _iDisplayLength;
    }
    
    public void setiDisplayLength(final String iDisplayLength){
        _iDisplayLength = iDisplayLength;
    }
    
    public String getiDisplayStart(){
        return _iDisplayStart;
    }
    
    public void setiDisplayStart(final String iDisplayStart){
        _iDisplayStart = iDisplayStart;
    }
    
    public String getiColumns(){
        return _iColumns;
    }
    
    public void setiColumns(final String iColumns){
        _iColumns = iColumns;
    }
    
    public String getiSortingCols(){
        return _iSortingCols;
    }
    
    public void setiSortingCols(final String iSortingCols){
        _iSortingCols = iSortingCols;
    }
    
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
    
    public String getSSortDir_0(){
        return _sSortDir_0;
    }
    
    public void setSSortDir_0(final String sSortDir_0){
        _sSortDir_0 = sSortDir_0;
    }
    
    /**
     * @return the username
     */
    public String getUsername(){
        return _username;
    }
    
    /**
     * @param username 
     * 			the username to set
     */
    public void setUsername(final String username){
        _username = username;
    }
    
}
