package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.utilitybillcalculator.R;

public class ElectricChoice extends AppCompatActivity {

    //View component declaration
    TextView tnb;
    TextView sarawakEnergy;
    TextView sabahElectric;

    //A final string variable is created to avoid mistyping as it is used multiple times.
    public static final String TYPE = "Electric";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_electricity);

        //Attaching views to layout resource.
        tnb = (TextView) findViewById(R.id.tnb);
        sarawakEnergy = (TextView) findViewById(R.id.sarawak_energy);
        sabahElectric = (TextView) findViewById(R.id.sabah_electric);

        /*
        setOnClickListener is used on each TextViews to store information on which views user
        tapped to program the calculator and start the calculator activity.
         */

        tnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Tenaga Nasional";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        sarawakEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Sarawak Energy";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        sabahElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Sabah Electric";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });
    }
}