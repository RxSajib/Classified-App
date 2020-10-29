package com.digital.digitalbusinessowners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.digital.digitalbusinessowners.BottomTab.Chat;
import com.digital.digitalbusinessowners.BottomTab.Home;
import com.digital.digitalbusinessowners.BottomTab.Profile;
import com.digital.digitalbusinessowners.BottomTab.Search;
import com.digital.digitalbusinessowners.Memory.SharedPref;
import com.digital.digitalbusinessowners.ProductUpload.UpdloadPageOne;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePage extends AppCompatActivity {

    private ImageView homeicon, searchicon, chaticon, profileicon;
    private MaterialTextView hometext, searchtext;
    private LinearLayout homebutton, searchbutton, chatbutton, profilebutton;
    private CircleImageView profileimage;
    private FirebaseAuth Mauth;
    private String CurrentuserID;
    private DatabaseReference MuserDatabase;
    private FloatingActionButton uploadproductbutton;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);



        uploadproductbutton = findViewById(R.id.UploadProfuctButton);
        uploadproductbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UpdloadPageOne.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Mauth = FirebaseAuth.getInstance();
        CurrentuserID = Mauth.getCurrentUser().getUid();
        MuserDatabase = FirebaseDatabase.getInstance().getReference().child(DataManager.UserRoot);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }


        profileimage = findViewById(R.id.ProfileImage);
        setHome(new Home());

        setup_image();

        homeicon = findViewById(R.id.HomeIcon);
        hometext = findViewById(R.id.HomeText);
        chaticon = findViewById(R.id.ChatIcon);
        chatbutton = findViewById(R.id.ChatButton);
        profileicon = findViewById(R.id.ProfileIcon);
        profilebutton = findViewById(R.id.ProfileButton);

        searchicon = findViewById(R.id.SearchIcon);
        searchtext = findViewById(R.id.SearchText);
        searchbutton = findViewById(R.id.SearchButtons);

        homebutton = findViewById(R.id.HomeButton);

        homeicon.setImageDrawable(getResources().getDrawable(R.drawable.home_icon_green));
        homebutton.setBackground(getResources().getDrawable(R.drawable.tab_selected));

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeicon.setImageDrawable(getResources().getDrawable(R.drawable.home_icon_green));
                homebutton.setBackground(getResources().getDrawable(R.drawable.tab_selected));

                searchicon.setImageDrawable(getResources().getDrawable(R.drawable.search_black));
                searchbutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                chaticon.setImageDrawable(getResources().getDrawable(R.drawable.chat_black));
                chatbutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                profileicon.setImageDrawable(getResources().getDrawable(R.drawable.profile_black));
                profilebutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                setHome(new Home());
            }
        });


        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchicon.setImageDrawable(getResources().getDrawable(R.drawable.search_green));
                searchbutton.setBackground(getResources().getDrawable(R.drawable.tab_selected));

                homeicon.setImageDrawable(getResources().getDrawable(R.drawable.home_black));
                homebutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                chaticon.setImageDrawable(getResources().getDrawable(R.drawable.chat_black));
                chatbutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                profileicon.setImageDrawable(getResources().getDrawable(R.drawable.profile_black));
                profilebutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                setHome(new Search());
            }
        });

        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chaticon.setImageDrawable(getResources().getDrawable(R.drawable.chat_green));
                chatbutton.setBackground(getResources().getDrawable(R.drawable.tab_selected));

                searchicon.setImageDrawable(getResources().getDrawable(R.drawable.search_black));
                searchbutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                homeicon.setImageDrawable(getResources().getDrawable(R.drawable.home_black));
                homebutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                profileicon.setImageDrawable(getResources().getDrawable(R.drawable.profile_black));
                profilebutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));


                setHome(new Chat());
            }
        });

        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileicon.setImageDrawable(getResources().getDrawable(R.drawable.profilegreen));
                profilebutton.setBackground(getResources().getDrawable(R.drawable.tab_selected));

                homeicon.setImageDrawable(getResources().getDrawable(R.drawable.home_black));
                homebutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                searchicon.setImageDrawable(getResources().getDrawable(R.drawable.search_black));
                searchbutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                chaticon.setImageDrawable(getResources().getDrawable(R.drawable.chat_black));
                chatbutton.setBackground(getResources().getDrawable(R.drawable.tab_unselected));

                setHome(new Profile());
            }
        });
    }

    private void setHome(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.HomeFream, fragment);
            transaction.commit();
        }
    }

    private void setup_image(){
        MuserDatabase.child(CurrentuserID)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            if(dataSnapshot.hasChild(DataManager.ProfileImageURI)){
                                String uri = dataSnapshot.child(DataManager.ProfileImageURI).getValue().toString();
                                Picasso.with(getApplicationContext()).load(uri).into(profileimage);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
}