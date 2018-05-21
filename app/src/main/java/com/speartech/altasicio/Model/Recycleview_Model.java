package com.speartech.altasicio.Model;

public class Recycleview_Model {

    String name;
    int id_;
    int image;


    public Recycleview_Model() {
    }

    public Recycleview_Model(String name, int id_, int image) {
        this.name = name;
        this.id_ = id_;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }

}