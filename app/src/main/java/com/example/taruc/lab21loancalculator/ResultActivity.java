package com.example.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //To receive data from another Activity
        Intent intent = getIntent(); //Asking "who called me"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO : Display Output

        TextView displayMonPay = (TextView) findViewById(R.id.textMonPay);
        displayMonPay.setText("Monthly Payment =" + payment);
        TextView displayStatus = (TextView) findViewById (R.id.textStatus);
        displayStatus.setText("Status = " + status);





    }

    public void closeActivity (View view){
        //terminate the calculate
        finish();

    }

}
