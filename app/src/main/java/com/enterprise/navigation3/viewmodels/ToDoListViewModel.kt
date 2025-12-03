package com.enterprise.navigation3.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ToDoListViewModel: ViewModel() {

    val todos = MutableStateFlow(
        (1..100).map { "Todo $it" }
    )

}