package com.nineinfosys.android.otherscalculators.gradepointer;

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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.fuelcostcalculator.FuelCostCalculator;
import com.nineinfosys.android.otherscalculators.horsepower.horsePowerCalculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;

public class averagePointer extends AppCompatActivity {


    EditText Credit,Score,creditsecond,scoresecond,creditthird,scorethird,creditFourth,scoreFourth,creditFifth,scoreFifth;
    TextView Grade_Point,Grade_Point2,Grade_Point3,Grade_Point4,Grade_Point5,TotalCredit;
    double CreditValue,ScoreValue,CreditValue2,ScoreValue2,CreditValue3,ScoreValue3 ,CreditValue4,ScoreValue4,CreditValue5,ScoreValue5;
    Button Calculate;
    double grade_point,grade_point2,grade_point3,grade_point4,grade_point5,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_pointer);

        MobileAds.initialize(averagePointer.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewaverage);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Credit=(EditText)findViewById(R.id.credit);
        Score=(EditText)findViewById(R.id.score);
        Grade_Point=(TextView)findViewById(R.id.gradepoint);

        creditsecond=(EditText)findViewById(R.id.creditsecond);
        scoresecond=(EditText)findViewById(R.id.scoresecond);
        Grade_Point2=(TextView) findViewById(R.id.gradepointseconf);

        creditthird=(EditText)findViewById(R.id.creditthird);
        scorethird=(EditText)findViewById(R.id.scorethird);
        Grade_Point3=(TextView) findViewById(R.id.gradepointthird);

        creditFourth=(EditText)findViewById(R.id.creditfourth);
        scoreFourth=(EditText)findViewById(R.id.scorefourth);
        Grade_Point4=(TextView) findViewById(R.id.gradepointfourth);

        creditFifth=(EditText)findViewById(R.id.creditfifth);
        scoreFifth=(EditText)findViewById(R.id.scorefifth);
        Grade_Point5=(TextView) findViewById(R.id.gradepointfifth);
        TotalCredit=(TextView)findViewById(R.id.totalcredit);



        Calculate=(Button)findViewById(R.id.calculate);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(Credit.getText().toString().trim())) {
                    Credit.setError("Enter Credit");
                    return;
                }

                if (TextUtils.isEmpty(Score.getText().toString().trim())) {
                    Score.setError("Enter Score");
                    return;
                }


                if (TextUtils.isEmpty(creditsecond.getText().toString().trim())) {
                    creditsecond.setError("Enter Credit");
                    return;
                }


                if (TextUtils.isEmpty(scoresecond.getText().toString().trim())) {
                    scoresecond.setError("Enter Score");
                    return;
                }

                //

                if (TextUtils.isEmpty(creditthird.getText().toString().trim())) {
                    creditthird.setError("Enter Credit");
                    return;
                }

                if (TextUtils.isEmpty(scorethird.getText().toString().trim())) {
                    scorethird.setError("Enter Score");
                    return;
                }


                if (TextUtils.isEmpty(creditFourth.getText().toString().trim())) {
                    creditthird.setError("Enter Credit");
                    return;
                }


                if (TextUtils.isEmpty(creditFourth.getText().toString().trim())) {
                    scoresecond.setError("Enter Score");
                    return;
                }



                CreditValue=Double.parseDouble(Credit.getText().toString().trim());
                ScoreValue=Double.parseDouble(Score.getText().toString().trim());

                CreditValue2=Double.parseDouble(creditsecond.getText().toString().trim());
                ScoreValue2=Double.parseDouble(scoresecond.getText().toString().trim());

                CreditValue3=Double.parseDouble(creditthird.getText().toString().trim());
                ScoreValue3=Double.parseDouble(scorethird.getText().toString().trim());

                CreditValue4=Double.parseDouble(creditFourth.getText().toString().trim());
                ScoreValue4=Double.parseDouble(scoreFourth.getText().toString().trim());


                CreditValue5=Double.parseDouble(creditFifth.getText().toString().trim());
                ScoreValue5=Double.parseDouble(scoreFifth.getText().toString().trim());




                GPA_Calci GPA = new GPA_Calci(CreditValue,ScoreValue);

                double add = (CreditValue+CreditValue2+ CreditValue3+ CreditValue4+ CreditValue5);



                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");
                grade_point=GPA.cal_GPA();
                grade_point2=GPA.secondgradepoint(CreditValue2,ScoreValue2);
                grade_point3=GPA.thirdgradepoint(CreditValue3,ScoreValue3);
                grade_point4=GPA.fourthgradepoint(CreditValue4,ScoreValue4);
                grade_point5=GPA.fifthgradepoint(CreditValue5,ScoreValue5);

                double gradepointadd = (grade_point+grade_point2+ grade_point3+ grade_point4+ grade_point5);

                Grade_Point.setText("" +REAL_FORMATTER.format(grade_point));
                Grade_Point2.setText(""+REAL_FORMATTER.format(grade_point2));
                Grade_Point3.setText(""+REAL_FORMATTER.format(grade_point3));
                Grade_Point4.setText(""+REAL_FORMATTER.format(grade_point4));
                Grade_Point5.setText(""+REAL_FORMATTER.format(grade_point5));


                double gpa=(gradepointadd/add);

                TotalCredit.setText("Total Credit: " +REAL_FORMATTER.format(add)+"\nTotal Grade Point: " +REAL_FORMATTER.format(gradepointadd)+"\nGPA Is:"+REAL_FORMATTER.format(gpa));
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
            Intent intent=new Intent(averagePointer.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(averagePointer.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



