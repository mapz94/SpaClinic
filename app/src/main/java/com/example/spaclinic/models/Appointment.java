package com.example.spaclinic.models;

import java.util.Date;

public class Appointment {

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
            column_name = "userID",
            column_props = "INTEGER NOT NULL",
            getter = "getUserID",
            setter = "setUserID"
    )
    private int userID;

    @Column(
            column_name = "CreationTime",
            column_props = "TEXT NOT NULL",
            getter = "getCreationTime",
            setter = "setCreationTime"
    )
    private Date creationTime;

    @Column(
            column_name = "appointedTime",
            column_props = "TEXT NOT NULL",
            getter = "getAppointedTime",
            setter = "setAppointedTime"
    )
    private Date appointedTime;

    @Column(
            column_name = "succeeded",
            column_props = "INTEGER NOT NULL",
            getter = "getSucceeded",
            setter = "setSucceeded"
    )
    private boolean succeeded;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getAppointedTime() {
        return appointedTime;
    }

    public void setAppointedTime(Date appointedTime) {
        this.appointedTime = appointedTime;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
}
