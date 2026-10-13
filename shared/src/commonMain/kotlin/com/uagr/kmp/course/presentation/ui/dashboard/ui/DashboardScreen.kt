package com.uagr.kmp.course.presentation.ui.dashboard.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest

@Composable
fun DashboardScreen(idCashAccount: String) {
    SafeScreenContainer {
        DashboardContainer(idCashAccount)
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun DashboardScreenPreview() {
    SafeScreenContainerTest {
        DashboardContainer("")
    }
}