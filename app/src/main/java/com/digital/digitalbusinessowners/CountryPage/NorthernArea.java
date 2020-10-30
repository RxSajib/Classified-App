package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.Khyber_pakhtunkhwa_locationAdapter;
import com.digital.digitalbusinessowners.Adapter.NorthanAreaLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;

public class NorthernArea extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private NorthanAreaLocationAdapter counteyLocationAdapter;


    public NorthernArea() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.northern_area, container, false);

        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        setdata();

        return view;
    }


    private void setdata() {

        counteyLocationAdapter = new NorthanAreaLocationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.Askoley));

        Location two = new Location();
        two.setName(getString(R.string.Chilas));

        Location three = new Location();
        three.setName(getString(R.string.Ghanche));

        Location four = new Location();
        four.setName(getString(R.string.Ghizer));

        Location five = new Location();
        five.setName(getString(R.string.Gilgit));

        Location six = new Location();
        six.setName(getString(R.string.Khaplu));

        Location seven = new Location();
        seven.setName(getString(R.string.Skardu));

        locationList.add(one);
        locationList.add(two);
        locationList.add(three);
        locationList.add(four);
        locationList.add(five);
        locationList.add(six);
        locationList.add(seven);

        recyclerView.setAdapter(counteyLocationAdapter);

    }

}