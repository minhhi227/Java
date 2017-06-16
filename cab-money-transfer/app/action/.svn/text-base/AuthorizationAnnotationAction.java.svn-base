/**
 * 21/12/2014
 */
package action;

import java.util.Arrays;
import controllers.routes;
import annotation.AuthorizationAnnotation;
import play.cache.Cache;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import utils.CABConstantKeys;

/**
 * 
 * @author Chamnan
 *
 */
public class AuthorizationAnnotationAction extends Action<AuthorizationAnnotation> {

    @Override
    public Promise<Result> call(final Context ctx) throws Throwable {
        String[] params = configuration.value();
        if(params == null || params.length == 0) {
            return delegate.call(ctx);
        }
        String username = (String) Cache.get(ctx.session().get(CABConstantKeys.KEY));
        if(Arrays.asList(params).contains(Cache.get(username + CABConstantKeys.ROLE_CODE_SUFFIX))) {
            return delegate.call(ctx); 
        }
        else {
            return Promise.pure(redirect(routes.LoginController.noAuthorization()));
        }
    }

}
