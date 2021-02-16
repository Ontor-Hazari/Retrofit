package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.retrofit.model.ModelPost;
import com.example.retrofit.retrofit.ApiInterface;
import com.example.retrofit.retrofit.Apiclient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<ModelPost> posts;

    ApiInterface apiInterface;
    private final String TAG = "MainActivity";

    RecyclerView recycelerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycelerview = (RecyclerView) findViewById(R.id.recycelerview);

        posts = new ArrayList<>();

        apiInterface = Apiclient.getInstace();
        recycelerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Adapter adapter = new Adapter(posts,this);


        recycelerview.setAdapter(adapter);


        apiInterface.getposts().enqueue(new Callback<List<ModelPost>>() {
            @Override
            public void onResponse(Call<List<ModelPost>> call, Response<List<ModelPost>> response) {
                posts.addAll(response.body());
                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,""+response.body().size(),Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<ModelPost>> call, Throwable t) {

                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });
    }
}