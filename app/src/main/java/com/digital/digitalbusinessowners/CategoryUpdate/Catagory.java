package com.digital.digitalbusinessowners.CategoryUpdate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.digital.digitalbusinessowners.R;

public class Catagory extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        categoryplaceholder(new CategoryPlaceHolder());
    }

    private void categoryplaceholder(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CategoryHolder, fragment);
            transaction.commit();
        }
    }
}