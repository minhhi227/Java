/**
 * Created on: 25/10/2014
 */
package controllers;

import static play.libs.Json.toJson;
import models.User;
import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Security;
import utils.CABConstantKeys;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.core.AbstractController;
import controllers.core.Secured;

/**
 * @author vichrak
 */
@Security.Authenticated(Secured.class)
public class SettingController extends AbstractController{
    
    private static User _user;
    
    /**
     * Setting page.
     */
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        _user = User.findByLogin(getUsername());
        return ok(views.html.settings.render(_user));
    }
    
    @Transactional
    public static Result changePassword(){
        JsonNode rootNode = request().body().asJson();
        if(rootNode != null){
            String username = rootNode.path("username").asText();
            String newPassword = rootNode.path("newPassword").asText();
            
            User user = User.findByLogin(username);
            user.setPassword(newPassword);
            User.saveOrUpdate(user);
            
            return ok(toJson(CABConstantKeys.SUCCESS));
        }
        else{
            return ok(toJson("json_expected"));
        }
    }
    
}
