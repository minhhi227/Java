
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
object settings extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/main("Settings", user, null, null, null,null)/*3.47*/ {_display_(Seq[Any](format.raw/*3.49*/("""
	
	"""),format.raw/*5.2*/("""<div class="content-wrapper">
		<center><h1>Page Settings</h1></center>
	</div>

	<!-- jQuery -->
	<script src=""""),_display_(/*10.16*/routes/*10.22*/.Assets.at("javascripts/jquery-1.11.1.min.js")),format.raw/*10.68*/(""""></script>
	<!-- JS Bootstrap -->		
	<script type="text/javascript" src=""""),_display_(/*12.39*/routes/*12.45*/.Assets.at("bootstrap/js/bootstrap.min.js")),format.raw/*12.88*/("""" defer></script>
	<!-- JS Bootstrap Switch -->
	<script type="text/javascript" src=""""),_display_(/*14.39*/routes/*14.45*/.Assets.at("bootstrap/js/bootstrap-switch.min.js")),format.raw/*14.95*/("""" defer></script>
	<!-- JS Bootstrap Validator -->
	<!-- <script type="text/javascript" src=""""),_display_(/*16.44*/routes/*16.50*/.Assets.at("bootstrap/js/bootstrapValidator.min.js")),format.raw/*16.102*/("""" defer></script>-->
	
	<script type="text/javascript" language="javascript">
		$(document).ready(function() """),format.raw/*19.32*/("""{"""),format.raw/*19.33*/("""

		"""),format.raw/*21.3*/("""}"""),format.raw/*21.4*/("""); /* end document ready */
		
	</script>

""")))}))}
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:53 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/settings.scala.html
                  HASH: 4dc0c9f3f74e320b7f6bfda662a19ae936de10eb
                  MATRIX: 724->1|824->13|852->16|905->61|944->63|974->67|1114->180|1129->186|1196->232|1298->307|1313->313|1377->356|1490->442|1505->448|1576->498|1697->592|1712->598|1786->650|1923->759|1952->760|1983->764|2011->765
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|38->10|38->10|38->10|40->12|40->12|40->12|42->14|42->14|42->14|44->16|44->16|44->16|47->19|47->19|49->21|49->21
                  -- GENERATED --
              */
          