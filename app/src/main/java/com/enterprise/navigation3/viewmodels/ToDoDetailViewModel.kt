package com.enterprise.navigation3.viewmodels

import androidx.lifecycle.ViewModel

class ToDoDetailViewModel: ViewModel() {

    init {
        println("ToDoDetailViewModel initialized")
    }

    override fun onCleared() {
        super.onCleared()
        println("ToDoDetailViewModel cleared")
    }
}
