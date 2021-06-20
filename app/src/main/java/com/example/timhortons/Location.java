package com.example.timhortons;

import android.widget.ImageView;

public class Location {
        private  String image;
        private String Loc;
        private  String Name;


    public Location() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public Location(String Loc, String image, String Name) {
        this.Loc = Loc;
        this.image=image;
        this.Name=Name;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        this.Loc = Loc;
    }

}


