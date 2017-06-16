
package views.html.teller

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import com.fasterxml.jackson.databind.JsonNode
/**/
object remittance extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[User,List[CurrencyExchange],String,String,List[SenderReceiverTransaction],List[SenderReceiverTransaction],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(user: User, listCurrencies: List[CurrencyExchange], strTypeSender:String, nav: String, blockedRemittanceTransactions: List[SenderReceiverTransaction], rejectedAndApprovedTxs: List[SenderReceiverTransaction], continuingTransactionId: String, notificationInterval: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.273*/("""

"""),_display_(/*5.2*/main("REMITTANCE", user, nav, blockedRemittanceTransactions, rejectedAndApprovedTxs, notificationInterval, listCurrencies)/*5.124*/ {_display_(Seq[Any](format.raw/*5.126*/("""
	"""),format.raw/*6.2*/("""<!-- JS dataTables -->
	<script type="text/javascript" language="javascript" src=""""),_display_(/*7.61*/routes/*7.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.js")),format.raw/*7.125*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*8.61*/routes/*8.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.dataTables.min.js")),format.raw/*8.140*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*9.61*/routes/*9.67*/.Assets.at("plugins/datatables-1.10.2/fnReloadAjax.js")),format.raw/*9.122*/(""""></script>
	<!-- JS Bootstrap -->
	<script type="text/javascript" src=""""),_display_(/*11.39*/routes/*11.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*11.88*/("""" defer></script>
	<script type="text/javascript" src=""""),_display_(/*12.39*/routes/*12.45*/.Assets.at("plugins/jquery.numeric.min.js")),format.raw/*12.88*/(""""></script>
	<script type="text/javascript" src=""""),_display_(/*13.39*/routes/*13.45*/.Assets.at("plugins/bootbox.min.js")),format.raw/*13.81*/(""""></script>
	<!-- JS Print -->
	<script type="text/javascript" src=""""),_display_(/*15.39*/routes/*15.45*/.Assets.at("plugins/jquery.print.js")),format.raw/*15.82*/(""""></script>
	"""),_display_(/*16.3*/if(user.getRole().getCode()=="role_teller")/*16.46*/{_display_(Seq[Any](format.raw/*16.47*/("""
		"""),format.raw/*17.3*/("""<!-- easyUi -->
		<script type="text/javascript" src=""""),_display_(/*18.40*/routes/*18.46*/.Assets.at("plugins/easyui/jquery.easyui.min.js")),format.raw/*18.95*/(""""></script>
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*19.64*/routes/*19.70*/.Assets.at("plugins/easyui/themes/bootstrap/easyui.css")),format.raw/*19.126*/(""""/>
		<!-- end easyUi -->
	""")))}),format.raw/*21.3*/("""
	"""),format.raw/*22.2*/("""<div class="content-wrapper">
		<div>
			<a data-toggle="modal" class="btn btn-primary pull-right" id="btnAdvanceSearchRemittance">Advanced Search</a>
		</div>
		<!-- start form add / update remittance -->
		<form id="frmRemittance" class="form-horizontal" role="form" style="margin-top:10px;">
<!--			<div>-->
<!--				<div class="row">-->
<!--					<div class="col-md-4">-->
<!--						<h4 class="modal-title" id="myModalLabel"></h4>-->
<!--					</div>-->
<!--					<div class="col-md-4">-->
<!--						<label for="txtDateTransaction">Date</label>-->
<!--						<input type="text" style="height:25px;width:210px;" class="form-control" id="txtDateTransaction" name="txtDateTransaction" placeholder="Date" value="">-->
<!--					</div>-->
<!--					<div class="col-md-4">-->
<!--						<label for="txtBankRef">Bank's Reference No.</label>-->
<!--						<input type="text" style="height:25px;width:210px;" class="form-control" id="txtBankRef" name="txtBankRef" placeholder="Bank's Reference No" value="">-->
<!--					 </div>-->
<!--				</div>-->
<!--			</div>-->
			<div>
				<div id="remittance-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
				<div id="remittance-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Receiver exists</div>
				<div id="remittance-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Error occurred!</div>
				<h4>APPLICANT'S DETAILS</h4><hr/>
				<div>
					<div class="form-group row">
						<label for="txtFullName" class="col-sm-2 control-label">Full name</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtFullName" name="txtFullName">
						</div>
					</div>
					<div class="form-group">
						<label for="txtAccNumber" class="col-sm-2 control-label">A/C number</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtAccNumber" name="txtAccNumber" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label for="txtDOB" class="col-sm-2 control-label">Date of birth</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtDOB" name="txtDOB" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label for="txtPassportNo" class="col-sm-2 control-label">ID/Passport No</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtPassportNo" name="txtPassportNo" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label for="txtExpireDate" class="col-sm-2 control-label">Expire date</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtExpireDate" name="txtExpireDate" disabled="disabled">
							<input type="hidden" id="hidTypeSender" name="hidTypeSender" value=""/>
						</div>
					</div>
					<div class="form-group">
						<label for="taAddress" class="col-sm-2 control-label">Address</label>
						<div class="col-sm-8">
							<input type="text" class="form-control col-sm-2" id="taAddress" name="taAddress" value="" disabled="disabled"/>
						</div>
					</div>
				</div>
				<h4>BENEFICIARY'S DETAILS</h4><hr/>
				<div>
					<div class="form-group">
						<label for="txtInterBank" class="col-sm-2 control-label">Inter Bank</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtInterBank" name="txtInterBank">
						</div>
					</div>
					<div class="form-group">
						<label for="txtSwiftCode" class="col-sm-2 control-label">Swift Code</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtSwiftCode" name="txtSwiftCode">
						</div>
					</div>
					<div class="form-group">
						<label for="txtBankAddress" class="col-sm-2 control-label">Bank's Address</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtBankAddress" name="txtBankAddress">
						</div>
					</div>
					<div class="form-group">
						<label for="txtRcAccNumber" class="col-sm-2 control-label">A/C Number</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtRcAccNumber" name="txtRcAccNumber">
						</div>
					</div>
					<div class="form-group">
						<label for="txtRcFullName" class="col-sm-2 control-label">Full Name</label>
						<div class="col-sm-6">
							<input type="text" class="form-control col-sm-2" id="txtRcFullName" name="txtRcFullName">
						</div>
					</div>
					<div class="form-group">
						<label for="txtRcPurpose" class="col-sm-2 control-label">Purpose</label>
						<div class="col-sm-8">
							<input type="text" class="form-control col-sm-2" id="txtRcPurpose" name="txtRcPurpose">
						</div>
					</div>
				</div>					
<!--					<h3>Mode of Payment</h3><hr/>-->
<!--					<div> -->
<!--						<div class="radio"> -->
<!--							<label> <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Cash</label> -->
<!--						</div> -->
<!--						<div class="radio"> -->
<!--							<label> <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Cheque No......</label> -->
<!--						</div> -->
<!--						<div class="radio"> -->
<!--							<label> <input type="radio" name="optionsRadios" id="optionsRadios2" value="option3">I/We authorize the bank to debit my/our account no: ...................</label> -->
<!--						</div> -->
<!--					</div>-->
					<h4>FILL AMOUNT</h4><hr/>
				<div>
					<div class="row">
						<div class="col-xs-6 col-sm-3 form-group" style="padding-left: 34px;">
							<b>Foreign Amount</b>
							<input type="text" class="form-control col-sm-2" id="txtAmount" name="txtAmount">
						</div>
						<div class="col-xs-6 col-sm-3">
							<b>Currency</b>
						  	<select class="form-control" name="selCurrency" id="selCurrency">
						  	"""),_display_(/*148.11*/for(currency <- listCurrencies) yield /*148.42*/{_display_(Seq[Any](format.raw/*148.43*/("""
						  		"""),format.raw/*149.11*/("""<option value=""""),_display_(/*149.27*/currency/*149.35*/.getId()),format.raw/*149.43*/("""">"""),_display_(/*149.46*/currency/*149.54*/.getName()),format.raw/*149.64*/("""</option>
						  	""")))}),format.raw/*150.11*/("""
							"""),format.raw/*151.8*/("""</select>
						</div>
						<div class="col-xs-6 col-sm-3">
							<b>Exchange rate</b>
							<input type="text" class="form-control col-sm-2" id="txtExchangeRate" name="txtExchangeRate">
						</div>
						<div class="col-xs-6 col-sm-3" style="padding-right: 23px;">
							<b>USD Equivalent</b>
							<div class="form-group">
								<input type="text" class="form-control col-sm-2" id="txtUsdEquivalent" name="txtUsdEquivalent" disabled="disabled">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-3 form-group" style="padding-left: 34px;">
							<b>Fee</b>
							<input type="text" class="form-control col-sm-2" id="txtFee" name="txtFee">
						</div>
						<div class="col-xs-6 col-sm-3">
							<b>Cable</b>
							<input type="text" class="form-control col-sm-2" id="txtCable" name="txtCable">
						</div>
						<div class="col-xs-6 col-sm-3">
							<b>Postage</b>
							<input type="text" class="form-control col-sm-2" id="txtPostage" name="txtPostage">
						</div>
						<div class="col-xs-6 col-sm-2">
							<b>Other</b>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control col-sm-2" id="txtOther" name="txtOther" value="0">
									<div class="input-group-addon" id="divCharge"></div>
									<input type="hidden" class="form-control col-sm-2" id="txtCharge" name="txtCharge" placeholder="" value="SHA">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							&nbsp;
						</div>
						<div class="col-xs-6 col-sm-3">
							&nbsp;
						</div>
						<div class="col-xs-6 col-sm-2">
							&nbsp;
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="form-group">
								<label for="txtTotalAmount" class="col-sm-4 control-label">Total USD</label>
								<div class="col-sm-8">
									<input type="text" class="form-control col-sm-2" id="txtTotalAmount" name="txtTotalAmount" disabled="disabled">
								</div>
							</div>
						</div>						
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Preview</button>
				<input type="hidden" name="hidSenderId"/>
				<input type="hidden" name="hidRemittanceId" id="hidRemittanceId"/>
				<input type="hidden" name="hidRecieverId"/>
				<input type="hidden" name="hidProcess" id="hidProcess"/>
				<input type="hidden" name="hidRcFullName" id="hidRcFullName"/>
				<input type="hidden" name="hidDateTransaction" id="hidDateTransaction"/>
				<input type="hidden" name="hidBankRef" id="hidBankRef"/>
			</div>
		</form>		

	</div>
		
    <!-- modal remittance advanced search -->
	<div id="modalAdvancedSearch" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalAdvancedSearch" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog" style="width:80%;">
			<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h4 class="modal-title" id="popupAddEditReceiverTitle">Advanced Search</h4>
					</div>
					<form role="form" id="frmAdvancedSearch" name="frmAdvancedSearch" data-toggle="validator">
						<div class="modal-body" style="width:500px;margin:auto;">
							<div class="row">
								<div class="col-md-6 form-group">
									<label class="control-label">From</label>
									<div class="input-group">
									<input type="text" name="searchFromDate" id="advFromDate" class="form-control" placeholder="dd/mm/yyyy"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
									</div>
								</div>
								<div class="col-md-6 form-group">
									<label class="control-label">To</label>
									<div class="input-group">
									<input type="text" name="searchToDate" id="advToDate" class="form-control" placeholder="dd/mm/yyyy"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Sender Name</label>
									<input type="text" name="advSenderFullName" class="form-control" placeholder="any..."/>
								</div>
								<div class="col-md-6">
									<label>Sender Account No.</label>
									<input type="text" name="advSenderAccountNo" class="form-control" placeholder="any..."/>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Sender ID/Passport No.</label>
									<input type="text" name="advSenderIdentityNo" class="form-control" placeholder="any..."/>
								</div>					
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Intermediary Bank</label>
									<input type="text" name="advIntermediaryBank" class="form-control" placeholder="any..."/>
								</div>
								<div class="col-md-6">
									<label>Swift Code</label>
									<input type="text" name="advSwiftCode" class="form-control" placeholder="any..."/>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Receiver Account No.</label>
									<input type="text" name="advReceiverAccountNo" class="form-control" placeholder="any..."/>
								</div>
								<div class="col-md-6">
									<label>Receiver Name</label>
									<input type="text" name="advReceiverFullName" class="form-control" placeholder="any..."/>
								</div>
							</div>												
						</div>
						<div class="modal-footer">
							<button id="btnAdvancedSearchRemittance" type="submit" class="btn btn-primary">Search</button>
<!-- 							<button id="btnCancelAdvanceSearch" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button> -->
							<a id="btnClearSearch" href="#" class="btn btn-primary">Clear Search</a>
						</div>
					</form>
					<div class="row" style="padding:0;margin:0;">
						<input type="hidden" name="hidListTypeSender" value=""""),_display_(/*293.61*/strTypeSender),format.raw/*293.74*/(""""/>
				        <div class="col-md-12">
				          	<table id="tbRemittance" class="display cell-border compact" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>N&deg;</th>
										<th width="25px">ID</th>
										<th width="200px">Sender</th>
										<th width="190px">Receiver</th>
										<th width="70px">Sent Date</th>
										<th width="100px">Bank/Swift Code</th>
										<th width="70px">Amount</th>
										<th width="60px">Currency</th>
										<th width="60px">Exc. Rate</th>
										<th width="70px">USD Equi.</th>
										<th width="50px">Fee</th>
										<th width="50px">Cable</th>	
									</tr>
								</thead>
								<tfoot></tfoot>
								<tbody></tbody>
							</table>
				        </div>
			        </div>
			</div>			
		</div>
	</div>
	<!-- end pop up sender advanced search view -->
	
	<script type="text/javascript" language="javascript">
		var colNo = 0;
		var colId = 1;
		var colSender = 2;
		var colReceiver = 3;
		var colSentDate = 4;
		var colSwiftCode = 5;
		var colAmount = 6;
		var colCurrency = 7;
		var colExchangeRate = 8;
		var colUSDEqivalent = 9;
		var colFee = 10;
		var colCable = 11;
		
		var oTable;
		var ruleFilleAmount = """),format.raw/*337.25*/("""{"""),format.raw/*337.26*/("""}"""),format.raw/*337.27*/(""";
		
		function OnloadRuleFillAmountFunction ()"""),format.raw/*339.43*/("""{"""),format.raw/*339.44*/("""
			"""),format.raw/*340.4*/("""$.ajax("""),format.raw/*340.11*/("""{"""),format.raw/*340.12*/("""
				"""),format.raw/*341.5*/("""url: """"),_display_(/*341.12*/routes/*341.18*/.RemittanceController.getRuleFillAmount()),format.raw/*341.59*/("""",
				type: "get",
				dataType: 'json',
	   			contentType : "application/json",
				success: function(response) """),format.raw/*345.33*/("""{"""),format.raw/*345.34*/("""
					"""),format.raw/*346.6*/("""ruleFilleAmount = response;
				"""),format.raw/*347.5*/("""}"""),format.raw/*347.6*/(""",
				error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*348.52*/("""{"""),format.raw/*348.53*/("""
					"""),format.raw/*349.6*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*349.92*/("""{"""),format.raw/*349.93*/("""}"""),format.raw/*349.94*/(""");
				"""),format.raw/*350.5*/("""}"""),format.raw/*350.6*/("""
			"""),format.raw/*351.4*/("""}"""),format.raw/*351.5*/(""");
		"""),format.raw/*352.3*/("""}"""),format.raw/*352.4*/("""

		"""),format.raw/*354.3*/("""$(document).ready(function() """),format.raw/*354.32*/("""{"""),format.raw/*354.33*/("""
			"""),format.raw/*355.4*/("""OnloadRuleFillAmountFunction();
			
			/* date picker start date */
			var dpsearchFromDate = new dhtmlXCalendarObject(["advFromDate"]);
			dpsearchFromDate.setDateFormat("%d/%m/%Y");
			$("input[name=searchFromDate]").val(dpsearchFromDate.getFormatedDate("%d/%m/%Y", new Date()));
			
			/* date picker end date */
			var dpsearchToDate = new dhtmlXCalendarObject(["advToDate"]);
			dpsearchToDate.setDateFormat("%d/%m/%Y");
			$("input[name=searchToDate]").val(dpsearchToDate.getFormatedDate("%d/%m/%Y", new Date()));

			/* date picker end date */
			var dpExpireDate = new dhtmlXCalendarObject(["txtExpireDate"]);
			dpExpireDate.setDateFormat("%d/%m/%Y");
			
			var dpDOB = new dhtmlXCalendarObject(["txtDOB"]);
			dpDOB.setDateFormat("%d/%m/%Y");
			
			$('[name="txtAmount"]').numeric();
			$('[name="txtExchangeRate"]').numeric();
			$('[name="txtFee"]').numeric();
			$('[name="txtCable"]').numeric();
			$('[name="txtPostage"]').numeric();
			$('[name="txtOther"]').numeric();
			
			$('input[name="txtOther"]').val("0");
			$('#divCharge').text("SHA");
			
			 oTable = $('#tbRemittance').dataTable( """),format.raw/*384.44*/("""{"""),format.raw/*384.45*/("""
			    """),format.raw/*385.8*/(""""oLanguage": """),format.raw/*385.21*/("""{"""),format.raw/*385.22*/("""
				    """),format.raw/*386.9*/(""""sSearch": " "
				"""),format.raw/*387.5*/("""}"""),format.raw/*387.6*/(""",
				"columnDefs": [ 
					"""),format.raw/*389.6*/("""{"""),format.raw/*389.7*/(""""targets":[colNo], "sortable":false, "searchable":false"""),format.raw/*389.62*/("""}"""),format.raw/*389.63*/(""",
					"""),format.raw/*390.6*/("""{"""),format.raw/*390.7*/(""""targets":[colId], "visible":false, "searchable":false"""),format.raw/*390.61*/("""}"""),format.raw/*390.62*/("""
				"""),format.raw/*391.5*/("""],
				"bProcessing": true,
				"bServerSide": true,	  
				"sAjaxSource": """"),_display_(/*394.22*/routes/*394.28*/.RemittanceController.getRemittanceList()),format.raw/*394.69*/("""",
				"bAutoWidth": false,
				"dom": 'flt<"advanceSearch">ip',
				"bPaginate": true,
				"bFilter": true,
				"bInfo": true,
				"bLengthChange": true,
				"deferLoading": 0,
		        scrollCollapse: true,
				"fnServerParams": function ( aoData ) """),format.raw/*403.43*/("""{"""),format.raw/*403.44*/("""
					"""),format.raw/*404.6*/("""var searchContainer = $("#frmAdvancedSearch");
					searchContainer.find('input[type="text"][value!=""],input[type="radio"]:checked,input[type="checkbox"]:checked,textarea[value!=""],select[value!=""]').each(function () """),format.raw/*405.174*/("""{"""),format.raw/*405.175*/("""
		                """),format.raw/*406.19*/("""// all textboxes, radio buttons, checkboxes, textareas, and selects that actually have a value associated with them
		                var element = $(this), value = element.val();
		                if (typeof value === "string") """),format.raw/*408.50*/("""{"""),format.raw/*408.51*/("""
		                	"""),format.raw/*409.20*/("""aoData.push("""),format.raw/*409.32*/("""{"""),format.raw/*409.33*/(""" """),format.raw/*409.34*/(""""name": element.attr("name"), "value": value """),format.raw/*409.79*/("""}"""),format.raw/*409.80*/(""");
		                """),format.raw/*410.19*/("""}"""),format.raw/*410.20*/("""
		                """),format.raw/*411.19*/("""else if (Object.prototype.toString.apply(value) === '[object Array]') """),format.raw/*411.89*/("""{"""),format.raw/*411.90*/("""
		                    """),format.raw/*412.23*/("""// multi select since it has an array of selected values
		                    var i;
		                    for (i = 0; i < value.length; i++) """),format.raw/*414.58*/("""{"""),format.raw/*414.59*/("""
		                    	"""),format.raw/*415.24*/("""aoData.push("""),format.raw/*415.36*/("""{"""),format.raw/*415.37*/(""" """),format.raw/*415.38*/(""""name": element.attr("name"), "value": value[i] """),format.raw/*415.86*/("""}"""),format.raw/*415.87*/(""");
		                    """),format.raw/*416.23*/("""}"""),format.raw/*416.24*/("""
		                """),format.raw/*417.19*/("""}"""),format.raw/*417.20*/("""
		            """),format.raw/*418.15*/("""}"""),format.raw/*418.16*/(""");
			    """),format.raw/*419.8*/("""}"""),format.raw/*419.9*/(""",
			    fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*420.81*/("""{"""),format.raw/*420.82*/("""
					"""),format.raw/*421.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*421.46*/("""{"""),format.raw/*421.47*/(""" 
						"""),format.raw/*422.7*/("""var requestUrl = '"""),_display_(/*422.26*/routes/*422.32*/.RemittanceController.getById()),format.raw/*422.63*/("""' + "?transactionId=" + aData[colId];
						showModalRemittance(requestUrl, """"),_display_(/*423.41*/user/*423.45*/.getRole().getCode()),format.raw/*423.65*/("""");
					"""),format.raw/*424.6*/("""}"""),format.raw/*424.7*/(""");
				"""),format.raw/*425.5*/("""}"""),format.raw/*425.6*/("""
			"""),format.raw/*426.4*/("""}"""),format.raw/*426.5*/(""" """),format.raw/*426.6*/(""");

			"""),_display_(/*428.5*/if(continuingTransactionId != null)/*428.40*/{_display_(Seq[Any](format.raw/*428.41*/("""
				"""),format.raw/*429.5*/("""var requestUrl = '"""),_display_(/*429.24*/routes/*429.30*/.RemittanceController.getById()),format.raw/*429.61*/("""' + "?transactionId="""),_display_(/*429.82*/continuingTransactionId),format.raw/*429.105*/("""";
				showModalRemittance(requestUrl, """"),_display_(/*430.39*/user/*430.43*/.getRole().getCode()),format.raw/*430.63*/("""");
			""")))}),format.raw/*431.5*/("""

			"""),format.raw/*433.4*/("""//$('div.dataTables_filter label').append('&nbsp;<a id="btnClearSearch" href="#" class="btn btn-primary">Clear Search</a>');

			/* Validate form advanced search remittance and submit */
			dpsearchFromDate.attachEvent("onClick", function(date)"""),format.raw/*436.58*/("""{"""),format.raw/*436.59*/("""
				"""),format.raw/*437.5*/("""$('#frmAdvancedSearch').bootstrapValidator('revalidateField', 'searchFromDate');
			"""),format.raw/*438.4*/("""}"""),format.raw/*438.5*/(""");
			dpsearchToDate.attachEvent("onClick", function(date)"""),format.raw/*439.56*/("""{"""),format.raw/*439.57*/("""
				"""),format.raw/*440.5*/("""$('#frmAdvancedSearch').bootstrapValidator('revalidateField', 'searchToDate');
			"""),format.raw/*441.4*/("""}"""),format.raw/*441.5*/(""");	
		    $('#frmAdvancedSearch').bootstrapValidator("""),format.raw/*442.50*/("""{"""),format.raw/*442.51*/("""
		    	"""),format.raw/*443.8*/("""container: 'tooltip',
		    	excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		        feedbackIcons: """),format.raw/*446.26*/("""{"""),format.raw/*446.27*/("""
		            """),format.raw/*447.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon'
		        """),format.raw/*450.11*/("""}"""),format.raw/*450.12*/(""",
		        fields:"""),format.raw/*451.18*/("""{"""),format.raw/*451.19*/("""
		        	"""),format.raw/*452.12*/("""searchFromDate:"""),format.raw/*452.27*/("""{"""),format.raw/*452.28*/("""
						"""),format.raw/*453.7*/("""validators:"""),format.raw/*453.18*/("""{"""),format.raw/*453.19*/("""
							"""),format.raw/*454.8*/("""date: """),format.raw/*454.14*/("""{"""),format.raw/*454.15*/("""
								"""),format.raw/*455.9*/("""format: 'DD/MM/YYYY',
								message: 'Invalid date'
							"""),format.raw/*457.8*/("""}"""),format.raw/*457.9*/("""
						"""),format.raw/*458.7*/("""}"""),format.raw/*458.8*/("""
					"""),format.raw/*459.6*/("""}"""),format.raw/*459.7*/(""",
					searchToDate:"""),format.raw/*460.19*/("""{"""),format.raw/*460.20*/("""
						"""),format.raw/*461.7*/("""validators:"""),format.raw/*461.18*/("""{"""),format.raw/*461.19*/("""
							"""),format.raw/*462.8*/("""date: """),format.raw/*462.14*/("""{"""),format.raw/*462.15*/("""
								"""),format.raw/*463.9*/("""format: 'DD/MM/YYYY',
								message: 'Invalid date'
							"""),format.raw/*465.8*/("""}"""),format.raw/*465.9*/("""
						"""),format.raw/*466.7*/("""}"""),format.raw/*466.8*/("""
					"""),format.raw/*467.6*/("""}"""),format.raw/*467.7*/("""					
			    """),format.raw/*468.8*/("""}"""),format.raw/*468.9*/("""
		    """),format.raw/*469.7*/("""}"""),format.raw/*469.8*/(""")	        
			.on('success.form.bv', function(e) """),format.raw/*470.39*/("""{"""),format.raw/*470.40*/("""
				"""),format.raw/*471.5*/("""e.preventDefault();
				oTable.fnReloadAjax();			
			"""),format.raw/*473.4*/("""}"""),format.raw/*473.5*/(""");	    
	        
	        $searchContainerInputs = $('#frmAdvancedSearch').find('input[type="text"],input[type="radio"],input[type="checkbox"],select,textarea');
	        
	        $('#btnAdvanceSearchRemittance').click(function()"""),format.raw/*477.59*/("""{"""),format.raw/*477.60*/("""
				"""),format.raw/*478.5*/("""$('#frmAdvancedSearch').data('bootstrapValidator').resetForm();
				$('#modalAdvancedSearch').modal("show");
			"""),format.raw/*480.4*/("""}"""),format.raw/*480.5*/(""");
	        
	        $("#btnClearSearch").click(function () """),format.raw/*482.49*/("""{"""),format.raw/*482.50*/("""
	        	"""),format.raw/*483.11*/("""$searchContainerInputs.each(function () """),format.raw/*483.51*/("""{"""),format.raw/*483.52*/("""
	                """),format.raw/*484.18*/("""var $input = $(this),
	                tagName = this.tagName.toLowerCase();
	                if (tagName === "input") """),format.raw/*486.43*/("""{"""),format.raw/*486.44*/("""
	                    """),format.raw/*487.22*/("""var type = $input.attr("type").toLowerCase();
	                    if (type === "checkbox"
	                    || type === "radio") """),format.raw/*489.43*/("""{"""),format.raw/*489.44*/("""
	                        """),format.raw/*490.26*/("""$input.removeAttr("checked");
	                    """),format.raw/*491.22*/("""}"""),format.raw/*491.23*/("""
	                    """),format.raw/*492.22*/("""else if (type === "text") """),format.raw/*492.48*/("""{"""),format.raw/*492.49*/("""
	                        """),format.raw/*493.26*/("""$input.val("");
	                    """),format.raw/*494.22*/("""}"""),format.raw/*494.23*/("""
	                """),format.raw/*495.18*/("""}"""),format.raw/*495.19*/("""
	                """),format.raw/*496.18*/("""else if (tagName === "select") """),format.raw/*496.49*/("""{"""),format.raw/*496.50*/("""
	                    """),format.raw/*497.22*/("""if ($input.attr("multiple") !== undefined) """),format.raw/*497.65*/("""{"""),format.raw/*497.66*/("""
	                        """),format.raw/*498.26*/("""$input.val([]);
	                    """),format.raw/*499.22*/("""}"""),format.raw/*499.23*/("""
	                    """),format.raw/*500.22*/("""else """),format.raw/*500.27*/("""{"""),format.raw/*500.28*/("""
	                        """),format.raw/*501.26*/("""$input.val("");
	                    """),format.raw/*502.22*/("""}"""),format.raw/*502.23*/("""
	                """),format.raw/*503.18*/("""}"""),format.raw/*503.19*/("""
	                """),format.raw/*504.18*/("""else if (tagName === "textarea") """),format.raw/*504.51*/("""{"""),format.raw/*504.52*/("""
	                    """),format.raw/*505.22*/("""$input.val("");
	                """),format.raw/*506.18*/("""}"""),format.raw/*506.19*/("""
	            """),format.raw/*507.14*/("""}"""),format.raw/*507.15*/(""");
	        	$("input[name=searchFromDate]").val(dpsearchFromDate.getFormatedDate("%d/%m/%Y", new Date()));
				$("input[name=searchToDate]").val(dpsearchToDate.getFormatedDate("%d/%m/%Y", new Date()));
	            oTable.fnReloadAjax();
	        """),format.raw/*511.10*/("""}"""),format.raw/*511.11*/(""");
			
			if(document.getElementById("tbRemittance_filter") != null) """),format.raw/*513.63*/("""{"""),format.raw/*513.64*/("""
				"""),format.raw/*514.5*/("""var searchFilter = $('#tbRemittance_filter').find('input[type="search"]');
				searchFilter.each(function () """),format.raw/*515.35*/("""{"""),format.raw/*515.36*/("""
					"""),format.raw/*516.6*/("""var $input = $(this);
					$input.hide();
				"""),format.raw/*518.5*/("""}"""),format.raw/*518.6*/(""");
			"""),format.raw/*519.4*/("""}"""),format.raw/*519.5*/("""
			
			"""),format.raw/*521.4*/("""enableDisableControlById=function(objectId) """),format.raw/*521.48*/("""{"""),format.raw/*521.49*/("""
				"""),format.raw/*522.5*/("""var recieverArea = $('#' + objectId).find('input[type="text"]');
				recieverArea.each(function () """),format.raw/*523.35*/("""{"""),format.raw/*523.36*/("""
					"""),format.raw/*524.6*/("""var $input = $(this),
					tagName = this.tagName.toLowerCase();
					if (tagName === "input") """),format.raw/*526.31*/("""{"""),format.raw/*526.32*/("""
						"""),format.raw/*527.7*/("""var type = $input.attr("type").toLowerCase();
						if (type === "text") """),format.raw/*528.28*/("""{"""),format.raw/*528.29*/("""
							"""),format.raw/*529.8*/("""$input.removeAttr('disabled');
						"""),format.raw/*530.7*/("""}"""),format.raw/*530.8*/("""
					"""),format.raw/*531.6*/("""}"""),format.raw/*531.7*/("""
				"""),format.raw/*532.5*/("""}"""),format.raw/*532.6*/(""");
			"""),format.raw/*533.4*/("""}"""),format.raw/*533.5*/("""
			
			"""),format.raw/*535.4*/("""$popupAddRemittantContainerInputs = $('#popupAddUpdateRemittant').find('input[type="text"],input[type="hidden"],input[type="radio"],input[type="checkbox"],select,textarea');
			
			// Reset the Tooltip container form
		    $('#resetButton').on('click', function(e) """),format.raw/*538.49*/("""{"""),format.raw/*538.50*/("""
		    	"""),format.raw/*539.8*/("""clearAndResetForm("frmRemittance");
		    """),format.raw/*540.7*/("""}"""),format.raw/*540.8*/(""");
			
			$('#resetOnClose').on('click', function(e) """),format.raw/*542.47*/("""{"""),format.raw/*542.48*/("""
				"""),format.raw/*543.5*/("""clearAndResetForm("frmRemittance");
		    """),format.raw/*544.7*/("""}"""),format.raw/*544.8*/(""");
			$('.textbox-text.validatebox-text').on('input',function()"""),format.raw/*545.61*/("""{"""),format.raw/*545.62*/("""
				"""),format.raw/*546.5*/("""//$('#frmRemittance').bootstrapValidator('revalidateField', 'txtAccNumber');
				$('#frmRemittance').bootstrapValidator('revalidateField', 'txtInterBank');
				$('#frmRemittance').bootstrapValidator('revalidateField', 'txtSwiftCode');
				$('#frmRemittance').bootstrapValidator('revalidateField', 'txtRcAccNumber');
				$('#frmRemittance').bootstrapValidator('revalidateField', 'txtAmount');
				$('#frmRemittance').bootstrapValidator('revalidateField', 'txtFee');
			"""),format.raw/*552.4*/("""}"""),format.raw/*552.5*/(""");		
			$('#frmRemittance').bootstrapValidator("""),format.raw/*553.43*/("""{"""),format.raw/*553.44*/("""
				"""),format.raw/*554.5*/("""container: 'tooltip',
		        message: 'This value is not valid',
		        feedbackIcons: """),format.raw/*556.26*/("""{"""),format.raw/*556.27*/("""
		            """),format.raw/*557.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon'
		        """),format.raw/*560.11*/("""}"""),format.raw/*560.12*/(""",
		        fields: """),format.raw/*561.19*/("""{"""),format.raw/*561.20*/("""
		        	"""),format.raw/*562.12*/("""'txtFullName': """),format.raw/*562.27*/("""{"""),format.raw/*562.28*/("""
		                """),format.raw/*563.19*/("""validators: """),format.raw/*563.31*/("""{"""),format.raw/*563.32*/("""
		                	"""),format.raw/*564.20*/("""notEmpty: """),format.raw/*564.30*/("""{"""),format.raw/*564.31*/(""" """),format.raw/*564.32*/("""message: 'Required' """),format.raw/*564.52*/("""}"""),format.raw/*564.53*/("""
		                """),format.raw/*565.19*/("""}"""),format.raw/*565.20*/("""
		            """),format.raw/*566.15*/("""}"""),format.raw/*566.16*/(""",
			       /*  'txtAccNumber': """),format.raw/*567.31*/("""{"""),format.raw/*567.32*/("""
			            """),format.raw/*568.16*/("""validators: """),format.raw/*568.28*/("""{"""),format.raw/*568.29*/("""
			            	"""),format.raw/*569.17*/("""notEmpty: """),format.raw/*569.27*/("""{"""),format.raw/*569.28*/(""" """),format.raw/*569.29*/("""message: 'Required' """),format.raw/*569.49*/("""}"""),format.raw/*569.50*/("""
			            """),format.raw/*570.16*/("""}"""),format.raw/*570.17*/("""
			        """),format.raw/*571.12*/("""}"""),format.raw/*571.13*/(""", */
					'txtInterBank': """),format.raw/*572.22*/("""{"""),format.raw/*572.23*/("""
		                """),format.raw/*573.19*/("""validators: """),format.raw/*573.31*/("""{"""),format.raw/*573.32*/("""
		                	"""),format.raw/*574.20*/("""notEmpty: """),format.raw/*574.30*/("""{"""),format.raw/*574.31*/(""" """),format.raw/*574.32*/("""message: 'Required' """),format.raw/*574.52*/("""}"""),format.raw/*574.53*/("""
		                """),format.raw/*575.19*/("""}"""),format.raw/*575.20*/("""
		            """),format.raw/*576.15*/("""}"""),format.raw/*576.16*/(""",
					'txtSwiftCode': """),format.raw/*577.22*/("""{"""),format.raw/*577.23*/("""
		                """),format.raw/*578.19*/("""validators: """),format.raw/*578.31*/("""{"""),format.raw/*578.32*/("""
		                	"""),format.raw/*579.20*/("""notEmpty: """),format.raw/*579.30*/("""{"""),format.raw/*579.31*/(""" """),format.raw/*579.32*/("""message: 'Required' """),format.raw/*579.52*/("""}"""),format.raw/*579.53*/("""
		                """),format.raw/*580.19*/("""}"""),format.raw/*580.20*/("""
		            """),format.raw/*581.15*/("""}"""),format.raw/*581.16*/(""",
		            'txtRcAccNumber': """),format.raw/*582.33*/("""{"""),format.raw/*582.34*/("""
		                """),format.raw/*583.19*/("""validators: """),format.raw/*583.31*/("""{"""),format.raw/*583.32*/("""
		                	"""),format.raw/*584.20*/("""notEmpty: """),format.raw/*584.30*/("""{"""),format.raw/*584.31*/(""" """),format.raw/*584.32*/("""message: 'Required' """),format.raw/*584.52*/("""}"""),format.raw/*584.53*/("""
		                """),format.raw/*585.19*/("""}"""),format.raw/*585.20*/("""
		            """),format.raw/*586.15*/("""}"""),format.raw/*586.16*/(""",
					'txtRcFullName': """),format.raw/*587.23*/("""{"""),format.raw/*587.24*/("""
		                """),format.raw/*588.19*/("""validators: """),format.raw/*588.31*/("""{"""),format.raw/*588.32*/("""
		                	"""),format.raw/*589.20*/("""notEmpty: """),format.raw/*589.30*/("""{"""),format.raw/*589.31*/(""" """),format.raw/*589.32*/("""message: 'Required' """),format.raw/*589.52*/("""}"""),format.raw/*589.53*/("""
		                """),format.raw/*590.19*/("""}"""),format.raw/*590.20*/("""
		            """),format.raw/*591.15*/("""}"""),format.raw/*591.16*/(""",
			        'txtAmount': """),format.raw/*592.25*/("""{"""),format.raw/*592.26*/("""
		                """),format.raw/*593.19*/("""validators: """),format.raw/*593.31*/("""{"""),format.raw/*593.32*/("""
		                	"""),format.raw/*594.20*/("""notEmpty: """),format.raw/*594.30*/("""{"""),format.raw/*594.31*/(""" """),format.raw/*594.32*/("""message: 'Required' """),format.raw/*594.52*/("""}"""),format.raw/*594.53*/("""
		                """),format.raw/*595.19*/("""}"""),format.raw/*595.20*/("""
		            """),format.raw/*596.15*/("""}"""),format.raw/*596.16*/(""",
		            'txtFee': """),format.raw/*597.25*/("""{"""),format.raw/*597.26*/("""
		                """),format.raw/*598.19*/("""validators: """),format.raw/*598.31*/("""{"""),format.raw/*598.32*/("""
		                	"""),format.raw/*599.20*/("""notEmpty: """),format.raw/*599.30*/("""{"""),format.raw/*599.31*/(""" """),format.raw/*599.32*/("""message: 'Required' """),format.raw/*599.52*/("""}"""),format.raw/*599.53*/(""",
		                	greaterThan: """),format.raw/*600.33*/("""{"""),format.raw/*600.34*/("""
		                		"""),format.raw/*601.21*/("""message: 'Fee must be greater than 15.',
		                		value: 15
		                	"""),format.raw/*603.20*/("""}"""),format.raw/*603.21*/("""
		                """),format.raw/*604.19*/("""}"""),format.raw/*604.20*/("""
		            """),format.raw/*605.15*/("""}"""),format.raw/*605.16*/("""
		        """),format.raw/*606.11*/("""}"""),format.raw/*606.12*/("""
		    """),format.raw/*607.7*/("""}"""),format.raw/*607.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*608.42*/("""{"""),format.raw/*608.43*/("""
	            """),format.raw/*609.14*/("""e.preventDefault();       
	            $("input[name=hidSenderId]").val(senderId);
	            $("input[name=hidRecieverId]").val(receiverId);
	            $('#hidRcFullName').val($("#txtRcFullName").combo('getText'));
	            var $form = $(e.target);// Get the form instance 
	            var data = """),format.raw/*614.25*/("""{"""),format.raw/*614.26*/("""}"""),format.raw/*614.27*/(""";
	            $form.find('[name]').each(function(index, value)"""),format.raw/*615.62*/("""{"""),format.raw/*615.63*/("""
					"""),format.raw/*616.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*619.68*/("""{"""),format.raw/*619.69*/("""
						"""),format.raw/*620.7*/("""data[name] = that.prop('checked');
					"""),format.raw/*621.6*/("""}"""),format.raw/*621.7*/("""else"""),format.raw/*621.11*/("""{"""),format.raw/*621.12*/("""
						"""),format.raw/*622.7*/("""data[name] = value;
					"""),format.raw/*623.6*/("""}"""),format.raw/*623.7*/("""
				"""),format.raw/*624.5*/("""}"""),format.raw/*624.6*/(""");
	            
	            // Use Ajax to submit form data 
	            $.ajax("""),format.raw/*627.21*/("""{"""),format.raw/*627.22*/("""
	       			"""),format.raw/*628.12*/("""url: """"),_display_(/*628.19*/routes/*628.25*/.RemittanceController.previewRemittanceTransaction()),format.raw/*628.77*/("""",
	       			type: "post",
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*633.40*/("""{"""),format.raw/*633.41*/("""
	       				"""),format.raw/*634.13*/("""if(response.result == 'block') """),format.raw/*634.44*/("""{"""),format.raw/*634.45*/("""
	       					"""),format.raw/*635.14*/("""bootbox.alert(response.message, function() """),format.raw/*635.57*/("""{"""),format.raw/*635.58*/("""
	       					"""),format.raw/*636.14*/("""}"""),format.raw/*636.15*/(""");
	       				"""),format.raw/*637.13*/("""}"""),format.raw/*637.14*/("""
	       				"""),format.raw/*638.13*/("""else if(response.result == 'warning')"""),format.raw/*638.50*/("""{"""),format.raw/*638.51*/("""	  
	       					"""),format.raw/*639.14*/("""bootbox.dialog("""),format.raw/*639.29*/("""{"""),format.raw/*639.30*/("""
	       						"""),format.raw/*640.15*/("""message: response.message ,
	       						title: "Warning",
	       						buttons: """),format.raw/*642.24*/("""{"""),format.raw/*642.25*/("""
	       							"""),format.raw/*643.16*/("""success: """),format.raw/*643.25*/("""{"""),format.raw/*643.26*/("""
	       								"""),format.raw/*644.17*/("""label: "NO",
	       								className: "btn-default",
	       								callback: function() """),format.raw/*646.38*/("""{"""),format.raw/*646.39*/("""
	       									"""),format.raw/*647.18*/("""$('#frmRemittance').data('bootstrapValidator').resetForm();
	       								"""),format.raw/*648.17*/("""}"""),format.raw/*648.18*/("""
	       							"""),format.raw/*649.16*/("""}"""),format.raw/*649.17*/(""",
	       							main: """),format.raw/*650.22*/("""{"""),format.raw/*650.23*/("""
	       								"""),format.raw/*651.17*/("""label: "Yes",
	       								className: "btn-primary",
	       								callback: function() """),format.raw/*653.38*/("""{"""),format.raw/*653.39*/("""
	       									"""),format.raw/*654.18*/("""// Save transaction as blocking 
	       									var actionurl = """"),_display_(/*655.36*/routes/*655.42*/.RemittanceController.saveOrUpdateRemittanceTransaction()),format.raw/*655.99*/("""";
	       							        //do your own request an handle the results
	       							         $.ajax("""),format.raw/*657.32*/("""{"""),format.raw/*657.33*/("""
	       							                """),format.raw/*658.32*/("""url: actionurl,
	       							                type: 'post',
	       							                dataType: 'json',
	       							                success: function(data) """),format.raw/*661.56*/("""{"""),format.raw/*661.57*/("""
	       							                	"""),format.raw/*662.33*/("""clearAndResetForm("frmRemittance");
	       							                    location.reload();
	       							                """),format.raw/*664.32*/("""}"""),format.raw/*664.33*/("""
	       							         """),format.raw/*665.25*/("""}"""),format.raw/*665.26*/(""");
	       								"""),format.raw/*666.17*/("""}"""),format.raw/*666.18*/("""
	       							"""),format.raw/*667.16*/("""}"""),format.raw/*667.17*/("""
	       						"""),format.raw/*668.15*/("""}"""),format.raw/*668.16*/("""
	       					"""),format.raw/*669.14*/("""}"""),format.raw/*669.15*/(""");
				       	"""),format.raw/*670.13*/("""}"""),format.raw/*670.14*/("""
	       				"""),format.raw/*671.13*/("""else if(response == 'failed')"""),format.raw/*671.42*/("""{"""),format.raw/*671.43*/("""	
				       		"""),format.raw/*672.14*/("""$('#remittance-alert-danger').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*673.35*/("""{"""),format.raw/*673.36*/("""
			       				"""),format.raw/*674.15*/("""$('#remittance-alert-danger').addClass('hidden');
			       			"""),format.raw/*675.14*/("""}"""),format.raw/*675.15*/(""", 3000);
					    """),format.raw/*676.10*/("""}"""),format.raw/*676.11*/("""
	       				"""),format.raw/*677.13*/("""else"""),format.raw/*677.17*/("""{"""),format.raw/*677.18*/("""
			       			"""),format.raw/*678.14*/("""updateRemittanceFormForPrint(response);
			       			$('#popupRemittanceApplicationForm').modal("show");
			       			$('#frmRemittance').data('bootstrapValidator').resetForm();
			       		"""),format.raw/*681.13*/("""}"""),format.raw/*681.14*/("""
		       		"""),format.raw/*682.12*/("""}"""),format.raw/*682.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*683.62*/("""{"""),format.raw/*683.63*/("""
		            	"""),format.raw/*684.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*684.102*/("""{"""),format.raw/*684.103*/("""}"""),format.raw/*684.104*/(""");
		            """),format.raw/*685.15*/("""}"""),format.raw/*685.16*/("""
		       	"""),format.raw/*686.11*/("""}"""),format.raw/*686.12*/(""");
		    """),format.raw/*687.7*/("""}"""),format.raw/*687.8*/(""");
			
			
			<!-- start suggestion combo work only with role teller -->
			"""),_display_(/*691.5*/if(user.getRole().getCode()=="role_teller")/*691.48*/{_display_(Seq[Any](format.raw/*691.49*/("""
"""),format.raw/*692.1*/("""<!--				$('#txtFullName').combogrid('grid').datagrid('loadData', """),format.raw/*692.66*/("""{"""),format.raw/*692.67*/(""""total":0,"rows":[]"""),format.raw/*692.86*/("""}"""),format.raw/*692.87*/(""");-->
<!--			    $('#txtRcFullName').combogrid('grid').datagrid('loadData', """),format.raw/*693.71*/("""{"""),format.raw/*693.72*/(""""total":0,"rows":[]"""),format.raw/*693.91*/("""}"""),format.raw/*693.92*/(""");-->
<!--			    $('#txtFullName').combogrid('clear');-->
<!--			    $('#txtRcFullName').combogrid('clear');-->
<!--			    $('#txtFullName').combo('clear');-->
<!--			    $('#txtRcFullName').combo('clear');-->
				$("#hidProcess").val("1");
				senderId = 0;
				receiverId = 0;
				$('#frmRemittance').bootstrapValidator('resetForm', true);
				
				/* $.ajax("""),format.raw/*703.15*/("""{"""),format.raw/*703.16*/("""
	       			"""),format.raw/*704.12*/("""url: """"),_display_(/*704.19*/routes/*704.25*/.RemittanceController.getBankReference()),format.raw/*704.65*/("""",
	       			type: "get",
	       			dataType: 'json',
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*708.40*/("""{"""),format.raw/*708.41*/("""
	       				"""),format.raw/*709.13*/("""clearForm("frmRemittance");
	       				$("#hidBankRef").val(response.bankRef);
						$("#hidDateTransaction").val(response.dateTransaction);
		       		"""),format.raw/*712.12*/("""}"""),format.raw/*712.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*713.62*/("""{"""),format.raw/*713.63*/("""
		            	"""),format.raw/*714.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*714.102*/("""{"""),format.raw/*714.103*/("""}"""),format.raw/*714.104*/(""");
		            """),format.raw/*715.15*/("""}"""),format.raw/*715.16*/("""
		       	"""),format.raw/*716.11*/("""}"""),format.raw/*716.12*/("""); */
		       	
				$('button[name="btnReject"]').hide();
				$('button[name="btnApprove"]').hide();

				$(".notif-action-button").on("click", function()"""),format.raw/*721.53*/("""{"""),format.raw/*721.54*/("""
					"""),format.raw/*722.6*/("""bootbox.dialog("""),format.raw/*722.21*/("""{"""),format.raw/*722.22*/("""
						"""),format.raw/*723.7*/("""message: "Do you want to cancel the transaction ?" ,
						title: "Warning",
						buttons: """),format.raw/*725.16*/("""{"""),format.raw/*725.17*/("""
							"""),format.raw/*726.8*/("""success: """),format.raw/*726.17*/("""{"""),format.raw/*726.18*/("""
								"""),format.raw/*727.9*/("""label: "NO",
								className: "btn-default",
								callback: function() """),format.raw/*729.30*/("""{"""),format.raw/*729.31*/("""

								"""),format.raw/*731.9*/("""}"""),format.raw/*731.10*/("""
							"""),format.raw/*732.8*/("""}"""),format.raw/*732.9*/(""",
							main: """),format.raw/*733.14*/("""{"""),format.raw/*733.15*/("""
								"""),format.raw/*734.9*/("""label: "Yes",
								className: "btn-primary",
								callback: function() """),format.raw/*736.30*/("""{"""),format.raw/*736.31*/("""
									"""),format.raw/*737.10*/("""var transactionId = $("#hidRemittanceId").val();
									var status = "transaction_canceled";
									$.ajax("""),format.raw/*739.17*/("""{"""),format.raw/*739.18*/("""
						       			"""),format.raw/*740.17*/("""url: '"""),_display_(/*740.24*/routes/*740.30*/.RemittanceController.updateTransactionStatus()),format.raw/*740.77*/("""' + '?transactionId=' + transactionId + "&status=" + status,
						       			type: 'post',
						       			success: function(response) """),format.raw/*742.45*/("""{"""),format.raw/*742.46*/("""
						       				"""),format.raw/*743.18*/("""oTable.fnReloadAjax();
							       		"""),format.raw/*744.17*/("""}"""),format.raw/*744.18*/(""",
							            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*745.67*/("""{"""),format.raw/*745.68*/("""
										    """),format.raw/*746.15*/("""console.log(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText);
											bootbox.alert(jqXHR.statusText, function() """),format.raw/*747.55*/("""{"""),format.raw/*747.56*/("""

					       					"""),format.raw/*749.18*/("""}"""),format.raw/*749.19*/(""");
							            """),format.raw/*750.20*/("""}"""),format.raw/*750.21*/("""
							       	"""),format.raw/*751.16*/("""}"""),format.raw/*751.17*/(""");
								"""),format.raw/*752.9*/("""}"""),format.raw/*752.10*/("""
							"""),format.raw/*753.8*/("""}"""),format.raw/*753.9*/("""
						"""),format.raw/*754.7*/("""}"""),format.raw/*754.8*/("""
					"""),format.raw/*755.6*/("""}"""),format.raw/*755.7*/(""");
				"""),format.raw/*756.5*/("""}"""),format.raw/*756.6*/(""");
				
				$('#txtFullName').combogrid("""),format.raw/*758.33*/("""{"""),format.raw/*758.34*/("""
	                """),format.raw/*759.18*/("""panelWidth:500,
	                name:'comboFullName',
	                height: 28,
	                width: "100%",
	                url: '"""),_display_(/*763.25*/routes/*763.31*/.SenderController.filterSenderByFullName()),format.raw/*763.73*/("""',
	                idField:'id',
	                textField:'fullName',
	                fitColumns:true,
	                loadMsg: 'Loading ...',
	                method: 'get',
	                mode:'remote',
	                fitColumns:true,
	                queryParams: """),format.raw/*771.31*/("""{"""),format.raw/*771.32*/("""
	                	"""),format.raw/*772.19*/("""minLength: '3'
	            	"""),format.raw/*773.15*/("""}"""),format.raw/*773.16*/(""",
	                columns:[[
	                    """),format.raw/*775.22*/("""{"""),format.raw/*775.23*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*775.68*/("""}"""),format.raw/*775.69*/(""",
	                    """),format.raw/*776.22*/("""{"""),format.raw/*776.23*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*776.66*/("""}"""),format.raw/*776.67*/(""",
	                    """),format.raw/*777.22*/("""{"""),format.raw/*777.23*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*777.78*/("""}"""),format.raw/*777.79*/("""
	                """),format.raw/*778.18*/("""]],
	                onSelect: function (rowIndex, rowData) """),format.raw/*779.57*/("""{"""),format.raw/*779.58*/("""
	                    """),format.raw/*780.22*/("""var grid = $('#txtFullName').combogrid('grid');	// get datagrid object
	                    var data = grid.datagrid('getSelected');	
	                    senderId = data.id;
			        	updateValueSenderPopup(data);
			        	
			        	$('#frmRemittance').data('bootstrapValidator').resetForm(true);
			        	
						var urlRequest = '"""),_display_(/*787.26*/routes/*787.32*/.RemittanceController.getRecieverBySenderId()),format.raw/*787.77*/("""' + '?senderId=' + senderId;
						$('#txtRcFullName').combogrid('grid').datagrid("""),format.raw/*788.54*/("""{"""),format.raw/*788.55*/("""
							"""),format.raw/*789.8*/("""panelWidth:500,
							url: urlRequest,
			                idField:'id',
			                textField:'fullName',
			                fitColumns:true,
			                loadMsg: 'Loading ...',
			                method: 'get',
			                mode:'remote',
			                fitColumns:true,
			                queryParams: """),format.raw/*798.33*/("""{"""),format.raw/*798.34*/("""
			                	"""),format.raw/*799.21*/("""minLength: '3'
			            	"""),format.raw/*800.17*/("""}"""),format.raw/*800.18*/(""",
			                columns:[[
			                    """),format.raw/*802.24*/("""{"""),format.raw/*802.25*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*802.70*/("""}"""),format.raw/*802.71*/(""",
			                    """),format.raw/*803.24*/("""{"""),format.raw/*803.25*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*803.68*/("""}"""),format.raw/*803.69*/(""",
			                    """),format.raw/*804.24*/("""{"""),format.raw/*804.25*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*804.80*/("""}"""),format.raw/*804.81*/("""
			                """),format.raw/*805.20*/("""]]
						"""),format.raw/*806.7*/("""}"""),format.raw/*806.8*/(""");
	                """),format.raw/*807.18*/("""}"""),format.raw/*807.19*/(""",
	                onChange: function(newValue,oldValue)"""),format.raw/*808.55*/("""{"""),format.raw/*808.56*/("""
	                	"""),format.raw/*809.19*/("""if(newValue.length >= 3 && !isNumber(newValue)) """),format.raw/*809.67*/("""{"""),format.raw/*809.68*/("""
	                		"""),format.raw/*810.20*/("""$('#txtFullName').combogrid('grid').datagrid("""),format.raw/*810.65*/("""{"""),format.raw/*810.66*/("""
	                			"""),format.raw/*811.21*/("""url: '"""),_display_(/*811.28*/routes/*811.34*/.SenderController.filterSenderByFullName()),format.raw/*811.76*/("""',
	    		                idField:'id',
	    		                textField:'fullName',
	    		                fitColumns:true,
	    		                loadMsg: 'Loading ...',
	    		                method: 'get',
	    		                mode:'remote',
	    		                fitColumns:true,
	    		                queryParams: """),format.raw/*819.37*/("""{"""),format.raw/*819.38*/("""
	    		                	"""),format.raw/*820.25*/("""minLength: '3'
	    		            	"""),format.raw/*821.21*/("""}"""),format.raw/*821.22*/(""",
	    		            	columns:[[
	    		                          """),format.raw/*823.34*/("""{"""),format.raw/*823.35*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*823.80*/("""}"""),format.raw/*823.81*/(""",
	    		                          """),format.raw/*824.34*/("""{"""),format.raw/*824.35*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*824.78*/("""}"""),format.raw/*824.79*/(""",
	    		                          """),format.raw/*825.34*/("""{"""),format.raw/*825.35*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*825.90*/("""}"""),format.raw/*825.91*/("""
	    		                      """),format.raw/*826.30*/("""]]
	    					"""),format.raw/*827.11*/("""}"""),format.raw/*827.12*/(""");
	                	"""),format.raw/*828.19*/("""}"""),format.raw/*828.20*/("""
	                """),format.raw/*829.18*/("""}"""),format.raw/*829.19*/("""
	            """),format.raw/*830.14*/("""}"""),format.raw/*830.15*/(""");
				
				// ============= Receiver ===============
				$( "#txtRcFullName" ).combogrid("""),format.raw/*833.37*/("""{"""),format.raw/*833.38*/("""
					"""),format.raw/*834.6*/("""panelWidth:500,
					height: 28,
					width: "100%",
	                url: '"""),_display_(/*837.25*/routes/*837.31*/.ReceiverController.filterByFullNameANDAccountNo()),format.raw/*837.81*/("""',
	                idField:'id',
	                textField:'fullName',
	                fitColumns:true,
	                loadMsg: 'Loading ...',
	                method: 'get',
	                mode:'remote',
	                fitColumns:true,
	                queryParams: """),format.raw/*845.31*/("""{"""),format.raw/*845.32*/("""
	                	"""),format.raw/*846.19*/("""minLength: '3'
	            	"""),format.raw/*847.15*/("""}"""),format.raw/*847.16*/(""",
	                columns:[[
	                    """),format.raw/*849.22*/("""{"""),format.raw/*849.23*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*849.68*/("""}"""),format.raw/*849.69*/(""",
	                    """),format.raw/*850.22*/("""{"""),format.raw/*850.23*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*850.66*/("""}"""),format.raw/*850.67*/(""",
	                    """),format.raw/*851.22*/("""{"""),format.raw/*851.23*/("""field:'swiftCode',title:'Swift Code',width:30"""),format.raw/*851.68*/("""}"""),format.raw/*851.69*/("""
	                """),format.raw/*852.18*/("""]],
	                onSelect: function (rowIndex, rowData) """),format.raw/*853.57*/("""{"""),format.raw/*853.58*/("""
						"""),format.raw/*854.7*/("""var grid = $('#txtRcFullName').combogrid('grid');	// get datagrid object
						var data = grid.datagrid('getSelected');	
						receiverId = data.id;
						updateValueRecieverPopup(data);
						
						var urlRequest = '"""),_display_(/*859.26*/routes/*859.32*/.RemittanceController.getSenderByRecieverId()),format.raw/*859.77*/("""' + '?receiverId=' + receiverId;
						$('#txtFullName').combogrid('grid').datagrid("""),format.raw/*860.52*/("""{"""),format.raw/*860.53*/("""
							"""),format.raw/*861.8*/("""panelWidth:500,
							url: urlRequest,
						             idField:'id',
						             textField:'fullName',
						             fitColumns:true,
						             loadMsg: 'Loading ...',
						             method: 'get',
						             mode:'remote',
						             fitColumns:true,
						             queryParams: """),format.raw/*870.33*/("""{"""),format.raw/*870.34*/("""
						             	"""),format.raw/*871.21*/("""minLength: '3'
						         	"""),format.raw/*872.17*/("""}"""),format.raw/*872.18*/(""",
						         	columns:[[
						                   """),format.raw/*874.26*/("""{"""),format.raw/*874.27*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*874.72*/("""}"""),format.raw/*874.73*/(""",
						                   """),format.raw/*875.26*/("""{"""),format.raw/*875.27*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*875.70*/("""}"""),format.raw/*875.71*/(""",
						                   """),format.raw/*876.26*/("""{"""),format.raw/*876.27*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*876.82*/("""}"""),format.raw/*876.83*/("""
						                """),format.raw/*877.23*/("""]]
						"""),format.raw/*878.7*/("""}"""),format.raw/*878.8*/(""");
	                """),format.raw/*879.18*/("""}"""),format.raw/*879.19*/(""",
	                onLoadSuccess: function(data)"""),format.raw/*880.47*/("""{"""),format.raw/*880.48*/("""
	                	"""),format.raw/*881.19*/("""if (data.rows.length)"""),format.raw/*881.40*/("""{"""),format.raw/*881.41*/("""
	    					"""),format.raw/*882.11*/("""$(this).combogrid('setValue',data.rows[0].id);
	    				"""),format.raw/*883.10*/("""}"""),format.raw/*883.11*/("""
	                """),format.raw/*884.18*/("""}"""),format.raw/*884.19*/(""",
	                onChange: function(newValue,oldValue)"""),format.raw/*885.55*/("""{"""),format.raw/*885.56*/("""
	                	
	                	"""),format.raw/*887.19*/("""var vSenderName = $('#txtFullName').combo('getText');
	                	receiverId = 0;
	                	if(newValue.length >= 3 && !isNumber(newValue)) """),format.raw/*889.67*/("""{"""),format.raw/*889.68*/("""
	                		"""),format.raw/*890.20*/("""$('#txtRcFullName').combogrid('grid').datagrid("""),format.raw/*890.67*/("""{"""),format.raw/*890.68*/("""
	    						"""),format.raw/*891.12*/("""url: 'receiver/filterByFullNameANDAccountNo',
	    		                idField:'id',
	    		                textField:'fullName',
	    		                fitColumns:true,
	    		                loadMsg: 'Loading ...',
	    		                method: 'get',
	    		                mode:'remote',
	    		                fitColumns:true,
	    		                queryParams: """),format.raw/*899.37*/("""{"""),format.raw/*899.38*/("""
	    		                	"""),format.raw/*900.25*/("""minLength: '3'
	    		            	"""),format.raw/*901.21*/("""}"""),format.raw/*901.22*/(""",
	    		                columns:[[
	    		                    """),format.raw/*903.28*/("""{"""),format.raw/*903.29*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*903.74*/("""}"""),format.raw/*903.75*/(""",
	    		                    """),format.raw/*904.28*/("""{"""),format.raw/*904.29*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*904.72*/("""}"""),format.raw/*904.73*/(""",
	    		                    """),format.raw/*905.28*/("""{"""),format.raw/*905.29*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*905.84*/("""}"""),format.raw/*905.85*/("""
	    		                """),format.raw/*906.24*/("""]]
	    					"""),format.raw/*907.11*/("""}"""),format.raw/*907.12*/(""");
	                	"""),format.raw/*908.19*/("""}"""),format.raw/*908.20*/("""
	                	"""),format.raw/*909.19*/("""$("#txtFullName").combo('setValue', vSenderName).combo('setText', vSenderName);
	                """),format.raw/*910.18*/("""}"""),format.raw/*910.19*/("""
				"""),format.raw/*911.5*/("""}"""),format.raw/*911.6*/(""");
			""")))}),format.raw/*912.5*/("""
			"""),format.raw/*913.4*/("""<!-- end suggestion combo work only with role teller -->
			
			$( "#txtOther" ).keyup(function() """),format.raw/*915.38*/("""{"""),format.raw/*915.39*/("""
				"""),format.raw/*916.5*/("""var vOther = ($( "#txtOther" ).val() != "") ? parseInt($( "#txtOther" ).val()) : 0;
				if(vOther == 0) """),format.raw/*917.21*/("""{"""),format.raw/*917.22*/("""
					"""),format.raw/*918.6*/("""$("#txtCharge").val("SHA");
					$("#divCharge").text("SHA");
				"""),format.raw/*920.5*/("""}"""),format.raw/*920.6*/("""
				"""),format.raw/*921.5*/("""else if(vOther >= 8) """),format.raw/*921.26*/("""{"""),format.raw/*921.27*/("""
					"""),format.raw/*922.6*/("""$("#txtCharge").val("OUR");
					$("#divCharge").text("OUR");
				"""),format.raw/*924.5*/("""}"""),format.raw/*924.6*/(""" """),format.raw/*924.7*/("""else """),format.raw/*924.12*/("""{"""),format.raw/*924.13*/("""
					"""),format.raw/*925.6*/("""$("#txtCharge").val("");
					$("#divCharge").text("");
				"""),format.raw/*927.5*/("""}"""),format.raw/*927.6*/("""
			"""),format.raw/*928.4*/("""}"""),format.raw/*928.5*/(""");
			
			/* $( "#txtFee" ).change(function() """),format.raw/*930.40*/("""{"""),format.raw/*930.41*/("""
				"""),format.raw/*931.5*/("""var vFee = ($( "#txtFee" ).val() != "") ? $( "#txtFee" ).val() : 0;
				if(vFee < 15) """),format.raw/*932.19*/("""{"""),format.raw/*932.20*/("""
					"""),format.raw/*933.6*/("""bootbox.alert("Fee must be greater than 15.", function() """),format.raw/*933.63*/("""{"""),format.raw/*933.64*/("""}"""),format.raw/*933.65*/(""");
				"""),format.raw/*934.5*/("""}"""),format.raw/*934.6*/("""
			"""),format.raw/*935.4*/("""}"""),format.raw/*935.5*/("""); */
			
			$("#frmRemittanceApplication").submit(function(e) """),format.raw/*937.54*/("""{"""),format.raw/*937.55*/("""
		        """),format.raw/*938.11*/("""e.preventDefault();
		        var data = """),format.raw/*939.22*/("""{"""),format.raw/*939.23*/("""}"""),format.raw/*939.24*/(""";
		        data["dateTransaction"] = $('#dateTransaction').val();
		        data["bankRef"] = $('#bankRef').val();
		        $.ajax("""),format.raw/*942.18*/("""{"""),format.raw/*942.19*/("""
	                """),format.raw/*943.18*/("""url: '"""),_display_(/*943.25*/routes/*943.31*/.RemittanceController.saveOrUpdateRemittanceTransaction()),format.raw/*943.88*/("""',
	                type: 'post',
					dataType: 'json',
					data: JSON.stringify(data),
					contentType : "application/json",
	                success: function(response) """),format.raw/*948.46*/("""{"""),format.raw/*948.47*/("""
		                """),format.raw/*949.19*/("""if(response == 'success')"""),format.raw/*949.44*/("""{"""),format.raw/*949.45*/("""
			                """),format.raw/*950.20*/("""$('#pdateTransaction').text(data["dateTransaction"]);
			                $('#pbankRef').text(data["bankRef"]);
		                    $('#printableRemittanceApplicationForm').print();
		                    $('#popupRemittanceApplicationForm').modal("hide");
		                    clearAndResetForm("frmRemittance");
		                    location.reload();
			            """),format.raw/*956.16*/("""}"""),format.raw/*956.17*/("""
		                """),format.raw/*957.19*/("""else"""),format.raw/*957.23*/("""{"""),format.raw/*957.24*/("""
							"""),format.raw/*958.8*/("""bootbox.alert("There is problem with saving remittance transaction.", function() """),format.raw/*958.89*/("""{"""),format.raw/*958.90*/("""}"""),format.raw/*958.91*/(""");
			            """),format.raw/*959.16*/("""}"""),format.raw/*959.17*/("""
	                """),format.raw/*960.18*/("""}"""),format.raw/*960.19*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*961.62*/("""{"""),format.raw/*961.63*/("""
						"""),format.raw/*962.7*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*962.93*/("""{"""),format.raw/*962.94*/("""}"""),format.raw/*962.95*/(""");
		            """),format.raw/*963.15*/("""}"""),format.raw/*963.16*/("""
		        """),format.raw/*964.11*/("""}"""),format.raw/*964.12*/(""");
		    """),format.raw/*965.7*/("""}"""),format.raw/*965.8*/(""");
			
			$( "#txtAmount" ).keyup(function() """),format.raw/*967.39*/("""{"""),format.raw/*967.40*/("""
				"""),format.raw/*968.5*/("""computeUsdEquivalent();
				computeTotalAmount();
			"""),format.raw/*970.4*/("""}"""),format.raw/*970.5*/(""");
			
			$( "#txtExchangeRate" ).keyup(function() """),format.raw/*972.45*/("""{"""),format.raw/*972.46*/("""
				"""),format.raw/*973.5*/("""computeUsdEquivalent();
				computeTotalAmount();
			"""),format.raw/*975.4*/("""}"""),format.raw/*975.5*/(""");
			
			$( "#txtFee" ).keyup(function() """),format.raw/*977.36*/("""{"""),format.raw/*977.37*/("""
				"""),format.raw/*978.5*/("""computeTotalAmount();
			"""),format.raw/*979.4*/("""}"""),format.raw/*979.5*/(""");
			
			$( "#txtCable" ).keyup(function() """),format.raw/*981.38*/("""{"""),format.raw/*981.39*/("""
				"""),format.raw/*982.5*/("""computeTotalAmount();
			"""),format.raw/*983.4*/("""}"""),format.raw/*983.5*/(""");
			
			$( "#txtPostage" ).keyup(function() """),format.raw/*985.40*/("""{"""),format.raw/*985.41*/("""
				"""),format.raw/*986.5*/("""computeUsdEquivalent();
				computeTotalAmount();
			"""),format.raw/*988.4*/("""}"""),format.raw/*988.5*/(""");
			
			$( "#txtOther" ).keyup(function() """),format.raw/*990.38*/("""{"""),format.raw/*990.39*/("""
				"""),format.raw/*991.5*/("""computeUsdEquivalent();
				computeTotalAmount();
			"""),format.raw/*993.4*/("""}"""),format.raw/*993.5*/(""");
		
			$("#btnCancelSaveAndPrint").click(function() """),format.raw/*995.49*/("""{"""),format.raw/*995.50*/("""
				"""),format.raw/*996.5*/("""$('#popupRemittanceApplicationForm').modal("hide");
			"""),format.raw/*997.4*/("""}"""),format.raw/*997.5*/(""");
			
		"""),format.raw/*999.3*/("""}"""),format.raw/*999.4*/("""); /* end document ready */

	</script>

""")))}),format.raw/*1003.2*/("""
"""))}
  }

  def render(user:User,listCurrencies:List[CurrencyExchange],strTypeSender:String,nav:String,blockedRemittanceTransactions:List[SenderReceiverTransaction],rejectedAndApprovedTxs:List[SenderReceiverTransaction],continuingTransactionId:String,notificationInterval:String): play.twirl.api.HtmlFormat.Appendable = apply(user,listCurrencies,strTypeSender,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,continuingTransactionId,notificationInterval)

  def f:((User,List[CurrencyExchange],String,String,List[SenderReceiverTransaction],List[SenderReceiverTransaction],String,String) => play.twirl.api.HtmlFormat.Appendable) = (user,listCurrencies,strTypeSender,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,continuingTransactionId,notificationInterval) => apply(user,listCurrencies,strTypeSender,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,continuingTransactionId,notificationInterval)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:59 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/teller/remittance.scala.html
                  HASH: f04b6f2a5b9a8a2a11258732e570bd4e8cd872cb
                  MATRIX: 894->50|1254->321|1282->324|1413->446|1453->448|1481->450|1590->533|1604->539|1683->597|1781->669|1795->675|1889->748|1987->820|2001->826|2077->881|2177->954|2192->960|2256->1003|2339->1059|2354->1065|2418->1108|2495->1158|2510->1164|2567->1200|2663->1269|2678->1275|2736->1312|2776->1326|2828->1369|2867->1370|2897->1373|2979->1428|2994->1434|3064->1483|3166->1558|3181->1564|3259->1620|3317->1648|3346->1650|9626->7902|9674->7933|9714->7934|9754->7945|9798->7961|9816->7969|9846->7977|9877->7980|9895->7988|9927->7998|9979->8018|10015->8026|16211->14194|16246->14207|17497->15429|17527->15430|17557->15431|17633->15478|17663->15479|17695->15483|17731->15490|17761->15491|17794->15496|17829->15503|17845->15509|17908->15550|18052->15665|18082->15666|18116->15672|18176->15704|18205->15705|18287->15758|18317->15759|18351->15765|18466->15851|18496->15852|18526->15853|18561->15860|18590->15861|18622->15865|18651->15866|18684->15871|18713->15872|18745->15876|18803->15905|18833->15906|18865->15910|20006->17022|20036->17023|20072->17031|20114->17044|20144->17045|20181->17054|20228->17073|20257->17074|20313->17102|20342->17103|20426->17158|20456->17159|20491->17166|20520->17167|20603->17221|20633->17222|20666->17227|20771->17304|20787->17310|20850->17351|21131->17603|21161->17604|21195->17610|21445->17830|21476->17831|21524->17850|21782->18079|21812->18080|21861->18100|21902->18112|21932->18113|21962->18114|22036->18159|22066->18160|22116->18181|22146->18182|22194->18201|22293->18271|22323->18272|22375->18295|22547->18438|22577->18439|22630->18463|22671->18475|22701->18476|22731->18477|22808->18525|22838->18526|22892->18551|22922->18552|22970->18571|23000->18572|23044->18587|23074->18588|23112->18598|23141->18599|23252->18681|23282->18682|23316->18688|23385->18728|23415->18729|23451->18737|23498->18756|23514->18762|23567->18793|23673->18871|23687->18875|23729->18895|23766->18904|23795->18905|23830->18912|23859->18913|23891->18917|23920->18918|23949->18919|23984->18927|24029->18962|24069->18963|24102->18968|24149->18987|24165->18993|24218->19024|24267->19045|24313->19068|24382->19109|24396->19113|24438->19133|24477->19141|24510->19146|24783->19390|24813->19391|24846->19396|24958->19480|24987->19481|25074->19539|25104->19540|25137->19545|25247->19627|25276->19628|25358->19681|25388->19682|25424->19690|25585->19822|25615->19823|25659->19838|25792->19942|25822->19943|25870->19962|25900->19963|25941->19975|25985->19990|26015->19991|26050->19998|26090->20009|26120->20010|26156->20018|26191->20024|26221->20025|26258->20034|26347->20095|26376->20096|26411->20103|26440->20104|26474->20110|26503->20111|26552->20131|26582->20132|26617->20139|26657->20150|26687->20151|26723->20159|26758->20165|26788->20166|26825->20175|26914->20236|26943->20237|26978->20244|27007->20245|27041->20251|27070->20252|27111->20265|27140->20266|27175->20273|27204->20274|27282->20323|27312->20324|27345->20329|27426->20382|27455->20383|27715->20614|27745->20615|27778->20620|27918->20732|27947->20733|28037->20794|28067->20795|28107->20806|28176->20846|28206->20847|28253->20865|28401->20984|28431->20985|28482->21007|28644->21140|28674->21141|28729->21167|28809->21218|28839->21219|28890->21241|28945->21267|28975->21268|29030->21294|29096->21331|29126->21332|29173->21350|29203->21351|29250->21369|29310->21400|29340->21401|29391->21423|29463->21466|29493->21467|29548->21493|29614->21530|29644->21531|29695->21553|29729->21558|29759->21559|29814->21585|29880->21622|29910->21623|29957->21641|29987->21642|30034->21660|30096->21693|30126->21694|30177->21716|30239->21749|30269->21750|30312->21764|30342->21765|30619->22013|30649->22014|30747->22083|30777->22084|30810->22089|30948->22198|30978->22199|31012->22205|31086->22251|31115->22252|31149->22258|31178->22259|31214->22267|31287->22311|31317->22312|31350->22317|31478->22416|31508->22417|31542->22423|31666->22518|31696->22519|31731->22526|31833->22599|31863->22600|31899->22608|31964->22645|31993->22646|32027->22652|32056->22653|32089->22658|32118->22659|32152->22665|32181->22666|32217->22674|32511->22939|32541->22940|32577->22948|32647->22990|32676->22991|32758->23044|32788->23045|32821->23050|32891->23092|32920->23093|33012->23156|33042->23157|33075->23162|33571->23630|33600->23631|33676->23678|33706->23679|33739->23684|33861->23777|33891->23778|33935->23793|34068->23897|34098->23898|34147->23918|34177->23919|34218->23931|34262->23946|34292->23947|34340->23966|34381->23978|34411->23979|34460->23999|34499->24009|34529->24010|34559->24011|34608->24031|34638->24032|34686->24051|34716->24052|34760->24067|34790->24068|34851->24100|34881->24101|34926->24117|34967->24129|34997->24130|35043->24147|35082->24157|35112->24158|35142->24159|35191->24179|35221->24180|35266->24196|35296->24197|35337->24209|35367->24210|35422->24236|35452->24237|35500->24256|35541->24268|35571->24269|35620->24289|35659->24299|35689->24300|35719->24301|35768->24321|35798->24322|35846->24341|35876->24342|35920->24357|35950->24358|36002->24381|36032->24382|36080->24401|36121->24413|36151->24414|36200->24434|36239->24444|36269->24445|36299->24446|36348->24466|36378->24467|36426->24486|36456->24487|36500->24502|36530->24503|36593->24537|36623->24538|36671->24557|36712->24569|36742->24570|36791->24590|36830->24600|36860->24601|36890->24602|36939->24622|36969->24623|37017->24642|37047->24643|37091->24658|37121->24659|37174->24683|37204->24684|37252->24703|37293->24715|37323->24716|37372->24736|37411->24746|37441->24747|37471->24748|37520->24768|37550->24769|37598->24788|37628->24789|37672->24804|37702->24805|37757->24831|37787->24832|37835->24851|37876->24863|37906->24864|37955->24884|37994->24894|38024->24895|38054->24896|38103->24916|38133->24917|38181->24936|38211->24937|38255->24952|38285->24953|38340->24979|38370->24980|38418->24999|38459->25011|38489->25012|38538->25032|38577->25042|38607->25043|38637->25044|38686->25064|38716->25065|38779->25099|38809->25100|38859->25121|38978->25211|39008->25212|39056->25231|39086->25232|39130->25247|39160->25248|39200->25259|39230->25260|39265->25267|39294->25268|39366->25311|39396->25312|39439->25326|39776->25634|39806->25635|39836->25636|39928->25699|39958->25700|39992->25706|40166->25851|40196->25852|40231->25859|40299->25899|40328->25900|40361->25904|40391->25905|40426->25912|40479->25937|40508->25938|40541->25943|40570->25944|40682->26027|40712->26028|40753->26040|40788->26047|40804->26053|40878->26105|41087->26285|41117->26286|41159->26299|41219->26330|41249->26331|41292->26345|41364->26388|41394->26389|41437->26403|41467->26404|41511->26419|41541->26420|41583->26433|41649->26470|41679->26471|41725->26488|41769->26503|41799->26504|41843->26519|41955->26602|41985->26603|42030->26619|42068->26628|42098->26629|42144->26646|42265->26738|42295->26739|42342->26757|42447->26833|42477->26834|42522->26850|42552->26851|42604->26874|42634->26875|42680->26892|42802->26985|42832->26986|42879->27004|42975->27072|42991->27078|43070->27135|43200->27236|43230->27237|43291->27269|43485->27434|43515->27435|43577->27468|43727->27589|43757->27590|43811->27615|43841->27616|43889->27635|43919->27636|43964->27652|43994->27653|44038->27668|44068->27669|44111->27683|44141->27684|44185->27699|44215->27700|44257->27713|44315->27742|44345->27743|44389->27758|44505->27845|44535->27846|44579->27861|44671->27924|44701->27925|44748->27943|44778->27944|44820->27957|44853->27961|44883->27962|44926->27976|45145->28166|45175->28167|45216->28179|45246->28180|45338->28243|45368->28244|45413->28260|45529->28346|45560->28347|45591->28348|45637->28365|45667->28366|45707->28377|45737->28378|45774->28387|45803->28388|45907->28465|45960->28508|46000->28509|46029->28510|46123->28575|46153->28576|46201->28595|46231->28596|46336->28672|46366->28673|46414->28692|46444->28693|46834->29054|46864->29055|46905->29067|46940->29074|46956->29080|47018->29120|47187->29260|47217->29261|47259->29274|47441->29427|47471->29428|47563->29491|47593->29492|47638->29508|47754->29594|47785->29595|47816->29596|47862->29613|47892->29614|47932->29625|47962->29626|48146->29781|48176->29782|48210->29788|48254->29803|48284->29804|48319->29811|48440->29903|48470->29904|48506->29912|48544->29921|48574->29922|48611->29931|48716->30007|48746->30008|48784->30018|48814->30019|48850->30027|48879->30028|48923->30043|48953->30044|48990->30053|49096->30130|49126->30131|49165->30141|49305->30252|49335->30253|49381->30270|49416->30277|49432->30283|49501->30330|49665->30465|49695->30466|49742->30484|49810->30523|49840->30524|49937->30592|49967->30593|50011->30608|50168->30736|50198->30737|50246->30756|50276->30757|50327->30779|50357->30780|50402->30796|50432->30797|50471->30808|50501->30809|50537->30817|50566->30818|50601->30825|50630->30826|50664->30832|50693->30833|50728->30840|50757->30841|50826->30881|50856->30882|50903->30900|51071->31040|51087->31046|51151->31088|51456->31364|51486->31365|51534->31384|51592->31413|51622->31414|51702->31465|51732->31466|51806->31511|51836->31512|51888->31535|51918->31536|51990->31579|52020->31580|52072->31603|52102->31604|52186->31659|52216->31660|52263->31678|52352->31738|52382->31739|52433->31761|52805->32105|52821->32111|52888->32156|52999->32238|53029->32239|53065->32247|53423->32576|53453->32577|53503->32598|53563->32629|53593->32630|53677->32685|53707->32686|53781->32731|53811->32732|53865->32757|53895->32758|53967->32801|53997->32802|54051->32827|54081->32828|54165->32883|54195->32884|54244->32904|54281->32913|54310->32914|54359->32934|54389->32935|54474->32991|54504->32992|54552->33011|54629->33059|54659->33060|54708->33080|54782->33125|54812->33126|54862->33147|54897->33154|54913->33160|54977->33202|55330->33526|55360->33527|55414->33552|55478->33587|55508->33588|55603->33654|55633->33655|55707->33700|55737->33701|55801->33736|55831->33737|55903->33780|55933->33781|55997->33816|56027->33817|56111->33872|56141->33873|56200->33903|56242->33916|56272->33917|56322->33938|56352->33939|56399->33957|56429->33958|56472->33972|56502->33973|56621->34063|56651->34064|56685->34070|56790->34147|56806->34153|56878->34203|57183->34479|57213->34480|57261->34499|57319->34528|57349->34529|57429->34580|57459->34581|57533->34626|57563->34627|57615->34650|57645->34651|57717->34694|57747->34695|57799->34718|57829->34719|57903->34764|57933->34765|57980->34783|58069->34843|58099->34844|58134->34851|58381->35070|58397->35076|58464->35121|58577->35205|58607->35206|58643->35214|59001->35543|59031->35544|59081->35565|59141->35596|59171->35597|59254->35651|59284->35652|59358->35697|59388->35698|59444->35725|59474->35726|59546->35769|59576->35770|59632->35797|59662->35798|59746->35853|59776->35854|59828->35877|59865->35886|59894->35887|59943->35907|59973->35908|60050->35956|60080->35957|60128->35976|60178->35997|60208->35998|60248->36009|60333->36065|60363->36066|60410->36084|60440->36085|60525->36141|60555->36142|60622->36180|60805->36334|60835->36335|60884->36355|60960->36402|60990->36403|61031->36415|61427->36782|61457->36783|61511->36808|61575->36843|61605->36844|61697->36907|61727->36908|61801->36953|61831->36954|61889->36983|61919->36984|61991->37027|62021->37028|62079->37057|62109->37058|62193->37113|62223->37114|62276->37138|62318->37151|62348->37152|62398->37173|62428->37174|62476->37193|62602->37290|62632->37291|62665->37296|62694->37297|62732->37304|62764->37308|62891->37406|62921->37407|62954->37412|63087->37516|63117->37517|63151->37523|63245->37589|63274->37590|63307->37595|63357->37616|63387->37617|63421->37623|63515->37689|63544->37690|63573->37691|63607->37696|63637->37697|63671->37703|63759->37763|63788->37764|63820->37768|63849->37769|63924->37815|63954->37816|63987->37821|64102->37907|64132->37908|64166->37914|64252->37971|64282->37972|64312->37973|64347->37980|64376->37981|64408->37985|64437->37986|64529->38049|64559->38050|64599->38061|64669->38102|64699->38103|64729->38104|64891->38237|64921->38238|64968->38256|65003->38263|65019->38269|65098->38326|65301->38500|65331->38501|65379->38520|65433->38545|65463->38546|65512->38566|65912->38937|65942->38938|65990->38957|66023->38961|66053->38962|66089->38970|66199->39051|66229->39052|66259->39053|66306->39071|66336->39072|66383->39090|66413->39091|66505->39154|66535->39155|66570->39162|66685->39248|66715->39249|66745->39250|66791->39267|66821->39268|66861->39279|66891->39280|66928->39289|66957->39290|67031->39335|67061->39336|67094->39341|67175->39394|67204->39395|67284->39446|67314->39447|67347->39452|67428->39505|67457->39506|67528->39548|67558->39549|67591->39554|67644->39579|67673->39580|67746->39624|67776->39625|67809->39630|67862->39655|67891->39656|67966->39702|67996->39703|68029->39708|68110->39761|68139->39762|68212->39806|68242->39807|68275->39812|68356->39865|68385->39866|68468->39920|68498->39921|68531->39926|68614->39981|68643->39982|68680->39991|68709->39992|68783->40034
                  LINES: 26->3|29->3|31->5|31->5|31->5|32->6|33->7|33->7|33->7|34->8|34->8|34->8|35->9|35->9|35->9|37->11|37->11|37->11|38->12|38->12|38->12|39->13|39->13|39->13|41->15|41->15|41->15|42->16|42->16|42->16|43->17|44->18|44->18|44->18|45->19|45->19|45->19|47->21|48->22|174->148|174->148|174->148|175->149|175->149|175->149|175->149|175->149|175->149|175->149|176->150|177->151|319->293|319->293|363->337|363->337|363->337|365->339|365->339|366->340|366->340|366->340|367->341|367->341|367->341|367->341|371->345|371->345|372->346|373->347|373->347|374->348|374->348|375->349|375->349|375->349|375->349|376->350|376->350|377->351|377->351|378->352|378->352|380->354|380->354|380->354|381->355|410->384|410->384|411->385|411->385|411->385|412->386|413->387|413->387|415->389|415->389|415->389|415->389|416->390|416->390|416->390|416->390|417->391|420->394|420->394|420->394|429->403|429->403|430->404|431->405|431->405|432->406|434->408|434->408|435->409|435->409|435->409|435->409|435->409|435->409|436->410|436->410|437->411|437->411|437->411|438->412|440->414|440->414|441->415|441->415|441->415|441->415|441->415|441->415|442->416|442->416|443->417|443->417|444->418|444->418|445->419|445->419|446->420|446->420|447->421|447->421|447->421|448->422|448->422|448->422|448->422|449->423|449->423|449->423|450->424|450->424|451->425|451->425|452->426|452->426|452->426|454->428|454->428|454->428|455->429|455->429|455->429|455->429|455->429|455->429|456->430|456->430|456->430|457->431|459->433|462->436|462->436|463->437|464->438|464->438|465->439|465->439|466->440|467->441|467->441|468->442|468->442|469->443|472->446|472->446|473->447|476->450|476->450|477->451|477->451|478->452|478->452|478->452|479->453|479->453|479->453|480->454|480->454|480->454|481->455|483->457|483->457|484->458|484->458|485->459|485->459|486->460|486->460|487->461|487->461|487->461|488->462|488->462|488->462|489->463|491->465|491->465|492->466|492->466|493->467|493->467|494->468|494->468|495->469|495->469|496->470|496->470|497->471|499->473|499->473|503->477|503->477|504->478|506->480|506->480|508->482|508->482|509->483|509->483|509->483|510->484|512->486|512->486|513->487|515->489|515->489|516->490|517->491|517->491|518->492|518->492|518->492|519->493|520->494|520->494|521->495|521->495|522->496|522->496|522->496|523->497|523->497|523->497|524->498|525->499|525->499|526->500|526->500|526->500|527->501|528->502|528->502|529->503|529->503|530->504|530->504|530->504|531->505|532->506|532->506|533->507|533->507|537->511|537->511|539->513|539->513|540->514|541->515|541->515|542->516|544->518|544->518|545->519|545->519|547->521|547->521|547->521|548->522|549->523|549->523|550->524|552->526|552->526|553->527|554->528|554->528|555->529|556->530|556->530|557->531|557->531|558->532|558->532|559->533|559->533|561->535|564->538|564->538|565->539|566->540|566->540|568->542|568->542|569->543|570->544|570->544|571->545|571->545|572->546|578->552|578->552|579->553|579->553|580->554|582->556|582->556|583->557|586->560|586->560|587->561|587->561|588->562|588->562|588->562|589->563|589->563|589->563|590->564|590->564|590->564|590->564|590->564|590->564|591->565|591->565|592->566|592->566|593->567|593->567|594->568|594->568|594->568|595->569|595->569|595->569|595->569|595->569|595->569|596->570|596->570|597->571|597->571|598->572|598->572|599->573|599->573|599->573|600->574|600->574|600->574|600->574|600->574|600->574|601->575|601->575|602->576|602->576|603->577|603->577|604->578|604->578|604->578|605->579|605->579|605->579|605->579|605->579|605->579|606->580|606->580|607->581|607->581|608->582|608->582|609->583|609->583|609->583|610->584|610->584|610->584|610->584|610->584|610->584|611->585|611->585|612->586|612->586|613->587|613->587|614->588|614->588|614->588|615->589|615->589|615->589|615->589|615->589|615->589|616->590|616->590|617->591|617->591|618->592|618->592|619->593|619->593|619->593|620->594|620->594|620->594|620->594|620->594|620->594|621->595|621->595|622->596|622->596|623->597|623->597|624->598|624->598|624->598|625->599|625->599|625->599|625->599|625->599|625->599|626->600|626->600|627->601|629->603|629->603|630->604|630->604|631->605|631->605|632->606|632->606|633->607|633->607|634->608|634->608|635->609|640->614|640->614|640->614|641->615|641->615|642->616|645->619|645->619|646->620|647->621|647->621|647->621|647->621|648->622|649->623|649->623|650->624|650->624|653->627|653->627|654->628|654->628|654->628|654->628|659->633|659->633|660->634|660->634|660->634|661->635|661->635|661->635|662->636|662->636|663->637|663->637|664->638|664->638|664->638|665->639|665->639|665->639|666->640|668->642|668->642|669->643|669->643|669->643|670->644|672->646|672->646|673->647|674->648|674->648|675->649|675->649|676->650|676->650|677->651|679->653|679->653|680->654|681->655|681->655|681->655|683->657|683->657|684->658|687->661|687->661|688->662|690->664|690->664|691->665|691->665|692->666|692->666|693->667|693->667|694->668|694->668|695->669|695->669|696->670|696->670|697->671|697->671|697->671|698->672|699->673|699->673|700->674|701->675|701->675|702->676|702->676|703->677|703->677|703->677|704->678|707->681|707->681|708->682|708->682|709->683|709->683|710->684|710->684|710->684|710->684|711->685|711->685|712->686|712->686|713->687|713->687|717->691|717->691|717->691|718->692|718->692|718->692|718->692|718->692|719->693|719->693|719->693|719->693|729->703|729->703|730->704|730->704|730->704|730->704|734->708|734->708|735->709|738->712|738->712|739->713|739->713|740->714|740->714|740->714|740->714|741->715|741->715|742->716|742->716|747->721|747->721|748->722|748->722|748->722|749->723|751->725|751->725|752->726|752->726|752->726|753->727|755->729|755->729|757->731|757->731|758->732|758->732|759->733|759->733|760->734|762->736|762->736|763->737|765->739|765->739|766->740|766->740|766->740|766->740|768->742|768->742|769->743|770->744|770->744|771->745|771->745|772->746|773->747|773->747|775->749|775->749|776->750|776->750|777->751|777->751|778->752|778->752|779->753|779->753|780->754|780->754|781->755|781->755|782->756|782->756|784->758|784->758|785->759|789->763|789->763|789->763|797->771|797->771|798->772|799->773|799->773|801->775|801->775|801->775|801->775|802->776|802->776|802->776|802->776|803->777|803->777|803->777|803->777|804->778|805->779|805->779|806->780|813->787|813->787|813->787|814->788|814->788|815->789|824->798|824->798|825->799|826->800|826->800|828->802|828->802|828->802|828->802|829->803|829->803|829->803|829->803|830->804|830->804|830->804|830->804|831->805|832->806|832->806|833->807|833->807|834->808|834->808|835->809|835->809|835->809|836->810|836->810|836->810|837->811|837->811|837->811|837->811|845->819|845->819|846->820|847->821|847->821|849->823|849->823|849->823|849->823|850->824|850->824|850->824|850->824|851->825|851->825|851->825|851->825|852->826|853->827|853->827|854->828|854->828|855->829|855->829|856->830|856->830|859->833|859->833|860->834|863->837|863->837|863->837|871->845|871->845|872->846|873->847|873->847|875->849|875->849|875->849|875->849|876->850|876->850|876->850|876->850|877->851|877->851|877->851|877->851|878->852|879->853|879->853|880->854|885->859|885->859|885->859|886->860|886->860|887->861|896->870|896->870|897->871|898->872|898->872|900->874|900->874|900->874|900->874|901->875|901->875|901->875|901->875|902->876|902->876|902->876|902->876|903->877|904->878|904->878|905->879|905->879|906->880|906->880|907->881|907->881|907->881|908->882|909->883|909->883|910->884|910->884|911->885|911->885|913->887|915->889|915->889|916->890|916->890|916->890|917->891|925->899|925->899|926->900|927->901|927->901|929->903|929->903|929->903|929->903|930->904|930->904|930->904|930->904|931->905|931->905|931->905|931->905|932->906|933->907|933->907|934->908|934->908|935->909|936->910|936->910|937->911|937->911|938->912|939->913|941->915|941->915|942->916|943->917|943->917|944->918|946->920|946->920|947->921|947->921|947->921|948->922|950->924|950->924|950->924|950->924|950->924|951->925|953->927|953->927|954->928|954->928|956->930|956->930|957->931|958->932|958->932|959->933|959->933|959->933|959->933|960->934|960->934|961->935|961->935|963->937|963->937|964->938|965->939|965->939|965->939|968->942|968->942|969->943|969->943|969->943|969->943|974->948|974->948|975->949|975->949|975->949|976->950|982->956|982->956|983->957|983->957|983->957|984->958|984->958|984->958|984->958|985->959|985->959|986->960|986->960|987->961|987->961|988->962|988->962|988->962|988->962|989->963|989->963|990->964|990->964|991->965|991->965|993->967|993->967|994->968|996->970|996->970|998->972|998->972|999->973|1001->975|1001->975|1003->977|1003->977|1004->978|1005->979|1005->979|1007->981|1007->981|1008->982|1009->983|1009->983|1011->985|1011->985|1012->986|1014->988|1014->988|1016->990|1016->990|1017->991|1019->993|1019->993|1021->995|1021->995|1022->996|1023->997|1023->997|1025->999|1025->999|1029->1003
                  -- GENERATED --
              */
          