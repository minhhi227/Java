/**
 * Oct 1, 2014
 */
import java.util.ArrayList;
import java.util.List;

import models.CurrencyExchange;
import models.enums.TypeSender;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.cache.Cache;
import play.db.jpa.JPA;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import utils.CABConstantKeys;

/**
 * @author Vichrak
 */
public class Global extends GlobalSettings {

    /**
     * Constructor
     */
    public Global(){
        super();
    }
    
    @Override
    public void beforeStart(final Application app){
        /**
         * execute before any plugin.
         */
    }
    
    @Override
    public void onStart(final Application app){
        Logger.info("Application has started.");
        storeCurrency();
        storeSenderTypes();
    }
    
    private void storeSenderTypes(){
        final List<String> typeSenders = new ArrayList<String>();
        typeSenders.add(TypeSender.TO721.getCode());
        typeSenders.add(TypeSender.VI731.getCode());
        typeSenders.add(TypeSender.CH741.getCode());
        Cache.set(CABConstantKeys.SENDER_TYPE, typeSenders);
    }
    
    private void storeCurrency(){
        try{
            JPA.withTransaction(new play.libs.F.Callback0(){
                
                @Override
                public void invoke(){
                    final List<CurrencyExchange> listCurrencies = CurrencyExchange.getAll();
                    Cache.set(CABConstantKeys.CURRENCY, listCurrencies);
                }
            });
        }
        catch(final Exception ex){
            Logger.error("Can't get currency.");
        }
    }
    
    @Override
    public void onStop(final Application app){
        Logger.info("Application has stopped.");
    }
    
    //    @SuppressWarnings("rawtypes")
    //    @Override
    //    public Action onRequest(Request request, Method actionMethod){
    //        /**
    //         * Call to create the root Action of a request for a Java application.
    //         * The request and actionMethod values are passed for information.
    //         */
    //        return new Action.Simple(){
    //
    //            @Override
    //            public Promise<Result> call(Context context) throws Throwable{
    //
    //                /* default */
    //                return delegate.call(context);
    //            }
    //        };
    //    }
    
    //    @Override
    //    public play.api.mvc.Handler onRouteRequest(RequestHeader request){
    //        /**
    //         * Called when an HTTP request has been received.
    //         * The default implementation (return null) means to use the application router
    //         * to find the appropriate action By overriding this method one
    //         * can provide an alternative routing mechanism.
    //         */
    //        return null;
    //    }
    
    //    @Override
    //    public Promise<Result> onError(RequestHeader request, Throwable t){
    //        /**
    //         * Called when an exception occurred. The default is to send the framework's default error page.
    //         * This is achieved by returning null, so that the Scala engine handles the excepetion and shows
    //         * an error page. By overriding this method one can provide an alternative error page.
    //         */
    //        return controllers.ErrorController.techicalError();
    //    }
    
    @Override
    public Promise<Result> onHandlerNotFound(final RequestHeader request){
        /**
         * Called when no action was found to serve a request. The default behavior is to render the
         * framework's default 404 page. This is achieved by returning null, so that the Scala engine
         * handles onHandlerNotFound. By overriding this method one can provide an alternative 404 page.
         */
        return null;
    }
    
    @Override
    public Promise<Result> onBadRequest(final RequestHeader request, final String error){
        /**
         * Called when an action has been found, but the request parsing has failed. The default behavior
         * is to render the framework's default 400 page. This is achieved by returning null, so that the
         * Scala engine handles onBadRequest. By overriding this method one can provide an alternative 400 page.
         */
        return null;
    }
    //
    //    @Override
    //    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception{
    //        /**
    //         * Manages controllers instantiation.
    //         */
    //        return null;
    //    }
    //
    //    @Override
    //    public Configuration onLoadConfig(Configuration config, File path, ClassLoader classloader){
    //        /**
    //         * Called just after configuration has been loaded, to give the application an opportunity to modify it.
    //         */
    //        return null;
    //    }
}