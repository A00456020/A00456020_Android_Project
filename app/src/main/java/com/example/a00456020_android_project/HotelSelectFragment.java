package com.example.a00456020_android_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelSelectFragment extends Fragment {

    View view;
    List<HotelModel> hotels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotel_select_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        APIInterface apiInterface = APIClient.getApiInstance().create(APIInterface.class);
        Call<List<HotelModel>> hotelModelCall = apiInterface.getAllHotels();
        hotelModelCall.enqueue(new Callback<List<HotelModel>>() {
            @Override
            public void onResponse(Call<List<HotelModel>> call, Response<List<HotelModel>> response) {

                hotels.addAll(response.body());

            }

            @Override
            public void onFailure(Call<List<HotelModel>> call, Throwable t) {

            }

        });

    }
}
