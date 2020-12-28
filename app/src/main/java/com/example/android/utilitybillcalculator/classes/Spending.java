package com.example.android.utilitybillcalculator.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Spending {

    private Integer ID;
    private String name;
    private String type;
    private String date;
    private Double toCalculate;
    private Double cost;

    //Four constructors in case of requiring null value
    public Spending(Double toCalculate, String type, String name) {
        this.name = name;
        this.type = type;
        this.date = setDate();
        this.toCalculate = toCalculate;
        this.cost = setCalculatedCost(toCalculate, type, name);
    }

    public Spending(String type, String name, Double cost, String date) {
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.date = date;
    }

    public Spending(String type, String name, Double cost) {
        this.name = name;
        this.type = type;
        this.date = setDate();
        this.cost = cost;
        this.toCalculate = null;
    }

    public Spending(String type, String name, String date, Double cost) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.cost = cost;
        this.toCalculate = null;
    }


    //Getter methods
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public Double getToCalculate() {
        return this.toCalculate;
    }

    public Double getCost() {
        return cost;
    }

    //Calculation logic according to each provider
    private Double setCalculatedCost(Double amountToCalculate, String type, String name) {
        Double result = 0.0;
        if (type.equals("Electric")) {
            Double tax = 0.0;
            if (name.equals("Tenaga Nasional")) {
                if (amountToCalculate < 1) {
                    result = 300.0 / 100.0;
                } else if (amountToCalculate > 1 && amountToCalculate < 201) {
                    result += (amountToCalculate * 21.80) / 100;
                    if (result <= 3.00) {
                        result = 3.00;
                    }
                } else if (amountToCalculate > 200 && amountToCalculate < 301) {
                    amountToCalculate -= 200;
                    result += ((amountToCalculate * 33.40) + (200 * 21.80)) / 100;
                } else if (amountToCalculate > 300 && amountToCalculate < 601) {
                    amountToCalculate -= 300;
                    result += ((amountToCalculate * 51.60) + (100 * 33.40) + (200 * 21.80)) / 100;
                } else if (amountToCalculate > 600 && amountToCalculate < 901) {
                    amountToCalculate -= 600;
                    tax += (amountToCalculate * 54.60 / 100) * 6 / 100;
                    result += (((amountToCalculate * 54.60) + (100 * 33.40) + (200 * 21.80) + (300 * 51.60)) / 100) + tax;
                } else if (amountToCalculate > 900) {
                    amountToCalculate -= 900;
                    tax += ((amountToCalculate * 57.10 / 100) + (300 * 54.60 / 100)) * 6 / 100;
                    result += (((amountToCalculate * 57.10) + (100 * 33.40) + (200 * 21.80) + (300 * 51.60) + (300 * 54.60)) / 100) + tax;
                }
            } else if (name.equals("Sarawak Energy")) {
                if (amountToCalculate < 0) {
                    result += 500.0 / 100.0;
                } else if (amountToCalculate > 0 && amountToCalculate < 151) {
                    result += (amountToCalculate * 18) / 100;
                    if (result <= 5.00) {
                        result = 5.00;
                    }
                } else if (amountToCalculate > 150 && amountToCalculate < 201) {
                    result += (amountToCalculate * 22) / 100;
                } else if (amountToCalculate > 200 && amountToCalculate < 301) {
                    result += (amountToCalculate * 25) / 100;
                } else if (amountToCalculate > 300 && amountToCalculate < 401) {
                    result += (amountToCalculate * 27) / 100;
                } else if (amountToCalculate > 400 && amountToCalculate < 501) {
                    result += (amountToCalculate * 29.5) / 100;
                } else if (amountToCalculate > 500 && amountToCalculate < 701) {
                    if (amountToCalculate > 600) {
                        double amountToCalculateHelper = amountToCalculate - 600;
                        tax += (amountToCalculateHelper * 30) / 100 * 6 / 100;
                    }
                    result += ((amountToCalculate * 30) / 100) + tax;
                } else if (amountToCalculate > 700 && amountToCalculate < 801) {
                    double amountToCalculateHelper = amountToCalculate - 600;
                    tax += (amountToCalculateHelper * 30.5) / 100 * 6 / 100;
                    result += ((amountToCalculate * 30.5) / 100) + tax;
                } else if (amountToCalculate > 800 && amountToCalculate < 1301) {
                    double amountToCalculateHelper = amountToCalculate - 600;
                    tax += (amountToCalculateHelper * 31) / 100 * 6 / 100;
                    result += ((amountToCalculate * 31) / 100) + tax;
                } else if (amountToCalculate > 1300) {
                    double amountToCalculateHelper = amountToCalculate - 600;
                    tax += (amountToCalculateHelper * 31) / 100 * 6 / 100;
                    result += ((amountToCalculate * 31.5) / 100) + tax;
                }
            } else if (name.equals("Sabah Electric")) {
                if (amountToCalculate < 1) {
                    result = 500.0 / 100.0;
                } else if (amountToCalculate > 1 && amountToCalculate < 101) {
                    result += (amountToCalculate * 17.5) / 100;
                    if (result <= 5.00) {
                        result = 5.00;
                    }
                } else if (amountToCalculate > 100 && amountToCalculate < 201) {
                    amountToCalculate -= 100;
                    result += ((amountToCalculate * 18.5) + (100 * 17.5)) / 100;
                } else if (amountToCalculate > 200 && amountToCalculate < 301) {
                    amountToCalculate -= 200;
                    result += ((amountToCalculate * 33.0) + (100 * 17.5) + (100 * 18.5)) / 100;
                } else if (amountToCalculate > 300 && amountToCalculate < 501) {
                    amountToCalculate -= 300;
                    result += ((amountToCalculate * 44.5) + (100 * 17.5) + (100 * 18.5) + (100 * 33.0)) / 100;
                } else if (amountToCalculate > 500 && amountToCalculate < 1001) {
                    if (amountToCalculate > 600) {
                        Double taxHelper = amountToCalculate - 600;
                        tax += (taxHelper * 45.0) / 100 * 6 / 100;
                    }
                    amountToCalculate -= 500;
                    result += (((amountToCalculate * 45.0) + (100 * 17.5) + (100 * 18.5) + (100 * 33.0) + (200 * 44.50)) / 100) + tax;
                } else if (amountToCalculate > 1000) {
                    Double firstTax = (400 * 45.0) / 100 * 6 / 100;
                    Double taxHelper2 = amountToCalculate - 1000;
                    tax += ((taxHelper2 * 47.0) / 100 * 6 / 100) + firstTax;
                    amountToCalculate -= 1000;
                    result += (((amountToCalculate * 47.0) + (100 * 17.5) + (100 * 18.5) + (100 * 33.0) + (200 * 44.50) + (500 * 45.0)) / 100) + tax;
                }
            }
        } else if (type.equals("Water")) {
            Double balance = 0.0;
            Double surcharge = 0.0;
            if (name.equals("Johor")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.80);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 2.00) + (20 * 0.80));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 3.00) + (20 * 0.80) + (15 * 2.00));
                }

            } else if (name.equals("Kedah")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.50);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 0.90) + (20 * 0.50));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 1.30) + (20 * 0.50) + (15 * 0.90));
                }

            } else if (name.equals("Kelantan")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.45);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 0.97) + (20 * 0.45));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 1.42) + (20 * 0.45) + (15 * 0.97));
                }

            } else if (name.equals("Melaka")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.60);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 0.95) + (20 * 0.60));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 1.45) + (20 * 0.60) + (15 * 0.95));
                }

            } else if (name.equals("Negeri Sembilan")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.55);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 0.85) + (20 * 0.55));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 1.40) + (20 * 0.55) + (15 * 0.85));
                }

            } else if (name.equals("Pahang")) {
                if (amountToCalculate > 0 && amountToCalculate <= 18) {
                    result += (amountToCalculate * 0.37);
                } else if (amountToCalculate > 18 && amountToCalculate <= 45) {
                    amountToCalculate -= 18;
                    result += ((amountToCalculate * 0.79) + (18 * 0.37));
                } else if (amountToCalculate > 45) {
                    amountToCalculate -= 45;
                    result += ((amountToCalculate * 0.99) + (18 * 0.37) + (27 * 0.79));
                }

            } else if (name.equals("Penang")) {

                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.22);
                } else if (amountToCalculate > 20 && amountToCalculate <= 40) {
                    if (amountToCalculate > 35) {
                        balance = amountToCalculate - 35;
                        surcharge = balance * 0.48;
                    }
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 0.46) + (20 * 0.22) + surcharge);
                } else if (amountToCalculate > 40 && amountToCalculate <= 60) {
                    balance = amountToCalculate;
                    balance -= 35;
                    surcharge = balance * 0.48;
                    amountToCalculate -= 40;
                    result += ((amountToCalculate * 0.68) + (20 * 0.22) + (20 * 0.46) + surcharge);
                } else if (amountToCalculate > 60 && amountToCalculate <= 200) {
                    balance = amountToCalculate;
                    balance -= 35;
                    surcharge = balance * 0.48;
                    amountToCalculate -= 60;
                    result += ((amountToCalculate * 1.17) + (20 * 0.22) + (20 * 0.46) + (20 * 0.68) + surcharge);
                } else if (amountToCalculate > 200) {
                    balance = amountToCalculate;
                    balance -= 35;
                    surcharge = balance * 0.48;
                    amountToCalculate -= 200;
                    result += ((amountToCalculate * 1.30) + (20 * 0.22) + (20 * 0.46) + (20 * 0.68) + (140 * 1.17) + surcharge);
                }

            } else if (name.equals("Perak")) {
                if (amountToCalculate > 0 && amountToCalculate <= 10) {
                    result += (amountToCalculate * 0.30);
                } else if (amountToCalculate > 10 && amountToCalculate <= 20) {
                    amountToCalculate -= 10;
                    result += ((amountToCalculate * 0.70) + (10 * 0.30));
                } else if (amountToCalculate > 20) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 1.03) + (10 * 0.30) + (10 * 0.70));
                }

            } else if (name.equals("Perlis")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * 0.40);
                } else if (amountToCalculate > 15 && amountToCalculate <= 40) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * 0.70) + (15 * 0.40));
                } else if (amountToCalculate > 40) {
                    amountToCalculate -= 40;
                    result += ((amountToCalculate * 1.10) + (15 * 0.40) + (25 * 0.70));
                }

            } else if (name.equals("Selangor")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.57);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 1.03) + (20 * 0.57));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 2.00) + (20 * 0.57) + (15 * 1.03));
                }

            } else if (name.equals("Terengganu")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.42);
                } else if (amountToCalculate > 20 && amountToCalculate <= 40) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 0.65) + (20 * 0.42));
                } else if (amountToCalculate > 40 && amountToCalculate <= 60) {
                    amountToCalculate -= 40;
                    result += ((amountToCalculate * 0.90) + (20 * 0.42) + (20 * 0.65));
                } else if (amountToCalculate > 60) {
                    amountToCalculate -= 60;
                    result += ((amountToCalculate * 1.00) + (20 * 0.42) + (20 * 0.65) + (20 * 0.90));
                }

            } else if (name.equals("Labuan")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * 0.57);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 1.20) + (20 * 0.57));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 1.70) + (20 * 0.57) + (15 * 1.20));
                }

            } else if (name.equals("Kuching")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * 0.48);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * 0.72) + (15 * 0.48));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * 0.76) + (15 * 0.48) + (35 * 0.72));
                }

            } else if (name.equals("Sibu")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * 0.48);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * 0.72) + (15 * 0.48));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * 0.76) + (15 * 0.48) + (35 * 0.72));
                }

            } else if (name.equals("Miri")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * 0.48);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * 0.72) + (15 * 0.48));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * 0.76) + (15 * 0.48) + (35 * 0.72));
                }

            } else if (name.equals("Bintulu")) {
                if (amountToCalculate > 0 && amountToCalculate <= 14) {
                    result = 6.60;
                } else if (amountToCalculate > 14 && amountToCalculate <= 45) {
                    amountToCalculate -= 14;
                    result += ((amountToCalculate * 0.61) + 6.60);
                } else if (amountToCalculate > 45) {
                    amountToCalculate -= 45;
                    result += ((amountToCalculate * 0.66) + 6.60 + (31 * 0.61));
                }

            } else if (name.equals("Sarawak")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * 0.44);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * 0.65) + (15 * 0.44));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * 0.69) + (15 * 0.44) + (35 * 0.65));
                }

            } else if (name.equals("Sabah")) {
                if (amountToCalculate > 0 && amountToCalculate <= 10) {
                    result += (amountToCalculate * 0.30);
                } else if (amountToCalculate > 10 && amountToCalculate <= 20) {
                    amountToCalculate -= 10;
                    result += ((amountToCalculate * 0.60) + (10 * 0.30));
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * 1.10) + (10 * 0.30) + (10 * 0.60));
                } else if (amountToCalculate > 35 && amountToCalculate <= 60) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * 1.30) + (10 * 0.30) + (10 * 0.60) + (15 * 1.10));
                } else if (amountToCalculate > 60) {
                    amountToCalculate -= 60;
                    result += ((amountToCalculate * 1.80) + (10 * 0.30) + (10 * 0.60) + (15 * 1.10) + (25 * 1.30));
                }
            }
        }


        return result;
    }

    //Get current date
    private String setDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

}
