/**
 * Created on: 30/05/2012
 */
package controllers.core;

import controllers.routes;
import play.Logger;
import play.cache.Cache;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import utils.CABConstantKeys;

/**
 * @author sbunthoeun
 *
 */
public class Secured extends Security.Authenticator{
    
    @Override
    public String getUsername(Context ctx){
        String username = (String) Cache.get(ctx.session().get(CABConstantKeys.KEY));
        return username;
    }
    
    @Override
    public Result onUnauthorized(Context ctx){
        return redirect(routes.LoginController.login());
    }
    
}
