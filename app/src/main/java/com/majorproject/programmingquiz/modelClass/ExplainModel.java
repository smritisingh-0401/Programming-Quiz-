package com.majorproject.programmingquiz.modelClass;

public class ExplainModel {
    String explain
, category;

    public ExplainModel(){

    }

    public ExplainModel(String explain, String category) {
        this.explain
 = explain
;
        this.category = category;
    }

    public String getTitle() {
        return explain
;
    }

    public void setTitle(String explain) {
        this.explain
 = explain
;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
