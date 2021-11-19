package com.example.spaclinic.models;

import java.util.Date;

@Table(table_name = "surgical_histories")
public class SurgicalHistory extends Model{

    @Column(
            column_name = "surgical_history_id",
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
    private Date creationTime;
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

    public void setId(int ID) {
        this.ID = ID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
