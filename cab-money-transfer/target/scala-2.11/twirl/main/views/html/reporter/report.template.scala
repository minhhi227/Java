
package views.html.reporter

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

/**/
object report extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[User,String,List[SenderReceiverTransaction],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User, nav: String, blockingRemittanceTransactions: List[SenderReceiverTransaction], notificationInterval: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.122*/("""
"""),_display_(/*2.2*/main("REPORT", user, nav, blockingRemittanceTransactions, null,notificationInterval, null)/*2.92*/ {_display_(Seq[Any](format.raw/*2.94*/("""

	"""),format.raw/*4.2*/("""<div class="content-wrapper">
		<div class="page-header"><h3>Remittance Report</h3></div>
		<div class="row">
	        <div class="col-md-12">
	          	<table id="tbReport" class="display cell-border compact" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>N&deg;</th>
							<th>DATE</th>
							<th>REF</th>
							<th>CUSTOMER'S NAME</th>
							<th>C.B Ref.</th>
							
							<th>ADD.</th>
							<th>DOB.</th>
							<th>ID/Passport No.</th>
							<th>Expired Date</th>
							
							<th>AMOUNT OUTWARD</th>
							<th>Currency</th>
							<th>EX.</th>

							<th>Fee</th>
							<th>Cable</th>
							<th>OUR</th>

							<th>BENEFICIARY'S ACC</th>
							<th>BENEFICIARY'S NAME</th>
							<th>PURPOSE</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
	        </div>
        </div>
	</div>

	<!-- modal report advanced search view -->
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
						<div class="row">
							<div class="col-md-12">
									<br><label>Show columns</label><br>
									<input type="checkbox" id="chkShowSenderAddress" name="showSenderAddress" value="showSenderAddress"><label for="chkShowSenderAddress" style="margin-right:40px;">&nbsp;Sender Address</label>
									<input type="checkbox" id="chkShowSenderDOB" name="showSenderDOB" value="showSenderDOB"><label for="chkShowSenderDOB" style="margin-right:40px;">&nbsp;Sender DOB</label>
									<input type="checkbox" id="chkShowSenderIdentityNo" name="showSenderIdentityNo" value="showSenderIdentityNo"><label for="chkShowSenderIdentityNo" style="margin-right:40px;">&nbsp;ID/Passport No.</label>
									<input type="checkbox" id="chkShowExpiredDate" name="showSenderExpiredDate" value="showSenderExpiredDate"><label for="chkShowExpiredDate">&nbsp;Expired Date</label>
							</div>
						</div>																		
					</div>
					<div class="modal-footer">
						<button id="btnAdvancedSearchReport" type="submit" class="btn btn-primary">Search</button>
						<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end modal report advanced search view -->

	<!-- modal report copy data view -->
	<div id="modalReportCopyData" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalReportCopyData" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<form role="form">
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
								<textarea id="txtCopyData" class="form-control" rows="17"></textarea>	
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end modal report copy data view -->
	
	<!-- JS dataTables -->
	<script type="text/javascript" language="javascript" src=""""),_display_(/*145.61*/routes/*145.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.js")),format.raw/*145.125*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*146.61*/routes/*146.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.dataTables.min.js")),format.raw/*146.140*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*147.61*/routes/*147.67*/.Assets.at("plugins/datatables-1.10.2/fnReloadAjax.js")),format.raw/*147.122*/("""" defer></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*148.61*/routes/*148.67*/.Assets.at("plugins/datatables-1.10.2/fnFilterClear.js")),format.raw/*148.123*/(""""></script>
	<!-- JS Bootstrap -->		
	<script type="text/javascript" src=""""),_display_(/*150.39*/routes/*150.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*150.88*/("""" defer></script>
	<script type="text/javascript" language="javascript">
		var colNo = 0,
			colDate = 1,
			colBankRef = 2,
			colSenderName = 3,
			colSenderCBRef = 4, 
			colSenderAddress = 5,
			colSenderDOB = 6,
			colSenderIdentityNo = 7,
			colExpiredDate = 8,
			colAmount = 9,
			colCurrency = 10,
			colExchange = 11,
			colFee = 12,
			colCable = 13,
			colOur = 14,
			colReceiverAccountNo = 15,
			colReceiverFullName = 16,
			colPurpose = 17;
	
		var tbReport;
		
		$(document).ready(function() """),format.raw/*173.32*/("""{"""),format.raw/*173.33*/("""
			
			"""),format.raw/*175.4*/("""/* advanced search date picker from date */
			var dpAdvancedSearchFromDate = new dhtmlXCalendarObject(["advFromDate"]);
			dpAdvancedSearchFromDate.setDateFormat("%d/%m/%Y");

			/* advanced search date picker from date */
			var dpAdvancedSearchToDate = new dhtmlXCalendarObject(["advToDate"]);
			dpAdvancedSearchToDate.setDateFormat("%d/%m/%Y");

			 tbReport = $('#tbReport').dataTable( """),format.raw/*183.42*/("""{"""),format.raw/*183.43*/("""
				"""),format.raw/*184.5*/("""columnDefs: [ 
					"""),format.raw/*185.6*/("""{"""),format.raw/*185.7*/("""targets:[colNo], sortable:false, searchable:false"""),format.raw/*185.56*/("""}"""),format.raw/*185.57*/(""",
					"""),format.raw/*186.6*/("""{"""),format.raw/*186.7*/("""targets:[colSenderAddress], visible:false"""),format.raw/*186.48*/("""}"""),format.raw/*186.49*/(""",
					"""),format.raw/*187.6*/("""{"""),format.raw/*187.7*/("""targets:[colSenderDOB], visible:false"""),format.raw/*187.44*/("""}"""),format.raw/*187.45*/(""",
					"""),format.raw/*188.6*/("""{"""),format.raw/*188.7*/("""targets:[colSenderIdentityNo], visible:false"""),format.raw/*188.51*/("""}"""),format.raw/*188.52*/(""",
					"""),format.raw/*189.6*/("""{"""),format.raw/*189.7*/("""targets:[colExpiredDate], visible:false"""),format.raw/*189.46*/("""}"""),format.raw/*189.47*/("""
				"""),format.raw/*190.5*/("""],
				processing: true,
				serverSide: true,
		        scrollX: "100%",
		        scrollXInner: "200%",
		        scrollY: "300",
		        scrollCollapse: true,
		        pagingType: "full_numbers",
		        deferLoading: 0,
				ajaxSource: """"),_display_(/*199.19*/routes/*199.25*/.ReportController.getRemittanceReport()),format.raw/*199.64*/("""",
				dom: 'l<"export-excel">rtip',
				fnServerParams: function ( aoData ) """),format.raw/*201.41*/("""{"""),format.raw/*201.42*/("""
					"""),format.raw/*202.6*/("""$frmReportInputWithValue = $("#frmAdvancedSearch").find('input[type="text"][value!=""],input[type="radio"]:checked,input[type="checkbox"]:checked,textarea[value!=""],select[value!=""]');
					$frmReportInputWithValue.each(function () """),format.raw/*203.48*/("""{"""),format.raw/*203.49*/("""
		                """),format.raw/*204.19*/("""var that = $(this), value = that.val();
		                if (typeof value === "string") """),format.raw/*205.50*/("""{"""),format.raw/*205.51*/("""
		                	"""),format.raw/*206.20*/("""aoData.push("""),format.raw/*206.32*/("""{"""),format.raw/*206.33*/(""" """),format.raw/*206.34*/(""""name": that.attr("name"), "value": value """),format.raw/*206.76*/("""}"""),format.raw/*206.77*/(""");
		                """),format.raw/*207.19*/("""}"""),format.raw/*207.20*/("""
		                """),format.raw/*208.19*/("""else if (Object.prototype.toString.apply(value) === '[object Array]') """),format.raw/*208.89*/("""{"""),format.raw/*208.90*/("""
		                    """),format.raw/*209.23*/("""// for multi select because it has an array of selected values
		                    var i;
		                    for (i = 0; i < value.length; i++) """),format.raw/*211.58*/("""{"""),format.raw/*211.59*/("""
		                    	"""),format.raw/*212.24*/("""aoData.push("""),format.raw/*212.36*/("""{"""),format.raw/*212.37*/(""" """),format.raw/*212.38*/(""""name": that.attr("name"), "value": value[i] """),format.raw/*212.83*/("""}"""),format.raw/*212.84*/(""");
		                    """),format.raw/*213.23*/("""}"""),format.raw/*213.24*/("""
		                """),format.raw/*214.19*/("""}"""),format.raw/*214.20*/("""
		          	"""),format.raw/*215.14*/("""}"""),format.raw/*215.15*/(""");
			    """),format.raw/*216.8*/("""}"""),format.raw/*216.9*/(""",
			    fnDrawCallback: function()"""),format.raw/*217.34*/("""{"""),format.raw/*217.35*/("""
			    	"""),format.raw/*218.9*/("""/* disable button search if no record found */
			    	var emptyRow = $('#tbReport td.dataTables_empty');
			    	if(emptyRow.length == 0)"""),format.raw/*220.33*/("""{"""),format.raw/*220.34*/("""
						"""),format.raw/*221.7*/("""$('#btnExportExcel').removeClass('disabled');
				    """),format.raw/*222.9*/("""}"""),format.raw/*222.10*/("""else"""),format.raw/*222.14*/("""{"""),format.raw/*222.15*/("""
				    	"""),format.raw/*223.10*/("""$('#btnExportExcel').addClass('disabled');
					"""),format.raw/*224.6*/("""}"""),format.raw/*224.7*/("""
			    """),format.raw/*225.8*/("""}"""),format.raw/*225.9*/(""",
				fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*226.78*/("""{"""),format.raw/*226.79*/("""
					"""),format.raw/*227.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*227.46*/("""{"""),format.raw/*227.47*/(""" 
						"""),format.raw/*228.7*/("""preparePopupBeforeShowModalCopyData(aData);
						$('#modalReportCopyData').modal("show");
					"""),format.raw/*230.6*/("""}"""),format.raw/*230.7*/(""");
				"""),format.raw/*231.5*/("""}"""),format.raw/*231.6*/("""
			"""),format.raw/*232.4*/("""}"""),format.raw/*232.5*/(""");
				
			function fnShowHide(colIndex, visible)"""),format.raw/*234.42*/("""{"""),format.raw/*234.43*/("""
				"""),format.raw/*235.5*/("""var tbReport = $('#tbReport').dataTable();
				tbReport.fnSetColumnVis(colIndex, visible);
			"""),format.raw/*237.4*/("""}"""),format.raw/*237.5*/("""
			
			"""),format.raw/*239.4*/("""$('#modalAdvancedSearch').on('show.bs.modal', function() """),format.raw/*239.61*/("""{"""),format.raw/*239.62*/("""
				"""),format.raw/*240.5*/("""$('#frmAdvancedSearch').bootstrapValidator('resetForm', true);
				clearAdvancedSearchControls();
			"""),format.raw/*242.4*/("""}"""),format.raw/*242.5*/(""");
			
			function showHideColumns()"""),format.raw/*244.30*/("""{"""),format.raw/*244.31*/("""
				"""),format.raw/*245.5*/("""if($('#chkShowSenderAddress').prop('checked') == true)"""),format.raw/*245.59*/("""{"""),format.raw/*245.60*/("""
					"""),format.raw/*246.6*/("""fnShowHide(colSenderAddress, true);
				"""),format.raw/*247.5*/("""}"""),format.raw/*247.6*/("""else"""),format.raw/*247.10*/("""{"""),format.raw/*247.11*/("""
					"""),format.raw/*248.6*/("""fnShowHide(colSenderAddress, false);
				"""),format.raw/*249.5*/("""}"""),format.raw/*249.6*/("""
				"""),format.raw/*250.5*/("""if($('#chkShowSenderDOB').prop('checked') == true)"""),format.raw/*250.55*/("""{"""),format.raw/*250.56*/("""
					"""),format.raw/*251.6*/("""fnShowHide(colSenderDOB, true);
				"""),format.raw/*252.5*/("""}"""),format.raw/*252.6*/("""else"""),format.raw/*252.10*/("""{"""),format.raw/*252.11*/("""
					"""),format.raw/*253.6*/("""fnShowHide(colSenderDOB, false);
				"""),format.raw/*254.5*/("""}"""),format.raw/*254.6*/("""
				"""),format.raw/*255.5*/("""if($('#chkShowSenderIdentityNo').prop('checked') == true)"""),format.raw/*255.62*/("""{"""),format.raw/*255.63*/("""
					"""),format.raw/*256.6*/("""fnShowHide(colSenderIdentityNo, true);
				"""),format.raw/*257.5*/("""}"""),format.raw/*257.6*/("""else"""),format.raw/*257.10*/("""{"""),format.raw/*257.11*/("""
					"""),format.raw/*258.6*/("""fnShowHide(colSenderIdentityNo, false);
				"""),format.raw/*259.5*/("""}"""),format.raw/*259.6*/("""
				"""),format.raw/*260.5*/("""if($('#chkShowExpiredDate').prop('checked') == true)"""),format.raw/*260.57*/("""{"""),format.raw/*260.58*/("""
					"""),format.raw/*261.6*/("""fnShowHide(colExpiredDate, true);
				"""),format.raw/*262.5*/("""}"""),format.raw/*262.6*/("""else"""),format.raw/*262.10*/("""{"""),format.raw/*262.11*/("""
					"""),format.raw/*263.6*/("""fnShowHide(colExpiredDate, false);
				"""),format.raw/*264.5*/("""}"""),format.raw/*264.6*/("""
			"""),format.raw/*265.4*/("""}"""),format.raw/*265.5*/("""
			
			"""),format.raw/*267.4*/("""function clearAdvancedSearchControls()"""),format.raw/*267.42*/("""{"""),format.raw/*267.43*/("""
				"""),format.raw/*268.5*/("""$('#frmAdvancedSearch').find('input[type="text"]').each(function(index, value)"""),format.raw/*268.83*/("""{"""),format.raw/*268.84*/("""
					"""),format.raw/*269.6*/("""$(this).val('');
				"""),format.raw/*270.5*/("""}"""),format.raw/*270.6*/(""");
				$('#chkShowSenderAddress').attr('checked',false);
				$('#chkShowSenderDOB').attr('checked',false);
				$('#chkShowSenderIdentityNo').attr('checked',false);
				$('#chkShowExpiredDate').attr('checked',false);
			"""),format.raw/*275.4*/("""}"""),format.raw/*275.5*/("""

			"""),format.raw/*277.4*/("""function preparePopupBeforeShowModalCopyData(dr)"""),format.raw/*277.52*/("""{"""),format.raw/*277.53*/("""
				"""),format.raw/*278.5*/("""var result = '';
				var isColSenderAddressVisible = $('#chkShowSenderAddress').prop('checked');
				var isColBankRefVisible = $('#chkShowSenderDOB').prop('checked');
				var isColSenderFullNameVisible = $('#chkShowSenderIdentityNo').prop('checked');
				var isColCBRefVisible = $('#chkShowExpiredDate').prop('checked');

				result += 'DATE: ' + dr[colDate] + '\n'
				result += 'REF: ' + dr[colBankRef] + '\n'
				result += 'CUSTOMER\'S NAME: ' + dr[colSenderName] + '\n'
				result += 'C.B Ref.: ' + dr[colSenderCBRef] + '\n'

				if(isColSenderAddressVisible == true)"""),format.raw/*289.42*/("""{"""),format.raw/*289.43*/("""
					"""),format.raw/*290.6*/("""result += 'ADD.: ' + dr[colSenderAddress] + '\n'
				"""),format.raw/*291.5*/("""}"""),format.raw/*291.6*/("""
				"""),format.raw/*292.5*/("""if(isColBankRefVisible == true)"""),format.raw/*292.36*/("""{"""),format.raw/*292.37*/("""
					"""),format.raw/*293.6*/("""result += 'DOB.: ' + dr[colSenderDOB] + '\n'
				"""),format.raw/*294.5*/("""}"""),format.raw/*294.6*/("""
				"""),format.raw/*295.5*/("""if(isColSenderFullNameVisible == true)"""),format.raw/*295.43*/("""{"""),format.raw/*295.44*/("""
					"""),format.raw/*296.6*/("""result += 'ID/PASSPORT NO.: ' + dr[colSenderIdentityNo] + '\n'
				"""),format.raw/*297.5*/("""}"""),format.raw/*297.6*/("""
				"""),format.raw/*298.5*/("""if(isColCBRefVisible == true)"""),format.raw/*298.34*/("""{"""),format.raw/*298.35*/("""
					"""),format.raw/*299.6*/("""result += 'EXPIRED DATE: ' + dr[colExpiredDate] + '\n'
				"""),format.raw/*300.5*/("""}"""),format.raw/*300.6*/("""

				"""),format.raw/*302.5*/("""result += 'AMOUNT OUTWARD: ' + dr[colAmount] + '\n'
				result += 'CURRENCY: ' + dr[colCurrency] + '\n'
				result += 'EX.: ' + dr[colExchange] + '\n'
				result += 'Fee: ' + dr[colFee] + '\n'
				result += 'Cable: ' + dr[colCable] + '\n'
				result += 'OUR: ' + dr[colOur] + '\n'
				result += 'BENEFICIARY\'S ACC: ' + dr[colReceiverAccountNo] + '\n'
				result += 'BENEFICIARY\'S NAME: ' + dr[colReceiverFullName] + '\n'
				result += 'PURPOSE: ' + dr[colPurpose];
				
				$('#txtCopyData').val(result);
			"""),format.raw/*313.4*/("""}"""),format.raw/*313.5*/("""
				
			"""),format.raw/*315.4*/("""$("div.export-excel").append('&nbsp;<a name="btnExportExcel" id="btnExportExcel" href=""""),_display_(/*315.92*/routes/*315.98*/.ReportController.exportExcel),format.raw/*315.127*/("""" target="_blank" class="btn btn-primary pull-right disabled">Export Excel</a>');
			$("div.export-excel").append('&nbsp;<button type="button" class="btn btn-primary pull-right col-margin-right" id="btnAdvancedSearch" data-toggle="modal" data-target="#modalAdvancedSearch">Advanced Search</button>&nbsp;');
			$("div.export-excel").append('&nbsp;<button type="button" class="btn btn-primary pull-right col-margin-right" id="btnClearSearch">Clear Search</button>&nbsp;');
		    
	        
	        $("#btnClearSearch").click(function () """),format.raw/*320.49*/("""{"""),format.raw/*320.50*/("""
				"""),format.raw/*321.5*/("""clearAdvancedSearchControls();
				tbReport.fnReloadAjax();
	        """),format.raw/*323.10*/("""}"""),format.raw/*323.11*/(""");

	        function getCurrentDateString()"""),format.raw/*325.41*/("""{"""),format.raw/*325.42*/("""
	        	"""),format.raw/*326.11*/("""var d = new Date();
	        	var month = d.getMonth()+1;
	        	var day = d.getDate();
        	    var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
        	    return output;
		    """),format.raw/*331.7*/("""}"""),format.raw/*331.8*/("""
	        
		    """),format.raw/*333.7*/("""/* Validate form advanced search remittance and submit */
		    $('#frmAdvancedSearch').bootstrapValidator("""),format.raw/*334.50*/("""{"""),format.raw/*334.51*/("""
		    	"""),format.raw/*335.8*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		    	container: 'tooltip',
		        feedbackIcons: """),format.raw/*338.26*/("""{"""),format.raw/*338.27*/("""
		            """),format.raw/*339.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*342.11*/("""}"""),format.raw/*342.12*/(""",
		        fields:"""),format.raw/*343.18*/("""{"""),format.raw/*343.19*/("""
		        	"""),format.raw/*344.12*/("""searchFromDate:"""),format.raw/*344.27*/("""{"""),format.raw/*344.28*/("""
						"""),format.raw/*345.7*/("""validators:"""),format.raw/*345.18*/("""{"""),format.raw/*345.19*/("""
							"""),format.raw/*346.8*/("""date: """),format.raw/*346.14*/("""{"""),format.raw/*346.15*/("""
								"""),format.raw/*347.9*/("""format: 'DD/MM/YYYY',
								message: 'Invalid date'
							"""),format.raw/*349.8*/("""}"""),format.raw/*349.9*/("""
						"""),format.raw/*350.7*/("""}"""),format.raw/*350.8*/("""
					"""),format.raw/*351.6*/("""}"""),format.raw/*351.7*/(""",
					searchToDate:"""),format.raw/*352.19*/("""{"""),format.raw/*352.20*/("""
						"""),format.raw/*353.7*/("""validators:"""),format.raw/*353.18*/("""{"""),format.raw/*353.19*/("""
							"""),format.raw/*354.8*/("""date: """),format.raw/*354.14*/("""{"""),format.raw/*354.15*/("""
								"""),format.raw/*355.9*/("""format: 'DD/MM/YYYY',
								message: 'Invalid date'
							"""),format.raw/*357.8*/("""}"""),format.raw/*357.9*/("""
						"""),format.raw/*358.7*/("""}"""),format.raw/*358.8*/("""
					"""),format.raw/*359.6*/("""}"""),format.raw/*359.7*/("""					
			    """),format.raw/*360.8*/("""}"""),format.raw/*360.9*/("""
		    """),format.raw/*361.7*/("""}"""),format.raw/*361.8*/(""")	        
			.on('success.form.bv', function(e) """),format.raw/*362.39*/("""{"""),format.raw/*362.40*/("""
				"""),format.raw/*363.5*/("""e.preventDefault();
				tbReport.fnReloadAjax();
				showHideColumns();
				$('#modalAdvancedSearch').modal("hide");				
			"""),format.raw/*367.4*/("""}"""),format.raw/*367.5*/(""");	    
		"""),format.raw/*368.3*/("""}"""),format.raw/*368.4*/("""); /* end document ready */
		
	</script>

""")))}))}
  }

  def render(user:User,nav:String,blockingRemittanceTransactions:List[SenderReceiverTransaction],notificationInterval:String): play.twirl.api.HtmlFormat.Appendable = apply(user,nav,blockingRemittanceTransactions,notificationInterval)

  def f:((User,String,List[SenderReceiverTransaction],String) => play.twirl.api.HtmlFormat.Appendable) = (user,nav,blockingRemittanceTransactions,notificationInterval) => apply(user,nav,blockingRemittanceTransactions,notificationInterval)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:56 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/reporter/report.scala.html
                  HASH: eae54efb48c408a16ec9c7ef051f2ec7e2593604
                  MATRIX: 777->1|986->121|1013->123|1111->213|1150->215|1179->218|7014->6025|7030->6031|7111->6089|7211->6161|7227->6167|7323->6240|7423->6312|7439->6318|7517->6373|7623->6451|7639->6457|7718->6513|7821->6588|7837->6594|7902->6637|8440->7146|8470->7147|8506->7155|8927->7547|8957->7548|8990->7553|9038->7573|9067->7574|9145->7623|9175->7624|9210->7631|9239->7632|9309->7673|9339->7674|9374->7681|9403->7682|9469->7719|9499->7720|9534->7727|9563->7728|9636->7772|9666->7773|9701->7780|9730->7781|9798->7820|9828->7821|9861->7826|10136->8073|10152->8079|10213->8118|10319->8195|10349->8196|10383->8202|10646->8436|10676->8437|10724->8456|10842->8545|10872->8546|10921->8566|10962->8578|10992->8579|11022->8580|11093->8622|11123->8623|11173->8644|11203->8645|11251->8664|11350->8734|11380->8735|11432->8758|11610->8907|11640->8908|11693->8932|11734->8944|11764->8945|11794->8946|11868->8991|11898->8992|11952->9017|11982->9018|12030->9037|12060->9038|12103->9052|12133->9053|12171->9063|12200->9064|12264->9099|12294->9100|12331->9109|12498->9247|12528->9248|12563->9255|12645->9309|12675->9310|12708->9314|12738->9315|12777->9325|12853->9373|12882->9374|12918->9382|12947->9383|13055->9462|13085->9463|13119->9469|13188->9509|13218->9510|13254->9518|13378->9614|13407->9615|13442->9622|13471->9623|13503->9627|13532->9628|13610->9677|13640->9678|13673->9683|13795->9777|13824->9778|13860->9786|13946->9843|13976->9844|14009->9849|14138->9950|14167->9951|14232->9987|14262->9988|14295->9993|14378->10047|14408->10048|14442->10054|14510->10094|14539->10095|14572->10099|14602->10100|14636->10106|14705->10147|14734->10148|14767->10153|14846->10203|14876->10204|14910->10210|14974->10246|15003->10247|15036->10251|15066->10252|15100->10258|15165->10295|15194->10296|15227->10301|15313->10358|15343->10359|15377->10365|15448->10408|15477->10409|15510->10413|15540->10414|15574->10420|15646->10464|15675->10465|15708->10470|15789->10522|15819->10523|15853->10529|15919->10567|15948->10568|15981->10572|16011->10573|16045->10579|16112->10618|16141->10619|16173->10623|16202->10624|16238->10632|16305->10670|16335->10671|16368->10676|16475->10754|16505->10755|16539->10761|16588->10782|16617->10783|16864->11002|16893->11003|16926->11008|17003->11056|17033->11057|17066->11062|17666->11633|17696->11634|17730->11640|17811->11693|17840->11694|17873->11699|17933->11730|17963->11731|17997->11737|18074->11786|18103->11787|18136->11792|18203->11830|18233->11831|18267->11837|18362->11904|18391->11905|18424->11910|18482->11939|18512->11940|18546->11946|18633->12005|18662->12006|18696->12012|19234->12522|19263->12523|19300->12532|19416->12620|19432->12626|19484->12655|20049->13191|20079->13192|20112->13197|20210->13266|20240->13267|20313->13311|20343->13312|20383->13323|20651->13563|20680->13564|20725->13581|20861->13688|20891->13689|20927->13697|21088->13829|21118->13830|21162->13845|21313->13967|21343->13968|21391->13987|21421->13988|21462->14000|21506->14015|21536->14016|21571->14023|21611->14034|21641->14035|21677->14043|21712->14049|21742->14050|21779->14059|21868->14120|21897->14121|21932->14128|21961->14129|21995->14135|22024->14136|22073->14156|22103->14157|22138->14164|22178->14175|22208->14176|22244->14184|22279->14190|22309->14191|22346->14200|22435->14261|22464->14262|22499->14269|22528->14270|22562->14276|22591->14277|22632->14290|22661->14291|22696->14298|22725->14299|22803->14348|22833->14349|22866->14354|23018->14478|23047->14479|23085->14489|23114->14490
                  LINES: 26->1|29->1|30->2|30->2|30->2|32->4|173->145|173->145|173->145|174->146|174->146|174->146|175->147|175->147|175->147|176->148|176->148|176->148|178->150|178->150|178->150|201->173|201->173|203->175|211->183|211->183|212->184|213->185|213->185|213->185|213->185|214->186|214->186|214->186|214->186|215->187|215->187|215->187|215->187|216->188|216->188|216->188|216->188|217->189|217->189|217->189|217->189|218->190|227->199|227->199|227->199|229->201|229->201|230->202|231->203|231->203|232->204|233->205|233->205|234->206|234->206|234->206|234->206|234->206|234->206|235->207|235->207|236->208|236->208|236->208|237->209|239->211|239->211|240->212|240->212|240->212|240->212|240->212|240->212|241->213|241->213|242->214|242->214|243->215|243->215|244->216|244->216|245->217|245->217|246->218|248->220|248->220|249->221|250->222|250->222|250->222|250->222|251->223|252->224|252->224|253->225|253->225|254->226|254->226|255->227|255->227|255->227|256->228|258->230|258->230|259->231|259->231|260->232|260->232|262->234|262->234|263->235|265->237|265->237|267->239|267->239|267->239|268->240|270->242|270->242|272->244|272->244|273->245|273->245|273->245|274->246|275->247|275->247|275->247|275->247|276->248|277->249|277->249|278->250|278->250|278->250|279->251|280->252|280->252|280->252|280->252|281->253|282->254|282->254|283->255|283->255|283->255|284->256|285->257|285->257|285->257|285->257|286->258|287->259|287->259|288->260|288->260|288->260|289->261|290->262|290->262|290->262|290->262|291->263|292->264|292->264|293->265|293->265|295->267|295->267|295->267|296->268|296->268|296->268|297->269|298->270|298->270|303->275|303->275|305->277|305->277|305->277|306->278|317->289|317->289|318->290|319->291|319->291|320->292|320->292|320->292|321->293|322->294|322->294|323->295|323->295|323->295|324->296|325->297|325->297|326->298|326->298|326->298|327->299|328->300|328->300|330->302|341->313|341->313|343->315|343->315|343->315|343->315|348->320|348->320|349->321|351->323|351->323|353->325|353->325|354->326|359->331|359->331|361->333|362->334|362->334|363->335|366->338|366->338|367->339|370->342|370->342|371->343|371->343|372->344|372->344|372->344|373->345|373->345|373->345|374->346|374->346|374->346|375->347|377->349|377->349|378->350|378->350|379->351|379->351|380->352|380->352|381->353|381->353|381->353|382->354|382->354|382->354|383->355|385->357|385->357|386->358|386->358|387->359|387->359|388->360|388->360|389->361|389->361|390->362|390->362|391->363|395->367|395->367|396->368|396->368
                  -- GENERATED --
              */
          