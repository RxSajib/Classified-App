package com.digital.digitalbusinessowners.CategoryUpdate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.R;

public class CategoryPlaceHolder extends Fragment {

    private RelativeLayout mobilel, vehicles, propartysale, propartyrent, electronichomeappliances, bikes;
    private RelativeLayout bugnessindag, more;

    public CategoryPlaceHolder() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.category_place_holder, container, false);


        mobilel = view.findViewById(R.id.MobileButtonID);
        vehicles = view.findViewById(R.id.vehiclesID);
        propartysale = view.findViewById(R.id.PropartySale);
        propartyrent = view.findViewById(R.id.PropartyRent);
        electronichomeappliances = view.findViewById(R.id.ElectronicHomeAppliances);
        bikes = view.findViewById(R.id.BikesID);
        bugnessindag = view.findViewById(R.id.BugnessIndAg);
        more = view.findViewById(R.id.MoreID);

        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_veichelslist(new CategoryListUpdate());
            }
        });

        mobilel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                goto_categorylist(new CategoryListUpdate());
            }
        });

        propartysale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_propartysale(new CategoryListUpdate());
            }
        });

        propartyrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_rentpage(new CategoryListUpdate());
            }
        });

        electronichomeappliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_electronic_homeapplicants(new CategoryListUpdate());
            }
        });

        bikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_bikes_pages(new CategoryListUpdate());
            }
        });

        bugnessindag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_bugness_indrestree(new CategoryListUpdate());
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_more_page(new AllList_MainCategory());
            }
        });

        return view;
    }

    private void goto_categorylist(Fragment fragment){
        if(fragment != null){

            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.MobileUpdate);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_veichelslist(Fragment fragment){
        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.Vehicles);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_propartysale(Fragment fragment){
        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.PropartySale);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_rentpage(Fragment fragment){
        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.PropartyRent);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_electronic_homeapplicants(Fragment fragment){
        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.ElectronicHomeAppliances);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_bikes_pages(Fragment fragment){
        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.Bikes);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_bugness_indrestree(Fragment fragment){
        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("CategoryKey", DataManager.BugnessIndustrial_agri);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }

    private void goto_more_page(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }
}