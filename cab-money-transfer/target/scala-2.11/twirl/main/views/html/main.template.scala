
package views.html

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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[String,User,String,List[SenderReceiverTransaction],List[SenderReceiverTransaction],String,List[CurrencyExchange],Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titile: String, user: User, nav: String, blockedRemittanceTransactions: List[SenderReceiverTransaction], rejectedAndApprovedTxs: List[SenderReceiverTransaction], notificationInterval: String, listCurrencies: List[CurrencyExchange] = null)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.256*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>"""),_display_(/*9.11*/titile),format.raw/*9.17*/("""</title>
		<link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.53*/routes/*10.59*/.Assets.at("images/favicon.jpg")),format.raw/*10.91*/("""" />
		
		<!-- CSS Bootstrap -->
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*13.64*/routes/*13.70*/.Assets.at("bootstrap/css/bootstrap.min.css")),format.raw/*13.115*/("""" />
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*14.64*/routes/*14.70*/.Assets.at("bootstrap/css/bootstrap-switch.min.css")),format.raw/*14.122*/("""" />
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*15.64*/routes/*15.70*/.Assets.at("bootstrap/css/bootstrapValidator.min.css")),format.raw/*15.124*/("""" />
		<!-- CSS dataTables -->
		<link rel="stylesheet" type="text/css" href=""""),_display_(/*17.49*/routes/*17.55*/.Assets.at("plugins/datatables-1.10.2/media/css/jquery.dataTables.min.css")),format.raw/*17.130*/(""""/>
		<link rel="stylesheet" type="text/css" href=""""),_display_(/*18.49*/routes/*18.55*/.Assets.at("plugins/datatables-1.10.2/media/css/dataTables.bootstrap.css")),format.raw/*18.129*/(""""/>
		<!-- CSS datePicker -->
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*20.64*/routes/*20.70*/.Assets.at("plugins/datepicker/codebase/dhtmlxcalendar.css")),format.raw/*20.130*/("""" />
		<!-- CSS Bootstrap Validator -->
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*22.64*/routes/*22.70*/.Assets.at("bootstrap/css/bootstrapValidator.min.css")),format.raw/*22.124*/("""" />
		<!-- CSS Custom -->
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*24.64*/routes/*24.70*/.Assets.at("stylesheets/main.css")),format.raw/*24.104*/("""" />
		<style type="text/css" media="print">
			html, body """),format.raw/*26.15*/("""{"""),format.raw/*26.16*/("""
				"""),format.raw/*27.5*/("""width:210mm; 
				height:297mm;
				margin:auto;
				padding:0;
			"""),format.raw/*31.4*/("""}"""),format.raw/*31.5*/("""
			"""),format.raw/*32.4*/("""body"""),format.raw/*32.8*/("""{"""),format.raw/*32.9*/("""
				"""),format.raw/*33.5*/("""font-size:12px;
			"""),format.raw/*34.4*/("""}"""),format.raw/*34.5*/("""
			"""),format.raw/*35.4*/(""".row"""),format.raw/*35.8*/("""{"""),format.raw/*35.9*/("""
				"""),format.raw/*36.5*/("""display:inline-block;
				width:100%;
				vertical-align: top;
			"""),format.raw/*39.4*/("""}"""),format.raw/*39.5*/("""
			"""),format.raw/*40.4*/(""".childDiv"""),format.raw/*40.13*/("""{"""),format.raw/*40.14*/("""
				"""),format.raw/*41.5*/("""width:120mm;
				float:right;
			"""),format.raw/*43.4*/("""}"""),format.raw/*43.5*/("""
			"""),format.raw/*44.4*/(""".childDiv2"""),format.raw/*44.14*/("""{"""),format.raw/*44.15*/("""
				"""),format.raw/*45.5*/("""width:100mm;
				float:right;
			"""),format.raw/*47.4*/("""}"""),format.raw/*47.5*/("""
			
			"""),format.raw/*49.4*/("""/* Box1 */
			.box1-y"""),format.raw/*50.11*/("""{"""),format.raw/*50.12*/("""margin-top:61mm;"""),format.raw/*50.28*/("""}"""),format.raw/*50.29*/("""
			
			"""),format.raw/*52.4*/("""/* Box2 */
			.box2-y"""),format.raw/*53.11*/("""{"""),format.raw/*53.12*/("""margin-top:84mm;"""),format.raw/*53.28*/("""}"""),format.raw/*53.29*/("""
			
			"""),format.raw/*55.4*/("""/* Box3 */
			.box3-y"""),format.raw/*56.11*/("""{"""),format.raw/*56.12*/("""margin-top:127mm;"""),format.raw/*56.29*/("""}"""),format.raw/*56.30*/("""
			
			"""),format.raw/*58.4*/("""/* Box4 */
			.box4-y"""),format.raw/*59.11*/("""{"""),format.raw/*59.12*/("""margin-top:235mm;"""),format.raw/*59.29*/("""}"""),format.raw/*59.30*/("""
			
			"""),format.raw/*61.4*/("""/* Box5 */
			.box5-y"""),format.raw/*62.11*/("""{"""),format.raw/*62.12*/("""margin-top:284mm;"""),format.raw/*62.29*/("""}"""),format.raw/*62.30*/("""

			"""),format.raw/*64.4*/(""".childDiv > div"""),format.raw/*64.19*/("""{"""),format.raw/*64.20*/("""
				"""),format.raw/*65.5*/("""padding:2px 0 0 2px;
			"""),format.raw/*66.4*/("""}"""),format.raw/*66.5*/("""
			"""),format.raw/*67.4*/(""".childDiv2 > div > div"""),format.raw/*67.26*/("""{"""),format.raw/*67.27*/("""
				"""),format.raw/*68.5*/("""display: table-cell; 
				vertical-align: middle;
				min-width:45mm;
				padding-left:2px;
			"""),format.raw/*72.4*/("""}"""),format.raw/*72.5*/("""
		"""),format.raw/*73.3*/("""</style>	
	
		<!-- jQuery -->
		<script src=""""),_display_(/*76.17*/routes/*76.23*/.Assets.at("javascripts/jquery-1.11.1.min.js")),format.raw/*76.69*/(""""></script>
		<!-- JS dataTables -->
		<!-- <script type="text/javascript" language="javascript" src=""""),_display_(/*78.67*/routes/*78.73*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.js")),format.raw/*78.131*/("""" defer></script>-->
		<script type="text/javascript" language="javascript" src=""""),_display_(/*79.62*/routes/*79.68*/.Assets.at("plugins/datatables-1.10.2/media/js/jquery.dataTables.min.js")),format.raw/*79.141*/("""" defer></script>
		<script type="text/javascript" language="javascript" src=""""),_display_(/*80.62*/routes/*80.68*/.Assets.at("plugins/datatables-1.10.2/media/js/dataTables.bootstrap.js")),format.raw/*80.140*/("""" defer></script>
		<!-- JS Bootstrap Validator -->
		<script type="text/javascript" src=""""),_display_(/*82.40*/routes/*82.46*/.Assets.at("bootstrap/js/bootstrapValidator.min.js")),format.raw/*82.98*/("""" defer></script>
		<!-- JS datePicker -->
		<script type="text/javascript" language="javascript" src=""""),_display_(/*84.62*/routes/*84.68*/.Assets.at("plugins/datepicker/codebase/dhtmlxcalendar.js")),format.raw/*84.127*/("""" defer></script>
		
		<script type="text/javascript" language="javascript" src=""""),_display_(/*86.62*/routes/*86.68*/.Assets.at("javascripts/fn-utils.js")),format.raw/*86.105*/(""""></script>
		
		<script type="text/javascript" language="javascript">
			var reviewingRemittanceTxId = 0;
			$(document).ready(function()"""),format.raw/*90.32*/("""{"""),format.raw/*90.33*/("""
				"""),format.raw/*91.5*/("""$('#lnkChangePassword').on('click',function(e)"""),format.raw/*91.51*/("""{"""),format.raw/*91.52*/("""
					"""),format.raw/*92.6*/("""e.preventDefault();
					$('#username').val('"""),_display_(/*93.27*/user/*93.31*/.getUsername()),format.raw/*93.45*/("""');
					$('#modalChangePassword').modal("show");
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/(""");
				$('#modalChangePassword').on('hide.bs.modal', function() """),format.raw/*96.62*/("""{"""),format.raw/*96.63*/("""
					"""),format.raw/*97.6*/("""$('#frmChangePassword').bootstrapValidator('resetForm', true);
				"""),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""");
				
			    /* Validate form Change Password and submit */
			    $('#frmChangePassword').bootstrapValidator("""),format.raw/*101.51*/("""{"""),format.raw/*101.52*/("""
			    	"""),format.raw/*102.9*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
			    	live: 'enabled',
			    	container: 'tooltip',
			        feedbackIcons: """),format.raw/*105.27*/("""{"""),format.raw/*105.28*/("""
			            """),format.raw/*106.16*/("""valid: 'glyphicon',
			            invalid: 'glyphicon',
			            validating: 'glyphicon glyphicon-refresh'
			        """),format.raw/*109.12*/("""}"""),format.raw/*109.13*/(""",
			        fields: """),format.raw/*110.20*/("""{"""),format.raw/*110.21*/("""
			        	"""),format.raw/*111.13*/("""currentPassword: """),format.raw/*111.30*/("""{"""),format.raw/*111.31*/("""
		                    """),format.raw/*112.23*/("""validators: """),format.raw/*112.35*/("""{"""),format.raw/*112.36*/("""
		                    	"""),format.raw/*113.24*/("""notEmpty: """),format.raw/*113.34*/("""{"""),format.raw/*113.35*/("""
		                    		"""),format.raw/*114.25*/("""message: 'Required'
		                    	"""),format.raw/*115.24*/("""}"""),format.raw/*115.25*/(""",
			        			callback: """),format.raw/*116.25*/("""{"""),format.raw/*116.26*/("""
			        				"""),format.raw/*117.16*/("""message: 'Your password was incorrect.',
			    					callback: function(value, validator, $field) """),format.raw/*118.58*/("""{"""),format.raw/*118.59*/("""
			    				    	"""),format.raw/*119.17*/("""var currentPassword = $('#currentPassword').val();
			    				    	if(currentPassword != '"""),_display_(/*120.41*/user/*120.45*/.getPassword()),format.raw/*120.59*/("""')"""),format.raw/*120.61*/("""{"""),format.raw/*120.62*/("""
			    							"""),format.raw/*121.15*/("""return false;
			    						"""),format.raw/*122.14*/("""}"""),format.raw/*122.15*/("""else"""),format.raw/*122.19*/("""{"""),format.raw/*122.20*/("""
											"""),format.raw/*123.12*/("""return true;
				    					"""),format.raw/*124.14*/("""}"""),format.raw/*124.15*/("""
			    					"""),format.raw/*125.13*/("""}"""),format.raw/*125.14*/("""		        				
			        			"""),format.raw/*126.15*/("""}"""),format.raw/*126.16*/("""	                        
		                    """),format.raw/*127.23*/("""}"""),format.raw/*127.24*/("""
		                """),format.raw/*128.19*/("""}"""),format.raw/*128.20*/(""",		            
		                newPassword: """),format.raw/*129.32*/("""{"""),format.raw/*129.33*/("""
		                    """),format.raw/*130.23*/("""validators: """),format.raw/*130.35*/("""{"""),format.raw/*130.36*/("""
		                    	"""),format.raw/*131.24*/("""stringLength: """),format.raw/*131.38*/("""{"""),format.raw/*131.39*/("""
		                    		"""),format.raw/*132.25*/("""min: 6,
		                    		message: 'Min is 6 characters long'
		                    	"""),format.raw/*134.24*/("""}"""),format.raw/*134.25*/(""",
		                        identical: """),format.raw/*135.38*/("""{"""),format.raw/*135.39*/("""
		                            """),format.raw/*136.31*/("""field: 'confirmNewPassword',
		                        	message: 'Passwords do not match'
		                        """),format.raw/*138.27*/("""}"""),format.raw/*138.28*/("""	                        
		                    """),format.raw/*139.23*/("""}"""),format.raw/*139.24*/("""
		                """),format.raw/*140.19*/("""}"""),format.raw/*140.20*/(""",
		                confirmNewPassword: """),format.raw/*141.39*/("""{"""),format.raw/*141.40*/("""
		                    """),format.raw/*142.23*/("""validators: """),format.raw/*142.35*/("""{"""),format.raw/*142.36*/("""
		                    	"""),format.raw/*143.24*/("""stringLength: """),format.raw/*143.38*/("""{"""),format.raw/*143.39*/("""
		                    		"""),format.raw/*144.25*/("""min: 6,
		                    		message: 'Min is 6 characters long'
		                    	"""),format.raw/*146.24*/("""}"""),format.raw/*146.25*/(""",
		                        identical: """),format.raw/*147.38*/("""{"""),format.raw/*147.39*/("""
		                            """),format.raw/*148.31*/("""field: 'newPassword',
		                        	message: 'Passwords do not match'
		                        """),format.raw/*150.27*/("""}"""),format.raw/*150.28*/("""	                        
		                    """),format.raw/*151.23*/("""}"""),format.raw/*151.24*/("""
		                """),format.raw/*152.19*/("""}"""),format.raw/*152.20*/("""
			        """),format.raw/*153.12*/("""}"""),format.raw/*153.13*/("""
			    """),format.raw/*154.8*/("""}"""),format.raw/*154.9*/(""")
			    .on('success.form.bv', function(e) """),format.raw/*155.43*/("""{"""),format.raw/*155.44*/("""
			    	"""),format.raw/*156.9*/("""e.preventDefault();
					var that = $(this),
					url = that.attr('action'),
					type = that.attr('method'),
					data = """),format.raw/*160.13*/("""{"""),format.raw/*160.14*/("""}"""),format.raw/*160.15*/(""";
					that.find('[name]').each(function(index, value)"""),format.raw/*161.53*/("""{"""),format.raw/*161.54*/("""
						"""),format.raw/*162.7*/("""var that = $(this),
							name = that.attr('name'),
							value = that.val();
						data[name] = value;
					"""),format.raw/*166.6*/("""}"""),format.raw/*166.7*/(""");
					data['updateTime'] = new Date().getTime();
					$.ajax("""),format.raw/*168.13*/("""{"""),format.raw/*168.14*/("""
		       			"""),format.raw/*169.13*/("""url: url,
		       			type: type,
		       			dataType: 'json',
		       			data: JSON.stringify(data),
		       			contentType : "application/json",
		       			success: function(response) """),format.raw/*174.41*/("""{"""),format.raw/*174.42*/("""
		       				"""),format.raw/*175.14*/("""if(response == 'json_expected')"""),format.raw/*175.45*/("""{"""),format.raw/*175.46*/("""
					       		"""),format.raw/*176.15*/("""$('#pwd-alert-danger').removeClass('hidden');
				       			setTimeout(function()"""),format.raw/*177.36*/("""{"""),format.raw/*177.37*/("""
				       				"""),format.raw/*178.16*/("""$('#pwd-alert-danger').addClass('hidden');
				       			"""),format.raw/*179.15*/("""}"""),format.raw/*179.16*/(""", 2000);
						    """),format.raw/*180.11*/("""}"""),format.raw/*180.12*/("""else"""),format.raw/*180.16*/("""{"""),format.raw/*180.17*/("""
				       			"""),format.raw/*181.15*/("""$('#pwd-alert-success').removeClass('hidden');
				       			setTimeout(function()"""),format.raw/*182.36*/("""{"""),format.raw/*182.37*/("""
				       				"""),format.raw/*183.16*/("""$('#pwd-alert-success').addClass('hidden');
					       			$('#modalChangePassword').modal("hide");
				       			"""),format.raw/*185.15*/("""}"""),format.raw/*185.16*/(""", 2000);
				       		"""),format.raw/*186.14*/("""}"""),format.raw/*186.15*/("""
			       		"""),format.raw/*187.13*/("""}"""),format.raw/*187.14*/(""",
			            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*188.63*/("""{"""),format.raw/*188.64*/("""
				            """),format.raw/*189.17*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*189.103*/("""{"""),format.raw/*189.104*/("""}"""),format.raw/*189.105*/(""");
			            """),format.raw/*190.16*/("""}"""),format.raw/*190.17*/("""
			       	"""),format.raw/*191.12*/("""}"""),format.raw/*191.13*/(""");
				    return false;
			    """),format.raw/*193.8*/("""}"""),format.raw/*193.9*/(""");
				
				<!-- pull notifications for CO -->
				"""),_display_(/*196.6*/if(user.getRole().getCode()=="role_compliance_officer")/*196.61*/{_display_(Seq[Any](format.raw/*196.62*/("""	
					
					"""),format.raw/*198.6*/("""(function workerForCO() """),format.raw/*198.30*/("""{"""),format.raw/*198.31*/("""
						  """),format.raw/*199.9*/("""$.ajax("""),format.raw/*199.16*/("""{"""),format.raw/*199.17*/("""
						    """),format.raw/*200.11*/("""url: '"""),_display_(/*200.18*/routes/*200.24*/.RemittanceController.getNotificationsForCO()),format.raw/*200.69*/("""', 
						    type: "get",
						    success: function(response) """),format.raw/*202.39*/("""{"""),format.raw/*202.40*/("""
							    """),format.raw/*203.12*/("""var blockingTxs = response.result;
							    
							    $('#dropdownBlockingTx').html('');

							    var part3 = '';
							    for(var i=0; i<blockingTxs.length; i++)"""),format.raw/*208.51*/("""{"""),format.raw/*208.52*/("""
							    	"""),format.raw/*209.13*/("""var blockingTx = blockingTxs[i];
									var reviewButtonId = 'transaction_reviewed-' + blockingTx.id;
								    var l1 = '<li id="menu-item' + blockingTx.id + '"><a class="pull-right">',
								    	l2 = blockingTx.reason,
								    	l3 = '&nbsp;<button type="button" id="' + reviewButtonId + '" class="btn btn-info btn-xs notif-action-button"><span class="glyphicon glyphicon-search"></span> Review</button>',
									    l4 = '</a></li>';
									    part3 = part3 + l1 + l2 + l3 + l4;
								"""),format.raw/*216.9*/("""}"""),format.raw/*216.10*/("""

								"""),format.raw/*218.9*/("""var part1 = '<a class="dropdown-toggle" data-toggle="dropdown" href=""><span class="badge red" id="badgeBlockingTx"></span> Message<b class="caret"></b></a>',
								    part2 = '<ul class="dropdown-menu dropdown-menu-notif scrollable-menu" role="menu" id="dropdownMenuBlockingTx">',
								    part4 = '</ul>';
							    $('#dropdownBlockingTx').append(part1 + part2 + part3 + part4);

							    if(blockingTxs.length > 0)"""),format.raw/*223.38*/("""{"""),format.raw/*223.39*/("""
							    	"""),format.raw/*224.13*/("""$('#badgeBlockingTx').show();
							    	$('#badgeBlockingTx').html(blockingTxs.length);
								"""),format.raw/*226.9*/("""}"""),format.raw/*226.10*/("""else"""),format.raw/*226.14*/("""{"""),format.raw/*226.15*/("""
									"""),format.raw/*227.10*/("""$('#badgeBlockingTx').hide();
									$('#dropdownMenuBlockingTx').hide();
								"""),format.raw/*229.9*/("""}"""),format.raw/*229.10*/("""

								"""),format.raw/*231.9*/("""<!-- prevent closing dropdown when click on dropdown items -->
							    $('ul.dropdown-menu').click(function(e) """),format.raw/*232.52*/("""{"""),format.raw/*232.53*/("""
								    """),format.raw/*233.13*/("""if($('li.dropdown').hasClass('open'))"""),format.raw/*233.50*/("""{"""),format.raw/*233.51*/("""
								    	"""),format.raw/*234.14*/("""e.stopPropagation();
									"""),format.raw/*235.10*/("""}"""),format.raw/*235.11*/("""
							    """),format.raw/*236.12*/("""}"""),format.raw/*236.13*/(""");

						    """),format.raw/*238.11*/("""}"""),format.raw/*238.12*/(""", /* end success */
						    complete: function() """),format.raw/*239.32*/("""{"""),format.raw/*239.33*/("""
						      """),format.raw/*240.13*/("""// Schedule the next request when the current one's complete in ms
						      setTimeout(workerForCO, parseInt("""),_display_(/*241.47*/notificationInterval),format.raw/*241.67*/(""")*1000);
						    """),format.raw/*242.11*/("""}"""),format.raw/*242.12*/("""
						  """),format.raw/*243.9*/("""}"""),format.raw/*243.10*/(""");
					"""),format.raw/*244.6*/("""}"""),format.raw/*244.7*/(""")();
					
					$("button[name=btnApprove]").on("click", function()"""),format.raw/*246.57*/("""{"""),format.raw/*246.58*/("""
						"""),format.raw/*247.7*/("""var actionButton = $(this);
						var status = actionButton.attr('id').split('-')[0];
						var transactionId = actionButton.attr('id').split('-')[1];

						if(status == 'transaction_reviewed')"""),format.raw/*251.43*/("""{"""),format.raw/*251.44*/("""
							"""),format.raw/*252.8*/("""$('button[name="btnReject"]').attr('id', 'transaction_rejected-' + transactionId);
							$('button[name="btnApprove"]').attr('id', 'transaction_approved-' + transactionId);
							reviewingRemittanceTxId = transactionId;
						"""),format.raw/*255.7*/("""}"""),format.raw/*255.8*/("""
						"""),format.raw/*256.7*/("""else if(status == 'transaction_rejected' || status == 'transaction_approved')"""),format.raw/*256.84*/("""{"""),format.raw/*256.85*/("""
							"""),format.raw/*257.8*/("""transactionId = reviewingRemittanceTxId;
						"""),format.raw/*258.7*/("""}"""),format.raw/*258.8*/("""

						"""),format.raw/*260.7*/("""$.ajax("""),format.raw/*260.14*/("""{"""),format.raw/*260.15*/("""
			       			"""),format.raw/*261.14*/("""url: '"""),_display_(/*261.21*/routes/*261.27*/.RemittanceController.updateTransactionStatus()),format.raw/*261.74*/("""' + '?transactionId=' + transactionId + "&status=" + status,
			       			type: 'post',
			       			success: function(response) """),format.raw/*263.42*/("""{"""),format.raw/*263.43*/("""
				       			"""),format.raw/*264.15*/("""if(response.response == 'review')"""),format.raw/*264.48*/("""{"""),format.raw/*264.49*/("""
			       					"""),format.raw/*265.16*/("""preparePopupBeforeEdit(response); 
			       					$('#popupAddUpdateRemittant').modal("show");
					       		"""),format.raw/*267.15*/("""}"""),format.raw/*267.16*/("""
				       			"""),format.raw/*268.15*/("""else if(response.response == 'non-review')"""),format.raw/*268.57*/("""{"""),format.raw/*268.58*/("""
				       				"""),format.raw/*269.16*/("""$('#popupAddUpdateRemittant').modal("hide");
				       				$('#menu-item' + transactionId).hide();
				       				var numMsg = $('#badgeBlockingTx').html().trim();
			       				   	var updatedNumMsg = parseInt(numMsg)-1;
			       				 	$('#badgeBlockingTx').html(updatedNumMsg);
			       				    if(updatedNumMsg==0)"""),format.raw/*274.39*/("""{"""),format.raw/*274.40*/("""
			       				    	"""),format.raw/*275.20*/("""$('#badgeBlockingTx').hide();
			       				    	$('.dropdown-menu-notif').hide();
				       				"""),format.raw/*277.16*/("""}"""),format.raw/*277.17*/("""
					       		"""),format.raw/*278.15*/("""}"""),format.raw/*278.16*/("""
				       		"""),format.raw/*279.14*/("""}"""),format.raw/*279.15*/(""",
				            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*280.64*/("""{"""),format.raw/*280.65*/("""
								"""),format.raw/*281.9*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*281.95*/("""{"""),format.raw/*281.96*/("""}"""),format.raw/*281.97*/(""");
				            """),format.raw/*282.17*/("""}"""),format.raw/*282.18*/("""
				       	"""),format.raw/*283.13*/("""}"""),format.raw/*283.14*/(""");
	       				
					"""),format.raw/*285.6*/("""}"""),format.raw/*285.7*/(""");
					
				""")))}),format.raw/*287.6*/(""" """),format.raw/*287.7*/("""<!-- pull notifications for CO -->
				
				"""),_display_(/*289.6*/if(user.getRole().getCode()!= "role_teller")/*289.50*/{_display_(Seq[Any](format.raw/*289.51*/("""
					"""),format.raw/*290.6*/("""$('#popupAddUpdateRemittant .modal-header :input[type="text"]').attr('disabled', true);
					$('#popupAddUpdateRemittant .modal-body :input').attr('disabled', true);
				""")))}),format.raw/*292.6*/("""
				
				"""),format.raw/*294.5*/("""<!-- pull notifications for Teller -->
				"""),_display_(/*295.6*/if(user.getRole().getCode()=="role_teller")/*295.49*/{_display_(Seq[Any](format.raw/*295.50*/("""	
					"""),format.raw/*296.6*/("""(function workerForTeller() """),format.raw/*296.34*/("""{"""),format.raw/*296.35*/("""
						  """),format.raw/*297.9*/("""$.ajax("""),format.raw/*297.16*/("""{"""),format.raw/*297.17*/("""
							"""),format.raw/*298.8*/("""url: '"""),_display_(/*298.15*/routes/*298.21*/.RemittanceController.getNotificationsForTeller()),format.raw/*298.70*/("""', 
							type: "get",
							success: function(response) """),format.raw/*300.36*/("""{"""),format.raw/*300.37*/("""
								"""),format.raw/*301.9*/("""var rejectedAndApprovedTxs = response.result;
								
								$('#dropdownRejectedApprovedTx').html('');

								var part3 = '';
								for(var i=0; i<rejectedAndApprovedTxs.length; i++)"""),format.raw/*306.59*/("""{"""),format.raw/*306.60*/("""
									"""),format.raw/*307.10*/("""var rejectedAndApprovedTx = rejectedAndApprovedTxs[i];
									var reviewButtonId = 'transaction_reviewed-' + rejectedAndApprovedTx.id;
									var l1 = '<li id="menu-item' + rejectedAndApprovedTx.id + '"><a class="pull-right">';
									var	l2 = '';
									if(rejectedAndApprovedTx.transactionStatus == 'transaction_rejected')"""),format.raw/*311.79*/("""{"""),format.raw/*311.80*/("""
										"""),format.raw/*312.11*/("""l2 = '[Rejected] ' + rejectedAndApprovedTx.reason;
										l2 = l2 + '&nbsp;<button type="button" id="transaction_blocked-' + rejectedAndApprovedTx.id + '" class="btn btn-success btn-xs notif-action-button"><span class="glyphicon glyphicon-ok"></span> Ok</button>';
									"""),format.raw/*314.10*/("""}"""),format.raw/*314.11*/("""
									"""),format.raw/*315.10*/("""else if(rejectedAndApprovedTx.transactionStatus == 'transaction_approved')"""),format.raw/*315.84*/("""{"""),format.raw/*315.85*/("""
										"""),format.raw/*316.11*/("""l2 = '[Approved] ' + rejectedAndApprovedTx.reason;
										l2 = l2 + '&nbsp;<button type="button" id="' + rejectedAndApprovedTx.id + '" class="btn btn-success btn-xs continue-tx-button"><span class="glyphicon glyphicon-ok"></span> Ok</button>';
									"""),format.raw/*318.10*/("""}"""),format.raw/*318.11*/("""
									"""),format.raw/*319.10*/("""var	l3 = '</a></li>';
									part3 = part3 + l1 + l2 + l3;
								"""),format.raw/*321.9*/("""}"""),format.raw/*321.10*/("""

								"""),format.raw/*323.9*/("""var part1 = '<a class="dropdown-toggle" data-toggle="dropdown" href=""><span class="badge red" id="badgeRejectedApprovedTx"></span> Message<b class="caret"></b></a>',
									part2 = '<ul class="dropdown-menu dropdown-menu-notif scrollable-menu" role="menu" id="dropdownMenuRejectedApprovedTx">',
									part4 = '</ul>';
								$('#dropdownRejectedApprovedTx').append(part1 + part2 + part3 + part4);

								if(rejectedAndApprovedTxs.length > 0)"""),format.raw/*328.46*/("""{"""),format.raw/*328.47*/("""
									"""),format.raw/*329.10*/("""$('#badgeRejectedApprovedTx').show();
									$('#badgeRejectedApprovedTx').html(rejectedAndApprovedTxs.length);
								"""),format.raw/*331.9*/("""}"""),format.raw/*331.10*/("""else"""),format.raw/*331.14*/("""{"""),format.raw/*331.15*/("""
									"""),format.raw/*332.10*/("""$('#badgeRejectedApprovedTx').hide();
									$('#dropdownMenuRejectedApprovedTx').hide();
								"""),format.raw/*334.9*/("""}"""),format.raw/*334.10*/("""

								"""),format.raw/*336.9*/("""<!-- prevent closing dropdown when click on dropdown items -->
								$('ul.dropdown-menu').click(function(e) """),format.raw/*337.49*/("""{"""),format.raw/*337.50*/("""
									"""),format.raw/*338.10*/("""if($('li.dropdown').hasClass('open'))"""),format.raw/*338.47*/("""{"""),format.raw/*338.48*/("""
										"""),format.raw/*339.11*/("""e.stopPropagation();
									"""),format.raw/*340.10*/("""}"""),format.raw/*340.11*/("""
								"""),format.raw/*341.9*/("""}"""),format.raw/*341.10*/(""");
								
							"""),format.raw/*343.8*/("""}"""),format.raw/*343.9*/(""", /* end success */
							complete: function() """),format.raw/*344.29*/("""{"""),format.raw/*344.30*/("""
							  """),format.raw/*345.10*/("""// Schedule the next request when the current one's complete in ms
							  setTimeout(workerForTeller, parseInt("""),_display_(/*346.48*/notificationInterval),format.raw/*346.68*/(""")*1000);
							"""),format.raw/*347.8*/("""}"""),format.raw/*347.9*/("""
						  """),format.raw/*348.9*/("""}"""),format.raw/*348.10*/(""");
					"""),format.raw/*349.6*/("""}"""),format.raw/*349.7*/(""")();
					
					
					$('.continue-tx-button').click(function()"""),format.raw/*352.47*/("""{"""),format.raw/*352.48*/("""
						"""),format.raw/*353.7*/("""var txId = $(this).attr('id');
						if($('#tabReceiver').hasClass('active'))"""),format.raw/*354.47*/("""{"""),format.raw/*354.48*/("""
							"""),format.raw/*355.8*/("""window.location.href = '"""),_display_(/*355.33*/routes/*355.39*/.RemittanceController.continueTransaction()),format.raw/*355.82*/("""' + '?continuingTransactionId=' + txId;
						"""),format.raw/*356.7*/("""}"""),format.raw/*356.8*/("""else if($('#tabRemittance').hasClass('active'))"""),format.raw/*356.55*/("""{"""),format.raw/*356.56*/("""
							"""),format.raw/*357.8*/("""var requestUrl = '"""),_display_(/*357.27*/routes/*357.33*/.RemittanceController.getById()),format.raw/*357.64*/("""' + "?transactionId=" + txId;
							showModalRemittance(requestUrl, """"),_display_(/*358.42*/user/*358.46*/.getRole().getCode()),format.raw/*358.66*/("""");
						"""),format.raw/*359.7*/("""}"""),format.raw/*359.8*/("""
					"""),format.raw/*360.6*/("""}"""),format.raw/*360.7*/(""");
					
					$(".notif-action-button").on("click", function()"""),format.raw/*362.54*/("""{"""),format.raw/*362.55*/("""
						"""),format.raw/*363.7*/("""var actionButton = $(this);
						//var status = actionButton.attr('id').split('-')[0];
						var transactionId = actionButton.attr('id').split('-')[1];
						$.ajax("""),format.raw/*366.14*/("""{"""),format.raw/*366.15*/("""
			       			"""),format.raw/*367.14*/("""//url: 'remittance/updateTransactionStatus?remittanceTransactionId=' + transactionId + "&status=transaction_rejected_view",
			       			url: '"""),_display_(/*368.21*/routes/*368.27*/.RemittanceController.updateTransactionStatus()),format.raw/*368.74*/("""' + '?transactionId=' + transactionId + "&status=transaction_rejected_view" ,
			       			type: 'post',
			       			success: function(response) """),format.raw/*370.42*/("""{"""),format.raw/*370.43*/("""
				       			"""),format.raw/*371.15*/("""// TODO
				       		"""),format.raw/*372.14*/("""}"""),format.raw/*372.15*/(""",
				            error: function(jqXHR, textStatus, errorThrown)"""),format.raw/*373.64*/("""{"""),format.raw/*373.65*/("""
								"""),format.raw/*374.9*/("""bootbox.alert(jqXHR.status + ' : ' + textStatus + ', ' + jqXHR.statusText, function() """),format.raw/*374.95*/("""{"""),format.raw/*374.96*/("""}"""),format.raw/*374.97*/(""");
				            """),format.raw/*375.17*/("""}"""),format.raw/*375.18*/("""
				       	"""),format.raw/*376.13*/("""}"""),format.raw/*376.14*/(""");
	       				
					"""),format.raw/*378.6*/("""}"""),format.raw/*378.7*/(""");
				""")))}),format.raw/*379.6*/(""" """),format.raw/*379.7*/("""<!-- pull notifications for Teller -->

			"""),format.raw/*381.4*/("""}"""),format.raw/*381.5*/(""");	/* end document ready */
			
		</script>
	</head>
	
    <body class="container">	
   		"""),_display_(/*387.7*/if(user != null)/*387.23*/{_display_(Seq[Any](format.raw/*387.24*/("""
		"""),format.raw/*388.3*/("""<div id="dic_bubble" class="selection_bubble fontSize13 noSelect" style="z-index: 9999; border: 1px solid rgb(74, 174, 222); visibility: hidden;"></div>
		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header" style="margin-right:5px;border:solid 1px #fff;">
				  <a href=""""),_display_(/*392.17*/routes/*392.23*/.Application.index()),format.raw/*392.43*/(""""><img alt="" src=""""),_display_(/*392.63*/routes/*392.69*/.Assets.at("images/logo.jpg")),format.raw/*392.98*/("""" height="48" width="48"/></a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
			            """),_display_(/*396.17*/if(user.getRole().getCode()=="role_administrator")/*396.67*/{_display_(Seq[Any](format.raw/*396.68*/("""
			            	"""),format.raw/*397.17*/("""<li """),_display_(/*397.22*/if(nav=="user")/*397.37*/{_display_(Seq[Any](format.raw/*397.38*/("""class="active"""")))}),format.raw/*397.53*/("""><a href=""""),_display_(/*397.64*/routes/*397.70*/.UserController.index()),format.raw/*397.93*/("""">USER</a></li>
							<li """),_display_(/*398.13*/if(nav=="sender")/*398.30*/{_display_(Seq[Any](format.raw/*398.31*/("""class="active"""")))}),format.raw/*398.46*/("""><a href=""""),_display_(/*398.57*/routes/*398.63*/.SenderController.index()),format.raw/*398.88*/("""">SENDER</a></li>
							<li """),_display_(/*399.13*/if(nav=="receiver")/*399.32*/{_display_(Seq[Any](format.raw/*399.33*/("""class="active"""")))}),format.raw/*399.48*/("""><a href=""""),_display_(/*399.59*/routes/*399.65*/.ReceiverController.index()),format.raw/*399.92*/("""">RECEIVER</a></li>
							<li """),_display_(/*400.13*/if(nav=="remittance")/*400.34*/{_display_(Seq[Any](format.raw/*400.35*/("""class="active"""")))}),format.raw/*400.50*/("""><a href=""""),_display_(/*400.61*/routes/*400.67*/.RemittanceController.index()),format.raw/*400.96*/("""">REMITTANCE</a></li>
							<li """),_display_(/*401.13*/if(nav=="report")/*401.30*/{_display_(Seq[Any](format.raw/*401.31*/("""class="active"""")))}),format.raw/*401.46*/("""><a href=""""),_display_(/*401.57*/routes/*401.63*/.ReportController.index()),format.raw/*401.88*/("""">REPORT</a></li>
			            	<li """),_display_(/*402.22*/if(nav=="rule_fill_amount_managment")/*402.59*/{_display_(Seq[Any](format.raw/*402.60*/("""class="active"""")))}),format.raw/*402.75*/("""><a href=""""),_display_(/*402.86*/routes/*402.92*/.RuleFillAmountManagementController.index()),format.raw/*402.135*/("""">RULE FILL AMOUNT</a></li>
			            """)))}),format.raw/*403.17*/("""
			            """),_display_(/*404.17*/if(user.getRole().getCode()=="role_compliance_officer")/*404.72*/{_display_(Seq[Any](format.raw/*404.73*/("""
			            	"""),format.raw/*405.17*/("""<li """),_display_(/*405.22*/if(nav=="sender")/*405.39*/{_display_(Seq[Any](format.raw/*405.40*/("""class="active"""")))}),format.raw/*405.55*/("""><a href=""""),_display_(/*405.66*/routes/*405.72*/.SenderController.index()),format.raw/*405.97*/("""">SENDER</a></li>
			            	<li """),_display_(/*406.22*/if(nav=="remittance")/*406.43*/{_display_(Seq[Any](format.raw/*406.44*/("""class="active"""")))}),format.raw/*406.59*/("""><a href=""""),_display_(/*406.70*/routes/*406.76*/.RemittanceController.index()),format.raw/*406.105*/("""">REMITTANCE</a></li>
			            	<li """),_display_(/*407.22*/if(nav=="report")/*407.39*/{_display_(Seq[Any](format.raw/*407.40*/("""class="active"""")))}),format.raw/*407.55*/("""><a href=""""),_display_(/*407.66*/routes/*407.72*/.ReportController.index()),format.raw/*407.97*/("""">REPORT</a></li>
			            """)))}),format.raw/*408.17*/("""
			            """),_display_(/*409.17*/if(user.getRole().getCode()=="role_teller")/*409.60*/{_display_(Seq[Any](format.raw/*409.61*/("""
							"""),format.raw/*410.8*/("""<li """),_display_(/*410.13*/if(nav=="remittance")/*410.34*/{_display_(Seq[Any](format.raw/*410.35*/("""class="active"""")))}),format.raw/*410.50*/(""" """),format.raw/*410.51*/("""id="tabRemittance"><a href=""""),_display_(/*410.80*/routes/*410.86*/.RemittanceController.index()),format.raw/*410.115*/("""">REMITTANCE</a></li>
							<li """),_display_(/*411.13*/if(nav=="receiver")/*411.32*/{_display_(Seq[Any](format.raw/*411.33*/("""class="active"""")))}),format.raw/*411.48*/(""" """),format.raw/*411.49*/("""id="tabReceiver"><a href=""""),_display_(/*411.76*/routes/*411.82*/.ReceiverController.index()),format.raw/*411.109*/("""">RECEIVER</a></li>
							<li """),_display_(/*412.13*/if(nav=="report")/*412.30*/{_display_(Seq[Any](format.raw/*412.31*/("""class="active"""")))}),format.raw/*412.46*/("""><a href=""""),_display_(/*412.57*/routes/*412.63*/.ReportController.index()),format.raw/*412.88*/("""">REPORT</a></li>				            
			            """)))}),format.raw/*413.17*/("""
			            """),_display_(/*414.17*/if(user.getRole().getCode()=="role_reporter")/*414.62*/{_display_(Seq[Any](format.raw/*414.63*/("""
			            	"""),format.raw/*415.17*/("""<li """),_display_(/*415.22*/if(nav=="report")/*415.39*/{_display_(Seq[Any](format.raw/*415.40*/("""class="active"""")))}),format.raw/*415.55*/("""><a href=""""),_display_(/*415.66*/routes/*415.72*/.ReportController.index()),format.raw/*415.97*/("""">REPORT</a></li>
			            	<li """),_display_(/*416.22*/if(nav=="remittance")/*416.43*/{_display_(Seq[Any](format.raw/*416.44*/("""class="active"""")))}),format.raw/*416.59*/("""><a href=""""),_display_(/*416.70*/routes/*416.76*/.RemittanceController.index()),format.raw/*416.105*/("""">REMITTANCE</a></li>
			            """)))}),format.raw/*417.17*/("""
					"""),format.raw/*418.6*/("""</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a class="dropdown-toggle"data-toggle="dropdown" href=""><span class="glyphicon glyphicon-user">&nbsp;</span>"""),_display_(/*421.118*/user/*421.122*/.getFullName()),format.raw/*421.136*/("""&nbsp;<b class="caret"></b></a>
							<ul class="dropdown-menu">
							"""),_display_(/*423.9*/if(user != null)/*423.25*/{_display_(Seq[Any](format.raw/*423.26*/("""
								"""),format.raw/*424.9*/("""<!-- <li><a href=""""),_display_(/*424.28*/routes/*424.34*/.SettingController.index()),format.raw/*424.60*/(""""><span class="glyphicon glyphicon-cog">&nbsp;</span>Settings</a></li>-->
								<li><a href="" id="lnkChangePassword"><span class="glyphicon glyphicon-lock">&nbsp;</span>Change password</a></li>
								<li class="divider"></li>
								<li><a href=""""),_display_(/*427.23*/routes/*427.29*/.LoginController.logout()),format.raw/*427.54*/(""""><span class="glyphicon glyphicon-off">&nbsp;</span>Sign out</a></li>
							""")))}),format.raw/*428.9*/("""
							"""),format.raw/*429.8*/("""</ul>
						</li>
					</ul>
					"""),_display_(/*432.7*/if(user.getRole().getCode()=="role_compliance_officer" && blockedRemittanceTransactions != null)/*432.103*/{_display_(Seq[Any](format.raw/*432.104*/("""
						"""),format.raw/*433.7*/("""<ul class="nav navbar-nav navbar-right">
							<li class="dropdown" id="dropdownBlockingTx">

							</li>
						</ul>
					""")))}),format.raw/*438.7*/("""
					"""),_display_(/*439.7*/if(user.getRole().getCode()=="role_teller" && rejectedAndApprovedTxs != null)/*439.84*/{_display_(Seq[Any](format.raw/*439.85*/("""
						"""),format.raw/*440.7*/("""<ul class="nav navbar-nav navbar-right">
							<li class="dropdown" id="dropdownRejectedApprovedTx">

							</li>
						</ul>
					""")))}),format.raw/*445.7*/("""
				"""),format.raw/*446.5*/("""</div>
			</div>
		</div>
		""")))}),format.raw/*449.4*/("""
   	 """),format.raw/*450.6*/("""<!-- contents --> 
		"""),_display_(/*451.4*/content),format.raw/*451.11*/("""
     """),format.raw/*452.6*/("""<!-- end contents --> 

	<!-- modal change password-->
	<div id="modalChangePassword" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalChangePassword" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title">Change Password</h4>
				</div>
				<form role="form" id="frmChangePassword" action=""""),_display_(/*462.55*/routes/*462.61*/.SettingController.changePassword()),format.raw/*462.96*/("""" method="post">
					<div class="modal-body">
						<div id="pwd-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
						<div id="pwd-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>JSON expected</div>
	
						<div class="row">
							<div class="col-md-6 form-group">
								<label class="control-label">Username</label>
								<input type="text" name="username" id="username" class="form-control" placeholder="username" disabled/>	
							</div>	
							<div class="col-md-6 form-group">
								<label class="control-label">Current password</label>
								<input type="password" name="currentPassword" id="currentPassword" class="form-control" placeholder="current password"/>
							</div>		
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<label class="control-label">New password</label>
								<input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="new password" required/>
							</div>	
							<div class="col-md-6 form-group">
								<label class="control-label">Confirm new password</label>
								<input type="password" name="confirmNewPassword" id="confirmNewPassword" class="form-control" placeholder="confirm new password" required/>	
							</div>			
						</div>
						
					</div>
					<div class="modal-footer">
						<button id="btnChangePassword" type="submit" class="btn btn-primary">Save</button>
						<button id="btnCancel" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end modal change password-->
	
	<!-- Remittance Popup -->
	"""),_display_(/*500.3*/if(listCurrencies != null)/*500.29*/ {_display_(Seq[Any](format.raw/*500.31*/("""
		"""),format.raw/*501.3*/("""<div id="popupAddUpdateRemittant" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAddUpdateRemittant" data-replace="true" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form id="frmRemittance" class="form-horizontal" role="form">
				<div class="modal-header">
					<div class="row">
				  		<div class="col-md-4">
							<h4 class="modal-title" id="myModalLabel"></h4>
				  		</div>
						<div class="col-md-4">
						  	<label for="txtDateTransaction">Date</label>
							<input type="text" style="height:25px;width:80%;" class="form-control" id="txtDateTransaction" name="txtDateTransaction" placeholder="Date" value="">
						</div>
						<div class="col-md-4">
							<button type="button" class="close" data-dismiss="modal" id="resetOnClose"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
							<label for="txtBankRef">Bank's Reference No.</label>
							<input type="text" style="height:25px;width:80%;" class="form-control" id="txtBankRef" name="txtBankRef" placeholder="Bank's Reference No" value="">
						 </div>
					</div>
				</div>
 			 <div class="modal-body">
	 			 <div id="remittance-alert-success" class="alert alert-success hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Saved successfully</div>
	 			 <div id="remittance-alert-warning" class="alert alert-warning hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Receiver exists</div>
				 <div id="remittance-alert-danger" class="alert alert-danger hidden" role="alert" alert-dismissable><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Error occured!</div>
 			 	 <h5>APPLICANT'S DETAILS</h5>
  				 <div style="padding: 15px; border-color: #ddd;color: #333; background-color: #EAEAEA;border: 1px solid transparent; border-radius: 6px;">
    			 <div class="form-group row">
				    <label for="txtFullName" class="col-sm-2 control-label">Full name</label>
				    <div class="col-sm-6">
				      <input type="text" class="easyui-combogrid" id="txtFullName" name="txtFullName" style="width:100%"/>
				    </div>
				 </div>
				 <div class="form-group">
				    <label for="txtAccNumber" class="col-sm-2 control-label">A/C number</label>
				    <div class="col-sm-6">
				      <input type="text" class="form-control col-sm-2" id="txtAccNumber" name="txtAccNumber">
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
				    <div class="col-sm-10">
					<input type="text" class="form-control col-sm-2" id="taAddress" name="taAddress" value="" disabled="disabled"/>
				    </div>
				 </div>
			 </div>
			 <h5>BENEFICIARY'S DETAILS</h5>
			 <div style="padding: 15px; border-color: #ddd;color: #333; background-color: #EAEAEA;border: 1px solid transparent; border-radius: 6px;" id="recieverArea">
    			<div class="form-group">
				    <label for="txtInterBank" class="col-sm-2 control-label">Inter Bank:</label>
				    <div class="col-sm-6">
				      <input type="text" class="form-control col-sm-2" id="txtInterBank" name="txtInterBank">
				    </div>
<!-- 				    <div class="col-sm-3"> -->
<!-- 						<input type="checkbox" name="receiverBlock" class="form-control" data-on-text="Add New" data-off-text="Existing"/> -->
<!-- 					</div> -->
				</div>
				<div class="form-group">
				    <label for="txtSwiftCode" class="col-sm-2 control-label">Swift Code:</label>
				    <div class="col-sm-6">
				      <input type="text" class="form-control col-sm-2" id="txtSwiftCode" name="txtSwiftCode">
				    </div>
				</div>
				<div class="form-group">
				    <label for="txtBankAddress" class="col-sm-2 control-label">Bank's Address:</label>
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
				      <input type="text" class="easyui-combogrid" id="txtRcFullName" name="txtRcFullName" style="width:100%;"/>
				    </div>
			   </div>
			   <div class="form-group">
				    <label for="txtRcPurpose" class="col-sm-2 control-label">Purpose</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control col-sm-2" id="txtRcPurpose" name="txtRcPurpose">
				    </div>
			  </div>
			</div>
			 <h5>FILL AMOUNT</h5>
  			   
 			 <div style="padding: 15px; border-color: #ddd;color: #333; background-color: #EAEAEA;border: 1px solid transparent; border-radius: 6px;">
 				<div class="row">
				  <div class="col-xs-6 col-sm-3 form-group" style="padding-left: 34px;">
				  	<b>Foreign Amount</b>
				    <input type="text" class="form-control col-sm-2" id="txtAmount" name="txtAmount" placeholder="0">
				  </div>
				  <div class="col-xs-6 col-sm-3">
				  	<b>Currency</b>
				  	<select class="form-control" name="selCurrency" id="selCurrency">
				  	"""),_display_(/*618.9*/for(currency <- listCurrencies) yield /*618.40*/{_display_(Seq[Any](format.raw/*618.41*/("""
				  		"""),format.raw/*619.9*/("""<option value=""""),_display_(/*619.25*/currency/*619.33*/.getId()),format.raw/*619.41*/("""">"""),_display_(/*619.44*/currency/*619.52*/.getName()),format.raw/*619.62*/("""</option>
				  	""")))}),format.raw/*620.9*/("""
					"""),format.raw/*621.6*/("""</select>
				  </div>
				  <div class="col-xs-6 col-sm-3">
				  	<b>Exchange rate</b>
				  	<input type="text" class="form-control col-sm-2" id="txtExchangeRate" name="txtExchangeRate">
				  </div>
				  <div class="col-xs-6 col-sm-3" style="padding-right: 23px;">
				  	<b>USD Equivalent</b>
				  	<div class="form-group">
<!-- 				  	<div class="input-group"> -->
				  	<input type="text" class="form-control col-sm-2" id="txtUsdEquivalent" name="txtUsdEquivalent" disabled="disabled">
<!-- 				  	</div> -->
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
				<div class="form-group">
				    <label class="col-sm-7 control-label" for="txtTotalAmount">Total USD</label>
				    <div class="col-sm-5">
				      <input type="text" name="txtTotalAmount" id="txtTotalAmount" class="form-control col-sm-2" disabled="disabled">
				    </div>
			  </div>
			</div>
   	 	  </div>
   	 	  	<div class="modal-footer">
				<button type="button" name="btnReject" class="btn btn-danger notif-action-button"><span class="glyphicon glyphicon-remove"></span> 
					"""),_display_(/*670.7*/if(user.getRole().getCode()=="role_teller")/*670.50*/{_display_(Seq[Any](format.raw/*670.51*/("""Cancel Transaction""")))}),format.raw/*670.70*/("""
					"""),_display_(/*671.7*/if(user.getRole().getCode()=="role_compliance_officer")/*671.62*/{_display_(Seq[Any](format.raw/*671.63*/("""Reject""")))}),format.raw/*671.70*/("""
				"""),format.raw/*672.5*/("""</button> 
				<button type="button" name="btnApprove" class="btn btn-success notif-action-button"><span class="glyphicon glyphicon-ok"></span> Approve</button> 
				"""),_display_(/*674.6*/if(user.getRole().getCode()=="role_teller")/*674.49*/{_display_(Seq[Any](format.raw/*674.50*/("""
					"""),format.raw/*675.6*/("""<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Preview</button>
				""")))}),format.raw/*676.6*/("""
				"""),format.raw/*677.5*/("""<button type="button" class="btn btn-default" data-dismiss="modal" id="resetButton"><span class="glyphicon glyphicon-off"></span> Close</button>
				<input type="hidden" name="hidSenderId" value=""/>
				<input type="hidden" name="hidRemittanceId" id="hidRemittanceId" value=""/>
				<input type="hidden" name="hidRecieverId" value=""/>
				<input type="hidden" name="hidProcess" id="hidProcess" value=""/>
				<input type="hidden" name="hidRcFullName" id="hidRcFullName" value=""/>
			</div>
       </form>
   		</div>
		</div>
	</div>
	<!-- end modal remittance -->
	
	<!-- modal remittance application form -->
		<div id="popupRemittanceApplicationForm" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupSaveAndPrint" aria-hidden="true" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog">
				<div class="modal-content">
				<!-- <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					</div> -->
					<form role="form" id="frmRemittanceApplication" data-toggle="validator" action="javascript:return;" method="post">
						<div class="modal-body" style="border: solid 1px; padding: 5px 0px; margin:15px;">
							<div class="row">
								<div class="col-md-4 form-group" style="padding:0;">
									<div class="row">
										<div class="col-sm-3" style="padding: 0 0 0 5px; margin-right:8px;">
											<center><img src=""""),_display_(/*703.31*/routes/*703.37*/.Assets.at("images/logo.jpg")),format.raw/*703.66*/("""" width="60" height="60"/></center>									
										</div>
										<div class="col-sm-6" style="padding:0px;font-weight:bold;">
											<div style="font-size:13px">ធនាគារ កម្ពុជា អាស៊ី</div>
											<div style="font-size:11px">CAMBODIA ASIA BANK</div>
										</div>										
									</div>
								</div>
								<div class="col-md-4 form-group">
									<div style="font-size:17px; font-weight:bold;"><center>ទំរង់បែបបទនៃការផ្ទេរប្រាក់</center></div>
									<div style="font-size:12px"><center>REMITTANCE APPLICATION FORM</center></div>	
								</div>	
								<div class="col-md-3 form-group pull-right" style="padding-right: 0px;margin-bottom:5px;">
									<div style="font-size:10px">កាលបរិច្ឆេទ Date<br/><input type="text" id="dateTransaction"/></div>
									<div style="font-size:10px;">លេខសំគាល់ធនាគារ</div>
									<div style="font-size:10px">Bank's Reference No.:<br/><input type="text" id="bankRef"/></div>
								</div>									
							</div>
							<div class="row wrapped">
								<hr style="margin:0 0 4px 0;"/>
							</div>
							<div class="row">
								<div class="col-md-2 col-padding">
									<div style="font-size:10px; margin-top:5px;">ទំរង់បែបបទសំរាប់</div>
									<div style="font-size:9px">Application For:</div>
								</div>
								<div class="col-md-3 form-group" style="padding-left:0;">
									<div class="checkbox pull-left" style="margin:0 0 5px 0;display:block;">
										<label>
											<input type="checkbox" name="chkDemandDraft" value="chkDemandDraft" style="margin-top:0;"/>
											<div style="font-size:10px;">ប័ណ្ណធនាគារត្រូវសងប្រាក់</div>
										</label>
										<div style="font-size:9px; margin-left:20px;">Demand Draft</div>
									</div>
								</div>
								<div class="col-md-3 form-group">
									<div class="checkbox pull-left" style="margin-top:0;">
										<label>
											<input type="checkbox" name="chkCashierOrder" value="chkCashierOrder" style="margin-top:0;"/>
											<div style="font-size:10px">មូលប្បទានប័ត្រធនាគារ</div>
										</label>
										<div style="font-size:9px; margin-left:20px;">Cashier's Order</div>
									</div>
								</div>
								<div class="col-md-4 form-group" style="padding-right:0;">
									<div class="checkbox pull-left" style="margin-top:0;">
										<label>
											<input type="checkbox" name="chkSwift" value="chkSwift" style="margin-top:0;"/>
											<div style="font-size:10px">ផ្ទេរប្រាក់តាមទូរលេខ</div>
										</label>
										<div style="font-size:9px; margin-left:20px; position:relative;">Telegraphic Transfer/Swift</div>
									</div>									
								</div>
							</div>
							<div class="row form-content tborder">
								<div class="col-md-12 form-group grey">
									រូបិយប័ណ្ណ និង ចំនួនត្រូវផ្ទេរ  &nbsp;&nbsp;CURRENCY & AMOUNT
								</div>
							</div>
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									ជាលេខ  &nbsp;&nbsp;In Figures
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>32A</center>
								</div>
								<div class="col-md-7 form-group" id="divInFigure">
									
								</div>									
							</div>	
							<div class="row form-content tborder double">
								<div class="col-md-4 form-group grey rborder">
									ជាអក្សរ &nbsp;&nbsp;In Words
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center></center>
								</div>
								<div class="col-md-7 form-group" id="divInWord">
									
								</div>									
							</div>
							<div class="row form-content tborder">
								<div class="col-md-12 form-group grey">
									ពត័មានពីអ្នកស្នើសុំ  &nbsp;&nbsp;APPLICANT'S DETAILS
								</div>
							</div>
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									ឈ្មោះ &nbsp;&nbsp;Applicant's Name
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>50</center>
								</div>
								<div class="col-md-7 form-group" id="senderfullName"></div>									
							</div>								
							<div class="row form-content tborder double">
								<div class="col-md-4 form-group grey rborder" style="height:100%;">
									អាសយដ្ឋាន និង លេខទូរស័ព្ទ &nbsp;&nbsp;Address & Tel No.
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center></center>
								</div>
								<div class="col-md-7 form-group" id="senderaddress"></div>									
							</div>					
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									លេខគណនី &nbsp;&nbsp;Account Number
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>&nbsp;</center>
								</div>
								<div class="col-md-7 form-group" id="senderaccountNo">
									
								</div>									
							</div>						
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									ថ្ងៃខែឆ្នាំកំនើត &nbsp;&nbsp;Date of Birth
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>&nbsp;</center>
								</div>
								<div class="col-md-7 form-group" id="senderdateOfBirth">
									
								</div>									
							</div>	
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									លេខអត្តសញ្ញាណប័ណ្ណ រឺ លិខិតឆ្លងដែន  &nbsp;&nbsp;ID or Passport No.
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>&nbsp;</center>
								</div>
								<div class="col-md-7 form-group" id="senderidentityNumber">
									
								</div>									
							</div>							
							<div class="row form-content tborder">
								<div class="col-md-12 form-group grey">
									ពត័មានពីអ្នកទទួលផល &nbsp;&nbsp;BENEFICIARY'S DETAILS
								</div>
							</div>							
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									ធនាគារកណ្តាល &nbsp;&nbsp;Intermediary Bank
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>56</center>
								</div>
								<div class="col-md-7 form-group" id="receiverintermediaryBank">
									
								</div>									
							</div>							
							<div class="row form-content tborder semi-double">
								<div class="col-md-4 form-group grey rborder">
									ធនាគារទទួលផល  &nbsp;&nbsp;Beneficiary's Bank/SWIFT Code
									អាសយដ្ឋានធនាគារទទួលផល &nbsp;&nbsp;Bank's Address
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>57</center>
								</div>
								<div class="col-md-7 form-group" id="receiverswiftCode">
									
								</div>									
							</div>							
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									លេខគណនីអ្នកទទួលផល &nbsp;&nbsp;Beneficiary's Account No.
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>59</center>
								</div>
								<div class="col-md-7 form-group" id="receiveraccountNo">
									
								</div>									
							</div>
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									ឈ្មោះអ្នកទទួលផល &nbsp;&nbsp;Beneficiary's Name
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>&nbsp;</center>
								</div>
								<div class="col-md-7 form-group" id="receiverfullName">
									
								</div>									
							</div>
							<div class="row form-content tborder">
								<div class="col-md-4 form-group grey rborder">
									គោលបំណងនៃការផ្ទេរ &nbsp;&nbsp;Purpose of Transfer
								</div>	
								<div class="col-md-1 form-group grey rborder">
									<center>70</center>
								</div>
								<div class="col-md-7 form-group" id="receiverpurpose">
									
								</div>									
							</div>							
							<div class="row form-content tborder">
								<div class="col-md-12 form-group grey">
									វិធីទូទាត់ &nbsp;&nbsp;MODE OF PAYMENT
								</div>
							</div>							
							
							<div class="row form-content tborder" style="padding-top: 5px;">
								<div class="col-md-6 form-group">
									<div class="checkbox" style="margin-top:0;">
										<label>
											<input type="checkbox" name="chkCash" value="chkCash" style="margin-top:0;"/>
											<div style="font-size:10px">សាច់ប្រាក់ &nbsp;Cash</div>
										</label>
									</div>
									<div class="checkbox" style="margin-top:0;">
										<label>
											<input type="checkbox" name="chkCheque" value="chkCheque" style="margin-top:0;"/>
											<div style="font-size:10px">លេខមូលប្បទានប័ត្រ &nbsp;Cheque No.</div>
										</label>
									</div>
									<div class="checkbox" style="margin-top:0;">
										<label>
											<input type="checkbox" name="chkAuthorizeDebit" value="chkAuthorizeDebit" style="margin-top:0;"/>
											<div style="font-size:10px">យើងសូមប្រគល់សិទ្ធិជូនធនាគារដកទឹកប្រាក់ពីគណីលេខ</div>
										</label>
										<div style="font-size:9px; margin-left:20px;">I / We authorize the Bank to debit my / our account no.:</div>
										<br/>
										<div style="font-size:9px; margin-left:20px;">...............................................................................</div>
									</div>									
								</div>
								<div class="col-md-6 form-group lborder">
									<div class="row double"></div>
									<div class="row double"></div>
									<div class="row">
										<div class="col-sm-6 form-group">
											<div style="font-size:9px;">............................................................................</div>
											ហត្ថលេខា រឺត្រារបស់អ្នកស្នើសុំ &nbsp;&nbsp;Applicant's Stamp/ Signature
										</div>
										<div class="col-sm-3 form-group pull-right">
											Signature Verified
										</div>										
									</div>
								</div>
							</div>
							<div class="row form-content tborder">
								<div class="col-md-12 form-group">
									&nbsp;
								</div>
							</div>	
							<div class="row form-content tborder">
								<div class="col-md-12 form-group">
									<center>បែបបទនេះមានសុពលភាពលុះត្រាតែមានចុះហត្ថលេខាដោយមន្ត្រីរបស់ធនាគារ &nbsp;&nbsp;This application is only valid when signed by Bank's authorised officer/s</center>
								</div>
							</div>								
							<div class="row form-content tborder">
								<div class="col-md-12 form-group grey">
									សំរាប់ធនាគារ &nbsp;&nbsp;FOR BANK USE ONLY
								</div>
							</div>	
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>100 x</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Foreign Amount
								</div>
								<div class="col-md-3 form-group" id="amount">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Contract No
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>							
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>50 x</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Exchange Rate
								</div>
								<div class="col-md-3 form-group" id="exchangeAmount">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Msg Prepare
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>20 x</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									USD Equivalent
								</div>
								<div class="col-md-3 form-group" id="usdEquivalent">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Msg Check
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>10 x</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Fee
								</div>
								<div class="col-md-3 form-group" id="fee">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Msg Counter Check
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>5 x</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Cable
								</div>
								<div class="col-md-3 form-group" id="cable">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Receiving Bank
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>1 x</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Postage
								</div>
								<div class="col-md-3 form-group" id="postage">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Charges
								</div>
								<div class="col-md-2 form-group">
									<center><b id="charge"></b></center>
								</div>								
							</div>
							<div class="row form-content tborder">
								<div class="col-md-1 form-group grey rborder">
									<center>Total Cash</center>
								</div>
								<div class="col-md-2 form-group" id="totalAmount">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									Other
								</div>
								<div class="col-md-3 form-group" id="other">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									&nbsp;
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>
							<div class="row form-content tborder bborder">
								<div class="col-md-1 form-group grey rborder">
									<center>Teller's Initial</center>
								</div>
								<div class="col-md-2 form-group">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									TOTAL USD
								</div>
								<div class="col-md-3 form-group" id="totalUsd">
									
								</div>
								<div class="col-md-2 form-group grey rborder lborder">
									&nbsp;
								</div>
								<div class="col-md-2 form-group">
									
								</div>								
							</div>							
							<div class="row form-content double">
								<div class="col-md-12 form-group"></div>
							</div>	
							<div class="row form-content">
								<div class="col-md-1 form-group"></div>
								<div class="col-md-7 form-group">
									<center>ការអនុម័តដោយមន្ត្រីធនាគារ &nbsp;&nbsp;Officer's Authorization</center>
								</div>
								<div class="col-md-4 form-group" style="text-align:right;padding-right:10px;">
									Additional Instructions / Remarks
								</div>								
							</div>								
						</div>
						<div class="modal-footer">
							<button id="btnSaveAndPrint" type="submit" class="btn btn-primary">Save/Print</button>
							<button id="btnCancelSaveAndPrint" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- end modal remittance transaction -->

		<!-- printable modal -->
		<div id="printableRemittanceApplicationForm">
			<div id="printableContent" class="modal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-body">
							<div class="row" style="position:absolute;margin-top:17mm;text-align:right;">
								<div id="pdateTransaction" style="margin-right:20mm"></div>
							</div>
							<div class="row" style="position:absolute;margin-top:33mm;text-align:right;">	
								<div id="pbankRef" style="margin-right:10mm"></div>									
							</div>
							
							<!-- Box1 -->
							<div class="box1-y" style="position:absolute;">
								<div class="row">
									<div class="childDiv">
										<div id="pdivInFigure" style="height:5mm;">&nbsp;</div>
									</div>
								</div>
								<div class="row">
									<div class="childDiv">
										<div id="pdivInWord" style="height:11mm;">&nbsp;</div>
									</div>
								</div>
								<div style="clear:both;"></div>								
							</div>
							
							<!-- Box2 -->
							<div class="box2-y" style="position:absolute;">
								<div class="row">
									<div class="childDiv">
										<div id="psenderfullName" style="height:6mm;">&nbsp;</div>
									</div>
								</div>							
								<div class="row">
									<div class="childDiv">
										<div id="psenderaddress" style="height:13mm; word-wrap:break-word; overflow:hidden;">&nbsp;</div>
									</div>							
								</div>					
								<div class="row">
									<div class="childDiv">
										<div id="psenderaccountNo" style="height:6mm;">&nbsp;</div>
									</div>								
								</div>						
								<div class="row">
									<div class="childDiv">
										<div id="psenderdateOfBirth" style="height:6mm;">&nbsp;</div>
									</div>								
								</div>	
								<div class="row">
									<div class="childDiv">
										<div id="psenderidentityNumber" style="height:5mm;vertical-align:top;">&nbsp;</div>
									</div>							
								</div>	
								<div style="clear:both;"></div>								
							</div>
							
							<!-- Box3 -->	
							<div class="box3-y" style="position:absolute;">
								<div class="row">
									<div class="childDiv">
										<div id="preceiverintermediaryBank" style="height:5mm;">&nbsp;</div>
									</div>							
								</div>							
								<div class="row">
									<div class="childDiv">
										<div id="preceiverswiftCode" style="height:14mm;">&nbsp;</div>
									</div>							
								</div>							
								<div class="row">
									<div class="childDiv">
										<div id="preceiveraccountNo" style="height:6mm;">&nbsp;</div>
									</div>							
								</div>
								<div class="row">
									<div class="childDiv">
										<div id="preceiverfullName" style="height:10mm;">&nbsp;</div>
									</div>							
								</div>
								<div class="row">
									<div class="childDiv">
										<div id="preceiverpurpose" style="height:10mm;">&nbsp;</div>
									</div>							
								</div>
								<div style="clear:both;"></div>								
							</div>						

							<!-- Box4 -->
							<div class="box4-y" style="position:absolute;">
								<div class="row">
									<div class="childDiv2">
										<div style="width:185px">
											<div id="pamount" style="h"""),
format.raw("""eight:5mm;">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="childDiv2">
										<div style="width:185px">
											<div id="pexchangeAmount" style="height:5mm;">&nbsp;</div>
										</div>
									</div>							
								</div>
								<div class="row">	
									<div class="childDiv2">
										<div style="width:185px">
											<div id="pusdEquivalent" style="height:5mm;">&nbsp;</div>
										</div>
									</div>							
								</div>
								<div class="row">	
									<div class="childDiv2">
										<div style="width:185px">
											<div id="pfee" style="height:5mm;">&nbsp;</div>
										</div>
									</div>							
								</div>
								<div class="row">
									<div class="childDiv2">
										<div style="width:185px">
											<div id="pcable" style="height:5mm;">&nbsp;</div>
										</div>
									</div>					
								</div>
								<div class="row">
									<div class="childDiv2">
										<div style="width:185px">
											<div id="ppostage" style="height:4.5mm;">&nbsp;</div>
										</div>
									</div>							
								</div>
								<div class="row">
									<div class="childDiv2">
										<div style="width:45mm;float:left;">
											<div id="pother" style="height:6mm;">&nbsp;</div>
										</div>
										<div style="width:28mm;float:left;">&nbsp;</div>
										<div id="pcharge" style="display:table-cell;vertical-align:middle;text-align:center;width:20mm;height:6mm;">&nbsp;</div>
										<div style="clear:both;"></div>								
									</div>							
								</div>
								<div class="row">
									<div class="childDiv2">
										<div style="width:185px">
											<div id="ptotalUsd" style="height:7mm;">&nbsp;</div>
										</div>
									</div>
								</div>
								<div style="clear:both;"></div>								
							</div>

							<!-- Box5 -->
							<div class="box5-y" style="position:absolute;">
								<div class="row">	
									<div style="padding-left:57px;">
										<span style="float:left;">User:&nbsp;</span><div id="puser" style="width:100px;">&nbsp;</div>
									</div>						
								</div>							
							</div>
							<div style="clear:both;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end printable modal -->

	""")))}),format.raw/*1311.3*/("""
 
      """),format.raw/*1313.7*/("""<!-- footer -->
      """),_display_(/*1314.8*/if(user != null)/*1314.24*/{_display_(Seq[Any](format.raw/*1314.25*/("""
		"""),format.raw/*1315.3*/("""<div class="footer navbar-fixed-bottom">
			<center><p>© 2014 Cambodia Asia Bank Ltd</p></center>
		</div>
	  """)))}),format.raw/*1318.5*/("""
	  """),format.raw/*1319.4*/("""<!-- end footer -->
		
    </body>

</html>
"""))}
  }

  def render(titile:String,user:User,nav:String,blockedRemittanceTransactions:List[SenderReceiverTransaction],rejectedAndApprovedTxs:List[SenderReceiverTransaction],notificationInterval:String,listCurrencies:List[CurrencyExchange],content:Html): play.twirl.api.HtmlFormat.Appendable = apply(titile,user,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,notificationInterval,listCurrencies)(content)

  def f:((String,User,String,List[SenderReceiverTransaction],List[SenderReceiverTransaction],String,List[CurrencyExchange]) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (titile,user,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,notificationInterval,listCurrencies) => (content) => apply(titile,user,nav,blockedRemittanceTransactions,rejectedAndApprovedTxs,notificationInterval,listCurrencies)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:53 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/main.scala.html
                  HASH: 8d4025e6e75a30d0faef291a63e17070a4a16bf9
                  MATRIX: 833->1|1176->255|1206->259|1640->667|1666->673|1755->735|1770->741|1823->773|1949->872|1964->878|2031->923|2127->992|2142->998|2216->1050|2312->1119|2327->1125|2403->1179|2511->1260|2526->1266|2623->1341|2703->1394|2718->1400|2814->1474|2936->1569|2951->1575|3033->1635|3165->1740|3180->1746|3256->1800|3375->1892|3390->1898|3446->1932|3535->1993|3564->1994|3597->2000|3695->2071|3723->2072|3755->2077|3786->2081|3814->2082|3847->2088|3894->2108|3922->2109|3954->2114|3985->2118|4013->2119|4046->2125|4142->2194|4170->2195|4202->2200|4239->2209|4268->2210|4301->2216|4363->2251|4391->2252|4423->2257|4461->2267|4490->2268|4523->2274|4585->2309|4613->2310|4650->2320|4700->2342|4729->2343|4773->2359|4802->2360|4839->2370|4889->2392|4918->2393|4962->2409|4991->2410|5028->2420|5078->2442|5107->2443|5152->2460|5181->2461|5218->2471|5268->2493|5297->2494|5342->2511|5371->2512|5408->2522|5458->2544|5487->2545|5532->2562|5561->2563|5595->2570|5638->2585|5667->2586|5700->2592|5752->2617|5780->2618|5812->2623|5862->2645|5891->2646|5924->2652|6050->2751|6078->2752|6109->2756|6185->2805|6200->2811|6267->2857|6399->2962|6414->2968|6494->3026|6604->3109|6619->3115|6714->3188|6821->3268|6836->3274|6930->3346|7050->3439|7065->3445|7138->3497|7271->3603|7286->3609|7367->3668|7478->3752|7493->3758|7552->3795|7722->3937|7751->3938|7784->3944|7858->3990|7887->3991|7921->3998|7995->4045|8008->4049|8043->4063|8126->4119|8154->4120|8247->4185|8276->4186|8310->4193|8405->4261|8433->4262|8577->4377|8607->4378|8645->4388|8812->4526|8842->4527|8888->4544|9045->4672|9075->4673|9126->4695|9156->4696|9199->4710|9245->4727|9275->4728|9328->4752|9369->4764|9399->4765|9453->4790|9492->4800|9522->4801|9577->4827|9650->4871|9680->4872|9736->4899|9766->4900|9812->4917|9940->5016|9970->5017|10017->5035|10137->5127|10151->5131|10187->5145|10218->5147|10248->5148|10293->5164|10350->5192|10380->5193|10413->5197|10443->5198|10485->5211|10541->5238|10571->5239|10614->5253|10644->5254|10703->5284|10733->5285|10811->5334|10841->5335|10890->5355|10920->5356|10997->5404|11027->5405|11080->5429|11121->5441|11151->5442|11205->5467|11248->5481|11278->5482|11333->5508|11455->5601|11485->5602|11554->5642|11584->5643|11645->5675|11792->5793|11822->5794|11900->5843|11930->5844|11979->5864|12009->5865|12079->5906|12109->5907|12162->5931|12203->5943|12233->5944|12287->5969|12330->5983|12360->5984|12415->6010|12537->6103|12567->6104|12636->6144|12666->6145|12727->6177|12867->6288|12897->6289|12975->6338|13005->6339|13054->6359|13084->6360|13126->6373|13156->6374|13193->6383|13222->6384|13296->6429|13326->6430|13364->6440|13519->6566|13549->6567|13579->6568|13663->6623|13693->6624|13729->6632|13872->6747|13901->6748|13995->6813|14025->6814|14068->6828|14292->7023|14322->7024|14366->7039|14426->7070|14456->7071|14501->7087|14612->7169|14642->7170|14688->7187|14775->7245|14805->7246|14854->7266|14884->7267|14917->7271|14947->7272|14992->7288|15104->7371|15134->7372|15180->7389|15325->7505|15355->7506|15407->7529|15437->7530|15480->7544|15510->7545|15604->7610|15634->7611|15681->7629|15797->7715|15828->7716|15859->7717|15907->7736|15937->7737|15979->7750|16009->7751|16071->7785|16100->7786|16182->7841|16247->7896|16287->7897|16330->7912|16383->7936|16413->7937|16451->7947|16487->7954|16517->7955|16558->7967|16593->7974|16609->7980|16676->8025|16772->8092|16802->8093|16844->8106|17049->8282|17079->8283|17122->8297|17662->8809|17692->8810|17732->8822|18193->9254|18223->9255|18266->9269|18394->9369|18424->9370|18457->9374|18487->9375|18527->9386|18641->9472|18671->9473|18711->9485|18855->9600|18885->9601|18928->9615|18994->9652|19024->9653|19068->9668|19128->9699|19158->9700|19200->9713|19230->9714|19275->9730|19305->9731|19386->9783|19416->9784|19459->9798|19601->9912|19643->9932|19692->9952|19722->9953|19760->9963|19790->9964|19827->9973|19856->9974|19954->10043|19984->10044|20020->10052|20247->10250|20277->10251|20314->10260|20573->10491|20602->10492|20638->10500|20744->10577|20774->10578|20811->10587|20887->10635|20916->10636|20954->10646|20990->10653|21020->10654|21064->10669|21099->10676|21115->10682|21184->10729|21344->10860|21374->10861|21419->10877|21481->10910|21511->10911|21557->10928|21697->11039|21727->11040|21772->11056|21843->11098|21873->11099|21919->11116|22273->11441|22303->11442|22353->11463|22482->11563|22512->11564|22557->11580|22587->11581|22631->11596|22661->11597|22756->11663|22786->11664|22824->11674|22939->11760|22969->11761|22999->11762|23048->11782|23078->11783|23121->11797|23151->11798|23202->11821|23231->11822|23278->11838|23307->11839|23381->11886|23435->11930|23475->11931|23510->11938|23714->12111|23754->12123|23826->12168|23879->12211|23919->12212|23955->12220|24012->12248|24042->12249|24080->12259|24116->12266|24146->12267|24183->12276|24218->12283|24234->12289|24305->12338|24395->12399|24425->12400|24463->12410|24686->12604|24716->12605|24756->12616|25121->12952|25151->12953|25192->12965|25500->13244|25530->13245|25570->13256|25673->13330|25703->13331|25744->13343|26031->13601|26061->13602|26101->13613|26200->13684|26230->13685|26270->13697|26754->14152|26784->14153|26824->14164|26976->14288|27006->14289|27039->14293|27069->14294|27109->14305|27239->14407|27269->14408|27309->14420|27450->14532|27480->14533|27520->14544|27586->14581|27616->14582|27657->14594|27717->14625|27747->14626|27785->14636|27815->14637|27864->14658|27893->14659|27971->14708|28001->14709|28041->14720|28184->14835|28226->14855|28271->14872|28300->14873|28338->14883|28368->14884|28405->14893|28434->14894|28529->14960|28559->14961|28595->14969|28702->15047|28732->15048|28769->15057|28822->15082|28838->15088|28903->15131|28978->15178|29007->15179|29083->15226|29113->15227|29150->15236|29197->15255|29213->15261|29266->15292|29366->15364|29380->15368|29422->15388|29461->15399|29490->15400|29525->15407|29554->15408|29647->15472|29677->15473|29713->15481|29911->15650|29941->15651|29985->15666|30158->15811|30174->15817|30243->15864|30420->16012|30450->16013|30495->16029|30546->16051|30576->16052|30671->16118|30701->16119|30739->16129|30854->16215|30884->16216|30914->16217|30963->16237|30993->16238|31036->16252|31066->16253|31117->16276|31146->16277|31186->16286|31215->16287|31288->16332|31317->16333|31441->16430|31467->16446|31507->16447|31539->16451|31920->16804|31936->16810|31978->16830|32026->16850|32042->16856|32093->16885|32259->17023|32319->17073|32359->17074|32406->17092|32439->17097|32464->17112|32504->17113|32551->17128|32590->17139|32606->17145|32651->17168|32708->17197|32735->17214|32775->17215|32822->17230|32861->17241|32877->17247|32924->17272|32983->17303|33012->17322|33052->17323|33099->17338|33138->17349|33154->17355|33203->17382|33264->17415|33295->17436|33335->17437|33382->17452|33421->17463|33437->17469|33488->17498|33551->17533|33578->17550|33618->17551|33665->17566|33704->17577|33720->17583|33767->17608|33835->17648|33882->17685|33922->17686|33969->17701|34008->17712|34024->17718|34090->17761|34167->17806|34213->17824|34278->17879|34318->17880|34365->17898|34398->17903|34425->17920|34465->17921|34512->17936|34551->17947|34567->17953|34614->17978|34682->18018|34713->18039|34753->18040|34800->18055|34839->18066|34855->18072|34907->18101|34979->18145|35006->18162|35046->18163|35093->18178|35132->18189|35148->18195|35195->18220|35262->18255|35308->18273|35361->18316|35401->18317|35438->18326|35471->18331|35502->18352|35542->18353|35589->18368|35619->18369|35676->18398|35692->18404|35744->18433|35807->18468|35836->18487|35876->18488|35923->18503|35953->18504|36008->18531|36024->18537|36074->18564|36135->18597|36162->18614|36202->18615|36249->18630|36288->18641|36304->18647|36351->18672|36434->18723|36480->18741|36535->18786|36575->18787|36622->18805|36655->18810|36682->18827|36722->18828|36769->18843|36808->18854|36824->18860|36871->18885|36939->18925|36970->18946|37010->18947|37057->18962|37096->18973|37112->18979|37164->19008|37235->19047|37270->19054|37499->19254|37514->19258|37551->19272|37654->19348|37680->19364|37720->19365|37758->19375|37805->19394|37821->19400|37869->19426|38153->19682|38169->19688|38216->19713|38327->19793|38364->19802|38429->19840|38536->19936|38577->19937|38613->19945|38775->20076|38810->20084|38897->20161|38937->20162|38973->20170|39143->20309|39177->20315|39240->20347|39275->20354|39325->20377|39354->20384|39389->20391|40014->20988|40030->20994|40087->21029|42047->22962|42083->22988|42124->22990|42156->22994|48785->29596|48833->29627|48873->29628|48911->29638|48955->29654|48973->29662|49003->29670|49034->29673|49052->29681|49084->29691|49134->29710|49169->29717|51300->31821|51353->31864|51393->31865|51444->31884|51479->31892|51544->31947|51584->31948|51623->31955|51657->31961|51853->32130|51906->32173|51946->32174|51981->32181|52130->32299|52164->32305|53714->33827|53730->33833|53781->33862|76222->56251|76262->56262|76314->56286|76341->56302|76382->56303|76415->56307|76561->56421|76595->56426
                  LINES: 26->1|29->1|31->3|37->9|37->9|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|48->20|48->20|48->20|50->22|50->22|50->22|52->24|52->24|52->24|54->26|54->26|55->27|59->31|59->31|60->32|60->32|60->32|61->33|62->34|62->34|63->35|63->35|63->35|64->36|67->39|67->39|68->40|68->40|68->40|69->41|71->43|71->43|72->44|72->44|72->44|73->45|75->47|75->47|77->49|78->50|78->50|78->50|78->50|80->52|81->53|81->53|81->53|81->53|83->55|84->56|84->56|84->56|84->56|86->58|87->59|87->59|87->59|87->59|89->61|90->62|90->62|90->62|90->62|92->64|92->64|92->64|93->65|94->66|94->66|95->67|95->67|95->67|96->68|100->72|100->72|101->73|104->76|104->76|104->76|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|110->82|110->82|110->82|112->84|112->84|112->84|114->86|114->86|114->86|118->90|118->90|119->91|119->91|119->91|120->92|121->93|121->93|121->93|123->95|123->95|124->96|124->96|125->97|126->98|126->98|129->101|129->101|130->102|133->105|133->105|134->106|137->109|137->109|138->110|138->110|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|142->114|143->115|143->115|144->116|144->116|145->117|146->118|146->118|147->119|148->120|148->120|148->120|148->120|148->120|149->121|150->122|150->122|150->122|150->122|151->123|152->124|152->124|153->125|153->125|154->126|154->126|155->127|155->127|156->128|156->128|157->129|157->129|158->130|158->130|158->130|159->131|159->131|159->131|160->132|162->134|162->134|163->135|163->135|164->136|166->138|166->138|167->139|167->139|168->140|168->140|169->141|169->141|170->142|170->142|170->142|171->143|171->143|171->143|172->144|174->146|174->146|175->147|175->147|176->148|178->150|178->150|179->151|179->151|180->152|180->152|181->153|181->153|182->154|182->154|183->155|183->155|184->156|188->160|188->160|188->160|189->161|189->161|190->162|194->166|194->166|196->168|196->168|197->169|202->174|202->174|203->175|203->175|203->175|204->176|205->177|205->177|206->178|207->179|207->179|208->180|208->180|208->180|208->180|209->181|210->182|210->182|211->183|213->185|213->185|214->186|214->186|215->187|215->187|216->188|216->188|217->189|217->189|217->189|217->189|218->190|218->190|219->191|219->191|221->193|221->193|224->196|224->196|224->196|226->198|226->198|226->198|227->199|227->199|227->199|228->200|228->200|228->200|228->200|230->202|230->202|231->203|236->208|236->208|237->209|244->216|244->216|246->218|251->223|251->223|252->224|254->226|254->226|254->226|254->226|255->227|257->229|257->229|259->231|260->232|260->232|261->233|261->233|261->233|262->234|263->235|263->235|264->236|264->236|266->238|266->238|267->239|267->239|268->240|269->241|269->241|270->242|270->242|271->243|271->243|272->244|272->244|274->246|274->246|275->247|279->251|279->251|280->252|283->255|283->255|284->256|284->256|284->256|285->257|286->258|286->258|288->260|288->260|288->260|289->261|289->261|289->261|289->261|291->263|291->263|292->264|292->264|292->264|293->265|295->267|295->267|296->268|296->268|296->268|297->269|302->274|302->274|303->275|305->277|305->277|306->278|306->278|307->279|307->279|308->280|308->280|309->281|309->281|309->281|309->281|310->282|310->282|311->283|311->283|313->285|313->285|315->287|315->287|317->289|317->289|317->289|318->290|320->292|322->294|323->295|323->295|323->295|324->296|324->296|324->296|325->297|325->297|325->297|326->298|326->298|326->298|326->298|328->300|328->300|329->301|334->306|334->306|335->307|339->311|339->311|340->312|342->314|342->314|343->315|343->315|343->315|344->316|346->318|346->318|347->319|349->321|349->321|351->323|356->328|356->328|357->329|359->331|359->331|359->331|359->331|360->332|362->334|362->334|364->336|365->337|365->337|366->338|366->338|366->338|367->339|368->340|368->340|369->341|369->341|371->343|371->343|372->344|372->344|373->345|374->346|374->346|375->347|375->347|376->348|376->348|377->349|377->349|380->352|380->352|381->353|382->354|382->354|383->355|383->355|383->355|383->355|384->356|384->356|384->356|384->356|385->357|385->357|385->357|385->357|386->358|386->358|386->358|387->359|387->359|388->360|388->360|390->362|390->362|391->363|394->366|394->366|395->367|396->368|396->368|396->368|398->370|398->370|399->371|400->372|400->372|401->373|401->373|402->374|402->374|402->374|402->374|403->375|403->375|404->376|404->376|406->378|406->378|407->379|407->379|409->381|409->381|415->387|415->387|415->387|416->388|420->392|420->392|420->392|420->392|420->392|420->392|424->396|424->396|424->396|425->397|425->397|425->397|425->397|425->397|425->397|425->397|425->397|426->398|426->398|426->398|426->398|426->398|426->398|426->398|427->399|427->399|427->399|427->399|427->399|427->399|427->399|428->400|428->400|428->400|428->400|428->400|428->400|428->400|429->401|429->401|429->401|429->401|429->401|429->401|429->401|430->402|430->402|430->402|430->402|430->402|430->402|430->402|431->403|432->404|432->404|432->404|433->405|433->405|433->405|433->405|433->405|433->405|433->405|433->405|434->406|434->406|434->406|434->406|434->406|434->406|434->406|435->407|435->407|435->407|435->407|435->407|435->407|435->407|436->408|437->409|437->409|437->409|438->410|438->410|438->410|438->410|438->410|438->410|438->410|438->410|438->410|439->411|439->411|439->411|439->411|439->411|439->411|439->411|439->411|440->412|440->412|440->412|440->412|440->412|440->412|440->412|441->413|442->414|442->414|442->414|443->415|443->415|443->415|443->415|443->415|443->415|443->415|443->415|444->416|444->416|444->416|444->416|444->416|444->416|444->416|445->417|446->418|449->421|449->421|449->421|451->423|451->423|451->423|452->424|452->424|452->424|452->424|455->427|455->427|455->427|456->428|457->429|460->432|460->432|460->432|461->433|466->438|467->439|467->439|467->439|468->440|473->445|474->446|477->449|478->450|479->451|479->451|480->452|490->462|490->462|490->462|528->500|528->500|528->500|529->501|646->618|646->618|646->618|647->619|647->619|647->619|647->619|647->619|647->619|647->619|648->620|649->621|698->670|698->670|698->670|698->670|699->671|699->671|699->671|699->671|700->672|702->674|702->674|702->674|703->675|704->676|705->677|731->703|731->703|731->703|1340->1311|1342->1313|1343->1314|1343->1314|1343->1314|1344->1315|1347->1318|1348->1319
                  -- GENERATED --
              */
          