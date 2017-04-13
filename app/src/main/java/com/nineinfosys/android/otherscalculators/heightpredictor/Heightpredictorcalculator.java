package com.nineinfosys.android.otherscalculators.heightpredictor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.nineinfosys.android.otherscalculators.lovecalculator.LoveCalculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Heightpredictorcalculator extends AppCompatActivity {
    EditText editTextchildHeight,editTextchildAge,editTextmotherHeight,editTextfatherHeight;

    TextView textViewresult,malecmValue,malefeetValue,femalecmValue,femalefeetValue;
    Button btnCalculate;
    double ChildHeight,Childage,MotherHeight,FatherHeight;

    TextView ageField,motherField,fatherField;
    Spinner UnitField;
    String Agevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_predictor);

        editTextchildHeight=(EditText)findViewById(R.id.editTextchildHeight);
        editTextchildAge=(EditText)findViewById(R.id.editTextchildAge);
        editTextmotherHeight=(EditText)findViewById(R.id.editTextmotherheight);
        editTextfatherHeight=(EditText)findViewById(R.id.editTextfatherheight);

        ageField = (TextView) findViewById(R.id.childSpinner);
        motherField = (TextView) findViewById(R.id.motherSpinner);
        fatherField = (TextView) findViewById(R.id.fatherSpinner);
        UnitField = (Spinner) findViewById(R.id.unitspinner);



        final ArrayList Age = new ArrayList();
        Age.add("cm");
        Age.add("ft");

       /* final ArrayList Mother = new ArrayList();

        Mother.add("Centimeters");
        Mother.add("Foot");

        final ArrayList father = new ArrayList();
        father.add("Centimeters");
        father.add("Foot");
*/



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Age);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        UnitField.setAdapter(dataAdapter);

      /*  ArrayAdapter<String> tempAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Mother);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motherField.setAdapter(tempAdapter);

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, father);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fatherField.setAdapter(timeAdapter);*/





        malecmValue=(TextView)findViewById(R.id.malecmValue);
        malefeetValue=(TextView)findViewById(R.id.malefeetValue);

        femalecmValue=(TextView)findViewById(R.id.femalecmValue);
        femalefeetValue=(TextView)findViewById(R.id.femalefeetValue);



        UnitField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Agevalue= UnitField.getSelectedItem().toString().trim();
                ageField.setText(UnitField.getSelectedItem().toString().trim());
                motherField.setText(UnitField.getSelectedItem().toString().trim());
                fatherField.setText(UnitField.getSelectedItem().toString().trim());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        btnCalculate=(Button)findViewById(R.id.btnCalculateHeight);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(editTextchildHeight.getText().toString().trim())) {
                    editTextchildHeight.setError("Current Height Of child");
                    return;
                }

                if (TextUtils.isEmpty(editTextchildAge.getText().toString().trim())) {
                    editTextchildAge.setError("Enter the Age");
                    return;
                }



                if (TextUtils.isEmpty(editTextmotherHeight.getText().toString().trim())) {
                    editTextmotherHeight.setError("Enter Mother Height in cm");
                    return;
                }

                if (TextUtils.isEmpty(editTextfatherHeight.getText().toString().trim())) {
                    editTextfatherHeight.setError("Enter Father Height in cm");
                    return;
                }

                ChildHeight=Double.parseDouble(editTextchildHeight.getText().toString().trim());
                Childage=Double.parseDouble(editTextchildAge.getText().toString().trim());

                MotherHeight=Double.parseDouble(editTextmotherHeight.getText().toString().trim());
                FatherHeight=Double.parseDouble(editTextfatherHeight.getText().toString().trim());




                HeightPredictor height = new HeightPredictor();
                double   result=height.CalculateboyHeight(ChildHeight,Childage,MotherHeight,FatherHeight,Agevalue);
                double girlheight=height.CalculategirlHeight(ChildHeight,Childage,MotherHeight,FatherHeight,Agevalue);
              /*  double  result=(MotherHeight+FatherHeight+13.70)/2;
                double  girlheight=(MotherHeight+FatherHeight-13)/2;*/


                DecimalFormat REAL = new DecimalFormat("0.#");

                malecmValue.setText(""+ REAL.format(result));
                femalecmValue.setText(""+REAL.format(girlheight));

                malefeetValue.setText(""+ REAL.format(result*0.03280));
                femalefeetValue.setText(""+ REAL.format(girlheight*0.03280));

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
            Intent intent=new Intent(Heightpredictorcalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(Heightpredictorcalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

