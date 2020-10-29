package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.digital.digitalbusinessowners.Adapter.CounteyLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class Pakistan extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private CounteyLocationAdapter counteyLocationAdapter;


    public Pakistan() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.pakistan, container, false);

        recyclerView = view.findViewById(R.id.CountryListID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        setdata();


        return view;
    }

    private void setdata(){

        counteyLocationAdapter = new CounteyLocationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.azad_kashmir));

        Location two = new Location();
        two.setName(getString(R.string.balochistan));

        Location three = new Location();
        three.setName(getString(R.string.islamabad_capital_territory));

        Location five = new Location();
        five.setName(getString(R.string.khyber_pakhtunkhwa));

        Location six = new Location();
        six.setName(getString(R.string.northern_areas));

        Location seven = new Location();
        seven.setName(getString(R.string.punjab));

        Location nine = new Location();
        nine.setName(getString(R.string.sindh));

        locationList.add(one);
        locationList.add(two);
        locationList.add(three);
        locationList.add(five);
        locationList.add(six);
        locationList.add(seven);
        locationList.add(nine);

        recyclerView.setAdapter(counteyLocationAdapter);

    }
}