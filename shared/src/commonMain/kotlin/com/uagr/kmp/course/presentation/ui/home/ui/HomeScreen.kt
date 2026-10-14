package com.uagr.kmp.course.presentation.ui.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.ui.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    idCashAccount: String
) {

    LaunchedEffect(key1 = true) {
        viewModel.getSummaryUserAccount(idCashAccount)
    }

    val userUiState by viewModel.userUiState.collectAsStateWithLifecycle()
    val balanceUiState by viewModel.balanceUiState.collectAsStateWithLifecycle()

    SafeScreenContainer {
        HomeContainer(
            userName = userUiState.userName,
            net = balanceUiState.net,
            income = balanceUiState.income,
            expenses = balanceUiState.expenses
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun HomeScreenPreview() {
    SafeScreenContainerTest {
        HomeContainer(
            userName = "Usuario",
            net = "5500.00",
            income = "10000",
            expenses = "4500"
        )
    }
}