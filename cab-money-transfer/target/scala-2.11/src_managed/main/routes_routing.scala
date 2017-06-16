// @SOURCE:C:/dev/play/cab-remittance/conf/routes
// @HASH:959990078f8647a9aadf7ad0fb2dd1a6943f3eec
// @DATE:Sat Feb 07 01:44:49 ICT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:8
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ ============================================================================
 Home page
 ============================================================================""", Routes.prefix + """"""))
        

// @LINE:13
private[this] lazy val controllers_LoginController_login1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_LoginController_login1_invoker = createInvoker(
controllers.LoginController.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "login", Nil,"GET", """ ============================================================================
 Authentication
 ============================================================================""", Routes.prefix + """login"""))
        

// @LINE:14
private[this] lazy val controllers_LoginController_authenticate2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_LoginController_authenticate2_invoker = createInvoker(
controllers.LoginController.authenticate(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:15
private[this] lazy val controllers_LoginController_logout3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_LoginController_logout3_invoker = createInvoker(
controllers.LoginController.logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:16
private[this] lazy val controllers_LoginController_sessionExpired4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("session-expired.html"))))
private[this] lazy val controllers_LoginController_sessionExpired4_invoker = createInvoker(
controllers.LoginController.sessionExpired(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "sessionExpired", Nil,"GET", """""", Routes.prefix + """session-expired.html"""))
        

// @LINE:17
private[this] lazy val controllers_LoginController_redirectPage5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("redirectPage"))))
private[this] lazy val controllers_LoginController_redirectPage5_invoker = createInvoker(
controllers.LoginController.redirectPage(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "redirectPage", Seq(classOf[String]),"GET", """""", Routes.prefix + """redirectPage"""))
        

// @LINE:18
private[this] lazy val controllers_LoginController_noAuthorization6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("no-authorization"))))
private[this] lazy val controllers_LoginController_noAuthorization6_invoker = createInvoker(
controllers.LoginController.noAuthorization(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "noAuthorization", Nil,"GET", """""", Routes.prefix + """no-authorization"""))
        

// @LINE:23
private[this] lazy val controllers_UserController_index7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin"))))
private[this] lazy val controllers_UserController_index7_invoker = createInvoker(
controllers.UserController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "index", Nil,"GET", """ ============================================================================
 User
 ============================================================================""", Routes.prefix + """admin"""))
        

// @LINE:24
private[this] lazy val controllers_UserController_filterUser8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/filterUser"))))
private[this] lazy val controllers_UserController_filterUser8_invoker = createInvoker(
controllers.UserController.filterUser(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "filterUser", Nil,"GET", """""", Routes.prefix + """admin/filterUser"""))
        

// @LINE:25
private[this] lazy val controllers_UserController_saveOrUpdateUser9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/saveOrUpdateUser"))))
private[this] lazy val controllers_UserController_saveOrUpdateUser9_invoker = createInvoker(
controllers.UserController.saveOrUpdateUser(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "saveOrUpdateUser", Nil,"POST", """""", Routes.prefix + """admin/saveOrUpdateUser"""))
        

// @LINE:26
private[this] lazy val controllers_UserController_saveOrUpdateBranch10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/saveOrUpdateBranch"))))
private[this] lazy val controllers_UserController_saveOrUpdateBranch10_invoker = createInvoker(
controllers.UserController.saveOrUpdateBranch(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "saveOrUpdateBranch", Nil,"POST", """""", Routes.prefix + """admin/saveOrUpdateBranch"""))
        

// @LINE:31
private[this] lazy val controllers_RuleFillAmountManagementController_index11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rule-fill-amount"))))
private[this] lazy val controllers_RuleFillAmountManagementController_index11_invoker = createInvoker(
controllers.RuleFillAmountManagementController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RuleFillAmountManagementController", "index", Nil,"GET", """ ============================================================================
 Rule Fill Amount
 ============================================================================""", Routes.prefix + """rule-fill-amount"""))
        

// @LINE:32
private[this] lazy val controllers_RuleFillAmountManagementController_getAll12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rule-fill-amount/getAll"))))
private[this] lazy val controllers_RuleFillAmountManagementController_getAll12_invoker = createInvoker(
controllers.RuleFillAmountManagementController.getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RuleFillAmountManagementController", "getAll", Nil,"GET", """""", Routes.prefix + """rule-fill-amount/getAll"""))
        

// @LINE:33
private[this] lazy val controllers_RuleFillAmountManagementController_update13_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rule-fill-amount/update"))))
private[this] lazy val controllers_RuleFillAmountManagementController_update13_invoker = createInvoker(
controllers.RuleFillAmountManagementController.update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RuleFillAmountManagementController", "update", Nil,"POST", """""", Routes.prefix + """rule-fill-amount/update"""))
        

// @LINE:38
private[this] lazy val controllers_SenderController_index14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sender"))))
private[this] lazy val controllers_SenderController_index14_invoker = createInvoker(
controllers.SenderController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "index", Nil,"GET", """ ============================================================================
 Sender
 ============================================================================""", Routes.prefix + """sender"""))
        

// @LINE:39
private[this] lazy val controllers_SenderController_checkAccount15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sender/checkAccount"))))
private[this] lazy val controllers_SenderController_checkAccount15_invoker = createInvoker(
controllers.SenderController.checkAccount(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "checkAccount", Nil,"GET", """""", Routes.prefix + """sender/checkAccount"""))
        

// @LINE:40
private[this] lazy val controllers_SenderController_isInTransaction16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sender/isInTransaction"))))
private[this] lazy val controllers_SenderController_isInTransaction16_invoker = createInvoker(
controllers.SenderController.isInTransaction(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "isInTransaction", Nil,"GET", """""", Routes.prefix + """sender/isInTransaction"""))
        

// @LINE:41
private[this] lazy val controllers_SenderController_filterSender17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sender/filterSender"))))
private[this] lazy val controllers_SenderController_filterSender17_invoker = createInvoker(
controllers.SenderController.filterSender(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "filterSender", Nil,"GET", """""", Routes.prefix + """sender/filterSender"""))
        

// @LINE:42
private[this] lazy val controllers_SenderController_saveOrUpdateSender18_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sender/saveOrUpdateSender"))))
private[this] lazy val controllers_SenderController_saveOrUpdateSender18_invoker = createInvoker(
controllers.SenderController.saveOrUpdateSender(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "saveOrUpdateSender", Nil,"POST", """""", Routes.prefix + """sender/saveOrUpdateSender"""))
        

// @LINE:43
private[this] lazy val controllers_SenderController_filterSenderByFullName19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sender/filterSenderByFullName"))))
private[this] lazy val controllers_SenderController_filterSenderByFullName19_invoker = createInvoker(
controllers.SenderController.filterSenderByFullName(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "filterSenderByFullName", Nil,"GET", """""", Routes.prefix + """sender/filterSenderByFullName"""))
        

// @LINE:48
private[this] lazy val controllers_ReceiverController_index20_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("receiver"))))
private[this] lazy val controllers_ReceiverController_index20_invoker = createInvoker(
controllers.ReceiverController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "index", Nil,"GET", """ ============================================================================
 Receiver
 ============================================================================""", Routes.prefix + """receiver"""))
        

// @LINE:49
private[this] lazy val controllers_ReceiverController_filterReceiver21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("receiver/filterReceiver"))))
private[this] lazy val controllers_ReceiverController_filterReceiver21_invoker = createInvoker(
controllers.ReceiverController.filterReceiver(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "filterReceiver", Nil,"GET", """""", Routes.prefix + """receiver/filterReceiver"""))
        

// @LINE:50
private[this] lazy val controllers_ReceiverController_saveOrUpdateReceiver22_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("receiver/saveOrUpdateReceiver"))))
private[this] lazy val controllers_ReceiverController_saveOrUpdateReceiver22_invoker = createInvoker(
controllers.ReceiverController.saveOrUpdateReceiver(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "saveOrUpdateReceiver", Nil,"POST", """""", Routes.prefix + """receiver/saveOrUpdateReceiver"""))
        

// @LINE:51
private[this] lazy val controllers_ReceiverController_filterByFullNameANDAccountNo23_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("receiver/filterByFullNameANDAccountNo"))))
private[this] lazy val controllers_ReceiverController_filterByFullNameANDAccountNo23_invoker = createInvoker(
controllers.ReceiverController.filterByFullNameANDAccountNo(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "filterByFullNameANDAccountNo", Nil,"GET", """""", Routes.prefix + """receiver/filterByFullNameANDAccountNo"""))
        

// @LINE:56
private[this] lazy val controllers_RemittanceController_index24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance"))))
private[this] lazy val controllers_RemittanceController_index24_invoker = createInvoker(
controllers.RemittanceController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "index", Nil,"GET", """ ============================================================================
 Remittance
 ============================================================================""", Routes.prefix + """remittance"""))
        

// @LINE:57
private[this] lazy val controllers_RemittanceController_getRemittanceList25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getRemittanceList"))))
private[this] lazy val controllers_RemittanceController_getRemittanceList25_invoker = createInvoker(
controllers.RemittanceController.getRemittanceList(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getRemittanceList", Nil,"GET", """""", Routes.prefix + """remittance/getRemittanceList"""))
        

// @LINE:58
private[this] lazy val controllers_RemittanceController_getById26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getById"))))
private[this] lazy val controllers_RemittanceController_getById26_invoker = createInvoker(
controllers.RemittanceController.getById(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getById", Nil,"GET", """""", Routes.prefix + """remittance/getById"""))
        

// @LINE:59
private[this] lazy val controllers_RemittanceController_saveOrUpdateRemittanceTransaction27_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/saveOrUpdate"))))
private[this] lazy val controllers_RemittanceController_saveOrUpdateRemittanceTransaction27_invoker = createInvoker(
controllers.RemittanceController.saveOrUpdateRemittanceTransaction(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "saveOrUpdateRemittanceTransaction", Nil,"POST", """""", Routes.prefix + """remittance/saveOrUpdate"""))
        

// @LINE:60
private[this] lazy val controllers_RemittanceController_updateTransactionStatus28_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/updateTransactionStatus"))))
private[this] lazy val controllers_RemittanceController_updateTransactionStatus28_invoker = createInvoker(
controllers.RemittanceController.updateTransactionStatus(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "updateTransactionStatus", Nil,"POST", """""", Routes.prefix + """remittance/updateTransactionStatus"""))
        

// @LINE:61
private[this] lazy val controllers_RemittanceController_previewRemittanceTransaction29_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/preview"))))
private[this] lazy val controllers_RemittanceController_previewRemittanceTransaction29_invoker = createInvoker(
controllers.RemittanceController.previewRemittanceTransaction(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "previewRemittanceTransaction", Nil,"POST", """""", Routes.prefix + """remittance/preview"""))
        

// @LINE:62
private[this] lazy val controllers_RemittanceController_getBankReference30_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getBankReference"))))
private[this] lazy val controllers_RemittanceController_getBankReference30_invoker = createInvoker(
controllers.RemittanceController.getBankReference(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getBankReference", Nil,"GET", """""", Routes.prefix + """remittance/getBankReference"""))
        

// @LINE:63
private[this] lazy val controllers_RemittanceController_continueTransaction31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/continueTransaction"))))
private[this] lazy val controllers_RemittanceController_continueTransaction31_invoker = createInvoker(
controllers.RemittanceController.continueTransaction(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "continueTransaction", Nil,"GET", """""", Routes.prefix + """remittance/continueTransaction"""))
        

// @LINE:64
private[this] lazy val controllers_RemittanceController_getNotificationsForCO32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getNotificationsForCO"))))
private[this] lazy val controllers_RemittanceController_getNotificationsForCO32_invoker = createInvoker(
controllers.RemittanceController.getNotificationsForCO(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getNotificationsForCO", Nil,"GET", """""", Routes.prefix + """remittance/getNotificationsForCO"""))
        

// @LINE:65
private[this] lazy val controllers_RemittanceController_getNotificationsForTeller33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getNotificationsForTeller"))))
private[this] lazy val controllers_RemittanceController_getNotificationsForTeller33_invoker = createInvoker(
controllers.RemittanceController.getNotificationsForTeller(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getNotificationsForTeller", Nil,"GET", """""", Routes.prefix + """remittance/getNotificationsForTeller"""))
        

// @LINE:66
private[this] lazy val controllers_RemittanceController_getSenderByRecieverId34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getSenderByRecierId"))))
private[this] lazy val controllers_RemittanceController_getSenderByRecieverId34_invoker = createInvoker(
controllers.RemittanceController.getSenderByRecieverId(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getSenderByRecieverId", Nil,"GET", """""", Routes.prefix + """remittance/getSenderByRecierId"""))
        

// @LINE:67
private[this] lazy val controllers_RemittanceController_getRecieverBySenderId35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getReceiverBySenderId"))))
private[this] lazy val controllers_RemittanceController_getRecieverBySenderId35_invoker = createInvoker(
controllers.RemittanceController.getRecieverBySenderId(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getRecieverBySenderId", Nil,"GET", """""", Routes.prefix + """remittance/getReceiverBySenderId"""))
        

// @LINE:68
private[this] lazy val controllers_RemittanceController_getRuleFillAmount36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remittance/getRuleFillAmount"))))
private[this] lazy val controllers_RemittanceController_getRuleFillAmount36_invoker = createInvoker(
controllers.RemittanceController.getRuleFillAmount(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getRuleFillAmount", Nil,"GET", """""", Routes.prefix + """remittance/getRuleFillAmount"""))
        

// @LINE:73
private[this] lazy val controllers_ReportController_index37_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("report"))))
private[this] lazy val controllers_ReportController_index37_invoker = createInvoker(
controllers.ReportController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReportController", "index", Nil,"GET", """ ============================================================================
 Report
 ============================================================================""", Routes.prefix + """report"""))
        

// @LINE:74
private[this] lazy val controllers_ReportController_getRemittanceReport38_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("report/getRemittanceReport"))))
private[this] lazy val controllers_ReportController_getRemittanceReport38_invoker = createInvoker(
controllers.ReportController.getRemittanceReport(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReportController", "getRemittanceReport", Nil,"GET", """""", Routes.prefix + """report/getRemittanceReport"""))
        

// @LINE:75
private[this] lazy val controllers_ReportController_exportExcel39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("report/exportExcel"))))
private[this] lazy val controllers_ReportController_exportExcel39_invoker = createInvoker(
controllers.ReportController.exportExcel(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ReportController", "exportExcel", Nil,"GET", """""", Routes.prefix + """report/exportExcel"""))
        

// @LINE:76
private[this] lazy val controllers_ErrorController_techicalError40_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("techicalError"))))
private[this] lazy val controllers_ErrorController_techicalError40_invoker = createInvoker(
controllers.ErrorController.techicalError(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ErrorController", "techicalError", Nil,"GET", """""", Routes.prefix + """techicalError"""))
        

// @LINE:81
private[this] lazy val controllers_SettingController_index41_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("settings"))))
private[this] lazy val controllers_SettingController_index41_invoker = createInvoker(
controllers.SettingController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SettingController", "index", Nil,"GET", """ ============================================================================
 Settings
 ============================================================================""", Routes.prefix + """settings"""))
        

// @LINE:82
private[this] lazy val controllers_SettingController_changePassword42_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("settings/changePassword"))))
private[this] lazy val controllers_SettingController_changePassword42_invoker = createInvoker(
controllers.SettingController.changePassword(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SettingController", "changePassword", Nil,"POST", """""", Routes.prefix + """settings/changePassword"""))
        

// @LINE:85
private[this] lazy val controllers_Assets_at43_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at43_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.LoginController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.LoginController.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.LoginController.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """session-expired.html""","""controllers.LoginController.sessionExpired()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """redirectPage""","""controllers.LoginController.redirectPage(username:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """no-authorization""","""controllers.LoginController.noAuthorization()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin""","""controllers.UserController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/filterUser""","""controllers.UserController.filterUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/saveOrUpdateUser""","""controllers.UserController.saveOrUpdateUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/saveOrUpdateBranch""","""controllers.UserController.saveOrUpdateBranch()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rule-fill-amount""","""controllers.RuleFillAmountManagementController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rule-fill-amount/getAll""","""controllers.RuleFillAmountManagementController.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rule-fill-amount/update""","""controllers.RuleFillAmountManagementController.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sender""","""controllers.SenderController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sender/checkAccount""","""controllers.SenderController.checkAccount()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sender/isInTransaction""","""controllers.SenderController.isInTransaction()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sender/filterSender""","""controllers.SenderController.filterSender()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sender/saveOrUpdateSender""","""controllers.SenderController.saveOrUpdateSender()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sender/filterSenderByFullName""","""controllers.SenderController.filterSenderByFullName()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """receiver""","""controllers.ReceiverController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """receiver/filterReceiver""","""controllers.ReceiverController.filterReceiver()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """receiver/saveOrUpdateReceiver""","""controllers.ReceiverController.saveOrUpdateReceiver()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """receiver/filterByFullNameANDAccountNo""","""controllers.ReceiverController.filterByFullNameANDAccountNo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance""","""controllers.RemittanceController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getRemittanceList""","""controllers.RemittanceController.getRemittanceList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getById""","""controllers.RemittanceController.getById()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/saveOrUpdate""","""controllers.RemittanceController.saveOrUpdateRemittanceTransaction()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/updateTransactionStatus""","""controllers.RemittanceController.updateTransactionStatus()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/preview""","""controllers.RemittanceController.previewRemittanceTransaction()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getBankReference""","""controllers.RemittanceController.getBankReference()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/continueTransaction""","""controllers.RemittanceController.continueTransaction()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getNotificationsForCO""","""controllers.RemittanceController.getNotificationsForCO()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getNotificationsForTeller""","""controllers.RemittanceController.getNotificationsForTeller()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getSenderByRecierId""","""controllers.RemittanceController.getSenderByRecieverId()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getReceiverBySenderId""","""controllers.RemittanceController.getRecieverBySenderId()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remittance/getRuleFillAmount""","""controllers.RemittanceController.getRuleFillAmount()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """report""","""controllers.ReportController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """report/getRemittanceReport""","""controllers.ReportController.getRemittanceReport()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """report/exportExcel""","""controllers.ReportController.exportExcel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """techicalError""","""controllers.ErrorController.techicalError()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """settings""","""controllers.SettingController.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """settings/changePassword""","""controllers.SettingController.changePassword()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:8
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:13
case controllers_LoginController_login1_route(params) => {
   call { 
        controllers_LoginController_login1_invoker.call(controllers.LoginController.login())
   }
}
        

