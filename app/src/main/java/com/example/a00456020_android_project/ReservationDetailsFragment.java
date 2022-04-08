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
import androidx.fragment.app.Fragment;

public class ReservationDetailsFragment extends Fragment {

    View view;
    EditText customer_name_edit_text;
    EditText customer_email_edit_text;
    EditText number_of_rooms_edit_text;
    EditText number_of_guests_edit_text;
    DatePicker check_in_date_date_picker;
    DatePicker check_out_date_date_picker;
    Button reservation_search_button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.reservation_details_layout, container, false);
        return view;
    }
}
