package com.digital.digitalbusinessowners.Catagory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.Model.CatagoryList;
import com.digital.digitalbusinessowners.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubCatagory extends AppCompatActivity {

    private String DataRoot, Name;
    private DatabaseReference MSubcatagoryRoot;
    private RecyclerView catagorylist;
    private MaterialTextView CatagoryNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catagory);

        CatagoryNameText = findViewById(R.id.CatagoryName);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }

        catagorylist = findViewById(R.id.CatagoryListID);
        catagorylist.setHasFixedSize(true);
        catagorylist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        DataRoot = getIntent().getStringExtra(DataManager.DATAROOT);
        Name = getIntent().getStringExtra(DataManager.CatagoryName);
        if(!DataRoot.isEmpty()){
            MSubcatagoryRoot = FirebaseDatabase.getInstance().getReference().child(DataRoot);
            CatagoryNameText.setText(Name);

            showcatagory();

        }

    }


    private void showcatagory() {

        FirebaseRecyclerAdapter<CatagoryList, CatagoryHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<CatagoryList, CatagoryHolder>(
                CatagoryList.class,
                R.layout.subcatagory,
                CatagoryHolder.class,
                MSubcatagoryRoot
        ) {
            @Override
            protected void populateViewHolder(CatagoryHolder catagoryHolder, CatagoryList catagoryList, int i) {
                String UID = getRef(i).getKey();
                MSubcatagoryRoot.child(UID)
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    if (dataSnapshot.hasChild(DataManager.CategoryTitle)) {
                                        String title = dataSnapshot.child(DataManager.CategoryTitle).getValue().toString();
                                        catagoryHolder.setCatagorynameset(title);
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

        catagorylist.setAdapter(firebaseRecyclerAdapter);

    }

    public static class CatagoryHolder extends RecyclerView.ViewHolder {

        private MaterialTextView catagoryname;

        public CatagoryHolder(@NonNull View itemView) {
            super(itemView);

            catagoryname = itemView.findViewById(R.id.CatagoryName);
        }

        public void setCatagorynameset(String nam) {
            catagoryname.setText(nam);
        }
    }
}