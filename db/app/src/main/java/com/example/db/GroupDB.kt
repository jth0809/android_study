package com.example.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GroupDB(
    @PrimaryKey var name: String,
    var number: Int
)
