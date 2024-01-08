package com.sadeeq.encoders.roominjetpackcompose.repo


import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val yourDao: Dao) {

    fun getAllData(): Flow<List<UserEnitity>> {
        return yourDao.getAllData()
    }

    suspend fun insertData(data: UserEnitity) {
        yourDao.insertData(data)
    }

    suspend fun deleteData(data: UserEnitity) {
        yourDao.deleteData(data)
    }

    suspend fun updateUser(user: UserEnitity) {
        yourDao.updateUser(user)
    }
}
