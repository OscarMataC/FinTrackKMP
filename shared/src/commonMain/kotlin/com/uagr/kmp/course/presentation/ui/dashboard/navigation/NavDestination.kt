package com.uagr.kmp.course.presentation.ui.dashboard.navigation

import course.shared.generated.resources.Res
import course.shared.generated.resources.unselected_dot
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data object Home: BottomNavDestination {
    override val navIndex: Int = 0
    override val navTitle: String = "Inicio"
    override val icon: DrawableResource = Res.drawable.unselected_dot
}

@Serializable
data object Movements: BottomNavDestination {
    override val navIndex: Int = 1
    override val navTitle: String = "Movimientos"
    override val icon: DrawableResource = Res.drawable.unselected_dot
}

@Serializable
data object Budget: BottomNavDestination {
    override val navIndex: Int = 2
    override val navTitle: String = "Presupuesto"
    override val icon: DrawableResource = Res.drawable.unselected_dot
}

@Serializable
data object Goals: BottomNavDestination {
    override val navIndex: Int = 3
    override val navTitle: String = "Metas"
    override val icon: DrawableResource = Res.drawable.unselected_dot
}