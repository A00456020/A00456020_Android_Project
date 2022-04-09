package com.example.a00456020_android_project;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("hotels/")
    Call<ArrayList<HotelModel>> getAllHotels();

    @FormUrlEncoded
    @POST("reservations/")
    Call<ReservationModel> makeReservation(@Field("hotel_id") String hotel_id,
                                           @Field("customer_id") String customer_id,
                                           @Field("checkin_date") String checkin_date,
                                           @Field("checkout_date") String checkout_date,
                                           @Field("number_of_rooms") String number_of_rooms);

}
