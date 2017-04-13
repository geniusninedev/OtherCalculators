package com.nineinfosys.android.otherscalculators.golfhandicapindex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;

import java.util.ArrayList;

/**
 * Created by Dev on 03-04-2017.
 */

public class Resistor extends AppCompatActivity {
    TextView lengthTextview,diameterTextview,conductivityTextview;
    EditText lengthEditText,diameterEditText,conductivityEditText;
    TextView result;

    TextView result1,lengthUnit,diameterUnit;
   Spinner LenghthUnit;
    resistorCalci resistorValue;
    String Lengthfield;

    double LengthValue,diameterValue,conductivityValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resistor);

        lengthTextview=(TextView)findViewById(R.id.textViewLength);
        diameterTextview=(TextView)findViewById(R.id.textViewDiameter);
        conductivityTextview=(TextView)findViewById(R.id.textViewConductivity);
        result=(TextView)findViewById(R.id.textViewResult);
        result1=(TextView)findViewById(R.id.textViewResult1);

        lengthEditText=(EditText)findViewById(R.id.editTextLength);
        diameterEditText=(EditText)findViewById(R.id.editTextDiameter);
        conductivityEditText=(EditText)findViewById(R.id.editTextConductivity);

        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);
        lengthUnit = (TextView) findViewById(R.id.textViewlength);
        diameterUnit = (TextView) findViewById(R.id.spinnerDiameter);
        LenghthUnit=(Spinner)findViewById(R.id.spinnerUnit);


        ArrayList area = new ArrayList();
        area.add("mile");
        area.add("km");

        area.add("cm");
        area.add("mm");
        area.add("inch");
        area.add("ft");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        LenghthUnit.setAdapter(dataAdapter);
        LenghthUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Lengthfield=  LenghthUnit.getSelectedItem().toString().trim();

                lengthUnit.setText(LenghthUnit.getSelectedItem().toString().trim());
                diameterUnit.setText(LenghthUnit.getSelectedItem().toString().trim());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       /* ArrayList area1 = new ArrayList();

        area1.add("mile");
        area1.add("km");
        area1.add("m");
        area1.add("cm");
        area1.add("mm");
        area1.add("inch");
        area1.add("ft");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, area1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        diameterUnit.setAdapter(dataAdapter1);
*/

        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lengthEditText.getText().toString().trim().equals("")) {
                    lengthEditText.setError("Enter the length");
                } else if (diameterEditText.getText().toString().trim().equals("")) {
                    diameterEditText.setError("Enter Diameter");
                }
                else if (conductivityEditText.getText().toString().trim().equals("")) {
                    conductivityEditText.setError("Enter Conductivity");

                }
                else{


                            //diameterUnit.getSelectedItem().toString().trim());


                  //  result.setText("Resistance of a conductor::" + gfr);




/*

                    if (TextUtils.isEmpty(lengthEditText.getText().toString().trim())) {
                        lengthEditText.setError("Enter the length");
                        return;
                    }

                    if (TextUtils.isEmpty(diameterEditText.getText().toString().trim())) {
                        diameterEditText.setError("Enter Diameter");
                        return;
                    }



                    if (TextUtils.isEmpty(conductivityEditText.getText().toString().trim())) {
                        conductivityEditText.setError("Enter Conductivity");
                        return;
                    }
*/




                    resistorCalci gfr_calci=new resistorCalci();


                      LengthValue=Double.parseDouble(lengthEditText.getText().toString().trim());
                    diameterValue=Double.parseDouble(diameterEditText.getText().toString().trim());
                     conductivityValue=Double.parseDouble(conductivityEditText.getText().toString().trim());




                    double   result=gfr_calci.resistorCalci(LengthValue,diameterValue,conductivityValue,Lengthfield);

                   result1.setText("Resistance Of Conductor: " +result +" Ω");


                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);




                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                lengthEditText.getText().clear();
                diameterEditText.getText().clear();
                conductivityEditText.getText().clear();
                result.setText("");
                result1.setText("");

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
            Intent intent=new Intent(Resistor.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(Resistor.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


