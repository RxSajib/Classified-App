package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Catagory.SubCatagoryPost;
import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.Memory.SharedPref;
import com.digital.digitalbusinessowners.Model.AllCatagoryList;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class CatagoryAdapter  extends RecyclerView.Adapter<CatagoryAdapter.CatagoryHolder>{

    private Context context;
    private List<AllCatagoryList> allCatagoryLists;
    private SharedPref sharedPref;

    public CatagoryAdapter(Context context, List<AllCatagoryList> allCatagoryLists) {
        this.context = context;
        this.allCatagoryLists = allCatagoryLists;
    }

    @NonNull
    @Override
    public CatagoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_layout, parent, false);
        return new CatagoryHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryHolder holder, int position) {
        holder.setallcatagory(allCatagoryLists.get(position));

        sharedPref = new SharedPref(context);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String catagoryname = allCatagoryLists.get(position).getTitle();






            }
        });

    }

    @Override
    public int getItemCount() {
        return allCatagoryLists.size();
    }

    public class CatagoryHolder extends RecyclerView.ViewHolder{

        private ImageView catagoryimage;
        private MaterialTextView catagorytitle;

        public CatagoryHolder(@NonNull View itemView) {
            super(itemView);

            catagoryimage = itemView.findViewById(R.id.Catagoryimage);
            catagorytitle = itemView.findViewById(R.id.CatagoryTitle);
        }

        public void setallcatagory(AllCatagoryList allCatagoryList){

            catagoryimage.setImageResource(allCatagoryList.getImage());
            catagorytitle.setText(allCatagoryList.getTitle());
        }

    }

    private void goto_subcatagory(Fragment fragment, String Type){
        if(fragment != null){

            Bundle bundle = new Bundle();
            bundle.putString("KEY", Type);
            fragment.setArguments(bundle);

            FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CatagoryFrameID, fragment);
            transaction.commit();
        }
    }

}
