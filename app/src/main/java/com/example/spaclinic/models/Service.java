package com.example.spaclinic.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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

    @Override
    public String toString() {
        return "(" + this.getId() + ")" + " " + this.getService();
    }

    public MenuItem getMenuItem() {
        DecimalFormat df = new DecimalFormat(
                "#,##0",
                new DecimalFormatSymbols(new Locale("es", "CL")));
        return new MenuItem(this.ID, this.service, "",
                "$" + df.format(this.cost));
    }

}
