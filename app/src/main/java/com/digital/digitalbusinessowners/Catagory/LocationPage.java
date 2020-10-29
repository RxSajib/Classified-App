package com.digital.digitalbusinessowners.Catagory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.digital.digitalbusinessowners.CountryPage.Pakistan;
import com.digital.digitalbusinessowners.Memory.SharedPref;
import com.digital.digitalbusinessowners.R;


public class LocationPage extends Fragment {

    private SharedPref sharedPref;
    private RelativeLayout pakistan, uae;

    public LocationPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.location_page, container, false);

        sharedPref = new SharedPref(getActivity());



        pakistan = view.findViewById(R.id.PakistanButtonID);
        uae = view.findViewById(R.id.UAECountryButton);

        pakistan.setBackgroundColor(getResources().getColor(R.color.carbon_red_200));
        uae.setBackgroundColor(getResources().getColor(R.color.carbon_white));


        goto_pakistan(new Pakistan());

        pakistan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pakistan.setBackgroundColor(getResources().getColor(R.color.carbon_red_200));
                uae.setBackgroundColor(getResources().getColor(R.color.carbon_white));


                goto_pakistan(new Pakistan());
            }
        });

        uae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pakistan.setBackgroundColor(getResources().getColor(R.color.carbon_white));
                uae.setBackgroundColor(getResources().getColor(R.color.carbon_red_200));
            }
        });


        return view;
    }

    private void goto_pakistan(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CounteyVP, fragment);
            transaction.commit();
        }
    }
}