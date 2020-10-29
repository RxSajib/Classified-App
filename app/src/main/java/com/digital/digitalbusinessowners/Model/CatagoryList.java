package com.digital.digitalbusinessowners.Model;

public class CatagoryList {

    private String CategoryName, CategoryTitle, Type;

    public CatagoryList() {
    }

    public CatagoryList(String categoryName, String categoryTitle, String type) {
        CategoryName = categoryName;
        CategoryTitle = categoryTitle;
        Type = type;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
