package com.digital.digitalbusinessowners.MobilePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.digital.digitalbusinessowners.R;

public class Tablets extends Fragment {

    private Spinner spinner_state, city_spinner;
    private String State[] = {"State","Azad Kashmir", "Balochistan", "Islamabad Capital Territory", "Khyber Pakhtunkhwa", "Northern Areas", "Punjab", "Sindh"};
    private String AzadKashmir[] = {"State","City","Bagh", "Bhimber", "Hajira", "Kotli", "Mirpur", "Muzaffarabad", "Pallandri", "Rawalakot"};
    private String FildState;
    private String CityDefault[] = {"City"};
    private String Balochistan[] = {"State", "Bela", "Gwadar", "Jiwani", "Kalat", "Khuzdar", "Lasbela", "Loralai", "Ormara", "Pasni", "Quetta", "Zhob"};
    private String Khyber[] = {"State", "Abbottabad", "Ali Masjid", "Bannu", "Batagram", "Buner", "Charsadda", "Chitral", "Darra Adam Khel", "Dera Ismail Khan", "Hangu", "Haripur", "Jamrud", "Jandola", "Karak", "Kohat", "Kohistan", "Lakki Marwat", "Landi Kotal", "Lower Dir", "Malakand", "Mansehra", "Mardan", "Mingaora", "Miram Shah", "Nowshera", "Parachinar", "Peshawar", "Shangla", "Swabi", "Swat", "Tank", "Torkham", "Upper Dir", "Wana"};
    private String Northern_Areas[] = {"State", "Askoley", "Chilas", "Ghanche", "Ghizer", "Gilgit", "Khaplu", "Skardu"};
    private String Punjab[] = {"State", "Ahmadpur East", "Arifwala", "Attock", "Bahawalnagar", "Bahawalpur", "Bhakkar", "Burewala", "Chakwal", "Chichawatni", "Chiniot", "Chishtian Mandi", "Daska", "Depalpur", "Dera Ghazi Khan", "Faisalabad", "Gojra", "Gujar Khan", "Gujranwala", "Gujrat", "Hafizabad", "Haroonabad", "Hasan Abdal", "Hasilpur", "Haveli lakha", "Hazro", "Jaranwala", "Jhang Sadar", "Jhelum", "Kamoke", "Kasur", "Khanewal", "Khanpur", "Khushab", "Kot Addu", "Kotli", "Lahore", "Layyah", "Lodhran", "Mailsi", "Mandi Bahauddin", "Mian Chunnu", "Mianwali", "Multan", "Muridike", "Murree", "Muzaffargarh", "Nankana Sahib", "Narowal", "Okara", "Pakpattan", "Pindi Bhattian", "Pirmahal", "Rahimyar Khan", "Raiwind", "Rajanpur", "Rawalpindi", "Sadiqabad", "Safdar Abad", "Sahiwal", "Samundri", "Sargodha", "Shakargarh", "Sheikhüpura", "Sialkot", "Sohawa", "Talagang", "Taxila", "Toba Tek singh", "Vehari", "Wah", "Wazirabad"};
    private String Islamabad_Capital_Territory[] = {"State","Islamabad"};
    private String Sindh[] = {"State", "Badin", "Dadu", "Ghotki", "Hala", "Hyderabad", "Jacobabad", "Jamshoro", "Karachi", "Khairpur", "Larkana", "Mirpur Khas", "Mithi", "Nawabshah", "Ratodero", "Sanghar", "Shikarpur", "Sukkur", "Tando Adam", "Thatta", "Umerkot"};

    public Tablets() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tablets, container, false);



        spinner_state = view.findViewById(R.id.SpinerState);
        city_spinner = view.findViewById(R.id.CityesID);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, State);
        spinner_state.setAdapter(arrayAdapter);

        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FildState = parent.getItemAtPosition(position).toString();

                change_state(FildState);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        return view;
    }

    private void change_state(String state){

        if(state.equals("Azad Kashmir")){
            city_spinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, AzadKashmir);
            city_spinner.setAdapter(arrayAdapter);
        }
         if(state.equals("Balochistan")){
            city_spinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, Balochistan);
            city_spinner.setAdapter(arrayAdapter);
        }
         if(state.equals("Islamabad Capital Territory")){
             city_spinner.setVisibility(View.VISIBLE);
             ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, Islamabad_Capital_Territory);
             city_spinner.setAdapter(arrayAdapter);
         }
         if(state.equals("Khyber Pakhtunkhwa")){
             city_spinner.setVisibility(View.VISIBLE);
             ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, Khyber);
             city_spinner.setAdapter(arrayAdapter);
         }
         if(state.equals("Northern Areas")){
             city_spinner.setVisibility(View.VISIBLE);
             ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, Northern_Areas);
             city_spinner.setAdapter(arrayAdapter);
         }
         if(state.equals("Punjab")){
             city_spinner.setVisibility(View.VISIBLE);
             ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, Punjab);
             city_spinner.setAdapter(arrayAdapter);
         }
         if(State.equals("Sindh")){
             city_spinner.setVisibility(View.VISIBLE);
             ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, Sindh);
             city_spinner.setAdapter(arrayAdapter);
         }
        if(state.equals("State")) {
            city_spinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.city_layout, R.id.CityName, CityDefault);
            city_spinner.setAdapter(arrayAdapter);
        }

    }
}