package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.IslamabadCapital_twaryLocationAdapter;
import com.digital.digitalbusinessowners.Adapter.Khyber_pakhtunkhwa_locationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class KhyberPakhtunkhwa extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private Khyber_pakhtunkhwa_locationAdapter counteyLocationAdapter;


    public KhyberPakhtunkhwa() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.khyber_pakhtunkhwa, container, false);


        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        setdata();


        return view;
    }

    private void setdata() {

        counteyLocationAdapter = new Khyber_pakhtunkhwa_locationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.abbottabad));

        Location two = new Location();
        two.setName(getString(R.string.Ali_Masjid));

        Location three = new Location();
        three.setName(getString(R.string.bannnu));

        Location four = new Location();
        four.setName(getString(R.string.Batagram));

        Location five = new Location();
        five.setName(getString(R.string.Buner));

        Location six = new Location();
        six.setName(getString(R.string.Charsadda));

        Location seven = new Location();
        seven.setName(getString(R.string.Chitral));

        Location eight = new Location();
        eight.setName(getString(R.string.Darra_Adam_Khel));

        Location nine = new Location();
        nine.setName(getString(R.string.Dera_Ismail_Khan));

        Location ten = new Location();
        ten.setName(getString(R.string.Hangu));

        Location eleven = new Location();
        eleven.setName(getString(R.string.Haripur));

        Location twelve = new Location();
        twelve.setName(getString(R.string.Jamrud));

        Location thirteen = new Location();
        thirteen.setName(getString(R.string.Jandola));

        Location forteen = new Location();
        forteen.setName(getString(R.string.Karak));

        Location fiveteen = new Location();
        fiveteen.setName(getString(R.string.Kohat));

        Location sixteen = new Location();
        sixteen.setName(getString(R.string.Kohistan));

        Location seventeen = new Location();
        seventeen.setName(getString(R.string.Lakki_Marwat));

        Location eighteen = new Location();
        eighteen.setName(getString(R.string.Landi_Kotal));

        Location nineteen = new Location();
        nineteen.setName(getString(R.string.Lower_Dir));


        Location Twenty = new Location();
        Twenty.setName(getString(R.string.Malakand));

        Location Twentyone = new Location();
        Twentyone.setName(getString(R.string.Mansehra));

        Location Twentytwo = new Location();
        Twentytwo.setName(getString(R.string.Mardan));

        Location Twentythree = new Location();
        Twentythree.setName(getString(R.string.Mingaora));

        Location Twentytfour = new Location();
        Twentytfour.setName(getString(R.string.Miram_Shah));

        Location Twentytfive = new Location();
        Twentytfive.setName(getString(R.string.Nowshera));

        Location TwentytSix = new Location();
        TwentytSix.setName(getString(R.string.Parachinar));

        Location TwentytSeven = new Location();
        TwentytSeven.setName(getString(R.string.Peshawar));

        Location TwentytEight = new Location();
        TwentytEight.setName(getString(R.string.Shangla));

        Location TwentytNine = new Location();
        TwentytNine.setName(getString(R.string.Swabi));

        Location Thirtee = new Location();
        Thirtee.setName(getString(R.string.Swat));

        Location Thirteeone = new Location();
        Thirteeone.setName(getString(R.string.Tank));

        Location Thirteetwo = new Location();
        Thirteetwo.setName(getString(R.string.Torkham));

        Location Thirteethree = new Location();
        Thirteethree.setName(getString(R.string.Upper_Dir));

        Location Thirteefour = new Location();
        Thirteefour.setName(getString(R.string.Wana));


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
        locationList.add(forteen);
        locationList.add(fiveteen);
        locationList.add(sixteen);
        locationList.add(seventeen);
        locationList.add(eighteen);
        locationList.add(nineteen);
        locationList.add(Twenty);
        locationList.add(Twentyone);
        locationList.add(Twentytwo);
        locationList.add(Twentythree);
        locationList.add(Twentytfour);
        locationList.add(Twentytfive);
        locationList.add(TwentytSix);
        locationList.add(TwentytSeven);
        locationList.add(TwentytEight);
        locationList.add(TwentytNine);
        locationList.add(Thirtee);
        locationList.add(Thirteeone);
        locationList.add(Thirteetwo);
        locationList.add(Thirteethree);
        locationList.add(Thirteefour);


        recyclerView.setAdapter(counteyLocationAdapter);

    }
}