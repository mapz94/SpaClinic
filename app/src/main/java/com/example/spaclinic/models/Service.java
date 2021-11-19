package com.example.spaclinic.models;

public class Service {
    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT",
            getter = "getID",
            setter = "setID"
    )
    private int ID;
    @Column(
            column_name = "service",
            column_props = "TEXT NOT NULL",
            getter = "getService",
            setter = "setService"
    )
    private String service;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
