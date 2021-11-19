package com.example.spaclinic.models;


public class MorbidHistory {
    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT",
            getter = "getID",
            setter = "setID"
    )
    private int ID;

    @Column(
            column_name = "patientID",
            column_props = "INTEGER NOT NULL",
            getter = "getPatientID",
            setter = "setPatientID"
    )
    private int patientID;

    @Column(
            column_name = "creationTime",
            column_props = "TEXT NOT NULL",
            getter = "getCreationTime",
            setter = "setCreationTime"
    )
    private String creationTime;

    @Column(
            column_name = "description",
            column_props = "TEXT NOT NULL",
            getter = "getDescription",
            setter = "setDescription"
    )
    private String description;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
