package com.robo.retrofitexample;

import com.robo.retrofitexample.POJO.Reviews;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kundan on 8/8/2015.
 */
public interface RestInterfaceGizmo {

    @GET("/latest-reviews.json")
    void getWheatherReport(Callback<Reviews> cb);

}
