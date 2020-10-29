package com.digital.digitalbusinessowners.Catagory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.Memory.SharedPref;
import com.digital.digitalbusinessowners.Model.CatagoryList;
import com.digital.digitalbusinessowners.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubCatagoryPost extends Fragment {

    private RecyclerView subcatagory;
    private String Datakey;
    private DatabaseReference MDatabase;
    private SharedPref sharedPref;

    public SubCatagoryPost() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.sub_catagory_post, container, false);

        sharedPref = new SharedPref(getActivity());
        subcatagory = view.findViewById(R.id.SubcatagoryID);
        subcatagory.setHasFixedSize(true);
        subcatagory.setLayoutManager(new LinearLayoutManager(getActivity()));
        subcatagory.addItemDecoration(new DividerItemDecoration(subcatagory.getContext(), DividerItemDecoration.VERTICAL));


        Bundle bundle = getArguments();
        Datakey = bundle.getString("KEY");

        if (Datakey != null) {
            MDatabase = FirebaseDatabase.getInstance().getReference().child(Datakey);
        }


        //     getData();


        return view;
    }

    @Override
    public void onStart() {


        FirebaseRecyclerAdapter<CatagoryList, SubHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<CatagoryList, SubHolder>(
                CatagoryList.class,
                R.layout.subcatagory_tem,
                SubHolder.class,
                MDatabase
        ) {
            @Override
            protected void populateViewHolder(SubHolder subHolder, CatagoryList catagoryList, int i) {
                String UID = getRef(i).getKey();
                MDatabase.child(UID)
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    if (dataSnapshot.hasChild(DataManager.CategoryTitle)) {
                                        String title = dataSnapshot.child(DataManager.CategoryTitle).getValue().toString();
                                        subHolder.setTitleSet(title);


                                        if(!title.isEmpty()){

                                            subHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String catagorytitle = dataSnapshot.child(DataManager.CategoryTitle).getValue().toString();

                                                    sharedPref.putString("SUBCATAGORY", catagorytitle);
                                                    goto_locationpage(new LocationPage());
                                                }
                                            });

                                        }

                                    }
                                } else {

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
            }
        };



        subcatagory.setAdapter(firebaseRecyclerAdapter);
        super.onStart();
    }


    public static class SubHolder extends RecyclerView.ViewHolder {

        private MaterialTextView title;

        public SubHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.SubcatagoryTitle);
        }

        public void setTitleSet(String tit) {
            title.setText(tit);
        }
    }

    private void goto_locationpage(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CatagoryFrameID, fragment);
            transaction.commit();
        }
    }
}