package com.example.restaurantsapplication.server;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL="https://04bc048c-2ea7-49a3-a2c0-4018e398e7e7.mock.pstmn.io/";


    public static Retrofit getInstance(){


         Retrofit  instance= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        return  instance;

    }

    public static RetrofitInterface getService(){
        RetrofitInterface retrofitInterface=getInstance().create(RetrofitInterface.class);
        return retrofitInterface;
    }

    public static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor=getHttpLoggingInterceptor();
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;

    }
}
