package com.aditya.room_android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "user_name")
    val name: String,
    @ColumnInfo(name = "user_age")
    val age: Int,
    @ColumnInfo(name = "user_gender")
    val gender: String
)