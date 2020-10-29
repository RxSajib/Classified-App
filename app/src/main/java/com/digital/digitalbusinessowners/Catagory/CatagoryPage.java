package com.digital.digitalbusinessowners.Catagory;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.UploadMainCatagoryAdapter;
import com.digital.digitalbusinessowners.Model.MainCatagory;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class CatagoryPage extends Fragment {

    private RecyclerView catagorylist;
    private List<MainCatagory> mainCatagoryList = new ArrayList<>();
    private UploadMainCatagoryAdapter uploadMainCatagoryAdapter;


    public CatagoryPage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.catagory_page, container, false);


        catagorylist = view.findViewById(R.id.UploadCatagoryList);
        catagorylist.addItemDecoration(new DividerItemDecoration(catagorylist.getContext(), DividerItemDecoration.VERTICAL));
        catagorylist.setHasFixedSize(true);
        catagorylist.setLayoutManager(new LinearLayoutManager(getActivity()));
        uploadMainCatagoryAdapter = new UploadMainCatagoryAdapter(getActivity(), mainCatagoryList);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }

        MainCatagory proparty = new MainCatagory();
        proparty.setTitle(getResources().getString(R.string.catagoryone));

        MainCatagory rantproparty = new MainCatagory();
        rantproparty.setTitle(getResources().getString(R.string.catagorytwo));

        MainCatagory jobforpost = new MainCatagory();
        jobforpost.setTitle(getResources().getString(R.string.catagorythree));

        MainCatagory searchingforbuy = new MainCatagory();
        searchingforbuy.setTitle(getResources().getString(R.string.catagoryfour));

        MainCatagory searchingrant = new MainCatagory();
        searchingrant.setTitle(getResources().getString(R.string.catagoryfive));

        mainCatagoryList.add(proparty);
        mainCatagoryList.add(rantproparty);
        mainCatagoryList.add(jobforpost);
        mainCatagoryList.add(searchingforbuy);
        mainCatagoryList.add(searchingrant);

        catagorylist.setAdapter(uploadMainCatagoryAdapter);


        return view;
    }
}