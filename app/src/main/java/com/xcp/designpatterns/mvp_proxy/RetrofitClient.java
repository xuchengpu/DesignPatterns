package com.xcp.designpatterns.mvp_proxy;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 许成谱 on 2019/6/17 11:05.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class RetrofitClient {
    public static ServiceApi getServiceApi() {
        return ServiceApiHolder.serviceApi;
    }

    //静态保证了在内存中只存在一份实例且第一次调用时才加载，最推荐的单例模式
    private static class ServiceApiHolder {

        private static final ServiceApi serviceApi;

        static {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor(new HttpLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                    .connectTimeout(8, TimeUnit.SECONDS)
                    .readTimeout(8, TimeUnit.SECONDS)
                    .build();
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .client(client)
                    .baseUrl(URLHelper.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            serviceApi = retrofit.create(ServiceApi.class);
        }
    }


    static class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.e("HttpLogger", "" + message);
        }
    }

}
