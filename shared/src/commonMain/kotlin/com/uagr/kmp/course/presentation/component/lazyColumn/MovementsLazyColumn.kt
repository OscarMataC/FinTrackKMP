package com.uagr.kmp.course.presentation.component.lazyColumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextSmall
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens

@Composable
fun MovementsLazyColumn(modifier: Modifier, items: List<ItemTest>) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items) {
            ItemMovement(it)
        }
    }

}

@Composable
fun ItemMovement(item: ItemTest) {
    SafeScreenContainerTest {
        val (containerColor, dotAndTextColor) = if(item.cost > 0) {
            Pair(AppTheme.colors.backgrounds.greenE5, Color.Green)
        } else {
            Pair(AppTheme.colors.backgrounds.redFF, Color.Red)

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .size(42.dp),
                colors = CardDefaults.cardColors(containerColor = containerColor),
                shape = RoundedCornerShape(Dimens.corner13)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = dotAndTextColor,
                                shape = CircleShape
                            )
                    )
                }

            }
            Spacer(Modifier.width(Dimens.height19))
            Column(modifier = Modifier.weight(1f)) {
                TextSmall(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize =  Dimens.textSizeSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = AppTheme.colors.text.black1A,
                    text = item.activity,
                    textAlign = TextAlign.Left,
                )
                Spacer(Modifier.height(Dimens.height4))
                TextSmallExtra(
                    modifier = Modifier.fillMaxWidth(),
                    color = AppTheme.colors.text.gray7A,
                    text = item.dayAndTheme,
                    textAlign = TextAlign.Left,
                    fontSize = Dimens.textSizeExtraSmall11
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                TextSmall(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = Dimens.textSizeSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = dotAndTextColor,
                    text = "$${item.cost}",
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}

data class ItemTest(
    val activity: String,
    val dayAndTheme: String,
    val cost: Float
)


@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
fun ItemPreview() {
    val itemListTest = listOf<ItemTest>(
        ItemTest(
        "Supermercado",
        "Ayer • Alimentacion",
        300f
        )
    )
    MovementsLazyColumn(
        modifier = Modifier.fillMaxWidth(),
        itemListTest
    )
}