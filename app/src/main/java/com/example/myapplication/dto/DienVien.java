package com.example.myapplication.dto;

public class DienVien {
    private String name;

    private String gender;
    private String bird;

    private int pic;

    public DienVien(String name, String gender, String bird, int pic) {
        this.name = name;
        this.gender = gender;
        this.bird = bird;
        this.pic = pic;
    }

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

    public String getBird() {
        return bird;
    }

    public void setBird(String bird) {
        this.bird = bird;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
