package com.example.myapplication.dto;

public class Phim {
    private String code;
    private String name;

    private String genre;
    private String shortDescription;
    private int pic;

    public Phim(String code, String name, String genre, String shortDescription, int pic) {
        this.code = code;
        this.name = name;
        this.genre = genre;
        this.shortDescription = shortDescription;
        this.pic = pic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
