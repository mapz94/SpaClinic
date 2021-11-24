package com.manager.spaclinic.models;

@Table(table_name = "appointments")
public class Appointment extends Model {

    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT"
    )
    private int ID;

    @Column(
            column_name = "patientID",
            column_props = "INTEGER NOT NULL"
    )
    private int patientID;

    @Column(
            column_name = "userID",
            column_props = "INTEGER NOT NULL"
    )
    private int userID;

    @Column(
            column_name = "serviceID",
            column_props = "INTEGER NOT NULL"
    )
    private int serviceID;

    @Column(
            column_name = "CreationTime",
            column_props = "TEXT NOT NULL"
    )
    private String creationTime;

    @Column(
            column_name = "appointedTime",
            column_props = "TEXT NOT NULL"
    )
    private String appointedTime;

    @Column(
            column_name = "appointedDate",
            column_props = "TEXT NOT NULL"
    )
    private String appointedDate;

    @Column(
            column_name = "succeeded",
            column_props = "INTEGER NOT NULL"
    )
    private int succeeded;

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

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getAppointedTime() {
        return appointedTime;
    }

    public void setAppointedTime(String appointedTime) {
        this.appointedTime = appointedTime;
    }

    public String getAppointedDate() {
        return appointedDate;
    }

    public void setAppointedDate(String appointedDate) {
        this.appointedDate = appointedDate;
    }

    public int isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(int succeeded) {
        this.succeeded = succeeded;
    }

    public MenuItem getMenuItem(Patient patient) {
        return new MenuItem(this.ID,
                patient.getFirstName() + " " + patient.getLastName(),
                "Fecha de creación: " + this.creationTime,
                "Para: " + this.appointedTime);
    }

    @Override
    public String toString() {
        return this.getID() + "";
    }

    @Override
    public MenuItem getMenuItem() {
        return new MenuItem(this.ID,
                "Reserva: " + this.appointedDate + " " + this.appointedTime,
                "",
                ""
        );
    }
}
