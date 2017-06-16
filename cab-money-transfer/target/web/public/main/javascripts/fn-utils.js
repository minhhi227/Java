// JavaScript Document
var senderId, receiverId;

function preparePopupBeforeEdit(resultValue){
	var response = resultValue.result;
	var dateTransaction = resultValue.dateTransaction;
	$('#myModalLabel').html('Edit Remittance');
	$('#btnSaveSender').html('Update');
	
	var sender = response.sender;
	$("input[name='txtFullName']").val(sender.fullName);
	$("input[name='txtAccNumber']").val(sender.accountNo);
	$("input[name='txtDOB']").val(formatDateDDMMYYYY(sender.dateOfBirth));
	$("input[name='txtPassportNo']").val(sender.identityNumber);
	$("input[name='txtExpireDate']").val(formatDateDDMMYYYY(sender.expiredDate));
	$("input[name='taAddress']").val(sender.address);
	$("input[name=hidTypeSender]").val(sender.type);
	
	var receiver = response.receiver;
	$("input[name='txtInterBank']").val(receiver.intermediaryBank);
	$("input[name='txtSwiftCode']").val(receiver.swiftCode);
	$("input[name='txtBankAddress']").val(receiver.bankAddress);
	$("input[name='txtRcAccNumber']").val(receiver.accountNo);
	$("input[name='txtRcFullName']").val(receiver.fullName);
	$("input[name='txtRcPurpose']").val(response.purpose);
	$("input[name='txtAmount']").val(response.amount);
//	var type = $("#selCurrency").attr("type").toLowerCase();
//	if(type === "text") {
//		$("#selCurrency").val(response.currency.name);
//	} else {
	$("#selCurrency").val(response.currency.id);
//	}
	
	$("input[name='txtExchangeRate']").val(response.exchangeAmount);
	$("input[name='txtUsdEquivalent']").val(response.usdEquivalent);
	$("input[name='txtFee']").val(response.fee);
	$("input[name='txtCable']").val(response.cable);
	$("input[name='txtOther']").val(response.other);
	$("input[name='txtCharge']").val(response.charge);
	$("#divCharge").text(response.charge);
	$("input[name='txtPostage']").val(response.postage);
	$("input[name='txtTotalAmount']").val(response.totalAmount);
	
	$("input[name='hidBankRef']").val(response.bankRef);
	$("input[name='hidDateTransaction']").val(dateTransaction);
	
	var txtDateTransaction = $("#txtDateTransaction");
	if(txtDateTransaction != null) {
		txtDateTransaction.val(resultValue.dateTransaction);
	}
	var txtBankRef = $("#txtBankRef");
	if(txtBankRef != null) {
		txtBankRef.val(response.bankRef);
	}
	
	$('#hidRemittanceId').val(response.id);
	$("input[name='hidSenderId']").val(sender.id);
	$("input[name='hidRecieverId']").val(receiver.id);
	senderId = sender.id;
	receiverId = receiver.id;
	
	var testType = $('input[type=hidden][name=txtFullName]');
	if(testType.length == 0) {
		$("#txtFullName").addClass('form-control');
		$("#txtRcFullName").addClass('form-control');
	} else {
		$("#txtFullName").combo('setValue', sender.fullName).combo('setText', sender.fullName);
		$("#txtRcFullName").combo('setValue', receiver.fullName).combo('setText', receiver.fullName);
	}
	
}

function clearRecieverForm() {
	$('#txtInterBank').val("");
	$('#txtSwiftCode').val("");
	$('#txtBankAddress').val("");
	$('#txtRcAccNumber').val("");
	$('#txtRcPurpose').val("");
}

function clearAndResetForm(formId) {
	clearForm(formId);
	resetFormValidator(formId);
}

function clearForm(formId) {
	$('#'+formId).find('input:text,input:hidden, input:password, textarea').val('');
	$('#'+formId).find('input:radio, input:checkbox').prop('checked', false);
	$('select option:contains("USD")').prop('selected',true);
	$('input[name="txtOther"]').val("0");
	$('#divCharge').text("SHA");
}

function resetFormValidator(formId) {
	if($('#' + formId).data('bootstrapValidator') != undefined) {
		$('#' + formId).data('bootstrapValidator').resetForm(true);
	}
}

function convertMillisToDate(millis) {
	var today = new Date(millis);
	var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 
    var today = dd+'/'+mm+'/'+yyyy;
	return today;
}

function formatDateDDMMYYYY (input) {
	 if(typeof input === "undefined") {
	  return "";
	 }
	 if(input == "" || input == null) {
	  return "";
	 }
	 var datePart = input.match(/\d+/g),
	 year = datePart[0], // get only two digits
	 month = datePart[1], day = datePart[2];
	 return day+'/'+month+'/'+year;
}

function getObjects(obj, key, val) {
    var objects = [];
    for (var i in obj) {
        if (!obj.hasOwnProperty(i)) continue;
        if (typeof obj[i] == 'object') {
            objects = objects.concat(getObjects(obj[i], key, val));
        } else if (i == key && obj[key] == val) {
            objects.push(obj);
        }
    }
    return objects;
}

