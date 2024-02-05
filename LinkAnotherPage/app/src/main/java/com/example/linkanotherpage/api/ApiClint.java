package com.example.linkanotherpage.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClint {
    private static final String BASE_URL ="https://purbacal.emranhss.com/";

    private  static Retrofit retrofit ;

    public static Retrofit getRetrofitInstance (){
        if (retrofit == null){
            retrofit =new  Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
