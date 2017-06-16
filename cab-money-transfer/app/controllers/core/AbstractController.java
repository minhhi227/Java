/*
 * Created on 5 Oct. 2014
 */
package controllers.core;

import org.apache.commons.lang3.StringUtils;

import play.mvc.Controller;

/**
 * @author vichrak 
 * 
 * Used to redirect to previous request.
 */
public class AbstractController extends Controller{
    
    public static String requestUri = StringUtils.EMPTY;
    
    public static String getUsername(){
        return request().username();
    }
}
