package com.nineinfosys.android.otherscalculators.ohmcalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.gradepointer.averagePointer;
import com.nineinfosys.android.otherscalculators.lovecalculator.LoveCalculator;

public class OhmsLaw_Calculator extends AppCompatActivity {

    EditText editTextVoltage,editTextcurrent,editTextresistance,editTextPower;
    double voltageValue,resistanceValue,currentValue,PowerValue;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohms_law__calculator);
        MobileAds.initialize(OhmsLaw_Calculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewohmslaw);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        editTextVoltage=(EditText) findViewById(R.id.editTextvoltage);
        editTextcurrent=(EditText)findViewById(R.id.editTextcurrent);
        editTextresistance=(EditText)findViewById(R.id.editTextresistance);
        editTextPower=(EditText)findViewById(R.id.editTextpower);
        btncalculate=(Button)findViewById(R.id.btnCalculatecost);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ohm ohm = new Ohm();

                if (TextUtils.isEmpty(editTextVoltage.getText().toString().trim())&&TextUtils.isEmpty(editTextresistance.getText().toString().trim())&&TextUtils.isEmpty(editTextcurrent.getText().toString().trim())) {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextPower.getText().toString().trim())&&TextUtils.isEmpty(editTextresistance.getText().toString().trim())&&TextUtils.isEmpty(editTextcurrent.getText().toString().trim())) {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(editTextVoltage.getText().toString().trim())&&TextUtils.isEmpty(editTextresistance.getText().toString().trim())&&TextUtils.isEmpty(editTextPower.getText().toString().trim())) {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(editTextVoltage.getText().toString().trim())&&TextUtils.isEmpty(editTextcurrent.getText().toString().trim())&&TextUtils.isEmpty(editTextPower.getText().toString().trim())) {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                    return;
                }

                if(editTextresistance.getText().toString().trim().equals("")&& editTextPower.getText().toString().trim().equals("")) {


                    currentValue=Double.parseDouble(editTextcurrent.getText().toString().trim());
                    voltageValue=Double.parseDouble(editTextVoltage.getText().toString().trim());


                    double result = ohm.calculateResistanceFromVoltagecurrent(voltageValue, currentValue);
                    double watt = ohm.calculatePowerFromVoltagecurrent(voltageValue, currentValue);
                    editTextresistance.setText(String.valueOf(result));
                    editTextPower.setText(String.valueOf(watt));

                }

                else if(editTextVoltage.getText().toString().trim().equals("")&& editTextcurrent.getText().toString().trim().equals(""))

                {
                    PowerValue=Double.parseDouble(editTextPower.getText().toString().trim());
                    resistanceValue=Double.parseDouble(editTextresistance.getText().toString().trim());

                    double vtg = ohm.calculateVoltageFromResistancepower(PowerValue, resistanceValue);
                    double curr = ohm.calculateCurrentFromPowerResistance(PowerValue, resistanceValue);
                    editTextVoltage.setText(String.valueOf(vtg));
                    editTextcurrent.setText(String.valueOf(curr));

                }
                else if(editTextcurrent.getText().toString().trim().equals("")&& editTextresistance.getText().toString().trim().equals(""))

                {
                    PowerValue=Double.parseDouble(editTextPower.getText().toString().trim());
                    voltageValue=Double.parseDouble(editTextVoltage.getText().toString().trim());

                    double curr = ohm.calculateCurrentFromVoltagePower(PowerValue, voltageValue);
                    double res = ohm.calculateResistanceFromVoltagepower(PowerValue, voltageValue);
                    editTextcurrent.setText(String.valueOf(curr));
                    editTextresistance.setText(String.valueOf(res));

                }

                else if(editTextcurrent.getText().toString().trim().equals("")&& editTextPower.getText().toString().trim().equals(""))

                {

                    voltageValue=Double.parseDouble(editTextVoltage.getText().toString().trim());
                    resistanceValue=Double.parseDouble(editTextresistance.getText().toString().trim());

                    double cur = ohm.calculateCurrentFromVoltageResistance(voltageValue, resistanceValue);
                    double pow = ohm.calculatePowerFromVoltageresistance(voltageValue, resistanceValue);
                    editTextcurrent.setText(String.valueOf(cur));
                    editTextPower.setText(String.valueOf(pow));

                }


                else if(editTextVoltage.getText().toString().trim().equals("")&& editTextresistance.getText().toString().trim().equals(""))

                {
                    currentValue=Double.parseDouble(editTextcurrent.getText().toString().trim());
                    PowerValue=Double.parseDouble(editTextPower.getText().toString().trim());

                    double vtg = ohm.calculateVoltageFromCurrentpower(currentValue, PowerValue);
                    double res = ohm.calculateResistanceFromCurrentpower(currentValue, PowerValue);
                    editTextVoltage.setText(String.valueOf(vtg));
                    editTextresistance.setText(String.valueOf(res));

                }


                else if(editTextVoltage.getText().toString().trim().equals("")&& editTextPower.getText().toString().trim().equals(""))

                {
                    currentValue=Double.parseDouble(editTextcurrent.getText().toString().trim());
                    resistanceValue=Double.parseDouble(editTextresistance.getText().toString().trim());

                    double vtg = ohm.calculateVoltageFromCurrentResistance(currentValue, resistanceValue);
                    double pow = ohm.calculatePowerFromResistancecurrent(currentValue, resistanceValue);
                    editTextVoltage.setText(String.valueOf(vtg));
                    editTextPower.setText(String.valueOf(pow));

                }


                else if(editTextVoltage.getText().toString().trim().equals(""))

                {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                }

                else if(editTextcurrent.getText().toString().trim().equals(""))

                {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                }


                else if(editTextPower.getText().toString().trim().equals(""))

                {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                }



                else if(editTextresistance.getText().toString().trim().equals(""))

                {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();

                }

                else if(!editTextVoltage.getText().toString().trim().equals("")&& !editTextPower.getText().toString().trim().equals("")&&!editTextcurrent.getText().toString().trim().equals("")&& !editTextresistance.getText().toString().trim().equals(""))

                {
                    Toast.makeText(OhmsLaw_Calculator.this,"Please provide any two values",Toast.LENGTH_SHORT).show();


                }


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
            Intent intent=new Intent(OhmsLaw_Calculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(OhmsLaw_Calculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


