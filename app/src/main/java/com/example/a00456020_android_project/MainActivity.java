package com.example.a00456020_android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Begin the transaction
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //Replace the contents of the container with new fragment
        fragmentTransaction.replace(R.id.main_frame_layout, new ReservationDetailsFragment());

        //Complete the changes added above
        fragmentTransaction.commit();
    }
}