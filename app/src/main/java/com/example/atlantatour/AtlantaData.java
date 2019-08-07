package com.example.atlantatour;

public class AtlantaData {

    private int imageResourceId;
    private String heading;
    private String description;

    public AtlantaData(int imageResourceId, String heading, String description) {
        this.imageResourceId = imageResourceId;
        this.description = description;
        this.heading = heading;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }
}
