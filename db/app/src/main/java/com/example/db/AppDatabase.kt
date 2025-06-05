package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GroupDB::class], version = 1)
abstract class AppDatabase() : RoomDatabase(){
    abstract fun groupDBDao() : GroupDBDao
}
