package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.utilitybillcalculator.R;

public class HistoryChoice extends AppCompatActivity {

    //View component declaration
    TextView allSpending;
    TextView electricSpending;
    TextView waterSpending;
    TextView insightSpending;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_history);

        //Attaching views to layout resources.
        allSpending = findViewById(R.id.all_spending);
        electricSpending = findViewById(R.id.electric_spending);
        waterSpending = findViewById(R.id.water_spending);
        insightSpending = findViewById(R.id.insight_spending);

        /*
        setOnClickListener is used on each TextViews to store information on which views user
        tapped to program the spending history and start the spending history activity
         */

        allSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHistory = new Intent(getApplicationContext(), SpendingHistory.class);
                String choice = "All";
                openHistory.putExtra("TYPE", choice);
                startActivity(openHistory);
            }
        });

        electricSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHistory = new Intent(getApplicationContext(), SpendingHistory.class);
                String choice = "Electric";
                openHistory.putExtra("TYPE", choice);
                startActivity(openHistory);

            }
        });

        waterSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHistory = new Intent(getApplicationContext(), SpendingHistory.class);
                String choice = "Water";
                openHistory.putExtra("TYPE", choice);
                startActivity(openHistory);
            }
        });

        //No information is stored, only opens spending insight
        insightSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openInsightHistory = new Intent(getApplicationContext(), SpendingInsight.class);
                startActivity(openInsightHistory);
            }
        });
    }
}
