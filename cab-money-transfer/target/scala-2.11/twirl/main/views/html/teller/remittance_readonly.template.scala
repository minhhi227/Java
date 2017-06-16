
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
object remittance_readonly extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[User,List[CurrencyExchange],String,String,List[SenderReceiverTransaction],List[SenderReceiverTransaction],String,String,play.twirl.api.HtmlFormat.Appendable] {

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
	
	<!-- easyUi -->
	"""),_display_(/*18.3*/if(user.getRole().getCode()=="role_teller")/*18.46*/{_display_(Seq[Any](format.raw/*18.47*/("""
	"""),format.raw/*19.2*/("""<script type="text/javascript" src=""""),_display_(/*19.39*/routes/*19.45*/.Assets.at("plugins/easyui/jquery.easyui.min.js")),format.raw/*19.94*/(""""></script>
	<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*20.63*/routes/*20.69*/.Assets.at("plugins/easyui/themes/bootstrap/easyui.css")),format.raw/*20.125*/(""""/>
	""")))}),format.raw/*21.3*/("""
	"""),format.raw/*22.2*/("""<!-- end easyUi -->
	
	<div class="content-wrapper">
		<div class="page-header"><h3>List remittance </h3></div>
		<div class="row">
			<input type="hidden" name="hidListTypeSender" value=""""),_display_(/*27.58*/strTypeSender),format.raw/*27.71*/(""""/>
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

	<!-- modal remittance -->
	
		<!-- end pop up create or update user -->
		
	    <!-- pop up receiver advanced search view -->
		<div id="modalAdvancedSearch" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalAdvancedSearch" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			   <div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="popupAddEditReceiverTitle">Advanced Search</h4>
				</div>
				<form role="form" id="frmAdvancedSearch" name="frmAdvancedSearch" data-toggle="validator">
					<div class="modal-body">
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
						<button id="btnCancelAdvanceSearch" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</form>
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
		
		$(document).ready(function() """),format.raw/*146.32*/("""{"""),format.raw/*146.33*/("""
			"""),format.raw/*147.4*/("""/* date picker start date */
			var dpsearchFromDate = new dhtmlXCalendarObject(["advFromDate"]);
			dpsearchFromDate.setDateFormat("%d/%m/%Y");
			$("input[name=searchFromDate]").val(dpsearchFromDate.getFormatedDate("%d/%m/%Y", new Date()));
			
			/* date picker end date */
			var dpsearchToDate = new dhtmlXCalendarObject(["advToDate"]);
			dpsearchToDate.setDateFormat("%d/%m/%Y");
			$("input[name=searchToDate]").val(dpsearchToDate.getFormatedDate("%d/%m/%Y", new Date()));
			
			/* date picker end date */
			var dpDateTransaction = new dhtmlXCalendarObject(["txtDateTransactoin"]);
			dpDateTransaction.setDateFormat("%d/%m/%Y %H:%i");
			
			/* date picker end date */
			var dpExpireDate = new dhtmlXCalendarObject(["txtExpireDate"]);
			dpExpireDate.setDateFormat("%d/%m/%Y");
			
			var dpDOB = new dhtmlXCalendarObject(["txtDOB"]);
			dpDOB.setDateFormat("%d/%m/%Y");
			
			$('[name="txtOther"]').numeric();
			$('[name="txtAmount"]').numeric();
			$('[name="txtExchangeRate"]').numeric();
			$('[name="txtExchangeRate"]').numeric();
			$('[name="txtFee"]').numeric();
			
			 oTable = $('#tbRemittance').dataTable( """),format.raw/*174.44*/("""{"""),format.raw/*174.45*/("""
			    """),format.raw/*175.8*/(""""oLanguage": """),format.raw/*175.21*/("""{"""),format.raw/*175.22*/("""
				    """),format.raw/*176.9*/(""""sSearch": " "
				"""),format.raw/*177.5*/("""}"""),format.raw/*177.6*/(""",
				"columnDefs": [ 
					"""),format.raw/*179.6*/("""{"""),format.raw/*179.7*/(""""targets":[colNo], "sortable":false, "searchable":false"""),format.raw/*179.62*/("""}"""),format.raw/*179.63*/(""",
					"""),format.raw/*180.6*/("""{"""),format.raw/*180.7*/(""""targets":[colId], "visible":false, "searchable":false"""),format.raw/*180.61*/("""}"""),format.raw/*180.62*/("""
				"""),format.raw/*181.5*/("""],
				"bProcessing": true,
				"bServerSide": true,	  
				"sAjaxSource": """"),_display_(/*184.22*/routes/*184.28*/.RemittanceController.getRemittanceList()),format.raw/*184.69*/("""",
				"bAutoWidth": false,
				//"dom": 'fl<"toolbar">t<"search">ip',
				"dom": 'fl<"toolbar">t<"advanceSearch">ip',
				"bPaginate": true,
				"bFilter": true,
				"bInfo": true,
				"bLengthChange": true,
				//"sScrollY": "900px",
				//"sDom": 'T<"clear">frtiS',
				"fnServerParams": function ( aoData ) """),format.raw/*194.43*/("""{"""),format.raw/*194.44*/("""
					"""),format.raw/*195.6*/("""var searchContainer = $("#frmAdvancedSearch");
					searchContainer.find('input[type="text"][value!=""],input[type="radio"]:checked,input[type="checkbox"]:checked,textarea[value!=""],select[value!=""]').each(function () """),format.raw/*196.174*/("""{"""),format.raw/*196.175*/("""
		                """),format.raw/*197.19*/("""// all textboxes, radio buttons, checkboxes, textareas, and selects that actually have a value associated with them
		                var element = $(this), value = element.val();
		                if (typeof value === "string") """),format.raw/*199.50*/("""{"""),format.raw/*199.51*/("""
		                	"""),format.raw/*200.20*/("""aoData.push("""),format.raw/*200.32*/("""{"""),format.raw/*200.33*/(""" """),format.raw/*200.34*/(""""name": element.attr("name"), "value": value """),format.raw/*200.79*/("""}"""),format.raw/*200.80*/(""");
		                """),format.raw/*201.19*/("""}"""),format.raw/*201.20*/("""
		                """),format.raw/*202.19*/("""else if (Object.prototype.toString.apply(value) === '[object Array]') """),format.raw/*202.89*/("""{"""),format.raw/*202.90*/("""
		                    """),format.raw/*203.23*/("""// multi select since it has an array of selected values
		                    var i;
		                    for (i = 0; i < value.length; i++) """),format.raw/*205.58*/("""{"""),format.raw/*205.59*/("""
		                    	"""),format.raw/*206.24*/("""aoData.push("""),format.raw/*206.36*/("""{"""),format.raw/*206.37*/(""" """),format.raw/*206.38*/(""""name": element.attr("name"), "value": value[i] """),format.raw/*206.86*/("""}"""),format.raw/*206.87*/(""");
		                    """),format.raw/*207.23*/("""}"""),format.raw/*207.24*/("""
		                """),format.raw/*208.19*/("""}"""),format.raw/*208.20*/("""
		            """),format.raw/*209.15*/("""}"""),format.raw/*209.16*/(""");
			    """),format.raw/*210.8*/("""}"""),format.raw/*210.9*/(""",
			    fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*211.81*/("""{"""),format.raw/*211.82*/("""
					"""),format.raw/*212.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*212.46*/("""{"""),format.raw/*212.47*/(""" 
						"""),format.raw/*213.7*/("""var requestUrl = '"""),_display_(/*213.26*/routes/*213.32*/.RemittanceController.getById()),format.raw/*213.63*/("""' + "?transactionId=" + aData[colId];
						showModalRemittance(requestUrl, """"),_display_(/*214.41*/user/*214.45*/.getRole().getCode()),format.raw/*214.65*/("""");
					"""),format.raw/*215.6*/("""}"""),format.raw/*215.7*/(""");
				"""),format.raw/*216.5*/("""}"""),format.raw/*216.6*/("""
			"""),format.raw/*217.4*/("""}"""),format.raw/*217.5*/(""" """),format.raw/*217.6*/(""");

			"""),_display_(/*219.5*/if(continuingTransactionId != null)/*219.40*/{_display_(Seq[Any](format.raw/*219.41*/("""
				"""),format.raw/*220.5*/("""var requestUrl = '"""),_display_(/*220.24*/routes/*220.30*/.RemittanceController.getById()),format.raw/*220.61*/("""' + "?transactionId="""),_display_(/*220.82*/continuingTransactionId),format.raw/*220.105*/("""";
				showModalRemittance(requestUrl, """"),_display_(/*221.39*/user/*221.43*/.getRole().getCode()),format.raw/*221.63*/("""");
			""")))}),format.raw/*222.5*/("""


			"""),_display_(/*225.5*/if(user.getRole().getCode()=="role_teller")/*225.48*/{_display_(Seq[Any](format.raw/*225.49*/("""
				"""),format.raw/*226.5*/("""$("div.toolbar").html('&nbsp;<a id="btnAddRemittantTransaction" class="btn btn-primary">Add</a>');
			""")))}),format.raw/*227.5*/("""
			"""),format.raw/*228.4*/("""$('div.dataTables_filter label').append('&nbsp;<a id="btnClearSearch" href="#" class="btn btn-primary">Clear Search</a>');
			$('div.dataTables_filter label').append('&nbsp;<a data-toggle="modal" class="btn btn-primary" id="btnAdvanceSearchRemittance">Advanced Search</a>');
			
			/* Validate form advanced search remittance and submit */
		    $('#frmAdvancedSearch').bootstrapValidator("""),format.raw/*232.50*/("""{"""),format.raw/*232.51*/("""
		    	"""),format.raw/*233.8*/("""container: 'tooltip',
		    	excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		        feedbackIcons: """),format.raw/*236.26*/("""{"""),format.raw/*236.27*/("""
		            """),format.raw/*237.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*240.11*/("""}"""),format.raw/*240.12*/(""",
		        fields:"""),format.raw/*241.18*/("""{"""),format.raw/*241.19*/("""
		        	"""),format.raw/*242.12*/("""searchFromDate:"""),format.raw/*242.27*/("""{"""),format.raw/*242.28*/("""
						"""),format.raw/*243.7*/("""validators:"""),format.raw/*243.18*/("""{"""),format.raw/*243.19*/("""
							"""),format.raw/*244.8*/("""date: """),format.raw/*244.14*/("""{"""),format.raw/*244.15*/("""
								"""),format.raw/*245.9*/("""format: 'DD/MM/YYYY',
								message: 'Invalid date'
							"""),format.raw/*247.8*/("""}"""),format.raw/*247.9*/("""
						"""),format.raw/*248.7*/("""}"""),format.raw/*248.8*/("""
					"""),format.raw/*249.6*/("""}"""),format.raw/*249.7*/(""",
					searchToDate:"""),format.raw/*250.19*/("""{"""),format.raw/*250.20*/("""
						"""),format.raw/*251.7*/("""validators:"""),format.raw/*251.18*/("""{"""),format.raw/*251.19*/("""
							"""),format.raw/*252.8*/("""date: """),format.raw/*252.14*/("""{"""),format.raw/*252.15*/("""
								"""),format.raw/*253.9*/("""format: 'DD/MM/YYYY',
								message: 'Invalid date'
							"""),format.raw/*255.8*/("""}"""),format.raw/*255.9*/("""
						"""),format.raw/*256.7*/("""}"""),format.raw/*256.8*/("""
					"""),format.raw/*257.6*/("""}"""),format.raw/*257.7*/("""					
			    """),format.raw/*258.8*/("""}"""),format.raw/*258.9*/("""
		    """),format.raw/*259.7*/("""}"""),format.raw/*259.8*/(""")	        
			.on('success.form.bv', function(e) """),format.raw/*260.39*/("""{"""),format.raw/*260.40*/("""
				"""),format.raw/*261.5*/("""e.preventDefault();
				oTable.fnReloadAjax();
				$('#modalAdvancedSearch').modal("hide");				
			"""),format.raw/*264.4*/("""}"""),format.raw/*264.5*/(""");	    
	        
	        $searchContainerInputs = $('#frmAdvancedSearch').find('input[type="text"],input[type="radio"],input[type="checkbox"],select,textarea');
	        
	        $('#btnAdvanceSearchRemittance').click(function()"""),format.raw/*268.59*/("""{"""),format.raw/*268.60*/("""
				"""),format.raw/*269.5*/("""$('#modalAdvancedSearch').modal("show");
				$('#frmAdvancedSearch').data('bootstrapValidator').resetForm();
			"""),format.raw/*271.4*/("""}"""),format.raw/*271.5*/(""");
	        
	        $("#btnClearSearch").click(function () """),format.raw/*273.49*/("""{"""),format.raw/*273.50*/("""
	        	"""),format.raw/*274.11*/("""$searchContainerInputs.each(function () """),format.raw/*274.51*/("""{"""),format.raw/*274.52*/("""
	                """),format.raw/*275.18*/("""var $input = $(this),
	                tagName = this.tagName.toLowerCase();
	                if (tagName === "input") """),format.raw/*277.43*/("""{"""),format.raw/*277.44*/("""
	                    """),format.raw/*278.22*/("""var type = $input.attr("type").toLowerCase();
	                    if (type === "checkbox"
	                    || type === "radio") """),format.raw/*280.43*/("""{"""),format.raw/*280.44*/("""
	                        """),format.raw/*281.26*/("""$input.removeAttr("checked");
	                    """),format.raw/*282.22*/("""}"""),format.raw/*282.23*/("""
	                    """),format.raw/*283.22*/("""else if (type === "text") """),format.raw/*283.48*/("""{"""),format.raw/*283.49*/("""
	                        """),format.raw/*284.26*/("""$input.val("");
	                    """),format.raw/*285.22*/("""}"""),format.raw/*285.23*/("""
	                """),format.raw/*286.18*/("""}"""),format.raw/*286.19*/("""
	                """),format.raw/*287.18*/("""else if (tagName === "select") """),format.raw/*287.49*/("""{"""),format.raw/*287.50*/("""
	                    """),format.raw/*288.22*/("""if ($input.attr("multiple") !== undefined) """),format.raw/*288.65*/("""{"""),format.raw/*288.66*/("""
	                        """),format.raw/*289.26*/("""$input.val([]);
	                    """),format.raw/*290.22*/("""}"""),format.raw/*290.23*/("""
	                    """),format.raw/*291.22*/("""else """),format.raw/*291.27*/("""{"""),format.raw/*291.28*/("""
	                        """),format.raw/*292.26*/("""$input.val("");
	                    """),format.raw/*293.22*/("""}"""),format.raw/*293.23*/("""
	                """),format.raw/*294.18*/("""}"""),format.raw/*294.19*/("""
	                """),format.raw/*295.18*/("""else if (tagName === "textarea") """),format.raw/*295.51*/("""{"""),format.raw/*295.52*/("""
	                    """),format.raw/*296.22*/("""$input.val("");
	                """),format.raw/*297.18*/("""}"""),format.raw/*297.19*/("""
	            """),format.raw/*298.14*/("""}"""),format.raw/*298.15*/(""");
	        	$("input[name=searchFromDate]").val(dpsearchFromDate.getFormatedDate("%d/%m/%Y", new Date()));
				$("input[name=searchToDate]").val(dpsearchToDate.getFormatedDate("%d/%m/%Y", new Date()));
	            oTable.fnReloadAjax();
	        """),format.raw/*302.10*/("""}"""),format.raw/*302.11*/(""");
			
			if(document.getElementById("tbRemittance_filter") != null) """),format.raw/*304.63*/("""{"""),format.raw/*304.64*/("""
				"""),format.raw/*305.5*/("""//$("#tbRemittance_filter").hide();
				var searchFilter = $('#tbRemittance_filter').find('input[type="search"]');
				searchFilter.each(function () """),format.raw/*307.35*/("""{"""),format.raw/*307.36*/("""
					"""),format.raw/*308.6*/("""var $input = $(this);
					$input.hide();
				"""),format.raw/*310.5*/("""}"""),format.raw/*310.6*/(""");
			"""),format.raw/*311.4*/("""}"""),format.raw/*311.5*/("""
			
			"""),format.raw/*313.4*/("""enableDisableControlById=function(objectId) """),format.raw/*313.48*/("""{"""),format.raw/*313.49*/("""
				"""),format.raw/*314.5*/("""var recieverArea = $('#' + objectId).find('input[type="text"]');
				recieverArea.each(function () """),format.raw/*315.35*/("""{"""),format.raw/*315.36*/("""
					"""),format.raw/*316.6*/("""var $input = $(this),
					tagName = this.tagName.toLowerCase();
					if (tagName === "input") """),format.raw/*318.31*/("""{"""),format.raw/*318.32*/("""
						"""),format.raw/*319.7*/("""var type = $input.attr("type").toLowerCase();
						if (type === "text") """),format.raw/*320.28*/("""{"""),format.raw/*320.29*/("""
							"""),format.raw/*321.8*/("""$input.removeAttr('disabled');
						"""),format.raw/*322.7*/("""}"""),format.raw/*322.8*/("""
					"""),format.raw/*323.6*/("""}"""),format.raw/*323.7*/("""
				"""),format.raw/*324.5*/("""}"""),format.raw/*324.6*/(""");
			"""),format.raw/*325.4*/("""}"""),format.raw/*325.5*/("""
			
			"""),format.raw/*327.4*/("""$popupAddRemittantContainerInputs = $('#popupAddUpdateRemittant').find('input[type="text"],input[type="hidden"],input[type="radio"],input[type="checkbox"],select,textarea');
			
			$('#modalAdvancedSearch').on('hide.bs.modal', function() """),format.raw/*329.61*/("""{"""),format.raw/*329.62*/("""
				"""),format.raw/*330.5*/("""//$('#frmAdvancedSearch').bootstrapValidator('resetForm', true);
			"""),format.raw/*331.4*/("""}"""),format.raw/*331.5*/(""");
			
			// Reset the Tooltip container form
		    $('#resetButton').on('click', function(e) """),format.raw/*334.49*/("""{"""),format.raw/*334.50*/("""
		    	"""),format.raw/*335.8*/("""clearAndResetForm("frmAddUpdateRemittant");
		    """),format.raw/*336.7*/("""}"""),format.raw/*336.8*/(""");
			
			$('#resetOnClose').on('click', function(e) """),format.raw/*338.47*/("""{"""),format.raw/*338.48*/("""
				"""),format.raw/*339.5*/("""clearAndResetForm("frmAddUpdateRemittant");
		    """),format.raw/*340.7*/("""}"""),format.raw/*340.8*/(""");
			
			$('#frmAddUpdateRemittant').bootstrapValidator("""),format.raw/*342.51*/("""{"""),format.raw/*342.52*/("""
				"""),format.raw/*343.5*/("""container: 'tooltip',
		        message: 'This value is not valid',
		        feedbackIcons: """),format.raw/*345.26*/("""{"""),format.raw/*345.27*/("""
		            """),format.raw/*346.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon'
		        """),format.raw/*349.11*/("""}"""),format.raw/*349.12*/(""",
		        fields: """),format.raw/*350.19*/("""{"""),format.raw/*350.20*/("""
		        	"""),format.raw/*351.12*/("""'txtFullName': """),format.raw/*351.27*/("""{"""),format.raw/*351.28*/("""
		                """),format.raw/*352.19*/("""validators: """),format.raw/*352.31*/("""{"""),format.raw/*352.32*/("""
		                	"""),format.raw/*353.20*/("""notEmpty: """),format.raw/*353.30*/("""{"""),format.raw/*353.31*/(""" """),format.raw/*353.32*/("""message: 'Please enter required information.' """),format.raw/*353.78*/("""}"""),format.raw/*353.79*/("""
		                """),format.raw/*354.19*/("""}"""),format.raw/*354.20*/("""
		            """),format.raw/*355.15*/("""}"""),format.raw/*355.16*/(""",
			        'txtAccNumber': """),format.raw/*356.28*/("""{"""),format.raw/*356.29*/("""
			            """),format.raw/*357.16*/("""validators: """),format.raw/*357.28*/("""{"""),format.raw/*357.29*/("""
			            	"""),format.raw/*358.17*/("""notEmpty: """),format.raw/*358.27*/("""{"""),format.raw/*358.28*/(""" """),format.raw/*358.29*/("""message: 'Please enter required information.' """),format.raw/*358.75*/("""}"""),format.raw/*358.76*/("""
			            """),format.raw/*359.16*/("""}"""),format.raw/*359.17*/("""
			        """),format.raw/*360.12*/("""}"""),format.raw/*360.13*/(""",
					'txtInterBank': """),format.raw/*361.22*/("""{"""),format.raw/*361.23*/("""
		                """),format.raw/*362.19*/("""validators: """),format.raw/*362.31*/("""{"""),format.raw/*362.32*/("""
		                	"""),format.raw/*363.20*/("""notEmpty: """),format.raw/*363.30*/("""{"""),format.raw/*363.31*/(""" """),format.raw/*363.32*/("""message: 'Please enter required information.' """),format.raw/*363.78*/("""}"""),format.raw/*363.79*/("""
		                """),format.raw/*364.19*/("""}"""),format.raw/*364.20*/("""
		            """),format.raw/*365.15*/("""}"""),format.raw/*365.16*/(""",
					'txtSwiftCode': """),format.raw/*366.22*/("""{"""),format.raw/*366.23*/("""
		                """),format.raw/*367.19*/("""validators: """),format.raw/*367.31*/("""{"""),format.raw/*367.32*/("""
		                	"""),format.raw/*368.20*/("""notEmpty: """),format.raw/*368.30*/("""{"""),format.raw/*368.31*/(""" """),format.raw/*368.32*/("""message: 'Please enter required information.' """),format.raw/*368.78*/("""}"""),format.raw/*368.79*/("""
		                """),format.raw/*369.19*/("""}"""),format.raw/*369.20*/("""
		            """),format.raw/*370.15*/("""}"""),format.raw/*370.16*/(""",
		            'txtRcAccNumber': """),format.raw/*371.33*/("""{"""),format.raw/*371.34*/("""
		                """),format.raw/*372.19*/("""validators: """),format.raw/*372.31*/("""{"""),format.raw/*372.32*/("""
		                	"""),format.raw/*373.20*/("""notEmpty: """),format.raw/*373.30*/("""{"""),format.raw/*373.31*/(""" """),format.raw/*373.32*/("""message: 'Please enter required information.' """),format.raw/*373.78*/("""}"""),format.raw/*373.79*/("""
		                """),format.raw/*374.19*/("""}"""),format.raw/*374.20*/("""
		            """),format.raw/*375.15*/("""}"""),format.raw/*375.16*/(""",
					'txtRcFullName': """),format.raw/*376.23*/("""{"""),format.raw/*376.24*/("""
		                """),format.raw/*377.19*/("""validators: """),format.raw/*377.31*/("""{"""),format.raw/*377.32*/("""
		                	"""),format.raw/*378.20*/("""notEmpty: """),format.raw/*378.30*/("""{"""),format.raw/*378.31*/(""" """),format.raw/*378.32*/("""message: 'Please enter required information.' """),format.raw/*378.78*/("""}"""),format.raw/*378.79*/("""
		                """),format.raw/*379.19*/("""}"""),format.raw/*379.20*/("""
		            """),format.raw/*380.15*/("""}"""),format.raw/*380.16*/(""",
					/*'txtRcPurpose': """),format.raw/*381.24*/("""{"""),format.raw/*381.25*/("""
		                """),format.raw/*382.19*/("""validators: """),format.raw/*382.31*/("""{"""),format.raw/*382.32*/("""
		                	"""),format.raw/*383.20*/("""notEmpty: """),format.raw/*383.30*/("""{"""),format.raw/*383.31*/(""" """),format.raw/*383.32*/("""message: 'Please enter required information.' """),format.raw/*383.78*/("""}"""),format.raw/*383.79*/("""
		                """),format.raw/*384.19*/("""}"""),format.raw/*384.20*/("""
		            """),format.raw/*385.15*/("""}"""),format.raw/*385.16*/(""",*/
<!--		            'txtBankRef': """),format.raw/*386.33*/("""{"""),format.raw/*386.34*/("""-->
<!--			            validators: """),format.raw/*387.32*/("""{"""),format.raw/*387.33*/("""-->
<!--			            	notEmpty: """),format.raw/*388.31*/("""{"""),format.raw/*388.32*/(""" """),format.raw/*388.33*/("""message: 'Please enter required information.' """),format.raw/*388.79*/("""}"""),format.raw/*388.80*/("""-->
<!--			            """),format.raw/*389.20*/("""}"""),format.raw/*389.21*/("""-->
<!--			        """),format.raw/*390.16*/("""}"""),format.raw/*390.17*/(""",-->
<!--					'txtDateTransactoin': """),format.raw/*391.32*/("""{"""),format.raw/*391.33*/("""-->
<!--			            validators: """),format.raw/*392.32*/("""{"""),format.raw/*392.33*/("""-->
<!--			            	notEmpty: """),format.raw/*393.31*/("""{"""),format.raw/*393.32*/(""" """),format.raw/*393.33*/("""message: 'Please enter required information.' """),format.raw/*393.79*/("""}"""),format.raw/*393.80*/("""-->
<!--			            """),format.raw/*394.20*/("""}"""),format.raw/*394.21*/("""-->
<!--			        """),format.raw/*395.16*/("""}"""),format.raw/*395.17*/(""",-->
			        'txtAmount': """),format.raw/*396.25*/("""{"""),format.raw/*396.26*/("""
		                """),format.raw/*397.19*/("""validators: """),format.raw/*397.31*/("""{"""),format.raw/*397.32*/("""
		                	"""),format.raw/*398.20*/("""notEmpty: """),format.raw/*398.30*/("""{"""),format.raw/*398.31*/(""" """),format.raw/*398.32*/("""message: 'Please enter required information.' """),format.raw/*398.78*/("""}"""),format.raw/*398.79*/("""
		                """),format.raw/*399.19*/("""}"""),format.raw/*399.20*/("""
		            """),format.raw/*400.15*/("""}"""),format.raw/*400.16*/(""",
		            'txtFee': """),format.raw/*401.25*/("""{"""),format.raw/*401.26*/("""
		                """),format.raw/*402.19*/("""validators: """),format.raw/*402.31*/("""{"""),format.raw/*402.32*/("""
		                	"""),format.raw/*403.20*/("""notEmpty: """),format.raw/*403.30*/("""{"""),format.raw/*403.31*/(""" """),format.raw/*403.32*/("""message: 'Please enter required information.' """),format.raw/*403.78*/("""}"""),format.raw/*403.79*/("""
		                """),format.raw/*404.19*/("""}"""),format.raw/*404.20*/("""
		            """),format.raw/*405.15*/("""}"""),format.raw/*405.16*/("""
		        """),format.raw/*406.11*/("""}"""),format.raw/*406.12*/("""
		    """),format.raw/*407.7*/("""}"""),format.raw/*407.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*408.42*/("""{"""),format.raw/*408.43*/("""
	            """),format.raw/*409.14*/("""// Prevent form submission
	            e.preventDefault();       
	            $("input[name=hidSenderId]").val(senderId);
	            $("input[name=hidRecieverId]").val(receiverId);
	            $('#hidRcFullName').val($("#txtRcFullName").combo('getText'));
	            var $form = $(e.target);// Get the form instance
	            var data = """),format.raw/*415.25*/("""{"""),format.raw/*415.26*/("""}"""),format.raw/*415.27*/(""";
	            $form.find('[name]').each(function(index, value)"""),format.raw/*416.62*/("""{"""),format.raw/*416.63*/("""
					"""),format.raw/*417.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*420.68*/("""{"""),format.raw/*420.69*/("""
						"""),format.raw/*421.7*/("""data[name] = that.prop('checked');
					"""),format.raw/*422.6*/("""}"""),format.raw/*422.7*/("""else"""),format.raw/*422.11*/("""{"""),format.raw/*422.12*/("""
						"""),format.raw/*423.7*/("""data[name] = value;
					"""),format.raw/*424.6*/("""}"""),format.raw/*424.7*/("""
				"""),format.raw/*425.5*/("""}"""),format.raw/*425.6*/(""");
	            
	            // Use Ajax to submit form data 
	            $.ajax("""),format.raw/*428.21*/("""{"""),format.raw/*428.22*/("""
	       			"""),format.raw/*429.12*/("""url: """"),_display_(/*429.19*/routes/*429.25*/.RemittanceController.previewRemittanceTransaction()),format.raw/*429.77*/("""",
	       			type: "post",
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*434.40*/("""{"""),format.raw/*434.41*/("""
	       				"""),format.raw/*435.13*/("""if(response.result == 'block') """),format.raw/*435.44*/("""{"""),format.raw/*435.45*/("""
	       					"""),format.raw/*436.14*/("""$('#popupAddUpdateRemittant').modal("hide");
	       					bootbox.alert(response.message, function() """),format.raw/*437.57*/("""{"""),format.raw/*437.58*/("""
	       						"""),format.raw/*438.15*/("""$('#popupAddUpdateRemittant').modal("show");
	       					"""),format.raw/*439.14*/("""}"""),format.raw/*439.15*/(""");
	       				"""),format.raw/*440.13*/("""}"""),format.raw/*440.14*/("""
	       				"""),format.raw/*441.13*/("""else if(response.result == 'warning')"""),format.raw/*441.50*/("""{"""),format.raw/*441.51*/("""	  
	       					"""),format.raw/*442.14*/("""$('#popupAddUpdateRemittant').modal("hide");
	       					bootbox.dialog("""),format.raw/*443.29*/("""{"""),format.raw/*443.30*/("""
	       						"""),format.raw/*444.15*/("""message: response.message ,
	       						title: "Warning",
	       						buttons: """),format.raw/*446.24*/("""{"""),format.raw/*446.25*/("""
	       							"""),format.raw/*447.16*/("""success: """),format.raw/*447.25*/("""{"""),format.raw/*447.26*/("""
	       								"""),format.raw/*448.17*/("""label: "NO",
	       								className: "btn-default",
	       								callback: function() """),format.raw/*450.38*/("""{"""),format.raw/*450.39*/("""
	       									"""),format.raw/*451.18*/("""$('#frmAddUpdateRemittant').data('bootstrapValidator').resetForm();
	       									$('#popupAddUpdateRemittant').modal("show");
	       								"""),format.raw/*453.17*/("""}"""),format.raw/*453.18*/("""
	       							"""),format.raw/*454.16*/("""}"""),format.raw/*454.17*/(""",
	       							main: """),format.raw/*455.22*/("""{"""),format.raw/*455.23*/("""
	       								"""),format.raw/*456.17*/("""label: "Yes",
	       								className: "btn-primary",
	       								callback: function() """),format.raw/*458.38*/("""{"""),format.raw/*458.39*/("""
	       									"""),format.raw/*459.18*/("""// Save transaction as blocking 
	       									var actionurl = """"),_display_(/*460.36*/routes/*460.42*/.RemittanceController.saveOrUpdateRemittanceTransaction()),format.raw/*460.99*/("""";
	       							        //do your own request an handle the results
	       							         $.ajax("""),format.raw/*462.32*/("""{"""),format.raw/*462.33*/("""
	       							                """),format.raw/*463.32*/("""url: actionurl,
	       							                type: 'post',
	       							                dataType: 'json',
	       							                success: function(data) """),format.raw/*466.56*/("""{"""),format.raw/*466.57*/("""
	       							                    """),format.raw/*467.36*/("""location.reload();
	       							                """),format.raw/*468.32*/("""}"""),format.raw/*468.33*/("""
	       							           """),format.raw/*469.27*/("""}"""),format.raw/*469.28*/(""");
	       								"""),format.raw/*470.17*/("""}"""),format.raw/*470.18*/("""
	       							"""),format.raw/*471.16*/("""}"""),format.raw/*471.17*/("""
	       						"""),format.raw/*472.15*/("""}"""),format.raw/*472.16*/("""
	       					"""),format.raw/*473.14*/("""}"""),format.raw/*473.15*/(""");
				       	"""),format.raw/*474.13*/("""}"""),format.raw/*474.14*/("""
	       				"""),format.raw/*475.13*/("""else if(response == 'failed')"""),format.raw/*475.42*/("""{"""),format.raw/*475.43*/("""	       					
				       		"""),format.raw/*476.14*/("""$('#remittance-alert-danger').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*477.35*/("""{"""),format.raw/*477.36*/("""
			       				"""),format.raw/*478.15*/("""$('#remittance-alert-danger').addClass('hidden');
			       			"""),format.raw/*479.14*/("""}"""),format.raw/*479.15*/(""", 3000);
					    """),format.raw/*480.10*/("""}"""),format.raw/*480.11*/("""
	       				"""),format.raw/*481.13*/("""else"""),format.raw/*481.17*/("""{"""),format.raw/*481.18*/("""	       					
	       					"""),format.raw/*482.14*/("""$('#popupAddUpdateRemittant').modal("hide");
			       			updateRemittanceFormForPrint(response);
			       			$('#popupRemittanceApplicationForm').modal("show");
			       			$('#frmAddUpdateRemittant').data('bootstrapValidator').resetForm();
			       		"""),format.raw/*486.13*/("""}"""),format.raw/*486.14*/("""
		       		"""),format.raw/*487.12*/("""}"""),format.raw/*487.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*488.62*/("""{"""),format.raw/*488.63*/("""
		            	"""),format.raw/*489.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*489.102*/("""{"""),format.raw/*489.103*/("""}"""),format.raw/*489.104*/(""");
		            """),format.raw/*490.15*/("""}"""),format.raw/*490.16*/("""
		       	"""),format.raw/*491.11*/("""}"""),format.raw/*491.12*/(""");
		    """),format.raw/*492.7*/("""}"""),format.raw/*492.8*/(""");
			
			
			<!-- start suggestion combo work only with role teller -->
			"""),_display_(/*496.5*/if(user.getRole().getCode()=="role_teller")/*496.48*/{_display_(Seq[Any](format.raw/*496.49*/("""
				
				"""),format.raw/*498.5*/("""$('#btnAddRemittantTransaction').click(function()"""),format.raw/*498.54*/("""{"""),format.raw/*498.55*/("""
					"""),format.raw/*499.6*/("""$('#txtFullName').combogrid('grid').datagrid('loadData', """),format.raw/*499.63*/("""{"""),format.raw/*499.64*/(""""total":0,"rows":[]"""),format.raw/*499.83*/("""}"""),format.raw/*499.84*/(""");
				    $('#txtRcFullName').combogrid('grid').datagrid('loadData', """),format.raw/*500.68*/("""{"""),format.raw/*500.69*/(""""total":0,"rows":[]"""),format.raw/*500.88*/("""}"""),format.raw/*500.89*/(""");
				    $('#txtFullName').combogrid('clear');
				    $('#txtRcFullName').combogrid('clear');
				    $('#txtFullName').combo('clear');
				    $('#txtRcFullName').combo('clear');
					
					$('#myModalLabel').html('Add Remittance');
					$("#hidProcess").val("1");
					senderId = 0;
					receiverId = 0;
					$('#frmAddUpdateRemittant').bootstrapValidator('resetForm', true) 
					$.ajax("""),format.raw/*511.13*/("""{"""),format.raw/*511.14*/("""
		       			"""),format.raw/*512.13*/("""url: """"),_display_(/*512.20*/routes/*512.26*/.RemittanceController.getBankReference()),format.raw/*512.66*/("""",
		       			type: "get",
		       			dataType: 'json',
		       			contentType : "application/json",
		       			success: function(response) """),format.raw/*516.41*/("""{"""),format.raw/*516.42*/("""
		       				"""),format.raw/*517.14*/("""clearForm("frmAddUpdateRemittant");
		       				$("input[name='hidBankRef']").val(response.bankRef);
							$("input[name='txtDateTransactoin']").val(response.dateTransaction);
							$('button[name="btnReject"]').hide();
							$('button[name="btnApprove"]').hide();
		       				$('#popupAddUpdateRemittant').modal("show");
			       		"""),format.raw/*523.13*/("""}"""),format.raw/*523.14*/(""",
			            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*524.63*/("""{"""),format.raw/*524.64*/("""
			            	"""),format.raw/*525.17*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*525.103*/("""{"""),format.raw/*525.104*/("""}"""),format.raw/*525.105*/(""");
			            """),format.raw/*526.16*/("""}"""),format.raw/*526.17*/("""
			       	"""),format.raw/*527.12*/("""}"""),format.raw/*527.13*/(""");
				"""),format.raw/*528.5*/("""}"""),format.raw/*528.6*/(""");
				
				
				$(".notif-action-button").on("click", function()"""),format.raw/*531.53*/("""{"""),format.raw/*531.54*/("""
					"""),format.raw/*532.6*/("""$('#popupAddUpdateRemittant').modal("hide");
					bootbox.dialog("""),format.raw/*533.21*/("""{"""),format.raw/*533.22*/("""
						"""),format.raw/*534.7*/("""message: "Do you want to cancel the transaction ?" ,
						title: "Warning",
						buttons: """),format.raw/*536.16*/("""{"""),format.raw/*536.17*/("""
							"""),format.raw/*537.8*/("""success: """),format.raw/*537.17*/("""{"""),format.raw/*537.18*/("""
								"""),format.raw/*538.9*/("""label: "NO",
								className: "btn-default",
								callback: function() """),format.raw/*540.30*/("""{"""),format.raw/*540.31*/("""
									"""),format.raw/*541.10*/("""//$('#popupAddUpdateRemittant').modal("show");
								"""),format.raw/*542.9*/("""}"""),format.raw/*542.10*/("""
							"""),format.raw/*543.8*/("""}"""),format.raw/*543.9*/(""",
							main: """),format.raw/*544.14*/("""{"""),format.raw/*544.15*/("""
								"""),format.raw/*545.9*/("""label: "Yes",
								className: "btn-primary",
								callback: function() """),format.raw/*547.30*/("""{"""),format.raw/*547.31*/("""
									"""),format.raw/*548.10*/("""var transactionId = $("#hidRemittanceId").val();
									var status = "transaction_canceled";
									$.ajax("""),format.raw/*550.17*/("""{"""),format.raw/*550.18*/("""
						       			"""),format.raw/*551.17*/("""url: '"""),_display_(/*551.24*/routes/*551.30*/.RemittanceController.updateTransactionStatus()),format.raw/*551.77*/("""' + '?transactionId=' + transactionId + "&status=" + status,
						       			type: 'post',
						       			success: function(response) """),format.raw/*553.45*/("""{"""),format.raw/*553.46*/("""
						       				"""),format.raw/*554.18*/("""oTable.fnReloadAjax();
							       		"""),format.raw/*555.17*/("""}"""),format.raw/*555.18*/(""",
							            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*556.67*/("""{"""),format.raw/*556.68*/("""
											"""),format.raw/*557.12*/("""bootbox.alert(jqXHR.statusText, function() """),format.raw/*557.55*/("""{"""),format.raw/*557.56*/("""
					       						"""),format.raw/*558.19*/("""$('#popupAddUpdateRemittant').modal("show");
					       					"""),format.raw/*559.18*/("""}"""),format.raw/*559.19*/(""");
							            """),format.raw/*560.20*/("""}"""),format.raw/*560.21*/("""
							       	"""),format.raw/*561.16*/("""}"""),format.raw/*561.17*/(""");
								"""),format.raw/*562.9*/("""}"""),format.raw/*562.10*/("""
							"""),format.raw/*563.8*/("""}"""),format.raw/*563.9*/("""
						"""),format.raw/*564.7*/("""}"""),format.raw/*564.8*/("""
					"""),format.raw/*565.6*/("""}"""),format.raw/*565.7*/(""");
				"""),format.raw/*566.5*/("""}"""),format.raw/*566.6*/(""");
				
				$('#txtFullName').combogrid("""),format.raw/*568.33*/("""{"""),format.raw/*568.34*/("""
	                """),format.raw/*569.18*/("""panelWidth:500,
	                name:'comboFullName',
	                height: 28,
	                width: 403,
	                url: '"""),_display_(/*573.25*/routes/*573.31*/.SenderController.filterSenderByFullName()),format.raw/*573.73*/("""',
	                idField:'id',
	                textField:'fullName',
	                fitColumns:true,
	                loadMsg: 'Loading ...',
	                method: 'get',
	                mode:'remote',
	                fitColumns:true,
	                queryParams: """),format.raw/*581.31*/("""{"""),format.raw/*581.32*/("""
	                	"""),format.raw/*582.19*/("""minLength: '3'
	            	"""),format.raw/*583.15*/("""}"""),format.raw/*583.16*/(""",
	                columns:[[
	                    """),format.raw/*585.22*/("""{"""),format.raw/*585.23*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*585.68*/("""}"""),format.raw/*585.69*/(""",
	                    """),format.raw/*586.22*/("""{"""),format.raw/*586.23*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*586.66*/("""}"""),format.raw/*586.67*/(""",
	                    """),format.raw/*587.22*/("""{"""),format.raw/*587.23*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*587.78*/("""}"""),format.raw/*587.79*/("""
	                """),format.raw/*588.18*/("""]],
	                onSelect: function (rowIndex, rowData) """),format.raw/*589.57*/("""{"""),format.raw/*589.58*/("""
	                    """),format.raw/*590.22*/("""var grid = $('#txtFullName').combogrid('grid');	// get datagrid object
	                    var data = grid.datagrid('getSelected');	
	                    senderId = data.id;
			        	updateValueSenderPopup(data);
						var urlRequest = '"""),_display_(/*594.26*/routes/*594.32*/.RemittanceController.getRecieverBySenderId()),format.raw/*594.77*/("""' + '?senderId=' + senderId;
						$('#txtRcFullName').combogrid('grid').datagrid("""),format.raw/*595.54*/("""{"""),format.raw/*595.55*/("""
							"""),format.raw/*596.8*/("""panelWidth:500,
							url: urlRequest,
			                idField:'id',
			                textField:'fullName',
			                fitColumns:true,
			                loadMsg: 'Loading ...',
			                method: 'get',
			                mode:'remote',
			                fitColumns:true,
			                queryParams: """),format.raw/*605.33*/("""{"""),format.raw/*605.34*/("""
			                	"""),format.raw/*606.21*/("""minLength: '3'
			            	"""),format.raw/*607.17*/("""}"""),format.raw/*607.18*/(""",
			                columns:[[
			                    """),format.raw/*609.24*/("""{"""),format.raw/*609.25*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*609.70*/("""}"""),format.raw/*609.71*/(""",
			                    """),format.raw/*610.24*/("""{"""),format.raw/*610.25*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*610.68*/("""}"""),format.raw/*610.69*/(""",
			                    """),format.raw/*611.24*/("""{"""),format.raw/*611.25*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*611.80*/("""}"""),format.raw/*611.81*/("""
			                """),format.raw/*612.20*/("""]]
						"""),format.raw/*613.7*/("""}"""),format.raw/*613.8*/(""");
	                """),format.raw/*614.18*/("""}"""),format.raw/*614.19*/(""",
	                onChange: function(newValue,oldValue)"""),format.raw/*615.55*/("""{"""),format.raw/*615.56*/("""
	                	"""),format.raw/*616.19*/("""if(newValue.length >= 3 && !isNumber(newValue)) """),format.raw/*616.67*/("""{"""),format.raw/*616.68*/("""
	                		"""),format.raw/*617.20*/("""$('#txtFullName').combogrid('grid').datagrid("""),format.raw/*617.65*/("""{"""),format.raw/*617.66*/("""
	                			"""),format.raw/*618.21*/("""url: '"""),_display_(/*618.28*/routes/*618.34*/.SenderController.filterSenderByFullName()),format.raw/*618.76*/("""',
	    		                idField:'id',
	    		                textField:'fullName',
	    		                fitColumns:true,
	    		                loadMsg: 'Loading ...',
	    		                method: 'get',
	    		                mode:'remote',
	    		                fitColumns:true,
	    		                queryParams: """),format.raw/*626.37*/("""{"""),format.raw/*626.38*/("""
	    		                	"""),format.raw/*627.25*/("""minLength: '3'
	    		            	"""),format.raw/*628.21*/("""}"""),format.raw/*628.22*/(""",
	    		            	columns:[[
	    		                          """),format.raw/*630.34*/("""{"""),format.raw/*630.35*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*630.80*/("""}"""),format.raw/*630.81*/(""",
	    		                          """),format.raw/*631.34*/("""{"""),format.raw/*631.35*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*631.78*/("""}"""),format.raw/*631.79*/(""",
	    		                          """),format.raw/*632.34*/("""{"""),format.raw/*632.35*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*632.90*/("""}"""),format.raw/*632.91*/("""
	    		                      """),format.raw/*633.30*/("""]]
	    					"""),format.raw/*634.11*/("""}"""),format.raw/*634.12*/(""");
	                	"""),format.raw/*635.19*/("""}"""),format.raw/*635.20*/("""
	                """),format.raw/*636.18*/("""}"""),format.raw/*636.19*/("""
	            """),format.raw/*637.14*/("""}"""),format.raw/*637.15*/(""");
				
				// ============= Reciever ===============
				$( "#txtRcFullName" ).combogrid("""),format.raw/*640.37*/("""{"""),format.raw/*640.38*/("""
					"""),format.raw/*641.6*/("""panelWidth:500,
					height: 28,
		            width: 403,
	                url: '"""),_display_(/*644.25*/routes/*644.31*/.ReceiverController.filterByFullNameANDAccountNo()),format.raw/*644.81*/("""',
	                idField:'id',
	                textField:'fullName',
	                fitColumns:true,
	                loadMsg: 'Loading ...',
	                method: 'get',
	                mode:'remote',
	                fitColumns:true,
	                queryParams: """),format.raw/*652.31*/("""{"""),format.raw/*652.32*/("""
	                	"""),format.raw/*653.19*/("""minLength: '3'
	            	"""),format.raw/*654.15*/("""}"""),format.raw/*654.16*/(""",
	                columns:[[
	                    """),format.raw/*656.22*/("""{"""),format.raw/*656.23*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*656.68*/("""}"""),format.raw/*656.69*/(""",
	                    """),format.raw/*657.22*/("""{"""),format.raw/*657.23*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*657.66*/("""}"""),format.raw/*657.67*/(""",
	                    """),format.raw/*658.22*/("""{"""),format.raw/*658.23*/("""field:'swiftCode',title:'Swift Code',width:30"""),format.raw/*658.68*/("""}"""),format.raw/*658.69*/("""
	                """),format.raw/*659.18*/("""]],
	                onSelect: function (rowIndex, rowData) """),format.raw/*660.57*/("""{"""),format.raw/*660.58*/("""
	                	 """),format.raw/*661.20*/("""var grid = $('#txtRcFullName').combogrid('grid');	// get datagrid object
	                     var data = grid.datagrid('getSelected');	
	                     receiverId = data.id;
	                     updateValueRecieverPopup(data);
	                     
	                     var urlRequest = '"""),_display_(/*666.42*/routes/*666.48*/.RemittanceController.getSenderByRecieverId()),format.raw/*666.93*/("""' + '?receiverId=' + receiverId;
	 					$('#txtFullName').combogrid('grid').datagrid("""),format.raw/*667.53*/("""{"""),format.raw/*667.54*/("""
	 						"""),format.raw/*668.9*/("""panelWidth:500,
	 						url: urlRequest,
	 		                idField:'id',
	 		                textField:'fullName',
	 		                fitColumns:true,
	 		                loadMsg: 'Loading ...',
	 		                method: 'get',
	 		                mode:'remote',
	 		                fitColumns:true,
	 		                queryParams: """),format.raw/*677.34*/("""{"""),format.raw/*677.35*/("""
	 		                	"""),format.raw/*678.22*/("""minLength: '3'
	 		            	"""),format.raw/*679.18*/("""}"""),format.raw/*679.19*/(""",
	 		            	columns:[[
		                        """),format.raw/*681.27*/("""{"""),format.raw/*681.28*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*681.73*/("""}"""),format.raw/*681.74*/(""",
		                        """),format.raw/*682.27*/("""{"""),format.raw/*682.28*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*682.71*/("""}"""),format.raw/*682.72*/(""",
		                        """),format.raw/*683.27*/("""{"""),format.raw/*683.28*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*683.83*/("""}"""),format.raw/*683.84*/("""
	 	                    """),format.raw/*684.24*/("""]]
	 					"""),format.raw/*685.8*/("""}"""),format.raw/*685.9*/(""");
	                """),format.raw/*686.18*/("""}"""),format.raw/*686.19*/(""",
	                onLoadSuccess: function(data)"""),format.raw/*687.47*/("""{"""),format.raw/*687.48*/("""
	                	"""),format.raw/*688.19*/("""if (data.rows.length)"""),format.raw/*688.40*/("""{"""),format.raw/*688.41*/("""
	    					"""),format.raw/*689.11*/("""$(this).combogrid('setValue',data.rows[0].id);
	    				"""),format.raw/*690.10*/("""}"""),format.raw/*690.11*/("""
	                """),format.raw/*691.18*/("""}"""),format.raw/*691.19*/(""",
	                onChange: function(newValue,oldValue)"""),format.raw/*692.55*/("""{"""),format.raw/*692.56*/("""
	                	
	                	"""),format.raw/*694.19*/("""var vSenderName = $('#txtFullName').combo('getText');
	                	receiverId = 0;
	                	if(newValue.length >= 3 && !isNumber(newValue)) """),format.raw/*696.67*/("""{"""),format.raw/*696.68*/("""
	                		"""),format.raw/*697.20*/("""$('#txtRcFullName').combogrid('grid').datagrid("""),format.raw/*697.67*/("""{"""),format.raw/*697.68*/("""
	    						"""),format.raw/*698.12*/("""url: 'receiver/filterByFullNameANDAccountNo',
	    		                idField:'id',
	    		                textField:'fullName',
	    		                fitColumns:true,
	    		                loadMsg: 'Loading ...',
	    		                method: 'get',
	    		                mode:'remote',
	    		                fitColumns:true,
	    		                queryParams: """),format.raw/*706.37*/("""{"""),format.raw/*706.38*/("""
	    		                	"""),format.raw/*707.25*/("""minLength: '3'
	    		            	"""),format.raw/*708.21*/("""}"""),format.raw/*708.22*/(""",
	    		                columns:[[
	    		                    """),format.raw/*710.28*/("""{"""),format.raw/*710.29*/("""field:'accountNo',title:'Account No',width:30"""),format.raw/*710.74*/("""}"""),format.raw/*710.75*/(""",
	    		                    """),format.raw/*711.28*/("""{"""),format.raw/*711.29*/("""field:'fullName',title:'Full Name',width:40"""),format.raw/*711.72*/("""}"""),format.raw/*711.73*/(""",
	    		                    """),format.raw/*712.28*/("""{"""),format.raw/*712.29*/("""field:'identityNumber',title:'Identity Number',width:30"""),format.raw/*712.84*/("""}"""),format.raw/*712.85*/("""
	    		                """),format.raw/*713.24*/("""]]
	    					"""),format.raw/*714.11*/("""}"""),format.raw/*714.12*/(""");
	                	"""),format.raw/*715.19*/("""}"""),format.raw/*715.20*/("""
	                	"""),format.raw/*716.19*/("""$("#txtFullName").combo('setValue', vSenderName).combo('setText', vSenderName);
	                """),format.raw/*717.18*/("""}"""),format.raw/*717.19*/("""
	                
				"""),format.raw/*719.5*/("""}"""),format.raw/*719.6*/(""");
			""")))}),format.raw/*720.5*/("""
			"""),format.raw/*721.4*/("""<!-- end suggestion combo work only with role teller -->
			
			$( "#txtOther" ).keyup(function() """),format.raw/*723.38*/("""{"""),format.raw/*723.39*/("""
				"""),format.raw/*724.5*/("""var vOther = ($( "#txtOther" ).val() != "") ? parseInt($( "#txtOther" ).val()) : 0;
				if(vOther == 0) """),format.raw/*725.21*/("""{"""),format.raw/*725.22*/("""
					"""),format.raw/*726.6*/("""$("#txtCharge").val("SHA");
					$("#divCharge").text("SHA");
				"""),format.raw/*728.5*/("""}"""),format.raw/*728.6*/("""
				"""),format.raw/*729.5*/("""else if(vOther >= 8) """),format.raw/*729.26*/("""{"""),format.raw/*729.27*/("""
					"""),format.raw/*730.6*/("""$("#txtCharge").val("OUR");
					$("#divCharge").text("OUR");
				"""),format.raw/*732.5*/("""}"""),format.raw/*732.6*/(""" """),format.raw/*732.7*/("""else """),format.raw/*732.12*/("""{"""),format.raw/*732.13*/("""
					"""),format.raw/*733.6*/("""$("#txtCharge").val("");
					$("#divCharge").text("");
				"""),format.raw/*735.5*/("""}"""),format.raw/*735.6*/("""
			"""),format.raw/*736.4*/("""}"""),format.raw/*736.5*/(""");
			
			$( "#txtFee" ).change(function() """),format.raw/*738.37*/("""{"""),format.raw/*738.38*/("""
				"""),format.raw/*739.5*/("""var vFee = ($( "#txtFee" ).val() != "") ? $( "#txtFee" ).val() : 0;
				if(vFee < 15) """),format.raw/*740.19*/("""{"""),format.raw/*740.20*/("""
					"""),format.raw/*741.6*/("""bootbox.alert("Fee must be greater than 15.", function() """),format.raw/*741.63*/("""{"""),format.raw/*741.64*/("""}"""),format.raw/*741.65*/(""");
				"""),format.raw/*742.5*/("""}"""),format.raw/*742.6*/("""
			"""),format.raw/*743.4*/("""}"""),format.raw/*743.5*/(""");
			
			$("#frmRemittanceApplication").submit(function(e) """),format.raw/*745.54*/("""{"""),format.raw/*745.55*/("""
		        """),format.raw/*746.11*/("""e.preventDefault();
		        $.ajax("""),format.raw/*747.18*/("""{"""),format.raw/*747.19*/("""
	                """),format.raw/*748.18*/("""url: '"""),_display_(/*748.25*/routes/*748.31*/.RemittanceController.saveOrUpdateRemittanceTransaction()),format.raw/*748.88*/("""',
	                type: 'post',
	                dataType: 'json',
	                success: function(response) """),format.raw/*751.46*/("""{"""),format.raw/*751.47*/("""
		                """),format.raw/*752.19*/("""if(response == 'success')"""),format.raw/*752.44*/("""{"""),format.raw/*752.45*/("""
		                    """),format.raw/*753.23*/("""$('#popupAddUpdateRemittant').modal("hide");
		                    $('#printableRemittanceApplicationForm').print();
		                    $('#popupRemittanceApplicationForm').modal("hide");
		                    location.reload();
			            """),format.raw/*757.16*/("""}"""),format.raw/*757.17*/("""
		                """),format.raw/*758.19*/("""else"""),format.raw/*758.23*/("""{"""),format.raw/*758.24*/("""
							"""),format.raw/*759.8*/("""bootbox.alert("There is problem with saving remittance transaction.", function() """),format.raw/*759.89*/("""{"""),format.raw/*759.90*/("""}"""),format.raw/*759.91*/(""");
			            """),format.raw/*760.16*/("""}"""),format.raw/*760.17*/("""
	                """),format.raw/*761.18*/("""}"""),format.raw/*761.19*/("""
		        """),format.raw/*762.11*/("""}"""),format.raw/*762.12*/(""");
		    """),format.raw/*763.7*/("""}"""),format.raw/*763.8*/(""");
			
			$( "#txtAmount" ).keyup(function() """),format.raw/*765.39*/("""{"""),format.raw/*765.40*/("""
				"""),format.raw/*766.5*/("""computeUsdEquivalent();
				computeTotalAmount();
			"""),format.raw/*768.4*/("""}"""),format.raw/*768.5*/(""");
			
			$( "#txtExchangeRate" ).keyup(function() """),format.raw/*770.45*/("""{"""),format.raw/*770.46*/("""
				"""),format.raw/*771.5*/("""computeUsdEquivalent();
				computeTotalAmount();
			"""),format.raw/*773.4*/("""}"""),format.raw/*773.5*/(""");
			
			$( "#txtFee" ).keyup(function() """),format.raw/*775.36*/("""{"""),format.raw/*775.37*/("""
				"""),format.raw/*776.5*/("""computeTotalAmount();
			"""),format.raw/*777.4*/("""}"""),format.raw/*777.5*/(""");
			
			$( "#txtCable" ).keyup(function() """),format.raw/*779.38*/("""{"""),format.raw/*779.39*/("""
				"""),format.raw/*780.5*/("""computeTotalAmount();
			"""),format.raw/*781.4*/("""}"""),format.raw/*781.5*/(""");
		
			$("#btnCancelSaveAndPrint").click(function() """),format.raw/*783.49*/("""{"""),format.raw/*783.50*/("""
				"""),format.raw/*784.5*/("""//$('#popupRemittanceApplicationForm').modal("hide");
				$('#popupAddUpdateRemittant').modal("show");
			"""),format.raw/*786.4*/("""}"""),format.raw/*786.5*/(""");
			
			
		"""),format.raw/*789.3*/("""}"""),format.raw/*789.4*/("""); /* end document ready */
		
		
		
	</script>

""")))}))}
  }

  def render(user:User,listCurrencies:List[CurrencyExchange],strTypeSender:String,nav:String,blockedRemittanceTransactions:List[SenderReceiverTransaction],rejectedAndApprovedTxs:List[SenderReceiverTransaction],continuingTransactionId:String,notificationInterval:String): play.twirl.api.HtmlFormat.Appendable = apply(user,listCurrencies,strTypeSender,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,continuingTransactionId,notificationInterval)

  def f:((User,List[CurrencyExchange],String,String,List[SenderReceiverTransaction],List[SenderReceiverTransaction],String,String) => play.twirl.api.HtmlFormat.Appendable) = (user,listCurrencies,strTypeSender,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,continuingTransactionId,notificationInterval) => apply(user,listCurrencies,strTypeSender,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,continuingTransactionId,notificationInterval)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:45:01 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/teller/remittance_readonly.scala.html
                  HASH: cf7322c0dfb00404256b3350b33b6aee02a3e961
                  MATRIX: 903->50|1263->321|1291->324|1422->446|1462->448|1490->450|1599->533|1613->539|1692->597|1790->669|1804->675|1898->748|1996->820|2010->826|2086->881|2188->956|2203->962|2267->1005|2350->1061|2365->1067|2429->1110|2506->1160|2521->1166|2578->1202|2674->1271|2689->1277|2747->1314|2806->1347|2858->1390|2897->1391|2926->1393|2990->1430|3005->1436|3075->1485|3176->1559|3191->1565|3269->1621|3305->1627|3334->1629|3550->1818|3584->1831|8013->6231|8043->6232|8075->6236|9236->7368|9266->7369|9302->7377|9344->7390|9374->7391|9411->7400|9458->7419|9487->7420|9543->7448|9572->7449|9656->7504|9686->7505|9721->7512|9750->7513|9833->7567|9863->7568|9896->7573|10001->7650|10017->7656|10080->7697|10420->8008|10450->8009|10484->8015|10734->8235|10765->8236|10813->8255|11071->8484|11101->8485|11150->8505|11191->8517|11221->8518|11251->8519|11325->8564|11355->8565|11405->8586|11435->8587|11483->8606|11582->8676|11612->8677|11664->8700|11836->8843|11866->8844|11919->8868|11960->8880|11990->8881|12020->8882|12097->8930|12127->8931|12181->8956|12211->8957|12259->8976|12289->8977|12333->8992|12363->8993|12401->9003|12430->9004|12541->9086|12571->9087|12605->9093|12674->9133|12704->9134|12740->9142|12787->9161|12803->9167|12856->9198|12962->9276|12976->9280|13018->9300|13055->9309|13084->9310|13119->9317|13148->9318|13180->9322|13209->9323|13238->9324|13273->9332|13318->9367|13358->9368|13391->9373|13438->9392|13454->9398|13507->9429|13556->9450|13602->9473|13671->9514|13685->9518|13727->9538|13766->9546|13800->9553|13853->9596|13893->9597|13926->9602|14060->9705|14092->9709|14510->10098|14540->10099|14576->10107|14737->10239|14767->10240|14811->10255|14962->10377|14992->10378|15040->10397|15070->10398|15111->10410|15155->10425|15185->10426|15220->10433|15260->10444|15290->10445|15326->10453|15361->10459|15391->10460|15428->10469|15517->10530|15546->10531|15581->10538|15610->10539|15644->10545|15673->10546|15722->10566|15752->10567|15787->10574|15827->10585|15857->10586|15893->10594|15928->10600|15958->10601|15995->10610|16084->10671|16113->10672|16148->10679|16177->10680|16211->10686|16240->10687|16281->10700|16310->10701|16345->10708|16374->10709|16452->10758|16482->10759|16515->10764|16642->10863|16671->10864|16931->11095|16961->11096|16994->11101|17134->11213|17163->11214|17253->11275|17283->11276|17323->11287|17392->11327|17422->11328|17469->11346|17617->11465|17647->11466|17698->11488|17860->11621|17890->11622|17945->11648|18025->11699|18055->11700|18106->11722|18161->11748|18191->11749|18246->11775|18312->11812|18342->11813|18389->11831|18419->11832|18466->11850|18526->11881|18556->11882|18607->11904|18679->11947|18709->11948|18764->11974|18830->12011|18860->12012|18911->12034|18945->12039|18975->12040|19030->12066|19096->12103|19126->12104|19173->12122|19203->12123|19250->12141|19312->12174|19342->12175|19393->12197|19455->12230|19485->12231|19528->12245|19558->12246|19835->12494|19865->12495|19963->12564|19993->12565|20026->12570|20204->12719|20234->12720|20268->12726|20342->12772|20371->12773|20405->12779|20434->12780|20470->12788|20543->12832|20573->12833|20606->12838|20734->12937|20764->12938|20798->12944|20922->13039|20952->13040|20987->13047|21089->13120|21119->13121|21155->13129|21220->13166|21249->13167|21283->13173|21312->13174|21345->13179|21374->13180|21408->13186|21437->13187|21473->13195|21740->13433|21770->13434|21803->13439|21899->13507|21928->13508|22051->13602|22081->13603|22117->13611|22195->13661|22224->13662|22306->13715|22336->13716|22369->13721|22447->13771|22476->13772|22562->13829|22592->13830|22625->13835|22747->13928|22777->13929|22821->13944|22954->14048|22984->14049|23033->14069|23063->14070|23104->14082|23148->14097|23178->14098|23226->14117|23267->14129|23297->14130|23346->14150|23385->14160|23415->14161|23445->14162|23520->14208|23550->14209|23598->14228|23628->14229|23672->14244|23702->14245|23760->14274|23790->14275|23835->14291|23876->14303|23906->14304|23952->14321|23991->14331|24021->14332|24051->14333|24126->14379|24156->14380|24201->14396|24231->14397|24272->14409|24302->14410|24354->14433|24384->14434|24432->14453|24473->14465|24503->14466|24552->14486|24591->14496|24621->14497|24651->14498|24726->14544|24756->14545|24804->14564|24834->14565|24878->14580|24908->14581|24960->14604|24990->14605|25038->14624|25079->14636|25109->14637|25158->14657|25197->14667|25227->14668|25257->14669|25332->14715|25362->14716|25410->14735|25440->14736|25484->14751|25514->14752|25577->14786|25607->14787|25655->14806|25696->14818|25726->14819|25775->14839|25814->14849|25844->14850|25874->14851|25949->14897|25979->14898|26027->14917|26057->14918|26101->14933|26131->14934|26184->14958|26214->14959|26262->14978|26303->14990|26333->14991|26382->15011|26421->15021|26451->15022|26481->15023|26556->15069|26586->15070|26634->15089|26664->15090|26708->15105|26738->15106|26792->15131|26822->15132|26870->15151|26911->15163|26941->15164|26990->15184|27029->15194|27059->15195|27089->15196|27164->15242|27194->15243|27242->15262|27272->15263|27316->15278|27346->15279|27411->15315|27441->15316|27505->15351|27535->15352|27598->15386|27628->15387|27658->15388|27733->15434|27763->15435|27815->15458|27845->15459|27893->15478|27923->15479|27988->15515|28018->15516|28082->15551|28112->15552|28175->15586|28205->15587|28235->15588|28310->15634|28340->15635|28392->15658|28422->15659|28470->15678|28500->15679|28558->15708|28588->15709|28636->15728|28677->15740|28707->15741|28756->15761|28795->15771|28825->15772|28855->15773|28930->15819|28960->15820|29008->15839|29038->15840|29082->15855|29112->15856|29167->15882|29197->15883|29245->15902|29286->15914|29316->15915|29365->15935|29404->15945|29434->15946|29464->15947|29539->15993|29569->15994|29617->16013|29647->16014|29691->16029|29721->16030|29761->16041|29791->16042|29826->16049|29855->16050|29927->16093|29957->16094|30000->16108|30376->16455|30406->16456|30436->16457|30528->16520|30558->16521|30592->16527|30766->16672|30796->16673|30831->16680|30899->16720|30928->16721|30961->16725|30991->16726|31026->16733|31079->16758|31108->16759|31141->16764|31170->16765|31282->16848|31312->16849|31353->16861|31388->16868|31404->16874|31478->16926|31687->17106|31717->17107|31759->17120|31819->17151|31849->17152|31892->17166|32022->17267|32052->17268|32096->17283|32183->17341|32213->17342|32257->17357|32287->17358|32329->17371|32395->17408|32425->17409|32471->17426|32573->17499|32603->17500|32647->17515|32759->17598|32789->17599|32834->17615|32872->17624|32902->17625|32948->17642|33069->17734|33099->17735|33146->17753|33321->17899|33351->17900|33396->17916|33426->17917|33478->17940|33508->17941|33554->17958|33676->18051|33706->18052|33753->18070|33849->18138|33865->18144|33944->18201|34074->18302|34104->18303|34165->18335|34359->18500|34389->18501|34454->18537|34533->18587|34563->18588|34619->18615|34649->18616|34697->18635|34727->18636|34772->18652|34802->18653|34846->18668|34876->18669|34919->18683|34949->18684|34993->18699|35023->18700|35065->18713|35123->18742|35153->18743|35209->18770|35325->18857|35355->18858|35399->18873|35491->18936|35521->18937|35568->18955|35598->18956|35640->18969|35673->18973|35703->18974|35759->19001|36044->19257|36074->19258|36115->19270|36145->19271|36237->19334|36267->19335|36312->19351|36428->19437|36459->19438|36490->19439|36536->19456|36566->19457|36606->19468|36636->19469|36673->19478|36702->19479|36806->19556|36859->19599|36899->19600|36937->19610|37015->19659|37045->19660|37079->19666|37165->19723|37195->19724|37243->19743|37273->19744|37372->19814|37402->19815|37450->19834|37480->19835|37902->20228|37932->20229|37974->20242|38009->20249|38025->20255|38087->20295|38260->20439|38290->20440|38333->20454|38701->20793|38731->20794|38824->20858|38854->20859|38900->20876|39016->20962|39047->20963|39078->20964|39125->20982|39155->20983|39196->20995|39226->20996|39261->21003|39290->21004|39384->21069|39414->21070|39448->21076|39542->21141|39572->21142|39607->21149|39728->21241|39758->21242|39794->21250|39832->21259|39862->21260|39899->21269|40004->21345|40034->21346|40073->21356|40156->21411|40186->21412|40222->21420|40251->21421|40295->21436|40325->21437|40362->21446|40468->21523|40498->21524|40537->21534|40677->21645|40707->21646|40753->21663|40788->21670|40804->21676|40873->21723|41037->21858|41067->21859|41114->21877|41182->21916|41212->21917|41309->21985|41339->21986|41380->21998|41452->22041|41482->22042|41530->22061|41621->22123|41651->22124|41702->22146|41732->22147|41777->22163|41807->22164|41846->22175|41876->22176|41912->22184|41941->22185|41976->22192|42005->22193|42039->22199|42068->22200|42103->22207|42132->22208|42201->22248|42231->22249|42278->22267|42443->22404|42459->22410|42523->22452|42828->22728|42858->22729|42906->22748|42964->22777|42994->22778|43074->22829|43104->22830|43178->22875|43208->22876|43260->22899|43290->22900|43362->22943|43392->22944|43444->22967|43474->22968|43558->23023|43588->23024|43635->23042|43724->23102|43754->23103|43805->23125|44075->23367|44091->23373|44158->23418|44269->23500|44299->23501|44335->23509|44693->23838|44723->23839|44773->23860|44833->23891|44863->23892|44947->23947|44977->23948|45051->23993|45081->23994|45135->24019|45165->24020|45237->24063|45267->24064|45321->24089|45351->24090|45435->24145|45465->24146|45514->24166|45551->24175|45580->24176|45629->24196|45659->24197|45744->24253|45774->24254|45822->24273|45899->24321|45929->24322|45978->24342|46052->24387|46082->24388|46132->24409|46167->24416|46183->24422|46247->24464|46600->24788|46630->24789|46684->24814|46748->24849|46778->24850|46873->24916|46903->24917|46977->24962|47007->24963|47071->24998|47101->24999|47173->25042|47203->25043|47267->25078|47297->25079|47381->25134|47411->25135|47470->25165|47512->25178|47542->25179|47592->25200|47622->25201|47669->25219|47699->25220|47742->25234|47772->25235|47891->25325|47921->25326|47955->25332|48066->25415|48082->25421|48154->25471|48459->25747|48489->25748|48537->25767|48595->25796|48625->25797|48705->25848|48735->25849|48809->25894|48839->25895|48891->25918|48921->25919|48993->25962|49023->25963|49075->25986|49105->25987|49179->26032|49209->26033|49256->26051|49345->26111|49375->26112|49424->26132|49751->26431|49767->26437|49834->26482|49948->26567|49978->26568|50015->26577|50382->26915|50412->26916|50463->26938|50524->26970|50554->26971|50639->27027|50669->27028|50743->27073|50773->27074|50830->27102|50860->27103|50932->27146|50962->27147|51019->27175|51049->27176|51133->27231|51163->27232|51216->27256|51254->27266|51283->27267|51332->27287|51362->27288|51439->27336|51469->27337|51517->27356|51567->27377|51597->27378|51637->27389|51722->27445|51752->27446|51799->27464|51829->27465|51914->27521|51944->27522|52011->27560|52194->27714|52224->27715|52273->27735|52349->27782|52379->27783|52420->27795|52816->28162|52846->28163|52900->28188|52964->28223|52994->28224|53086->28287|53116->28288|53190->28333|53220->28334|53278->28363|53308->28364|53380->28407|53410->28408|53468->28437|53498->28438|53582->28493|53612->28494|53665->28518|53707->28531|53737->28532|53787->28553|53817->28554|53865->28573|53991->28670|54021->28671|54072->28694|54101->28695|54139->28702|54171->28706|54298->28804|54328->28805|54361->28810|54494->28914|54524->28915|54558->28921|54652->28987|54681->28988|54714->28993|54764->29014|54794->29015|54828->29021|54922->29087|54951->29088|54980->29089|55014->29094|55044->29095|55078->29101|55166->29161|55195->29162|55227->29166|55256->29167|55328->29210|55358->29211|55391->29216|55506->29302|55536->29303|55570->29309|55656->29366|55686->29367|55716->29368|55751->29375|55780->29376|55812->29380|55841->29381|55930->29441|55960->29442|56000->29453|56066->29490|56096->29491|56143->29509|56178->29516|56194->29522|56273->29579|56416->29693|56446->29694|56494->29713|56548->29738|56578->29739|56630->29762|56906->30009|56936->30010|56984->30029|57017->30033|57047->30034|57083->30042|57193->30123|57223->30124|57253->30125|57300->30143|57330->30144|57377->30162|57407->30163|57447->30174|57477->30175|57514->30184|57543->30185|57617->30230|57647->30231|57680->30236|57761->30289|57790->30290|57870->30341|57900->30342|57933->30347|58014->30400|58043->30401|58114->30443|58144->30444|58177->30449|58230->30474|58259->30475|58332->30519|58362->30520|58395->30525|58448->30550|58477->30551|58560->30605|58590->30606|58623->30611|58757->30717|58786->30718|58827->30731|58856->30732
                  LINES: 26->3|29->3|31->5|31->5|31->5|32->6|33->7|33->7|33->7|34->8|34->8|34->8|35->9|35->9|35->9|37->11|37->11|37->11|38->12|38->12|38->12|39->13|39->13|39->13|41->15|41->15|41->15|44->18|44->18|44->18|45->19|45->19|45->19|45->19|46->20|46->20|46->20|47->21|48->22|53->27|53->27|172->146|172->146|173->147|200->174|200->174|201->175|201->175|201->175|202->176|203->177|203->177|205->179|205->179|205->179|205->179|206->180|206->180|206->180|206->180|207->181|210->184|210->184|210->184|220->194|220->194|221->195|222->196|222->196|223->197|225->199|225->199|226->200|226->200|226->200|226->200|226->200|226->200|227->201|227->201|228->202|228->202|228->202|229->203|231->205|231->205|232->206|232->206|232->206|232->206|232->206|232->206|233->207|233->207|234->208|234->208|235->209|235->209|236->210|236->210|237->211|237->211|238->212|238->212|238->212|239->213|239->213|239->213|239->213|240->214|240->214|240->214|241->215|241->215|242->216|242->216|243->217|243->217|243->217|245->219|245->219|245->219|246->220|246->220|246->220|246->220|246->220|246->220|247->221|247->221|247->221|248->222|251->225|251->225|251->225|252->226|253->227|254->228|258->232|258->232|259->233|262->236|262->236|263->237|266->240|266->240|267->241|267->241|268->242|268->242|268->242|269->243|269->243|269->243|270->244|270->244|270->244|271->245|273->247|273->247|274->248|274->248|275->249|275->249|276->250|276->250|277->251|277->251|277->251|278->252|278->252|278->252|279->253|281->255|281->255|282->256|282->256|283->257|283->257|284->258|284->258|285->259|285->259|286->260|286->260|287->261|290->264|290->264|294->268|294->268|295->269|297->271|297->271|299->273|299->273|300->274|300->274|300->274|301->275|303->277|303->277|304->278|306->280|306->280|307->281|308->282|308->282|309->283|309->283|309->283|310->284|311->285|311->285|312->286|312->286|313->287|313->287|313->287|314->288|314->288|314->288|315->289|316->290|316->290|317->291|317->291|317->291|318->292|319->293|319->293|320->294|320->294|321->295|321->295|321->295|322->296|323->297|323->297|324->298|324->298|328->302|328->302|330->304|330->304|331->305|333->307|333->307|334->308|336->310|336->310|337->311|337->311|339->313|339->313|339->313|340->314|341->315|341->315|342->316|344->318|344->318|345->319|346->320|346->320|347->321|348->322|348->322|349->323|349->323|350->324|350->324|351->325|351->325|353->327|355->329|355->329|356->330|357->331|357->331|360->334|360->334|361->335|362->336|362->336|364->338|364->338|365->339|366->340|366->340|368->342|368->342|369->343|371->345|371->345|372->346|375->349|375->349|376->350|376->350|377->351|377->351|377->351|378->352|378->352|378->352|379->353|379->353|379->353|379->353|379->353|379->353|380->354|380->354|381->355|381->355|382->356|382->356|383->357|383->357|383->357|384->358|384->358|384->358|384->358|384->358|384->358|385->359|385->359|386->360|386->360|387->361|387->361|388->362|388->362|388->362|389->363|389->363|389->363|389->363|389->363|389->363|390->364|390->364|391->365|391->365|392->366|392->366|393->367|393->367|393->367|394->368|394->368|394->368|394->368|394->368|394->368|395->369|395->369|396->370|396->370|397->371|397->371|398->372|398->372|398->372|399->373|399->373|399->373|399->373|399->373|399->373|400->374|400->374|401->375|401->375|402->376|402->376|403->377|403->377|403->377|404->378|404->378|404->378|404->378|404->378|404->378|405->379|405->379|406->380|406->380|407->381|407->381|408->382|408->382|408->382|409->383|409->383|409->383|409->383|409->383|409->383|410->384|410->384|411->385|411->385|412->386|412->386|413->387|413->387|414->388|414->388|414->388|414->388|414->388|415->389|415->389|416->390|416->390|417->391|417->391|418->392|418->392|419->393|419->393|419->393|419->393|419->393|420->394|420->394|421->395|421->395|422->396|422->396|423->397|423->397|423->397|424->398|424->398|424->398|424->398|424->398|424->398|425->399|425->399|426->400|426->400|427->401|427->401|428->402|428->402|428->402|429->403|429->403|429->403|429->403|429->403|429->403|430->404|430->404|431->405|431->405|432->406|432->406|433->407|433->407|434->408|434->408|435->409|441->415|441->415|441->415|442->416|442->416|443->417|446->420|446->420|447->421|448->422|448->422|448->422|448->422|449->423|450->424|450->424|451->425|451->425|454->428|454->428|455->429|455->429|455->429|455->429|460->434|460->434|461->435|461->435|461->435|462->436|463->437|463->437|464->438|465->439|465->439|466->440|466->440|467->441|467->441|467->441|468->442|469->443|469->443|470->444|472->446|472->446|473->447|473->447|473->447|474->448|476->450|476->450|477->451|479->453|479->453|480->454|480->454|481->455|481->455|482->456|484->458|484->458|485->459|486->460|486->460|486->460|488->462|488->462|489->463|492->466|492->466|493->467|494->468|494->468|495->469|495->469|496->470|496->470|497->471|497->471|498->472|498->472|499->473|499->473|500->474|500->474|501->475|501->475|501->475|502->476|503->477|503->477|504->478|505->479|505->479|506->480|506->480|507->481|507->481|507->481|508->482|512->486|512->486|513->487|513->487|514->488|514->488|515->489|515->489|515->489|515->489|516->490|516->490|517->491|517->491|518->492|518->492|522->496|522->496|522->496|524->498|524->498|524->498|525->499|525->499|525->499|525->499|525->499|526->500|526->500|526->500|526->500|537->511|537->511|538->512|538->512|538->512|538->512|542->516|542->516|543->517|549->523|549->523|550->524|550->524|551->525|551->525|551->525|551->525|552->526|552->526|553->527|553->527|554->528|554->528|557->531|557->531|558->532|559->533|559->533|560->534|562->536|562->536|563->537|563->537|563->537|564->538|566->540|566->540|567->541|568->542|568->542|569->543|569->543|570->544|570->544|571->545|573->547|573->547|574->548|576->550|576->550|577->551|577->551|577->551|577->551|579->553|579->553|580->554|581->555|581->555|582->556|582->556|583->557|583->557|583->557|584->558|585->559|585->559|586->560|586->560|587->561|587->561|588->562|588->562|589->563|589->563|590->564|590->564|591->565|591->565|592->566|592->566|594->568|594->568|595->569|599->573|599->573|599->573|607->581|607->581|608->582|609->583|609->583|611->585|611->585|611->585|611->585|612->586|612->586|612->586|612->586|613->587|613->587|613->587|613->587|614->588|615->589|615->589|616->590|620->594|620->594|620->594|621->595|621->595|622->596|631->605|631->605|632->606|633->607|633->607|635->609|635->609|635->609|635->609|636->610|636->610|636->610|636->610|637->611|637->611|637->611|637->611|638->612|639->613|639->613|640->614|640->614|641->615|641->615|642->616|642->616|642->616|643->617|643->617|643->617|644->618|644->618|644->618|644->618|652->626|652->626|653->627|654->628|654->628|656->630|656->630|656->630|656->630|657->631|657->631|657->631|657->631|658->632|658->632|658->632|658->632|659->633|660->634|660->634|661->635|661->635|662->636|662->636|663->637|663->637|666->640|666->640|667->641|670->644|670->644|670->644|678->652|678->652|679->653|680->654|680->654|682->656|682->656|682->656|682->656|683->657|683->657|683->657|683->657|684->658|684->658|684->658|684->658|685->659|686->660|686->660|687->661|692->666|692->666|692->666|693->667|693->667|694->668|703->677|703->677|704->678|705->679|705->679|707->681|707->681|707->681|707->681|708->682|708->682|708->682|708->682|709->683|709->683|709->683|709->683|710->684|711->685|711->685|712->686|712->686|713->687|713->687|714->688|714->688|714->688|715->689|716->690|716->690|717->691|717->691|718->692|718->692|720->694|722->696|722->696|723->697|723->697|723->697|724->698|732->706|732->706|733->707|734->708|734->708|736->710|736->710|736->710|736->710|737->711|737->711|737->711|737->711|738->712|738->712|738->712|738->712|739->713|740->714|740->714|741->715|741->715|742->716|743->717|743->717|745->719|745->719|746->720|747->721|749->723|749->723|750->724|751->725|751->725|752->726|754->728|754->728|755->729|755->729|755->729|756->730|758->732|758->732|758->732|758->732|758->732|759->733|761->735|761->735|762->736|762->736|764->738|764->738|765->739|766->740|766->740|767->741|767->741|767->741|767->741|768->742|768->742|769->743|769->743|771->745|771->745|772->746|773->747|773->747|774->748|774->748|774->748|774->748|777->751|777->751|778->752|778->752|778->752|779->753|783->757|783->757|784->758|784->758|784->758|785->759|785->759|785->759|785->759|786->760|786->760|787->761|787->761|788->762|788->762|789->763|789->763|791->765|791->765|792->766|794->768|794->768|796->770|796->770|797->771|799->773|799->773|801->775|801->775|802->776|803->777|803->777|805->779|805->779|806->780|807->781|807->781|809->783|809->783|810->784|812->786|812->786|815->789|815->789
                  -- GENERATED --
              */
          