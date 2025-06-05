package com.example.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GroupDBDao {
    @Insert
    fun insert(group:GroupDB)
    @Delete
    fun delete(group:GroupDB)
    @Query("SELECT * FROM GroupDB")
    fun getall(): List<GroupDB>
}