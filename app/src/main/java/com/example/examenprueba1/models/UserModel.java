package com.example.examenprueba1.models;

import java.util.List;

public class UserModel {

    public static class Name {
        private String title;
        private String first;
        private String last;

        public String getTitle() { return title; }
        public String getFirst() { return first; }
        public String getLast() { return last; }
    }

    public static class Street {
        private Integer number;
        private String name;

        public Integer getNumber() { return number; }
        public String getName() { return name; }

        public String str()
        {
            return getName() + " " + getNumber();
        }
    }

    public static class Coordinates {
        private String latitude;
        private String longitude;
    }

    public static class Timezone {
        private String offset;
        private String description;
    }

    public static class Location {
        private Street street;
        private String city;
        private String state;
        private String country;
        private String postcode;
        private Coordinates coordinates;
        private Timezone timezone;

        public Street getStreet() { return street; }
        public String getCity() { return city; }
        public String getState() { return state; }
        public String getCountry() { return country; }
        public String getPostcode() { return postcode; }
        public Coordinates getCoordinates() { return coordinates; }
        public Timezone getTimezone() { return timezone; }
    }

    public static class Picture {
        public String getLarge() {
            return large;
        }

        public String getMedium() {
            return medium;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        private String large;
        private String medium;
        private String thumbnail;

    }

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Picture picture;
    private String phone;
    private String cell;

    public String getGender() { return gender; }
    public Name getName() { return name; }
    public Location getLocation() { return location; }
    public String getEmail() { return email; }
    public Picture getPicture() { return picture; }
    public String getPhone() { return phone; }
    public String getCell() { return cell; }

    public String getNameStr() {
        if (name != null) {
            return name.getTitle() + " " + name.getFirst() + " " + name.getLast();
        } else {
            return "";
        }
    }


}