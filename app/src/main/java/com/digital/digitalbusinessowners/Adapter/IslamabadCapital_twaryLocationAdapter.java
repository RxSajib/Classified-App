package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class IslamabadCapital_twaryLocationAdapter extends RecyclerView.Adapter<IslamabadCapital_twaryLocationAdapter.IslamabadCapitalTwary>{


    private Context context;
    private List<Location> locationList;

    public IslamabadCapital_twaryLocationAdapter(Context context, List<Location> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public IslamabadCapitalTwary onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcatagory_tem, parent, false);
        return new IslamabadCapitalTwary(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IslamabadCapitalTwary holder, int position) {
        holder.setNameset(locationList.get(position));
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public class IslamabadCapitalTwary extends RecyclerView.ViewHolder{

        private MaterialTextView name;

        public IslamabadCapitalTwary(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.SubcatagoryTitle);
        }

        public void setNameset(Location location){
            name.setText(location.getName());
        }
    }
}
