package com.digital.digitalbusinessowners.CategoryUpdate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.MobilePage.Accessories;
import com.digital.digitalbusinessowners.MobilePage.MobilePhones;
import com.digital.digitalbusinessowners.MobilePage.Tablets;
import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.Model.CategoryUpdateList;
import com.digital.digitalbusinessowners.R;
import com.digital.digitalbusinessowners.VehiclesPage.Car_On_Installments;
import com.digital.digitalbusinessowners.VehiclesPage.Cars;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CategoryListUpdate extends Fragment {

    private RecyclerView categorylist;
    private MaterialTextView toolbartext;
    private DatabaseReference MDatabase;
    private DatabaseReference MCategoryData;
    private String key, name;

    public CategoryListUpdate() {
        //todo Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //todo Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.category_list_update, container, false);

        MCategoryData = FirebaseDatabase.getInstance().getReference().child("Subcategory");

       

        categorylist = view.findViewById(R.id.CategoryListID);
        toolbartext = view.findViewById(R.id.CategoryToolbarText);

        Bundle bundle = getArguments();
        key = bundle.getString("CategoryKey");

        MDatabase = FirebaseDatabase.getInstance().getReference().child(DataManager.Subcategory).child(key);
        categorylist.setHasFixedSize(true);
        categorylist.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onStart() {

        FirebaseRecyclerAdapter<CategoryUpdateList, CategoryHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<CategoryUpdateList, CategoryHolder>(
                CategoryUpdateList.class,
                R.layout.catagory_layout_update,
                CategoryHolder.class,
                MDatabase
        ) {
            @Override
            protected void populateViewHolder(CategoryHolder categoryHolder, CategoryUpdateList categoryUpdateList, int i) {
                String UID = getRef(i).getKey();
                MDatabase.child(UID)
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()){
                                    if(dataSnapshot.hasChild("Title")){
                                         name = dataSnapshot.child("Title").getValue().toString();
                                        categoryHolder.setTitleset(name);


                                    }

                                    categoryHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                          String title = dataSnapshot.child("Title").getValue().toString();
                                          if(title.equals("Tablets")){
                                              goto_tebletspage(new Tablets());
                                          }
                                          if(title.equals("Accessories")){
                                              goto_tebletspage(new Accessories());
                                          }
                                          if(title.equals("Mobile Phones")){
                                              goto_tebletspage(new MobilePhones());
                                          }
                                          if(title.equals("Cars")){
                                              goto_tebletspage(new Cars());
                                          }
                                          if(title.equals("Cars on Installments")){
                                              goto_tebletspage(new Car_On_Installments());
                                          }
                                        }
                                    });

                                }
                                else {

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
            }
        };

        categorylist.setAdapter(firebaseRecyclerAdapter);
        super.onStart();
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder{

        private MaterialTextView title;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);


            title = itemView.findViewById(R.id.CategoryNameID);
        }

        public void setTitleset(String name){
            title.setText(name);
        }
    }

    private void goto_tebletspage(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment).addToBackStack(null);
            transaction.commit();
        }
    }
}