package com.eebrahimjoy.roomdbtesting.model;


import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "state_table", indices = {@Index(value = {"state_id", "state_name"}, unique = true)})
public class State {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "state_id")
    private long stateId;

    @ColumnInfo(name = "state_name")
    private String name;

    @ColumnInfo(name = "state_code")
    private int code;

    @ColumnInfo(name = "state_economyStatus")
    private String economyStatus;

    @ColumnInfo(name = "state_mainLanguage")
    private String mainLanguage;

    @ColumnInfo(name = "state_mainReligion")
    private String mainReligion;

    @ColumnInfo(name = "state_area")
    private double area;

    @ColumnInfo(name = "state_subcontinent")
    private String subcontinent;

    @ColumnInfo(name = "state_population")
    private int population;

    @ColumnInfo(name = "state_totalNoDivision")
    private int totalNoDivision;

    @Embedded(prefix = "prime_minister_")
    private PrimeMinister primeMinister;

    public State(int id, long stateId, String name, int code, String economyStatus, String mainLanguage, String mainReligion, double area, String subcontinent, int population, int totalNoDivision, PrimeMinister primeMinister) {
        this.id = id;
        this.stateId = stateId;
        this.name = name;
        this.code = code;
        this.economyStatus = economyStatus;
        this.mainLanguage = mainLanguage;
        this.mainReligion = mainReligion;
        this.area = area;
        this.subcontinent = subcontinent;
        this.population = population;
        this.totalNoDivision = totalNoDivision;
        this.primeMinister = primeMinister;
    }

    @Ignore
    public State(long stateId, String name, int code, String economyStatus, String mainLanguage, String mainReligion, double area, String subcontinent, int population, int totalNoDivision, PrimeMinister primeMinister) {
        this.stateId = stateId;
        this.name = name;
        this.code = code;
        this.economyStatus = economyStatus;
        this.mainLanguage = mainLanguage;
        this.mainReligion = mainReligion;
        this.area = area;
        this.subcontinent = subcontinent;
        this.population = population;
        this.totalNoDivision = totalNoDivision;
        this.primeMinister = primeMinister;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getEconomyStatus() {
        return economyStatus;
    }

    public void setEconomyStatus(String economyStatus) {
        this.economyStatus = economyStatus;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public String getMainReligion() {
        return mainReligion;
    }

    public void setMainReligion(String mainReligion) {
        this.mainReligion = mainReligion;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getSubcontinent() {
        return subcontinent;
    }

    public void setSubcontinent(String subcontinent) {
        this.subcontinent = subcontinent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTotalNoDivision() {
        return totalNoDivision;
    }

    public void setTotalNoDivision(int totalNoDivision) {
        this.totalNoDivision = totalNoDivision;
    }

    public PrimeMinister getPrimeMinister() {
        return primeMinister;
    }

    public void setPrimeMinister(PrimeMinister primeMinister) {
        this.primeMinister = primeMinister;
    }
}
