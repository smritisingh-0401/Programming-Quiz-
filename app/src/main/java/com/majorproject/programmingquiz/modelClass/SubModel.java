package com.majorproject.programmingquiz.modelClass;

public class SubModel {
    String title, des, category;

    public SubModel(){

    }

    public SubModel(String title, String des, String category) {
        this.title = title;
        this.des = des;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
