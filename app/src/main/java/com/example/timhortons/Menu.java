package com.example.timhortons;

public class Menu {
    private String Name;
    private String Image;
    private String Price;

    public Menu(){}

    public Menu(String Name, String Image, String Price) {
        this.Name = Name;
        this.Image = Image;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = Image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price = Price;
    }


}
