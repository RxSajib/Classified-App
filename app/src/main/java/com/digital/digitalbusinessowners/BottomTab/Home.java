package com.digital.digitalbusinessowners.BottomTab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Catagory.SubCatagory;
import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.card.MaterialCardView;


public class Home extends Fragment {

    private MaterialCardView dailyinstument;

    private String RootData, Catagoryname;

    public Home() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home, container, false);

        dailyinstument = view.findViewById(R.id.DailyInstumentID);

        dailyinstument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootData = "Daily_InstrumentSubCatagory";
                Catagoryname = "Daily Instrument";
                Intent intent = new Intent(getActivity(), SubCatagory.class);
                intent.putExtra(DataManager.DATAROOT, RootData);
                intent.putExtra(DataManager.CatagoryName, Catagoryname);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        return view;
    }
}