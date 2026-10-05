package com.uagr.kmp.course.presentation.ui.budget

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest

@Composable
fun BudgetScreen() {
    SafeScreenContainer {
        BudgetContainer()
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun BudgetScreenPreview() {
    SafeScreenContainerTest {
        BudgetContainer()
    }
}