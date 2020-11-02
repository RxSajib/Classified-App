package com.digital.digitalbusinessowners.UpdateAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Model.CategoryUpdateList;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryHolder>{

    private Context context;
    private List<CategoryUpdateList> categoryUpdateLists;

    public AllCategoryAdapter(Context context, List<CategoryUpdateList> categoryUpdateLists) {
        this.context = context;
        this.categoryUpdateLists = categoryUpdateLists;
    }

    @NonNull
    @Override
    public AllCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_layout_update, parent, false);

        return new AllCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryHolder holder, int position) {
        holder.setTitleset(categoryUpdateLists.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryUpdateLists.size();
    }

    public class AllCategoryHolder extends RecyclerView.ViewHolder{

        private MaterialTextView title;

        public AllCategoryHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.CategoryNameID);
        }

        public void setTitleset(CategoryUpdateList categoryUpdateList){
            title.setText(categoryUpdateList.getTitle());
        }
    }
}