// @LINE:14
case controllers_LoginController_authenticate2_route(params) => {
   call { 
        controllers_LoginController_authenticate2_invoker.call(controllers.LoginController.authenticate())
   }
}
        

// @LINE:15
case controllers_LoginController_logout3_route(params) => {
   call { 
        controllers_LoginController_logout3_invoker.call(controllers.LoginController.logout())
   }
}
        

// @LINE:16
case controllers_LoginController_sessionExpired4_route(params) => {
   call { 
        controllers_LoginController_sessionExpired4_invoker.call(controllers.LoginController.sessionExpired())
   }
}
        

// @LINE:17
case controllers_LoginController_redirectPage5_route(params) => {
   call(params.fromQuery[String]("username", None)) { (username) =>
        controllers_LoginController_redirectPage5_invoker.call(controllers.LoginController.redirectPage(username))
   }
}
        

// @LINE:18
case controllers_LoginController_noAuthorization6_route(params) => {
   call { 
        controllers_LoginController_noAuthorization6_invoker.call(controllers.LoginController.noAuthorization())
   }
}
        

// @LINE:23
case controllers_UserController_index7_route(params) => {
   call { 
        controllers_UserController_index7_invoker.call(controllers.UserController.index())
   }
}
        

// @LINE:24
case controllers_UserController_filterUser8_route(params) => {
   call { 
        controllers_UserController_filterUser8_invoker.call(controllers.UserController.filterUser())
   }
}
        

