package com.example.a00456020_android_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestDetailsFragment extends Fragment {

    View view;
    TextView headingTextView;
    EditText guestName, guest2Name;
    EditText guestGender, guest2Gender;
    int numberOfGuests;
    String guest_name, guest2_name, guest_gender, guest2_gender;
    Button nextButton;

    private static final String TAG = "GuestDetailsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guest_details_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headingTextView = view.findViewById(R.id.heading_text_view);
//        guestName = view.findViewById(R.id.guest_name_edit_text);
//        guest2Name = view.findViewById(R.id.guest2_name_edit_text);
//        guestGender = view.findViewById(R.id.guest_gender_edit_text);
//        guest2Gender = view.findViewById(R.id.guest2_gender_edit_text);
        nextButton = view.findViewById(R.id.next_button);

        String checkInDate = getArguments().getString("check-in date");
        String checkOutDate = getArguments().getString("check-out date");
        numberOfGuests = getArguments().getInt("number of guests");
        int numberOfRooms = getArguments().getInt("number of rooms");
        String customerName = getArguments().getString("customer name");
        String customerEmail = getArguments().getString("customer email");
        String hotelId = getArguments().getString("hotel id");

        headingTextView.setText(customerName + ", please enter guest details for " + numberOfGuests + " guests \n staying from " + checkInDate + " to " + checkOutDate);

        initiateRecyclerView();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                guest_name = guestName.getText().toString();
//                guest2_name = guest2Name.getText().toString();
//                guest2_gender = guest2Gender.getText().toString();
//                guest2_name = guest2Name.getText().toString();
                String checkInDate = getArguments().getString("check-in date");
                String checkOutDate = getArguments().getString("check-out date");
                numberOfGuests = getArguments().getInt("number of guests");
                int numberOfRooms = getArguments().getInt("number of rooms");
                String customerName = getArguments().getString("customer name");
                String customerEmail = getArguments().getString("customer email");
                String hotelId = getArguments().getString("hotel id");

                APIInterface apiInterface = APIClient.getApiInstance().create(APIInterface.class);
                Call<ReservationModel> makeReservation = apiInterface.makeReservation(hotelId,
                        "1", checkInDate, checkOutDate, String.valueOf(numberOfRooms));
                makeReservation.enqueue(new Callback<ReservationModel>() {
                    @Override
                    public void onResponse(Call<ReservationModel> call, Response<ReservationModel> response) {

                        Log.e(TAG, "onResponse: response:" + response.body());

                    }

                    @Override
                    public void onFailure(Call<ReservationModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: Failure:" + t.getMessage());

                    }

                });

            }
        });

    }

    private void initiateRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.guest_details_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        GuestDetailsAdapter guestDetailsAdapter = new GuestDetailsAdapter(getActivity(), numberOfGuests);
        recyclerView.setAdapter(guestDetailsAdapter);

    }

}
