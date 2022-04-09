package com.example.a00456020_android_project;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("hotels/")
    Call<List<HotelModel>> getAllHotels();

}
