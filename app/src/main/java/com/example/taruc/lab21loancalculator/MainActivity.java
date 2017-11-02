package com.example.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "monthlyPayment";
    public static final String LOAN_STATUS = "status";

   EditText vehiclePrice;
    EditText downPayment;
    EditText Repayment;
    EditText interestRate;
    EditText Salary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehiclePrice = (EditText) findViewById(R.id.editVehiclePrice);
        downPayment = (EditText) findViewById(R.id.editDownPayment);
        Repayment = (EditText) findViewById(R.id.editRepayment);
        interestRate = (EditText) findViewById(R.id.editInterestRate);
        Salary = (EditText) findViewById(R.id.editSalary);



    }

    public void calculateLoan(View view) {
        //TODO : calculate monthly payment and determine the loan status
        double monthlypayment =0;
        String status ="Approved";


        int VehiclePrice = Integer.parseInt(vehiclePrice.getText().toString());
        double DownPayment = Double.parseDouble(downPayment.getText().toString());
        double repayment = Double.parseDouble(Repayment.getText().toString());
        double InterestRate = Double.parseDouble(interestRate.getText().toString());
        double salary = Double.parseDouble(Salary.getText().toString());

        double totalInterest = (VehiclePrice - DownPayment) * InterestRate * (repayment/12);
        double totalLoan = (VehiclePrice - DownPayment) + totalInterest;
        monthlypayment = totalLoan / repayment;

        if(monthlypayment > salary * 0.3){
            status = "Rejected";
        }else {
            status ="Approved";
        }



        //create an explicit intent
        Intent intent = new Intent(this,ResultActivity.class);
        //TODO : passing data usign putExtra method
        //putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlypayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);


    }

    public void Reset (View view){
        vehiclePrice.setText("");
        downPayment.setText("");
        Repayment.setText("");
        interestRate.setText("");
        Salary.setText("");
    }


}