package com.manager.spaclinic.models;

public class MenuItem {
    private int ID;
    private String title;
    private String subtitle;
    private String stringData;

    public MenuItem(int ID, String title, String subtitle, String stringData) {
        this.ID = ID;
        this.title = title;
        this.subtitle = subtitle;
        this.stringData = stringData;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }
}
