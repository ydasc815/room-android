package com.aditya.room_android.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    fun databaseInstance(context: Context) : UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, "User.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}