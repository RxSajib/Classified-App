package com.digital.digitalbusinessowners.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.digital.digitalbusinessowners.Model.OnboardingList;
import com.digital.digitalbusinessowners.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnBoardingHolder>{

    private List<OnboardingList> onboardingListList;
    private Context context;

    public OnboardingAdapter(List<OnboardingList> onboardingListList, Context context) {
        this.onboardingListList = onboardingListList;
        this.context = context;
    }

    @NonNull
    @Override
    public OnBoardingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.onboarding_iteams, parent, false);
        return new OnBoardingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingHolder holder, int position) {
        holder.setOnboardingdata(onboardingListList.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingListList.size();
    }

    public class OnBoardingHolder extends RecyclerView.ViewHolder{

        private LottieAnimationView onboardingimage;
        private MaterialTextView onboardingtitle, onboardingdetails;

        public OnBoardingHolder(@NonNull View itemView) {
            super(itemView);

            onboardingimage = itemView.findViewById(R.id.Image);
            onboardingtitle = itemView.findViewById(R.id.OnBoardingTitle);
            onboardingdetails = itemView.findViewById(R.id.OnBoardingDetails);
        }

        void setOnboardingdata(OnboardingList onboardingdata){
          //  onboardingimage.setL(onboardingdata.getImage());
            onboardingimage.setAnimation(onboardingdata.getImage());
            onboardingtitle.setText(onboardingdata.getTitle());
            onboardingdetails.setText(onboardingdata.getDetails());
        }
    }
}
