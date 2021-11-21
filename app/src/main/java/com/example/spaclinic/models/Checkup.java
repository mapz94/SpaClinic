package com.example.spaclinic.models;

import java.util.Date;

@Table(table_name = "checkups")
public class Checkup {

    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT",
            getter = "getID",
            setter = "setID"
    )
    private int ID;

    @Column(
            column_name = "creationTime",
            column_props = "TEXT NOT NULL",
            getter = "getCreationTime",
            setter = "setCreationTime"
    )
    private Date creationTime;

    @Column(
            column_name = "appointmentID",
            column_props = "INTEGER NOT NULL",
            getter = "getAppointmentID",
            setter = "setAppointmentID"
    )
    private int appointmentID;

    @Column(
            column_name = "motive",
            column_props = "TEXT NOT NULL",
            getter = "getMotive",
            setter = "setMotive"
    )
    private String motive;

    @Column(
            column_name = "observation",
            column_props = "TEXT NOT NULL",
            getter = "getObservation",
            setter = "setObservation"
    )
    private String observation;

    @Column(
            column_name = "painDescription",
            column_props = "TEXT NOT NULL",
            getter = "getPainDescription",
            setter = "setPainDescription"
    )
    private String painDescription;

    @Column(
            column_name = "inspection",
            column_props = "TEXT NOT NULL",
            getter = "getInspection",
            setter = "setInspection"
    )
    private String inspection;

    @Column(
            column_name = "palpationDescription",
            column_props = "TEXT NOT NULL",
            getter = "getPalpationDescription",
            setter = "setPalpationDescription"
    )
    private String palpationDescription;

    @Column(
            column_name = "procedure",
            column_props = "TEXT NOT NULL",
            getter = "getProcedure",
            setter = "setProcedure"
    )
    private String procedure;

    @Column(
            column_name = "serviceID",
            column_props = "INTEGER NOT NULL",
            getter = "getServiceID",
            setter = "setServiceID"
    )
    private int serviceID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPainDescription() {
        return painDescription;
    }

    public void setPainDescription(String painDescription) {
        this.painDescription = painDescription;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getPalpationDescription() {
        return palpationDescription;
    }

    public void setPalpationDescription(String palpationDescription) {
        this.palpationDescription = palpationDescription;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }
}
