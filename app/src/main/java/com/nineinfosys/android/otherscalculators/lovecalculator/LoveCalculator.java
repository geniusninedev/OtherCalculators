package com.nineinfosys.android.otherscalculators.lovecalculator;

import android.content.Context;
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
import android.widget.TextView;

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

public class LoveCalculator extends AppCompatActivity {
    EditText editTextYourName,editTextParnerName;
    Button btnCalculateLove;
    TextView textViewResult;
    Love_Calculator love_calculator;
    String yourname,partnername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_calculator);


        editTextYourName=(EditText)findViewById(R.id.editTextyourName);
        editTextParnerName=(EditText)findViewById(R.id.editTextpartnerName);

        btnCalculateLove=(Button)findViewById(R.id.btnCalculateLove);
        textViewResult=(TextView)findViewById(R.id.textViewResult);

        btnCalculateLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (TextUtils.isEmpty(editTextYourName.getText().toString().trim())) {
                    editTextYourName.setError("Enter Your Name");
                    return;
                }

                if (TextUtils.isEmpty(editTextParnerName.getText().toString().trim())) {
                    editTextParnerName.setError("Enter Partner Name ");
                    return;
                }

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



                yourname=editTextYourName.getText().toString().trim();
                partnername=editTextParnerName.getText().toString().trim();
                love_calculator=new Love_Calculator(yourname,partnername);
                int lovepercent=love_calculator.CalculateLove();
                textViewResult.setText(String.valueOf("The Love Between " +yourname+ "  and  " +   partnername  +" is " +  lovepercent  + " % "));


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
            Intent intent=new Intent(LoveCalculator.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(
                        LoveCalculator.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
