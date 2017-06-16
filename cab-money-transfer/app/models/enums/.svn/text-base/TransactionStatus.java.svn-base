package models.enums;

public enum TransactionStatus{
    TRANSACTION_BLOCKING("transaction_blocking"), // has been blocking because of the rule
    TRANSACTION_REVIEWED("transaction_reviewed"), // when CO clicks review
    TRANSACTION_REJECTED("transaction_rejected"), // was rejected by CO
    TRANSACTION_REJECTING("transaction_rejected_view"), // the rejected transaction was view by Teller
    TRANSACTION_BLOCKED("transaction_blocked"), // has been blocked because of rule
    TRANSACTION_APPROVED("transaction_approved"), // was approved by CO
    TRANSACTION_DONE("transaction_done"), // normal process without any problem
    TRANSACTION_ERROR("transaction_error"), // was error by runtime
    TRANSACTION_CANCELED("transaction_canceled"); // the transaction that was cancel by teller
    
    private String _code;
    
    private TransactionStatus(final String code){
        _code = code;
    }
    
    /**
     * @return {@link String}
     */
    public String getCode(){
        return _code;
    }
    
    /**
     * @param code
     */
    public void setCode(final String code){
        _code = code;
    }
    
    @Override
    public String toString(){
        return getCode();
    }
    
}
