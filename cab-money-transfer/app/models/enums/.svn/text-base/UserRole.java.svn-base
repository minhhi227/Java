/*
 * Created on Jun 5, 2013
 */
package models.enums;

public enum UserRole{
    ROLE_ADMINISTRATOR ("role_administrator"), 
    ROLE_COMPLIANCE_OFFICER ("role_compliance_officer"), 
    ROLE_TELLER ("role_teller"), 
    ROLE_REPORTER ("role_reporter");
    
    private String _code;
    
    private UserRole (final String code){
        _code = code;
    }
    
    /**
     * @return {@link String}
     */
    public String getCode (){
        return _code;
    }
    
    /**
     * 
     * @param code
     */
    public void setCode (final String code){
        _code = code;
    }
    
    @Override
    public String toString (){
        return getCode ();
    }
    
}
