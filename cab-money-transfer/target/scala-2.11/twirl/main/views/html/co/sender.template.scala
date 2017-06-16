
package views.html.co

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
object sender extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[User,String,List[SenderReceiverTransaction],String,List[CurrencyExchange],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User, nav: String, blockedRemittanceTransactions: List[SenderReceiverTransaction], notificationInterval: String, listCurrencies: List[CurrencyExchange]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import utils.DateUtils

Seq[Any](format.raw/*1.161*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("SENDER", user, nav, blockedRemittanceTransactions, null, notificationInterval, listCurrencies)/*5.102*/ {_display_(Seq[Any](format.raw/*5.104*/("""

	"""),format.raw/*7.2*/("""<div class="content-wrapper">
		<div class="page-header"><h3>List sender</h3></div>
		<table id="tbSender" class="display cell-border compact" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th width="25px">N&deg;</th>
					<th>ID</th>
					<th width="50px">Type</th>
					<th width="120px">Account No</th>
					<th width="180px">Full name</th>
					<th width="180px">Company name</th>
					<th>Address & Tel No.</th>
					<th width="70px">DOB</th>
					<th width="70px">ID/Passport</th>
					<th width="70px">Expired Date</th>
					<th width="70px">Email</th>
					<th width="40px">Blacklist</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>

	<!-- pop up create or update sender -->
	<div id="popupAddEditSender" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAddEditSender" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="popupAddEditSenderTitle">Create Sender</h4>
				</div>
				<form role="form" id="frmSender" data-toggle="validator" action=""""),_display_(/*38.71*/routes/*38.77*/.SenderController.saveOrUpdateSender()),format.raw/*38.115*/("""" method="post">
					<div class="modal-body">
						<input type="hidden" name="senderId" id="senderId" value="0"/>
						<div id="sender-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
						<div id="sender-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Sender exists</div>
						<div id="sender-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>JSON expected</div>
						<div class="row"> <!-- Row 1 -->
							<div class="col-md-6">
								<label>Type</label>
								<select class="form-control" name="senderType">
									<option value="TO721">TO721</option>
									<option value="VI731">VI731</option>
									<option value="CH741">CH741</option>
									<option value="WI888">WI888</option>
									<option value="Other">Other</option>
								</select>
							</div>
							<div class="col-md-6 form-group">
								<label class="control-label">Account No.</label>
								<input type="text" name="senderAccountNo" class="form-control" placeholder="account no."/>
							</div>
						</div>
						<div class="row"> <!-- Row 2 -->
							<div class="col-md-6 form-group">
								<label class="control-label">Full name</label>
								<input type="text" name="senderFullName" class="form-control" placeholder="full name"/>
							</div>
							<div class="col-md-6 form-group">
								<label class="control-label">Company name</label>
								<input type="text" name="senderCompanyName" class="form-control" placeholder="company name"/>
							</div>
						</div>
						<div class="row"> <!-- Row 3 -->
							<div class="col-md-6 form-group">
								<label class="control-label">Date of birth (15 < Age < 70)</label>
				                <div class="input-group">
				                    <input type="text" name="senderDateOfBirth" id="senderDateOfBirth" class="form-control" placeholder="dd/mm/yyyy"/>
				                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                </div>
							</div>	
							<div class="col-md-6 form-group">
								<label class="control-label">Email</label>
								<input type="email" name="senderEmail" class="form-control" placeholder="email"/>
							</div>						
						</div>
						<div class="row"> <!-- Row 4 -->
							<div class="col-md-12 form-group">
								<label class="control-label">Address & Tel No.</label>
								<textarea name="senderAddress" class="form-control" rows="2" placeholder="address & tel no." maxLength="255"></textarea>	
							</div>		
						</div>
<!-- 						<div class="row"> Row 5 -->
<!-- 							<div class="col-md-12 form-group"> -->
<!-- 								<label class="control-label">Reason</label> -->
<!-- 								<textarea name="senderReason" class="form-control" rows="2" placeholder="reason" maxLength="255"></textarea>	 -->
<!-- 							</div>		 -->
<!-- 						</div> -->
						<div class="row"> <!-- Row 6 -->
							<div class="col-md-6 form-group">
								<label class="control-label">ID/Passport No.</label>
								<input type="text" name="senderIdentityNo" class="form-control" placeholder="identity number"/>
							</div>	
							<div class="col-md-6 form-group">
								<label class="control-label">Expire date</label>
				                <div class="input-group">
				                    <input type="text" name="senderExpireDate" id="senderExpireDate" class="form-control" placeholder="dd/mm/yyyy"/>
				                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                </div>
							</div>		
						</div>
						<div class="row"> <!-- Row 7 -->
							<div class="col-md-6">
								<div class="row">
									<div class="col-xs-12">
										<label>Blacklist</label>
										<input type="checkbox" name="senderBlacklist" class="form-control pull-right" data-on-text="YES" data-off-text="NO" data-on-color="danger"/>
									</div>
								</div>
							</div>
						</div>						
					</div>
					<div class="modal-footer">
						<button id="btnSaveSender" type="submit" class="btn btn-primary">Save</button>
						<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end pop up create or update sender -->

	<!-- pop up sender advanced search view -->
	<div id="popupAdvancedSearchSender" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAdvancedSearchSender" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="popupAddEditSenderTitle">Advanced Search</h4>
				</div>
				<form role="form" id="frmAdvancedSearchSender" name="frmAdvancedSearchSender">
					<div class="modal-body">
						<div id="search-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Sender exists</div>
						<div id="search-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>JSON expected</div>

						<div class="row"> <!-- Row 1 -->
							<div class="col-md-6">
								<label>Type</label>
								<select class="form-control" name="searchType" placeholder="any...">
									<option value=""></option>
									<option value="TO721">TO721</option>
									<option value="VI731">VI731</option>
									<option value="CH741">CH741</option>
									<option value="WI888">WI888</option>
									<option value="Other">Other</option>
								</select>
							</div>
							<div class="col-md-6">
								<label>Account No.</label>
								<input type="text" name="searchAccountNo" class="form-control" placeholder="any..."/>
							</div>
						</div>
						<div class="row"> <!-- Row 2 -->
							<div class="col-md-6">
								<label>Full name</label>
								<input type="text" name="searchFullName" class="form-control" placeholder="any..."/>
							</div>
							<div class="col-md-6">
								<label>Company name</label>
								<input type="text" name="searchCompanyName" class="form-control" placeholder="any..."/>
							</div>
						</div>
						<div class="row"> <!-- Row 3 -->	
							<div class="col-md-6">
								<label>Email</label>
								<input type="email" name="searchEmail" class="form-control" placeholder="any..."/>
							</div>
							<div class="col-md-6">
								<label>ID/Passport No</label>
								<input type="text" name="searchIdentityNo" class="form-control" placeholder="any..."/>
							</div>					
						</div>	
						<div class="row"> <!-- Row 4 -->
							<div class="col-md-6">
								<div class="row">
									<div class="col-xs-12">
										<label>Blacklist</label>
										<input type="checkbox" name="searchBlacklist" class="form-control pull-right" data-on-text="YES" data-off-text="NO" data-on-color="danger"/>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="btnSearchSender" type="button" class="btn btn-primary">Search</button>
						<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end pop up sender advanced search view -->
	
	<!-- jQuery -->
	<script type="text/javascript" language="javascript" src=""""),_display_(/*201.61*/routes/*201.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.js")),format.raw/*201.125*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*202.61*/routes/*202.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.dataTables.min.js")),format.raw/*202.140*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*203.61*/routes/*203.67*/.Assets.at("plugins/datatables-1.10.2/fnReloadAjax.js")),format.raw/*203.122*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*204.61*/routes/*204.67*/.Assets.at("plugins/datatables-1.10.2/fnFilterClear.js")),format.raw/*204.123*/(""""></script>
	<!-- JS Bootstrap -->		
	<script type="text/javascript" src=""""),_display_(/*206.39*/routes/*206.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*206.88*/("""" defer></script>
	<!-- JS Bootstrap Switch -->
	<script type="text/javascript" src=""""),_display_(/*208.39*/routes/*208.45*/.Assets.at("bootstrap/js/bootstrap-switch.min.js")),format.raw/*208.95*/("""" defer></script>
	
	<script type="text/javascript" language="javascript">
		var colNo = 0;
		var colId = 1;
		var colType = 2; 
		var colAccountNo = 3;
		var colFullName = 4; 
		var colCompanyName = 5;
		var colAddress = 6; 
		var colDOB = 7;
		var colIdentityNo = 8; 
		var colExpiredDate = 9;
		var colEmail = 10; 
		var colBlacklist = 11; 
		
		var existAccountNo = false;
		var existFullName = false;
		var existCompanyName = false;
		var existPhone = false;
		var existIdentityNo = false;

		$(document).ready(function() """),format.raw/*230.32*/("""{"""),format.raw/*230.33*/("""
			
			"""),format.raw/*232.4*/("""var tbSender;
			/*
			* dataTables : tbSender
			*/
			tbSender = $('#tbSender').dataTable("""),format.raw/*236.40*/("""{"""),format.raw/*236.41*/("""
				"""),format.raw/*237.5*/("""columnDefs: [ 
					"""),format.raw/*238.6*/("""{"""),format.raw/*238.7*/("""targets:[colNo], sortable:false, searchable:false"""),format.raw/*238.56*/("""}"""),format.raw/*238.57*/(""",
					"""),format.raw/*239.6*/("""{"""),format.raw/*239.7*/("""targets:[colId], visible:false, searchable:false"""),format.raw/*239.55*/("""}"""),format.raw/*239.56*/(""",
					"""),format.raw/*240.6*/("""{"""),format.raw/*240.7*/("""targets:[colEmail], visible:false, searchable:false"""),format.raw/*240.58*/("""}"""),format.raw/*240.59*/("""
				"""),format.raw/*241.5*/("""],
				dom: 'l<"toolbar">rtip',
				displayLength: 10,
				pagingType: "full_numbers",
				deferLoading: 0,
	            serverSide: true,	
	            processing: true,
	            stateSave: true,
	            ajaxSource: """"),_display_(/*249.28*/routes/*249.34*/.SenderController.filterSender()),format.raw/*249.66*/("""",
				fnServerParams: function (aoData) """),format.raw/*250.39*/("""{"""),format.raw/*250.40*/("""
					"""),format.raw/*251.6*/("""$frmSenderInputWithValue = $("#frmAdvancedSearchSender").find('input[type="text"][value!=""],input[type="email"][value!=""],input[type="radio"]:checked,input[type="checkbox"]:checked,textarea[value!=""],select[value!=""]');
					$frmSenderInputWithValue.each(function () """),format.raw/*252.48*/("""{"""),format.raw/*252.49*/("""
		                """),format.raw/*253.19*/("""var that = $(this), value = that.val();
		                if (typeof value === "string") """),format.raw/*254.50*/("""{"""),format.raw/*254.51*/("""
		                	"""),format.raw/*255.20*/("""aoData.push("""),format.raw/*255.32*/("""{"""),format.raw/*255.33*/(""" """),format.raw/*255.34*/(""""name": that.attr("name"), "value": value """),format.raw/*255.76*/("""}"""),format.raw/*255.77*/(""");
		                """),format.raw/*256.19*/("""}"""),format.raw/*256.20*/("""
		                """),format.raw/*257.19*/("""else if (Object.prototype.toString.apply(value) === '[object Array]') """),format.raw/*257.89*/("""{"""),format.raw/*257.90*/("""
		                    """),format.raw/*258.23*/("""// for multi select because it has an array of selected values 
		                    var i;
		                    for (i = 0; i < value.length; i++) """),format.raw/*260.58*/("""{"""),format.raw/*260.59*/("""
		                    	"""),format.raw/*261.24*/("""aoData.push("""),format.raw/*261.36*/("""{"""),format.raw/*261.37*/(""" """),format.raw/*261.38*/(""""name": that.attr("name"), "value": value[i] """),format.raw/*261.83*/("""}"""),format.raw/*261.84*/(""");
		                    """),format.raw/*262.23*/("""}"""),format.raw/*262.24*/("""
		                """),format.raw/*263.19*/("""}"""),format.raw/*263.20*/("""
		          	"""),format.raw/*264.14*/("""}"""),format.raw/*264.15*/(""");
			    """),format.raw/*265.8*/("""}"""),format.raw/*265.9*/(""",	            
				createdRow: function ( row, data, index ) """),format.raw/*266.47*/("""{"""),format.raw/*266.48*/("""
					"""),format.raw/*267.6*/("""if ( data[colBlacklist] == true) """),format.raw/*267.39*/("""{"""),format.raw/*267.40*/("""
						"""),format.raw/*268.7*/("""$(row).addClass('blacklist-row');
					"""),format.raw/*269.6*/("""}"""),format.raw/*269.7*/("""
"""),format.raw/*270.1*/("""<!--					else if(data[colBlock] == true)"""),format.raw/*270.41*/("""{"""),format.raw/*270.42*/("""-->
<!--						$(row).addClass('block-row');-->
<!--					"""),format.raw/*272.10*/("""}"""),format.raw/*272.11*/("""-->
				"""),format.raw/*273.5*/("""}"""),format.raw/*273.6*/(""",
				fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*274.78*/("""{"""),format.raw/*274.79*/("""
					"""),format.raw/*275.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*275.46*/("""{"""),format.raw/*275.47*/(""" 
						"""),format.raw/*276.7*/("""preparePopupBeforeEditSender(aData);
						$('#popupAddEditSender').modal("show");
					"""),format.raw/*278.6*/("""}"""),format.raw/*278.7*/(""");
				"""),format.raw/*279.5*/("""}"""),format.raw/*279.6*/("""
			"""),format.raw/*280.4*/("""}"""),format.raw/*280.5*/(""");
			
			$("div.toolbar").append('&nbsp;<a id="btnAddSender" class="btn btn-primary">Add</a>');
			$("div.toolbar").append('<a data-toggle="modal" class="btn btn-primary pull-right col-margin-right" data-target="#popupAdvancedSearchSender">Advanced Search</a>');
			$('div.toolbar').append('<a id="btnClearSearch" href="#" class="btn btn-primary pull-right col-margin-right">Clear Search</a>');

			$('#popupAddUpdateRemittant .modal-header :input[type="text"]').attr('disabled', true);
			$('#popupAddUpdateRemittant .modal-body :input').attr('disabled', true);
			
			/* date picker for date of birth */
			var senderDateOfBirth = new dhtmlXCalendarObject(["senderDateOfBirth"]);
			senderDateOfBirth.setDateFormat("%d/%m/%Y");
			/* date picker for expire date */
			var senderExpireDate = new dhtmlXCalendarObject(["senderExpireDate"]);
			senderExpireDate.setDateFormat("%d/%m/%Y");

