package com.eebrahimjoy.roomdbtesting.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class StateAndDivision {

    @Embedded
    public State state;

    @Relation(
            parentColumn = "id",
            entityColumn = "state_id"
    )
    private List<Division> divisionList;

    public StateAndDivision(State state, List<Division> divisionList) {
        this.state = state;
        this.divisionList = divisionList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }
}
