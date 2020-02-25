package com.eebrahimjoy.roomdbtesting.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.eebrahimjoy.roomdbtesting.model.Division;
import com.eebrahimjoy.roomdbtesting.model.State;

import java.util.List;

@Dao
public interface DivisionDao {

    //Single_Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOutbox(Division division);

    //List_Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsertOutbox(List<Division> divisions);

    //Get_State_List
    @Query("SELECT * FROM division_table WHERE division_name = :name")
    List<Division> getDivisionList(String name);

//    @Query("SELECT * FROM division_table division LEFT JOIN state_table state ON (division.division_id = state.state_id) WHERE state.state_name =:name")
//    List<Division> getStateWithDivision(String name);
}
