package com.infspmbechar.concours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConvocationActivity extends AppCompatActivity {
    TextView tvdateret,tvsalle;
    String dater,salle;
    int retreok;
    ImageView imretre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convocation);


        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean connected = (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED);

        if(connected){


            tvdateret = findViewById(R.id.date_retrer);
            tvsalle = findViewById(R.id.salle);
            imretre = findViewById(R.id.retreImg);



            SharedPreferences sharedPref = getSharedPreferences(MainActivity.SHARED_PREF_NAME, 0);

            if( sharedPref.contains(MainActivity.KEY_DATE_RETREE)){
                dater = sharedPref.getString(MainActivity.KEY_DATE_RETREE,"-");
                tvdateret.setText(dater+"");
            }

            if( sharedPref.contains(MainActivity.KEY_SALLE)){
                salle = sharedPref.getString(MainActivity.KEY_SALLE,"-");
                tvsalle.setText(salle);
            }

            if( sharedPref.contains(MainActivity.KEY_RETREE_OK)){
                retreok = sharedPref.getInt(MainActivity.KEY_RETREE_OK,0);
            }

            if (retreok == 1){
                imretre.setImageResource(R.drawable.accept_img);
                tvdateret.setText("Convocation retrer - Bon chance");
            }

        }else {
            Toast.makeText(getApplicationContext(),
                    "Il faut connecter via l'internet!", Toast.LENGTH_SHORT).show();
            this.finishAffinity();
        }


    }
}