// @LINE:25
case controllers_UserController_saveOrUpdateUser9_route(params) => {
   call { 
        controllers_UserController_saveOrUpdateUser9_invoker.call(controllers.UserController.saveOrUpdateUser())
   }
}
        

// @LINE:26
case controllers_UserController_saveOrUpdateBranch10_route(params) => {
   call { 
        controllers_UserController_saveOrUpdateBranch10_invoker.call(controllers.UserController.saveOrUpdateBranch())
   }
}
        

// @LINE:31
case controllers_RuleFillAmountManagementController_index11_route(params) => {
   call { 
        controllers_RuleFillAmountManagementController_index11_invoker.call(controllers.RuleFillAmountManagementController.index())
   }
}
        

// @LINE:32
case controllers_RuleFillAmountManagementController_getAll12_route(params) => {
   call { 
        controllers_RuleFillAmountManagementController_getAll12_invoker.call(controllers.RuleFillAmountManagementController.getAll())
   }
}
        

// @LINE:33
case controllers_RuleFillAmountManagementController_update13_route(params) => {
   call { 
        controllers_RuleFillAmountManagementController_update13_invoker.call(controllers.RuleFillAmountManagementController.update())
   }
}
        

// @LINE:38
case controllers_SenderController_index14_route(params) => {
   call { 
        controllers_SenderController_index14_invoker.call(controllers.SenderController.index())
   }
}
        

