package com.sadeeq.encoders.roominjetpackcompose.paging

import androidx.paging.DataSource
import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity

class MyDataSourceFactory(private val dao: Dao) : DataSource.Factory<Int, UserEnitity>() {

    override fun create(): DataSource<Int, UserEnitity> {
        return MyDataSource(dao)
    }
}
