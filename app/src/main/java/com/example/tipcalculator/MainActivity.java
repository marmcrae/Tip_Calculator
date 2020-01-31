package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText enterBillEditText;
    private TextView showResultTextView;
    private Button calculateTipButton;
    private SeekBar tipPercentageSeekBar;
    private TextView showTipPercentageTextView;
    private int tipPercentage;
    private float enteredBillFloat;
    private TextView totalDueTextView;
    DecimalFormat prettyTip = new DecimalFormat("$###,###.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBillEditText = (EditText) findViewById(R.id.billAmountID);
        showResultTextView = (TextView) findViewById(R.id.resultID);
        tipPercentageSeekBar = (SeekBar) findViewById(R.id.seekBar);
        calculateTipButton = (Button) findViewById(R.id.calculateButtonID);
        showTipPercentageTextView = (TextView) findViewById(R.id.userPercentageAmountID);
        totalDueTextView = (TextView) findViewById(R.id.totalDueID);

        calculateTipButton.setOnClickListener(this);

        tipPercentageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                showTipPercentageTextView.setText(String.valueOf(tipPercentageSeekBar.getProgress() + "%"));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipPercentage = tipPercentageSeekBar.getProgress();


            }
        });

    }

    @Override
    public void onClick(View v) {
        calculate();

    }

    public void calculate() {
        float result;
        float totalResult;


        if (!enterBillEditText.getText().toString().equals("")) {
            enteredBillFloat = Float.parseFloat(enterBillEditText.getText().toString());
            result = enteredBillFloat * tipPercentage / 100;
            showResultTextView.setText("Your tip will be " + prettyTip.format(result));

            totalResult = (result) + enteredBillFloat;
            totalDueTextView.setText("Your total amount due is " +  prettyTip.format(totalResult));




        }else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount." , Toast.LENGTH_SHORT).show();
        }

    }



    }


