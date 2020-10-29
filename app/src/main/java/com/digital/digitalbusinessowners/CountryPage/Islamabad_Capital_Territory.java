package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.BalochistanLocationAdapter;
import com.digital.digitalbusinessowners.Adapter.IslamabadCapital_twaryLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;

public class Islamabad_Capital_Territory extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private IslamabadCapital_twaryLocationAdapter counteyLocationAdapter;


    public Islamabad_Capital_Territory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.islamabad__capital__territory, container, false);



        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));



        setdata();

        return view;
    }

    private void setdata(){

        counteyLocationAdapter = new IslamabadCapital_twaryLocationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.islamabad));

        locationList.add(one);

        recyclerView.setAdapter(counteyLocationAdapter);

    }
}