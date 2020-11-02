package com.digital.digitalbusinessowners.MobilePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.R;

public class MobilePhones extends Fragment {


    public MobilePhones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.mobile_phones, container, false);
    }
}