
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

/**/
object receiver extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[User,String,List[SenderReceiverTransaction],String,List[CurrencyExchange],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User, nav: String, rejectedAndApprovedTxs: List[SenderReceiverTransaction], notificationInterval: String, listCurrencies: List[CurrencyExchange]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.154*/("""

"""),_display_(/*3.2*/main("RECEIVER", user, nav, null, rejectedAndApprovedTxs, notificationInterval, listCurrencies)/*3.97*/ {_display_(Seq[Any](format.raw/*3.99*/("""

	"""),format.raw/*5.2*/("""<div class="content-wrapper">
		<div class="page-header"><h3>List receiver</h3></div>
		<table id="tbReceiver" class="display cell-border compact" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>N&deg;</th>
					<th>ID</th>
					<th>Full name</th>
					<th>Account No.</th>
					<th>Intermediary Bank</th>
					<th>Swift Code</th>
					<th>Bank Address</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>

<!-- pop up create or update receiver -->
<div id="popupAddEditReceiver" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAddEditReceiver" aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="popupAddEditSenderTitle">Create Receiver</h4>
			</div>
			<form role="form" id="frmReceiver" action=""""),_display_(/*31.48*/routes/*31.54*/.ReceiverController.saveOrUpdateReceiver()),format.raw/*31.96*/("""" method="post">
				<div class="modal-body">
					<input type="hidden" name="receiverId" id="receiverId" value="0"/>
					<div id="receiver-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
					<div id="receiver-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Receiver with this account no. already exists</div>
					<div id="receiver-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>JSON expected</div>
					<div class="row"> <!-- Row 1 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Intermediary bank</label>
							<input type="text" name="receiverIntermediaryBank" class="form-control" placeholder="intermediary bank" required/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Swift code</label>
							<input type="text" name="receiverSwiftCode" class="form-control" placeholder="swift code" required/>
						</div>
					</div>
					<div class="row"> <!-- Row 2 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Account No.</label>
							<input type="text" name="receiverAccountNo" class="form-control" placeholder="account no." required/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Full name</label>
							<input type="text" name="receiverFullName" class="form-control" placeholder="full name" required/>
						</div>
					</div>
					<div class="row"> <!-- Row 3 -->
						<div class="col-md-12">
							<label>Bank address</label>
							<textarea name="receiverBankAddress" class="form-control" rows="2" placeholder="bank address"></textarea>	
						</div>		
					</div>
<!-- 					<div class="row"> Row 4 -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<label>Purpose</label> -->
<!-- 							<textarea name="receiverPurpose" class="form-control" rows="2" placeholder="purpose"></textarea>	 -->
<!-- 						</div>		 -->
<!-- 					</div> -->
				</div>
				<div class="modal-footer">
					<button id="btnSaveReceiver" type="submit" class="btn btn-primary">Save</button>
					<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end pop up create or update receiver -->

	<!-- pop up receiver advanced search view -->
	<div id="popupAdvancedSearchReceiver" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAdvancedSearchReceiver" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="popupAddEditReceiverTitle">Advanced Search</h4>
				</div>
				<form role="form" id="frmAdvancedSearchReceiver" data-toggle="validator">
					<div class="modal-body">
						<div class="row"> <!-- Row 1 -->
							<div class="col-md-6">
								<label>Intermediary Bank</label>
								<input type="text" name="searchIntermidiary" class="form-control" placeholder="any..."/>
							</div>
							<div class="col-md-6">
								<label>Swift Code</label>
								<input type="text" name="searchSwiftCode" class="form-control" placeholder="any..."/>
							</div>
						</div>
						<div class="row"> <!-- Row 2 -->
							<div class="col-md-6">
								<label>Account No.</label>
								<input type="text" name="searchAccountNumber" class="form-control" placeholder="any..."/>
							</div>
							<div class="col-md-6">
								<label>Full name</label>
								<input type="text" name="searchFullName" class="form-control" placeholder="any..."/>
							</div>
						</div>
<!--						<div class="row">  Row 3 -->
<!--							<div class="col-md-12">-->
<!--								<label>Bank Address</label>-->
<!--								<input type="text" name="searchBankAddress" class="form-control" placeholder="any..."/>-->
<!--							</div>					-->
<!--						</div>	-->
					</div>
					<div class="modal-footer">
						<button id="btnSearchReceiver" type="button" class="btn btn-primary">Search</button>
						<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end pop up sender advanced search view -->

	<!-- jQuery -->
	<script type="text/javascript" language="javascript" src=""""),_display_(/*128.61*/routes/*128.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.js")),format.raw/*128.125*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*129.61*/routes/*129.67*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.dataTables.min.js")),format.raw/*129.140*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*130.61*/routes/*130.67*/.Assets.at("plugins/datatables-1.10.2/fnReloadAjax.js")),format.raw/*130.122*/(""""></script>
	<script type="text/javascript" language="javascript" src=""""),_display_(/*131.61*/routes/*131.67*/.Assets.at("plugins/datatables-1.10.2/fnFilterClear.js")),format.raw/*131.123*/(""""></script>
	<!-- JS Bootstrap -->		
	<script type="text/javascript" src=""""),_display_(/*133.39*/routes/*133.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*133.88*/("""" defer></script>
	<script type="text/javascript" language="javascript">
		var colNo = 0;
		var colId = 1;
		var colFullName = 2; 
		var colAccountNo = 3;
		var colIntermediaryBank = 4;
		var colSwiftCode = 5; 
		var colBankAddress = 6;				
			
		$(document).ready(function() """),format.raw/*143.32*/("""{"""),format.raw/*143.33*/("""
			"""),format.raw/*144.4*/("""/*
			* dataTables : tbReceiver
			*/
			var tbReceiver = $('#tbReceiver').dataTable("""),format.raw/*147.48*/("""{"""),format.raw/*147.49*/("""
				"""),format.raw/*148.5*/("""columnDefs: [ 
					"""),format.raw/*149.6*/("""{"""),format.raw/*149.7*/("""targets:[colNo], sortable:false, searchable:false"""),format.raw/*149.56*/("""}"""),format.raw/*149.57*/(""",
					"""),format.raw/*150.6*/("""{"""),format.raw/*150.7*/("""targets:[colId], visible:false, searchable:false"""),format.raw/*150.55*/("""}"""),format.raw/*150.56*/("""
				"""),format.raw/*151.5*/("""],
	            processing: true,
	            serverSide: true,
	            stateSave: true,	
				pagingType: "full_numbers",
				deferLoading: 0,
				displayLength: 10,
	            ajaxSource: """"),_display_(/*158.28*/routes/*158.34*/.ReceiverController.filterReceiver()),format.raw/*158.70*/("""",
				dom: 'l<"toolbar">rtip',
				fnServerParams: function (aoData) """),format.raw/*160.39*/("""{"""),format.raw/*160.40*/("""
					"""),format.raw/*161.6*/("""$frmReceiverInputWithValue = $("#frmAdvancedSearchReceiver").find('input[type="text"][value!=""],input[type="radio"]:checked,input[type="checkbox"]:checked,textarea[value!=""],select[value!=""]');
					$frmReceiverInputWithValue.each(function () """),format.raw/*162.50*/("""{"""),format.raw/*162.51*/("""
		                """),format.raw/*163.19*/("""var that = $(this), value = that.val();
		                if (typeof value === "string") """),format.raw/*164.50*/("""{"""),format.raw/*164.51*/("""
		                	"""),format.raw/*165.20*/("""aoData.push("""),format.raw/*165.32*/("""{"""),format.raw/*165.33*/(""" """),format.raw/*165.34*/(""""name": that.attr("name"), "value": value """),format.raw/*165.76*/("""}"""),format.raw/*165.77*/(""");
		                """),format.raw/*166.19*/("""}"""),format.raw/*166.20*/("""
		                """),format.raw/*167.19*/("""else if (Object.prototype.toString.apply(value) === '[object Array]') """),format.raw/*167.89*/("""{"""),format.raw/*167.90*/("""
		                    """),format.raw/*168.23*/("""// for multi select because it has an array of selected values
		                    var i;
		                    for (i = 0; i < value.length; i++) """),format.raw/*170.58*/("""{"""),format.raw/*170.59*/("""
		                    	"""),format.raw/*171.24*/("""aoData.push("""),format.raw/*171.36*/("""{"""),format.raw/*171.37*/(""" """),format.raw/*171.38*/(""""name": that.attr("name"), "value": value[i] """),format.raw/*171.83*/("""}"""),format.raw/*171.84*/(""");
		                    """),format.raw/*172.23*/("""}"""),format.raw/*172.24*/("""
		                """),format.raw/*173.19*/("""}"""),format.raw/*173.20*/("""
		          	"""),format.raw/*174.14*/("""}"""),format.raw/*174.15*/(""");
			    """),format.raw/*175.8*/("""}"""),format.raw/*175.9*/(""",
				fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*176.78*/("""{"""),format.raw/*176.79*/("""
					"""),format.raw/*177.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*177.46*/("""{"""),format.raw/*177.47*/(""" 
						"""),format.raw/*178.7*/("""preparePopupBeforeEditReceiver(aData); 
						$('#popupAddEditReceiver').modal("show");
					"""),format.raw/*180.6*/("""}"""),format.raw/*180.7*/(""");
				"""),format.raw/*181.5*/("""}"""),format.raw/*181.6*/("""
			"""),format.raw/*182.4*/("""}"""),format.raw/*182.5*/(""");
			
			$("div.toolbar").append('&nbsp;<a id="btnAddReceiver" class="btn btn-primary">Add</a>');
			$('div.toolbar').append('<a data-toggle="modal" class="btn btn-primary pull-right col-margin-right" data-target="#popupAdvancedSearchReceiver">Advanced Search</a>');
			$('div.toolbar').append('<a id="btnClearSearch" href="#" class="btn btn-primary pull-right col-margin-right">Clear Search</a>');

			$("#btnClearSearch").click(function () """),format.raw/*188.43*/("""{"""),format.raw/*188.44*/("""
"""),format.raw/*189.1*/("""// 				tbReceiver.fnFilterClear();
				tbReceiver.fnReloadAjax(""""),_display_(/*190.31*/routes/*190.37*/.ReceiverController.filterReceiver()),format.raw/*190.73*/("""");
	        """),format.raw/*191.10*/("""}"""),format.raw/*191.11*/(""");
			
			$("#btnSearchReceiver").click(function () """),format.raw/*193.46*/("""{"""),format.raw/*193.47*/("""
				"""),format.raw/*194.5*/("""tbReceiver.fnReloadAjax(""""),_display_(/*194.31*/routes/*194.37*/.ReceiverController.filterReceiver()),format.raw/*194.73*/("""" + "?" + $("#frmAdvancedSearchReceiver").serialize());
				$('#popupAdvancedSearchReceiver').modal("hide");
	        """),format.raw/*196.10*/("""}"""),format.raw/*196.11*/(""");

			function preparePopupBeforeEditReceiver(dr)"""),format.raw/*198.47*/("""{"""),format.raw/*198.48*/("""
				"""),format.raw/*199.5*/("""$('#popupAddEditReceiverTitle').html('Edit Receiver');
				$('#btnSaveReceiver').html('Update');
				
				$('#receiverId').val(dr[colId]);
				$("input[name='receiverIntermediaryBank']").val(dr[colIntermediaryBank]);
				$("input[name='receiverSwiftCode']").val(dr[colSwiftCode]);
				$("input[name='receiverAccountNo']").val(dr[colAccountNo]);
				$("input[name='receiverFullName']").val(dr[colFullName]);
				$("textarea[name='receiverBankAddress']").val(dr[colBankAddress]);
			"""),format.raw/*208.4*/("""}"""),format.raw/*208.5*/("""
			
			"""),format.raw/*210.4*/("""$('#btnAddReceiver').click(function()"""),format.raw/*210.41*/("""{"""),format.raw/*210.42*/("""
				"""),format.raw/*211.5*/("""preparePopupBeforeAddReceiver();
				$('#popupAddEditReceiver').modal("show");
			"""),format.raw/*213.4*/("""}"""),format.raw/*213.5*/(""");

			function preparePopupBeforeAddReceiver()"""),format.raw/*215.44*/("""{"""),format.raw/*215.45*/("""
				"""),format.raw/*216.5*/("""clearPopupControls();
				$('#popupAddEditReceiverTitle').html('Create Receiver');
				$('#btnSaveReceiver').html('Save');
			"""),format.raw/*219.4*/("""}"""),format.raw/*219.5*/("""

			"""),format.raw/*221.4*/("""function clearPopupControls()"""),format.raw/*221.33*/("""{"""),format.raw/*221.34*/("""
				"""),format.raw/*222.5*/("""$('#receiverId').val('0');
				$("input[name='receiverIntermediaryBank']").val('');
				$("input[name='receiverSwiftCode']").val('');
				$("input[name='receiverAccountNo']").val('');
				$("input[name='receiverFullName']").val('');
				$("textarea[name='receiverBankAddress']").val('');
			"""),format.raw/*228.4*/("""}"""),format.raw/*228.5*/("""

			"""),format.raw/*230.4*/("""$('#popupAddEditReceiver').on('hide.bs.modal', function () """),format.raw/*230.63*/("""{"""),format.raw/*230.64*/("""
				"""),format.raw/*231.5*/("""$('#frmReceiver').bootstrapValidator('resetForm', true);
			"""),format.raw/*232.4*/("""}"""),format.raw/*232.5*/(""")
			
		    /* Validate form Receiver and submit */
		    $('#frmReceiver').bootstrapValidator("""),format.raw/*235.44*/("""{"""),format.raw/*235.45*/("""
		    	"""),format.raw/*236.8*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		    	container: 'tooltip',
		        feedbackIcons: """),format.raw/*239.26*/("""{"""),format.raw/*239.27*/("""
		            """),format.raw/*240.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*243.11*/("""}"""),format.raw/*243.12*/("""
		    """),format.raw/*244.7*/("""}"""),format.raw/*244.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*245.42*/("""{"""),format.raw/*245.43*/("""
		    	"""),format.raw/*246.8*/("""e.preventDefault();
				var that = $(this),
				url = that.attr('action'),
				type = that.attr('method'),
				data = """),format.raw/*250.12*/("""{"""),format.raw/*250.13*/("""}"""),format.raw/*250.14*/(""";
				that.find('[name]').each(function(index, value)"""),format.raw/*251.52*/("""{"""),format.raw/*251.53*/("""
					"""),format.raw/*252.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					if(that.attr('type') != null && that.attr('type')=='checkbox')"""),format.raw/*255.68*/("""{"""),format.raw/*255.69*/("""
						"""),format.raw/*256.7*/("""data[name] = that.prop('checked');
					"""),format.raw/*257.6*/("""}"""),format.raw/*257.7*/("""else"""),format.raw/*257.11*/("""{"""),format.raw/*257.12*/("""
						"""),format.raw/*258.7*/("""data[name] = value;
					"""),format.raw/*259.6*/("""}"""),format.raw/*259.7*/("""
				"""),format.raw/*260.5*/("""}"""),format.raw/*260.6*/(""");
				data['updateTime'] = new Date().getTime();
				$.ajax("""),format.raw/*262.12*/("""{"""),format.raw/*262.13*/("""
	       			"""),format.raw/*263.12*/("""url: url,
	       			type: type,
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*268.40*/("""{"""),format.raw/*268.41*/("""
	       				"""),format.raw/*269.13*/("""if(response == 'receiver_exists')"""),format.raw/*269.46*/("""{"""),format.raw/*269.47*/("""
	       					"""),format.raw/*270.14*/("""$('#receiver-alert-warning').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*271.35*/("""{"""),format.raw/*271.36*/("""
			       				"""),format.raw/*272.15*/("""$('#receiver-alert-warning').addClass('hidden');
			       			"""),format.raw/*273.14*/("""}"""),format.raw/*273.15*/(""", 3000);
				       	"""),format.raw/*274.13*/("""}"""),format.raw/*274.14*/("""else if(response == 'json_expected')"""),format.raw/*274.50*/("""{"""),format.raw/*274.51*/("""
				       		"""),format.raw/*275.14*/("""$('#receiver-alert-danger').removeClass('hidden');
			       			setTimeout(function()"""),format.raw/*276.35*/("""{"""),format.raw/*276.36*/("""
			       				"""),format.raw/*277.15*/("""$('#receiver-alert-danger').addClass('hidden');
			       			"""),format.raw/*278.14*/("""}"""),format.raw/*278.15*/(""", 3000);
					    """),format.raw/*279.10*/("""}"""),format.raw/*279.11*/("""else"""),format.raw/*279.15*/("""{"""),format.raw/*279.16*/("""
					    	"""),format.raw/*280.11*/("""tbReceiver.fnReloadAjax();
			       			$('#receiver-alert-success').removeClass('hidden');
					    	$("#receiver-alert-success").slideDown("slow");
							window.setTimeout(function()"""),format.raw/*283.36*/("""{"""),format.raw/*283.37*/("""$("#receiver-alert-success").slideUp("slow");"""),format.raw/*283.82*/("""}"""),format.raw/*283.83*/(""",2000);
							$('#frmReceiver').data('bootstrapValidator').resetForm();
							$('#frmReceiver').find('input,textarea').val("");
			       		"""),format.raw/*286.13*/("""}"""),format.raw/*286.14*/("""
		       		"""),format.raw/*287.12*/("""}"""),format.raw/*287.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*288.62*/("""{"""),format.raw/*288.63*/("""
		            	"""),format.raw/*289.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*289.102*/("""{"""),format.raw/*289.103*/("""}"""),format.raw/*289.104*/(""");
		            """),format.raw/*290.15*/("""}"""),format.raw/*290.16*/("""
		       	"""),format.raw/*291.11*/("""}"""),format.raw/*291.12*/(""");
	       		return false;
		    """),format.raw/*293.7*/("""}"""),format.raw/*293.8*/(""");
		    
		"""),format.raw/*295.3*/("""}"""),format.raw/*295.4*/("""); /* end document ready */

	</script>

""")))}))}
  }

  def render(user:User,nav:String,rejectedAndApprovedTxs:List[SenderReceiverTransaction],notificationInterval:String,listCurrencies:List[CurrencyExchange]): play.twirl.api.HtmlFormat.Appendable = apply(user,nav,rejectedAndApprovedTxs,notificationInterval,listCurrencies)

  def f:((User,String,List[SenderReceiverTransaction],String,List[CurrencyExchange]) => play.twirl.api.HtmlFormat.Appendable) = (user,nav,rejectedAndApprovedTxs,notificationInterval,listCurrencies) => apply(user,nav,rejectedAndApprovedTxs,notificationInterval,listCurrencies)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:56 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/teller/receiver.scala.html
                  HASH: bf8cbcafd37434099ac2b8880295b0cd12cd603d
                  MATRIX: 800->1|1041->153|1069->156|1172->251|1211->253|1240->256|2288->1277|2303->1283|2366->1325|7194->6125|7210->6131|7291->6189|7391->6261|7407->6267|7503->6340|7603->6412|7619->6418|7697->6473|7797->6545|7813->6551|7892->6607|7995->6682|8011->6688|8076->6731|8381->7007|8411->7008|8443->7012|8557->7097|8587->7098|8620->7103|8668->7123|8697->7124|8775->7173|8805->7174|8840->7181|8869->7182|8946->7230|8976->7231|9009->7236|9236->7435|9252->7441|9310->7477|9409->7547|9439->7548|9473->7554|9748->7800|9778->7801|9826->7820|9944->7909|9974->7910|10023->7930|10064->7942|10094->7943|10124->7944|10195->7986|10225->7987|10275->8008|10305->8009|10353->8028|10452->8098|10482->8099|10534->8122|10712->8271|10742->8272|10795->8296|10836->8308|10866->8309|10896->8310|10970->8355|11000->8356|11054->8381|11084->8382|11132->8401|11162->8402|11205->8416|11235->8417|11273->8427|11302->8428|11410->8507|11440->8508|11474->8514|11543->8554|11573->8555|11609->8563|11730->8656|11759->8657|11794->8664|11823->8665|11855->8669|11884->8670|12356->9113|12386->9114|12415->9115|12508->9180|12524->9186|12582->9222|12624->9235|12654->9236|12735->9288|12765->9289|12798->9294|12852->9320|12868->9326|12926->9362|13073->9480|13103->9481|13182->9531|13212->9532|13245->9537|13754->10018|13783->10019|13819->10027|13885->10064|13915->10065|13948->10070|14058->10152|14087->10153|14163->10200|14193->10201|14226->10206|14380->10332|14409->10333|14442->10338|14500->10367|14530->10368|14563->10373|14882->10664|14911->10665|14944->10670|15032->10729|15062->10730|15095->10735|15183->10795|15212->10796|15336->10891|15366->10892|15402->10900|15563->11032|15593->11033|15637->11048|15788->11170|15818->11171|15853->11178|15882->11179|15954->11222|15984->11223|16020->11231|16167->11349|16197->11350|16227->11351|16309->11404|16339->11405|16373->11411|16547->11556|16577->11557|16612->11564|16680->11604|16709->11605|16742->11609|16772->11610|16807->11617|16860->11642|16889->11643|16922->11648|16951->11649|17041->11710|17071->11711|17112->11723|17326->11908|17356->11909|17398->11922|17460->11955|17490->11956|17533->11970|17648->12056|17678->12057|17722->12072|17813->12134|17843->12135|17893->12156|17923->12157|17988->12193|18018->12194|18061->12208|18175->12293|18205->12294|18249->12309|18339->12370|18369->12371|18416->12389|18446->12390|18479->12394|18509->12395|18549->12406|18763->12591|18793->12592|18867->12637|18897->12638|19068->12780|19098->12781|19139->12793|19169->12794|19261->12857|19291->12858|19336->12874|19452->12960|19483->12961|19514->12962|19560->12979|19590->12980|19630->12991|19660->12992|19721->13025|19750->13026|19790->13038|19819->13039
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|59->31|59->31|59->31|156->128|156->128|156->128|157->129|157->129|157->129|158->130|158->130|158->130|159->131|159->131|159->131|161->133|161->133|161->133|171->143|171->143|172->144|175->147|175->147|176->148|177->149|177->149|177->149|177->149|178->150|178->150|178->150|178->150|179->151|186->158|186->158|186->158|188->160|188->160|189->161|190->162|190->162|191->163|192->164|192->164|193->165|193->165|193->165|193->165|193->165|193->165|194->166|194->166|195->167|195->167|195->167|196->168|198->170|198->170|199->171|199->171|199->171|199->171|199->171|199->171|200->172|200->172|201->173|201->173|202->174|202->174|203->175|203->175|204->176|204->176|205->177|205->177|205->177|206->178|208->180|208->180|209->181|209->181|210->182|210->182|216->188|216->188|217->189|218->190|218->190|218->190|219->191|219->191|221->193|221->193|222->194|222->194|222->194|222->194|224->196|224->196|226->198|226->198|227->199|236->208|236->208|238->210|238->210|238->210|239->211|241->213|241->213|243->215|243->215|244->216|247->219|247->219|249->221|249->221|249->221|250->222|256->228|256->228|258->230|258->230|258->230|259->231|260->232|260->232|263->235|263->235|264->236|267->239|267->239|268->240|271->243|271->243|272->244|272->244|273->245|273->245|274->246|278->250|278->250|278->250|279->251|279->251|280->252|283->255|283->255|284->256|285->257|285->257|285->257|285->257|286->258|287->259|287->259|288->260|288->260|290->262|290->262|291->263|296->268|296->268|297->269|297->269|297->269|298->270|299->271|299->271|300->272|301->273|301->273|302->274|302->274|302->274|302->274|303->275|304->276|304->276|305->277|306->278|306->278|307->279|307->279|307->279|307->279|308->280|311->283|311->283|311->283|311->283|314->286|314->286|315->287|315->287|316->288|316->288|317->289|317->289|317->289|317->289|318->290|318->290|319->291|319->291|321->293|321->293|323->295|323->295
                  -- GENERATED --
              */
          