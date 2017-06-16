
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
object error extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(errorMessage: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.24*/("""
"""),_display_(/*2.2*/main("Global error", null, null, null, null,null)/*2.51*/ {_display_(Seq[Any](format.raw/*2.53*/("""
	"""),format.raw/*3.2*/("""<div>
		"""),_display_(/*4.4*/errorMessage),format.raw/*4.16*/("""
	"""),format.raw/*5.2*/("""</div>
""")))}))}
  }

  def render(errorMessage:String): play.twirl.api.HtmlFormat.Appendable = apply(errorMessage)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (errorMessage) => apply(errorMessage)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:51 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/error.scala.html
                  HASH: 584b9df449485558e125ad2c25d57712b3f3bdf7
                  MATRIX: 723->1|833->23|861->26|918->75|957->77|986->80|1021->90|1053->102|1082->105
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|32->4|32->4|33->5
                  -- GENERATED --
              */
          