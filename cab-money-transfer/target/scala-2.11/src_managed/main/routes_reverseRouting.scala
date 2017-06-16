// @SOURCE:C:/dev/play/cab-remittance/conf/routes
// @HASH:959990078f8647a9aadf7ad0fb2dd1a6943f3eec
// @DATE:Sat Feb 07 01:44:49 ICT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:8
package controllers {

// @LINE:85
class ReverseAssets {


// @LINE:85
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseSenderController {


// @LINE:42
def saveOrUpdateSender(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "sender/saveOrUpdateSender")
}
                        

// @LINE:39
def checkAccount(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sender/checkAccount")
}
                        

// @LINE:40
def isInTransaction(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sender/isInTransaction")
}
                        

// @LINE:41
def filterSender(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sender/filterSender")
}
                        

// @LINE:43
def filterSenderByFullName(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sender/filterSenderByFullName")
}
                        

// @LINE:38
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sender")
}
                        

}
                          

// @LINE:82
// @LINE:81
class ReverseSettingController {


// @LINE:82
def changePassword(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "settings/changePassword")
}
                        

// @LINE:81
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "settings")
}
                        

}
                          

// @LINE:75
// @LINE:74
// @LINE:73
class ReverseReportController {


// @LINE:74
def getRemittanceReport(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "report/getRemittanceReport")
}
                        

// @LINE:75
def exportExcel(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "report/exportExcel")
}
                        

// @LINE:73
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "report")
}
                        

}
                          

// @LINE:76
class ReverseErrorController {


// @LINE:76
def techicalError(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "techicalError")
}
                        

}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
class ReverseReceiverController {


// @LINE:48
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "receiver")
}
                        

// @LINE:50
def saveOrUpdateReceiver(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "receiver/saveOrUpdateReceiver")
}
                        

// @LINE:51
def filterByFullNameANDAccountNo(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "receiver/filterByFullNameANDAccountNo")
}
                        

// @LINE:49
def filterReceiver(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "receiver/filterReceiver")
}
                        

}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseUserController {


// @LINE:26
def saveOrUpdateBranch(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "admin/saveOrUpdateBranch")
}
                        

// @LINE:24
def filterUser(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin/filterUser")
}
                        

// @LINE:23
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                        

// @LINE:25
def saveOrUpdateUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "admin/saveOrUpdateUser")
}
                        

}
                          

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
class ReverseLoginController {


// @LINE:17
def redirectPage(username:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "redirectPage" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("username", username)))))
}
                        

// @LINE:16
def sessionExpired(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "session-expired.html")
}
                        

// @LINE:15
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:18
def noAuthorization(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "no-authorization")
}
                        

// @LINE:14
def authenticate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

// @LINE:13
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
class ReverseRemittanceController {


// @LINE:66
def getSenderByRecieverId(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getSenderByRecierId")
}
                        

// @LINE:63
def continueTransaction(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/continueTransaction")
}
                        

// @LINE:59
def saveOrUpdateRemittanceTransaction(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "remittance/saveOrUpdate")
}
                        

// @LINE:67
def getRecieverBySenderId(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getReceiverBySenderId")
}
                        

// @LINE:62
def getBankReference(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getBankReference")
}
                        

// @LINE:58
def getById(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getById")
}
                        

// @LINE:68
def getRuleFillAmount(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getRuleFillAmount")
}
                        

// @LINE:65
def getNotificationsForTeller(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getNotificationsForTeller")
}
                        

// @LINE:57
def getRemittanceList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getRemittanceList")
}
                        

// @LINE:56
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance")
}
                        

// @LINE:64
def getNotificationsForCO(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "remittance/getNotificationsForCO")
}
                        

// @LINE:60
def updateTransactionStatus(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "remittance/updateTransactionStatus")
}
                        

// @LINE:61
def previewRemittanceTransaction(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "remittance/preview")
}
                        

}
                          

// @LINE:8
class ReverseApplication {


// @LINE:8
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:33
// @LINE:32
// @LINE:31
class ReverseRuleFillAmountManagementController {


// @LINE:33
def update(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "rule-fill-amount/update")
}
                        

// @LINE:32
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rule-fill-amount/getAll")
}
                        

// @LINE:31
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rule-fill-amount")
}
                        

}
                          
}
                  


// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:8
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:85
class ReverseAssets {


// @LINE:85
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseSenderController {


// @LINE:42
def saveOrUpdateSender : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SenderController.saveOrUpdateSender",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sender/saveOrUpdateSender"})
      }
   """
)
                        

// @LINE:39
def checkAccount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SenderController.checkAccount",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sender/checkAccount"})
      }
   """
)
                        

