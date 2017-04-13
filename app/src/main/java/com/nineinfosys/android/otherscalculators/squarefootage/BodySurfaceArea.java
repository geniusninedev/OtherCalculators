package com.nineinfosys.android.otherscalculators.squarefootage;

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

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;

import java.util.ArrayList;

/**
 * Created by Dev on 03-04-2017.
 */

public class BodySurfaceArea extends AppCompatActivity {
    EditText heightIncm, weightInkg;
    TextView resultBodySurfaceArea12;
    BodySurfaceAreaCalculator area;
    //private static final String REQUIRED_MSG = "required";
//    DecimalFormat f = new DecimalFormat("##.00");
Spinner WeightField,Heightfield;
    double heightIncmValue,weightInkgValue;
    String heightvalue, weightvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodysurface);
        heightIncm = (EditText) findViewById(R.id.editTextHeight);
        weightInkg = (EditText) findViewById(R.id.editTextWeight);
        resultBodySurfaceArea12 = (TextView) findViewById(R.id.textViewResult);
        Button Calculate = (Button) findViewById(R.id.CalculateBodySurfceArea);
        Button CalculateClear = (Button) findViewById(R.id.buttonClear);
        WeightField=(Spinner)findViewById(R.id.weightSpinner);
        Heightfield=(Spinner)findViewById(R.id.HeightSpinner) ;

        final ArrayList weight = new ArrayList();
        weight.add("kg");
        weight.add("pounds");


        final ArrayList height = new ArrayList();
        height.add("cm");
        height.add("ft");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, weight);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        WeightField.setAdapter(dataAdapter);

        ArrayAdapter<String> heightAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, height);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Heightfield.setAdapter(heightAdapter);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(heightIncm.getText().toString().trim())) {
                    heightIncm.setError("enter the height");
                    return;
                }
                if (TextUtils.isEmpty(weightInkg.getText().toString().trim())) {
                    weightInkg.setError("enter the weight");
                    return;
                }

                heightIncmValue = Double.parseDouble(heightIncm.getText().toString().trim());

                 weightInkgValue = Double.parseDouble(weightInkg.getText().toString().trim());
              heightvalue = Heightfield.getSelectedItem().toString().trim();
                 weightvalue = WeightField.getSelectedItem().toString().trim();
                area = new BodySurfaceAreaCalculator();
                double result = area.bsaCalculator(heightIncmValue, weightInkgValue,heightvalue,weightvalue);
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                //   String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);
                resultBodySurfaceArea12.setText("Body Surface Area:".toString() + Double.toString((double) result)+ " m²");
                // new DecimalFormat("##.00").format(Double.toString((double) resultBodySurfaceArea));
                //   new DecimalFormat("#.00").format(resultBodySurfaceArea);

            }
        });
        CalculateClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightIncm.getText().clear();
                weightInkg.getText().clear();
                resultBodySurfaceArea12.setText("");


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
            Intent intent=new Intent(BodySurfaceArea.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(BodySurfaceArea.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}