package com.uagr.kmp.course.presentation.ui.register.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.field.TextFieldPassword
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.arrow_back
import course.shared.generated.resources.confirm_password
import course.shared.generated.resources.email
import course.shared.generated.resources.email_example
import course.shared.generated.resources.fin_track_title
import course.shared.generated.resources.ic_visibility_off
import course.shared.generated.resources.ic_visibility_on
import course.shared.generated.resources.name
import course.shared.generated.resources.name_example
import course.shared.generated.resources.password
import course.shared.generated.resources.password_example
import course.shared.generated.resources.register_description
import course.shared.generated.resources.register_user
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RegisterContainer(
    name: String = "",
    onNameChanged: (String) -> Unit = {},
    email: String = "",
    onEmailChanged: (String) -> Unit = {},
    password: String = "",
    onPasswordChanged: (String) -> Unit = {},
    confirmPassword: String = "",
    onConfirmPasswordChanged: (String) -> Unit = {},
    isVisiblePassword: Boolean = false,
    onVisiblePasswordChange: (Boolean) -> Unit = {},
    isVisibleConfirmPassword: Boolean = false,
    onVisibleConfirmPasswordChange: (Boolean) -> Unit = {},
    onBackClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(state = scrollState)
    ) {
        Spacer(Modifier.height(Dimens.height19))
        Box(modifier = Modifier.fillMaxSize().padding(start = Dimens.height19)) {
            Image(
                painter = painterResource(Res.drawable.arrow_back),
                contentDescription = "Botón retroceso",
                modifier = Modifier
                    .width(Dimens.height30)
                    .height(Dimens.height28)
                    .clickable { onBackClick() }
            )
        }
        Spacer(Modifier.height(Dimens.height19))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.padding41),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBigBold(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.blue0F,
                text = stringResource(Res.string.fin_track_title),
                textAlign = TextAlign.Left,
                fontSize = Dimens.textSizeBig30
            )
            Spacer(Modifier.height(Dimens.height8))
            TextMedium(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.gray7A,
                text = stringResource(Res.string.register_description),
                textAlign = TextAlign.Left,
                fontSize = Dimens.textSizeSmall15
            )
        }
        Spacer(Modifier.height(Dimens.height33))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.padding28),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFieldCustom(
                value = name,
                onValueChange = onNameChanged,
                labelColor = AppTheme.colors.text.gray7A,
                label = stringResource(Res.string.name),
                placeholderColor = AppTheme.colors.text.gray7A,
                placeholder = stringResource(Res.string.name_example),
                shape = Dimens.corner14,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
            Spacer(Modifier.height(Dimens.height24))
            TextFieldCustom(
                value = email,
                onValueChange = onEmailChanged,
                labelColor = AppTheme.colors.text.gray7A,
                label = stringResource(Res.string.email),
                placeholderColor = AppTheme.colors.text.gray7A,
                placeholder = stringResource(Res.string.email_example),
                shape = Dimens.corner14,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
            Spacer(Modifier.height(Dimens.height24))
            TextFieldPassword(
                password = password,
                onPasswordChange = onPasswordChanged,
                passwordVisible = isVisiblePassword,
                onPasswordVisibleChange = onVisiblePasswordChange,
                labelColor = AppTheme.colors.text.gray7A,
                label = stringResource(Res.string.password),
                placeholderColor = AppTheme.colors.text.gray7A,
                placeholder = stringResource(Res.string.password_example),
                shape = Dimens.corner14,
                trailingIconActive = Res.drawable.ic_visibility_on,
                trailingIconInActive = Res.drawable.ic_visibility_off,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
            Spacer(Modifier.height(Dimens.height24))
            TextFieldPassword(
                password = confirmPassword,
                onPasswordChange = onConfirmPasswordChanged,
                passwordVisible = isVisibleConfirmPassword,
                onPasswordVisibleChange = onVisibleConfirmPasswordChange,
                labelColor = AppTheme.colors.text.gray7A,
                label = stringResource(Res.string.confirm_password),
                placeholderColor = AppTheme.colors.text.gray7A,
                placeholder = stringResource(Res.string.password_example),
                shape = Dimens.corner14,
                trailingIconActive = Res.drawable.ic_visibility_on,
                trailingIconInActive = Res.drawable.ic_visibility_off,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                keyboardActions = KeyboardActions(
                    onAny = {
                        focusManager.clearFocus()
                    }
                )
            )
            Spacer(Modifier.height(Dimens.height128))
            ButtonCustom(
                onClick = onRegisterClick,
                height = Dimens.height52,
                backgroundButton = AppTheme.colors.backgrounds.blue1A,
                textColor = AppTheme.colors.backgrounds.white,
                text = stringResource(Res.string.register_user),
                textAlign = TextAlign.Start,
                shape = Dimens.corner14
            )
            Spacer(modifier = Modifier.height(height = Dimens.height30))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginContainerPreview() {
    SafeScreenContainerTest {
        RegisterContainer()
    }
}