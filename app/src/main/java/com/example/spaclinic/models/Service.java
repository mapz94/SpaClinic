package com.example.spaclinic.models;

@Table(table_name = "services")
public class Service extends Model {
    @Column(
            column_name = "ID",
            column_props = "INTEGER PRIMARY KEY AUTOINCREMENT"
    )
    private int ID;
    @Column(
            column_name = "service",
            column_props = "TEXT NOT NULL"
    )
    private String service;

    @Column(
            column_name = "cost",
            column_props = "INTEGER NOT NULL"
    )
    private int cost;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public MenuItem getMenuItem() {
        return new MenuItem(this.ID, this.service, "", "");
    }

}
