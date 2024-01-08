package com.sadeeq.encoders.roominjetpackcompose.viewmodel


import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import com.sadeeq.encoders.roominjetpackcompose.paging.MyDataSourceFactory
import com.sadeeq.encoders.roominjetpackcompose.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val userListLiveData: LiveData<PagedList<UserEnitity>> = repository.getUserList()


    fun insertData(data: UserEnitity) {
        viewModelScope.launch {
            repository.insertData(data)
        }
    }

    fun deleteData(userEnitity: UserEnitity) {
        viewModelScope.launch {
            repository.deleteData(userEnitity)
        }
    }

    fun updateUser(user: UserEnitity) {
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }
}
