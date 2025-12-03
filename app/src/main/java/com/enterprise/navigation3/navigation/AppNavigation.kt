package com.enterprise.navigation3.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.enterprise.navigation3.screens.ToDoDetailScreen
import com.enterprise.navigation3.screens.ToDoListScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


@Composable
fun AppNavigation(
) {

    //With rememberNavBackStack, backstack survives the configuration changes such as screen rotation etc.
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(AppRoutes.ToDoList::class, AppRoutes.ToDoList.serializer())
                    subclass(AppRoutes.ToDoDetail::class, AppRoutes.ToDoDetail.serializer())
                }
            }
        },

        //NavigationStartScreen
        AppRoutes.ToDoList
    )
    NavDisplay(
        backStack = backStack,

        //In order to clear viewmodel, on navigation back
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),

        entryProvider = { key ->
            when(key) {
                is AppRoutes.ToDoList -> {
                    NavEntry(key) {
                        ToDoListScreen(
                            onTodoClick = {

                                //Navigates to added element to backstack
                                backStack.add(AppRoutes.ToDoDetail(it))
                            }
                        )
                    }
                }
                is AppRoutes.ToDoDetail -> {
                    NavEntry(key) {
                        ToDoDetailScreen(
                            todo = key.todo
                        )
                    }
                }
                else -> error("Unknown NavKey: $key")
            }
        }
    )
}