// @LINE:40
def isInTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SenderController.isInTransaction",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sender/isInTransaction"})
      }
   """
)
                        

// @LINE:41
def filterSender : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SenderController.filterSender",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sender/filterSender"})
      }
   """
)
                        

// @LINE:43
def filterSenderByFullName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SenderController.filterSenderByFullName",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sender/filterSenderByFullName"})
      }
   """
)
                        

// @LINE:38
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SenderController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sender"})
      }
   """
)
                        

}
              

// @LINE:82
// @LINE:81
class ReverseSettingController {


// @LINE:82
def changePassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SettingController.changePassword",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "settings/changePassword"})
      }
   """
)
                        

// @LINE:81
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SettingController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "settings"})
      }
   """
)
                        

}
              

// @LINE:75
// @LINE:74
// @LINE:73
class ReverseReportController {


// @LINE:74
def getRemittanceReport : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReportController.getRemittanceReport",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "report/getRemittanceReport"})
      }
   """
)
                        

// @LINE:75
def exportExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReportController.exportExcel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "report/exportExcel"})
      }
   """
)
                        

// @LINE:73
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReportController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "report"})
      }
   """
)
                        

}
              

// @LINE:76
class ReverseErrorController {


// @LINE:76
def techicalError : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ErrorController.techicalError",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "techicalError"})
      }
   """
)
                        

}
              

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
class ReverseReceiverController {


// @LINE:48
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReceiverController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receiver"})
      }
   """
)
                        

// @LINE:50
def saveOrUpdateReceiver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReceiverController.saveOrUpdateReceiver",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receiver/saveOrUpdateReceiver"})
      }
   """
)
                        

// @LINE:51
def filterByFullNameANDAccountNo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReceiverController.filterByFullNameANDAccountNo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receiver/filterByFullNameANDAccountNo"})
      }
   """
)
                        

// @LINE:49
def filterReceiver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ReceiverController.filterReceiver",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receiver/filterReceiver"})
      }
   """
)
                        

}
              

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseUserController {


// @LINE:26
def saveOrUpdateBranch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.saveOrUpdateBranch",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/saveOrUpdateBranch"})
      }
   """
)
                        

// @LINE:24
def filterUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.filterUser",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/filterUser"})
      }
   """
)
                        

// @LINE:23
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        

// @LINE:25
def saveOrUpdateUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.saveOrUpdateUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/saveOrUpdateUser"})
      }
   """
)
                        

}
              

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
class ReverseLoginController {


// @LINE:17
def redirectPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.redirectPage",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "redirectPage" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("username", username)])})
      }
   """
)
                        

// @LINE:16
def sessionExpired : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.sessionExpired",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "session-expired.html"})
      }
   """
)
                        

// @LINE:15
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:18
def noAuthorization : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.noAuthorization",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "no-authorization"})
      }
   """
)
                        

// @LINE:14
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:13
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
class ReverseRemittanceController {


// @LINE:66
def getSenderByRecieverId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getSenderByRecieverId",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getSenderByRecierId"})
      }
   """
)
                        

// @LINE:63
def continueTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.continueTransaction",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/continueTransaction"})
      }
   """
)
                        

// @LINE:59
def saveOrUpdateRemittanceTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.saveOrUpdateRemittanceTransaction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/saveOrUpdate"})
      }
   """
)
                        

// @LINE:67
def getRecieverBySenderId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getRecieverBySenderId",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getReceiverBySenderId"})
      }
   """
)
                        

// @LINE:62
def getBankReference : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getBankReference",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getBankReference"})
      }
   """
)
                        

// @LINE:58
def getById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getById",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getById"})
      }
   """
)
                        

// @LINE:68
def getRuleFillAmount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getRuleFillAmount",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getRuleFillAmount"})
      }
   """
)
                        

// @LINE:65
def getNotificationsForTeller : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getNotificationsForTeller",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getNotificationsForTeller"})
      }
   """
)
                        

// @LINE:57
def getRemittanceList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getRemittanceList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getRemittanceList"})
      }
   """
)
                        

// @LINE:56
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance"})
      }
   """
)
                        

// @LINE:64
def getNotificationsForCO : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.getNotificationsForCO",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/getNotificationsForCO"})
      }
   """
)
                        

// @LINE:60
def updateTransactionStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.updateTransactionStatus",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/updateTransactionStatus"})
      }
   """
)
                        

