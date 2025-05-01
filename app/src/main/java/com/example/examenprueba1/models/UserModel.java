package com.example.examenprueba1.models;

public class UserModel {

    public class Name {
        private String title;
        private String first;
        private String last;
    }
    public class Street {
        private Integer number;
        private String name;
    }

    public class Location {
        private Street street;
        private String city;
        private  String state;
        private String country;
        private Integer postcode;
    }

    public class Picture {
        private String large;
        private String medium;
        private String thumbnail;
    }
    public String gender;
    public Name name;
    public Location location;
    public String email;

    public Picture picture;
    public String phone;

    public String cell;
    //Getters y setters

}