// @LINE:39
case controllers_SenderController_checkAccount15_route(params) => {
   call { 
        controllers_SenderController_checkAccount15_invoker.call(controllers.SenderController.checkAccount())
   }
}
        

// @LINE:40
case controllers_SenderController_isInTransaction16_route(params) => {
   call { 
        controllers_SenderController_isInTransaction16_invoker.call(controllers.SenderController.isInTransaction())
   }
}
        

// @LINE:41
case controllers_SenderController_filterSender17_route(params) => {
   call { 
        controllers_SenderController_filterSender17_invoker.call(controllers.SenderController.filterSender())
   }
}
        

// @LINE:42
case controllers_SenderController_saveOrUpdateSender18_route(params) => {
   call { 
        controllers_SenderController_saveOrUpdateSender18_invoker.call(controllers.SenderController.saveOrUpdateSender())
   }
}
        

// @LINE:43
case controllers_SenderController_filterSenderByFullName19_route(params) => {
   call { 
        controllers_SenderController_filterSenderByFullName19_invoker.call(controllers.SenderController.filterSenderByFullName())
   }
}
        

// @LINE:48
case controllers_ReceiverController_index20_route(params) => {
   call { 
        controllers_ReceiverController_index20_invoker.call(controllers.ReceiverController.index())
   }
}
        

