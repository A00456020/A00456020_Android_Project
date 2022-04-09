package com.example.a00456020_android_project;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("hotels/")
    Call<ArrayList<HotelModel>> getAllHotels();

}
