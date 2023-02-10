package com.infspmbechar.concours;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.retrofit.lite.services.APITask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.User;
import SERVER.URLs;


public class MainActivity extends AppCompatActivity {
    private EditText recu_num, num_concr, tel_cond;
    private String idR,numR,telR;
    private ProgressBar progressBar;
    JSONObject jo;
    static ArrayList<User> student = new ArrayList<>();
    static User u1 = new User();
    User user = new User();


    SharedPreferences sharedPreferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recu_num = findViewById(R.id.editText1);
        num_concr = findViewById(R.id.editText2);
        tel_cond = findViewById(R.id.editText3);
        progressBar = findViewById(R.id.progressBar);
    }


    public void slideUp(View view){
        userLogin();

    }

    private void userLogin(){

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean connected = (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED);

        if(connected){


            final String myNumRecu = recu_num.getText().toString().trim();
            final String myNumConr = num_concr.getText().toString().trim();
            final String myTelCond = tel_cond.getText().toString().trim();

            if(TextUtils.isEmpty(myNumRecu)){
                recu_num.setError("N° Récu obligatoire");
                recu_num.requestFocus();
                return;
            }else{
                idR = String.valueOf(recu_num.getText());
            }

            if(TextUtils.isEmpty(myNumConr)){
                num_concr.setError("N° Classement obligatoire");
                num_concr.requestFocus();
                return;
            }else{
                numR = String.valueOf(num_concr.getText());
            }

            if(TextUtils.isEmpty(myTelCond)){
                tel_cond.setError("N° Téléphone obligatoire");
                tel_cond.requestFocus();
                return;
            }else{
                telR = String.valueOf(tel_cond.getText());
            }

            progressBar.setVisibility(View.VISIBLE);

            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("content-type", "application/json");


            APITask.from(this).sendPOST(201, URLs.URL_LOGIN, "{ \"id_cdd\" : \""+idR+"\",\"num_cdd\": \""+numR+"\",\"tel_cdd\" : \""+telR+"\" }", null, new APITask.Listener() {

                @Override
                public void onSuccess(int pid, int status,  Map<String, String> headers, String body) {
                    try {
                        Log.d("body_younes",body);
                        if(status == 404){

                            return;
                        }
                        JSONObject jsonObject = new JSONObject(body);
                        progressBar.setVisibility(View.INVISIBLE);

                        jo = jsonObject.getJSONObject("user");

                        user.setId(jo.getInt("id_cdd"));
                        user.setConcours(jo.getString("concours"));
                        user.setChoix_concours(jo.getString("choix_concours"));
                        user.setNum_cdd(jo.getString("num_cdd"));
                        user.setNom_cdd(jo.getString("nom_cdd"));
                        user.setPrenom_cdd(jo.getString("prenom_cdd"));
                        user.setGenre_cdd(jo.getString("genre_cdd"));
                        user.setNaissance_cdd(jo.getString("naissance_cdd"));
                        user.setLieu_cdd(jo.getString("lieu_cdd"));
                        user.setTel_cdd(jo.getString("tel_cdd"));
                        user.setResid_cdd(jo.getString("resid_cdd"));
                        user.setAdress_cdd(jo.getString("adress_cdd"));
                        user.setTypebac_cdd(jo.getString("typebac_cdd"));
                        user.setAnnbac_cdd(jo.getString("annbac_cdd"));
                        user.setValide(jo.getString("valide"));
                        user.setMotif(jo.getString("motif"));
                        user.setCentre_exam(jo.getString("centre_exam"));
                        user.setSalle(jo.getString("salle"));
                        user.setDate_retree(jo.getString("date_retree"));
                        user.setRetree_ok(jo.getInt("retree_ok"));
                        user.setToken(jsonObject.getString("token"));

                        userLog();



                        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                       // customType(MainActivity.this,"bottom-to-up");

                    } catch (JSONException jsonException) {
                        jsonException.printStackTrace();
                    }

                }


                @Override
                public void onFailed(int pid, Exception ex) {
                    Log.d("exception", ex.getMessage());
                }
            });



        }else {
            Toast.makeText(getApplicationContext(),
                    "Il faut connecter via l'internet!", Toast.LENGTH_SHORT).show();
        }


    }
    private Context mCtx;

    static final String SHARED_PREF_NAME = "com.example.mylearningapp";
    static final String KEY_CONCOURS = "concours";
    static final String KEY_CHOIX_CONCOURS = "choix_concours";
    static final String KEY_NUM_CDD = "num_cdd";
    static final String KEY_NOM_CDD = "nom_cdd";
    static final String KEY_PRENOM_CDD = "prenom_cdd";
    static final String KEY_GENRE_CDD = "genre_cdd";
    static final String KEY_NAISSANCE_CDD = "naissance_cdd";
    static final String KEY_LIEU_CDD = "lieu_cdd";
    static final String KEY_TEL_CDD = "tel_cdd";
    static final String KEY_RESID_CDD = "resid_cdd";
    static final String KEY_ADRESS_CDD = "adress_cdd";
    static final String KEY_TYPEBAC_CDD = "typebac_cdd";
    static final String KEY_ANNBAC_CDD = "annbac_cdd";
    static final String KEY_VALIDE = "valide";
    static final String KEY_MOTIF = "motif";
    static final String KEY_CENTRE_EXAM = "centre_exam";
    static final String KEY_SALLE = "salle";
    static final String KEY_DATE_RETREE = "date_retree";
    static final String KEY_RETREE_OK = "retree_ok";
    static final String KEY_ID = "id_cdd";
    static final String KEY_TOKEN = "token";

    public void userLog(){

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
        //Log.d("user",String.valueOf(user));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_CONCOURS,user.getConcours());
        editor.putString(KEY_CHOIX_CONCOURS,user.getChoix_concours());
        editor.putString(KEY_NUM_CDD,user.getNum_cdd());
        editor.putString(KEY_NOM_CDD,user.getNom_cdd());
        editor.putString(KEY_PRENOM_CDD,user.getPrenom_cdd());
        editor.putString(KEY_GENRE_CDD,user.getGenre_cdd());
        editor.putString(KEY_NAISSANCE_CDD,user.getNaissance_cdd());
        editor.putString(KEY_LIEU_CDD,user.getLieu_cdd());
        editor.putString(KEY_TEL_CDD,user.getTel_cdd());
        editor.putString(KEY_RESID_CDD,user.getResid_cdd());
        editor.putString(KEY_ADRESS_CDD,user.getAdress_cdd());
        editor.putString(KEY_TYPEBAC_CDD,user.getTypebac_cdd());
        editor.putString(KEY_ANNBAC_CDD,user.getAnnbac_cdd());
        editor.putString(KEY_VALIDE,user.getValide());
        editor.putString(KEY_MOTIF,user.getMotif());
        editor.putString(KEY_CENTRE_EXAM,user.getCentre_exam());
        editor.putString(KEY_SALLE,user.getSalle());
        editor.putString(KEY_DATE_RETREE,user.getDate_retree());
        editor.putInt(KEY_RETREE_OK,user.getRetree_ok());
        editor.putString(KEY_TOKEN,user.getToken());
        editor.commit();
    }
}