function updateValueSenderPopup(data) {
	$("input[name=txtFullName]").val(data.fullName);
	$("input[name=txtAccNumber]").val(data.accountNo);
	$("input[name=txtDOB]").val(formatDateDDMMYYYY(data.dateOfBirth));
	$("input[name=txtPassportNo]").val(data.identityNumber);
	$("input[name=txtExpireDate]").val(formatDateDDMMYYYY(data.expiredDate));
	$("input[name=taAddress]").val(data.address);
	$("input[name=hidTypeSender]").val(data.type);
	document.getElementById("txtFullName").value = data.fullName; 
}

function updateValueRecieverPopup(data) {
	$("input[name=txtInterBank]").val(data.intermediaryBank);
	$("input[name=txtSwiftCode]").val(data.swiftCode);
	$("input[name=txtBankAddress]").val(data.bankAddress);
	$("input[name=txtRcAccNumber]").val(data.accountNo);
	$("input[name=txtRcFullName]").val(data.fullName);
	document.getElementById("txtRcFullName").value = data.fullName; 
}

function roundNumber(textValue, decimal) {
	return parseFloat(textValue).toFixed(decimal);
}

function updateRemittanceFormForPrint(resultValue) {
	var response = resultValue.result;
	var sender = response.sender;
	var receiver = response.receiver;
	
	var txtDateTransaction = $("#txtDateTransaction");
	if(txtDateTransaction != null) {
		txtDateTransaction.val(resultValue.dateTransaction);
	}
	var txtBankRef = $("#txtBankRef");
	if(txtBankRef != null) {
		txtBankRef.val(response.bankRef);
	}
	
	$("#dateTransaction").val(resultValue.dateTransaction);
	$("#pdateTransaction").text(resultValue.dateTransaction);
	$("#bankRef").val(response.bankRef);
	$("#pbankRef").text(response.bankRef);
	
	$("#divInFigure").text(response.totalAmount);
	$("#pdivInFigure").text(response.totalAmount);
	$("#divInWord").text(resultValue.totalInWords);
	$("#pdivInWord").text(resultValue.totalInWords);
	
	
	$("#senderfullName").text(sender.fullName);
	$("#psenderfullName").text(sender.fullName);
	
	if(typeof sender.address !== "undefined" && sender.address != null) {
		$("#senderaddress").text(sender.address);
		$("#psenderaddress").text(sender.address);
	} else {
		$("#senderaddress").text("");
		$("#psenderaddress").text("");
	}
	if(typeof sender.accountNo !== "undefined" && sender.accountNo != null) {
		$("#senderaccountNo").text(sender.accountNo);
		$("#psenderaccountNo").text(sender.accountNo);
	} else {
		$("#senderaccountNo").text("");
		$("#psenderaccountNo").text("");
	}
	
	var senderDOB = '';
	if(typeof sender.dateOfBirth !== "undefined" && sender.dateOfBirth != null) {
		senderDOB = formatDateDDMMYYYY(sender.dateOfBirth);
	}
	$("#senderdateOfBirth").text(senderDOB);
	$("#psenderdateOfBirth").text(senderDOB);	
	if(typeof sender.identityNumber !== "undefined" && sender.identityNumber != null) {
		$("#senderidentityNumber").text(sender.identityNumber);
		$("#psenderidentityNumber").text(sender.identityNumber);
	} else {
		$("#senderidentityNumber").text("");
		$("#psenderidentityNumber").text("");
	}
	
	$("#receiverintermediaryBank").text(receiver.intermediaryBank);
	$("#preceiverintermediaryBank").text(receiver.intermediaryBank);
	var rcSwitCodeAdrress = receiver.swiftCode;
	if(typeof receiver.address !== "undefined" && receiver.address != null) {
		rcSwitCodeAdrress = rcSwitCodeAdrress + "<br/>" + receiver.address
	}
	$("#receiverswiftCode").html(rcSwitCodeAdrress);
	$("#preceiverswiftCode").html(rcSwitCodeAdrress);
	$("#receiveraccountNo").text(receiver.accountNo);
	$("#preceiveraccountNo").text(receiver.accountNo);
	$("#receiverfullName").text(receiver.fullName);
	$("#preceiverfullName").text(receiver.fullName);
	$("#receiverpurpose").text(response.purpose);
	$("#preceiverpurpose").text(response.purpose);
	
	$("#amount").text(response.amount);
	$("#pamount").text(response.amount);
	$("#exchangeAmount").text(response.exchangeAmount);
	$("#pexchangeAmount").text(response.exchangeAmount);
	$("#usdEquivalent").text(response.usdEquivalent);
	$("#pusdEquivalent").text(response.usdEquivalent);
	$("#fee").text(response.fee);
	$("#pfee").text(response.fee);
	$("#cable").text(response.cable);
	$("#pcable").text(response.cable);
	$("#postage").text(response.postage);
	$("#ppostage").text(response.postage);
	$("#other").text(response.other);
	$("#pother").text(response.other);
	$("#totalUsd").text(response.totalAmount);
	$("#ptotalUsd").text(response.totalAmount);
	$("#charge").text(response.charge);
	$("#pcharge").text(response.charge);
	$("#puser").text(resultValue.user);
}

