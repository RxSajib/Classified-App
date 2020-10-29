package com.digital.digitalbusinessowners.BottomTab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.ProfileAdapter;
import com.digital.digitalbusinessowners.Model.ProfileList;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class Profile extends Fragment {

    private RecyclerView profilelist;
    private List<ProfileList> profileLists = new ArrayList<>();
    private ProfileAdapter profileAdapter;

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile, container, false);

        profilelist = view.findViewById(R.id.ProfileList);
        profilelist.setHasFixedSize(true);
        profilelist.setLayoutManager(new LinearLayoutManager(getActivity()));



        set_view();
        return view;
    }

    private void set_view(){
        ProfileList one = new ProfileList();
        one.setProfileviewtext(getString(R.string.mypost));
        one.setProfileviewimage(R.drawable.mylist);

        ProfileList two = new ProfileList();
        two.setProfileviewtext(getString(R.string.Mymembership));
        two.setProfileviewimage(R.drawable.mymembership);

        ProfileList three = new ProfileList();
        three.setProfileviewtext(getString(R.string.Favorites));
        three.setProfileviewimage(R.drawable.love);

        ProfileList four = new ProfileList();
        four.setProfileviewtext(getString(R.string.Profile));
        four.setProfileviewimage(R.drawable.profile);

        ProfileList six = new ProfileList();
        six.setProfileviewtext(getString(R.string.StaySafe));
        six.setProfileviewimage(R.drawable.safe);

        ProfileList seven = new ProfileList();
        seven.setProfileviewtext(getString(R.string.FDQ));
        seven.setProfileviewimage(R.drawable.info);

        ProfileList eight = new ProfileList();
        eight.setProfileviewtext(getString(R.string.howsellquickly));
        eight.setProfileviewimage(R.drawable.sell);

        ProfileList ten = new ProfileList();
        ten.setProfileviewtext(getString(R.string.privacypolicy));
        ten.setProfileviewimage(R.drawable.privacypolicy);

        ProfileList nine = new ProfileList();
        nine.setProfileviewtext(getString(R.string.logout));
        nine.setProfileviewimage(R.drawable.logout);

        profileLists.add(one);
        profileLists.add(two);
        profileLists.add(three);
        profileLists.add(four);
        profileLists.add(six);
        profileLists.add(seven);
        profileLists.add(eight);
        profileLists.add(ten);
        profileLists.add(nine);


        profileAdapter = new ProfileAdapter(getActivity(), profileLists);
        profilelist.setAdapter(profileAdapter);
    }
}