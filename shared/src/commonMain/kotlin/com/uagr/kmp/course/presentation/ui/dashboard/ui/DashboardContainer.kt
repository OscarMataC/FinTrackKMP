package com.uagr.kmp.course.presentation.ui.dashboard.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.presentation.ui.budget.BudgetScreen
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.BottomNavDestination
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.Budget
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.Goals
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.Home
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.Movements
import com.uagr.kmp.course.presentation.ui.goals.GoalsScreen
import com.uagr.kmp.course.presentation.ui.home.ui.HomeScreen
import com.uagr.kmp.course.presentation.ui.movements.MovementsScreen
import course.shared.generated.resources.Res
import course.shared.generated.resources.selected_dot
import course.shared.generated.resources.unselected_dot

@Composable
fun DashboardContainer() {

    val navController = rememberNavController()
    val navStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navStackEntry?.destination?.route

    val currentDestination = BottomNavDestination.fromRoute(currentRoute)
    val selectedIndex = currentDestination.navIndex

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                items = BottomNavDestination.entries,
                selectedIndex = selectedIndex,
                backgroundColorBottomBar = Color.White,
                bottomBarHeight = Dimens.height68,
                bottomBarShape = Dimens.corner22,
                paddingStartEndBottom = Dimens.padding16,
                iconSelectedIndicator = Res.drawable.selected_dot,
                iconUnselectedIndicator = Res.drawable.unselected_dot,
                colorSelectedIndicator = AppTheme.colors.backgrounds.blue1A,
                colorUnselectedIndicator = AppTheme.colors.backgrounds.gray7A,
                iconWidthSelectedIndicator = Dimens.width13,
                iconHeightSelectedIndicator = Dimens.height17,
                iconWidthUnselectedIndicator = Dimens.width13,
                iconHeightUnselectedIndicator = Dimens.height17,
                widthContainerIcon = Dimens.width69,
                heightContainerIcon = Dimens.height28,
                shapeBackgroundContainerIcon = Dimens.corner10,
                backgroundColorContainerSelectedIndicator = AppTheme.colors.backgrounds.blueE8,
                backgroundColorContainerUnselectedIndicator = Color.White,
                textColorSelected = AppTheme.colors.text.blue1A,
                textColorUnselected = AppTheme.colors.text.gray7A,
                onItemSelected = {
                    val destination = BottomNavDestination.fromIndex(it)

                    navController.navigate(destination) {
                        popUpTo<Home> {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(padding)
        ) {
            composable<Home> {
                HomeScreen()
            }

            composable<Movements> {
                MovementsScreen()
            }

            composable<Budget> {
                BudgetScreen()
            }

            composable<Goals> {
                GoalsScreen()
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun DashboardContainerPreview() {
    SafeScreenContainerTest {
        DashboardContainer()
    }
}