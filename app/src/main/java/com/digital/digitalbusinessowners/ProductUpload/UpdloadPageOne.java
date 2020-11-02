package com.digital.digitalbusinessowners.ProductUpload;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import com.digital.digitalbusinessowners.Adapter.UploadMainCatagoryAdapter;
import com.digital.digitalbusinessowners.Catagory.CatagoryPage;
import com.digital.digitalbusinessowners.Catagory.LocationPage;
import com.digital.digitalbusinessowners.Memory.SharedPref;
import com.digital.digitalbusinessowners.Model.MainCatagory;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class UpdloadPageOne extends AppCompatActivity {


    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updload_page_one);

        sharedPref = new SharedPref(getApplicationContext());

       goto_page_one(new LocationPage());



    }

    private void goto_page_one(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CatagoryFrameID, fragment);
            transaction.commit();
        }
    }


    @Override
    public void onBackPressed() {

   //     UpdloadPageOne.super.onBackPressed();
        MaterialAlertDialogBuilder Mbuilder = new MaterialAlertDialogBuilder(UpdloadPageOne.this);
        Mbuilder.setTitle("Do you want to leave this page?");
        Mbuilder.setIcon(R.drawable.aleart_icon_color);
        Mbuilder.setMessage("Please follow me, your information not save if you exit the App.");




        Mbuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sharedPref.clearpreference();
                UpdloadPageOne.super.onBackPressed();
            }
        });

        Mbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


       AlertDialog alertDialog = Mbuilder.create();
       alertDialog.setCanceledOnTouchOutside(false);
       alertDialog.show();

    }
}