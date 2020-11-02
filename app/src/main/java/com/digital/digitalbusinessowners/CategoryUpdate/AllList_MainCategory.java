package com.digital.digitalbusinessowners.CategoryUpdate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Model.CategoryUpdateList;
import com.digital.digitalbusinessowners.R;
import com.digital.digitalbusinessowners.UpdateAdapter.AllCategoryAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class AllList_MainCategory extends Fragment {

    private RecyclerView categorylist;
    private AllCategoryAdapter allCategoryAdapter;
    private List<CategoryUpdateList> categoryUpdateLists = new ArrayList<>();

    public AllList_MainCategory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.all_list__main_category, container, false);

        categorylist = view.findViewById(R.id.MainCategoryList);
        categorylist.setHasFixedSize(true);
        categorylist.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewalllist();

        return view;
    }

    private void viewalllist() {
        allCategoryAdapter = new AllCategoryAdapter(getActivity(), categoryUpdateLists);

        CategoryUpdateList one = new CategoryUpdateList();
        one.setTitle(getResources().getString(R.string.Mobiles));

        CategoryUpdateList two = new CategoryUpdateList();
        two.setTitle(getResources().getString(R.string.Vehicles));

        CategoryUpdateList three = new CategoryUpdateList();
        three.setTitle(getResources().getString(R.string.Property_for_Sale));

        CategoryUpdateList four = new CategoryUpdateList();
        four.setTitle(getResources().getString(R.string.Property_for_Rent));

        CategoryUpdateList five = new CategoryUpdateList();
        five.setTitle(getResources().getString(R.string.Electronics_Home_Appliances));

        CategoryUpdateList six = new CategoryUpdateList();
        six.setTitle(getResources().getString(R.string.Bikes));

        CategoryUpdateList seven = new CategoryUpdateList();
        seven.setTitle(getResources().getString(R.string.Business_Industrial_Agriculture));


        CategoryUpdateList eight = new CategoryUpdateList();
        eight.setTitle(getResources().getString(R.string.Services));

        CategoryUpdateList nine = new CategoryUpdateList();
        nine.setTitle(getResources().getString(R.string.Jobs));


        CategoryUpdateList ten = new CategoryUpdateList();
        ten.setTitle(getResources().getString(R.string.Animals));

        CategoryUpdateList eleven = new CategoryUpdateList();
        eleven.setTitle(getResources().getString(R.string.Furniture_Home_Decor));

        CategoryUpdateList twelve = new CategoryUpdateList();
        twelve.setTitle(getResources().getString(R.string.Fashion_Beauty));

        CategoryUpdateList thirteen = new CategoryUpdateList();
        thirteen.setTitle(getResources().getString(R.string.Books_Sports_Hobbies));

        CategoryUpdateList fourteen = new CategoryUpdateList();
        fourteen.setTitle(getResources().getString(R.string.Kids));


        categoryUpdateLists.add(one);
        categoryUpdateLists.add(two);
        categoryUpdateLists.add(three);
        categoryUpdateLists.add(four);
        categoryUpdateLists.add(five);
        categoryUpdateLists.add(six);
        categoryUpdateLists.add(seven);
        categoryUpdateLists.add(eight);
        categoryUpdateLists.add(nine);
        categoryUpdateLists.add(ten);
        categoryUpdateLists.add(eleven);
        categoryUpdateLists.add(twelve);
        categoryUpdateLists.add(thirteen);
        categoryUpdateLists.add(fourteen);
        categorylist.setAdapter(allCategoryAdapter);
    }


}