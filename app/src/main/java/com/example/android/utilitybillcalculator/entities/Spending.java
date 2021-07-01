package com.example.android.utilitybillcalculator.entities;

import com.example.android.utilitybillcalculator.logic.Calculation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Spending {

    private Integer id;
    private String name;
    private String type;
    private String date;
    private Double price;

    public Spending() {

    }

    // Add new spending object
    public Spending(String type, String name, Double price) {
        this.name = name;
        this.type = type;
        this.date = setDate();
        this.price = price;
    }

    // Constructor with date parameter
    public Spending(String type, String name, Double price, String date) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.price = price;
    }

    // No date constructor
    public Spending(Double price, String type, String name) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //Get current date
    private String setDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

}
