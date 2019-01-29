package com.yema.kotlintest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel  : ViewModel() {
    private lateinit var users: MutableLiveData<List<User>>
    fun getUsers(): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = MutableLiveData()
        }
        return users
    }

}