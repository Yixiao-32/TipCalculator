package com.example.tipcalculator;
// edu.qc.seclass.tipcalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity {

    double checkAmount;
    int partySize;

    EditText checkAmountValue;
    EditText partySizeValue;
    Button computeButton;

    EditText percent15Tip;
    EditText percent20Tip;
    EditText percent25Tip;

    EditText percent15Total;
    EditText percent20Total;
    EditText percent25Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);

        computeButton = findViewById(R.id.buttonCompute);
        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkAmountValue.getText().toString().length() == 0 || partySizeValue.getText().toString().length() == 0 ){

                    Context context = getApplicationContext();
                    CharSequence text = "Enter data";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    /*
                    Or also can ues:
                    Toast.makeText(context, text, duration).show();
                     */
                }


                percent15Tip = findViewById(R.id.fifteenPercentTipValue);
                percent20Tip = findViewById(R.id.twentyPercentTipValue);
                percent25Tip = findViewById(R.id.twentyfivePercentTipValue);

                percent15Total = findViewById(R.id.fifteenPercentTotalValue);
                percent20Total = findViewById(R.id.twentyPercentTotalValue);
                percent25Total = findViewById(R.id.twentyfivePercentTotalValue);

                checkAmount = Double.valueOf(checkAmountValue.getText().toString());
                partySize = Integer.valueOf(partySizeValue.getText().toString());

                if(checkAmount < 0 || partySize <= 0 ){
                    Context context = getApplicationContext();
                    CharSequence text = "Enter valid data";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    /*
                    Or also can ues:
                    Toast.makeText(context, text, duration).show();
                     */
                }

                percent15Tip.setText(String.valueOf(calculateTip(checkAmount, partySize, 0.15)));
                percent20Tip.setText(String.valueOf(calculateTip(checkAmount, partySize, 0.20)));
                percent25Tip.setText(String.valueOf(calculateTip(checkAmount, partySize, 0.25)));

                percent15Total.setText(String.valueOf(calculateTotal(checkAmount, partySize, 0.15)));
                percent20Total.setText(String.valueOf(calculateTotal(checkAmount, partySize, 0.20)));
                percent25Total.setText(String.valueOf(calculateTotal(checkAmount, partySize, 0.25)));

            }
        });
    }

    private int  calculateTip(double CheckAmount, int PartySize, double percent) {
        int tip = (int) Math.ceil((CheckAmount / PartySize) * percent);
        return tip;
    }

    private int  calculateTotal(double CheckAmount, int PartySize, double percent) {
        int total = (int) Math.ceil((1 + percent) * (CheckAmount / PartySize));
        return total;
    }
}