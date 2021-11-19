package com.example.spaclinic.models;

import java.util.Date;

public class Patient {
    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT",
            getter = "getID",
            setter = "setID"
    )
    private int ID;

    @Column(
            column_name = "firstName",
            column_props = "TEXT NOT NULL",
            getter = "getFirstName",
            setter = "setFirstName"
    )
    private String firstName;

    @Column(
            column_name = "lastName",
            column_props = "TEXT NOT NULL",
            getter = "getLastName",
            setter = "setLastName"
    )
    private String lastName;

    @Column(
            column_name = "birthdate",
            column_props = "TEXT NOT NULL",
            getter = "getBirthdate",
            setter = "setBirthdate"
    )
    private Date birthdate;

    @Column(
            column_name = "rut",
            column_props = "TEXT NOT NULL",
            getter = "getRut",
            setter = "setRut"
    )
    private String rut;

    @Column(
            column_name = "address",
            column_props = "TEXT NOT NULL",
            getter = "getAddress",
            setter = "setAddress"
    )
    private String address;

    @Column(
            column_name = "phone",
            column_props = "TEXT NOT NULL",
            getter = "getPhone",
            setter = "setPhone"
    )
    private String phone;

    @Column(
            column_name = "emergencyPhone",
            column_props = "TEXT NOT NULL",
            getter = "getEmergencyPhone",
            setter = "setEmergencyPhone"
    )
    private String emergencyPhone;

    @Column(
            column_name = "occupation",
            column_props = "TEXT NOT NULL",
            getter = "getOccupation",
            setter = "setOccupation"
    )
    private String occupation;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
