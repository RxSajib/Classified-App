package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class AzadKasmerLocaionAdapter extends RecyclerView.Adapter<AzadKasmerLocaionAdapter.AzadKasmerHolder>{

    private Context context;
    private List<Location> locationList;

    public AzadKasmerLocaionAdapter(Context context, List<Location> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public AzadKasmerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcatagory_tem, parent, false);
        return new AzadKasmerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AzadKasmerHolder holder, int position) {
        holder.setNameset(locationList.get(position));
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public class AzadKasmerHolder extends RecyclerView.ViewHolder{

        private MaterialTextView name;

        public AzadKasmerHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.SubcatagoryTitle);
        }

        public void setNameset(Location location){
            name.setText(location.getName());
        }
    }
}
