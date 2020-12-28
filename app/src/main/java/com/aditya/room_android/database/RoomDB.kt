package com.aditya.room_android.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class RoomDB : RoomDatabase() {

}