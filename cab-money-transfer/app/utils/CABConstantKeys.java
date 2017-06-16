/**
 * Oct 5, 2014
 */
package utils;

import com.typesafe.config.ConfigFactory;

import models.enums.TransactionStatus;

/**
 * @author vichrak
 *
 */
public class CABConstantKeys{
    
    public static final String SECRET_KEY = "wHMAAOBY0wu";
    public static final String KEY = "currentUserId";
    
    /**
     * session time out
     */
    public static final String LAST_ACTION_TIME = "lastActionTime";
    public static final float SESSION_TIME_OUT = 60; // session time out in seconds
    public static final String MESSAGE_TIME_OUT = "* Session expired";
    public static final String TIME_OUT = "time-out";
    public static final String FLASH_ERROR = "error";
    
    /**
     * Status
     */
    public static final String FAILED = "failed";
    public static final String SUCCESS = "success";
    public static final String WARNING = "warning";
    public static final String BLOCK = "block";
    public static final String MESSAGE = "message";
    //    public static final String MESSAGE_TRANSACTION_SENDER_BEING_BLOCK = "<div class=\"alert alert-warning\" role=\"alert\">Block: Sender had sent to receiver more than two.<br/>Do you want to request for approval ?</div>";
    //    public static final String MESSAGE_TRANSACTION_RECIEVER_BEING_BLOCK = "<div class=\"alert alert-warning\" role=\"alert\">Block: Receiver is being received money from sender more than two.<br/>Do you want to request for approval ?</div>";
    public static final String MESSAGE_TRANSACTION_SENDER_BLOCK = "<div class=\"alert alert-warning\" role=\"alert\">This transaction have been blocked due to the sender sent cash to more than two receivers.<br/>Do you want to request for approval ?</div>";
    public static final String MESSAGE_TRANSACTION_RECIEVER_BLOCK = "<div class=\"alert alert-warning\" role=\"alert\">This transaction have been blocked due to receiver is being received from sender more than two.<br/>Do you want to request for approval ?</div>";
    public static final String REASON_TRANSACTION_SENDER_BLOCK = "Sender [[SENDER]] sends money to more than two receivers. [Teller: [TELLER]]";
    public static final String REASON_TRANSACTION_RECEIVER_BLOCK = "Sender [[SENDER]] sends to receiver [[RECEIVER]] that is being received from sender more than two. [Teller: [TELLER]]";
    public static final String REASON_TRANSACTION_BLACKlIST = "Block: The sender is in blacklist.";
    public static final String MESAGE_TRANSACTION_BLACKlIST = "<div class=\"alert alert-danger\" role=\"alert\">This transaction have been blocked due to selected sender is in the black list.</div>";
    
    /**
     * Templates
     */
    public static final String EXCEL_QUESTIONNAIRE_QUTEMPLATE = "template\\jxls\\template-export-questionnaire-excel.xls";
    
    public static final String PATH_TEMPLATE_EXCEL = ConfigFactory.load().getString("path.deployment.webapp");
    
    public static final String SECHO = "sEcho";
    public static final String ITOTALRECORDS = "iTotalRecords";
    public static final String ITOTALDISPLAYRECORDS = "iTotalDisplayRecords";
    public static final String AADATA = "aaData";
    
    public static final String BRANCH_SUFFIX = "-branch";
    public static final String ROLE_CODE_SUFFIX = "-role_code";
    public static final String USER_SUFIX = "-user";
    
    /**
     * Static string
     */
    public static final String PERCENT = "%";
    
    public static final String HYPHEN = "-";
    public static final String START_CODE = "10100";
    public static final String CURRENT_DATE_LABEL = "currentDateLabel";
    
    public static final String CURRENCY = "Currency";
    public static final String SENDER_TYPE = "senderType";
    
    public static final String RECORD_TRANSACTION = "record_transaction";
    
    public static final String MESSAGE_TRANSACTION_CANCELED = "\n It was canceled by teller.";

    public static final String[] COUNTABLE_TRANSACTION_STATUS = {
            TransactionStatus.TRANSACTION_APPROVED.getCode(),
            TransactionStatus.TRANSACTION_DONE.getCode()
    };

    public static final String GREATER_THAN = ">";
    public static final String LESS_OR_EQUAL = "<=";
}
