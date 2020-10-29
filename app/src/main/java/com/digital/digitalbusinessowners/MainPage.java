package com.digital.digitalbusinessowners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.digital.digitalbusinessowners.SplashScreenAndOnboarding.SplashScreen;

public class MainPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);


        setsplashscreen(new SplashScreen());



    }


    private void setsplashscreen(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.MainFrameLayout, fragment);
            transaction.commit();
        }
    }
}