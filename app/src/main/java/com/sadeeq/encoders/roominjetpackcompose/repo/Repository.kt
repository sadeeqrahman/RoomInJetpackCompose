package com.sadeeq.encoders.roominjetpackcompose.repo


import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val yourDao: Dao) {

    fun getUserList(): LiveData<PagedList<UserEnitity>> {
        val config = PagedList.Config.Builder()
            .setPageSize(100)
            .setEnablePlaceholders(false)
            .build()

        return LivePagedListBuilder(yourDao.getUserList(), config).build()
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
