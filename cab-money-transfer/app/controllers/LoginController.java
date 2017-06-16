/**
 * Created on: 5/10/2014
 */
package controllers;

import models.User;
import models.enums.UserRole;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

import play.Logger;
import play.cache.Cache;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import utils.CABConstantKeys;
import controllers.core.Secured;
import forms.LoginForm;

/**
 * @author vichrak
 */
public class LoginController extends Controller{
    
    final static Form<LoginForm> loginForm = Form.form(LoginForm.class);
    public static final String DELIMITER = "||";
    
    /**
     * Login page.
     */
    @Transactional(readOnly = true)
    public static Result login(){
        final LoginForm exitUser = new LoginForm();
        final Http.Cookie remember = request().cookies().get(CABConstantKeys.SECRET_KEY);
        if(remember != null){
            final BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
            basicTextEncryptor.setPassword(CABConstantKeys.SECRET_KEY);
            try{
                final String valueFromCookie = basicTextEncryptor.decrypt(remember.value());
                final String[] tmpValue = StringUtils.split(valueFromCookie, DELIMITER);
                exitUser.setUsername(tmpValue[0]);
                exitUser.setPassword(tmpValue[1]);
                exitUser.setRememberMe(true);
            }
            catch(final Exception e){
                Logger.warn(e.toString());
                response().discardCookie(CABConstantKeys.SECRET_KEY);
            }
            
        }
        else{
            exitUser.setRememberMe(false);
        }
        if(session(CABConstantKeys.TIME_OUT) != null){
            session().remove(CABConstantKeys.TIME_OUT);
            flash(CABConstantKeys.FLASH_ERROR, CABConstantKeys.MESSAGE_TIME_OUT);
        }
        exitUser.setAuthenticated(true);
        return ok(views.html.login.render(loginForm.fill(exitUser)));
    }
    
    public static Result noAuthorization() {
        return ok(views.html.no_authorization.render());
    }
    
    @Transactional(readOnly = true)
    public static Result sessionExpired(){
        final LoginForm exitUser = new LoginForm();
        final Http.Cookie remember = request().cookies().get(CABConstantKeys.SECRET_KEY);
        final BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(CABConstantKeys.SECRET_KEY);
        try{
            final String valueFromCookie = basicTextEncryptor.decrypt(remember.value());
            final String[] tmpValue = StringUtils.split(valueFromCookie, DELIMITER);
            exitUser.setUsername(tmpValue[0]);
            exitUser.setPassword(tmpValue[1]);
            exitUser.setRememberMe(true);
        }
        catch(final Exception e){
            Logger.info(e.toString());
            response().discardCookie(CABConstantKeys.SECRET_KEY);
        }
        session().remove(CABConstantKeys.TIME_OUT);
        flash(CABConstantKeys.FLASH_ERROR, CABConstantKeys.MESSAGE_TIME_OUT);
        exitUser.setAuthenticated(true);
        return ok(views.html.login.render(loginForm.fill(exitUser)));
    }
    
    /**
     * Handle login form submission.
     * @return {@link Result}
     */
    @Transactional
    public static Result authenticate(){
        final Form<LoginForm> loginForm = Form.form(LoginForm.class).bindFromRequest();
        final User user = User.authenticate(loginForm.get().getUsername(), loginForm.get().getPassword());
        if(user == null){
            final LoginForm form = new LoginForm();
            form.setUsername(loginForm.get().getUsername());
            form.setRememberMe(loginForm.get().isRememberMe());
            form.setAuthenticated(false);
            return ok(views.html.login.render(loginForm.fill(form)));
        }
        else{
            final Long userId = user.getId();
            session(CABConstantKeys.KEY, userId.toString());
            Cache.set(session(CABConstantKeys.KEY), user.getUsername());
            Cache.set(user.getUsername() + CABConstantKeys.BRANCH_SUFFIX, user.getBranch().getId());
            Cache.set(user.getUsername() + CABConstantKeys.USER_SUFIX, user);
            Cache.set(user.getUsername() + CABConstantKeys.ROLE_CODE_SUFFIX, user.getRole().getCode());
            final boolean remember = loginForm.get().isRememberMe();
            // Remember if needed
            if(remember == true){
                final BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
                basicTextEncryptor.setPassword(CABConstantKeys.SECRET_KEY);
                final String encriptValue = loginForm.get().getUsername() + DELIMITER + loginForm.get().getPassword();
                final String value = basicTextEncryptor.encrypt(encriptValue);
                final int maxAge = 5 * 24 * 3600;
                response().setCookie(CABConstantKeys.SECRET_KEY, value, maxAge);
            }
            else{
                //Remove cookie
                response().discardCookie(CABConstantKeys.SECRET_KEY);
            }
            
            // Manage the default home page for current user login
            return redirect(routes.LoginController.redirectPage(user.getUsername()));
        }
    }
    
    /**
     *
     * @param username
     * @return {@link Result}
     */
    @Transactional(readOnly = true)
    public static Result redirectPage(final String username){
        final User user = User.findByLogin(username);
        if(user != null){
            if(user.getRole().getCode().equals(UserRole.ROLE_COMPLIANCE_OFFICER.getCode())){
                return redirect(routes.SenderController.index());
            }
            else if(user.getRole().getCode().equals(UserRole.ROLE_TELLER.getCode())){
                return redirect(routes.RemittanceController.index());
            }
            else if(user.getRole().getCode().equals(UserRole.ROLE_REPORTER.getCode())){
                return redirect(routes.ReportController.index());
            }
            if(user.getRole().getCode().equals(UserRole.ROLE_ADMINISTRATOR.getCode())){
                return redirect(routes.UserController.index());
            }
        }
        return redirect(routes.Application.index());
    }
    
    /**
     * Logout and clean the session.
     */
    @Transactional
    public static Result logout(){
        final String userId = session(CABConstantKeys.KEY);
        Cache.set(userId, null);
        Cache.set(request().username() + CABConstantKeys.BRANCH_SUFFIX, null);
        Cache.set(request().username() + CABConstantKeys.USER_SUFIX, null);
        Cache.set(request().username() + CABConstantKeys.ROLE_CODE_SUFFIX, null);
        session().clear();
        return redirect(routes.LoginController.login());
    }
    
}
