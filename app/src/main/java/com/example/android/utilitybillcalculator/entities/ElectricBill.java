package com.example.android.utilitybillcalculator.entities;

public class ElectricBill {

    private int id;
    private String billName;
    private double priceBracketOne;
    private double priceBracketTwo;
    private double priceBracketThree;
    private double priceBracketFour;
    private double priceBracketFive;
    private double priceBracketSix;
    private double priceBracketSeven;
    private double priceBracketEight;
    private double priceBracketNine;
    private double priceBracketTen;
    private double priceBracketEleven;

    public ElectricBill () {

    }

    public ElectricBill(int id, String billName, double priceBracketOne, double priceBracketTwo,
                        double priceBracketThree, double priceBracketFour, double priceBracketFive,
                        double priceBracketSix, double priceBracketSeven, double priceBracketEight,
                        double priceBracketNine, double priceBracketTen, double priceBracketEleven) {
        this.id = id;
        this.billName = billName;
        this.priceBracketOne = priceBracketOne;
        this.priceBracketTwo = priceBracketTwo;
        this.priceBracketThree = priceBracketThree;
        this.priceBracketFour = priceBracketFour;
        this.priceBracketFive = priceBracketFive;
        this.priceBracketSix = priceBracketSix;
        this.priceBracketSeven = priceBracketSeven;
        this.priceBracketEight = priceBracketEight;
        this.priceBracketNine = priceBracketNine;
        this.priceBracketTen = priceBracketTen;
        this.priceBracketEleven = priceBracketEleven;
    }

    public ElectricBill(String billName, double priceBracketOne, double priceBracketTwo,
                        double priceBracketThree, double priceBracketFour, double priceBracketFive,
                        double priceBracketSix, double priceBracketSeven, double priceBracketEight,
                        double priceBracketNine, double priceBracketTen, double priceBracketEleven) {
        this.billName = billName;
        this.priceBracketOne = priceBracketOne;
        this.priceBracketTwo = priceBracketTwo;
        this.priceBracketThree = priceBracketThree;
        this.priceBracketFour = priceBracketFour;
        this.priceBracketFive = priceBracketFive;
        this.priceBracketSix = priceBracketSix;
        this.priceBracketSeven = priceBracketSeven;
        this.priceBracketEight = priceBracketEight;
        this.priceBracketNine = priceBracketNine;
        this.priceBracketTen = priceBracketTen;
        this.priceBracketEleven = priceBracketEleven;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public double getPriceBracketOne() {
        return priceBracketOne;
    }

    public void setPriceBracketOne(double priceBracketOne) {
        this.priceBracketOne = priceBracketOne;
    }

    public double getPriceBracketTwo() {
        return priceBracketTwo;
    }

    public void setPriceBracketTwo(double priceBracketTwo) {
        this.priceBracketTwo = priceBracketTwo;
    }

    public double getPriceBracketThree() {
        return priceBracketThree;
    }

    public void setPriceBracketThree(double priceBracketThree) {
        this.priceBracketThree = priceBracketThree;
    }

    public double getPriceBracketFour() {
        return priceBracketFour;
    }

    public void setPriceBracketFour(double priceBracketFour) {
        this.priceBracketFour = priceBracketFour;
    }

    public double getPriceBracketFive() {
        return priceBracketFive;
    }

    public void setPriceBracketFive(double priceBracketFive) {
        this.priceBracketFive = priceBracketFive;
    }

    public double getPriceBracketSix() {
        return priceBracketSix;
    }

    public void setPriceBracketSix(double priceBracketSix) {
        this.priceBracketSix = priceBracketSix;
    }

    public double getPriceBracketSeven() {
        return priceBracketSeven;
    }

    public void setPriceBracketSeven(double priceBracketSeven) {
        this.priceBracketSeven = priceBracketSeven;
    }

    public double getPriceBracketEight() {
        return priceBracketEight;
    }

    public void setPriceBracketEight(double priceBracketEight) {
        this.priceBracketEight = priceBracketEight;
    }

    public double getPriceBracketNine() {
        return priceBracketNine;
    }

    public void setPriceBracketNine(double priceBracketNine) {
        this.priceBracketNine = priceBracketNine;
    }

    public double getPriceBracketTen() {
        return priceBracketTen;
    }

    public void setPriceBracketTen(double priceBracketTen) {
        this.priceBracketTen = priceBracketTen;
    }

    public double getPriceBracketEleven() {
        return priceBracketEleven;
    }

    public void setPriceBracketEleven(double priceBracketEleven) {
        this.priceBracketEleven = priceBracketEleven;
    }
}
