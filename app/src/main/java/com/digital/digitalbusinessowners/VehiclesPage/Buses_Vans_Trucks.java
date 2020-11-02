package com.digital.digitalbusinessowners.VehiclesPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.R;

public class Buses_Vans_Trucks extends Fragment {


    public Buses_Vans_Trucks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.buses__vans__trucks, container, false);
    }
}