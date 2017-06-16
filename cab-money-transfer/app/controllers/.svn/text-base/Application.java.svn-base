package controllers;

import controllers.core.AbstractController;
import controllers.core.Secured;
import models.User;
import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(Secured.class)
public class Application extends AbstractController{
    
    /**
     * @return {@link Result}
     */
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        String currentUsername = request().username();
        User user = User.findByLogin(currentUsername);
        if(user != null){
            return redirect(routes.LoginController.redirectPage(user.getUsername()));
        }
        else{
            return ok(views.html.index.render(user));
        }
    }
}
