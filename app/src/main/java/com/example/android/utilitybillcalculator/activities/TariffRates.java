package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.android.utilitybillcalculator.R;

public class TariffRates extends AppCompatActivity {

    //Views declaration
    TextView minimumChargeCost;

    CardView cat1Card;
    CardView cat2Card;
    CardView cat3Card;
    CardView cat4Card;
    CardView cat5Card;
    CardView cat6Card;
    CardView cat7Card;
    CardView cat8Card;
    CardView cat9Card;
    CardView cat10Card;

    TextView cat1Text;
    TextView cat2Text;
    TextView cat3Text;
    TextView cat4Text;
    TextView cat5Text;
    TextView cat6Text;
    TextView cat7Text;
    TextView cat8Text;
    TextView cat9Text;
    TextView cat10Text;

    TextView cat1Rm;
    TextView cat2Rm;
    TextView cat3Rm;
    TextView cat4Rm;
    TextView cat5Rm;
    TextView cat6Rm;
    TextView cat7Rm;
    TextView cat8Rm;
    TextView cat9Rm;
    TextView cat10Rm;

    TextView cat1Cost;
    TextView cat2Cost;
    TextView cat3Cost;
    TextView cat4Cost;
    TextView cat5Cost;
    TextView cat6Cost;
    TextView cat7Cost;
    TextView cat8Cost;
    TextView cat9Cost;
    TextView cat10Cost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rates_tariff);

        //Attaching view component to layout resources
        minimumChargeCost = findViewById(R.id.minimum_charge_cost);

        cat1Card = findViewById(R.id.cat1_card);
        cat2Card = findViewById(R.id.cat2_card);
        cat3Card = findViewById(R.id.cat3_card);
        cat4Card = findViewById(R.id.cat4_card);
        cat5Card = findViewById(R.id.cat5_card);
        cat6Card = findViewById(R.id.cat6_card);
        cat7Card = findViewById(R.id.cat7_card);
        cat8Card = findViewById(R.id.cat8_card);
        cat9Card = findViewById(R.id.cat9_card);
        cat10Card = findViewById(R.id.cat10_card);

        cat1Text = findViewById(R.id.cat1_text);
        cat2Text = findViewById(R.id.cat2_text);
        cat3Text = findViewById(R.id.cat3_text);
        cat4Text = findViewById(R.id.cat4_text);
        cat5Text = findViewById(R.id.cat5_text);
        cat6Text = findViewById(R.id.cat6_text);
        cat7Text = findViewById(R.id.cat7_text);
        cat8Text = findViewById(R.id.cat8_text);
        cat9Text = findViewById(R.id.cat9_text);
        cat10Text = findViewById(R.id.cat10_text);

        cat1Rm = findViewById(R.id.cat1_rm);
        cat2Rm = findViewById(R.id.cat2_rm);
        cat3Rm = findViewById(R.id.cat3_rm);
        cat4Rm = findViewById(R.id.cat4_rm);
        cat5Rm = findViewById(R.id.cat5_rm);
        cat6Rm = findViewById(R.id.cat6_rm);
        cat7Rm = findViewById(R.id.cat7_rm);
        cat8Rm = findViewById(R.id.cat8_rm);
        cat9Rm = findViewById(R.id.cat9_rm);
        cat10Rm = findViewById(R.id.cat10_rm);

        cat1Cost = findViewById(R.id.cat1_cost);
        cat2Cost = findViewById(R.id.cat2_cost);
        cat3Cost = findViewById(R.id.cat3_cost);
        cat4Cost = findViewById(R.id.cat4_cost);
        cat5Cost = findViewById(R.id.cat5_cost);
        cat6Cost = findViewById(R.id.cat6_cost);
        cat7Cost = findViewById(R.id.cat7_cost);
        cat8Cost = findViewById(R.id.cat8_cost);
        cat9Cost = findViewById(R.id.cat9_cost);
        cat10Cost = findViewById(R.id.cat10_cost);

        //Get information on which TextView user tapped on, on previous activity
        final Intent intent = getIntent();
        final String choice = intent.getStringExtra("NAME");

        //Setting all tariff values according to each provider
        if (choice.equals("Tenaga Nasional")) {
            minimumChargeCost.setText("3.00");

            cat4Card.setVisibility(View.VISIBLE);
            cat5Card.setVisibility(View.VISIBLE);

            cat1Rm.setText("Cent : ");
            cat2Rm.setText("Cent : ");
            cat3Rm.setText("Cent : ");
            cat4Rm.setText("Cent : ");
            cat5Rm.setText("Cent : ");

            cat1Text.setText("1 - 200 kWh");
            cat1Cost.setText("21.80");
            cat2Text.setText("201 - 300 kWh");
            cat2Cost.setText("33.40");
            cat3Text.setText("301 - 600 kWh");
            cat3Cost.setText("51.60");
            cat4Text.setText("601 - 900 kWh");
            cat4Cost.setText("54.60");
            cat5Text.setText("901 kWh onwards");
            cat5Cost.setText("57.10");

        } else if (choice.equals("Sabah Electric")) {
            minimumChargeCost.setText("5.00");

            cat4Card.setVisibility(View.VISIBLE);
            cat5Card.setVisibility(View.VISIBLE);
            cat6Card.setVisibility(View.VISIBLE);

            cat1Rm.setText("Cent : ");
            cat2Rm.setText("Cent : ");
            cat3Rm.setText("Cent : ");
            cat4Rm.setText("Cent : ");
            cat5Rm.setText("Cent : ");
            cat6Rm.setText("Cent : ");

            cat1Text.setText("1 - 100 kWh");
            cat1Cost.setText("17.5");
            cat2Text.setText("101 - 200 kWh");
            cat2Cost.setText("18.5");
            cat3Text.setText("201 - 300 kWh");
            cat3Cost.setText("33.0");
            cat4Text.setText("301 - 500 kWh");
            cat4Cost.setText("44.5");
            cat5Text.setText("501 - 1000 kWh");
            cat5Cost.setText("45.0");
            cat6Text.setText("1001 kWh onwards");
            cat6Cost.setText("47.0");

        } else if (choice.equals("Sarawak Energy")) {
            minimumChargeCost.setText("5.00");

            cat4Card.setVisibility(View.VISIBLE);
            cat5Card.setVisibility(View.VISIBLE);
            cat6Card.setVisibility(View.VISIBLE);
            cat7Card.setVisibility(View.VISIBLE);
            cat8Card.setVisibility(View.VISIBLE);
            cat9Card.setVisibility(View.VISIBLE);
            cat10Card.setVisibility(View.VISIBLE);

            cat1Rm.setText("Cent : ");
            cat2Rm.setText("Cent : ");
            cat3Rm.setText("Cent : ");
            cat4Rm.setText("Cent : ");
            cat5Rm.setText("Cent : ");
            cat6Rm.setText("Cent : ");
            cat7Rm.setText("Cent : ");
            cat8Rm.setText("Cent : ");
            cat9Rm.setText("Cent : ");
            cat10Rm.setText("Cent : ");

            cat1Text.setText("1 - 100 kWh");
            cat1Cost.setText("18");
            cat2Text.setText("1 - 150 kWh");
            cat2Cost.setText("18");
            cat3Text.setText("1 - 200 kWh");
            cat3Cost.setText("22");
            cat4Text.setText("1 - 300 kWh");
            cat4Cost.setText("25");
            cat5Text.setText("1 - 400 kWh");
            cat5Cost.setText("27");
            cat6Text.setText("1 - 500 kWh");
            cat6Cost.setText("29.5");
            cat7Text.setText("1 - 700 kWh");
            cat7Cost.setText("29.5");
            cat8Text.setText("1 - 800 kWh");
            cat8Cost.setText("30.5");
            cat9Text.setText("1 - 1300 kWh");
            cat9Cost.setText("31");
            cat10Text.setText("1300 kWh onwards");
            cat10Cost.setText("31.5");

        } else if (choice.equals("Johor")) {
            minimumChargeCost.setText("7.00");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.80");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("2.00");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("3.00");

        } else if (choice.equals("Selangor")) {
            minimumChargeCost.setText("6.00");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.57");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("1.03");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("2.00");

        } else if (choice.equals("Labuan")) {
            minimumChargeCost.setText("7.00");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.70");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("1.20");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("1.70");

        } else if (choice.equals("Negeri Sembilan")) {
            minimumChargeCost.setText("5.00");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.55");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("0.85");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("1.40");

        } else if (choice.equals("Melaka")) {
            minimumChargeCost.setText("6.00");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.60");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("0.95");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("1.45");

        } else if (choice.equals("Perak")) {
            minimumChargeCost.setText("3.00");

            cat1Text.setText("0 - 10 m3");
            cat1Cost.setText("0.30");
            cat2Text.setText("10 - 20 m3");
            cat2Cost.setText("0.70");
            cat3Text.setText("20 m3 onwards");
            cat3Cost.setText("1.03");

        } else if (choice.equals("Kedah")) {
            minimumChargeCost.setText("6.00");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.50");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("0.90");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("1.30");

        } else if (choice.equals("Kelantan")) {
            minimumChargeCost.setText("4.50");

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.45");
            cat2Text.setText("20 - 35 m3");
            cat2Cost.setText("0.97");
            cat3Text.setText("35 m3 onwards");
            cat3Cost.setText("1.42");

        } else if (choice.equals("Terengganu")) {
            minimumChargeCost.setText("4.00");

            cat4Card.setVisibility(View.VISIBLE);

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.42");
            cat2Text.setText("20 - 40 m3");
            cat2Cost.setText("0.65");
            cat3Text.setText("40 - 60 m3");
            cat3Cost.setText("0.90");
            cat4Text.setText("60 m3 onwards");
            cat4Cost.setText("1.00");

        } else if (choice.equals("Pahang")) {
            minimumChargeCost.setText("3.00");

            cat1Text.setText("0 - 18 m3");
            cat1Cost.setText("0.37");
            cat2Text.setText("18 - 45 m3");
            cat2Cost.setText("0.79");
            cat3Text.setText("45 m3 onwards");
            cat3Cost.setText("0.99");

        } else if (choice.equals("Perlis")) {
            minimumChargeCost.setText("4.00");

            cat1Text.setText("0 - 15 m3");
            cat1Cost.setText("0.40");
            cat2Text.setText("15.1 - 40 m3");
            cat2Cost.setText("0.70");
            cat3Text.setText("40.1 m3 onwards");
            cat3Cost.setText("1.10");

        } else if (choice.equals("Penang")) {
            minimumChargeCost.setText("2.50");

            cat4Card.setVisibility(View.VISIBLE);
            cat5Card.setVisibility(View.VISIBLE);
            cat6Card.setVisibility(View.VISIBLE);

            cat1Text.setText("0 - 20 m3");
            cat1Cost.setText("0.22");
            cat2Text.setText("20 - 40 m3");
            cat2Cost.setText("0.46");
            cat3Text.setText("40 - 60 m3");
            cat3Cost.setText("0.68");
            cat4Text.setText("60 - 200 m3");
            cat4Cost.setText("1.17");
            cat5Text.setText("200 m3 onwards");
            cat5Cost.setText("1.30");
            cat6Text.setText("Consumption Exceeding 35 m3");
            cat6Cost.setText("0.48");

        } else if (choice.equals("Kuching")) {
            minimumChargeCost.setText("4.40");

            cat1Text.setText("1 - 15 m3");
            cat1Cost.setText("0.48");
            cat2Text.setText("15 - 50 m3");
            cat2Cost.setText("0.72");
            cat3Text.setText("50 m3 onwards");
            cat3Cost.setText("0.76");

        } else if (choice.equals("Sibu")) {
            minimumChargeCost.setText("4.40");

            cat1Text.setText("1 - 15 m3");
            cat1Cost.setText("0.48");
            cat2Text.setText("15 - 50 m3");
            cat2Cost.setText("0.72");
            cat3Text.setText("50 m3 onwards");
            cat3Cost.setText("0.76");

        } else if (choice.equals("Miri")) {
            minimumChargeCost.setText("4.40");

            cat1Text.setText("1 - 15 m3");
            cat1Cost.setText("0.48");
            cat2Text.setText("15 - 50 m3");
            cat2Cost.setText("0.72");
            cat3Text.setText("50 m3 onwards");
            cat3Cost.setText("0.76");

        } else if (choice.equals("Bintulu")) {
            minimumChargeCost.setText("6.60");

            cat1Text.setText("0 - 14 m3");
            cat1Cost.setText("Minimum Charge");
            cat2Text.setText("14 - 45 m3");
            cat2Cost.setText("0.61");
            cat3Text.setText("45 m3 onwards");
            cat3Cost.setText("0.66");

        } else if (choice.equals("Sarawak")) {
            minimumChargeCost.setText("4.00");

            cat1Text.setText("0 - 15 m3");
            cat1Cost.setText("0.44");
            cat2Text.setText("15 - 50 m3");
            cat2Cost.setText("0.65");
            cat3Text.setText("50 m3 onwards");
            cat3Cost.setText("0.69");

        } else if (choice.equals("Sabah")) {
            minimumChargeCost.setText("3.00");

            cat4Card.setVisibility(View.VISIBLE);
            cat5Card.setVisibility(View.VISIBLE);

            cat1Text.setText("0 - 10 m3");
            cat1Cost.setText("0.30");
            cat2Text.setText("11 - 20 m3");
            cat2Cost.setText("0.60");
            cat3Text.setText("21 - 35 m3");
            cat3Cost.setText("1.10");
            cat4Text.setText("36 - 60");
            cat4Cost.setText("1.30");
            cat5Text.setText("60 m3 onwards");
            cat5Cost.setText("1.80");
        }
    }
}