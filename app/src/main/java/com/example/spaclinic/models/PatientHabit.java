package com.example.spaclinic.models;

public class PatientHabit {

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
            column_name = "habit",
            column_props = "TEXT NOT NULL",
            getter = "getHabit",
            setter = "setHabit"
    )
    private String habit;

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

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }
}
