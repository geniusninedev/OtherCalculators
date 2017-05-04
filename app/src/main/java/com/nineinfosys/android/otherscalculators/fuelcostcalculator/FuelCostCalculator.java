package com.nineinfosys.android.otherscalculators.fuelcostcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.lovecalculator.LoveCalculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FuelCostCalculator extends AppCompatActivity {


    EditText editTexttripdistance,editTextgasprice,editTextfuelefficiency;
    Button btncalculate ;
    Fuel_Cost fuelcost;
    TextView textviewResult;

    Spinner tripField,effeciencyField,priceField;
    double distanceValue,priceValue,efficiencyValue;
    String tripspinneValue,fuelspinnerValue,priceSpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_cost_calculator);


        MobileAds.initialize(FuelCostCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewfuelcost);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        editTexttripdistance=(EditText)findViewById(R.id.editTexttripdistance);
        editTextfuelefficiency=(EditText)findViewById(R.id.editTextfuelefficiency);
        editTextgasprice=(EditText)findViewById(R.id.editTextgasPrice);
        textviewResult=(TextView)findViewById(R.id.textViewResult);

        tripField = (Spinner) findViewById(R.id.tripSpinner);
        effeciencyField = (Spinner) findViewById(R.id.fuelSpinner);
        priceField = (Spinner) findViewById(R.id.priceSpinner);


        final ArrayList trip = new ArrayList();
        trip.add("miles");
        trip.add("kilometers");

        ArrayList fueleff = new ArrayList();

        fueleff.add("miles/gallon");
        fueleff.add("kilometers/liter");

        ArrayList price = new ArrayList();
        price.add("/gallon");
        price.add("/liter");




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, trip);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        tripField.setAdapter(dataAdapter);

        ArrayAdapter<String> tempAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, fueleff);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        effeciencyField.setAdapter(tempAdapter);

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, price);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        priceField.setAdapter(timeAdapter);












        btncalculate=(Button)findViewById(R.id.btnCalculatecost);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(editTexttripdistance.getText().toString().trim())) {
                    editTexttripdistance.setError("Enter the trip distance");
                    return;
                }

                if (TextUtils.isEmpty(editTextfuelefficiency.getText().toString().trim())) {
                    editTextfuelefficiency.setError("enter the fuel efficiency");
                    return;
                }


                if (TextUtils.isEmpty(editTextgasprice.getText().toString().trim())) {
                    editTextgasprice.setError("enter the price");
                    return;
                }





                distanceValue=Double.parseDouble(editTexttripdistance.getText().toString().trim());
                priceValue=Double.parseDouble(editTextgasprice.getText().toString().trim());
                efficiencyValue=Double.parseDouble(editTextfuelefficiency.getText().toString().trim());

                tripspinneValue= tripField.getSelectedItem().toString().trim();
                fuelspinnerValue=effeciencyField.getSelectedItem().toString().trim();
                priceSpinnerValue=priceField.getSelectedItem().toString().trim();


                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



                fuelcost=new Fuel_Cost();
                double result=fuelcost.Calculate_Fuel_cost(distanceValue,priceValue,efficiencyValue,tripspinneValue,fuelspinnerValue,priceSpinnerValue);
                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.###");
                textviewResult.setText( "Fuel Cost Per Day Is:" +REAL_FORMATTER.format(result)+  " \u20B9");

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(FuelCostCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(FuelCostCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


