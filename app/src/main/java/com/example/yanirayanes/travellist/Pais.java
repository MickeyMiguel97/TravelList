package com.example.yanirayanes.travellist;

/**
 * Created by Yanira Yanes on 25/04/2018.
 */

public class Pais {
    private String name;
    private int img;
    private String desc;
    private boolean travelapp;

    public Pais(String name, int img, String desc){
        this.name = name;
        this.img = img;
        this.desc = desc;
        travelapp = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void set(boolean travelapp){
        this.travelapp = travelapp;
    }

    public boolean yesorno(){
        return travelapp;
    }
}
