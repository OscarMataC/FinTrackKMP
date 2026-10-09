/*
 * LoginContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
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
import com.uagr.kmp.course.presentation.component.card.SimpleCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.field.TextFieldPassword
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextMedium
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.available_balance
import course.shared.generated.resources.create_account
import course.shared.generated.resources.email
import course.shared.generated.resources.email_example
import course.shared.generated.resources.empty_balances
import course.shared.generated.resources.fin_track_description
import course.shared.generated.resources.fin_track_title
import course.shared.generated.resources.ic_visibility_off
import course.shared.generated.resources.ic_visibility_on
import course.shared.generated.resources.login
import course.shared.generated.resources.mini_chart
import course.shared.generated.resources.password
import course.shared.generated.resources.password_example
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginContainer(
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    passwordVisible: Boolean = false,
    onPasswordVisibleChange: (Boolean) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(horizontal = Dimens.padding28)
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(Dimens.height20))
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
            text = stringResource(Res.string.fin_track_description),
            textAlign = TextAlign.Left,
            fontSize = Dimens.textSizeSmall15
        )
        Spacer(Modifier.height(Dimens.height42))
        SimpleCard(
            cardBackgroundColor = AppTheme.colors.primary,
            shape = Dimens.corner28,
            paddingColumn = Dimens.padding28
        ) {
            Spacer(Modifier.height(Dimens.height12))
            TextBigBold(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.white,
                text = stringResource(Res.string.empty_balances),
                textAlign = TextAlign.Left,
                fontSize = Dimens.textSizeBig34
            )
            TextSmallExtra(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.blueC7,
                text = stringResource(Res.string.available_balance),
                textAlign = TextAlign.Left,
                fontSize = Dimens.textSizeExtraSmall13
            )
            Spacer(Modifier.height(Dimens.height18))
            Image(
                painter = painterResource(Res.drawable.mini_chart),
                contentDescription = "Gráfica",
                modifier = Modifier.fillMaxWidth().height(Dimens.height70),
            )
        }
        Spacer(Modifier.height(Dimens.height50))
        TextFieldCustom(
            value = email,
            onValueChange = onEmailChange,
            labelColor = AppTheme.colors.text.gray7A,
            label = stringResource(Res.string.email),
            placeholderColor = AppTheme.colors.text.gray7A,
            placeholder = stringResource(Res.string.email_example),
            shape = Dimens.corner14,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
        Spacer(Modifier.height(Dimens.height12))
        TextFieldPassword(
            password = password,
            onPasswordChange = onPasswordChange,
            passwordVisible = passwordVisible,
            onPasswordVisibleChange = onPasswordVisibleChange,
            labelColor = AppTheme.colors.text.gray7A,
            label = stringResource(Res.string.password),
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
        Spacer(modifier = Modifier.height(height = Dimens.height26))
        ButtonCustom(
            onClick = onLoginClick,
            height = Dimens.height52,
            backgroundButton = AppTheme.colors.backgrounds.blue1A,
            textColor = AppTheme.colors.backgrounds.white,
            text = stringResource(Res.string.login),
            textAlign = TextAlign.Start,
            shape = Dimens.corner14
        )
        Spacer(modifier = Modifier.height(height = Dimens.height30))
        TextSmallExtra(
            modifier = Modifier.fillMaxWidth().clickable { onRegisterClick() },
            color = AppTheme.colors.text.blue1A,
            text = stringResource(Res.string.create_account),
            fontSize = Dimens.textSizeExtraSmall13
        )
        Spacer(modifier = Modifier.height(height = Dimens.height30))
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginContainerPreview() {
    SafeScreenContainerTest {
        LoginContainer()
    }
}