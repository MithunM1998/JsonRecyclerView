package com.example.jsonrecyclerview;

public class Movie {
    private String movieTitle;
    private String movieYear;
    private String movieRated;
    private String movieReleased;
    private String movieRuntime;
    private String movieGenre;
    private String movieDirector;
    private String movieWriter;
    private String movieActors;
    private String imgUrl;

    public Movie() {
    }

    public Movie(String movieTitle, String movieYear, String movieRated, String movieReleased, String movieRuntime, String movieGenre, String movieDirector, String movieWriter, String movieActors,String imgUrl) {
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieRated = movieRated;
        this.movieReleased = movieReleased;
        this.movieRuntime = movieRuntime;
        this.movieGenre = movieGenre;
        this.movieDirector = movieDirector;
        this.movieWriter = movieWriter;
        this.movieActors = movieActors;
        this.imgUrl=imgUrl;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieRated() {
        return movieRated;
    }

    public void setMovieRated(String movieRated) {
        this.movieRated = movieRated;
    }

    public String getMovieReleased() {
        return movieReleased;
    }

    public void setMovieReleased(String movieReleased) {
        this.movieReleased = movieReleased;
    }

    public String getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(String movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieWriter() {
        return movieWriter;
    }

    public void setMovieWriter(String movieWriter) {
        this.movieWriter = movieWriter;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
