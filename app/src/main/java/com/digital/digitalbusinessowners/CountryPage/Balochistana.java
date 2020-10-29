package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.AzadKasmerLocaionAdapter;
import com.digital.digitalbusinessowners.Adapter.BalochistanLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;

public class Balochistana extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private BalochistanLocationAdapter counteyLocationAdapter;


    public Balochistana() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.balochistana, container, false);

        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));



        setdata();

        return view;
    }


    private void setdata(){

        counteyLocationAdapter = new BalochistanLocationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.bela));

        Location two = new Location();
        two.setName(getString(R.string.gwadar));

        Location three = new Location();
        three.setName(getString(R.string.jiwani));

        Location four = new Location();
        four.setName(getString(R.string.kalat));

        Location five = new Location();
        five.setName(getString(R.string.khuzdar));

        Location six = new Location();
        six.setName(getString(R.string.lasbela));

        Location seven = new Location();
        seven.setName(getString(R.string.loralai));

        Location eight = new Location();
        eight.setName(getString(R.string.ormara));

        Location nine = new Location();
        nine.setName(getString(R.string.pasni));

        Location ten = new Location();
        ten.setName(getString(R.string.quetta));

        Location eleven = new Location();
        eleven.setName(getString(R.string.zhob));

        locationList.add(one);
        locationList.add(two);
        locationList.add(three);
        locationList.add(four);
        locationList.add(five);
        locationList.add(six);
        locationList.add(seven);
        locationList.add(eight);
        locationList.add(nine);
        locationList.add(ten);
        locationList.add(eleven);

        recyclerView.setAdapter(counteyLocationAdapter);

    }
}