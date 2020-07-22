package com.example.user.clinic;

public class MyListData {


    private String description;
    private int imgId;
    private String sub;
    public  MyListData(String description, int imgId,String sub){
        this.description = description;
        this.imgId = imgId;
        this.sub=sub;

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getSub(){return sub;    }

    public void setSub(String sub) {this.sub = sub; }
}