// @LINE:49
case controllers_ReceiverController_filterReceiver21_route(params) => {
   call { 
        controllers_ReceiverController_filterReceiver21_invoker.call(controllers.ReceiverController.filterReceiver())
   }
}
        

// @LINE:50
case controllers_ReceiverController_saveOrUpdateReceiver22_route(params) => {
   call { 
        controllers_ReceiverController_saveOrUpdateReceiver22_invoker.call(controllers.ReceiverController.saveOrUpdateReceiver())
   }
}
        

// @LINE:51
case controllers_ReceiverController_filterByFullNameANDAccountNo23_route(params) => {
   call { 
        controllers_ReceiverController_filterByFullNameANDAccountNo23_invoker.call(controllers.ReceiverController.filterByFullNameANDAccountNo())
   }
}
        

// @LINE:56
case controllers_RemittanceController_index24_route(params) => {
   call { 
        controllers_RemittanceController_index24_invoker.call(controllers.RemittanceController.index())
   }
}
        

// @LINE:57
case controllers_RemittanceController_getRemittanceList25_route(params) => {
   call { 
        controllers_RemittanceController_getRemittanceList25_invoker.call(controllers.RemittanceController.getRemittanceList())
   }
}
        

// @LINE:58
case controllers_RemittanceController_getById26_route(params) => {
   call { 
        controllers_RemittanceController_getById26_invoker.call(controllers.RemittanceController.getById())
   }
}
        

