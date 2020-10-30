package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.CountryPage.Azad_Kahmer;
import com.digital.digitalbusinessowners.CountryPage.Balochistana;
import com.digital.digitalbusinessowners.CountryPage.Islamabad_Capital_Territory;
import com.digital.digitalbusinessowners.CountryPage.KhyberPakhtunkhwa;
import com.digital.digitalbusinessowners.CountryPage.NorthernArea;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class CounteyLocationAdapter extends RecyclerView.Adapter<CounteyLocationAdapter.CountryHolder> {

    private Context context;
    private List<Location> locationList;

    public CounteyLocationAdapter(Context context, List<Location> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcatagory_tem, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        holder.setlocation(locationList.get(position));

        String name = locationList.get(position).getName();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.equals("Azad Kashmir")){
                    goto_ajadkasmir(new Azad_Kahmer());
                }
                if(name.equals("Balochistan")){
                    goto_ajadkasmir(new Balochistana());
                }
                if(name.equals("Islamabad Capital Territory")){
                    goto_ajadkasmir(new Islamabad_Capital_Territory());
                }
                if(name.equals("Khyber Pakhtunkhwa")){
                    goto_ajadkasmir(new KhyberPakhtunkhwa());
                }
                if(name.equals("Northern Areas")){
                    goto_ajadkasmir(new NorthernArea());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder{

        private MaterialTextView name;

        public CountryHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.SubcatagoryTitle);
        }

        public void setlocation(Location location){
            name.setText(location.getName());
        }
    }

    private void goto_ajadkasmir(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CatagoryFrameID, fragment);
            transaction.commit();
        }
    }
}
