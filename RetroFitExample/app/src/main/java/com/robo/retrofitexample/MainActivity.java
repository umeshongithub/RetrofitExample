package com.robo.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.robo.retrofitexample.POJO.Reviews;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    TextView city;
    String url = "http://drop.ndtv.com/ndtv/apps/feeds/gadgets360";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = (TextView) findViewById(R.id.txt_city);

        //making object of RestAdapter
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        //Creating Rest Services
        RestInterfaceGizmo restInterface = adapter.create(RestInterfaceGizmo.class);
        //Calling method to get whether report
        restInterface.getWheatherReport(new Callback<Reviews>() {
            @Override
            public void success(com.robo.retrofitexample.POJO.Reviews model, Response response) {
                city.setText("city :" + model.total);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }


}
