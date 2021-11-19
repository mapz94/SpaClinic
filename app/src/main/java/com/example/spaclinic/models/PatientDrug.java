package com.example.spaclinic.models;

public class PatientDrug {
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
            column_name = "drug",
            column_props = "TEXT NOT NULL",
            getter = "getDrug",
            setter = "setDrug"
    )
    private String drug;

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

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }
}
