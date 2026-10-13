/*
 * LoginNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.DashboardNavigation
import com.uagr.kmp.course.presentation.ui.login.ui.LoginScreen
import com.uagr.kmp.course.presentation.ui.register.navigation.RegisterNavigation

data object LoginNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LoginScreen(
            onLoginSuccessWithCashAccount = {
                navigator.replaceAll(DashboardNavigation(it))
            },
            onLoginSuccessWithoutCashAccount = {
                //Navegar a pantalla para crear cuenta bancaria
            },
            navigateToRegister = {
                navigator.push(RegisterNavigation)
            }
        )
    }
}
