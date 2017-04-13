package com.nineinfosys.android.otherscalculators.gradepointer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.golfhandicapindex.Resistor;

import java.text.DecimalFormat;

/**
 * Created by Dev on 03-04-2017.
 */

public class Grade extends AppCompatActivity {

    private Button btnSubmit;

    private Spinner grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8;
    private double vgrade1=0.0,vgrade2=0.0,vgrade3=0.0,vgrade4=0.0,vgrade5=0.0,vgrade6=0.0,vgrade7=0.0,vgrade8=0.0;

    private Spinner hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8;
    private double vhour1=0.0,vhour2=0.0,vhour3=0.0,vhour4=0.0,vhour5=0.0,vhour6=0.0,vhour7=0.0,vhour8=0.0;

    private double gpoint1=0.0,gpoint2=0.0,gpoint3=0.0,gpoint4=0.0,gpoint5=0.0,gpoint6=0.0,gpoint7=0.0,gpoint8=0.0;


    public EditText lastCGPA,lastchour;
    private double lastgpoint = 0.0;


    private double currentpoint = 0.0;
    private double currentHour = 0.0;

    // store final grades/points etc.
    private double finalgpoint = 0.0;
    private double finalGPA = 0.0;
    private double finalCGPA = 0.0;
    private double finalchour = 0.0;

    private static final int DIALOG_ALERT = 10;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        btnSubmit = (Button) findViewById(R.id.calculate);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                retrieve();

                Calculate();

