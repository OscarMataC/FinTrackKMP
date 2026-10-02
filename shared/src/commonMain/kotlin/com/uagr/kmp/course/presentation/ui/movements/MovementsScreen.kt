package com.uagr.kmp.course.presentation.ui.movements

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest

@Composable
fun MovementsScreen() {

}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun MovementsScreenPreview() {
    SafeScreenContainerTest {
        MovementsContainer()
    }
}