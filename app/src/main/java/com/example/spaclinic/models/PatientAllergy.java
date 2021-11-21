package com.example.spaclinic.models;

@Table(table_name = "patientAllergies")
public class PatientAllergy extends Model {
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
            column_name = "allergy",
            column_props = "TEXT NOT NULL",
            getter = "getAllergy",
            setter = "setAllergy"
    )
    private String allergy;

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

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Override
    public MenuItem getMenuItem() {
        return null;
    }
}
