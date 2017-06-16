
package views.html.admin

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
object rule_fill_amount_managment extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User, nav: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import utils.DateUtils

Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("RULE FILL AMOUNT", user, nav, null, null, null)/*5.55*/ {_display_(Seq[Any](format.raw/*5.57*/("""

	"""),format.raw/*7.2*/("""<div class="content-wrapper">
		<div class="page-header"></div>
		<table id="tbRuleFillAmount" class="display cell-border compact" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>Type Rule</th>
					<th>Type Sender</th>
					<th>USD Amount($)</th>
					<th>Percent Fee(%)</th>
					<th>Cable</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	
<!-- pop up update rule-->
<div id="popupUpdateRule" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupUpdateRule" aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title" id="popupSaveOrUpdateBranchTitle">Update Rule Fill Amount</h4>
			</div>
			<form role="form" id="frmUpdateRuleManagement" action=""""),_display_(/*32.60*/routes/*32.66*/.UserController.saveOrUpdateBranch()),format.raw/*32.102*/("""" method="post">
				<div class="modal-body">
					<div id="ruleManagement-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
					<div id="ruleManagement-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Error !</div>
					<div class="row"> <!-- Row 1 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Rule Type</label>
							<input type="text" name="ruleTYpe" class="form-control" placeholder="Rule Type" disabled="disabled"/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Type Sender</label>
							<input type="text" name="typeSender" class="form-control" placeholder="Type Sender" disabled="disabled"/>
						</div>
					</div>
					<div class="row"> <!-- Row 2 -->
						<div class="col-md-6 form-group">
							<label class="control-label">USD Amount($)</label>
							<input type="text" name="usdAmount" class="form-control" placeholder="USD Amount($)"/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">Percent Fee(%)</label>
							<input type="text" name="percentFee" class="form-control" placeholder="0(%)"/>
						</div>
					</div>					
					<div class="row"> <!-- Row 3 -->
						<div class="col-md-6 form-group">
							<label class="control-label">Cable</label>
							<input type="text" name="cable" class="form-control" placeholder="0"/>
						</div>			
					</div>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="hidRuleManagementId" class="form-control"/>
					<button id="btnRuleManagementUpdate" type="submit" class="btn btn-primary">Update</button>
					<button id="btnRuleManagementCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end pop up save or update branch-->
	
	<!-- jQuery -->
	<script src=""""),_display_(/*75.16*/routes/*75.22*/.Assets.at("javascripts/jquery-1.11.1.min.js")),format.raw/*75.68*/(""""></script>
	<!-- JS Bootstrap -->		
	<script type="text/javascript" src=""""),_display_(/*77.39*/routes/*77.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*77.88*/("""" defer></script>
	<!-- JS fnReloadAjax -->
	<script type="text/javascript" language="javascript" src=""""),_display_(/*79.61*/routes/*79.67*/.Assets.at("plugins/datatables-1.10.2/fnReloadAjax.js")),format.raw/*79.122*/("""" defer></script>
	
	
	<script type="text/javascript" language="javascript">
		var tbRuleFillAmount
		$(document).ready(function() """),format.raw/*84.32*/("""{"""),format.raw/*84.33*/("""
			
			"""),format.raw/*86.4*/("""/*
			* dataTables : tbUser
			*/
			tbRuleFillAmount = $('#tbRuleFillAmount').dataTable("""),format.raw/*89.56*/("""{"""),format.raw/*89.57*/("""
				"""),format.raw/*90.5*/("""oLanguage: """),format.raw/*90.16*/("""{"""),format.raw/*90.17*/("""
				    """),format.raw/*91.9*/(""""sSearch": " "
				"""),format.raw/*92.5*/("""}"""),format.raw/*92.6*/(""",
				bInfo: false,
				bPaginate:false,
				dom: 'flt<"advanceSearch">ip',
				columnDefs: [ 
								"""),format.raw/*97.9*/("""{"""),format.raw/*97.10*/("""targets:[0], visible:false,sortable:false, searchable:false"""),format.raw/*97.69*/("""}"""),format.raw/*97.70*/(""",
								"""),format.raw/*98.9*/("""{"""),format.raw/*98.10*/("""targets:[1], sortable:false, searchable:false"""),format.raw/*98.55*/("""}"""),format.raw/*98.56*/(""",
								"""),format.raw/*99.9*/("""{"""),format.raw/*99.10*/("""targets:[2], sortable:false, searchable:false"""),format.raw/*99.55*/("""}"""),format.raw/*99.56*/(""",
								"""),format.raw/*100.9*/("""{"""),format.raw/*100.10*/("""targets:[3], sortable:false, searchable:false"""),format.raw/*100.55*/("""}"""),format.raw/*100.56*/(""",
								"""),format.raw/*101.9*/("""{"""),format.raw/*101.10*/("""targets:[4], sortable:false, searchable:false"""),format.raw/*101.55*/("""}"""),format.raw/*101.56*/(""",
								"""),format.raw/*102.9*/("""{"""),format.raw/*102.10*/("""targets:[5], sortable:false, searchable:false"""),format.raw/*102.55*/("""}"""),format.raw/*102.56*/("""
							"""),format.raw/*103.8*/("""],
	            serverSide: true,	
	            processing: true,
	            stateSave: true,
				ajaxSource: """"),_display_(/*107.19*/routes/*107.25*/.RuleFillAmountManagementController.getAll()),format.raw/*107.69*/("""",
				fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) """),format.raw/*108.78*/("""{"""),format.raw/*108.79*/("""
					"""),format.raw/*109.6*/("""$('td', nRow).on('dblclick', function() """),format.raw/*109.46*/("""{"""),format.raw/*109.47*/(""" 
						"""),format.raw/*110.7*/("""preparePopupBeforeEdit(aData);
						$('#popupUpdateRule').modal("show");
					"""),format.raw/*112.6*/("""}"""),format.raw/*112.7*/("""); 
				"""),format.raw/*113.5*/("""}"""),format.raw/*113.6*/("""
			"""),format.raw/*114.4*/("""}"""),format.raw/*114.5*/(""");
		
			if(document.getElementById("tbRuleFillAmount_filter") != null) """),format.raw/*116.67*/("""{"""),format.raw/*116.68*/("""
				"""),format.raw/*117.5*/("""var searchFilter = $('#tbRuleFillAmount_filter').find('input[type="search"]');
				searchFilter.each(function () """),format.raw/*118.35*/("""{"""),format.raw/*118.36*/("""
					"""),format.raw/*119.6*/("""var $input = $(this);
					$input.hide();
				"""),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""");
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/("""
		
			"""),format.raw/*124.4*/("""$('form#frmUpdateRuleManagement').bootstrapValidator("""),format.raw/*124.57*/("""{"""),format.raw/*124.58*/("""
		    	"""),format.raw/*125.8*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
		    	live: 'enabled',
		    	container: 'tooltip',
		        feedbackIcons: """),format.raw/*128.26*/("""{"""),format.raw/*128.27*/("""
		            """),format.raw/*129.15*/("""valid: 'glyphicon',
		            invalid: 'glyphicon',
		            validating: 'glyphicon glyphicon-refresh'
		        """),format.raw/*132.11*/("""}"""),format.raw/*132.12*/(""",
		        fields: """),format.raw/*133.19*/("""{"""),format.raw/*133.20*/("""
		        	"""),format.raw/*134.12*/("""usdAmount: """),format.raw/*134.23*/("""{"""),format.raw/*134.24*/("""
		                """),format.raw/*135.19*/("""validators: """),format.raw/*135.31*/("""{"""),format.raw/*135.32*/("""
		                    """),format.raw/*136.23*/("""regexp: """),format.raw/*136.31*/("""{"""),format.raw/*136.32*/("""
		                        """),format.raw/*137.27*/("""regexp: /[0-9]/i,
		                        message: 'Number only'
		                    """),format.raw/*139.23*/("""}"""),format.raw/*139.24*/("""		                    
		                """),format.raw/*140.19*/("""}"""),format.raw/*140.20*/("""
		            """),format.raw/*141.15*/("""}"""),format.raw/*141.16*/(""",
		            percentFee: """),format.raw/*142.27*/("""{"""),format.raw/*142.28*/("""
		                """),format.raw/*143.19*/("""validators: """),format.raw/*143.31*/("""{"""),format.raw/*143.32*/("""
		                    """),format.raw/*144.23*/("""regexp: """),format.raw/*144.31*/("""{"""),format.raw/*144.32*/("""
		                    	"""),format.raw/*145.24*/("""regexp: /[0-9]/i,
		                        message: 'Number only'
		                    """),format.raw/*147.23*/("""}"""),format.raw/*147.24*/("""		                    
		                """),format.raw/*148.19*/("""}"""),format.raw/*148.20*/("""
		            """),format.raw/*149.15*/("""}"""),format.raw/*149.16*/(""",
		            cable: """),format.raw/*150.22*/("""{"""),format.raw/*150.23*/("""
		                """),format.raw/*151.19*/("""validators: """),format.raw/*151.31*/("""{"""),format.raw/*151.32*/("""
		                    """),format.raw/*152.23*/("""regexp: """),format.raw/*152.31*/("""{"""),format.raw/*152.32*/("""
		                    	"""),format.raw/*153.24*/("""regexp: /[0-9]/i,
		                        message: 'Number only'
		                    """),format.raw/*155.23*/("""}"""),format.raw/*155.24*/("""		                    
		                """),format.raw/*156.19*/("""}"""),format.raw/*156.20*/("""
		            """),format.raw/*157.15*/("""}"""),format.raw/*157.16*/("""
		        """),format.raw/*158.11*/("""}"""),format.raw/*158.12*/("""
		    """),format.raw/*159.7*/("""}"""),format.raw/*159.8*/(""")
		    .on('success.form.bv', function(e) """),format.raw/*160.42*/("""{"""),format.raw/*160.43*/("""
		    	"""),format.raw/*161.8*/("""e.preventDefault(); // Prevent submit form 
				var that = $(this),
				url = "",
				type = that.attr('method'),
				data = """),format.raw/*165.12*/("""{"""),format.raw/*165.13*/("""}"""),format.raw/*165.14*/(""";
				that.find('[name]').each(function(index, value)"""),format.raw/*166.52*/("""{"""),format.raw/*166.53*/("""
					"""),format.raw/*167.6*/("""var that = $(this),
						name = that.attr('name'),
						value = that.val();
					data[name] = value;
				"""),format.raw/*171.5*/("""}"""),format.raw/*171.6*/(""");
				data['updateTime'] = new Date().getTime();
				$.ajax("""),format.raw/*173.12*/("""{"""),format.raw/*173.13*/("""
	       			"""),format.raw/*174.12*/("""url: '"""),_display_(/*174.19*/routes/*174.25*/.RuleFillAmountManagementController.update()),format.raw/*174.69*/("""',
	       			type: type,
	       			dataType: 'json',
	       			data: JSON.stringify(data),
	       			contentType : "application/json",
	       			success: function(response) """),format.raw/*179.40*/("""{"""),format.raw/*179.41*/("""
	       				"""),format.raw/*180.13*/("""if(response == "success") """),format.raw/*180.39*/("""{"""),format.raw/*180.40*/("""
	       					"""),format.raw/*181.14*/("""tbRuleFillAmount.fnReloadAjax();
	       					$('#ruleManagement-alert-success').removeClass('hidden');
					    	$("#ruleManagement-alert-success").slideDown("slow");
							window.setTimeout(function()"""),format.raw/*184.36*/("""{"""),format.raw/*184.37*/("""
								"""),format.raw/*185.9*/("""$("#ruleManagement-alert-success").slideUp("slow");
								$('#popupUpdateRule').modal("hide");
							"""),format.raw/*187.8*/("""}"""),format.raw/*187.9*/(""",2000);
	       				"""),format.raw/*188.13*/("""}"""),format.raw/*188.14*/(""" """),format.raw/*188.15*/("""else """),format.raw/*188.20*/("""{"""),format.raw/*188.21*/("""
	       					"""),format.raw/*189.14*/("""$('#ruleManagement-alert-danger').removeClass('hidden');
					    	$("#ruleManagement-alert-danger").slideDown("slow");
	       				"""),format.raw/*191.13*/("""}"""),format.raw/*191.14*/("""
		       		"""),format.raw/*192.12*/("""}"""),format.raw/*192.13*/(""",
		            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*193.62*/("""{"""),format.raw/*193.63*/("""
		            	"""),format.raw/*194.16*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*194.102*/("""{"""),format.raw/*194.103*/("""}"""),format.raw/*194.104*/(""");
		            """),format.raw/*195.15*/("""}"""),format.raw/*195.16*/("""
		       	"""),format.raw/*196.11*/("""}"""),format.raw/*196.12*/(""");
			    return false;
		    """),format.raw/*198.7*/("""}"""),format.raw/*198.8*/(""");
		    
		"""),format.raw/*200.3*/("""}"""),format.raw/*200.4*/("""); /* end document ready */
		
		function clearPopupEditRule() """),format.raw/*202.33*/("""{"""),format.raw/*202.34*/("""
			"""),format.raw/*203.4*/("""$("input[name='hidRuleManagementId']").val('0');
			$("input[name='ruleTYpe']").val("");
			$("input[name='typeSender']").val("");
			$("input[name='usdAmount']").val("");
			$("input[name='percentFee']").val("");
			$("input[name='cable']").val("");
		"""),format.raw/*209.3*/("""}"""),format.raw/*209.4*/("""
		
		"""),format.raw/*211.3*/("""function preparePopupBeforeEdit(dr)"""),format.raw/*211.38*/("""{"""),format.raw/*211.39*/("""
			"""),format.raw/*212.4*/("""clearPopupEditRule();
			$("input[name='hidRuleManagementId']").val(dr[0]);
			$("input[name='ruleTYpe']").val(dr[1]);
			$("input[name='typeSender']").val(dr[2]);
			$("input[name='usdAmount']").val(dr[3]);
			$("input[name='percentFee']").val(dr[4]);
			$("input[name='cable']").val(dr[5]);
		"""),format.raw/*219.3*/("""}"""),format.raw/*219.4*/("""
		
	"""),format.raw/*221.2*/("""</script>

