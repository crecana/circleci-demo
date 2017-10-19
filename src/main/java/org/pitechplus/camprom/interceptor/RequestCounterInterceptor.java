package org.pitechplus.camprom.interceptor;

import io.prometheus.client.Counter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author atincu
 *
 * This class creates a metric that counts the number of requests for each endpoint
 */
public class RequestCounterInterceptor extends HandlerInterceptorAdapter {

    private static final Counter requestTotal = Counter.build()
            .name("cam_http_requests_total")
            .labelNames("method", "handler", "status")
            .help("Http Request Total").register();

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
            throws Exception {
        // Update counters
        String handlerLabel = handler.toString();
        // get short form of handler method name
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            handlerLabel = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        }
        // Note (2)
        requestTotal.labels(request.getMethod(), handlerLabel, Integer.toString(response.getStatus())).inc();
    }

}
