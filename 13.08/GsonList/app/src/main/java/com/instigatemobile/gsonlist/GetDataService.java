package com.instigatemobile.gsonlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/users")
    Call<List<People>> getAllPeoples();
}

