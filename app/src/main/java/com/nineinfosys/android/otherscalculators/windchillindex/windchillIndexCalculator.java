package com.nineinfosys.android.otherscalculators.windchillindex;

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
import com.nineinfosys.android.otherscalculators.tilescalculator.tilescalci;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class windchillIndexCalculator extends AppCompatActivity {
    double tempValue,windspeedvalue;
    String SpinnerValue,OldIndexSpinner,tempSpinnerValue,oldtempSpinner;
    Spinner unitField,tempField;

    EditText edittextAirtempreture,editextWindspeed;
    TextView newfahrenheitValue,oldfahrenheitValue,newcelciusValue,oldcelciusValue,NewkelvinValue,oldkelvinValue;    Button btnCalculateIndex;
    Windchill windchill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windchill_index_calculator);

        MobileAds.initialize(windchillIndexCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewwindchill);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        edittextAirtempreture=(EditText)findViewById(R.id.editTextairTempreture);
        editextWindspeed=(EditText)findViewById(R.id.editTextwindspeed);
        newfahrenheitValue=(TextView)findViewById(R.id.newfahrenheitValue) ;
        oldfahrenheitValue=(TextView)findViewById(R.id.oldfahrenheitValue) ;


        newcelciusValue=(TextView)findViewById(R.id.newcelciusValue) ;
        oldcelciusValue=(TextView)findViewById(R.id.oldcelciusValue) ;

        NewkelvinValue=(TextView)findViewById(R.id.NewkelvinValue) ;
        oldkelvinValue=(TextView)findViewById(R.id.oldkelvinValue) ;

        unitField = (Spinner) findViewById(R.id.spinnerCreatinine);
        tempField = (Spinner) findViewById(R.id.spinnerTemp);

        ArrayList area = new ArrayList();
        area.add("m/h");
        area.add("km/h");

        ArrayList temp = new ArrayList();

        temp.add("℉");
        temp.add("℃");
        temp.add("K");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitField.setAdapter(dataAdapter);

        ArrayAdapter<String> tempAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temp);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempField.setAdapter(tempAdapter);

        btnCalculateIndex=(Button)findViewById(R.id.btnCalculateIndex);


        btnCalculateIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edittextAirtempreture.getText().toString().trim())) {
                    edittextAirtempreture.setError("Enter air tempreture");
                    return;
                }

                if (TextUtils.isEmpty(editextWindspeed.getText().toString().trim())) {
                    editextWindspeed.setError("Enter wind speed");
                    return;
                }

                tempValue=Double.parseDouble(edittextAirtempreture.getText().toString().trim());
                windspeedvalue=Double.parseDouble(editextWindspeed.getText().toString().trim());
                SpinnerValue= unitField.getSelectedItem().toString().trim();
                tempSpinnerValue=tempField.getSelectedItem().toString().trim();

                OldIndexSpinner= unitField.getSelectedItem().toString().trim();
                oldtempSpinner=tempField.getSelectedItem().toString().trim();

                windchill=new Windchill();
                double result=windchill.calculateNewWindchillIndex(tempValue,windspeedvalue,SpinnerValue,tempSpinnerValue);
                double resultincelcius=(result-32)*0.555;
                double resultinKelvin=(result+459.67)*0.555;
                double Oldresult=windchill.calculateOldWindchillIndex(tempValue,windspeedvalue,OldIndexSpinner,oldtempSpinner);
                double Oldresultincelcius=(Oldresult-32)*0.555;
                double OldresultinKelvin=(Oldresult+459.67)*0.555;



                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");

                newfahrenheitValue.setText(""+REAL_FORMATTER.format(result)+" \u2109");
                oldfahrenheitValue.setText(""+REAL_FORMATTER.format(Oldresult)+" \u2109");

                newcelciusValue.setText("" +REAL_FORMATTER.format(resultincelcius)+" \u2103");
                oldcelciusValue.setText(""+REAL_FORMATTER.format(Oldresultincelcius)+" \u2103");

                NewkelvinValue.setText(""   +REAL_FORMATTER.format(resultinKelvin)+" \u212A");
                oldkelvinValue.setText(""+REAL_FORMATTER.format(OldresultinKelvin)+" \u212A");

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


                // textViewResult.setText("New WindChill Index Is:".toString()+Double.toString((double) result +"\n in celcius:".toString()+Double.toString(double) resultincelcius));

                // textViewresultOld.setText("New WindChill Index Is In:".toString()+Double.toString((double) resultincelcius));




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
            Intent intent=new Intent(windchillIndexCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(windchillIndexCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

