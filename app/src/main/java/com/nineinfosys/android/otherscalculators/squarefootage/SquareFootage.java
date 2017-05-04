package com.nineinfosys.android.otherscalculators.squarefootage;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.horsepower.horsePowerCalculator;
import com.nineinfosys.android.otherscalculators.lovecalculator.timeZone;

import java.util.ArrayList;

/**
 * Created by Dev on 03-04-2017.
 */


public class SquareFootage extends AppCompatActivity {
    TextView lengthTextview,widthTextview,radiusTextview,base,height;
    EditText lengthEditText,widthEditText,radiusEdittext;
    Spinner areaField;
    TextView squareFootageValue;
   // sqrFoot sqrFoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.squarefootage);
        MobileAds.initialize(SquareFootage.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewsquareft);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        lengthTextview=(TextView)findViewById(R.id.textViewLength);
        widthTextview=(TextView)findViewById(R.id.textViewWidth);
        lengthEditText=(EditText)findViewById(R.id.editTextLength);
        widthEditText=(EditText)findViewById(R.id.editTextWidth);
        radiusEdittext=(EditText)findViewById(R.id.editTextRadius);

        base=(TextView)findViewById(R.id.textViewbase);
        height=(TextView)findViewById(R.id.textViewheight);

        squareFootageValue=(TextView)findViewById(R.id.textViewSquareFootageValue);
        radiusTextview=(TextView)findViewById(R.id.textViewRadius);
        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);
        areaField = (Spinner) findViewById(R.id.spinnerArea);

        ArrayList area = new ArrayList();
        area.add("Square");
        area.add("Triangle");
        area.add("Rectangle");
        area.add("Circle");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaField.setAdapter(dataAdapter);
areaField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position==0)
        {
            base.setVisibility(View.GONE);
            height.setVisibility(View.GONE);
            widthTextview.setVisibility(View.INVISIBLE);
            widthEditText.setVisibility(View.INVISIBLE);
            radiusTextview.setVisibility(View.INVISIBLE);
            radiusEdittext.setVisibility(View.INVISIBLE);

            lengthTextview.setVisibility(View.VISIBLE);
            lengthEditText.setVisibility(View.VISIBLE);
        }

        if (position==1)
        {


            base.setVisibility(View.VISIBLE);
            height.setVisibility(View.VISIBLE);
            radiusTextview.setVisibility(View.INVISIBLE);
            radiusEdittext.setVisibility(View.INVISIBLE);

            lengthTextview.setVisibility(View.GONE);
            lengthEditText.setVisibility(View.VISIBLE);
            widthTextview.setVisibility(View.GONE);
            widthEditText.setVisibility(View.VISIBLE);
        }
        if (position==2)
        {
            base.setVisibility(View.GONE);
            height.setVisibility(View.GONE);
            radiusTextview.setVisibility(View.INVISIBLE);
            radiusEdittext.setVisibility(View.INVISIBLE);

            lengthTextview.setVisibility(View.VISIBLE);
            lengthEditText.setVisibility(View.VISIBLE);
            widthTextview.setVisibility(View.VISIBLE);
            widthEditText.setVisibility(View.VISIBLE);

        }
        if (position==3)
        {
            base.setVisibility(View.GONE);
            height.setVisibility(View.GONE);
            radiusTextview.setVisibility(View.VISIBLE);
            radiusEdittext.setVisibility(View.VISIBLE);

            lengthTextview.setVisibility(View.INVISIBLE);
            lengthEditText.setVisibility(View.INVISIBLE);
            widthTextview.setVisibility(View.INVISIBLE);
            widthEditText.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for Keybord hiding
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                sqrFoot Calculator = new sqrFoot();

               //    String spinnerArea = areaField.getSelectedItem().toString().trim();

                if (areaField.getSelectedItem().toString().trim().equals("Square")) {


                    if (TextUtils.isEmpty(lengthEditText.getText().toString().trim())) {
                        lengthEditText.setError("enter length");
                        return;
                    }

                    final double lengthValue = Double.parseDouble(lengthEditText.getText().toString().trim());
                    double resultgrossDomesticProductValue = Calculator.square(lengthValue);
                    squareFootageValue.setText(resultgrossDomesticProductValue+" cm²");

                }
                else if (areaField.getSelectedItem().toString().trim().equals("Triangle"))
                {
                    if (TextUtils.isEmpty(lengthEditText.getText().toString().trim())) {
                        lengthEditText.setError("enter length");
                        return;
                    }

                    if (TextUtils.isEmpty(widthEditText.getText().toString().trim())) {
                        widthEditText.setError("enter width");
                        return;
                    }

                    final double lengthValue = Double.parseDouble(lengthEditText.getText().toString().trim());
                        final double widthValue = Double.parseDouble(widthEditText.getText().toString().trim());
                        double resultgrossDomesticProductValue = Calculator.triangle(lengthValue, widthValue);
                        squareFootageValue.setText(resultgrossDomesticProductValue+ " cm²");

                    }else if (areaField.getSelectedItem().toString().trim().equals("Circle")) {

                    if (TextUtils.isEmpty(radiusEdittext.getText().toString().trim())) {
                        radiusEdittext.setError("enter radius");
                        return;
                    }



                    double radiusValue = Double.parseDouble(radiusEdittext.getText().toString().trim());
                        double resultgrossDomesticProductValue = Calculator.circle(radiusValue);
                        squareFootageValue.setText("" + resultgrossDomesticProductValue+ " cm");

                    }else if (areaField.getSelectedItem().toString().trim().equals("Rectangle")) {


                    if (TextUtils.isEmpty(lengthEditText.getText().toString().trim())) {
                        lengthEditText.setError("enter length");
                        return;
                    }

                    if (TextUtils.isEmpty(widthEditText.getText().toString().trim())) {
                        widthEditText.setError("enter width");
                        return;
                    }


                        final double lengthValue = Double.parseDouble(lengthEditText.getText().toString().trim());
                        final double widthValue = Double.parseDouble(widthEditText.getText().toString().trim());

                        double resultgrossDomesticProductValue = Calculator.rectangle(lengthValue, widthValue);
                        squareFootageValue.setText("" + resultgrossDomesticProductValue+ " cm²");
                    }




            }


        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                lengthEditText.getText().clear();
                widthEditText.getText().clear();
                squareFootageValue.setText("");
                radiusEdittext.getText().clear();

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
            Intent intent=new Intent(SquareFootage.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(SquareFootage.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}







