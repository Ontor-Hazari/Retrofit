package com.example.retrofit.retrofit;

import android.content.Context;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {

  private  Context context;

    private Apiclient()
    {

    }

    private static final String  BASE_URL = "https://jsonplaceholder.typicode.com/";

    private  static Retrofit retrofit = null;

    public  static synchronized ApiInterface getInstace()
    {
        if(retrofit==null)
        {
           try
           {
               retrofit = new Retrofit
                       .Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

               Log.d("link","insert succsesfully");
           }
           catch (Exception e)
           {
               Log.d("link","insert unsuccsesfully");
           }
        }

        return   retrofit.create(ApiInterface.class);
    }
}
