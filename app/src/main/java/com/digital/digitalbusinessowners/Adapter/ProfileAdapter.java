package com.digital.digitalbusinessowners.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.digitalbusinessowners.Model.ProfileList;
import com.digital.digitalbusinessowners.ProfilePage.Editprofile;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder>{

    private Context context;
    private List<ProfileList> profileLists;

    public ProfileAdapter(Context context, List<ProfileList> profileLists) {
        this.context = context;
        this.profileLists = profileLists;
    }

    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_view, parent, false);
        return new ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder holder, int position) {
        holder.SetList(profileLists.get(position));

        ProfileList iteams = profileLists.get(position);
        String type = iteams.getProfileviewtext();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Profile")){
                    Intent intent = new Intent(holder.itemView.getContext(), Editprofile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return profileLists.size();
    }

    public class ProfileHolder extends RecyclerView.ViewHolder{

        private ImageView profileimage;
        private MaterialTextView profiletext;
        private MaterialTextView counter;

        public ProfileHolder(@NonNull View itemView) {
            super(itemView);

            profileimage = itemView.findViewById(R.id.profileListIcon);
            profiletext = itemView.findViewById(R.id.ProfileListText);
            counter = itemView.findViewById(R.id.MyPostCounter);
        }

       private void SetList(ProfileList profileList){
            profileimage.setBackgroundResource(profileList.getProfileviewimage());
            profiletext.setText(profileList.getProfileviewtext());


        }
    }
}
