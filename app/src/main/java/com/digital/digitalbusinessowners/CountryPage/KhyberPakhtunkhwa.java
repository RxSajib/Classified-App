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
        Twentyone.setName(getString(R.string.Malakand));



        locationList.add(one);

        recyclerView.setAdapter(counteyLocationAdapter);

    }
}