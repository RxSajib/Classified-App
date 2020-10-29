package com.digital.digitalbusinessowners.SplashScreenAndOnboarding;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.HomePage;
import com.digital.digitalbusinessowners.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends Fragment {


    private FirebaseAuth Mauth;

    public SplashScreen() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);

        Mauth = FirebaseAuth.getInstance();

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }


        FirebaseUser Muser = Mauth.getCurrentUser();
        if(Muser != null){
            Intent intent = new Intent(getActivity(), HomePage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        }
        else {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        goto_onboardingScreen(new OnboardingScreen());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }




        return view;
    }

    private void goto_onboardingScreen(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.MainFrameLayout, fragment);
            transaction.commit();
        }
    }
}