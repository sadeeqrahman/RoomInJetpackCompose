package com.sadeeq.encoders.roominjetpackcompose.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEnitity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String,
    var mobileNumber: String
)
