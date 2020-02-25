package com.eebrahimjoy.roomdbtesting.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "division_table", indices = {@Index(value = {"division_name"})})
public class Division {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "state_id")
    private int stateId;

    @ColumnInfo(name = "division_name")
    private String name;

    @ColumnInfo(name = "division_code")
    private int code;

    public Division(int id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Ignore
    public Division(String name, int code, int stateId) {
        this.name = name;
        this.code = code;
        this.stateId = stateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
