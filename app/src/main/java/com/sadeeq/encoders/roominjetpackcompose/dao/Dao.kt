package com.sadeeq.encoders.roominjetpackcompose.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM user_table")
    fun getAllData(): Flow<List<UserEnitity>>

    @Insert
    suspend fun insertData(data: UserEnitity)

    @Delete
    suspend fun deleteData(data: UserEnitity)

    @Update
    suspend fun updateUser(user: UserEnitity)
}
