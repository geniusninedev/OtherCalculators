package com.nineinfosys.android.otherscalculators.lovecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.nineinfosys.android.otherscalculators.MainActivity;
import com.nineinfosys.android.otherscalculators.R;
import com.nineinfosys.android.otherscalculators.squarefootage.BodySurfaceArea;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Dev on 05-04-2017.
 */

public class timeZone  extends AppCompatActivity{
    private Spinner spinnerAvailableID;
    private Calendar current;
    private TextView textTimeZone, txtCurrentTime, txtTimeZoneTime;
    private long miliSeconds;
    private ArrayAdapter<String> idAdapter;
    private SimpleDateFormat sdf;
    private Date resultdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.timezone);

        spinnerAvailableID = (Spinner) findViewById(R.id.availableID);

        textTimeZone = (TextView) findViewById(R.id.timezone);
        txtCurrentTime = (TextView) findViewById(R.id.txtCurrentTime);
        txtTimeZoneTime = (TextView) findViewById(R.id.txtTimeZoneTime);

        String[] idArray = TimeZone.getAvailableIDs();

        sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");

        idAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idArray);

        idAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAvailableID.setAdapter(idAdapter);

        getGMTTime();

        spinnerAvailableID
                .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view, int position, long id) {
                        getGMTTime();
                        String selectedId = (String) (parent
                                .getItemAtPosition(position));

                        TimeZone timezone = TimeZone.getTimeZone(selectedId);
                        String TimeZoneName = timezone.getDisplayName();

                        int TimeZoneOffset = timezone.getRawOffset()
                                / (60 * 1000);

                        int hrs = TimeZoneOffset / 60;
                        int mins = TimeZoneOffset % 60;

                        miliSeconds = miliSeconds + timezone.getRawOffset();

                        resultdate = new Date(miliSeconds);
                        System.out.println(sdf.format(resultdate));

                        textTimeZone.setText(TimeZoneName + " : GMT " + hrs + "."
                                + mins);
                        txtTimeZoneTime.setText("" + sdf.format(resultdate));
                        miliSeconds = 0;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }
                });

    }

    // Convert Local Time into GMT time

    private void getGMTTime() {
        current = Calendar.getInstance();
        txtCurrentTime.setText("" + current.getTime());

        miliSeconds = current.getTimeInMillis();

        TimeZone tzCurrent = current.getTimeZone();
        int offset = tzCurrent.getRawOffset();
        if (tzCurrent.inDaylightTime(new Date())) {
            offset = offset + tzCurrent.getDSTSavings();
        }

        miliSeconds = miliSeconds - offset;

        resultdate = new Date(miliSeconds);
        System.out.println(sdf.format(resultdate));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(timeZone.this,MainActivity.class);
            finish();
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(timeZone.this,MainActivity.class);
                finish();
                startActivity(intent);

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



