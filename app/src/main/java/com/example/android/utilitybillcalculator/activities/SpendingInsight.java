package com.example.android.utilitybillcalculator.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.utilitybillcalculator.R;
import com.example.android.utilitybillcalculator.database.DatabaseHelper;

public class SpendingInsight extends AppCompatActivity {

    //Views declaration
    TextView electricAverageSpending;
    TextView waterAverageSpending;
    TextView allLastMonthSpending;
    TextView electricLastMonthSpending;
    TextView waterLastMonthSpending;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insight_spending);

        //Attaching views to layout resources
        electricAverageSpending = findViewById(R.id.electricity_average_spending_value);
        waterAverageSpending = findViewById(R.id.water_average_spending_value);
        allLastMonthSpending = findViewById(R.id.all_last_month_spending_value);
        electricLastMonthSpending = findViewById(R.id.electricity_last_month_spending_value);
        waterLastMonthSpending = findViewById(R.id.water_last_month_spending_value);

        //Database declaration
        final DatabaseHelper databaseHelper = new DatabaseHelper(SpendingInsight.this);

        //Setting all card values to their corresponding value from database
        electricAverageSpending.setText(String.format("%.2f", databaseHelper.getAverageElectricCost()));
        waterAverageSpending.setText(String.format("%.2f", databaseHelper.getAverageWaterCost()));
        allLastMonthSpending.setText(String.format("%.2f", databaseHelper.getLastMonthSpendingWithoutBills()));
        electricLastMonthSpending.setText(String.format("%.2f", databaseHelper.getLastMonthElectricBill()));
        waterLastMonthSpending.setText(String.format("%.2f", databaseHelper.getLastMonthWaterBill()));

    }
}
