package com.aditya.room_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.aditya.room_android.database.User
import com.aditya.room_android.database.UserDao
import com.aditya.room_android.database.UserDatabase
import com.aditya.room_android.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dbInstance = Room.databaseBuilder(
            this, UserDatabase::class.java,
            "user-database"
        ).build()
        val users = dbInstance.userDao()
        binding.dbFunction.setOnClickListener {
            val name: String = binding.fieldName.text.toString()
            val age: String = binding.fieldAge.text.toString()
            val gender: String = binding.fieldGender.text.toString()
            runBlocking {
                databaseOperations(users, name, age, gender)
            }
        }
    }

    private suspend fun databaseOperations(users: UserDao, name: String, age: String, gender: String) {
        Dispatchers.IO {
            users.insert(User(null, name, age.toInt(), gender))
            println("SQL Test : ${users.getAllUsers()}")
        }
    }
}