package com.example.a00456020_android_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelSelectFragment extends Fragment implements ItemClickListener{
    private static final String TAG = "HotelSelectFragment";

    View view;
    List<HotelModel> hotels;
    TextView titleTextView;
    Bundle bundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotel_select_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //heading text view
        titleTextView = view.findViewById(R.id.title_text_view);

        String checkInDate = getArguments().getString("check-in date");
        String checkOutDate = getArguments().getString("check-out date");
        int numberOfGuests = getArguments().getInt("number of guests");
        int numberOfRooms = getArguments().getInt("number of rooms");
        String customerName = getArguments().getString("customer name");
        String customerEmail = getArguments().getString("customer email");

        bundle.putString("customer name", customerName);
        bundle.putString("customer email", customerEmail);
        bundle.putInt("number of guests", numberOfGuests);
        bundle.putInt("number of rooms", numberOfRooms);
        bundle.putString("check-in date", checkInDate);
        bundle.putString("check-out date", checkOutDate);

        titleTextView.setText("Welcome " + customerName + ", displaying hotels for " + numberOfGuests + " guests staying from " + checkInDate + " to " + checkOutDate);

        getAllHotels();

    }

    private void getAllHotels(){

        hotels = new ArrayList<HotelModel>();
        APIInterface apiInterface = APIClient.getApiInstance().create(APIInterface.class);
        Call<ArrayList<HotelModel>> hotelModelCall = apiInterface.getAllHotels();
        hotelModelCall.enqueue(new Callback<ArrayList<HotelModel>>() {
            @Override
            public void onResponse(Call<ArrayList<HotelModel>> call, Response<ArrayList<HotelModel>> response) {

                Log.e(TAG, "onResponse: response:" + response.body());

                hotels.addAll(response.body());
                initiateRecyclerView();

            }

            @Override
            public void onFailure(Call<ArrayList<HotelModel>> call, Throwable t) {

            }

        });

    }

    private void initiateRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(), hotels);
        recyclerView.setAdapter(hotelAdapter);

        //Bind the click listener
        hotelAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        HotelModel hotelListData = hotels.get(position);

        String hotelId = hotelListData.getId();
        String hotelName = hotelListData.getName();
        String price = hotelListData.getPrice();
        String availability = hotelListData.getAvailability();

        bundle.putString("hotel id", hotelId);
        bundle.putString("hotel name", hotelName);
        bundle.putString("hotel price", price);
        bundle.putString("hotel availability", availability);

        GuestDetailsFragment guestDetailsFragment = new GuestDetailsFragment();
        guestDetailsFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.remove(HotelSelectFragment.this);
        fragmentTransaction.replace(R.id.main_frame_layout, guestDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();

    }
}
