package com.sadeeq.encoders.roominjetpackcompose.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity

@Database(entities = [UserEnitity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun yourDao(): Dao
}
