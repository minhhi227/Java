
package views.html.popup

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
object addOrUpdateRemittance extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- popup Remittant -->
<div id="popupAddUpdateRemittant" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="popupAddUpdateRemittant" data-replace="true" aria-hidden="true" data-backdrop="static" data-keyboard="false">
 		<div class="modal-dialog modal-lg">
		<div class="modal-content">

  		</div>
	</div>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:56 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/popup/addOrUpdateRemittance.scala.html
                  HASH: 09f6f63432d5cbb9bb99f8db3c65b2d88ddd18f0
                  MATRIX: 820->0
                  LINES: 29->1
                  -- GENERATED --
              */
          