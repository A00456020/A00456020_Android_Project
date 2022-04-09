package com.example.a00456020_android_project;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GuestDetailsAdapter extends RecyclerView.Adapter<GuestDetailsAdapter.ViewHolder>{

//    private List<ReservationModel.GuestDetails> guestDetails;
    private int numberOfGuests;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    GuestDetailsAdapter(Context context, int numberOfGuests) {
        this.layoutInflater = LayoutInflater.from(context);
        this.numberOfGuests = numberOfGuests;
    }
    @NonNull
    @Override
    public GuestDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_details_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestDetailsAdapter.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
//        holder.guestName.setTag(position);
//        holder.guestGender.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (numberOfGuests > 0) {
            return numberOfGuests;
        } else {
            return 1;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            guestName = itemView.findViewById(R.id.guest_name_edit_text);
//            guestGender = itemView.findViewById(R.id.guest_gender_edit_text);
//            guestName.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    int position = (int)guestName.getTag();
//                    guestNames.set(position, s.toString());
//                }
//            });
//            guestGender.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    int position = (int)guestGender.getTag();
//                    guestgenders.set(position, s.toString());
//                }
//            });

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view, getAbsoluteAdapterPosition());
        }
    }

}
