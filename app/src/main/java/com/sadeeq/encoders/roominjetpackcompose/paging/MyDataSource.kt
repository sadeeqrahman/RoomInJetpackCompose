package com.sadeeq.encoders.roominjetpackcompose.paging

import androidx.paging.PageKeyedDataSource
import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity

class MyDataSource(private val dao: Dao) : PageKeyedDataSource<Int, UserEnitity>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UserEnitity>
    ) {
        val data = loadDataFromDao(0, params.requestedLoadSize)
        callback.onResult(data, null, 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserEnitity>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserEnitity>) {
        val data = loadDataFromDao(params.key, params.requestedLoadSize)
        callback.onResult(data, params.key + 1)
    }

    private fun loadDataFromDao(offset: Int, limit: Int): List<UserEnitity> {
        return dao.loadData(offset, limit)
    }
}
