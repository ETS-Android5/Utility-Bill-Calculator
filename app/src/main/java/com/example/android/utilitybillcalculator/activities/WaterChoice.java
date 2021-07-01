package com.example.android.utilitybillcalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.utilitybillcalculator.R;

public class WaterChoice extends AppCompatActivity {

    //View component declaration
    TextView johor;
    TextView kedah;
    TextView kelantan;
    TextView melaka;
    TextView negeriSembilan;
    TextView pahang;
    TextView penang;
    TextView perak;
    TextView perlis;
    TextView selangor;
    TextView terengganu;
    TextView sabah;
    TextView sarawak;
    TextView kuching;
    TextView sibu;
    TextView miri;
    TextView bintulu;
    TextView labuan;

    public static final String TYPE = "Water";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_water);

        //Attaching views to layout resources.
        johor = findViewById(R.id.johor);
        kedah = findViewById(R.id.kedah);
        kelantan = findViewById(R.id.kelantan);
        melaka = findViewById(R.id.melaka);
        negeriSembilan = findViewById(R.id.negeri_sembilan);
        pahang = findViewById(R.id.pahang);
        penang = findViewById(R.id.penang);
        perak = findViewById(R.id.perak);
        perlis = findViewById(R.id.perlis);
        sabah = findViewById(R.id.sabah);
        sarawak = findViewById(R.id.sarawak);
        selangor = findViewById(R.id.selangor);
        terengganu = findViewById(R.id.terengganu);
        kuching = findViewById(R.id.kuching);
        sibu = findViewById(R.id.sibu);
        miri = findViewById(R.id.miri);
        bintulu = findViewById(R.id.bintulu);
        labuan = findViewById(R.id.labuan);

        /*
        setOnClickListener is used on each TextViews to store information on which views user
        clicked to program the calculator and start the calculator activity.
         */

        johor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Johor";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        kedah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Kedah";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        kelantan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Kelantan";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        melaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Melaka";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        negeriSembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Negeri Sembilan";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        pahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Pahang";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        penang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Penang";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        perak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Perak";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        perlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Perlis";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        sabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Sabah";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        sarawak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Sarawak";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        selangor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Selangor";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        terengganu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Terengganu";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        kuching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Kuching";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        sibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Sibu";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        miri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Sri Aman";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        bintulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Bintulu";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

        labuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCalculator = new Intent(getApplicationContext(), CalculatorBill.class);
                String choice = "Labuan";
                openCalculator.putExtra("NAME", choice);
                openCalculator.putExtra("TYPE", TYPE);
                startActivity(openCalculator);
            }
        });

    }
}
