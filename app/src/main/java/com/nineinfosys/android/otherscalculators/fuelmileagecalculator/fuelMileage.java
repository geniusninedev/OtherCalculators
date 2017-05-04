package com.nineinfosys.android.otherscalculators.fuelmileagecalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.fuelcostcalculator.FuelCostCalculator;
import com.nineinfosys.android.otherscalculators.lovecalculator.LoveCalculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;

public class fuelMileage extends AppCompatActivity {
    Gas_mileage gasmileage;
    EditText editTextGasmileageStart,getEditTextGasmileageend,editTextgallonUsed;
    TextView textViewresult;
    Button btnCalculatecost;
    double startmileageValue, endmileageValue,Gallonused;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_mileage);

        MobileAds.initialize(fuelMileage.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewfuelmilage);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        editTextGasmileageStart=(EditText)findViewById(R.id.editTextmileage);
        getEditTextGasmileageend=(EditText)findViewById(R.id.editTextmileageend);
        editTextgallonUsed=(EditText)findViewById(R.id.editTextgasused);

        textViewresult=(TextView)findViewById(R.id.textViewResult);
        btnCalculatecost=(Button)findViewById(R.id.btnCalculatecost);
        btnCalculatecost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextGasmileageStart.getText().toString().trim())) {
                    editTextGasmileageStart.setError("Enter the current reading");
                    return;
                }

                if (TextUtils.isEmpty(getEditTextGasmileageend.getText().toString().trim())) {
                    getEditTextGasmileageend.setError("Enter the previous reading");
                    return;
                }


                if (TextUtils.isEmpty(getEditTextGasmileageend.getText().toString().trim())) {
                    editTextgallonUsed.setError("enter the gallon used");
                    return;
                }




                startmileageValue=Double.parseDouble(editTextGasmileageStart.getText().toString().trim());
                endmileageValue=Double.parseDouble(getEditTextGasmileageend.getText().toString().trim());
                Gallonused=Double.parseDouble(editTextgallonUsed.getText().toString().trim());



                gasmileage=new Gas_mileage(startmileageValue,endmileageValue,Gallonused);
                double result=gasmileage.calculateGasmileage();
                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");
                textViewresult.setText( "Fuel Mileage Is: " +REAL_FORMATTER.format(result)+" km/liter");
                textViewresult.setVisibility(View.VISIBLE);
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);




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
            Intent intent=new Intent(fuelMileage.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(fuelMileage.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