// @LINE:59
case controllers_RemittanceController_saveOrUpdateRemittanceTransaction27_route(params) => {
   call { 
        controllers_RemittanceController_saveOrUpdateRemittanceTransaction27_invoker.call(controllers.RemittanceController.saveOrUpdateRemittanceTransaction())
   }
}
        

// @LINE:60
case controllers_RemittanceController_updateTransactionStatus28_route(params) => {
   call { 
        controllers_RemittanceController_updateTransactionStatus28_invoker.call(controllers.RemittanceController.updateTransactionStatus())
   }
}
        

// @LINE:61
case controllers_RemittanceController_previewRemittanceTransaction29_route(params) => {
   call { 
        controllers_RemittanceController_previewRemittanceTransaction29_invoker.call(controllers.RemittanceController.previewRemittanceTransaction())
   }
}
        

// @LINE:62
case controllers_RemittanceController_getBankReference30_route(params) => {
   call { 
        controllers_RemittanceController_getBankReference30_invoker.call(controllers.RemittanceController.getBankReference())
   }
}
        

// @LINE:63
case controllers_RemittanceController_continueTransaction31_route(params) => {
   call { 
        controllers_RemittanceController_continueTransaction31_invoker.call(controllers.RemittanceController.continueTransaction())
   }
}
        