                showDialog(DIALOG_ALERT);

            }

        });

    }

    public void retrieve(){

        grade1 = (Spinner) findViewById(R.id.spinner1);
        grade2 = (Spinner) findViewById(R.id.spinner2);
        grade3 = (Spinner) findViewById(R.id.spinner3);
        grade4 = (Spinner) findViewById(R.id.spinner4);
        grade5 = (Spinner) findViewById(R.id.spinner5);
        grade6 = (Spinner) findViewById(R.id.spinner6);
        grade7 = (Spinner) findViewById(R.id.spinner7);
        grade8 = (Spinner) findViewById(R.id.spinner8);

        hour1 = (Spinner) findViewById(R.id.chour1);
        hour2 = (Spinner) findViewById(R.id.chour2);
        hour3 = (Spinner) findViewById(R.id.chour3);
        hour4 = (Spinner) findViewById(R.id.chour4);
        hour5 = (Spinner) findViewById(R.id.chour5);
        hour6 = (Spinner) findViewById(R.id.chour6);
        hour7 = (Spinner) findViewById(R.id.chour7);
        hour8 = (Spinner) findViewById(R.id.chour8);


        vgrade1 = convertGrade(String.valueOf(grade1.getSelectedItem()));
        vgrade2 = convertGrade(String.valueOf(grade2.getSelectedItem()));
        vgrade3 = convertGrade(String.valueOf(grade3.getSelectedItem()));
        vgrade4 = convertGrade(String.valueOf(grade4.getSelectedItem()));
        vgrade5 = convertGrade(String.valueOf(grade5.getSelectedItem()));
        vgrade6 = convertGrade(String.valueOf(grade6.getSelectedItem()));
        vgrade7 = convertGrade(String.valueOf(grade7.getSelectedItem()));
        vgrade8 = convertGrade(String.valueOf(grade8.getSelectedItem()));


        vhour1 = convertDouble(String.valueOf(hour1.getSelectedItem()));
        vhour2 = convertDouble(String.valueOf(hour2.getSelectedItem()));
        vhour3 = convertDouble(String.valueOf(hour3.getSelectedItem()));
        vhour4 = convertDouble(String.valueOf(hour4.getSelectedItem()));
        vhour5 = convertDouble(String.valueOf(hour5.getSelectedItem()));
        vhour6 = convertDouble(String.valueOf(hour6.getSelectedItem()));
        vhour7 = convertDouble(String.valueOf(hour7.getSelectedItem()));
        vhour8 = convertDouble(String.valueOf(hour8.getSelectedItem()));

    }

    public void Calculate(){

        gpoint1 = vgrade1*vhour1;
        gpoint2 = vgrade2*vhour2;
        gpoint3 = vgrade3*vhour3;
        gpoint4 = vgrade4*vhour4;
        gpoint5 = vgrade5*vhour5;
        gpoint6 = vgrade6*vhour6;
        gpoint7 = vgrade7*vhour7;
        gpoint8 = vgrade8*vhour8;


        // Last semester CGPA and Total Credit Hours
        lastCGPA = (EditText) findViewById(R.id.currentCGPA);
        lastchour = (EditText) findViewById(R.id.currentCredit);


        // Grade Points for last semester
        // CGPA = lastgpoint/lastchour
        lastgpoint = convertDouble((lastCGPA.getText().toString())) * convertDouble((lastchour.getText().toString())) ;


        //  Grade Points for current semester
        currentpoint =  gpoint1 + gpoint2 + gpoint3 + gpoint4 + gpoint5 + gpoint6 + gpoint7 + gpoint8;
        // Credit Hours for this semester
        currentHour = vhour1 + vhour2 + vhour3 + vhour4 + vhour5 + vhour6 + vhour7 + vhour8;


        //  Grade Points (Current Points + Previous Points)
        finalgpoint += currentpoint + lastgpoint;
        // To find Accumulated Credit Hours (Current cHours + Previous cHours)
        finalchour +=  currentHour + convertDouble((lastchour.getText().toString()));

        // final GPA
        // GPA = (Current Semester Grade Points) /  (Current Semester Credit hours)
        finalGPA = currentpoint /  currentHour;

        // final CGPA
        // CGPA = Total Accumulated Points / Total Accumulated Credit Hours
        finalCGPA= finalgpoint/finalchour;

    }


    public double convertGrade(String grade){
        double cgrade = 0.0;

        if(grade.equals("A+")){
            cgrade = 4.0;
        } else if(grade.equals("A-")){
            cgrade = 3.75;
        } else if(grade.equals("B+")){
            cgrade = 3.5;
        } else if(grade.equals("B")) {
            cgrade = 3.0;
        } else if(grade.equals("C+")){
            cgrade = 2.5;
        } else if(grade.equals("C")){
            cgrade = 2.0;
        } else if(grade.equals("D+")){
            cgrade = 1.5;
        } else if(grade.equals("D")) {
            cgrade = 1.0;
        } else if(grade.equals("F")) {
            cgrade = 0.0;
        } else {
            cgrade = 0.0;
        }

        return cgrade;
    }


    public double convertDouble(String hour){
        double chour = 0.0;

        try {
            String eAm = hour;
            DecimalFormat dF = new DecimalFormat("0.00");
            Number num = dF.parse(eAm);
            chour = num.doubleValue();
        } catch (Exception e) {
            chour = 0.0;
        }

        return chour;
    }



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_ALERT:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                DecimalFormat df = new DecimalFormat("0.00");
                DecimalFormat nf = new DecimalFormat("0");

                info = "Total Credit Hours : " + nf.format(finalchour)
                        + "\nTotal Grade Points : " + df.format(finalgpoint)
                        + "\nYour GPA  : " + df.format(finalGPA)
                        + "\nYour CGPA  : " + df.format(finalCGPA);

                builder.setMessage(info);
                builder.setCancelable(true);
             //   builder.setPositiveButton("Exit",/*(DialogInterface.OnClickListener) new Intent(Grade.this,MainActivity.class)*/);
                builder.setNegativeButton("Go Back", new backListener());
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    private final class backListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            reset();
            //Toast.makeText(getApplicationContext(), "Calculate Another CGPA :)",
                  //  Toast.LENGTH_LONG).show();
        }
    }

    private final class exitListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Grade.this.finish();
        }
    }


    private void reset(){
        vgrade1=0.0;vgrade2=0.0;vgrade3=0.0;vgrade4=0.0;vgrade5=0.0;vgrade6=0.0;vgrade7=0.0;vgrade8=0.0;

        vhour1=0.0;vhour2=0.0;vhour3=0.0;vhour4=0.0;vhour5=0.0;vhour6=0.0;vhour7=0.0;vhour8=0.0;

        gpoint1=0.0;gpoint2=0.0;gpoint3=0.0;gpoint4=0.0;gpoint5=0.0;gpoint6=0.0;gpoint7=0.0;gpoint8=0.0;

        lastgpoint = 0.0;

        currentpoint = 0.0;
        currentHour = 0.0;

        finalgpoint = 0.0;
        finalGPA = 0.0;
        finalCGPA = 0.0;
        finalchour = 0.0;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(Grade.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(Grade.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

