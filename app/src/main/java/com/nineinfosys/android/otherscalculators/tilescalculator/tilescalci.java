package com.nineinfosys.android.otherscalculators.tilescalculator;

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
import com.nineinfosys.android.otherscalculators.horsepower.horsePowerCalculator;
import com.nineinfosys.android.otherscalculators.lovecalculator.timeZone;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class tilescalci extends AppCompatActivity {

    Tile_Calculator tile_calculator;
    EditText editTextLength,editTextwidth;
    TextView TextviewResult;
    Button btnCalculatearea;
    double lengthValue,widthValue;
    Spinner Tilesize;
    String SpinnerValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilescalci);
        MobileAds.initialize(tilescalci.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewtiles);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        editTextLength=(EditText)findViewById(R.id.editTextLength);
        editTextwidth=(EditText)findViewById(R.id.editTextWidth);
        TextviewResult=(TextView)findViewById(R.id.textViewResult);
        Tilesize = (Spinner) findViewById(R.id.tilesize);


        ArrayList Tile = new ArrayList();
        Tile.add("12x12 inch");
        Tile.add("6x6 inch");
        Tile.add("4x4 inch");




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Tile);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Tilesize.setAdapter(dataAdapter);


        btnCalculatearea=(Button)findViewById(R.id.btnCalculatearea);
        btnCalculatearea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextLength.getText().toString().trim())) {
                    editTextLength.setError("enter the length");
                    return;
                }

                if (TextUtils.isEmpty(editTextwidth.getText().toString().trim())) {
                    editTextwidth.setError("enter the width");
                    return;
                }
                lengthValue=Double.parseDouble(editTextLength.getText().toString().trim());
                widthValue=Double.parseDouble(editTextwidth.getText().toString().trim());

                SpinnerValue= Tilesize.getSelectedItem().toString().trim();



                tile_calculator=new Tile_Calculator();
                double area=tile_calculator.area(lengthValue,widthValue);
                double result=tile_calculator.calculateTilearea(lengthValue,widthValue,SpinnerValue);
                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");

              /*  double totaltilesreqiured=result/0.25;
                double foursize=result*9;*/
                TextviewResult.setText( "Total area is : " +REAL_FORMATTER.format(area)+"sq.ft"+"\n\n Approximate Total Tiles Required  : " +REAL_FORMATTER.format(result)+
                        " tiles");



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
            Intent intent=new Intent(tilescalci.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(tilescalci.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



