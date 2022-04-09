package com.example.a00456020_android_project;

public class HotelModel {
    /*

    {
        "id": 1,
        "name": "ahmedabad inn",
        "country": "India",
        "website": "ahmedabadinn.com",
        "city": "Ahmedabad",
        "price": 250.0,
        "availability": true
    }
     */
    String id;
    String name;
    String country;
    String website;
    String city;
    String price;
    String availability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
