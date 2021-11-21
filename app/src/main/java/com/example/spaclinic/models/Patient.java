package com.example.spaclinic.models;

@Table(table_name = "patients")
public class Patient extends Model {
    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT"
    )
    private int ID;

    @Column(
            column_name = "firstName",
            column_props = "TEXT NOT NULL"
    )
    private String firstName;

    @Column(
            column_name = "lastName",
            column_props = "TEXT NOT NULL"
    )
    private String lastName;

    @Column(
            column_name = "birthdate",
            column_props = "TEXT NOT NULL"
    )
    private String birthdate;

    @Column(
            column_name = "email",
            column_props = "TEXT NOT NULL"
    )
    private String email;

    @Column(
            column_name = "rut",
            column_props = "TEXT NOT NULL"
    )
    private String rut;

    @Column(
            column_name = "address",
            column_props = "TEXT NOT NULL"
    )
    private String address;

    @Column(
            column_name = "phone",
            column_props = "TEXT NOT NULL"
    )
    private String phone;

    @Column(
            column_name = "emergencyPhone",
            column_props = "TEXT NOT NULL"
    )
    private String emergencyPhone;

    @Column(
            column_name = "occupation",
            column_props = "TEXT NOT NULL"
    )
    private String occupation;

    @Column(
            column_name = "allergies",
            column_props = "TEXT NOT NULL"
    )
    private String allergies;

    @Column(
            column_name = "drugs",
            column_props = "TEXT NOT NULL"
    )
    private String drugs;

    @Column(
            column_name = "habits",
            column_props = "TEXT NOT NULL"
    )
    private String habits;

    @Column(
            column_name = "morbid",
            column_props = "TEXT NOT NULL"
    )
    private String morbid;

    @Column(
            column_name = "clinical",
            column_props = "TEXT NOT NULL"
    )
    private String clinical;

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getMorbid() {
        return morbid;
    }

    public void setMorbid(String morbid) {
        this.morbid = morbid;
    }

    public String getClinical() {
        return clinical;
    }

    public void setClinical(String clinical) {
        this.clinical = clinical;
    }

    public MenuItem getMenuItem() {
        return new MenuItem(this.ID,
                this.firstName + " " + this.lastName,
                this.getRut(),
                ""
                );
    }
}
