package com.uagr.kmp.course.presentation.ui.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.card.SimpleCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.lazyColumn.ItemMovement
import com.uagr.kmp.course.presentation.component.lazyColumn.ItemTest
import com.uagr.kmp.course.presentation.component.text.TextBigBold
import com.uagr.kmp.course.presentation.component.text.TextNormal
import com.uagr.kmp.course.presentation.component.text.TextSmall
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.expenses
import course.shared.generated.resources.last_movements
import course.shared.generated.resources.this_month
import course.shared.generated.resources.total_balance
import course.shared.generated.resources.view_all
import course.shared.generated.resources.your_financial_outlook
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeContainer(userName: String) {
    val scrollState = rememberScrollState()
    val itemTestMovements= listOf<ItemTest>(
        ItemTest(
            "Supermercado",
            "Hoy • Alimentacion",
            -860f
        ),
                ItemTest(
                "Nomina",
        "Ayer • Ingreso",
        15500f
        ),
        ItemTest(
        "Internet",
        "18 sep • Servicios",
        -599f
        )
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .padding(horizontal = Dimens.padding24)
    ) {
        Spacer(Modifier.height(Dimens.height27))
        TextSmall(
            modifier = Modifier.fillMaxWidth(),
            fontSize =  Dimens.textSizeSmall15,
            fontWeight = FontWeight.Medium,
            color = AppTheme.colors.text.gray7A,
            text = "Hola, $userName",
            textAlign = TextAlign.Left,
        )
        Spacer(Modifier.height(Dimens.height7))
        TextBigBold(
            modifier = Modifier.fillMaxWidth(),
            fontSize = Dimens.textSizeBig25,
            color = AppTheme.colors.text.black1A,
            text = stringResource(Res.string.your_financial_outlook),
            textAlign = TextAlign.Left,
        )
        Spacer(Modifier.height(Dimens.height19))
        SimpleCard(
            cardBackgroundColor = AppTheme.colors.primary,
            shape = Dimens.corner26,
            paddingColumn = Dimens.padding20
        ) {
            Spacer(Modifier.height(Dimens.height2))
            TextSmall(
                modifier = Modifier.fillMaxWidth(),
                fontSize =  Dimens.textSizeSmall15,
                fontWeight = FontWeight.Medium,
                color = AppTheme.colors.text.blueC2,
                text = stringResource(Res.string.total_balance),
                textAlign = TextAlign.Left,
            )
            Spacer(Modifier.height(Dimens.height13))
            TextBigBold(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.white,
                text = "$24,000",
                textAlign = TextAlign.Left,
                fontSize = Dimens.textSizeBig34
            )
            Spacer(Modifier.height(Dimens.height21))
            Row(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.weight(1f)) {
                    TextSmall(
                        modifier = Modifier.fillMaxWidth(),
                        fontSize =  Dimens.textSizeExtraSmall11,
                        fontWeight = FontWeight.Medium,
                        color = AppTheme.colors.text.blueC2,
                        text = stringResource(Res.string.expenses),
                        textAlign = TextAlign.Left,
                    )
                    Spacer(Modifier.height(Dimens.height7))
                    TextSmall(
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold,
                        color = AppTheme.colors.text.white,
                        text = "+$18,500",
                        textAlign = TextAlign.Left,
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    TextSmall(
                        modifier = Modifier.fillMaxWidth(),
                        fontSize =  Dimens.textSizeExtraSmall11,
                        fontWeight = FontWeight.Medium,
                        color = AppTheme.colors.text.blueC2,
                        text = stringResource(Res.string.total_balance),
                        textAlign = TextAlign.Left,
                    )
                    Spacer(Modifier.height(Dimens.height7))
                    TextSmall(
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold,
                        color = AppTheme.colors.text.white,
                        text = "+$8,460",
                        textAlign = TextAlign.Left,
                    )
                }
            }
            Spacer(Modifier.height(Dimens.height1))
        }
        Spacer(Modifier.height(Dimens.height28))
        TextNormal(
            modifier = Modifier.fillMaxWidth(),
            fontSize =  Dimens.textSizeNormal18,
            fontWeight = FontWeight.SemiBold,
            color = AppTheme.colors.text.black1A,
            text = stringResource(Res.string.this_month),
            textAlign = TextAlign.Left,
        )
        Spacer(Modifier.height(Dimens.height14))
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(Dimens.padding22)
        ) {
            SimpleCard(
                modifierCard = Modifier.weight(1f),
                cardBackgroundColor = AppTheme.colors.backgrounds.white,
                shape = Dimens.padding18,
                paddingColumn = Dimens.padding16
            ) {
                TextSmall(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize =  Dimens.textSizeExtraSmall,
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.colors.text.gray7A,
                    text = stringResource(Res.string.expenses),
                    textAlign = TextAlign.Left,
                )
                Spacer(Modifier.height(Dimens.height6))
                TextBigBold(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = Dimens.textSizeMedium23,
                    color = AppTheme.colors.text.black1A,
                    text = "$8,460",
                    textAlign = TextAlign.Left,
                )
                Spacer(Modifier.height(Dimens.height5))
                TextSmallExtra(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = Dimens.textSizeExtraSmall11,
                    fontWeight = FontWeight.SemiBold,
                    color = AppTheme.colors.text.green17,
                    text = "↓12%",
                    textAlign = TextAlign.Left,
                )
            }

            SimpleCard(
                modifierCard = Modifier.weight(1f),
                cardBackgroundColor = AppTheme.colors.backgrounds.white,
                shape = Dimens.padding18,
                paddingColumn = Dimens.padding16
            ) {
                TextSmall(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize =  Dimens.textSizeExtraSmall,
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.colors.text.gray7A,
                    text = stringResource(Res.string.expenses),
                    textAlign = TextAlign.Left,
                )
                Spacer(Modifier.height(Dimens.height6))
                TextBigBold(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = Dimens.textSizeMedium23,
                    color = AppTheme.colors.text.black1A,
                    text = "$8,460",
                    textAlign = TextAlign.Left,
                )
                Spacer(Modifier.height(Dimens.height5))
                TextSmallExtra(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = Dimens.textSizeExtraSmall11,
                    fontWeight = FontWeight.SemiBold,
                    color = AppTheme.colors.text.green17,
                    text = "↑8%",
                    textAlign = TextAlign.Left,
                )
            }
        }
        Spacer(Modifier.height(Dimens.height33))
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            TextNormal(
                modifier = Modifier.weight(1f),
                fontSize =  Dimens.textSizeNormal18,
                fontWeight = FontWeight.SemiBold,
                color = AppTheme.colors.text.black1A,
                text = stringResource(Res.string.last_movements),
                textAlign = TextAlign.Left,
            )
            Column(modifier = Modifier.weight(0.3f)) {
                Spacer(Modifier.height(Dimens.height5))
                TextNormal(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize =  Dimens.textSizeExtraSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = AppTheme.colors.text.blue1A,
                    text = stringResource(Res.string.view_all),
                    textAlign = TextAlign.Left,
                )
            }
        }
        Spacer(Modifier.height(Dimens.height18))
        Column(modifier = Modifier.fillMaxWidth()) {
            itemTestMovements.forEach { itemTest ->
                ItemMovement(itemTest)
                Spacer(Modifier.height(Dimens.height16))
            }
        }
        Spacer(Modifier.height(Dimens.height30))
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun HomeContainerPreview() {
    SafeScreenContainerTest {
        HomeContainer("Usuario")
    }
}