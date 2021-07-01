package com.example.android.utilitybillcalculator.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.android.utilitybillcalculator.R;
import com.example.android.utilitybillcalculator.database.DatabaseHelper;
import com.example.android.utilitybillcalculator.entities.Spending;
import com.example.android.utilitybillcalculator.logic.Calculation;

public class CalculatorBill extends AppCompatActivity {

    //View component declaration
    EditText userInputToCalculate;
    Button calculateButton;
    Button saveButton;
    Button tariffRates;
    TextView resultText;
    TextView lastMonthText;
    TextView lastMonthCost;
    CardView historyCard;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_calculator);

        //Attach all views to corresponding resources
        lastMonthText = findViewById(R.id.bill_last_month);
        lastMonthCost = findViewById(R.id.cost_last_month);
        calculateButton = findViewById(R.id.calculate);
        saveButton = findViewById(R.id.save);
        resultText = findViewById(R.id.result);
        userInputToCalculate = findViewById(R.id.toCalculate);
        historyCard = findViewById(R.id.last_month_card);
        tariffRates = findViewById(R.id.tariff_rate_button);

        //Database initialization
        final DatabaseHelper databaseHelper = new DatabaseHelper(CalculatorBill.this);
        Calculation calculation = new Calculation(databaseHelper);

        //Intent is declared and used to receive information about which views user clicked on
        final Intent intention = getIntent();
        final String type = intention.getStringExtra("TYPE");
        final String choice = intention.getStringExtra("NAME");

        //Dynamically set the top card value depending on which category user tapped on
        if (type.equals("Electric")) {
            Double lastElectricCost = databaseHelper.getLastElectricCost();
            String formattedElectricCost = String.format("%.2f", lastElectricCost);
            lastMonthCost.setText(formattedElectricCost);
            lastMonthText.setText("Last saved electric bill");
            userInputToCalculate.setHint("KW/H");
        } else {
            Double lastWaterCost = databaseHelper.getLastWaterCost();
            String formattedWaterCost = String.format("%.2f", lastWaterCost);
            lastMonthCost.setText(formattedWaterCost);
            lastMonthText.setText("Last saved water bill");
            userInputToCalculate.setHint("M³");
        }

        calculateButton.setOnClickListener(new View.OnClickListener() {
            //This onClick method is used to receive and shows calculated user input values.
            @Override
            public void onClick(View v) {
                try {
                    String toCalculate = userInputToCalculate.getText().toString();
                    Double toCalculateAmount = Double.parseDouble(toCalculate);
                    Double price = calculation.calculate(type, choice, toCalculateAmount);
                    String resultDouble = String.format("%.2f", price);
                    resultText.setText(resultDouble);
                } catch (NumberFormatException e) {
                    Toast.makeText(CalculatorBill.this, "Invalid Amount!", Toast.LENGTH_SHORT).show();
                }
            }
        });

            /*
            setOnClickListener method is used to receive, calculated, show and save user input values.
            A new class is created based on user input values and calculated values which is then
            stored to the database.
            Toast is used to troubleshoot and show if storing is successful
             */
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Used to check for whether or not user has saved their bill this month.
                boolean checkIfSaved = false;
                if (type.equals("Electric")) {
                    checkIfSaved = databaseHelper.checkElectricBillSaved();
                } else {
                    checkIfSaved = databaseHelper.checkWaterBillSaved();
                }

                //If bill is saved, an alert will popup to warn user in order to ensure only one bill is saved per month.
                if (checkIfSaved) {
                    AlertDialog.Builder checkDialog = new AlertDialog.Builder(CalculatorBill.this);
                    checkDialog.setMessage("Current month bill is saved, do you want to save another one?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        String toCalculate = userInputToCalculate.getText().toString();
                                        Double toCalculateAmount = Double.parseDouble(toCalculate);
                                        Double price = calculation.calculate(type, choice, toCalculateAmount);
                                        Spending spend = new Spending(type, choice, price);
                                        String resultDouble = String.format("%.2f", spend.getPrice());
                                        boolean success = databaseHelper.addOneSpending(spend);
                                        if (success) {
                                            Toast.makeText(CalculatorBill.this, "Saved", Toast.LENGTH_SHORT).show();
                                        }
                                        resultText.setText(resultDouble);
                                    } catch (NumberFormatException e) {
                                        Toast.makeText(CalculatorBill.this, "Invalid Amount!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                    //Initialization of dialog box
                    AlertDialog alert = checkDialog.create();
                    alert.setTitle("Bill Saved");
                    alert.show();
                } else {
                    try {
                        String toCalculate = userInputToCalculate.getText().toString();
                        Double toCalculateAmount = Double.parseDouble(toCalculate);
                        Double price = calculation.calculate(type, choice, toCalculateAmount);
                        Spending spend = new Spending(type, choice, price);
                        String resultDouble = String.format("%.2f", spend.getPrice());
                        boolean success = databaseHelper.addOneSpending(spend);
                        if (success) {
                            Toast.makeText(CalculatorBill.this, "Saved", Toast.LENGTH_SHORT).show();
                        }
                        resultText.setText(resultDouble);
                    } catch (NumberFormatException e) {
                        Toast.makeText(CalculatorBill.this, "Invalid Amount!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    });

        historyCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
        Intent openHistory = new Intent(getApplicationContext(), SpendingHistory.class);
        openHistory.putExtra("TYPE", type);
        startActivity(openHistory);
    }
    });

        tariffRates.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
        Intent openTariffRates = new Intent(getApplicationContext(), TariffRates.class);
        openTariffRates.putExtra("TYPE", type);
        openTariffRates.putExtra("NAME", choice);
        startActivity(openTariffRates);
    }
    });
}
}
