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

public class SindhLocationAdapter extends RecyclerView.Adapter<SindhLocationAdapter.SindhHolder>{


    private Context context;
    private List<Location> locationList;

    public SindhLocationAdapter(Context context, List<Location> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public SindhHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcatagory_tem, parent, false);
        return new SindhHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SindhHolder holder, int position) {
        holder.setNameset(locationList.get(position));
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }


    public class SindhHolder extends RecyclerView.ViewHolder{

        private MaterialTextView name;

        public SindhHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.SubcatagoryTitle);
        }
        public void setNameset(Location location){
            name.setText(location.getName());
        }
    }

}
