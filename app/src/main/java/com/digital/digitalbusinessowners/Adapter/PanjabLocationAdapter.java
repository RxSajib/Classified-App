package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Catagory.AllCatagory;
import com.digital.digitalbusinessowners.Memory.SharedPref;
import com.digital.digitalbusinessowners.Model.AllCatagoryList;
import com.digital.digitalbusinessowners.Model.Location;
import com.digital.digitalbusinessowners.Model.MainCatagory;
import com.digital.digitalbusinessowners.PostPage.ProductBuy;
import com.digital.digitalbusinessowners.PostPage.propartyPost;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

public class PanjabLocationAdapter extends RecyclerView.Adapter<PanjabLocationAdapter.PanjabHolder>{

    private Context context;
    private List<Location> locationList;
    private SharedPref sharedPref;

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

        sharedPref = new SharedPref(context);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goto_main_catagorypage(new AllCatagory());
            }
        });
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



    private void goto_main_catagorypage(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CatagoryFrameID, fragment);
            transaction.commit();
        }
    }


}
