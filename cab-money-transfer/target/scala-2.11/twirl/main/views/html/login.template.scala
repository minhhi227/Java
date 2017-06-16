
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[forms.LoginForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(formLogin: Form[forms.LoginForm]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>CAB Remittance Login</title>
		<link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.53*/routes/*10.59*/.Assets.at("images/favicon.jpg")),format.raw/*10.91*/("""" />
		
		<!-- CSS Bootstrap -->
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*13.64*/routes/*13.70*/.Assets.at("bootstrap/css/bootstrap.min.css")),format.raw/*13.115*/("""" />
		<!-- CSS Bootstrap Validator -->
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*15.64*/routes/*15.70*/.Assets.at("bootstrap/css/bootstrapValidator.min.css")),format.raw/*15.124*/("""" />
		<!-- jQuery -->
		<script src=""""),_display_(/*17.17*/routes/*17.23*/.Assets.at("javascripts/jquery-1.11.1.min.js")),format.raw/*17.69*/(""""></script>		
		<!-- JS Bootstrap Validator -->
		<script type="text/javascript" src=""""),_display_(/*19.40*/routes/*19.46*/.Assets.at("bootstrap/js/bootstrapValidator.min.js")),format.raw/*19.98*/("""" defer></script>
		
		<script type="text/javascript" language="javascript">
			$(document).ready(function() """),format.raw/*22.33*/("""{"""),format.raw/*22.34*/("""
			    """),format.raw/*23.8*/("""$('.form-signin').bootstrapValidator("""),format.raw/*23.45*/("""{"""),format.raw/*23.46*/("""
			    	"""),format.raw/*24.9*/("""excluded: [':disabled', ':hidden', ':not(:visible)'],
			    	live: 'disabled',
			    	submitButtons: 'button[type="submit"]',
			        feedbackIcons: """),format.raw/*27.27*/("""{"""),format.raw/*27.28*/("""
			            """),format.raw/*28.16*/("""valid: 'glyphicon',
			            invalid: 'glyphicon',
			            validating: 'glyphicon glyphicon-refresh'
			        """),format.raw/*31.12*/("""}"""),format.raw/*31.13*/(""",
			        fields: """),format.raw/*32.20*/("""{"""),format.raw/*32.21*/("""
			            """),format.raw/*33.16*/("""username: """),format.raw/*33.26*/("""{"""),format.raw/*33.27*/("""
			                """),format.raw/*34.20*/("""validators: """),format.raw/*34.32*/("""{"""),format.raw/*34.33*/("""
			                    """),format.raw/*35.24*/("""notEmpty: """),format.raw/*35.34*/("""{"""),format.raw/*35.35*/("""
			                        """),format.raw/*36.28*/("""message: 'Required'
			                    """),format.raw/*37.24*/("""}"""),format.raw/*37.25*/("""
			                """),format.raw/*38.20*/("""}"""),format.raw/*38.21*/("""
			            """),format.raw/*39.16*/("""}"""),format.raw/*39.17*/(""",
			            password: """),format.raw/*40.26*/("""{"""),format.raw/*40.27*/("""
			                """),format.raw/*41.20*/("""validators: """),format.raw/*41.32*/("""{"""),format.raw/*41.33*/("""
			                    """),format.raw/*42.24*/("""notEmpty: """),format.raw/*42.34*/("""{"""),format.raw/*42.35*/("""
			                        """),format.raw/*43.28*/("""message: 'Required'
			                    """),format.raw/*44.24*/("""}"""),format.raw/*44.25*/("""
			                """),format.raw/*45.20*/("""}"""),format.raw/*45.21*/("""
			            """),format.raw/*46.16*/("""}"""),format.raw/*46.17*/("""
			        """),format.raw/*47.12*/("""}"""),format.raw/*47.13*/("""
			    """),format.raw/*48.8*/("""}"""),format.raw/*48.9*/(""");
			"""),format.raw/*49.4*/("""}"""),format.raw/*49.5*/("""); /* end document ready */
		</script>
	</head>
	
    <body class="container" style="width:400px; margin-top:50px;">	
		<div class="jumbotron">
			<div>
				<h2 class="text-center login-title">CAB Remittance</h2>
				<div class="account-wall">
					<form class="form-signin" action=""""),_display_(/*58.41*/routes/*58.47*/.LoginController.authenticate),format.raw/*58.76*/("""" method="post">
						"""),_display_(/*59.8*/if(formLogin("authenticated").value == "false")/*59.55*/{_display_(Seq[Any](format.raw/*59.56*/("""<div id="user-alert-danger" class="alert alert-danger" role="alert">Invalid username or password</div>""")))}),format.raw/*59.159*/("""
						"""),format.raw/*60.7*/("""<div class="form-group">
							<label class="control-label">Username</label>
							<input type="text" name="username" value=""""),_display_(/*62.51*/formLogin("username")/*62.72*/.value),format.raw/*62.78*/("""" class="form-control" placeholder="Username" autofocus/>
						</div>
						<div class="form-group">
							<label class="control-label">Password</label>
							<input type="password" name="password" value=""""),_display_(/*66.55*/formLogin("password")/*66.76*/.value),format.raw/*66.82*/("""" class="form-control" placeholder="Password"/>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-lg btn-primary btn-block">Log in</button>
						</div>
						<div class="form-group">
							<label>
								<input type="checkbox" name="rememberMe" """),_display_(/*73.51*/if(formLogin("rememberMe").value == "true")/*73.94*/{_display_(Seq[Any](format.raw/*73.95*/(""" """),format.raw/*73.96*/("""checked="checked" """)))}),format.raw/*73.115*/(""">
								Remember me
							</label>						
						</div>
					</form>
				</div>
			</div>
		</div>
    </body>

</html>"""))}
  }

  def render(formLogin:Form[forms.LoginForm]): play.twirl.api.HtmlFormat.Appendable = apply(formLogin)

  def f:((Form[forms.LoginForm]) => play.twirl.api.HtmlFormat.Appendable) = (formLogin) => apply(formLogin)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:51 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/login.scala.html
                  HASH: db586ae2fd35242ec1e408a48908218601234f0f
                  MATRIX: 738->1|860->35|890->39|1406->528|1421->534|1474->566|1600->665|1615->671|1682->716|1814->821|1829->827|1905->881|1973->922|1988->928|2055->974|2171->1063|2186->1069|2259->1121|2399->1233|2428->1234|2464->1243|2529->1280|2558->1281|2595->1291|2780->1448|2809->1449|2854->1466|3010->1594|3039->1595|3089->1617|3118->1618|3163->1635|3201->1645|3230->1646|3279->1667|3319->1679|3348->1680|3401->1705|3439->1715|3468->1716|3525->1745|3597->1789|3626->1790|3675->1811|3704->1812|3749->1829|3778->1830|3834->1858|3863->1859|3912->1880|3952->1892|3981->1893|4034->1918|4072->1928|4101->1929|4158->1958|4230->2002|4259->2003|4308->2024|4337->2025|4382->2042|4411->2043|4452->2056|4481->2057|4517->2066|4545->2067|4579->2074|4607->2075|4928->2369|4943->2375|4993->2404|5044->2429|5100->2476|5139->2477|5274->2580|5309->2588|5466->2718|5496->2739|5523->2745|5763->2958|5793->2979|5820->2985|6141->3279|6193->3322|6232->3323|6261->3324|6312->3343
                  LINES: 26->1|29->1|31->3|38->10|38->10|38->10|41->13|41->13|41->13|43->15|43->15|43->15|45->17|45->17|45->17|47->19|47->19|47->19|50->22|50->22|51->23|51->23|51->23|52->24|55->27|55->27|56->28|59->31|59->31|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|65->37|65->37|66->38|66->38|67->39|67->39|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|72->44|72->44|73->45|73->45|74->46|74->46|75->47|75->47|76->48|76->48|77->49|77->49|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|90->62|90->62|90->62|94->66|94->66|94->66|101->73|101->73|101->73|101->73|101->73
                  -- GENERATED --
              */
          