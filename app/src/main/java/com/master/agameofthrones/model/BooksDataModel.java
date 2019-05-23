package com.master.agameofthrones.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BooksDataModel {

    @Expose
    @SerializedName("released")
    private String released = "";
    @Expose
    @SerializedName("mediaType")
    private String mediaType = "";
    @Expose
    @SerializedName("country")
    private String country = "";
    @Expose
    @SerializedName("publisher")
    private String publisher = "";
    @Expose
    @SerializedName("numberOfPages")
    private int numberOfPages = 0;
    @Expose
    @SerializedName("authors")
    private List<String> authors = new ArrayList<>();

    @Expose
    @SerializedName("characters")
    public List<String> characters = new ArrayList<>();

    @Expose
    @SerializedName("isbn")
    private String isbn = "";
    @Expose
    @SerializedName("name")
    private String name = "";
    @Expose
    @SerializedName("url")
    private String url = "";

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
