package com.infspmbechar.concours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity {
    TextView tvidcdd,tvncdd,tvnomcdd,tvprenomcdd,tvdatecdd,tvlieucdd,tvadresscdd,tvconcours,tvbac,tvannbac;
    String num,name,prenom,date,lieu,adress,concours,bac,anbac;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean connected = (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED);

        if(connected){

            tvidcdd = findViewById(R.id.num_dossier);
            tvncdd = findViewById(R.id.classement_concr);
            tvnomcdd = findViewById(R.id.nom);
            tvprenomcdd = findViewById(R.id.prenom);
            tvdatecdd = findViewById(R.id.date);
            tvlieucdd = findViewById(R.id.lieu);
            tvadresscdd = findViewById(R.id.adresstv);
            tvconcours = findViewById(R.id.concours);
            tvbac = findViewById(R.id.typebac);
            tvannbac = findViewById(R.id.anneebac);





            SharedPreferences sharedPref = getSharedPreferences(MainActivity.SHARED_PREF_NAME, 0);

            if( sharedPref.contains(MainActivity.KEY_ID)){
                id = sharedPref.getInt(MainActivity.KEY_ID,0000);
                tvidcdd.setText(id+"");
            }

            if( sharedPref.contains(MainActivity.KEY_NUM_CDD)){
                num = sharedPref.getString(MainActivity.KEY_NUM_CDD,"-");
                tvncdd.setText(num);
            }

            if( sharedPref.contains(MainActivity.KEY_NOM_CDD)){
                name = sharedPref.getString(MainActivity.KEY_NOM_CDD,"-");
                tvnomcdd.setText(name);
            }

            if( sharedPref.contains(MainActivity.KEY_PRENOM_CDD)){
                prenom = sharedPref.getString(MainActivity.KEY_PRENOM_CDD,"-");
                tvprenomcdd.setText(prenom);
            }

            if( sharedPref.contains(MainActivity.KEY_NAISSANCE_CDD)){
                date = sharedPref.getString(MainActivity.KEY_NAISSANCE_CDD,"-");
                tvdatecdd.setText(date);
            }

            if( sharedPref.contains(MainActivity.KEY_LIEU_CDD)){
                lieu = sharedPref.getString(MainActivity.KEY_LIEU_CDD,"-");
                tvlieucdd.setText(lieu);
            }

            if( sharedPref.contains(MainActivity.KEY_ADRESS_CDD)){
                adress = sharedPref.getString(MainActivity.KEY_ADRESS_CDD,"-");
                tvadresscdd.setText(adress);
            }

            if( sharedPref.contains(MainActivity.KEY_CONCOURS)){
                concours = sharedPref.getString(MainActivity.KEY_CONCOURS,"-");
                tvconcours.setText(concours);
            }

            if( sharedPref.contains(MainActivity.KEY_TYPEBAC_CDD)){
                bac = sharedPref.getString(MainActivity.KEY_TYPEBAC_CDD,"-");
                tvbac.setText(bac);
            }

            if( sharedPref.contains(MainActivity.KEY_ANNBAC_CDD)){
                anbac = sharedPref.getString(MainActivity.KEY_ANNBAC_CDD,"-");
                tvannbac.setText(anbac);
            }

        }else {
            Toast.makeText(getApplicationContext(),
                    "Il faut connecter via l'internet!", Toast.LENGTH_SHORT).show();
            this.finishAffinity();

        }

    }



}