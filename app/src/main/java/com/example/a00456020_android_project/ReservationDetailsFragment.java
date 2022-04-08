package com.example.a00456020_android_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class ReservationDetailsFragment extends Fragment {

    View view;
    ConstraintLayout mainConstraintLayout;
    EditText customerNameEditText;
    EditText customerEmailEditText;
    EditText numberOfRoomsEditText;
    EditText numberOfGuestsEditText;
    DatePicker checkInDateDatePicker;
    DatePicker checkOutDateDatePicker;
    Button reservationSearchButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.reservation_details_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainConstraintLayout = view.findViewById(R.id.main_constraint_layout);
        customerNameEditText = view.findViewById(R.id.customer_name_edit_text);
        customerEmailEditText = view.findViewById(R.id.customer_email_edit_text);
        numberOfRoomsEditText = view.findViewById(R.id.number_of_rooms_edit_text);
        numberOfGuestsEditText = view.findViewById(R.id.number_of_guests_edit_text);
        checkInDateDatePicker = view.findViewById(R.id.check_in_date_date_picker);
        checkOutDateDatePicker = view.findViewById(R.id.check_out_date_date_picker);
        reservationSearchButton = view.findViewById(R.id.reservation_search_button);

        reservationSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        reservationSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
