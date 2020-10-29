package com.digital.digitalbusinessowners.Model;

public class OnboardingList {

    private String image;
    private String title;
    private String details;

    public OnboardingList() {
    }

    public OnboardingList(String image, String title, String details) {
        this.image = image;
        this.title = title;
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
