package com.example.a00456020_android_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private List<HotelModel> hotels;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    //Data gets passed in the constructor
    HotelAdapter(Context context, List<HotelModel> hotels) {
        this.layoutInflater = LayoutInflater.from(context);
        this.hotels = hotels;
    }
    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, int position) {
        String hotelId = hotels.get(position).getId();
        String hotelName = hotels.get(position).getName();
        String hotelPrice = hotels.get(position).getPrice();
        String hotelAvailability = hotels.get(position).getAvailability();

        // set up the text
        holder.hotelId.setText(hotelId);
        holder.hotelName.setText(hotelName);
        holder.hotelAvailability.setText(hotelAvailability);
        holder.hotelPrice.setText(hotelPrice);
    }

    @Override
    public int getItemCount() {
        if (hotels != null) {
            return hotels.size();
        } else {
            return 0;
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView hotelId, hotelName, hotelPrice, hotelAvailability;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelId = itemView.findViewById(R.id.hotel_id_text_view);
            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
            hotelPrice = itemView.findViewById(R.id.price_text_view);
            hotelAvailability = itemView.findViewById(R.id.availability_text_view);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view, getAbsoluteAdapterPosition());
        }
    }

}
