package com.my.common.modules.retrofit.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by conan on 2017/5/24.
 */
public class LoggingInterceptor implements Interceptor{
    private static Logger logger=Logger.getLogger(LoggingInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        logger.info(String.format("发送请求:%s%n请求头:%s",request.url(),
                request.headers()));
        Response response=chain.proceed(request);
        return response;
    }
}
