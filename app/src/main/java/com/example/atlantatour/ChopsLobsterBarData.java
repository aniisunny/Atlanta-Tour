package com.example.atlantatour;

public class ChopsLobsterBarData {

    private int imageResourceId;
    private String name;
    private String address;
    private String celebrityName;
    private String about;

    public ChopsLobsterBarData(int imageResourceId, String name, String address,
                               String celebrityName, String about) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.address = address;
        this.celebrityName = celebrityName;
        this.about = about;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public String getAbout() {
        return about;
    }
}
