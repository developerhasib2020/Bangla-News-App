package com.example.hasibsnews;

public class Model {
    int image;
    String newsname;
    float rating;
    String url;

    public Model(int image, String newsname, float rating, String url) {
        this.image = image;
        this.newsname = newsname;
        this.rating = rating;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