// @LINE:64
case controllers_RemittanceController_getNotificationsForCO32_route(params) => {
   call { 
        controllers_RemittanceController_getNotificationsForCO32_invoker.call(controllers.RemittanceController.getNotificationsForCO())
   }
}
        

// @LINE:65
case controllers_RemittanceController_getNotificationsForTeller33_route(params) => {
   call { 
        controllers_RemittanceController_getNotificationsForTeller33_invoker.call(controllers.RemittanceController.getNotificationsForTeller())
   }
}
        

// @LINE:66
case controllers_RemittanceController_getSenderByRecieverId34_route(params) => {
   call { 
        controllers_RemittanceController_getSenderByRecieverId34_invoker.call(controllers.RemittanceController.getSenderByRecieverId())
   }
}
        

// @LINE:67
case controllers_RemittanceController_getRecieverBySenderId35_route(params) => {
   call { 
        controllers_RemittanceController_getRecieverBySenderId35_invoker.call(controllers.RemittanceController.getRecieverBySenderId())
   }
}
        

// @LINE:68
case controllers_RemittanceController_getRuleFillAmount36_route(params) => {
   call { 
        controllers_RemittanceController_getRuleFillAmount36_invoker.call(controllers.RemittanceController.getRuleFillAmount())
   }
}
        

// @LINE:73
case controllers_ReportController_index37_route(params) => {
   call { 
        controllers_ReportController_index37_invoker.call(controllers.ReportController.index())
   }
}
        

// @LINE:74
case controllers_ReportController_getRemittanceReport38_route(params) => {
   call { 
        controllers_ReportController_getRemittanceReport38_invoker.call(controllers.ReportController.getRemittanceReport())
   }
}
        

// @LINE:75
case controllers_ReportController_exportExcel39_route(params) => {
   call { 
        controllers_ReportController_exportExcel39_invoker.call(controllers.ReportController.exportExcel())
   }
}
        

// @LINE:76
case controllers_ErrorController_techicalError40_route(params) => {
   call { 
        controllers_ErrorController_techicalError40_invoker.call(controllers.ErrorController.techicalError())
   }
}
        

// @LINE:81
case controllers_SettingController_index41_route(params) => {
   call { 
        controllers_SettingController_index41_invoker.call(controllers.SettingController.index())
   }
}
        

// @LINE:82
case controllers_SettingController_changePassword42_route(params) => {
   call { 
        controllers_SettingController_changePassword42_invoker.call(controllers.SettingController.changePassword())
   }
}
        

// @LINE:85
case controllers_Assets_at43_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at43_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     