// @LINE:61
def previewRemittanceTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RemittanceController.previewRemittanceTransaction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remittance/preview"})
      }
   """
)
                        

}
              

// @LINE:8
class ReverseApplication {


// @LINE:8
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:33
// @LINE:32
// @LINE:31
class ReverseRuleFillAmountManagementController {


// @LINE:33
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RuleFillAmountManagementController.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rule-fill-amount/update"})
      }
   """
)
                        

// @LINE:32
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RuleFillAmountManagementController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rule-fill-amount/getAll"})
      }
   """
)
                        

// @LINE:31
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RuleFillAmountManagementController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rule-fill-amount"})
      }
   """
)
                        

}
              
}
        


// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:8
package controllers.ref {


// @LINE:85
class ReverseAssets {


// @LINE:85
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseSenderController {


// @LINE:42
def saveOrUpdateSender(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SenderController.saveOrUpdateSender(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "saveOrUpdateSender", Seq(), "POST", """""", _prefix + """sender/saveOrUpdateSender""")
)
                      

// @LINE:39
def checkAccount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SenderController.checkAccount(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "checkAccount", Seq(), "GET", """""", _prefix + """sender/checkAccount""")
)
                      

// @LINE:40
def isInTransaction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SenderController.isInTransaction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "isInTransaction", Seq(), "GET", """""", _prefix + """sender/isInTransaction""")
)
                      

// @LINE:41
def filterSender(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SenderController.filterSender(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "filterSender", Seq(), "GET", """""", _prefix + """sender/filterSender""")
)
                      

// @LINE:43
def filterSenderByFullName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SenderController.filterSenderByFullName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "filterSenderByFullName", Seq(), "GET", """""", _prefix + """sender/filterSenderByFullName""")
)
                      