function getRuleFillAmount(senderType, vAmount) {
	var tempRule = ruleFilleAmount[senderType];
	var value;
	if(tempRule == null) {
		return null;
	}
	for(var index=0; index < tempRule.length; index ++) {
		var value = tempRule[index];
		if(vAmount > value.usdAmount && value.ruleType == ">") {
			return value;
		}
		else if(vAmount <= value.usdAmount && value.ruleType == "<=") {
			return value;
		}
	}
	return null;
}

computeUsdEquivalent=function() {
	var exchangeRate = ($("#txtExchangeRate").val() != "" && $("#txtExchangeRate").val() != 0) ? parseFloat($("#txtExchangeRate").val()) : 1;
	var txtForeignAmount = ($( "#txtAmount" ).val() != "") ? parseFloat($( "#txtAmount" ).val()) : 0;
	var UsdEquivalent = txtForeignAmount * exchangeRate;
	UsdEquivalent = roundNumber(UsdEquivalent, 2);
	// hidTypeSender
	var listTypeSender = $("input[name=hidListTypeSender]").val().split(";"); 
	var typeSender = $("input[name=hidTypeSender]").val();
	//var isContain = $.inArray(typeSender, listTypeSender);
	var vFee = 0;
	var tempRule = getRuleFillAmount(typeSender, UsdEquivalent) ;
	if(tempRule == null) {
		if(UsdEquivalent <= 15000 ) {
			$("#txtFee").val("20");
			$("#txtCable").val("");
		}
	} 
	else {
		var percentFee = parseFloat(tempRule.percentFee);
		var cable = tempRule.cable;
		vFee = parseFloat(UsdEquivalent) * (percentFee / 100);
		vFee = roundNumber(vFee, 2);
		$("#txtFee").val(vFee);
		$("#txtCable").val(cable);
		/*if(UsdEquivalent > 15000) {
			vFee = parseFloat(UsdEquivalent) * (0.13 / 100);
			vFee = roundNumber(vFee, 2);
			$("#txtFee").val(vFee);
			$("#txtCable").val("10");
		}
		else if(UsdEquivalent <= 15000 ) {
			$("#txtFee").val("20");
			$("#txtCable").val("");
		}*/
	}
	
	$("#txtUsdEquivalent").val(UsdEquivalent);
}

computeTotalAmount=function() {
	var usdAmount = ($("#txtUsdEquivalent").val() != "") ? $("#txtUsdEquivalent").val() : 0;
	var txtFee = ($("#txtFee").val() != "") ? $("#txtFee").val() : 0;
	var txtCable = ($("#txtCable").val() != "") ? $("#txtCable").val() : 0;
	var txtPostage = ($("#txtPostage").val() != "") ? $("#txtPostage").val() : 0;
	var txtOther = ($("#txtOther").val() != "") ? $("#txtOther").val() : 0;
	
	var total = parseFloat(usdAmount) + parseFloat(txtFee) + parseFloat(txtCable) + parseFloat(txtPostage)  + parseFloat(txtOther);
	total = roundNumber(total, 2);
	$("#txtTotalAmount").val(total);
}

function showModalRemittance(requestUrl, userRole){
	var testType = $('input[type=hidden][name=txtFullName]');
	if(testType.length == 0) {
		$("#txtFullName").addClass('form-control');
		$("#txtRcFullName").addClass('form-control');
	} else {
		$('#txtFullName').combogrid('grid').datagrid('loadData', {"total":0,"rows":[]});
	    $('#txtRcFullName').combogrid('grid').datagrid('loadData', {"total":0,"rows":[]});
	    $('#txtFullName').combogrid('clear');
	    $('#txtRcFullName').combogrid('clear');
	    $('#txtFullName').combo('clear');
	    $('#txtRcFullName').combo('clear');
	}
    
	$.ajax({
		url: requestUrl, //"@routes.RemittanceController.getById()" + "?transactionId=" + transactionId,
		type: "get",
		dataType: 'json',
		contentType : "application/json",
		success: function(response) {
			if(userRole != "role_teller") {
				preparePopupBeforeEdit(response); 
				$('#myModalLabel').html("Detail Remittance");
				$('button[name="btnReject"]').hide();
				$('button[name="btnApprove"]').hide();
				$('#popupAddUpdateRemittant').modal("show");
			} else {
				$('#frmRemittance').bootstrapValidator('resetForm', true);
				$('#frmRemittance')[0].reset();
				preparePopupBeforeEdit(response); 
				$("#hidProcess").val("2");
				$('button[name="btnReject"]').show();
				/*if(userRole == "role_teller"){
					$('button[name="btnReject"]').show();
				} else {
					$('button[name="btnReject"]').hide();
				}*/
				$('button[name="btnApprove"]').hide();
				updateRemittanceFormForPrint(response);
				$('#popupRemittanceApplicationForm').modal("show");
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
		    bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() {});
		}
   	});
}

function isNumber(n) {
  return !isNaN(parseFloat(n)) && isFinite(n);
}