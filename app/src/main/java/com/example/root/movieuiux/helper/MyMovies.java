package com.example.root.movieuiux.helper;public class MyMovies {    private String title;    private String release;    private String overview;    private String poster;    private String backdrop;    private String rate;    private String rate_avg;    private String popularity;    public MyMovies(){    }    public MyMovies(String title, String release, String overview, String poster, String backdrop, String rate, String rate_avg, String popularity) {        this.title = title;        this.release = release;        this.overview = overview;        this.poster = poster;        this.backdrop = backdrop;        this.rate = rate;        this.rate_avg = rate_avg;        this.popularity = popularity;    }    public String getPopularity() {        return popularity;    }    public void setPopularity(String popularity) {        this.popularity = popularity;    }    public String getTitle() {        return title;    }    public void setTitle(String title) {        this.title = title;    }    public String getRelease() {        return release;    }    public void setRelease(String release) {        this.release = release;    }    public String getOverview() {        return overview;    }    public void setOverview(String overview) {        this.overview = overview;    }    public String getPoster() {        return poster;    }    public void setPoster(String poster) {        this.poster = poster;    }    public String getBackdrop() {        return backdrop;    }    public void setBackdrop(String backdrop) {        this.backdrop = backdrop;    }    public String getRate() {        return rate;    }    public void setRate(String rate) {        this.rate = rate;    }    public String getRate_avg() {        return rate_avg;    }    public void setRate_avg(String rate_avg) {        this.rate_avg = rate_avg;    }}