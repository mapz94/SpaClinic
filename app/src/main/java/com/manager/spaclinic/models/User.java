package com.manager.spaclinic.models;

import android.text.TextUtils;
import android.util.Patterns;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Table(table_name = "users")
public class User extends Model{

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
            column_name = "email",
            column_props = "TEXT NOT NULL"
    )
    private String email;

    @Column(
            column_name = "password",
            column_props = "TEXT NOT NULL"
    )
    private String password;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        boolean isValid = isValidEmail(email);
        if(isValid)
            this.email = email;
        return isValid;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        boolean isValid = isValidPass(password);
        System.out.println(isValid);
        if(isValid)
            this.password = this.encryptMd5(password);
        return isValid;
    }

    public boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public boolean isValidPass(String password){
        return !password.isEmpty() && password.length() >= 8;
    }

    public String encryptMd5(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
            System.out.println(generatedPassword.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean isPassword(String password){
        return this.password.equals(encryptMd5(password));
    }

    @Override
    public String toString() {
        return "(" + this.getID() + ")" + " Email: " + this.getEmail();
    }

    @Override
    public MenuItem getMenuItem() {
        return new MenuItem(this.ID, this.firstName + " " + this.lastName, this.email, "");
    }
}
