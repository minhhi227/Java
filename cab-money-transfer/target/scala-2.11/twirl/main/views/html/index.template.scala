
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/main(null, user, null, null, null,null)/*3.41*/ {_display_(Seq[Any](format.raw/*3.43*/("""

""")))}))}
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Feb 07 01:44:51 ICT 2015
                  SOURCE: C:/dev/play/cab-remittance/app/views/index.scala.html
                  HASH: 126077866af14b126558b90e3d99278f8da9d5a5
                  MATRIX: 721->1|821->13|849->16|896->55|935->57
                  LINES: 26->1|29->1|31->3|31->3|31->3
                  -- GENERATED --
              */
          