package com.digital.digitalbusinessowners.SplashScreenAndOnboarding;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.digital.digitalbusinessowners.Adapter.OnboardingAdapter;
import com.digital.digitalbusinessowners.HomePage;
import com.digital.digitalbusinessowners.Model.OnboardingList;
import com.digital.digitalbusinessowners.R;
import com.digital.digitalbusinessowners.Register.PhoneLogin;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class OnboardingScreen extends Fragment {

    private ViewPager2 viewPager2;
    private OnboardingAdapter onboardingAdapter;
    private List<OnboardingList> list = new ArrayList<>();
    private MaterialTextView nextbutton;
    private LinearLayout LayoutonboardingIndictors;
    private FirebaseAuth Mauth;

    public OnboardingScreen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.onboarding_screen, container, false);
        LayoutonboardingIndictors = view.findViewById(R.id.OnboardingDots);

        Mauth = FirebaseAuth.getInstance();
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }


        nextbutton = view.findViewById(R.id.NextButtonID);
        viewPager2 = view.findViewById(R.id.ViewPager);

        OnboardingList one = new OnboardingList();
        one.setImage("safeshopping.json");
        one.setTitle("Safe Shopping");
        one.setDetails("Promotions on clothing, electronics, sports and more. Check out all the deals! Safe Payments.");

        OnboardingList two = new OnboardingList();
        two.setImage("location.json");
        two.setTitle("Location Tracking");
        two.setDetails("TRACK is the most powerful and inclusive package tracking platform. It enables to track over ... Your online order's shipping status is always within reach.\"");

        OnboardingList three = new OnboardingList();
        three.setImage("communaction.json");
        three.setTitle("Real-Time Communication");
        three.setDetails("You can view all your correspondence with sellers in the Buyer Seller messages tab of your message center. Note: To access your correspondence with sellers, go to Buyer Seller Messages.");


        list.add(one);
        list.add(two);
        list.add(three);


        onboardingAdapter = new OnboardingAdapter(list, getActivity());
        viewPager2.setAdapter(onboardingAdapter);


        setuponboardingIncodors();
        setcurrentOnboadingIndicators(0);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                setcurrentOnboadingIndicators(position);
            }
        });


        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager2.getCurrentItem()+1 < onboardingAdapter.getItemCount()){
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
                }
                else {
                    // goto home page
                    goto_loginpage(new PhoneLogin());
                }
            }
        });




        return view;
    }

    private void setuponboardingIncodors(){
        ImageView[] indicatore = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT
        );

        layoutParams.setMargins(8, 0, 8, 0);
        for (int i=0; i<indicatore.length; i++){
            indicatore[i] = new ImageView(getActivity());
            indicatore[i].setImageDrawable(ContextCompat.getDrawable(getActivity(),
                    R.drawable.onboarding_inactive));

            indicatore[i].setLayoutParams(layoutParams);
            LayoutonboardingIndictors.addView(indicatore[i]);
        }

    }

    private void setcurrentOnboadingIndicators(int index){
        int childcount = LayoutonboardingIndictors.getChildCount();

        for(int i=0; i< childcount; i++){
            ImageView imageView = (ImageView) LayoutonboardingIndictors.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_indicator_activity));

            }
            else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_inactive));

            }
        }

        if(index ==onboardingAdapter.getItemCount() - 1){
            nextbutton.setText("START");
        }
        else {
            nextbutton.setText("NEXT");
        }
    }


    private void goto_loginpage(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.MainFrameLayout, fragment);
            transaction.commit();
        }
    }





}