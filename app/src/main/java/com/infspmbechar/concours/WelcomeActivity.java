package com.infspmbechar.concours;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    private Dialog dialog;
    private TextView LabelNumDossier;
    private String keyid;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean connected = (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED);

        if(connected){

            LabelNumDossier = findViewById(R.id.textView2);

            SharedPreferences sharedPref = getSharedPreferences(MainActivity.SHARED_PREF_NAME, 0);

            if( sharedPref.contains(MainActivity.KEY_NUM_CDD)) {
                id = sharedPref.getString(MainActivity.KEY_NUM_CDD, "-");
                LabelNumDossier.setText("N° Dossier : "+id);
            }


            //Create the Dialog here
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_dialog);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
            }
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(false); //Optional
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

            Button Okay = dialog.findViewById(R.id.btn_okay);

            Okay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(WelcomeActivity.this, "حظ موفق", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

        }else {
            Toast.makeText(getApplicationContext(),
                    "Il faut connecter via l'internet!", Toast.LENGTH_SHORT).show();
            this.finishAffinity();

        }


    }

    public void InformButton(View view){
        startActivity(new Intent(WelcomeActivity.this, InformationActivity.class));
        //customType(WelcomeActivity.this,"bottom-to-up");

    }

    public void ConvButton(View view){
        startActivity(new Intent(WelcomeActivity.this, ConvocationActivity.class));
        //customType(WelcomeActivity.this,"bottom-to-up");
    }

    public void ResultButton(View view){
        dialog.show();
    }

    public void ButtonDisconnect(View view){
        onBackPressed();
    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "cliquez une dexieume fois pour déconneter", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


}