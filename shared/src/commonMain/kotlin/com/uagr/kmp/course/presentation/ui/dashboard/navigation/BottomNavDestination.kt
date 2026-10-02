package com.uagr.kmp.course.presentation.ui.dashboard.navigation

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
sealed interface BottomNavDestination {
    val navIndex: Int
    val navTitle: String
    val icon: DrawableResource

    companion object {
        val entries: List<BottomNavDestination> = listOf(Home, Movements, Budget, Goals)
        fun fromIndex(targetIndex: Int) = entries.find { it.navIndex == targetIndex } ?: Home
        fun fromRoute(route: String?) =
            entries.find { route?.contains(it::class.simpleName ?: "") == true } ?: Home
    }
}