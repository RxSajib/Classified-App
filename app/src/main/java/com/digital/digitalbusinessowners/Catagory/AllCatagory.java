package com.digital.digitalbusinessowners.Catagory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.CatagoryAdapter;
import com.digital.digitalbusinessowners.Model.AllCatagoryList;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class AllCatagory extends Fragment {

    private RecyclerView recyclerView;
    private List<AllCatagoryList> catagoryLists = new ArrayList<>();
    private CatagoryAdapter catagoryAdapter;

    public AllCatagory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.all_catagory, container, false);

        recyclerView = view.findViewById(R.id.AllCatagoryList);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        set_all_layout();
        return view;
    }

    private void set_all_layout(){

        catagoryAdapter = new CatagoryAdapter(getActivity(), catagoryLists);

        AllCatagoryList dailyinstument = new AllCatagoryList();
        dailyinstument.setImage(R.drawable.dailyinstument);
        dailyinstument.setTitle("Daily Instrument");

        AllCatagoryList mobile = new AllCatagoryList();
        mobile.setImage(R.drawable.mobilephone);
        mobile.setTitle("Mobile");

        AllCatagoryList electronic = new AllCatagoryList();
        electronic.setImage(R.drawable.tv);
        electronic.setTitle("Electronic");

        AllCatagoryList vychel = new AllCatagoryList();
        vychel.setImage(R.drawable.car);
        vychel.setTitle("Vehicle");

        AllCatagoryList proparty = new AllCatagoryList();
        proparty.setImage(R.drawable.proparty_home);
        proparty.setTitle("Property");



        AllCatagoryList services = new AllCatagoryList();
        services.setImage(R.drawable.services);
        services.setTitle("Services IT and Software");

        AllCatagoryList homeinstument = new AllCatagoryList();
        homeinstument.setTitle("Home Instrument");
        homeinstument.setImage(R.drawable.homeleaving);

        AllCatagoryList fation = new AllCatagoryList();
        fation.setImage(R.drawable.watch);
        fation.setTitle("Fashion");

        AllCatagoryList sports = new AllCatagoryList();
        sports.setTitle("Sports");
        sports.setImage(R.drawable.foodball);

        AllCatagoryList bugness = new AllCatagoryList();
        bugness.setImage(R.drawable.bugness_indress);
        bugness.setTitle("Business Industry");

        AllCatagoryList education = new AllCatagoryList();
        education.setTitle("Education");
        education.setImage(R.drawable.education);

        AllCatagoryList animals = new AllCatagoryList();
        animals.setImage(R.drawable.anmals);
        animals.setTitle("Animals");

        AllCatagoryList agriculture = new AllCatagoryList();
        agriculture.setTitle("Agriculture");
        agriculture.setImage(R.drawable.agriculture);


        catagoryLists.add(dailyinstument);
        catagoryLists.add(mobile);
        catagoryLists.add(electronic);
        catagoryLists.add(vychel);
        catagoryLists.add(proparty);
        catagoryLists.add(services);
        catagoryLists.add(homeinstument);
        catagoryLists.add(fation);
        catagoryLists.add(sports);
        catagoryLists.add(bugness);
        catagoryLists.add(education);
        catagoryLists.add(animals);
        catagoryLists.add(agriculture);


        recyclerView.setAdapter(catagoryAdapter);

    }
}