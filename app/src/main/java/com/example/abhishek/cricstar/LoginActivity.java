package com.example.abhishek.cricstar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abhishek on 04/07/17.
 */

public class LoginActivity extends AppCompatActivity {
private SharedPreferences sharedPreferences;
    private String email;
    private String password;

    @Override
   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setLogin();
        sharedPreferences = getSharedPreferences(getPackageName(), Activity.MODE_PRIVATE);
        email = sharedPreferences.getString("Email", "");
        if (!email.isEmpty()){
            Intent intent = new Intent(this,DashboardActivity.class);
            startActivity(intent);
            finish();

        }


    }



    public void onResume(){
        super.onResume();



    }

    public void setLogin(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment fragment = new LoginFragment();
        fragmentTransaction.replace(R.id.ffff, fragment);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    //Refrerences
    // https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization
    //https://futurestud.io/tutorials/retrofit-getting-started-and-android-client


}
