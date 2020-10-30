package com.digital.digitalbusinessowners.CountryPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital.digitalbusinessowners.Adapter.NorthanAreaLocationAdapter;
import com.digital.digitalbusinessowners.Adapter.PanjabLocationAdapter;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;

import java.util.ArrayList;
import java.util.List;


public class Panjab extends Fragment {

    private RecyclerView recyclerView;
    private List<Location> locationList = new ArrayList<>();
    private PanjabLocationAdapter counteyLocationAdapter;


    public Panjab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.panjab, container, false);

        recyclerView = view.findViewById(R.id.AzadKashmirID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        setdata();

        return view;
    }

    private void setdata() {

        counteyLocationAdapter = new PanjabLocationAdapter(getActivity(), locationList);

        Location one = new Location();
        one.setName(getString(R.string.Ahmadpur_East));

        Location two = new Location();
        two.setName(getString(R.string.Arifwala));

        Location three = new Location();
        three.setName(getString(R.string.Attock));

        Location four = new Location();
        four.setName(getString(R.string.Bahawalnagar));

        Location five = new Location();
        five.setName(getString(R.string.Bahawalpur));

        Location six = new Location();
        six.setName(getString(R.string.Bhakkar));

        Location seven = new Location();
        seven.setName(getString(R.string.Burewala));

        Location eight = new Location();
        eight.setName(getString(R.string.Chakwal));

        Location nine = new Location();
        nine.setName(getString(R.string.Chichawatni));

        Location ten = new Location();
        ten.setName(getString(R.string.Chiniot));

        Location eleven = new Location();
        eleven.setName(getString(R.string.Chishtian_Mandi));

        Location twelve = new Location();
        twelve.setName(getString(R.string.Daska));

        Location thirteen = new Location();
        thirteen.setName(getString(R.string.Depalpur));

        Location fourtheen = new Location();
        fourtheen.setName(getString(R.string.Dera_Ghazi_Khan));

        Location fiveteen = new Location();
        fiveteen.setName(getString(R.string.Faisalabad));



        Location sixteen = new Location();
        sixteen.setName(getString(R.string.Gojra));

        Location seventeen = new Location();
        seventeen.setName(getString(R.string.Gujar_Khan));

        Location eighteen = new Location();
        eighteen.setName(getString(R.string.Gujranwala));

        Location nineteen = new Location();
        nineteen.setName(getString(R.string.Gujrat));

        Location tweenty = new Location();
        tweenty.setName(getString(R.string.Hafizabad));

        Location tweentyone = new Location();
        tweentyone.setName(getString(R.string.Haroonabad));

        Location tweentytwo = new Location();
        tweentytwo.setName(getString(R.string.Hasan_Abdal));

        Location tweentythree = new Location();
        tweentythree.setName(getString(R.string.Hasilpur));

        Location tweentyfour = new Location();
        tweentyfour.setName(getString(R.string.Haveli_lakha));

        Location tweentyfive = new Location();
        tweentyfive.setName(getString(R.string.Hazro));

        Location tweentysix = new Location();
        tweentysix.setName(getString(R.string.Jaranwala));

        Location tweentyseven = new Location();
        tweentyseven.setName(getString(R.string.Jhang_Sadar));


        Location tweentyeight = new Location();
        tweentyeight.setName(getString(R.string.Jhelum));

        Location tweentynine = new Location();
        tweentynine.setName(getString(R.string.Kamoke));

        Location thirtee = new Location();
        thirtee.setName(getString(R.string.Kasur));

        Location thirteeone = new Location();
        thirteeone.setName(getString(R.string.Khanewal));

        Location thirteetwo = new Location();
        thirteetwo.setName(getString(R.string.Khanpur));

        Location thirteethree = new Location();
        thirteethree.setName(getString(R.string.Khushab));

        Location thirteefour = new Location();
        thirteefour.setName(getString(R.string.Kot_Addu));

        Location thirteefive = new Location();
        thirteefive.setName(getString(R.string.Kotli));

        Location thirteesix = new Location();
        thirteesix.setName(getString(R.string.Lahore));

        Location thirteeseven = new Location();
        thirteeseven.setName(getString(R.string.Layyah));


        Location thirteeeight = new Location();
        thirteeeight.setName(getString(R.string.Lodhran));


        Location thirteenine = new Location();
        thirteenine.setName(getString(R.string.Mailsi));


        Location fourtee = new Location();
        fourtee.setName(getString(R.string.Mandi_Bahauddin));


        Location fourteeone = new Location();
        fourteeone.setName(getString(R.string.Mian_Chunnu));

        Location fourteetwo = new Location();
        fourteetwo.setName(getString(R.string.Mianwali));

        Location fourteethree = new Location();
        fourteethree.setName(getString(R.string.Multan));

        Location fourteefour = new Location();
        fourteefour.setName(getString(R.string.Muridike));

        Location fourteefive = new Location();
        fourteefive.setName(getString(R.string.Murree));

        Location fourteesix = new Location();
        fourteesix.setName(getString(R.string.Muzaffargarh));

        Location fourteeseven = new Location();
        fourteeseven.setName(getString(R.string.Nankana_Sahib));

        Location fourteeeight = new Location();
        fourteeeight.setName(getString(R.string.Narowal));

        Location fourteenine = new Location();
        fourteenine.setName(getString(R.string.Okara));

        Location fivty = new Location();
        fivty.setName(getString(R.string.Pakpattan));


        Location fivtyone = new Location();
        fivtyone.setName(getString(R.string.Pindi_Bhattian));

        Location fivtytwo = new Location();
        fivtytwo.setName(getString(R.string.Pirmahal));

        Location fivtythree = new Location();
        fivtythree.setName(getString(R.string.Rahimyar_Khan));

        Location fivtyfour = new Location();
        fivtyfour.setName(getString(R.string.Raiwind));

        Location fivtysix = new Location();
        fivtysix.setName(getString(R.string.Rajanpur));

        Location fivtyseven = new Location();
        fivtyseven.setName(getString(R.string.Rawalpindi));

        Location fivtyeight = new Location();
        fivtyeight.setName(getString(R.string.Sadiqabad));

        Location fivtynine = new Location();
        fivtynine.setName(getString(R.string.Safdar_Abad));

        Location sixtee = new Location();
        sixtee.setName(getString(R.string.Sahiwal));

        Location sixteeone = new Location();
        sixteeone.setName(getString(R.string.Samundri));

        Location sixteetwo = new Location();
        sixteetwo.setName(getString(R.string.Sargodha));

        Location sixteethree = new Location();
        sixteethree.setName(getString(R.string.Shakargarh));

        Location sixteefour = new Location();
        sixteefour.setName(getString(R.string.Sheikhüpura));

        Location sixteefive = new Location();
        sixteefive.setName(getString(R.string.Sialkot));

        Location sixteesix = new Location();
        sixteesix.setName(getString(R.string.Sohawa));

        Location sixteeseven = new Location();
        sixteeseven.setName(getString(R.string.Talagang));

        Location sixteeseight = new Location();
        sixteeseight.setName(getString(R.string.Taxila));

        Location sixteesnine = new Location();
        sixteesnine.setName(getString(R.string.Toba_Tek_singh));

        Location seventy = new Location();
        seventy.setName(getString(R.string.Vehari));

        Location seventyone = new Location();
        seventyone.setName(getString(R.string.Wah));

        Location seventytwo = new Location();
        seventytwo.setName(getString(R.string.Wazirabad));


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
        locationList.add(tweentyone);
        locationList.add(tweentytwo);
        locationList.add(tweentythree);
        locationList.add(tweentyfour);
        locationList.add(tweentyfive);
        locationList.add(tweentysix);
        locationList.add(tweentyseven);
        locationList.add(tweentyeight);
        locationList.add(tweentynine);
        locationList.add(thirtee);
        locationList.add(thirteeone);
        locationList.add(thirteetwo);
        locationList.add(thirteethree);
        locationList.add(thirteefour);
        locationList.add(thirteefive);
        locationList.add(thirteesix);
        locationList.add(thirteeseven);
        locationList.add(thirteeeight);
        locationList.add(thirteenine);
        locationList.add(fourtee);
        locationList.add(fourteeone);
        locationList.add(fourteetwo);
        locationList.add(fourteethree);
        locationList.add(fourteefour);
        locationList.add(fourteefive);
        locationList.add(fourteesix);
        locationList.add(fourteeseven);
        locationList.add(fourteeeight);
        locationList.add(fourteenine);
        locationList.add(fivty);
        locationList.add(fivtyone);
        locationList.add(fivtytwo);
        locationList.add(fivtythree);
        locationList.add(fivtyfour);
        locationList.add(fivtysix);
        locationList.add(fivtyseven);
        locationList.add(fivtyeight);
        locationList.add(fivtynine);
        locationList.add(sixtee);
        locationList.add(sixteeone);
        locationList.add(sixteetwo);
        locationList.add(sixteethree);
        locationList.add(sixteefour);
        locationList.add(sixteefive);
        locationList.add(sixteesix);
        locationList.add(sixteeseven);
        locationList.add(sixteeseight);
        locationList.add(sixteesnine);
        locationList.add(seventy);
        locationList.add(seventyone);
        locationList.add(seventytwo);

        recyclerView.setAdapter(counteyLocationAdapter);

    }
}