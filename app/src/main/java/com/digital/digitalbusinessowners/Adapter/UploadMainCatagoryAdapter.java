package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Catagory.AllCatagory;
import com.digital.digitalbusinessowners.Catagory.JobCatagory;
import com.digital.digitalbusinessowners.Catagory.RentCatagory;
import com.digital.digitalbusinessowners.Model.MainCatagory;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class UploadMainCatagoryAdapter extends RecyclerView.Adapter<UploadMainCatagoryAdapter.MainCatagoryHolder>{

    private Context context;
    private List<MainCatagory> mainCatagoryList;

    public UploadMainCatagoryAdapter(Context context, List<MainCatagory> mainCatagoryList) {
        this.context = context;
        this.mainCatagoryList = mainCatagoryList;
    }

    @NonNull
    @Override
    public MainCatagoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updoad_catagory_iteams, parent, false);
        return new MainCatagoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCatagoryHolder holder, int position) {
        holder.setcatagory(mainCatagoryList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = mainCatagoryList.get(position).getTitle();
                if(title.equals("Searching for any product Buy")){
                    goto_all_catagorypage(new AllCatagory());
                }
                if(title.equals("Any product property or services sold")){
                    goto_all_catagorypage(new AllCatagory());
                }
                if(title.equals("Rent for property Advertising")){
                    goto_all_catagorypage(new RentCatagory());
                }
                if(title.equals("Searching for any rent")){
                    goto_all_catagorypage(new RentCatagory());
                }
                if(title.equals("For recruitment job advertising post")){
                    goto_all_catagorypage(new JobCatagory());
                }

            }



        });

    }

    @Override
    public int getItemCount() {
        return mainCatagoryList.size();
    }

    public class MainCatagoryHolder extends RecyclerView.ViewHolder{

        private MaterialTextView catagorytitle;

        public MainCatagoryHolder(@NonNull View itemView) {
            super(itemView);

            catagorytitle = itemView.findViewById(R.id.CatagoryNameID);
        }

        public void setcatagory(MainCatagory mainCatagory){
            catagorytitle.setText(mainCatagory.getTitle());
        }
    }

    private void goto_all_catagorypage(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.CatagoryFrameID, fragment);
            transaction.commit();
        }
    }


}
