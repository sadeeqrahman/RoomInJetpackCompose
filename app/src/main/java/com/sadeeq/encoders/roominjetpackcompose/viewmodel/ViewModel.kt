package com.sadeeq.encoders.roominjetpackcompose.viewmodel

// YourViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadeeq.encoders.roominjetpackcompose.entity.UserEnitity
import com.sadeeq.encoders.roominjetpackcompose.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getAllData(): Flow<List<UserEnitity>> {
        return repository.getAllData()
    }

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
