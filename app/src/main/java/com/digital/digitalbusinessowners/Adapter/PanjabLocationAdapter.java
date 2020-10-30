package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.Model.OnboardingList;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

public class PanjabLocationAdapter extends RecyclerView.Adapter<PanjabLocationAdapter.PanjabHolder>{

    private Context context;
    private List<Location> locationList;

    public PanjabLocationAdapter(Context context, List<Location> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public PanjabHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcatagory_tem, parent, false);
        return new PanjabHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PanjabHolder holder, int position) {
        holder.setNameset(locationList.get(position));
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    class PanjabHolder extends RecyclerView.ViewHolder{

        private MaterialTextView name;

        public PanjabHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.SubcatagoryTitle);
        }

        public void setNameset(Location location){
            name.setText(location.getName());
        }
    }

}
