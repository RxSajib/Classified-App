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
import com.digital.digitalbusinessowners.Adapter.CounteyLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class Azad_Kahmer extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private AzadKasmerLocaionAdapter counteyLocationAdapter;


    public Azad_Kahmer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.azad__kahmer, container, false);

        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));



        setdata();
        return view;
    }

    private void setdata(){

        counteyLocationAdapter = new AzadKasmerLocaionAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.bagh));

        Location two = new Location();
        two.setName(getString(R.string.bhimber));

        Location three = new Location();
        three.setName(getString(R.string.hajira));

        Location four = new Location();
        four.setName(getString(R.string.kotli));

        Location five = new Location();
        five.setName(getString(R.string.mirpur));

        Location six = new Location();
        six.setName(getString(R.string.muzaffarabad));

        Location seven = new Location();
        seven.setName(getString(R.string.pallandri));

        Location eight = new Location();
        eight.setName(getString(R.string.rawalakot));

        locationList.add(one);
        locationList.add(two);
        locationList.add(three);
        locationList.add(four);
        locationList.add(five);
        locationList.add(six);
        locationList.add(seven);
        locationList.add(eight);

        recyclerView.setAdapter(counteyLocationAdapter);

    }
}