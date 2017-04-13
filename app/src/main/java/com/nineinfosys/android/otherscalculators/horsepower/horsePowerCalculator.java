package com.nineinfosys.android.otherscalculators.horsepower;

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

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.heightpredictor.Heightpredictorcalculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class horsePowerCalculator extends AppCompatActivity {

    Horsepower horsepower;
    EditText editTextforce,editTextdistance,editTexttime;
    TextView textViewresult;
    Button btnCalculatePower;
    double forceValue, distanceValue,timeValue;

    Spinner forceField,distField,timeField;

    String forcespinneValue,disspinnerValue,tineSpinnerValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_power);

        editTextforce=(EditText)findViewById(R.id.editTextforce);
        editTextdistance=(EditText)findViewById(R.id.editTextdistance);
        editTexttime=(EditText)findViewById(R.id.editTexttime);


        forceField = (Spinner) findViewById(R.id.forceSpinner);
        distField = (Spinner) findViewById(R.id.distSpinner);
        timeField = (Spinner) findViewById(R.id.timeSpinner);




        ArrayList force = new ArrayList();
        force.add("newton");
        force.add("kilonewton");

        ArrayList dist = new ArrayList();

        dist.add("meter");
        dist.add("kilometer");

        ArrayList time = new ArrayList();
        time.add("second");
        time.add("minute");




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, force);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        forceField.setAdapter(dataAdapter);

        ArrayAdapter<String> tempAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dist);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        distField.setAdapter(tempAdapter);

        ArrayAdapter<String> timeeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, time);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        timeField.setAdapter(timeeAdapter);




        textViewresult=(TextView)findViewById(R.id.textViewResult);
        btnCalculatePower=(Button)findViewById(R.id.btnCalculatePower);
        btnCalculatePower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextforce.getText().toString().trim())) {
                    editTextforce.setError("Enter the force");
                    return;
                }

                if (TextUtils.isEmpty(editTextdistance.getText().toString().trim())) {
                    editTextdistance.setError("enter the distance");
                    return;
                }


                if (TextUtils.isEmpty(editTexttime.getText().toString().trim())) {
                    editTexttime.setError("enter the time");
                    return;
                }




                forceValue=Double.parseDouble(editTextforce.getText().toString().trim());
                distanceValue=Double.parseDouble(editTextdistance.getText().toString().trim());
                timeValue=Double.parseDouble(editTexttime.getText().toString().trim());
                forcespinneValue= forceField.getSelectedItem().toString().trim();
                disspinnerValue=distField.getSelectedItem().toString().trim();
                tineSpinnerValue=timeField.getSelectedItem().toString().trim();




                horsepower=new Horsepower();
                double result=horsepower.calculateHorsepower(forceValue,distanceValue,timeValue,forcespinneValue,disspinnerValue,tineSpinnerValue);

                double powerresult=(result*0.00134102);
                double metricresult=(result*0.001359);
                double electric=(result*0.00130404);
                double boiler=(result*0.0001);



                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.####");
                textViewresult.setText( "The Power is:" +REAL_FORMATTER.format(result)+" watts  " +"\n\n Its equivalent to: " +"\n "+REAL_FORMATTER.format(powerresult)+" mechanical horsepowers "+
                        "\n\n" +REAL_FORMATTER.format(metricresult)+" metric horsepowers "+
                        "\n\n" +REAL_FORMATTER.format(electric)+" electrical horsepowers "+
                        "\n\n" +REAL_FORMATTER.format(boiler)+" boiler horsepowers " );

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
            Intent intent=new Intent(horsePowerCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(horsePowerCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


