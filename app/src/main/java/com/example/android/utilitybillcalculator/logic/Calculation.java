package com.example.android.utilitybillcalculator.logic;

import android.app.Application;

import com.example.android.utilitybillcalculator.database.DatabaseHelper;
import com.example.android.utilitybillcalculator.entities.ElectricBill;
import com.example.android.utilitybillcalculator.entities.WaterBill;

public class Calculation extends Application {

    private DatabaseHelper dbHelper;

    public Calculation(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public double calculate(String type, String name, double amountToCalculate) {

        Double result = 0.0;
        if (type.equals("Electric")) {

            ElectricBill electricBill = dbHelper.getElectricBill(name);
            Double firstBracket = electricBill.getPriceBracketOne();
            Double secondBracket = electricBill.getPriceBracketTwo();
            Double thirdBracket = electricBill.getPriceBracketThree();
            Double fourthBracket = electricBill.getPriceBracketFour();
            Double fifthBracket = electricBill.getPriceBracketFive();
            Double sixthBracket = electricBill.getPriceBracketSix();
            Double seventhBracket = electricBill.getPriceBracketSeven();
            Double eightBracket = electricBill.getPriceBracketEight();
            Double ninthBracket = electricBill.getPriceBracketNine();
            Double tenthBracket = electricBill.getPriceBracketTen();
            Double eleventhBracket = electricBill.getPriceBracketEleven();
            Double tax = 0.0;

            if (name.equals("Tenaga Nasional")) {
                if (amountToCalculate < 1) {
                    result = firstBracket;
                } else if (amountToCalculate > 1 && amountToCalculate < 201) {
                    result += (amountToCalculate * secondBracket) / 100;
                    if (result <= firstBracket) {
                        result = firstBracket;
                    }
                } else if (amountToCalculate > 200 && amountToCalculate < 301) {
                    amountToCalculate -= 200;
                    result += ((amountToCalculate * thirdBracket) + (200 * secondBracket)) / 100;
                } else if (amountToCalculate > 300 && amountToCalculate < 601) {
                    amountToCalculate -= 300;
                    result += ((amountToCalculate * fourthBracket) + (100 * thirdBracket) + (200 * secondBracket)) / 100;
                } else if (amountToCalculate > 600 && amountToCalculate < 901) {
                    amountToCalculate -= 600;
                    tax += (amountToCalculate * fifthBracket / 100) * 6 / 100;
                    result += (((amountToCalculate * fifthBracket) + (100 * thirdBracket) + (200 * secondBracket) + (300 * fourthBracket)) / 100) + tax;
                } else if (amountToCalculate > 900) {
                    amountToCalculate -= 900;
                    tax += ((amountToCalculate * sixthBracket / 100) + (300 * fifthBracket / 100)) * 6 / 100;
                    result += (((amountToCalculate * sixthBracket) + (100 * thirdBracket) + (200 * secondBracket) + (300 * fourthBracket) + (300 * fifthBracket)) / 100) + tax;
                }
            } else if (name.equals("Sarawak Energy")) {
                if (amountToCalculate < 0) {
                    result += firstBracket;
                } else if (amountToCalculate > 0 && amountToCalculate < 100) {
                    result += (amountToCalculate * secondBracket) / 100;
                    if (result <= firstBracket) {
                        result = firstBracket;
                    }
                } else if (amountToCalculate > 100 && amountToCalculate < 151) {
                    result += (amountToCalculate * thirdBracket) / 100;
                    if (result <= firstBracket) {
                        result = firstBracket;
                    }
                } else if (amountToCalculate > 150 && amountToCalculate < 201) {
                    result += (amountToCalculate * fourthBracket) / 100;
                } else if (amountToCalculate > 200 && amountToCalculate < 301) {
                    result += (amountToCalculate * fifthBracket) / 100;
                } else if (amountToCalculate > 300 && amountToCalculate < 401) {
                    result += (amountToCalculate * sixthBracket) / 100;
                } else if (amountToCalculate > 400 && amountToCalculate < 501) {
                    result += (amountToCalculate * seventhBracket) / 100;
                } else if (amountToCalculate > 500 && amountToCalculate < 701) {
                    if (amountToCalculate > 600) {
                        double amountToCalculateHelper = amountToCalculate - 600;
                        tax += (amountToCalculateHelper * eightBracket) / 100 * 6 / 100;
                    }
                    result += ((amountToCalculate * eightBracket) / 100) + tax;
                } else if (amountToCalculate > 700 && amountToCalculate < 801) {
                    double amountToCalculateHelper = amountToCalculate - 600;
                    tax += (amountToCalculateHelper * ninthBracket) / 100 * 6 / 100;
                    result += ((amountToCalculate * ninthBracket) / 100) + tax;
                } else if (amountToCalculate > 800 && amountToCalculate < 1301) {
                    double amountToCalculateHelper = amountToCalculate - 600;
                    tax += (amountToCalculateHelper * tenthBracket) / 100 * 6 / 100;
                    result += ((amountToCalculate * tenthBracket) / 100) + tax;
                } else if (amountToCalculate > 1300) {
                    double amountToCalculateHelper = amountToCalculate - 600;
                    tax += (amountToCalculateHelper * eleventhBracket) / 100 * 6 / 100;
                    result += ((amountToCalculate * eleventhBracket) / 100) + tax;
                }
            } else if (name.equals("Sabah Electricity")) {
                if (amountToCalculate < 1) {
                    result = firstBracket;
                } else if (amountToCalculate > 1 && amountToCalculate < 101) {
                    result += (amountToCalculate * secondBracket) / 100;
                    if (result <= firstBracket) {
                        result = firstBracket;
                    }
                } else if (amountToCalculate > 100 && amountToCalculate < 201) {
                    amountToCalculate -= 100;
                    result += ((amountToCalculate * thirdBracket) + (100 * secondBracket)) / 100;
                } else if (amountToCalculate > 200 && amountToCalculate < 301) {
                    amountToCalculate -= 200;
                    result += ((amountToCalculate * fourthBracket) + (100 * secondBracket) + (100 * thirdBracket)) / 100;
                } else if (amountToCalculate > 300 && amountToCalculate < 501) {
                    amountToCalculate -= 300;
                    result += ((amountToCalculate * fifthBracket) + (100 * secondBracket) + (100 * thirdBracket) + (100 * fourthBracket)) / 100;
                } else if (amountToCalculate > 500 && amountToCalculate < 1001) {
                    if (amountToCalculate > 600) {
                        Double taxHelper = amountToCalculate - 600;
                        tax += (taxHelper * sixthBracket) / 100 * 6 / 100;
                    }
                    amountToCalculate -= 500;
                    result += (((amountToCalculate * sixthBracket) + (100 * secondBracket) + (100 * thirdBracket) + (100 * fourthBracket) + (200 * fifthBracket)) / 100) + tax;
                } else if (amountToCalculate > 1000) {
                    Double firstTax = (400 * sixthBracket) / 100 * 6 / 100;
                    Double taxHelper2 = amountToCalculate - 1000;
                    tax += ((taxHelper2 * seventhBracket) / 100 * 6 / 100) + firstTax;
                    amountToCalculate -= 1000;
                    result += (((amountToCalculate * seventhBracket) + (100 * secondBracket) + (100 * thirdBracket) + (100 * fourthBracket) + (200 * fifthBracket) + (500 * sixthBracket)) / 100) + tax;
                }
            }
        } else if (type.equals("Water")) {

            WaterBill waterBill = dbHelper.getWaterBill(name);
            Double firstBracket = waterBill.getPriceBracketOne();
            Double secondBracket = waterBill.getPriceBracketTwo();
            Double thirdBracket = waterBill.getPriceBracketThree();
            Double fourthBracket = waterBill.getPriceBracketFour();
            Double fifthBracket = waterBill.getPriceBracketFive();
            Double sixthBracket = waterBill.getPriceBracketSix();
            Double seventhBracket = waterBill.getPriceBracketSeven();
            Double balance = 0.0;
            Double surcharge = 0.0;

            if (name.equals("Johor")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Kedah")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Kelantan")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Melaka")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Negeri Sembilan")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Pahang")) {
                if (amountToCalculate > 0 && amountToCalculate <= 18) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 18 && amountToCalculate <= 45) {
                    amountToCalculate -= 18;
                    result += ((amountToCalculate * thirdBracket) + (18 * secondBracket));
                } else if (amountToCalculate > 45) {
                    amountToCalculate -= 45;
                    result += ((amountToCalculate * fourthBracket) + (18 * secondBracket) + (27 * thirdBracket));
                }

            } else if (name.equals("Penang")) {

                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 40) {
                    if (amountToCalculate > 35) {
                        balance = amountToCalculate - 35;
                        surcharge = balance * seventhBracket;
                    }
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket) + surcharge);
                } else if (amountToCalculate > 40 && amountToCalculate <= 60) {
                    balance = amountToCalculate;
                    balance -= 35;
                    surcharge = balance * seventhBracket;
                    amountToCalculate -= 40;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (20 * thirdBracket) + surcharge);
                } else if (amountToCalculate > 60 && amountToCalculate <= 200) {
                    balance = amountToCalculate;
                    balance -= 35;
                    surcharge = balance * seventhBracket;
                    amountToCalculate -= 60;
                    result += ((amountToCalculate * fifthBracket) + (20 * secondBracket) + (20 * thirdBracket) + (20 * fourthBracket) + surcharge);
                } else if (amountToCalculate > 200) {
                    balance = amountToCalculate;
                    balance -= 35;
                    surcharge = balance * seventhBracket;
                    amountToCalculate -= 200;
                    result += ((amountToCalculate * sixthBracket) + (20 * secondBracket) + (20 * thirdBracket) + (20 * fourthBracket) + (140 * fifthBracket) + surcharge);
                }

            } else if (name.equals("Perak")) {
                if (amountToCalculate > 0 && amountToCalculate <= 10) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 10 && amountToCalculate <= 20) {
                    amountToCalculate -= 10;
                    result += ((amountToCalculate * thirdBracket) + (10 * secondBracket));
                } else if (amountToCalculate > 20) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * fourthBracket) + (10 * secondBracket) + (10 * thirdBracket));
                }

            } else if (name.equals("Perlis")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 15 && amountToCalculate <= 40) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * thirdBracket) + (15 * secondBracket));
                } else if (amountToCalculate > 40) {
                    amountToCalculate -= 40;
                    result += ((amountToCalculate * fourthBracket) + (15 * secondBracket) + (25 * thirdBracket));
                }

            } else if (name.equals("Selangor")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Terengganu")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 40) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 40 && amountToCalculate <= 60) {
                    amountToCalculate -= 40;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (20 * thirdBracket));
                } else if (amountToCalculate > 60) {
                    amountToCalculate -= 60;
                    result += ((amountToCalculate * fifthBracket) + (20 * secondBracket) + (20 * thirdBracket) + (20 * fourthBracket));
                }

            } else if (name.equals("Labuan")) {
                if (amountToCalculate > 0 && amountToCalculate <= 20) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * thirdBracket) + (20 * secondBracket));
                } else if (amountToCalculate > 35) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fourthBracket) + (20 * secondBracket) + (15 * thirdBracket));
                }

            } else if (name.equals("Kuching")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * thirdBracket) + (15 * secondBracket));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * fourthBracket) + (15 * secondBracket) + (35 * thirdBracket));
                }

            } else if (name.equals("Sibu")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * thirdBracket) + (15 * secondBracket));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * fourthBracket) + (15 * secondBracket) + (35 * thirdBracket));
                }

            } else if (name.equals("Sri Aman")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * thirdBracket) + (15 * secondBracket));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * fourthBracket) + (15 * secondBracket) + (35 * thirdBracket));
                }

            } else if (name.equals("Bintulu")) {
                if (amountToCalculate > 0 && amountToCalculate <= 14) {
                    result = firstBracket;
                } else if (amountToCalculate > 14 && amountToCalculate <= 45) {
                    amountToCalculate -= 14;
                    result += ((amountToCalculate * thirdBracket) + firstBracket);
                } else if (amountToCalculate > 45) {
                    amountToCalculate -= 45;
                    result += ((amountToCalculate * fourthBracket) + firstBracket + (31 * thirdBracket));
                }

            } else if (name.equals("Sarawak")) {
                if (amountToCalculate > 0 && amountToCalculate <= 15) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 15 && amountToCalculate <= 50) {
                    amountToCalculate -= 15;
                    result += ((amountToCalculate * thirdBracket) + (15 * secondBracket));
                } else if (amountToCalculate > 50) {
                    amountToCalculate -= 50;
                    result += ((amountToCalculate * fourthBracket) + (15 * secondBracket) + (35 * thirdBracket));
                }

            } else if (name.equals("Sabah")) {
                if (amountToCalculate > 0 && amountToCalculate <= 10) {
                    result += (amountToCalculate * secondBracket);
                } else if (amountToCalculate > 10 && amountToCalculate <= 20) {
                    amountToCalculate -= 10;
                    result += ((amountToCalculate * thirdBracket) + (10 * secondBracket));
                } else if (amountToCalculate > 20 && amountToCalculate <= 35) {
                    amountToCalculate -= 20;
                    result += ((amountToCalculate * fourthBracket) + (10 * secondBracket) + (10 * thirdBracket));
                } else if (amountToCalculate > 35 && amountToCalculate <= 60) {
                    amountToCalculate -= 35;
                    result += ((amountToCalculate * fifthBracket) + (10 * secondBracket) + (10 * thirdBracket) + (15 * fourthBracket));
                } else if (amountToCalculate > 60) {
                    amountToCalculate -= 60;
                    result += ((amountToCalculate * sixthBracket) + (10 * secondBracket) + (10 * thirdBracket) + (15 * fourthBracket) + (25 * fifthBracket));
                }
            }
        }


        return result;
    }
}
