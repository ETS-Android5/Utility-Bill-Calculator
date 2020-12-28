package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.android.utilitybillcalculator.R;
import com.example.android.utilitybillcalculator.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    //Views declaration
    TextView thisMonthSpending;
    CardView electricityText;
    CardView waterText;
    CardView otherText;
    CardView historyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attaching views to layout resources.
        thisMonthSpending = findViewById(R.id.this_month_spending_value);
        electricityText = (CardView) findViewById(R.id.electric_choice);
        waterText = (CardView) findViewById(R.id.water_choice);
        otherText = (CardView) findViewById(R.id.others_choice);
        historyText = (CardView) findViewById(R.id.history_choice);

        //Set this month spending CardView text to current month spending value from database.
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        Double thisMonthCost = db.getMonthlyCost();
        String formattedThisMonthCost = String.format("%.2f", thisMonthCost);
        thisMonthSpending.setText(formattedThisMonthCost);

        /*
        setOnClickListener is used on each CardView to start and open each corresponding activities.
         */
        electricityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openElectricyChoice = new Intent(getApplicationContext(), ElectricChoice.class);
                startActivity(openElectricyChoice);
            }
        });

        waterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWaterChoice = new Intent(getApplicationContext(), WaterChoice.class);
                startActivity(openWaterChoice);
            }
        });

        otherText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openOtherChoice = new Intent(getApplicationContext(), OtherAdd.class);
                startActivity(openOtherChoice);
            }
        });

        historyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHistoryChoice = new Intent(getApplicationContext(), HistoryChoice.class);
                startActivity(openHistoryChoice);
            }
        });

    }

    //Used to set the top card value when user tap on back after saving their spending
    public void onRestart() {
        super.onRestart();
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        Double thisMonthCost = db.getMonthlyCost();
        String formattedThisMonthCost = String.format("%.2f", thisMonthCost);
        thisMonthSpending.setText(formattedThisMonthCost);
    }
}
