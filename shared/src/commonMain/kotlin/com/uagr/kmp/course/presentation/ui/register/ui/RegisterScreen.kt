package com.uagr.kmp.course.presentation.ui.register.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.register.viewmodel.RegisterUiEvent
import com.uagr.kmp.course.presentation.ui.register.viewmodel.RegisterViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    onBackClick: () -> Unit = {}
) {

    val registerUiState by viewModel.registerUiState.collectAsStateWithLifecycle()

    viewModel.registerUiEvent.CollectWithLifecycle { event ->
        when (event) {
            is RegisterUiEvent.Idle -> {}
            is RegisterUiEvent.SuccessfulRegister -> {
                viewModel.resetUiEvent()
                //onRegisterSuccess()
            }
        }
    }

    SafeScreenContainer {
        RegisterContainer(
            name = registerUiState.name,
            onNameChanged = { viewModel.updateName(it)},
            email = registerUiState.email,
            onEmailChanged = { viewModel.updateEmail(it) },
            password = registerUiState.password,
            onPasswordChanged = { viewModel.updatePassword(it) },
            confirmPassword = registerUiState.confirmPassword,
            onConfirmPasswordChanged = { viewModel.updateConfirmPassword(it) },
            isVisiblePassword = registerUiState.isVisiblePassword,
            onVisiblePasswordChange = { viewModel.updateIsVisiblePassword(it) },
            isVisibleConfirmPassword = registerUiState.isVisibleConfirmPassword,
            onVisibleConfirmPasswordChange = { viewModel.updateIsVisibleConfirmPassword(it) },
            onBackClick = { onBackClick() },
            onRegisterClick = {
                viewModel.validateRegisterForm(
                    name = registerUiState.name,
                    email = registerUiState.email,
                    password = registerUiState.password,
                    confirmPassword = registerUiState.confirmPassword
                )
            }
        )
        Loader(isLoading = registerUiState.isLoading)
        DialogCustom(
            errorDialog = registerUiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                viewModel.dismissErrorDialog()
            }
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun LoginScreenPreview() {
    SafeScreenContainerTest {
        RegisterContainer()
    }
}