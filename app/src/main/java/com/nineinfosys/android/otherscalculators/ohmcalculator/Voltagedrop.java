package com.nineinfosys.android.otherscalculators.ohmcalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.gradepointer.Grade;
import com.nineinfosys.android.otherscalculators.squarefootage.BodySurfaceArea;

/**
 * Created by Dev on 03-04-2017.
 */

public class Voltagedrop extends AppCompatActivity {
    TextView currentTextView,resistanceTextView,distanceTextView;

    EditText currentEditText,resistanceEditText,distanceEditText;


    TextView voltageDropCalculatorResult;
    voltageDropCalculator voltageDropCalculatorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voltagedrop);
        currentTextView=(TextView)findViewById(R.id.textViewCurrent);
        resistanceTextView=(TextView)findViewById(R.id.textViewResistance);
        distanceTextView=(TextView)findViewById(R.id.textViewDistance);

        currentEditText=(EditText)findViewById(R.id.editTextCurrent);
        resistanceEditText=(EditText)findViewById(R.id.editTextResistance);
        distanceEditText=(EditText)findViewById(R.id.editTextDistance);

        voltageDropCalculatorResult=(TextView)findViewById(R.id.textViewResult);
        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);
        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(currentEditText.getText().toString().trim())) {
                    currentEditText.setError("enter the current");
                    return;
                }
                if (TextUtils.isEmpty(resistanceEditText.getText().toString().trim())) {
                    resistanceEditText.setError("enter the resistance");
                    return;
                }
                if (TextUtils.isEmpty(distanceEditText.getText().toString().trim())) {
                    distanceEditText.setError("enter the distance");
                    return;
                }


                double distanceValue=Double.parseDouble(distanceEditText.getText().toString().trim());

                double currentValue=Double.parseDouble(currentEditText.getText().toString().trim());
                double resistanceValue=Double.parseDouble(resistanceEditText.getText().toString().trim());


                String distanceValue1 = Double.toString((double) distanceValue);
                String currentValue1 = Double.toString((double) currentValue);
                String resistanceValue1 = Double.toString((double) resistanceValue);

                voltageDropCalculatorValue=new voltageDropCalculator(currentValue,distanceValue,resistanceValue);
                double voltageDropCalculatorResultValue=voltageDropCalculatorValue.voltageCalculator();
                //   String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);
                voltageDropCalculatorResult.setText( "Voltage Drop  Value:".toString()+Double.toString((double) voltageDropCalculatorResultValue));
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distanceEditText.getText().clear();
                currentEditText.getText().clear();
                resistanceEditText.getText().clear();

                voltageDropCalculatorResult.setText("");


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
            Intent intent=new Intent(Voltagedrop.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(Voltagedrop.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



