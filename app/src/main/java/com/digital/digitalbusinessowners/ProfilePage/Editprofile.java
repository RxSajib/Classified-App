package com.digital.digitalbusinessowners.ProfilePage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.anstrontechnologies.corehelper.AnstronCoreHelper;
import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hbb20.CountryCodePicker;
import com.iceteck.silicompressorr.FileUtils;
import com.iceteck.silicompressorr.SiliCompressor;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Editprofile extends AppCompatActivity {

    private RelativeLayout backbutton;
    private RelativeLayout updatebutton;
    private EditText name, email, city, country, mobileinput;
    private CircleImageView profileimage;
    private CountryCodePicker codePicker;
    private FirebaseAuth Mauth;
    private String CurrentuserID;
    private DatabaseReference MuserDatabase;
    private String Permission[] = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int PermissionCode = 1;
    private final int IMAGECODE = 100;
    private AnstronCoreHelper coreHelper;
    private StorageReference MprofileStores;
    private String ImageDownloadURI;

    private String Name, Email, City, Country, MobileFullnumber, Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        MprofileStores = FirebaseStorage.getInstance().getReference().child(DataManager.ProfileImageRef);
        coreHelper = new AnstronCoreHelper(Editprofile.this);
        MuserDatabase = FirebaseDatabase.getInstance().getReference().child(DataManager.UserRoot);
        Mauth = FirebaseAuth.getInstance();
        CurrentuserID = Mauth.getCurrentUser().getUid();

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }

        mobileinput = findViewById(R.id.PhoneNumber);
        codePicker = findViewById(R.id.CountryCodePickerID);
        codePicker.registerCarrierNumberEditText(mobileinput);

        profileimage = findViewById(R.id.ProfileImage);
        name = findViewById(R.id.NameInput);
        email = findViewById(R.id.EmailInput);
        city = findViewById(R.id.City);
        country = findViewById(R.id.CountryID);


        backbutton = findViewById(R.id.BackButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        updatebutton = findViewById(R.id.UpdateButton);

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Name = name.getText().toString().trim();
                 Email = email.getText().toString().trim();
                 City = city.getText().toString().trim();
                 Country = country.getText().toString().trim();
                 MobileFullnumber = codePicker.getFullNumber();
                 Number = mobileinput.getText().toString().trim();


                if(Name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Name require", Toast.LENGTH_LONG).show();
                }
                else if(Email.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Email require", Toast.LENGTH_LONG).show();
                }
                else if(City.isEmpty()){
                    Toast.makeText(getApplicationContext(), "City require", Toast.LENGTH_LONG).show();
                }
                else if(Number.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Number require", Toast.LENGTH_LONG).show();
                }

                else {

                    Map<String, Object> usermap = new HashMap<String, Object>();
                    usermap.put(DataManager.Name, Name);
                    usermap.put(DataManager.Email, Email);
                    usermap.put(DataManager.SecondPhoneNumber, MobileFullnumber);
                    usermap.put(DataManager.City, City);
                    usermap.put(DataManager.Country, Country);
                    usermap.put(DataManager.ProfileImageURI, ImageDownloadURI);
                    usermap.put(DataManager.PhoneNumberWithCoutCode, Number);

                    MuserDatabase.child(CurrentuserID).updateChildren(usermap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(), "Profile is update success", Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });

                }


            }
        });

        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheackPermission()) {

                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, IMAGECODE);
                }
            }
        });

        getdata();
    }

    private void getdata(){
        MuserDatabase.child(CurrentuserID)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            if(dataSnapshot.hasChild(DataManager.Name)){
                                String Nameget = dataSnapshot.child(DataManager.Name).getValue().toString();
                                name.setText(Nameget);
                            }

                            if(dataSnapshot.hasChild(DataManager.Email)){
                                String Email = dataSnapshot.child(DataManager.Email).getValue().toString();
                                email.setText(Email);
                            }
                            if(dataSnapshot.hasChild(DataManager.PhoneNumberWithCoutCode)){
                                String Number = dataSnapshot.child(DataManager.PhoneNumberWithCoutCode).getValue().toString();
                                mobileinput.setText(Number);
                            }
                            if(dataSnapshot.hasChild(DataManager.City)){
                                String City = dataSnapshot.child(DataManager.City).getValue().toString();
                                city.setText(City);
                            }
                            if(dataSnapshot.hasChild(DataManager.Country)){
                                String mycountry = dataSnapshot.child(DataManager.Country).getValue().toString();
                                country.setText(mycountry);
                            }
                            if(dataSnapshot.hasChild(DataManager.ProfileImageURI)){
                                String uri = dataSnapshot.child(DataManager.ProfileImageURI).getValue().toString();
                                Picasso.with(getApplicationContext()).load(uri).into(profileimage);
                            }
                        }
                        else {

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    private boolean CheackPermission(){
        if(ContextCompat.checkSelfPermission(Editprofile.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else {
            ActivityCompat.requestPermissions(Editprofile.this, Permission, PermissionCode);
            return false;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri imageuri = data.getData();



            profileimage.setImageURI(imageuri);


            File file = new File(SiliCompressor.with(getApplicationContext())
                .compress(FileUtils.getPath(getApplicationContext(), imageuri), new File(getApplicationContext().getCacheDir(), "file")));


            Uri fromfile = Uri.fromFile(file);

            MprofileStores.child(coreHelper.getFileNameFromUri(fromfile))
                    .putFile(fromfile)
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()){
                                ImageDownloadURI = task.getResult().getDownloadUrl().toString();
                            }
                            else {
                                Toast.makeText(Editprofile.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Editprofile.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });


    }
}