<!--			$('[name="senderBlock"]').bootstrapSwitch();-->
			$('[name="senderBlacklist"]').bootstrapSwitch();
<!--			$('[name="searchBlock"]').bootstrapSwitch();-->
			$('[name="searchBlacklist"]').bootstrapSwitch();

			$('select[name="senderType"]').on('change', function()"""),format.raw/*301.58*/("""{"""),format.raw/*301.59*/("""
				"""),format.raw/*302.5*/("""var selectedValue = $(this).val();
				switch(selectedValue)"""),format.raw/*303.26*/("""{"""),format.raw/*303.27*/("""
					case 'TO721' : 
						fillRandomAccountNumber('31221-721-');
						break;
					case 'VI731' : 
						fillRandomAccountNumber('31221-731-');
						break;
					case 'CH741' : 
						fillRandomAccountNumber('31221-741-');
						break;					
					case 'WI888' : 
						fillRandomAccountNumber('31221-888-');
						break;
					case 'Other' : 
						$('input[name="senderAccountNo"]').val('');
						break;										
				"""),format.raw/*319.5*/("""}"""),format.raw/*319.6*/("""
			"""),format.raw/*320.4*/("""}"""),format.raw/*320.5*/(""");

			$('#popupAdvancedSearchSender').on('hide.bs.modal', function() """),format.raw/*322.67*/("""{"""),format.raw/*322.68*/("""
				"""),format.raw/*323.5*/("""clearSenderAdvancedSearchControls();
			"""),format.raw/*324.4*/("""}"""),format.raw/*324.5*/(""");

			function clearSenderAdvancedSearchControls()"""),format.raw/*326.48*/("""{"""),format.raw/*326.49*/("""
				"""),format.raw/*327.5*/("""$('select[name="searchType"]').val('');
				$('input[name="searchAccountNo"]').val('');
				$('input[name="searchFullName"]').val('');
				$('input[name="searchCompanyName"]').val('');
				$('input[name="searchEmail"]').val('');
				$('input[name="searchPhone"]').val('');
				$('input[name="searchIdentityNo"]').val('');
<!--				$("input[name='searchBlock']").bootstrapSwitch('state', false);-->
				$("input[name='searchBlacklist']").bootstrapSwitch('state', false);
			"""),format.raw/*336.4*/("""}"""),format.raw/*336.5*/("""
			
			"""),format.raw/*338.4*/("""$("#btnClearSearch").click(function () """),format.raw/*338.43*/("""{"""),format.raw/*338.44*/("""
				"""),format.raw/*339.5*/("""//tbSender.fnFilterClear();
				tbSender.fnReloadAjax(""""),_display_(/*340.29*/routes/*340.35*/.SenderController.filterSender()),format.raw/*340.67*/("""");
	        """),format.raw/*341.10*/("""}"""),format.raw/*341.11*/(""");
			
			$("#btnSearchSender").click(function () """),format.raw/*343.44*/("""{"""),format.raw/*343.45*/("""
				"""),format.raw/*344.5*/("""tbSender.fnReloadAjax(""""),_display_(/*344.29*/routes/*344.35*/.SenderController.filterSender()),format.raw/*344.67*/("""" + "?" + $("#frmAdvancedSearchSender").serialize());
				$('#popupAdvancedSearchSender').modal("hide");
	        """),format.raw/*346.10*/("""}"""),format.raw/*346.11*/(""");

			var countRecalculateRandom = 1;
			function fillRandomAccountNumber(accountPrefix)"""),format.raw/*349.51*/("""{"""),format.raw/*349.52*/("""
				"""),format.raw/*350.5*/("""var random1 = getRandomArbitrary(100, 99999);
				var random2 = getRandomArbitrary(1, 9);
				var random = $.strPad(random1, 5) + '-' + random2;
				var generatedAccountNo = accountPrefix + random;
				$.ajax("""),format.raw/*354.12*/("""{"""),format.raw/*354.13*/("""
	       			"""),format.raw/*355.12*/("""url: '"""),_display_(/*355.19*/routes/*355.25*/.SenderController.checkAccount()),format.raw/*355.57*/("""' + '?accountNo=' + generatedAccountNo,
	       			type: 'get',
	       			success: function(response) """),format.raw/*357.40*/("""{"""),format.raw/*357.41*/("""
	       				"""),format.raw/*358.13*/("""if(response == '1')"""),format.raw/*358.32*/("""{"""),format.raw/*358.33*/("""
		       				"""),format.raw/*359.14*/("""if(countRecalculateRandom < 10)"""),format.raw/*359.45*/("""{"""),format.raw/*359.46*/("""
		       					"""),format.raw/*360.15*/("""fillRandomAccountNumber(accountPrefix);
			       			"""),format.raw/*361.14*/("""}"""),format.raw/*361.15*/("""else"""),format.raw/*361.19*/("""{"""),format.raw/*361.20*/("""
				       			"""),format.raw/*362.15*/("""bootbox.alert('Random Account No. still exists with 10 times recalculation!', function() """),format.raw/*362.104*/("""{"""),format.raw/*362.105*/("""
									"""),format.raw/*363.10*/("""return;
					       		"""),format.raw/*364.15*/("""}"""),format.raw/*364.16*/(""");
				       		"""),format.raw/*365.14*/("""}"""),format.raw/*365.15*/("""
	       					"""),format.raw/*366.14*/("""countRecalculateRandom++;
				       	"""),format.raw/*367.13*/("""}"""),format.raw/*367.14*/("""else"""),format.raw/*367.18*/("""{"""),format.raw/*367.19*/("""
				       		"""),format.raw/*368.14*/("""$('input[name="senderAccountNo"]').val(generatedAccountNo);
					    """),format.raw/*369.10*/("""}"""),format.raw/*369.11*/("""
		       		"""),format.raw/*370.12*/("""}"""),format.raw/*370.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*371.62*/("""{"""),format.raw/*371.63*/("""
		            	"""),format.raw/*372.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*372.102*/("""{"""),format.raw/*372.103*/("""}"""),format.raw/*372.104*/(""");
		            """),format.raw/*373.15*/("""}"""),format.raw/*373.16*/("""
		       	"""),format.raw/*374.11*/("""}"""),format.raw/*374.12*/(""");				
			"""),format.raw/*375.4*/("""}"""),format.raw/*375.5*/("""

			"""),format.raw/*377.4*/("""function getRandomArbitrary(min, max) """),format.raw/*377.42*/("""{"""),format.raw/*377.43*/("""
				"""),format.raw/*378.5*/("""return Math.floor(Math.random() * (max - min)) + min;
			"""),format.raw/*379.4*/("""}"""),format.raw/*379.5*/("""

			"""),format.raw/*381.4*/("""$.strPad = function(input,length) """),format.raw/*381.38*/("""{"""),format.raw/*381.39*/("""
				"""),format.raw/*382.5*/("""var result = input.toString();
				while (result.length < length) """),format.raw/*383.36*/("""{"""),format.raw/*383.37*/("""
					"""),format.raw/*384.6*/("""result = '0' + result;
				"""),format.raw/*385.5*/("""}"""),format.raw/*385.6*/("""
				"""),format.raw/*386.5*/("""return result;
			"""),format.raw/*387.4*/("""}"""),format.raw/*387.5*/(""";

			/*
			* on submit form advanced search sender
			*/
			$('form#frmAdvancedSearchSender').on('submit', function(e)"""),format.raw/*392.62*/("""{"""),format.raw/*392.63*/("""
				
"""),format.raw/*394.1*/("""// 				var that = $(this);
// 					url = that.attr('action'),
// 					type = that.attr('method'),
// 				advanceSearchData = """),format.raw/*397.28*/("""{"""),format.raw/*397.29*/("""}"""),format.raw/*397.30*/(""";
// 				that.find('[name]').each(function(index, value)"""),format.raw/*398.55*/("""{"""),format.raw/*398.56*/("""
"""),format.raw/*399.1*/("""// 					var that = $(this),
// 						name = that.attr('name'),
// 						value = that.val();
// 					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*402.71*/("""{"""),format.raw/*402.72*/("""
"""),format.raw/*403.1*/("""// 						advanceSearchData[name] = that.prop('checked');
// 					"""),format.raw/*404.9*/("""}"""),format.raw/*404.10*/("""else"""),format.raw/*404.14*/("""{"""),format.raw/*404.15*/("""
"""),format.raw/*405.1*/("""// 						advanceSearchData[name] = value;
// 					"""),format.raw/*406.9*/("""}"""),format.raw/*406.10*/("""
"""),format.raw/*407.1*/("""// 				"""),format.raw/*407.8*/("""}"""),format.raw/*407.9*/(""");
// 				data['updateTime'] = new Date().getTime();
				e.preventDefault(); //STOP default action
				
				
			    e.unbind(); //unbind. to stop multiple form submit
				return false;
				
// 				$.ajax("""),format.raw/*415.15*/("""{"""),format.raw/*415.16*/("""
"""),format.raw/*416.1*/("""// 	       			url: url,
// 	       			type: type,
// 	       			dataType: 'json',
// 	       			data: JSON.stringify(data),
// 	       			contentType : "application/json",
// 	       			success: function(response) """),format.raw/*421.43*/("""{"""),format.raw/*421.44*/("""
"""),format.raw/*422.1*/("""// 	       				if(response == 'json_expected')"""),format.raw/*422.47*/("""{"""),format.raw/*422.48*/("""
"""),format.raw/*423.1*/("""// 				       		$('#search-alert-danger').removeClass('hidden');
// 			       			setTimeout(function()"""),format.raw/*424.38*/("""{"""),format.raw/*424.39*/("""
"""),format.raw/*425.1*/("""// 			       				$('#search-alert-danger').addClass('hidden');
// 			       			"""),format.raw/*426.17*/("""}"""),format.raw/*426.18*/(""", 3000);
// 					    """),format.raw/*427.13*/("""}"""),format.raw/*427.14*/("""
"""),format.raw/*428.1*/("""// <!--					    else"""),format.raw/*428.21*/("""{"""),format.raw/*428.22*/("""-->
// <!--				       		$('#popupAdvancedSearchSender').modal("hide");-->
// <!--				       		location.reload();-->
// <!--			       		"""),format.raw/*431.20*/("""}"""),format.raw/*431.21*/("""-->
// 		       		"""),format.raw/*432.15*/("""}"""),format.raw/*432.16*/(""",
// 		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*433.65*/("""{"""),format.raw/*433.66*/("""
"""),format.raw/*434.1*/("""// 			            bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*434.105*/("""{"""),format.raw/*434.106*/("""}"""),format.raw/*434.107*/(""");
// 		            """),format.raw/*435.18*/("""}"""),format.raw/*435.19*/("""
"""),format.raw/*436.1*/("""// 		       	"""),format.raw/*436.14*/("""}"""),format.raw/*436.15*/(""");
  
	       				
			"""),format.raw/*439.4*/("""}"""),format.raw/*439.5*/(""");
			/* end submit form advanced search sender */

			function preparePopupBeforeEditSender(dr)"""),format.raw/*442.45*/("""{"""),format.raw/*442.46*/("""
				"""),format.raw/*443.5*/("""$('#popupAddEditSenderTitle').html('Edit Sender');
				$('#btnSaveSender').html('Update');
				$('#senderId').val(dr[colId]);
				$("select[name='senderType']").val(dr[colType]);
				$("input[name='senderAccountNo']").val(dr[colAccountNo]);
				$("input[name='senderFullName']").val(dr[colFullName]);
				$("input[name='senderCompanyName']").val(dr[colCompanyName]);
				$("textarea[name='senderAddress']").val(dr[colAddress]);
				$("input[name='senderDateOfBirth']").val(dr[colDOB]);
				$("input[name='senderIdentityNo']").val(dr[colIdentityNo]);
				$("input[name='senderExpireDate']").val(dr[colExpiredDate]);
				$("input[name='senderEmail']").val(dr[colEmail]);
				$("input[name='senderBlacklist']").bootstrapSwitch('state', (dr[colBlacklist] === true));

				/* disable Sender Type if the sender is in remittance transaction */
				$.ajax("""),format.raw/*458.12*/("""{"""),format.raw/*458.13*/("""
	       			"""),format.raw/*459.12*/("""url: '"""),_display_(/*459.19*/routes/*459.25*/.SenderController.isInTransaction()),format.raw/*459.60*/("""' + '?senderId=' + $('#senderId').val(),
	       			type: 'get',
	       			success: function(response) """),format.raw/*461.40*/("""{"""),format.raw/*461.41*/("""
						"""),format.raw/*462.7*/("""if(response == '1')"""),format.raw/*462.26*/("""{"""),format.raw/*462.27*/(""" """),format.raw/*462.28*/("""// the sender is in transaction, so don't allow user to change type 
							$('select[name="senderType"]').prop("disabled", true);
						"""),format.raw/*464.7*/("""}"""),format.raw/*464.8*/("""else"""),format.raw/*464.12*/("""{"""),format.raw/*464.13*/("""
							"""),format.raw/*465.8*/("""$('select[name="senderType"]').prop("disabled", false);
						"""),format.raw/*466.7*/("""}"""),format.raw/*466.8*/("""
		       		"""),format.raw/*467.12*/("""}"""),format.raw/*467.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*468.62*/("""{"""),format.raw/*468.63*/("""
		            	"""),format.raw/*469.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*469.102*/("""{"""),format.raw/*469.103*/("""}"""),format.raw/*469.104*/(""");
		            """),format.raw/*470.15*/("""}"""),format.raw/*470.16*/("""
		       	"""),format.raw/*471.11*/("""}"""),format.raw/*471.12*/(""");				
			"""),format.raw/*472.4*/("""}"""),format.raw/*472.5*/("""
			
			"""),format.raw/*474.4*/("""$('#btnAddSender').click(function()"""),format.raw/*474.39*/("""{"""),format.raw/*474.40*/("""
				"""),format.raw/*475.5*/("""preparePopupBeforeAddSender();
				$('#popupAddEditSender').modal("show");
			"""),format.raw/*477.4*/("""}"""),format.raw/*477.5*/(""");

			function preparePopupBeforeAddSender()"""),format.raw/*479.42*/("""{"""),format.raw/*479.43*/("""
				"""),format.raw/*480.5*/("""clearPopupControls();
				$('#popupAddEditSenderTitle').html('Create Sender');
				$('#btnSaveSender').html('Save');
			"""),format.raw/*483.4*/("""}"""),format.raw/*483.5*/("""

			"""),format.raw/*485.4*/("""function clearPopupControls()"""),format.raw/*485.33*/("""{"""),format.raw/*485.34*/("""
				"""),format.raw/*486.5*/("""$('#frmSender').bootstrapValidator('resetForm', true);
				$('#senderId').val('0');
				$("select[name='senderType']").val('Other');
				$("input[name='senderBlacklist']").bootstrapSwitch('state', false);
			"""),format.raw/*490.4*/("""}"""),format.raw/*490.5*/("""
			
			"""),format.raw/*492.4*/("""$('#popupAddEditSender').on('hide.bs.modal', function () """),format.raw/*492.61*/("""{"""),format.raw/*492.62*/("""
				"""),format.raw/*493.5*/("""$('#frmSender').bootstrapValidator('resetForm', true);
				$('select[name="senderType"]').prop("disabled", false);
			"""),format.raw/*495.4*/("""}"""),format.raw/*495.5*/(""");
			senderDateOfBirth.attachEvent("onClick", function(date)"""),format.raw/*496.59*/("""{"""),format.raw/*496.60*/("""
				"""),format.raw/*497.5*/("""$('#frmSender').bootstrapValidator('revalidateField', 'senderFullName');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderDateOfBirth');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderIdentityNo');
			"""),format.raw/*500.4*/("""}"""),format.raw/*500.5*/(""");
			$('input[name="senderIdentityNo"]').on('input',function()"""),format.raw/*501.61*/("""{"""),format.raw/*501.62*/("""
				"""),format.raw/*502.5*/("""$('#frmSender').bootstrapValidator('revalidateField', 'senderDateOfBirth');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderIdentityNo');	
				$('#frmSender').bootstrapValidator('revalidateField', 'senderExpireDate');			
			"""),format.raw/*505.4*/("""}"""),format.raw/*505.5*/(""");
			senderExpireDate.attachEvent("onClick", function(date)"""),format.raw/*506.58*/("""{"""),format.raw/*506.59*/("""
				"""),format.raw/*507.5*/("""$('#frmSender').bootstrapValidator('revalidateField', 'senderIdentityNo');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderExpireDate');
			"""),format.raw/*509.4*/("""}"""),format.raw/*509.5*/(""");
			$('input[name="senderFullName"]').on('input',function()"""),format.raw/*510.59*/("""{"""),format.raw/*510.60*/("""
				"""),format.raw/*511.5*/("""$('#frmSender').bootstrapValidator('revalidateField', 'senderFullName');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderCompanyName');	
			"""),format.raw/*513.4*/("""}"""),format.raw/*513.5*/(""");
			$('input[name="senderCompanyName"]').on('input',function()"""),format.raw/*514.62*/("""{"""),format.raw/*514.63*/("""
				"""),format.raw/*515.5*/("""$('#frmSender').bootstrapValidator('revalidateField', 'senderFullName');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderCompanyName');	
				$('#frmSender').bootstrapValidator('revalidateField', 'senderDateOfBirth');
				$('#frmSender').bootstrapValidator('revalidateField', 'senderIdentityNo');
			"""),format.raw/*519.4*/("""}"""),format.raw/*519.5*/(""");
		    /* Validate form Sender and submit */
		    $('#frmSender').bootstrapValidator("""),format.raw/*521.42*/("""{"""),format.raw/*521.43*/("""
		    	"""),format.raw/*522.8*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		    	container: 'tooltip',
		        feedbackIcons: """),format.raw/*525.26*/("""{"""),format.raw/*525.27*/("""
		            """),format.raw/*526.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*529.11*/("""}"""),format.raw/*529.12*/(""",
		        fields: """),format.raw/*530.19*/("""{"""),format.raw/*530.20*/("""
			        """),format.raw/*531.12*/("""senderFullName: """),format.raw/*531.28*/("""{"""),format.raw/*531.29*/("""
			        	"""),format.raw/*532.13*/("""validators: """),format.raw/*532.25*/("""{"""),format.raw/*532.26*/("""
		        			"""),format.raw/*533.14*/("""callback: """),format.raw/*533.24*/("""{"""),format.raw/*533.25*/("""
		    					"""),format.raw/*534.12*/("""callback: function(value, validator, $field) """),format.raw/*534.57*/("""{"""),format.raw/*534.58*/("""
			    					"""),format.raw/*535.13*/("""var companyName = $('input[name="senderCompanyName"]').val();
		    						if (value === '' && companyName === '' ) """),format.raw/*536.54*/("""{"""),format.raw/*536.55*/("""
		    							"""),format.raw/*537.14*/("""return """),format.raw/*537.21*/("""{"""),format.raw/*537.22*/("""
		    								"""),format.raw/*538.15*/("""valid: false,
		    								message: 'Required when company name is empty.'
		    							"""),format.raw/*540.14*/("""}"""),format.raw/*540.15*/("""
		    						"""),format.raw/*541.13*/("""}"""),format.raw/*541.14*/("""else"""),format.raw/*541.18*/("""{"""),format.raw/*541.19*/("""
			    						"""),format.raw/*542.14*/("""if(existFullName == true)"""),format.raw/*542.39*/("""{"""),format.raw/*542.40*/("""
			    							"""),format.raw/*543.15*/("""return """),format.raw/*543.22*/("""{"""),format.raw/*543.23*/("""
			    					            """),format.raw/*544.25*/("""valid: false,
			    					            message: 'Sender with this name and date of birth already exists'
			    					        """),format.raw/*546.21*/("""}"""),format.raw/*546.22*/("""
					    				"""),format.raw/*547.14*/("""}"""),format.raw/*547.15*/("""else"""),format.raw/*547.19*/("""{"""),format.raw/*547.20*/("""
											"""),format.raw/*548.12*/("""return true;
						    			"""),format.raw/*549.14*/("""}"""),format.raw/*549.15*/("""
			    					"""),format.raw/*550.13*/("""}"""),format.raw/*550.14*/("""
		    					"""),format.raw/*551.12*/("""}"""),format.raw/*551.13*/("""		        				
		        			"""),format.raw/*552.14*/("""}"""),format.raw/*552.15*/("""
			        	"""),format.raw/*553.13*/("""}"""),format.raw/*553.14*/("""
				    """),format.raw/*554.9*/("""}"""),format.raw/*554.10*/(""",
			        senderCompanyName: """),format.raw/*555.31*/("""{"""),format.raw/*555.32*/("""
			        	"""),format.raw/*556.13*/("""validators: """),format.raw/*556.25*/("""{"""),format.raw/*556.26*/("""
		        			"""),format.raw/*557.14*/("""callback: """),format.raw/*557.24*/("""{"""),format.raw/*557.25*/("""
		    					"""),format.raw/*558.12*/("""callback: function(value, validator, $field) """),format.raw/*558.57*/("""{"""),format.raw/*558.58*/("""
			    					"""),format.raw/*559.13*/("""var fullName = $('input[name="senderFullName"]').val();
		    						if (value === '' && fullName === '' ) """),format.raw/*560.51*/("""{"""),format.raw/*560.52*/("""
		    					        """),format.raw/*561.20*/("""return """),format.raw/*561.27*/("""{"""),format.raw/*561.28*/("""
		    					            """),format.raw/*562.24*/("""valid: false,
		    					            message: 'Required when full name is empty.'
		    					        """),format.raw/*564.20*/("""}"""),format.raw/*564.21*/("""
		    						"""),format.raw/*565.13*/("""}"""),format.raw/*565.14*/("""else"""),format.raw/*565.18*/("""{"""),format.raw/*565.19*/("""
			    						"""),format.raw/*566.14*/("""if(existCompanyName == true)"""),format.raw/*566.42*/("""{"""),format.raw/*566.43*/("""
			    							"""),format.raw/*567.15*/("""return """),format.raw/*567.22*/("""{"""),format.raw/*567.23*/("""
			    					            """),format.raw/*568.25*/("""valid: false,
			    					            message: 'Sender as this company already exists'
			    					        """),format.raw/*570.21*/("""}"""),format.raw/*570.22*/("""
					    				"""),format.raw/*571.14*/("""}"""),format.raw/*571.15*/("""else"""),format.raw/*571.19*/("""{"""),format.raw/*571.20*/("""
											"""),format.raw/*572.12*/("""return true;
						    			"""),format.raw/*573.14*/("""}"""),format.raw/*573.15*/("""
			    					"""),format.raw/*574.13*/("""}"""),format.raw/*574.14*/("""
		    					"""),format.raw/*575.12*/("""}"""),format.raw/*575.13*/("""		        				
		        			"""),format.raw/*576.14*/("""}"""),format.raw/*576.15*/("""
			        	"""),format.raw/*577.13*/("""}"""),format.raw/*577.14*/("""
				    """),format.raw/*578.9*/("""}"""),format.raw/*578.10*/(""",
		        	senderDateOfBirth: """),format.raw/*579.31*/("""{"""),format.raw/*579.32*/("""
		        		"""),format.raw/*580.13*/("""validators: """),format.raw/*580.25*/("""{"""),format.raw/*580.26*/("""
		        			"""),format.raw/*581.14*/("""callback: """),format.raw/*581.24*/("""{"""),format.raw/*581.25*/("""
		        				"""),format.raw/*582.15*/("""message: 'Required when ID/Passport No is empty.',
		    					callback: function(value, validator, $field) """),format.raw/*583.57*/("""{"""),format.raw/*583.58*/("""
			    					"""),format.raw/*584.13*/("""var IDOrPassport = $('input[name="senderIdentityNo"]').val();
			    					var companyName = $('input[name="senderCompanyName"]').val();
		    						if (value === '' && IDOrPassport === '' && companyName === '') """),format.raw/*586.76*/("""{"""),format.raw/*586.77*/("""
		    							"""),format.raw/*587.14*/("""return false;
		    						"""),format.raw/*588.13*/("""}"""),format.raw/*588.14*/("""else"""),format.raw/*588.18*/("""{"""),format.raw/*588.19*/("""
										"""),format.raw/*589.11*/("""return true;
			    					"""),format.raw/*590.13*/("""}"""),format.raw/*590.14*/("""
		    					"""),format.raw/*591.12*/("""}"""),format.raw/*591.13*/("""		        				
		        			"""),format.raw/*592.14*/("""}"""),format.raw/*592.15*/(""",
		        			date: """),format.raw/*593.20*/("""{"""),format.raw/*593.21*/("""
		        				"""),format.raw/*594.15*/("""format: 'DD/MM/YYYY',
		        				message: 'Invalid date'
		        			"""),format.raw/*596.14*/("""}"""),format.raw/*596.15*/("""		        			
		        		"""),format.raw/*597.13*/("""}"""),format.raw/*597.14*/("""
			        """),format.raw/*598.12*/("""}"""),format.raw/*598.13*/(""",
			        senderIdentityNo: """),format.raw/*599.30*/("""{"""),format.raw/*599.31*/("""
		        		"""),format.raw/*600.13*/("""validators: """),format.raw/*600.25*/("""{"""),format.raw/*600.26*/("""
		        			"""),format.raw/*601.14*/("""callback: """),format.raw/*601.24*/("""{"""),format.raw/*601.25*/("""
		    					"""),format.raw/*602.12*/("""callback: function(value, validator, $field) """),format.raw/*602.57*/("""{"""),format.raw/*602.58*/("""
			    					"""),format.raw/*603.13*/("""var dateOfBirth = $('input[name="senderDateOfBirth"]').val();
			    					var companyName = $('input[name="senderCompanyName"]').val();
		    						if (value === '' && dateOfBirth === '' && companyName === '') """),format.raw/*605.75*/("""{"""),format.raw/*605.76*/("""
		    							"""),format.raw/*606.14*/("""return """),format.raw/*606.21*/("""{"""),format.raw/*606.22*/("""
		    								"""),format.raw/*607.15*/("""valid: false,
		    								message: 'Required when Date of Birth is empty.'
		    							"""),format.raw/*609.14*/("""}"""),format.raw/*609.15*/("""
		    						"""),format.raw/*610.13*/("""}"""),format.raw/*610.14*/("""else"""),format.raw/*610.18*/("""{"""),format.raw/*610.19*/("""
			    						"""),format.raw/*611.14*/("""if(existIdentityNo == true)"""),format.raw/*611.41*/("""{"""),format.raw/*611.42*/("""
			    							"""),format.raw/*612.15*/("""return """),format.raw/*612.22*/("""{"""),format.raw/*612.23*/("""
			    					            """),format.raw/*613.25*/("""valid: false,
			    					            message: 'Sender with this ID/Passport No. already exists'
			    					        """),format.raw/*615.21*/("""}"""),format.raw/*615.22*/("""
					    				"""),format.raw/*616.14*/("""}"""),format.raw/*616.15*/("""else"""),format.raw/*616.19*/("""{"""),format.raw/*616.20*/("""
											"""),format.raw/*617.12*/("""return true;
						    			"""),format.raw/*618.14*/("""}"""),format.raw/*618.15*/("""
			    					"""),format.raw/*619.13*/("""}"""),format.raw/*619.14*/("""
		    					"""),format.raw/*620.12*/("""}"""),format.raw/*620.13*/("""		        				
		        			"""),format.raw/*621.14*/("""}"""),format.raw/*621.15*/("""
		        		"""),format.raw/*622.13*/("""}"""),format.raw/*622.14*/("""
			        """),format.raw/*623.12*/("""}"""),format.raw/*623.13*/(""",
			        senderExpireDate: """),format.raw/*624.30*/("""{"""),format.raw/*624.31*/("""
		        		"""),format.raw/*625.13*/("""validators: """),format.raw/*625.25*/("""{"""),format.raw/*625.26*/("""
		        			"""),format.raw/*626.14*/("""callback: """),format.raw/*626.24*/("""{"""),format.raw/*626.25*/("""
		        				"""),format.raw/*627.15*/("""message: 'Please specify the expired date for the ID/Passport no.',
		    					callback: function(value, validator, $field) """),format.raw/*628.57*/("""{"""),format.raw/*628.58*/("""
			    					"""),format.raw/*629.13*/("""var IDOrPassport = $('input[name="senderIdentityNo"]').val();
		    						if (value === '' && IDOrPassport != '' ) """),format.raw/*630.54*/("""{"""),format.raw/*630.55*/("""
		    							"""),format.raw/*631.14*/("""return false;
		    						"""),format.raw/*632.13*/("""}"""),format.raw/*632.14*/("""else"""),format.raw/*632.18*/("""{"""),format.raw/*632.19*/("""
										"""),format.raw/*633.11*/("""return true;
			    					"""),format.raw/*634.13*/("""}"""),format.raw/*634.14*/("""
		    					"""),format.raw/*635.12*/("""}"""),format.raw/*635.13*/("""		        				
		        			"""),format.raw/*636.14*/("""}"""),format.raw/*636.15*/(""",
		        			date: """),format.raw/*637.20*/("""{"""),format.raw/*637.21*/("""
		        				"""),format.raw/*638.15*/("""format: 'DD/MM/YYYY',
		        				message: 'Invalid date'
		        			"""),format.raw/*640.14*/("""}"""),format.raw/*640.15*/("""		        			
		        		"""),format.raw/*641.13*/("""}"""),format.raw/*641.14*/("""
			        """),format.raw/*642.12*/("""}"""),format.raw/*642.13*/(""",
			        senderAccountNo: """),format.raw/*643.29*/("""{"""),format.raw/*643.30*/("""
		        		"""),format.raw/*644.13*/("""validators: """),format.raw/*644.25*/("""{"""),format.raw/*644.26*/("""
		        			"""),format.raw/*645.14*/("""callback: """),format.raw/*645.24*/("""{"""),format.raw/*645.25*/("""
		    					"""),format.raw/*646.12*/("""callback: function(value, validator, $field) """),format.raw/*646.57*/("""{"""),format.raw/*646.58*/("""
		    						"""),format.raw/*647.13*/("""if(existAccountNo == true)"""),format.raw/*647.39*/("""{"""),format.raw/*647.40*/("""
		    							"""),format.raw/*648.14*/("""return """),format.raw/*648.21*/("""{"""),format.raw/*648.22*/("""
		    					            """),format.raw/*649.24*/("""valid: false,
		    					            message: 'Sender with this Account No. already exists'
		    					        """),format.raw/*651.20*/("""}"""),format.raw/*651.21*/("""
				    				"""),format.raw/*652.13*/("""}"""),format.raw/*652.14*/("""else"""),format.raw/*652.18*/("""{"""),format.raw/*652.19*/("""
										"""),format.raw/*653.11*/("""return true;
					    			"""),format.raw/*654.13*/("""}"""),format.raw/*654.14*/("""
		    					"""),format.raw/*655.12*/("""}"""),format.raw/*655.13*/("""		        				
		        			"""),format.raw/*656.14*/("""}"""),format.raw/*656.15*/("""
		        		"""),format.raw/*657.13*/("""}"""),format.raw/*657.14*/("""
			        """),format.raw/*658.12*/("""}"""),format.raw/*658.13*/("""
			    """),format.raw/*659.8*/("""}"""),format.raw/*659.9*/("""
		    """),format.raw/*660.7*/("""}"""),format.raw/*660.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*661.42*/("""{"""),format.raw/*661.43*/("""
		    	"""),format.raw/*662.8*/("""e.preventDefault(); // Prevent submit form 
				var that = $(this),
				url = that.attr('action'),
				type = that.attr('method'),
				data = """),format.raw/*666.12*/("""{"""),format.raw/*666.13*/("""}"""),format.raw/*666.14*/(""";
				that.find('[name]').each(function(index, value)"""),format.raw/*667.52*/("""{"""),format.raw/*667.53*/("""
					"""),format.raw/*668.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*671.68*/("""{"""),format.raw/*671.69*/("""
						"""),format.raw/*672.7*/("""data[name] = that.prop('checked');
					"""),format.raw/*673.6*/("""}"""),format.raw/*673.7*/("""else"""),format.raw/*673.11*/("""{"""),format.raw/*673.12*/("""
						"""),format.raw/*674.7*/("""data[name] = value;
					"""),format.raw/*675.6*/("""}"""),format.raw/*675.7*/("""
				"""),format.raw/*676.5*/("""}"""),format.raw/*676.6*/(""");
				data['updateTime'] = new Date().getTime();
				$.ajax("""),format.raw/*678.12*/("""{"""),format.raw/*678.13*/("""
	       			"""),format.raw/*679.12*/("""url: url,
	       			type: type,
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*684.40*/("""{"""),format.raw/*684.41*/("""
	       				"""),format.raw/*685.13*/("""if(response.indexOf("sender_exists") != -1)"""),format.raw/*685.56*/("""{"""),format.raw/*685.57*/("""
	       					"""),format.raw/*686.14*/("""$('#sender-alert-warning').removeClass('hidden');
	       					$("#sender-alert-warning").slideDown("slow");
	       					var existField = response.split("||")[1];
	       					switch(existField)"""),format.raw/*689.32*/("""{"""),format.raw/*689.33*/("""
	       						case 'senderAccountNo' : 
		       						existAccountNo = true;
	       							$('#frmSender').bootstrapValidator('revalidateField', 'senderAccountNo'); 
	       							existAccountNo = false; break;
	       						case 'senderFullName' : 
		       						existFullName = true;
	       							$('#frmSender').bootstrapValidator('revalidateField', 'senderFullName'); 
	       							existFullName = false; break;
	       						case 'senderCompanyName' : 
		       						existCompanyName = true;
	       							$('#frmSender').bootstrapValidator('revalidateField', 'senderCompanyName'); 
	       							existCompanyName = false; break;
	       						case 'senderIdentityNo' : 
		       						existIdentityNo = true;
	       							$('#frmSender').bootstrapValidator('revalidateField', 'senderIdentityNo'); 
	       							existIdentityNo = false; break;       							      								       							
	       					"""),format.raw/*706.14*/("""}"""),format.raw/*706.15*/("""
			       			"""),format.raw/*707.14*/("""window.setTimeout(function()"""),format.raw/*707.42*/("""{"""),format.raw/*707.43*/("""$("#sender-alert-warning").slideUp("slow");"""),format.raw/*707.86*/("""}"""),format.raw/*707.87*/(""",3000);
				       	"""),format.raw/*708.13*/("""}"""),format.raw/*708.14*/("""else if(response == 'json_expected')"""),format.raw/*708.50*/("""{"""),format.raw/*708.51*/("""
				       		"""),format.raw/*709.14*/("""$('#sender-alert-danger').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*710.35*/("""{"""),format.raw/*710.36*/("""
			       				"""),format.raw/*711.15*/("""$('#sender-alert-danger').addClass('hidden');
			       			"""),format.raw/*712.14*/("""}"""),format.raw/*712.15*/(""", 3000);
					    """),format.raw/*713.10*/("""}"""),format.raw/*713.11*/("""else"""),format.raw/*713.15*/("""{"""),format.raw/*713.16*/("""
					    	"""),format.raw/*714.11*/("""tbSender.fnReloadAjax();
			       			$('#sender-alert-success').removeClass('hidden');
					    	$("#sender-alert-success").slideDown("slow");
							window.setTimeout(function()"""),format.raw/*717.36*/("""{"""),format.raw/*717.37*/("""$("#sender-alert-success").slideUp("slow");"""),format.raw/*717.80*/("""}"""),format.raw/*717.81*/(""",2000);
							$('#frmSender').data('bootstrapValidator').resetForm();
							$('#frmSender').find('input,textarea').val("");
							$('select[name="senderType"]').val('Other');
			       		"""),format.raw/*721.13*/("""}"""),format.raw/*721.14*/("""
		       		"""),format.raw/*722.12*/("""}"""),format.raw/*722.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*723.62*/("""{"""),format.raw/*723.63*/("""
		            	"""),format.raw/*724.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*724.102*/("""{"""),format.raw/*724.103*/("""}"""),format.raw/*724.104*/(""");
		            """),format.raw/*725.15*/("""}"""),format.raw/*725.16*/("""
		       	"""),format.raw/*726.11*/("""}"""),format.raw/*726.12*/(""");
	       		return false;
		    """),format.raw/*728.7*/("""}"""),format.raw/*728.8*/(""");			
		    
		"""),format.raw/*730.3*/("""}"""),format.raw/*730.4*/("""); /* end document ready */

	</script>

""")))}))}
  }

  def render(user:User,nav:String,blockedRemittanceTransactions:List[SenderReceiverTransaction],notificationInterval:String,listCurrencies:List[CurrencyExchange]): play.twirl.api.HtmlFormat.Appendable = apply(user,nav,blockedRemittanceTransactions,notificationInterval,listCurrencies)

  def f:((User,String,List[SenderReceiverTransaction],String,List[CurrencyExchange]) => play.twirl.api.HtmlFormat.Appendable) = (user,nav,blockedRemittanceTransactions,notificationInterval,listCurrencies) => apply(user,nav,blockedRemittanceTransactions,notificationInterval,listCurrencies)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:56 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/co/sender.scala.html
                  HASH: 4feb3110d364ff0cba12f23bbc3eecf89f683840
                  MATRIX: 794->1|1064->160|1092->186|1119->188|1228->288|1268->290|1297->293|2605->1574|2620->1580|2680->1618|10680->9590|10696->9596|10777->9654|10877->9726|10893->9732|10989->9805|11089->9877|11105->9883|11183->9938|11283->10010|11299->10016|11378->10072|11481->10147|11497->10153|11562->10196|11676->10282|11692->10288|11764->10338|12320->10865|12350->10866|12386->10874|12507->10966|12537->10967|12570->10972|12618->10992|12647->10993|12725->11042|12755->11043|12790->11050|12819->11051|12896->11099|12926->11100|12961->11107|12990->11108|13070->11159|13100->11160|13133->11165|13389->11393|13405->11399|13459->11431|13529->11472|13559->11473|13593->11479|13893->11750|13923->11751|13971->11770|14089->11859|14119->11860|14168->11880|14209->11892|14239->11893|14269->11894|14340->11936|14370->11937|14420->11958|14450->11959|14498->11978|14597->12048|14627->12049|14679->12072|14858->12222|14888->12223|14941->12247|14982->12259|15012->12260|15042->12261|15116->12306|15146->12307|15200->12332|15230->12333|15278->12352|15308->12353|15351->12367|15381->12368|15419->12378|15448->12379|15538->12440|15568->12441|15602->12447|15664->12480|15694->12481|15729->12488|15796->12527|15825->12528|15854->12529|15923->12569|15953->12570|16038->12626|16068->12627|16104->12635|16133->12636|16241->12715|16271->12716|16305->12722|16374->12762|16404->12763|16440->12771|16556->12859|16585->12860|16620->12867|16649->12868|16681->12872|16710->12873|17901->14035|17931->14036|17964->14041|18053->14101|18083->14102|18531->14522|18560->14523|18592->14527|18621->14528|18720->14598|18750->14599|18783->14604|18851->14644|18880->14645|18960->14696|18990->14697|19023->14702|19523->15174|19552->15175|19588->15183|19656->15222|19686->15223|19719->15228|19803->15284|19819->15290|19873->15322|19915->15335|19945->15336|20024->15386|20054->15387|20087->15392|20139->15416|20155->15422|20209->15454|20352->15568|20382->15569|20500->15658|20530->15659|20563->15664|20801->15873|20831->15874|20872->15886|20907->15893|20923->15899|20977->15931|21109->16034|21139->16035|21181->16048|21229->16067|21259->16068|21302->16082|21362->16113|21392->16114|21436->16129|21518->16182|21548->16183|21581->16187|21611->16188|21655->16203|21774->16292|21805->16293|21844->16303|21895->16325|21925->16326|21970->16342|22000->16343|22043->16357|22110->16395|22140->16396|22173->16400|22203->16401|22246->16415|22344->16484|22374->16485|22415->16497|22445->16498|22537->16561|22567->16562|22612->16578|22728->16664|22759->16665|22790->16666|22836->16683|22866->16684|22906->16695|22936->16696|22974->16706|23003->16707|23036->16712|23103->16750|23133->16751|23166->16756|23251->16813|23280->16814|23313->16819|23376->16853|23406->16854|23439->16859|23534->16925|23564->16926|23598->16932|23653->16959|23682->16960|23715->16965|23761->16983|23790->16984|23938->17103|23968->17104|24002->17110|24156->17235|24186->17236|24216->17237|24301->17293|24331->17294|24360->17295|24551->17457|24581->17458|24610->17459|24703->17524|24733->17525|24766->17529|24796->17530|24825->17531|24903->17581|24933->17582|24962->17583|24997->17590|25026->17591|25259->17795|25289->17796|25318->17797|25561->18011|25591->18012|25620->18013|25695->18059|25725->18060|25754->18061|25885->18163|25915->18164|25944->18165|26052->18244|26082->18245|26132->18266|26162->18267|26191->18268|26240->18288|26270->18289|26434->18424|26464->18425|26511->18443|26541->18444|26636->18510|26666->18511|26695->18512|26829->18616|26860->18617|26891->18618|26940->18638|26970->18639|26999->18640|27041->18653|27071->18654|27121->18676|27150->18677|27275->18773|27305->18774|27338->18779|28215->19627|28245->19628|28286->19640|28321->19647|28337->19653|28394->19688|28527->19792|28557->19793|28592->19800|28640->19819|28670->19820|28700->19821|28865->19958|28894->19959|28927->19963|28957->19964|28993->19972|29083->20034|29112->20035|29153->20047|29183->20048|29275->20111|29305->20112|29350->20128|29466->20214|29497->20215|29528->20216|29574->20233|29604->20234|29644->20245|29674->20246|29712->20256|29741->20257|29777->20265|29841->20300|29871->20301|29904->20306|30010->20384|30039->20385|30113->20430|30143->20431|30176->20436|30324->20556|30353->20557|30386->20562|30444->20591|30474->20592|30507->20597|30743->20805|30772->20806|30808->20814|30894->20871|30924->20872|30957->20877|31103->20995|31132->20996|31222->21057|31252->21058|31285->21063|31548->21298|31577->21299|31669->21362|31699->21363|31732->21368|32001->21609|32030->21610|32119->21670|32149->21671|32182->21676|32367->21833|32396->21834|32486->21895|32516->21896|32549->21901|32734->22058|32763->22059|32856->22123|32886->22124|32919->22129|33263->22445|33292->22446|33409->22534|33439->22535|33475->22543|33636->22675|33666->22676|33710->22691|33861->22813|33891->22814|33940->22834|33970->22835|34011->22847|34056->22863|34086->22864|34128->22877|34169->22889|34199->22890|34242->22904|34281->22914|34311->22915|34352->22927|34426->22972|34456->22973|34498->22986|34642->23101|34672->23102|34715->23116|34751->23123|34781->23124|34825->23139|34943->23228|34973->23229|35015->23242|35045->23243|35078->23247|35108->23248|35151->23262|35205->23287|35235->23288|35279->23303|35315->23310|35345->23311|35399->23336|35552->23460|35582->23461|35625->23475|35655->23476|35688->23480|35718->23481|35759->23493|35814->23519|35844->23520|35886->23533|35916->23534|35957->23546|35987->23547|36044->23575|36074->23576|36116->23589|36146->23590|36183->23599|36213->23600|36274->23632|36304->23633|36346->23646|36387->23658|36417->23659|36460->23673|36499->23683|36529->23684|36570->23696|36644->23741|36674->23742|36716->23755|36851->23861|36881->23862|36930->23882|36966->23889|36996->23890|37049->23914|37179->24015|37209->24016|37251->24029|37281->24030|37314->24034|37344->24035|37387->24049|37444->24077|37474->24078|37518->24093|37554->24100|37584->24101|37638->24126|37774->24233|37804->24234|37847->24248|37877->24249|37910->24253|37940->24254|37981->24266|38036->24292|38066->24293|38108->24306|38138->24307|38179->24319|38209->24320|38266->24348|38296->24349|38338->24362|38368->24363|38405->24372|38435->24373|38496->24405|38526->24406|38568->24419|38609->24431|38639->24432|38682->24446|38721->24456|38751->24457|38795->24472|38931->24579|38961->24580|39003->24593|39243->24804|39273->24805|39316->24819|39371->24845|39401->24846|39434->24850|39464->24851|39504->24862|39558->24887|39588->24888|39629->24900|39659->24901|39716->24929|39746->24930|39796->24951|39826->24952|39870->24967|39972->25040|40002->25041|40057->25067|40087->25068|40128->25080|40158->25081|40218->25112|40248->25113|40290->25126|40331->25138|40361->25139|40404->25153|40443->25163|40473->25164|40514->25176|40588->25221|40618->25222|40660->25235|40899->25445|40929->25446|40972->25460|41008->25467|41038->25468|41082->25483|41201->25573|41231->25574|41273->25587|41303->25588|41336->25592|41366->25593|41409->25607|41465->25634|41495->25635|41539->25650|41575->25657|41605->25658|41659->25683|41805->25800|41835->25801|41878->25815|41908->25816|41941->25820|41971->25821|42012->25833|42067->25859|42097->25860|42139->25873|42169->25874|42210->25886|42240->25887|42297->25915|42327->25916|42369->25929|42399->25930|42440->25942|42470->25943|42530->25974|42560->25975|42602->25988|42643->26000|42673->26001|42716->26015|42755->26025|42785->26026|42829->26041|42982->26165|43012->26166|43054->26179|43198->26294|43228->26295|43271->26309|43326->26335|43356->26336|43389->26340|43419->26341|43459->26352|43513->26377|43543->26378|43584->26390|43614->26391|43671->26419|43701->26420|43751->26441|43781->26442|43825->26457|43927->26530|43957->26531|44012->26557|44042->26558|44083->26570|44113->26571|44172->26601|44202->26602|44244->26615|44285->26627|44315->26628|44358->26642|44397->26652|44427->26653|44468->26665|44542->26710|44572->26711|44614->26724|44669->26750|44699->26751|44742->26765|44778->26772|44808->26773|44861->26797|45001->26908|45031->26909|45073->26922|45103->26923|45136->26927|45166->26928|45206->26939|45260->26964|45290->26965|45331->26977|45361->26978|45418->27006|45448->27007|45490->27020|45520->27021|45561->27033|45591->27034|45627->27042|45656->27043|45691->27050|45720->27051|45792->27094|45822->27095|45858->27103|46029->27245|46059->27246|46089->27247|46171->27300|46201->27301|46235->27307|46409->27452|46439->27453|46474->27460|46542->27500|46571->27501|46604->27505|46634->27506|46669->27513|46722->27538|46751->27539|46784->27544|46813->27545|46903->27606|46933->27607|46974->27619|47188->27804|47218->27805|47260->27818|47332->27861|47362->27862|47405->27876|47629->28071|47659->28072|48608->28992|48638->28993|48681->29007|48738->29035|48768->29036|48840->29079|48870->29080|48919->29100|48949->29101|49014->29137|49044->29138|49087->29152|49199->29235|49229->29236|49273->29251|49361->29310|49391->29311|49438->29329|49468->29330|49501->29334|49531->29335|49571->29346|49779->29525|49809->29526|49881->29569|49911->29570|50130->29760|50160->29761|50201->29773|50231->29774|50323->29837|50353->29838|50398->29854|50514->29940|50545->29941|50576->29942|50622->29959|50652->29960|50692->29971|50722->29972|50783->30005|50812->30006|50855->30021|50884->30022
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|34->7|65->38|65->38|65->38|228->201|228->201|228->201|229->202|229->202|229->202|230->203|230->203|230->203|231->204|231->204|231->204|233->206|233->206|233->206|235->208|235->208|235->208|257->230|257->230|259->232|263->236|263->236|264->237|265->238|265->238|265->238|265->238|266->239|266->239|266->239|266->239|267->240|267->240|267->240|267->240|268->241|276->249|276->249|276->249|277->250|277->250|278->251|279->252|279->252|280->253|281->254|281->254|282->255|282->255|282->255|282->255|282->255|282->255|283->256|283->256|284->257|284->257|284->257|285->258|287->260|287->260|288->261|288->261|288->261|288->261|288->261|288->261|289->262|289->262|290->263|290->263|291->264|291->264|292->265|292->265|293->266|293->266|294->267|294->267|294->267|295->268|296->269|296->269|297->270|297->270|297->270|299->272|299->272|300->273|300->273|301->274|301->274|302->275|302->275|302->275|303->276|305->278|305->278|306->279|306->279|307->280|307->280|328->301|328->301|329->302|330->303|330->303|346->319|346->319|347->320|347->320|349->322|349->322|350->323|351->324|351->324|353->326|353->326|354->327|363->336|363->336|365->338|365->338|365->338|366->339|367->340|367->340|367->340|368->341|368->341|370->343|370->343|371->344|371->344|371->344|371->344|373->346|373->346|376->349|376->349|377->350|381->354|381->354|382->355|382->355|382->355|382->355|384->357|384->357|385->358|385->358|385->358|386->359|386->359|386->359|387->360|388->361|388->361|388->361|388->361|389->362|389->362|389->362|390->363|391->364|391->364|392->365|392->365|393->366|394->367|394->367|394->367|394->367|395->368|396->369|396->369|397->370|397->370|398->371|398->371|399->372|399->372|399->372|399->372|400->373|400->373|401->374|401->374|402->375|402->375|404->377|404->377|404->377|405->378|406->379|406->379|408->381|408->381|408->381|409->382|410->383|410->383|411->384|412->385|412->385|413->386|414->387|414->387|419->392|419->392|421->394|424->397|424->397|424->397|425->398|425->398|426->399|429->402|429->402|430->403|431->404|431->404|431->404|431->404|432->405|433->406|433->406|434->407|434->407|434->407|442->415|442->415|443->416|448->421|448->421|449->422|449->422|449->422|450->423|451->424|451->424|452->425|453->426|453->426|454->427|454->427|455->428|455->428|455->428|458->431|458->431|459->432|459->432|460->433|460->433|461->434|461->434|461->434|461->434|462->435|462->435|463->436|463->436|463->436|466->439|466->439|469->442|469->442|470->443|485->458|485->458|486->459|486->459|486->459|486->459|488->461|488->461|489->462|489->462|489->462|489->462|491->464|491->464|491->464|491->464|492->465|493->466|493->466|494->467|494->467|495->468|495->468|496->469|496->469|496->469|496->469|497->470|497->470|498->471|498->471|499->472|499->472|501->474|501->474|501->474|502->475|504->477|504->477|506->479|506->479|507->480|510->483|510->483|512->485|512->485|512->485|513->486|517->490|517->490|519->492|519->492|519->492|520->493|522->495|522->495|523->496|523->496|524->497|527->500|527->500|528->501|528->501|529->502|532->505|532->505|533->506|533->506|534->507|536->509|536->509|537->510|537->510|538->511|540->513|540->513|541->514|541->514|542->515|546->519|546->519|548->521|548->521|549->522|552->525|552->525|553->526|556->529|556->529|557->530|557->530|558->531|558->531|558->531|559->532|559->532|559->532|560->533|560->533|560->533|561->534|561->534|561->534|562->535|563->536|563->536|564->537|564->537|564->537|565->538|567->540|567->540|568->541|568->541|568->541|568->541|569->542|569->542|569->542|570->543|570->543|570->543|571->544|573->546|573->546|574->547|574->547|574->547|574->547|575->548|576->549|576->549|577->550|577->550|578->551|578->551|579->552|579->552|580->553|580->553|581->554|581->554|582->555|582->555|583->556|583->556|583->556|584->557|584->557|584->557|585->558|585->558|585->558|586->559|587->560|587->560|588->561|588->561|588->561|589->562|591->564|591->564|592->565|592->565|592->565|592->565|593->566|593->566|593->566|594->567|594->567|594->567|595->568|597->570|597->570|598->571|598->571|598->571|598->571|599->572|600->573|600->573|601->574|601->574|602->575|602->575|603->576|603->576|604->577|604->577|605->578|605->578|606->579|606->579|607->580|607->580|607->580|608->581|608->581|608->581|609->582|610->583|610->583|611->584|613->586|613->586|614->587|615->588|615->588|615->588|615->588|616->589|617->590|617->590|618->591|618->591|619->592|619->592|620->593|620->593|621->594|623->596|623->596|624->597|624->597|625->598|625->598|626->599|626->599|627->600|627->600|627->600|628->601|628->601|628->601|629->602|629->602|629->602|630->603|632->605|632->605|633->606|633->606|633->606|634->607|636->609|636->609|637->610|637->610|637->610|637->610|638->611|638->611|638->611|639->612|639->612|639->612|640->613|642->615|642->615|643->616|643->616|643->616|643->616|644->617|645->618|645->618|646->619|646->619|647->620|647->620|648->621|648->621|649->622|649->622|650->623|650->623|651->624|651->624|652->625|652->625|652->625|653->626|653->626|653->626|654->627|655->628|655->628|656->629|657->630|657->630|658->631|659->632|659->632|659->632|659->632|660->633|661->634|661->634|662->635|662->635|663->636|663->636|664->637|664->637|665->638|667->640|667->640|668->641|668->641|669->642|669->642|670->643|670->643|671->644|671->644|671->644|672->645|672->645|672->645|673->646|673->646|673->646|674->647|674->647|674->647|675->648|675->648|675->648|676->649|678->651|678->651|679->652|679->652|679->652|679->652|680->653|681->654|681->654|682->655|682->655|683->656|683->656|684->657|684->657|685->658|685->658|686->659|686->659|687->660|687->660|688->661|688->661|689->662|693->666|693->666|693->666|694->667|694->667|695->668|698->671|698->671|699->672|700->673|700->673|700->673|700->673|701->674|702->675|702->675|703->676|703->676|705->678|705->678|706->679|711->684|711->684|712->685|712->685|712->685|713->686|716->689|716->689|733->706|733->706|734->707|734->707|734->707|734->707|734->707|735->708|735->708|735->708|735->708|736->709|737->710|737->710|738->711|739->712|739->712|740->713|740->713|740->713|740->713|741->714|744->717|744->717|744->717|744->717|748->721|748->721|749->722|749->722|750->723|750->723|751->724|751->724|751->724|751->724|752->725|752->725|753->726|753->726|755->728|755->728|757->730|757->730
                  -- GENERATED --
              */
          