package com.journaldev.navigationdrawer;

public class DataModel {
    public int icon;
    public String name;

    public DataModel(int icon, String name){
        this.icon = icon;
        this.name = name;
    }
    public void setString(String string){
        this.name = string;
    }

    public String getString() {
        return name;
    }
}