""")))}))}
  }

  def render(user:User,nav:String): play.twirl.api.HtmlFormat.Appendable = apply(user,nav)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (user,nav) => apply(user,nav)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:53 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/admin/rule_fill_amount_managment.scala.html
                  HASH: d6c2f487f69e5ff143e067ad5fae66fc977a1c8c
                  MATRIX: 755->1|890->26|918->52|945->54|1006->107|1045->109|1074->112|2079->1090|2094->1096|2152->1132|4298->3251|4313->3257|4380->3303|4482->3378|4497->3384|4561->3427|4692->3531|4707->3537|4784->3592|4943->3723|4972->3724|5007->3732|5124->3821|5153->3822|5185->3827|5224->3838|5253->3839|5289->3848|5335->3867|5363->3868|5493->3971|5522->3972|5609->4031|5638->4032|5675->4042|5704->4043|5777->4088|5806->4089|5843->4099|5872->4100|5945->4145|5974->4146|6012->4156|6042->4157|6116->4202|6146->4203|6184->4213|6214->4214|6288->4259|6318->4260|6356->4270|6386->4271|6460->4316|6490->4317|6526->4325|6668->4439|6684->4445|6750->4489|6859->4569|6889->4570|6923->4576|6992->4616|7022->4617|7058->4625|7165->4704|7194->4705|7230->4713|7259->4714|7291->4718|7320->4719|7421->4791|7451->4792|7484->4797|7626->4910|7656->4911|7690->4917|7764->4963|7793->4964|7827->4970|7856->4971|7891->4978|7973->5031|8003->5032|8039->5040|8200->5172|8230->5173|8274->5188|8425->5310|8455->5311|8504->5331|8534->5332|8575->5344|8615->5355|8645->5356|8693->5375|8734->5387|8764->5388|8816->5411|8853->5419|8883->5420|8939->5447|9057->5536|9087->5537|9157->5578|9187->5579|9231->5594|9261->5595|9318->5623|9348->5624|9396->5643|9437->5655|9467->5656|9519->5679|9556->5687|9586->5688|9639->5712|9757->5801|9787->5802|9857->5843|9887->5844|9931->5859|9961->5860|10013->5883|10043->5884|10091->5903|10132->5915|10162->5916|10214->5939|10251->5947|10281->5948|10334->5972|10452->6061|10482->6062|10552->6103|10582->6104|10626->6119|10656->6120|10696->6131|10726->6132|10761->6139|10790->6140|10862->6183|10892->6184|10928->6192|11082->6317|11112->6318|11142->6319|11224->6372|11254->6373|11288->6379|11423->6486|11452->6487|11542->6548|11572->6549|11613->6561|11648->6568|11664->6574|11730->6618|11937->6796|11967->6797|12009->6810|12064->6836|12094->6837|12137->6851|12369->7054|12399->7055|12436->7064|12568->7168|12597->7169|12646->7189|12676->7190|12706->7191|12740->7196|12770->7197|12813->7211|12974->7343|13004->7344|13045->7356|13075->7357|13167->7420|13197->7421|13242->7437|13358->7523|13389->7524|13420->7525|13466->7542|13496->7543|13536->7554|13566->7555|13624->7585|13653->7586|13693->7598|13722->7599|13814->7662|13844->7663|13876->7667|14157->7920|14186->7921|14220->7927|14284->7962|14314->7963|14346->7967|14669->8262|14698->8263|14731->8268
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|34->7|59->32|59->32|59->32|102->75|102->75|102->75|104->77|104->77|104->77|106->79|106->79|106->79|111->84|111->84|113->86|116->89|116->89|117->90|117->90|117->90|118->91|119->92|119->92|124->97|124->97|124->97|124->97|125->98|125->98|125->98|125->98|126->99|126->99|126->99|126->99|127->100|127->100|127->100|127->100|128->101|128->101|128->101|128->101|129->102|129->102|129->102|129->102|130->103|134->107|134->107|134->107|135->108|135->108|136->109|136->109|136->109|137->110|139->112|139->112|140->113|140->113|141->114|141->114|143->116|143->116|144->117|145->118|145->118|146->119|148->121|148->121|149->122|149->122|151->124|151->124|151->124|152->125|155->128|155->128|156->129|159->132|159->132|160->133|160->133|161->134|161->134|161->134|162->135|162->135|162->135|163->136|163->136|163->136|164->137|166->139|166->139|167->140|167->140|168->141|168->141|169->142|169->142|170->143|170->143|170->143|171->144|171->144|171->144|172->145|174->147|174->147|175->148|175->148|176->149|176->149|177->150|177->150|178->151|178->151|178->151|179->152|179->152|179->152|180->153|182->155|182->155|183->156|183->156|184->157|184->157|185->158|185->158|186->159|186->159|187->160|187->160|188->161|192->165|192->165|192->165|193->166|193->166|194->167|198->171|198->171|200->173|200->173|201->174|201->174|201->174|201->174|206->179|206->179|207->180|207->180|207->180|208->181|211->184|211->184|212->185|214->187|214->187|215->188|215->188|215->188|215->188|215->188|216->189|218->191|218->191|219->192|219->192|220->193|220->193|221->194|221->194|221->194|221->194|222->195|222->195|223->196|223->196|225->198|225->198|227->200|227->200|229->202|229->202|230->203|236->209|236->209|238->211|238->211|238->211|239->212|246->219|246->219|248->221
                  -- GENERATED --
              */
          