package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.PanjabLocationAdapter;
import com.digital.digitalbusinessowners.Adapter.SindhLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;

public class Sindh extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private SindhLocationAdapter counteyLocationAdapter;


    public Sindh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.sindh, container, false);


        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        setdata();


        return  view;
    }

    private void setdata() {

        counteyLocationAdapter = new SindhLocationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.Badin));

        Location two = new Location();
        two.setName(getString(R.string.Dadu));

        Location three = new Location();
        three.setName(getString(R.string.Ghotki));

        Location four = new Location();
        four.setName(getString(R.string.Hala));

        Location five = new Location();
        five.setName(getString(R.string.Hyderabad));

        Location six = new Location();
        six.setName(getString(R.string.Jacobabad));

        Location seven = new Location();
        seven.setName(getString(R.string.Jamshoro));

        Location eight = new Location();
        eight.setName(getString(R.string.Karachi));

        Location nine = new Location();
        nine.setName(getString(R.string.Khairpur));

        Location ten = new Location();
        ten.setName(getString(R.string.Larkana));

        Location eleven = new Location();
        eleven.setName(getString(R.string.Mirpur_Khas));

        Location twelve = new Location();
        twelve.setName(getString(R.string.Mithi));

        Location thirteen = new Location();
        thirteen.setName(getString(R.string.Nawabshah));

        Location fourtheen = new Location();
        fourtheen.setName(getString(R.string.Ratodero));

        Location fiveteen = new Location();
        fiveteen.setName(getString(R.string.Sanghar));



        Location sixteen = new Location();
        sixteen.setName(getString(R.string.Shikarpur));

        Location seventeen = new Location();
        seventeen.setName(getString(R.string.Sukkur));

        Location eighteen = new Location();
        eighteen.setName(getString(R.string.Tando_Adam));

        Location nineteen = new Location();
        nineteen.setName(getString(R.string.Thatta));

        Location tweenty = new Location();
        tweenty.setName(getString(R.string.Umerkot));


        locationList.add(one);
        locationList.add(two);
        locationList.add(three);
        locationList.add(four);
        locationList.add(five);
        locationList.add(six);
        locationList.add(seven);
        locationList.add(eight);
        locationList.add(nine);
        locationList.add(ten);
        locationList.add(eleven);
        locationList.add(twelve);
        locationList.add(thirteen);
        locationList.add(fourtheen);
        locationList.add(fiveteen);
        locationList.add(sixteen);
        locationList.add(seventeen);
        locationList.add(eighteen);
        locationList.add(nineteen);
        locationList.add(tweenty);


        recyclerView.setAdapter(counteyLocationAdapter);

    }
}