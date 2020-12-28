package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.utilitybillcalculator.R;
import com.example.android.utilitybillcalculator.classes.Spending;
import com.example.android.utilitybillcalculator.classes.SpendingAdapter;
import com.example.android.utilitybillcalculator.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;

public class SpendingHistory extends AppCompatActivity {

    //Views declaration
    private CardView spendingCard;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView lastMonthSpending;
    private TextView averageSpending;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_spending);

        //Receive information from previous activity about which TextView user tapped on
        final Intent intent = getIntent();
        final String choice = intent.getStringExtra("TYPE");
        //Database declaration
        final DatabaseHelper databaseHelper = new DatabaseHelper(SpendingHistory.this);
        //Attaching views to layout resources
        lastMonthSpending = findViewById(R.id.last_month_spending);
        averageSpending = findViewById(R.id.last_month_cost);
        spendingCard = findViewById(R.id.spending_card);

        //Program the type of spending to show depending on which TextView user tapped on
        if (choice.equals("All")) {
            ArrayList<Spending> spendingList = databaseHelper.getAllSpending();
            Collections.reverse(spendingList);
            lastMonthSpending.setText("This Month Spending");
            String averageBillCost = String.format("%.2f", databaseHelper.getMonthlyCost());
            averageSpending.setText(averageBillCost);
            mAdapter = new SpendingAdapter(spendingList);
        } else if (choice.equals("Electric")) {
            ArrayList<Spending> spendingList = databaseHelper.getElectricSpending();
            Collections.reverse(spendingList);
            lastMonthSpending.setText("Average Electric Bill");
            String averageBillCost = String.format("%.2f", databaseHelper.getAverageElectricCost());
            if (averageBillCost.equals("0.00")) {
                averageSpending.setText("0.00");
            } else {
                averageSpending.setText(averageBillCost);
            }
            mAdapter = new SpendingAdapter(spendingList);
        } else if (choice.equals("Water")) {
            ArrayList<Spending> spendingList = databaseHelper.getWaterSpending();
            Collections.reverse(spendingList);
            lastMonthSpending.setText("Average Water Bill");
            String averageBillCost = String.format("%.2f", databaseHelper.getAverageWaterCost());
            averageSpending.setText(averageBillCost);
            mAdapter = new SpendingAdapter(spendingList);
        }

        //Tapping on top card shows spending insight
        spendingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openInsight = new Intent(getApplicationContext(), SpendingInsight.class);
                startActivity(openInsight);
            }
        });

        //RecyclerView for dynamically adding spending to a list
        mRecyclerView = findViewById(R.id.all_recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

}
