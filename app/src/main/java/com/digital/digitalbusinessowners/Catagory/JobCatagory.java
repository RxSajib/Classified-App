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

public class JobCatagory extends Fragment {

    private RecyclerView joblist;
    private CatagoryAdapter catagoryAdapter;
    private List<AllCatagoryList> allCatagoryLists = new ArrayList<>();

    public JobCatagory() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.job_catagory, container, false);

        joblist = view.findViewById(R.id.JobListID);
        joblist.setHasFixedSize(true);
        joblist.setLayoutManager(new LinearLayoutManager(getActivity()));

        joblist.addItemDecoration(new DividerItemDecoration(joblist.getContext(), DividerItemDecoration.VERTICAL));


        setdata();

        return view;
    }

    private void setdata(){

        catagoryAdapter = new CatagoryAdapter(getActivity(), allCatagoryLists);
        AllCatagoryList one = new AllCatagoryList();
        one.setTitle("Job");
        one.setImage(R.drawable.job);

        AllCatagoryList two = new AllCatagoryList();
        two.setTitle("Former Job");
        two.setImage(R.drawable.worldjob);

        allCatagoryLists.add(one);
        allCatagoryLists.add(two);

        joblist.setAdapter(catagoryAdapter);
    }

}