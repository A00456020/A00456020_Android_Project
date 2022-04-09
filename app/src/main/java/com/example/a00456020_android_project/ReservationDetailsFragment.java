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
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    String checkInDate, checkOutDate, customerName, customerEmail;
    int numberOfRooms, numberOfGuests;


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
                customerName = customerNameEditText.getText().toString();
                customerEmail = customerEmailEditText.getText().toString();
                numberOfRooms = Integer.parseInt(numberOfRoomsEditText.getText().toString());
                numberOfGuests = Integer.parseInt(numberOfGuestsEditText.getText().toString());
                checkInDate = getDateFromCalendar(checkInDateDatePicker);
                checkOutDate = getDateFromCalendar(checkOutDateDatePicker);

                Bundle bundle = new Bundle();
                bundle.putString("check-in date", checkInDate);
                bundle.putString("check-out date", checkOutDate);
                bundle.putInt("number of rooms", numberOfRooms);
                bundle.putInt("number of guests", numberOfGuests);
                bundle.putString("customer name", customerName);
                bundle.putString("customer email", customerEmail);

                HotelSelectFragment hotelSelectFragment = new HotelSelectFragment();
                hotelSelectFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_constraint_layout, hotelSelectFragment);
                fragmentTransaction.remove(ReservationDetailsFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    }

    private String getDateFromCalendar(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("yyyy-MM-dd"));

        return simpleDateFormat.format(calendar.getTime());
    }
}
