package com.digital.digitalbusinessowners.PostPage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.digital.digitalbusinessowners.R;
import com.makeramen.roundedimageview.RoundedImageView;

import static android.app.Activity.RESULT_OK;


public class PostPage extends Fragment {

    private RelativeLayout addimage;
    private String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int IMAGEPERMISSION = 100;
    private int IMAGECODEONE = 1;
    private int IMAGECODETWO = 2;
    private RoundedImageView imageone, imagetwo;

    public PostPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.post_page, container, false);


        imageone = view.findViewById(R.id.ImageOne);
        imagetwo = view.findViewById(R.id.ImageTwo);
        imageone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheackPermission()) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, IMAGECODEONE);
                }
            }
        });

        imagetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGECODETWO);
            }
        });



        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);



        return view;
    }

    public boolean CheackPermission(){
        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), permission, IMAGEPERMISSION);
            return false;
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri imageoneuri = data.getData();
        if(requestCode == IMAGECODEONE && resultCode == RESULT_OK){

            if(imageoneuri != null){
                imageone.setImageURI(imageoneuri);
            }
            else {


            }
        }

        if(requestCode == IMAGECODETWO && resultCode == RESULT_OK){

            if(imageoneuri != null){
                imagetwo.setImageURI(imageoneuri);
            }
            else {


            }
        }






    }
}