// @LINE:38
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SenderController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SenderController", "index", Seq(), "GET", """ ============================================================================
 Sender
 ============================================================================""", _prefix + """sender""")
)
                      

}
                          

// @LINE:82
// @LINE:81
class ReverseSettingController {


// @LINE:82
def changePassword(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SettingController.changePassword(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SettingController", "changePassword", Seq(), "POST", """""", _prefix + """settings/changePassword""")
)
                      

// @LINE:81
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SettingController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SettingController", "index", Seq(), "GET", """ ============================================================================
 Settings
 ============================================================================""", _prefix + """settings""")
)
                      

}
                          

// @LINE:75
// @LINE:74
// @LINE:73
class ReverseReportController {


// @LINE:74
def getRemittanceReport(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReportController.getRemittanceReport(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReportController", "getRemittanceReport", Seq(), "GET", """""", _prefix + """report/getRemittanceReport""")
)
                      

// @LINE:75
def exportExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReportController.exportExcel(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReportController", "exportExcel", Seq(), "GET", """""", _prefix + """report/exportExcel""")
)
                      

// @LINE:73
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReportController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReportController", "index", Seq(), "GET", """ ============================================================================
 Report
 ============================================================================""", _prefix + """report""")
)
                      

}
                          

// @LINE:76
class ReverseErrorController {


// @LINE:76
def techicalError(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ErrorController.techicalError(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ErrorController", "techicalError", Seq(), "GET", """""", _prefix + """techicalError""")
)
                      

}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
class ReverseReceiverController {


// @LINE:48
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReceiverController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "index", Seq(), "GET", """ ============================================================================
 Receiver
 ============================================================================""", _prefix + """receiver""")
)
                      

// @LINE:50
def saveOrUpdateReceiver(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReceiverController.saveOrUpdateReceiver(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "saveOrUpdateReceiver", Seq(), "POST", """""", _prefix + """receiver/saveOrUpdateReceiver""")
)
                      

// @LINE:51
def filterByFullNameANDAccountNo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReceiverController.filterByFullNameANDAccountNo(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "filterByFullNameANDAccountNo", Seq(), "GET", """""", _prefix + """receiver/filterByFullNameANDAccountNo""")
)
                      

// @LINE:49
def filterReceiver(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ReceiverController.filterReceiver(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ReceiverController", "filterReceiver", Seq(), "GET", """""", _prefix + """receiver/filterReceiver""")
)
                      

}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseUserController {


// @LINE:26
def saveOrUpdateBranch(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.saveOrUpdateBranch(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "saveOrUpdateBranch", Seq(), "POST", """""", _prefix + """admin/saveOrUpdateBranch""")
)
                      

// @LINE:24
def filterUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.filterUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "filterUser", Seq(), "GET", """""", _prefix + """admin/filterUser""")
)
                      

// @LINE:23
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "index", Seq(), "GET", """ ============================================================================
 User
 ============================================================================""", _prefix + """admin""")
)
                      

// @LINE:25
def saveOrUpdateUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.saveOrUpdateUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "saveOrUpdateUser", Seq(), "POST", """""", _prefix + """admin/saveOrUpdateUser""")
)
                      

}
                          

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
class ReverseLoginController {


// @LINE:17
def redirectPage(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.redirectPage(username), HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "redirectPage", Seq(classOf[String]), "GET", """""", _prefix + """redirectPage""")
)
                      

// @LINE:16
def sessionExpired(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.sessionExpired(), HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "sessionExpired", Seq(), "GET", """""", _prefix + """session-expired.html""")
)
                      

// @LINE:15
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:18
def noAuthorization(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.noAuthorization(), HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "noAuthorization", Seq(), "GET", """""", _prefix + """no-authorization""")
)
                      

// @LINE:14
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.authenticate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:13
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.LoginController", "login", Seq(), "GET", """ ============================================================================
 Authentication
 ============================================================================""", _prefix + """login""")
)
                      

}
                          

// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
class ReverseRemittanceController {


// @LINE:66
def getSenderByRecieverId(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getSenderByRecieverId(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getSenderByRecieverId", Seq(), "GET", """""", _prefix + """remittance/getSenderByRecierId""")
)
                      

// @LINE:63
def continueTransaction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.continueTransaction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "continueTransaction", Seq(), "GET", """""", _prefix + """remittance/continueTransaction""")
)
                      

// @LINE:59
def saveOrUpdateRemittanceTransaction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.saveOrUpdateRemittanceTransaction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "saveOrUpdateRemittanceTransaction", Seq(), "POST", """""", _prefix + """remittance/saveOrUpdate""")
)
                      

// @LINE:67
def getRecieverBySenderId(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getRecieverBySenderId(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getRecieverBySenderId", Seq(), "GET", """""", _prefix + """remittance/getReceiverBySenderId""")
)
                      

// @LINE:62
def getBankReference(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getBankReference(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getBankReference", Seq(), "GET", """""", _prefix + """remittance/getBankReference""")
)
                      

// @LINE:58
def getById(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getById(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getById", Seq(), "GET", """""", _prefix + """remittance/getById""")
)
                      

// @LINE:68
def getRuleFillAmount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getRuleFillAmount(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getRuleFillAmount", Seq(), "GET", """""", _prefix + """remittance/getRuleFillAmount""")
)
                      

// @LINE:65
def getNotificationsForTeller(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getNotificationsForTeller(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getNotificationsForTeller", Seq(), "GET", """""", _prefix + """remittance/getNotificationsForTeller""")
)
                      

// @LINE:57
def getRemittanceList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getRemittanceList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getRemittanceList", Seq(), "GET", """""", _prefix + """remittance/getRemittanceList""")
)
                      

// @LINE:56
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "index", Seq(), "GET", """ ============================================================================
 Remittance
 ============================================================================""", _prefix + """remittance""")
)
                      

// @LINE:64
def getNotificationsForCO(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.getNotificationsForCO(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "getNotificationsForCO", Seq(), "GET", """""", _prefix + """remittance/getNotificationsForCO""")
)
                      

// @LINE:60
def updateTransactionStatus(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.updateTransactionStatus(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "updateTransactionStatus", Seq(), "POST", """""", _prefix + """remittance/updateTransactionStatus""")
)
                      

// @LINE:61
def previewRemittanceTransaction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RemittanceController.previewRemittanceTransaction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RemittanceController", "previewRemittanceTransaction", Seq(), "POST", """""", _prefix + """remittance/preview""")
)
                      

}
                          

// @LINE:8
class ReverseApplication {


// @LINE:8
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ ============================================================================
 Home page
 ============================================================================""", _prefix + """""")
)
                      

}
                          

// @LINE:33
// @LINE:32
// @LINE:31
class ReverseRuleFillAmountManagementController {


// @LINE:33
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RuleFillAmountManagementController.update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RuleFillAmountManagementController", "update", Seq(), "POST", """""", _prefix + """rule-fill-amount/update""")
)
                      

// @LINE:32
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RuleFillAmountManagementController.getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RuleFillAmountManagementController", "getAll", Seq(), "GET", """""", _prefix + """rule-fill-amount/getAll""")
)
                      

// @LINE:31
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RuleFillAmountManagementController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RuleFillAmountManagementController", "index", Seq(), "GET", """ ============================================================================
 Rule Fill Amount
 ============================================================================""", _prefix + """rule-fill-amount""")
)
                      

}
                          
}
        
    