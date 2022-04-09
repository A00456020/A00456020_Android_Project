package com.example.a00456020_android_project;

import java.util.ArrayList;

public class ReservationModel {
    /*  {
        "id": 1,
        "hotel_id": 2,
        "customer_id": 4,
        "hotel_name": "rajkot inn",
        "customer_name": "Parth",
        "customer_phone": "9021425367",
        "hotel_website": "rajkotinn.com",
        "number_of_rooms": 1,
        "checkin_date": "2022-04-10",
        "checkout_date": "2022-04-17",
        "guest_details": [
            {
                "name": "Parth",
                "gender": "male",
                "mobile": "1234567890",
                "email": "prefer not to give"
            }
        ]
    }  */

    String id;
    String hotel_id;
    String customer_id;
    String hotel_name;
    String customer_name;
    String customer_phone;
    String hotel_website;
    String number_of_rooms;
    String checkin_date;
    String checkout_date;
    ArrayList<GuestDetails> guest_details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getHotel_website() {
        return hotel_website;
    }

    public void setHotel_website(String hotel_website) {
        this.hotel_website = hotel_website;
    }

    public String getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(String number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public String getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(String checkin_date) {
        this.checkin_date = checkin_date;
    }

    public String getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(String checkout_date) {
        this.checkout_date = checkout_date;
    }

    public ArrayList<GuestDetails> getGuest_details() {
        return guest_details;
    }

    public void setGuest_details(ArrayList<GuestDetails> guest_details) {
        this.guest_details = guest_details;
    }

    public class GuestDetails{
        String name;
        String gender;
        String email;
        String mobile;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
