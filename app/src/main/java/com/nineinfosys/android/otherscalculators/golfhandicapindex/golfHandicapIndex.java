package com.nineinfosys.android.otherscalculators.golfhandicapindex;

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
import com.nineinfosys.android.otherscalculators.fuelmileagecalculator.fuelMileage;
import com.nineinfosys.android.otherscalculators.horsepower.horsePowerCalculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;

import java.text.DecimalFormat;

public class golfHandicapIndex extends AppCompatActivity {
    EditText Score,course_Rating,slope_Rating,Score1,course_Rating1,slope_Rating1,Score2,course_Rating2,slope_Rating2,Score3,course_Rating3,slope_Rating3,Score4,course_Rating4,slope_Rating4;
    TextView textresult,textresult1,textresult2,textresult3,textresult4,Diffrential;
    Button btnCalculate;

    double ScoreValue,CourseValue,slopeValue,ScoreValue1,CourseValue1,slopeValue1,ScoreValue2,CourseValue2,slopeValue2,ScoreValue3,CourseValue3,slopeValue3,ScoreValue4,CourseValue4,slopeValue4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf_handicap_index);


        MobileAds.initialize(golfHandicapIndex.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView)this.findViewById(R.id.adViewgolfhandi);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Score=(EditText)findViewById(R.id.score1);
        course_Rating=(EditText)findViewById(R.id.courseRating1);
        slope_Rating=(EditText)findViewById(R.id.slopeRating1);

        Score1=(EditText)findViewById(R.id.score2);
        course_Rating1=(EditText)findViewById(R.id.courseRating2);
        slope_Rating1=(EditText)findViewById(R.id.slopeRating2);

        Score2=(EditText)findViewById(R.id.score3);
        course_Rating2=(EditText)findViewById(R.id.courseRating3);
        slope_Rating2=(EditText)findViewById(R.id.slopeRating3);

        Score3=(EditText)findViewById(R.id.score4);
        course_Rating3=(EditText)findViewById(R.id.courseRating4);
        slope_Rating3=(EditText)findViewById(R.id.slopeRating4);

        Score4=(EditText)findViewById(R.id.score5);
        course_Rating4=(EditText)findViewById(R.id.courseRating5);
        slope_Rating4=(EditText)findViewById(R.id.slopeRating5);


        Diffrential=(TextView)findViewById(R.id.sumOfdiffrential);





        textresult=(TextView)findViewById(R.id.diff1);
        textresult1=(TextView)findViewById(R.id.diff2);
        textresult2=(TextView)findViewById(R.id.diff3);
        textresult3=(TextView)findViewById(R.id.diff4);
        textresult4=(TextView)findViewById(R.id.diff5);


        btnCalculate=(Button)findViewById(R.id.calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(Score.getText().toString().trim())) {
                    Score.setError("Enter all round score");
                    return;
                }

                if (TextUtils.isEmpty(slope_Rating.getText().toString().trim())) {
                    slope_Rating.setError("Enter all Slope Rating ");
                    return;
                }


                if (TextUtils.isEmpty(course_Rating.getText().toString().trim())) {
                    course_Rating.setError("Enter all course Rating");
                    return;
                }


                if (TextUtils.isEmpty(slope_Rating.getText().toString().trim())) {
                    slope_Rating.setError("Enter Score");
                    return;
                }

                //

                if (TextUtils.isEmpty(Score1.getText().toString().trim())) {
                    Score1.setError("Enter Credit");
                    return;
                }

                if (TextUtils.isEmpty(course_Rating1.getText().toString().trim())) {
                    course_Rating1.setError("Enter Score");
                    return;
                }


                if (TextUtils.isEmpty(slope_Rating1.getText().toString().trim())) {
                    slope_Rating1.setError("Enter Credit");
                    return;
                }


                if (TextUtils.isEmpty(Score2.getText().toString().trim())) {
                    Score2.setError("Enter Score");
                    return;
                }


                if (TextUtils.isEmpty(course_Rating2.getText().toString().trim())) {
                    course_Rating2.setError("Enter Credit");
                    return;
                }

                if (TextUtils.isEmpty(slope_Rating2.getText().toString().trim())) {
                    slope_Rating2.setError("Enter Score");
                    return;
                }


                if (TextUtils.isEmpty(Score3.getText().toString().trim())) {
                    Score3.setError("Enter Credit");
                    return;
                }


                if (TextUtils.isEmpty(course_Rating3.getText().toString().trim())) {
                    course_Rating3.setError("Enter Score");
                    return;
                }

                if (TextUtils.isEmpty(slope_Rating3.getText().toString().trim())) {
                    slope_Rating3.setError("Enter Score");
                    return;
                }


                if (TextUtils.isEmpty(Score4.getText().toString().trim())) {
                    Score3.setError("Enter Credit");
                    return;
                }


                if (TextUtils.isEmpty(course_Rating4.getText().toString().trim())) {
                    course_Rating3.setError("Enter Score");
                    return;
                }

                if (TextUtils.isEmpty(slope_Rating4.getText().toString().trim())) {
                    slope_Rating3.setError("Enter Score");
                    return;
                }



                ScoreValue=Double.parseDouble(Score.getText().toString().trim());
                CourseValue=Double.parseDouble(course_Rating.getText().toString().trim());
                slopeValue=Double.parseDouble(course_Rating.getText().toString().trim());

                ScoreValue1=Double.parseDouble(Score1.getText().toString().trim());
                CourseValue1=Double.parseDouble(course_Rating1.getText().toString().trim());
                slopeValue1=Double.parseDouble(course_Rating1.getText().toString().trim());

                ScoreValue2=Double.parseDouble(Score2.getText().toString().trim());
                CourseValue2=Double.parseDouble(course_Rating2.getText().toString().trim());
                slopeValue2=Double.parseDouble(course_Rating2.getText().toString().trim());

                ScoreValue3=Double.parseDouble(Score3.getText().toString().trim());
                CourseValue3=Double.parseDouble(course_Rating3.getText().toString().trim());
                slopeValue3=Double.parseDouble(course_Rating3.getText().toString().trim());


                ScoreValue4=Double.parseDouble(Score4.getText().toString().trim());
                CourseValue4=Double.parseDouble(course_Rating4.getText().toString().trim());
                slopeValue4=Double.parseDouble(course_Rating4.getText().toString().trim());





                golf_Handicap golf = new golf_Handicap(ScoreValue,CourseValue,slopeValue);


                DecimalFormat REAL_FORMATTER = new DecimalFormat("0.##");

                double result=golf.Calculate_Handicap_Golf();
                double result1=golf.Calculate_Handicap_Golf1(ScoreValue1,CourseValue1,slopeValue1);
                double result2=golf.Calculate_Handicap_Golf2(ScoreValue2,CourseValue2,slopeValue2);
                double result3=golf.Calculate_Handicap_Golf3(ScoreValue3,CourseValue3,slopeValue3);
                double result4=golf.Calculate_Handicap_Golf4(ScoreValue4,CourseValue4,slopeValue4);



                textresult.setText("" +REAL_FORMATTER.format(result));
                textresult1.setText("" +REAL_FORMATTER.format(result1));
                textresult2.setText("" +REAL_FORMATTER.format(result2));
                textresult3.setText("" +REAL_FORMATTER.format(result3));

                textresult4.setText("" +REAL_FORMATTER.format(result4));

                double add=result + result1 + result2 + result3 + result4;
                double HandicapIndex=add/5;

                Diffrential.setText("Average diffrential of Each Round "+REAL_FORMATTER.format(add)+"\n\nHandicap Index is "+REAL_FORMATTER.format(HandicapIndex));

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
            Intent intent=new Intent(golfHandicapIndex.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(golfHandicapIndex.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



