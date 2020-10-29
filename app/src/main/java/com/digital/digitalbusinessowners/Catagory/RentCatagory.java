package com.digital.digitalbusinessowners.Catagory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

public class RentCatagory extends Fragment {

    private RecyclerView recyclerView;
    private CatagoryAdapter catagoryAdapter;
    private List<AllCatagoryList> allCatagoryList = new ArrayList<>();

    public RentCatagory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rent_catagory, container, false);

        recyclerView = view.findViewById(R.id.RentList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        set_uplayout();

        return view;
    }

    private void set_uplayout(){
        catagoryAdapter = new CatagoryAdapter(getActivity(), allCatagoryList);

        AllCatagoryList proparty = new AllCatagoryList();
        proparty.setImage(R.drawable.proparty_home);
        proparty.setTitle("Property");

        allCatagoryList.add(proparty);
        recyclerView.setAdapter(catagoryAdapter);
    }
}