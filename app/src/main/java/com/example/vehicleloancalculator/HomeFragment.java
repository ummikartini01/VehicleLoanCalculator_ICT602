package com.example.vehicleloancalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class HomeFragment extends Fragment {

    private EditText etVehiclePrice, etDownPayment, etLoanPeriod, etInterestRate;
    private TextView tvLoanAmount, tvTotalInterest, tvTotalPayment, tvMonthlyPayment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceSate){

       View view = inflater.inflate(R.layout.fragment_home, container, false);

       etVehiclePrice = view.findViewById(R.id.etVehiclePrice);
       etDownPayment = view.findViewById(R.id.etDownPayment);
       etLoanPeriod = view.findViewById(R.id.etLoanPeriod);
       etInterestRate = view.findViewById(R.id.etInterestRate);

       Button btnCalc = view.findViewById(R.id.btnCalc);

       tvLoanAmount = view.findViewById(R.id.tvLoanAmount);
       tvTotalInterest = view.findViewById(R.id.tvTotalInterest);
       tvTotalPayment = view.findViewById(R.id.tvTotalPayment);
       tvMonthlyPayment = view.findViewById(R.id.tvMonthlyPayment);

       btnCalc.setOnClickListener(v -> calculateLoan());

       return view;
    }

    private void calculateLoan() {
        if (!validateInputs()) return;

        double vehiclePrice = Double.parseDouble(etVehiclePrice.getText().toString());
        double downPayment = Double.parseDouble(etDownPayment.getText().toString());
        int loanYears = Integer.parseInt(etLoanPeriod.getText().toString());
        double interestRate = Double.parseDouble(etInterestRate.getText().toString());

        double loanAmount = vehiclePrice - downPayment;
        double totalInterest = loanAmount * (interestRate/100.0) * loanYears;
        double totalPayment = loanAmount + totalInterest;
        double monthlyPayment = totalPayment / (loanYears * 12 );

        tvLoanAmount.setText("Loan Amount:" + String.format("RM %, .2f", loanAmount));
        tvTotalInterest.setText("Total Interest:" + String.format("RM %, .2f", totalInterest));
        tvTotalPayment.setText("Total Payment:" + String.format("RM %, .2f", totalPayment));
        tvMonthlyPayment.setText("Monthly Payment:" + String.format("RM %, .2f", monthlyPayment));

    }

    private boolean validateInputs() {
        if(TextUtils.isEmpty(etVehiclePrice.getText())){
            etVehiclePrice.setError("Enter vehicle price !");
            return false;
        }

        if (TextUtils.isEmpty(etDownPayment.getText())){
            etDownPayment.setError("Enter down payment !");
            return false;
        }

        if (TextUtils.isEmpty(etLoanPeriod.getText())){
            etLoanPeriod.setError("Enter loan period !");
            return false;
        }

        if (TextUtils.isEmpty(etInterestRate.getText())){
            etInterestRate.setError("Enter interest rate !");
            return false;
        }

        try {
            double vp = Double.parseDouble(etVehiclePrice.getText().toString());
            double dp = Double.parseDouble(etDownPayment.getText().toString());
            if(dp>vp){
                Toast.makeText(getContext(), " Down payment cannot exceed vehicle price", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), " Invalid input format", Toast.LENGTH_SHORT).show();
            return false;
        }
         return true;


    }

}
