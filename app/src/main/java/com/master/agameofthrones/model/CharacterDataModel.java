package com.master.agameofthrones.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public  class CharacterDataModel implements Serializable {


    @Expose
    @SerializedName("playedBy")
    private List<String> playedBy=new ArrayList<>();
    @Expose
    @SerializedName("tvSeries")
    private List<String> tvSeries=new ArrayList<>();
    @Expose
    @SerializedName("spouse")
    private String spouse="";
    @Expose
    @SerializedName("mother")
    private String mother="";
    @Expose
    @SerializedName("father")
    private String father="";
    @Expose
    @SerializedName("aliases")
    private List<String> aliases=new ArrayList<>();
    @Expose
    @SerializedName("titles")
    private List<String> titles=new ArrayList<>();
    @Expose
    @SerializedName("died")
    private String died="";
    @Expose
    @SerializedName("born")
    private String born="";
    @Expose
    @SerializedName("culture")
    private String culture="";
    @Expose
    @SerializedName("gender")
    private String gender="";
    @Expose
    @SerializedName("name")
    private String name="";

    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }

    public List<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
