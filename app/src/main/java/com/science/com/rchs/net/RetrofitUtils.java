package com.science.com.rchs.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static final int DEFAULT_TIME=10;
    //双重锁
    private static RetrofitUtils retrofitUtils;
    private void RetrofitUtils(){}
    public static RetrofitUtils getRetrofitUtils(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    //返回OkHttpClient 通过应用拦截器添加公共参数
    public OkHttpClient getOkHttp(final String sessionId, final String userId) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("sessionId", sessionId)
                                .addHeader("userId", userId)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return okHttpClient;


    }


    //初始化必要对象和参数------有请求头的
    public Retrofit getRetrofitHeader(String url, final String token){

        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttp(url,token))
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return  retrofit;

    }

    public <T> T getApiServiceHeader(String url, final String token, Class<T> service) {

        Retrofit retrofit = getRetrofitHeader(url,token);
        //通过java动态代理模式获取代理对象
        T t = retrofit.create(service);

        return t;

    }


    public Retrofit getRetrofit(String url){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return  retrofit;

    }

    public <T> T getApiService(String url, Class<T> service) {

        Retrofit retrofit = getRetrofit(url);
        //通过java动态代理模式获取代理对象
        T t = retrofit.create(service);
        return t;

    }

}
