package com.digital.digitalbusinessowners.Model;

public class ProfileList {

    private int profileviewimage;
    private String profileviewtext;

    public ProfileList() {
    }

    public ProfileList(int profileviewimage, String profileviewtext) {
        this.profileviewimage = profileviewimage;
        this.profileviewtext = profileviewtext;
    }

    public int getProfileviewimage() {
        return profileviewimage;
    }

    public void setProfileviewimage(int profileviewimage) {
        this.profileviewimage = profileviewimage;
    }

    public String getProfileviewtext() {
        return profileviewtext;
    }

    public void setProfileviewtext(String profileviewtext) {
        this.profileviewtext = profileviewtext;
    }
}
