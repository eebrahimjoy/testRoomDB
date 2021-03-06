package com.eebrahimjoy.roomdbtesting.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

public class PrimeMinister {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "religion")
    private String religion;

    @ColumnInfo(name = "is_political_family_background")
    private boolean isPoliticalFamilyBackground;

    @ColumnInfo(name = "address")
    private String address;

    public PrimeMinister(String name, int age, String gender, String religion, boolean isPoliticalFamilyBackground, String address) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.religion = religion;
        this.isPoliticalFamilyBackground = isPoliticalFamilyBackground;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public boolean isPoliticalFamilyBackground() {
        return isPoliticalFamilyBackground;
    }

    public void setPoliticalFamilyBackground(boolean politicalFamilyBackground) {
        isPoliticalFamilyBackground = politicalFamilyBackground;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
