package com.uagr.kmp.course.presentation.ui.dashboard.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.ui.dashboard.ui.DashboardScreen

data object DashboardNavigation: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        DashboardScreen()
    }
}