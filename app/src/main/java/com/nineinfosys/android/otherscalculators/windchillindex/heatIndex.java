package com.nineinfosys.android.otherscalculators.windchillindex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.nineinfosys.android.otherscalculators.lovecalculator.timeZone;
import com.nineinfosys.android.otherscalculators.tilescalculator.tilescalci;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Dev on 05-04-2017.
 */

public class heatIndex extends AppCompatActivity {


    TextView temperatureTextView,percentageTextView,descriptionTextView,resultTextView;
    EditText percentageEditText;
    TextView temp;
    EditText tempEditText;
    heatIndexCalculator1 heatIndex;
    Spinner temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heatindex);

        MobileAds.initialize(heatIndex.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewheat);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        temperature = (Spinner) findViewById(R.id.spinnerTemperature);
        //  temperatureTextView=(TextView)findViewById(R.id.textViewTemperature);
       // percentageTextView=(TextView)findViewById(R.id.textViewPercentage);
        //descriptionTextView=(TextView)findViewById(R.id.textViewDescription);
        resultTextView=(TextView)findViewById(R.id.textViewResult);
        temp=(TextView)findViewById(R.id.textViewTemp);
        tempEditText=(EditText)findViewById(R.id.editTextTemp);

        //   temperatureEditText=(EditText)findViewById(R.id.editTextTemperature);
        percentageEditText=(EditText)findViewById(R.id.editTextPercentage);

        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);

        ArrayList gender = new ArrayList();
        gender.add("℉");
        gender.add("℃");
        gender.add("K");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperature.setAdapter(dataAdapter);
        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinnerGender=temperature.getSelectedItem().toString().trim();


                //String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);

                if (TextUtils.isEmpty(tempEditText.getText().toString().trim())) {
                    tempEditText.setError("enter the temperature");
                    return;
                }
                if (TextUtils.isEmpty(percentageEditText.getText().toString().trim())) {
                    percentageEditText.setError("enter the humidity percentage");
                    return;
                }
                double temperatureValue=Double.parseDouble(tempEditText.getText().toString().trim());

                double pressureValue=Double.parseDouble(percentageEditText.getText().toString().trim());


                String consumptionValue1 = Double.toString((double) temperatureValue);
                String governmentconsumption1 = Double.toString((double) pressureValue);

                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");

                heatIndex=new heatIndexCalculator1();
                double resultgrossDomesticProductValue=heatIndex.calculateHeatIndex(temperatureValue,pressureValue,spinnerGender);

                double resultincelcius=(resultgrossDomesticProductValue-32)*0.555;
                double resultinKelvin=(resultgrossDomesticProductValue+459.67)*0.555;

                //String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);
               // descriptionTextView.setText("\nAt a temperature of" + temperatureValue + "and a humidity of" + pressureValue + "percent . . .\n");
                resultTextView.setText( "Heat Index Temperature :"+REAL_FORMATTER.format(resultgrossDomesticProductValue)+"℉"+ " or "
                        +REAL_FORMATTER.format(resultincelcius) + "℃" +" or " +REAL_FORMATTER.format(resultinKelvin)+" K");

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempEditText.getText().clear();
                percentageEditText.getText().clear();
                resultTextView.setText("");
                descriptionTextView.setText("");

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
            Intent intent=new Intent(heatIndex.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(heatIndex.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


