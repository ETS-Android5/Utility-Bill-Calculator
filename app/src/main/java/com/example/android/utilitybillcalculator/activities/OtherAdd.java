package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.android.utilitybillcalculator.R;
import com.example.android.utilitybillcalculator.database.DatabaseHelper;
import com.example.android.utilitybillcalculator.entities.Spending;

public class OtherAdd extends AppCompatActivity {

    //View component declaration
    EditText otherType;
    EditText otherName;
    EditText otherCost;
    TextView lastSpendType;
    TextView lastSpendName;
    TextView lastSpendCost;
    Button otherSave;
    CardView historyCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_other);

        //Attaching views to layout resources.
        otherType = findViewById(R.id.other_type);
        otherName = findViewById(R.id.other_name);
        otherCost = findViewById(R.id.other_cost);
        otherSave = findViewById(R.id.other_save);
        lastSpendType = findViewById(R.id.last_spending_type);
        lastSpendName = findViewById(R.id.last_spending_name);
        lastSpendCost = findViewById(R.id.last_spending_cost);
        historyCard = findViewById(R.id.other_last_month_card);

        //Database initialization
        final DatabaseHelper database = new DatabaseHelper(OtherAdd.this);

        //Get last spending record
        Spending spendObj = database.getLastRecord();

        //If no object is stored, set the card to null and 0.00 as the price
        if (spendObj == null) {
            spendObj = new Spending(null, null, 0.00);
        }

        //Program the type, name and cost of the card at the top of the activity
        String lastSpendingPrice = String.format("%.2f", spendObj.getPrice());
        lastSpendType.setText(spendObj.getType());
        lastSpendName.setText(spendObj.getName());
        lastSpendCost.setText(lastSpendingPrice);

        //Save spending to database
        otherSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String type = otherType.getText().toString();
                    String name = otherName.getText().toString();
                    Double cost = Double.parseDouble(otherCost.getText().toString());
                    //If type or name is empty, store as unstated instead for both
                    if (type.equals("")) {
                        type = "Unstated";
                    }
                    if (name.equals("")) {
                        name = "Unstated";
                    }
                    Spending other = new Spending(type, name, cost);

                    boolean success = database.addOneSpending(other);
                    Toast.makeText(OtherAdd.this, "Saved", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(OtherAdd.this, "Invalid Amount!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Opens all spending history when tapping on top card
        historyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHistory = new Intent(getApplicationContext(), SpendingHistory.class);
                openHistory.putExtra("TYPE", "All");
                startActivity(openHistory);
            }
        });
    }
}
