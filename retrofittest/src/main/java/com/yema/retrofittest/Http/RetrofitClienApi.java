package com.yema.retrofittest.Http;

import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class RetrofitClienApi {
    private static Retrofit retrofit;
    /**
     * 实例化 Retrofit
     *
     * @return
     */

    private static final OkHttpClient clientSSOServer = new OkHttpClient.Builder().
            connectTimeout(30, TimeUnit.SECONDS).
            addNetworkInterceptor(loggingInterceptor()).
            readTimeout(30, TimeUnit.SECONDS).
            writeTimeout(30, TimeUnit.SECONDS).build();


    /**
     * 添加请求log日志
     *
     * @return
     */
    private static final HttpLoggingInterceptor loggingInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
            try {
                String text = URLDecoder.decode(message, "utf-8");
                Log.e("OKHttp-----", text);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Log.e("OKHttp-----", message);
            }
        });

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitClienApi.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl("")//基础url
                        .client(null)//okhttpclient
                        .addConverterFactory(GsonConverterFactory.create())//转换器
                        .build();
            }
        }
        return retrofit;
    }

    /**
     * 修改baseurl问题
     *
     * @param newApiBaseUrl
     * @return
     */
    public static Retrofit changeApiBaseUrl(String newApiBaseUrl) {
        return retrofit = new Retrofit.Builder()
//                .client(clientSSOServer)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(newApiBaseUrl)
                .build();

    }


    public <T> Class<T> getApi(Class<T> a) {
        Class t = null;
        if (t == null) {
            synchronized (RetrofitClienApi.class) {
                t = getRetrofit().create(a.getClass());
            }
        }
        return t;
    }

}
