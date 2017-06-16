package controllers;

import static play.libs.Json.toJson;

import java.util.List;
import java.util.Map;

import models.RuleFillAmountManagement;
import models.User;
import models.dto.JQueryDataTableParamModelDto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Security;
import utils.CABConstantKeys;
import annotation.AuthorizationAnnotation;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.core.AbstractController;
import controllers.core.Secured;

@Security.Authenticated(Secured.class)
@AuthorizationAnnotation({
    "role_administrator"
})
public class RuleFillAmountManagementController extends AbstractController {

    private static final Log LOG = LogFactory.getLog(UserController.class);
    private static User _user;

    @Transactional(readOnly = true)
    public static Result index() {
        _user = User.findByLogin(request().username());
        return ok(views.html.admin.rule_fill_amount_managment.render(_user, "rule_fill_amount_managment"));
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getAll() {
        final Map<String, String[]> parames = request().queryString();
        final JQueryDataTableParamModelDto jQueryDataTableParamModel = new JQueryDataTableParamModelDto(parames);
        try {
            final List<RuleFillAmountManagement> ruleFillAmountManagements = RuleFillAmountManagement.getAll();
            final JSONArray[] jsonData = new JSONArray[ruleFillAmountManagements.size()];
            int i = 0;
            for (final RuleFillAmountManagement rule : ruleFillAmountManagements) {
                final JSONArray jsonArray = new JSONArray();
                jsonArray.add(rule.getId());
                jsonArray.add(rule.getRuleType());
                jsonArray.add(rule.getSenderType());
                jsonArray.add(rule.getUsdAmount());
                jsonArray.add(rule.getPercentFee());
                jsonArray.add(rule.getCable());
                jsonData[i] = jsonArray;
                i++;
            }
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put(CABConstantKeys.SECHO, jQueryDataTableParamModel.getsEcho());
            jsonObject.put(CABConstantKeys.ITOTALRECORDS, jQueryDataTableParamModel.getiTotalRecords());
            jsonObject.put(CABConstantKeys.ITOTALDISPLAYRECORDS, jQueryDataTableParamModel.getiTotalRecords());
            jsonObject.put(CABConstantKeys.AADATA, jsonData);
            final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
            return ok(jsonNode);
        }
        catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    @Transactional
    public static Result update() {
        try {
            final JsonNode rootNode = request().body().asJson();
            if (rootNode != null) {
                final Long ruleId = rootNode.path("hidRuleManagementId").asLong();
                final RuleFillAmountManagement ruleFillAmountManagement = (RuleFillAmountManagement) RuleFillAmountManagement.findById(RuleFillAmountManagement.class, ruleId);
                final double usdAmount = rootNode.path("usdAmount").asDouble();
                final double percentFee = rootNode.path("percentFee").asDouble();
                final double cable = rootNode.path("cable").asDouble();
                ruleFillAmountManagement.setUsdAmount(usdAmount);
                ruleFillAmountManagement.setPercentFee(percentFee);
                ruleFillAmountManagement.setCable(cable);

                RuleFillAmountManagement.updateBySenderType(usdAmount, ruleFillAmountManagement.getSenderType());
                
                return ok(toJson(CABConstantKeys.SUCCESS));
            }
            else {
                return ok(toJson("json_expected"));
            }
        }
        catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

}
