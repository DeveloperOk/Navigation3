package com.enterprise.navigation3.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AppRoutes {

        @Serializable
        data object ToDoList: AppRoutes, NavKey

        @Serializable
        data class ToDoDetail(val todo: String): AppRoutes, NavKey

}