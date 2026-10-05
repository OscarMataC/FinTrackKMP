package com.uagr.kmp.course.presentation.ui.dashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.uagr.kmp.course.presentation.component.text.TextSmallExtra
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import com.uagr.kmp.course.presentation.ui.dashboard.navigation.BottomNavDestination
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CustomBottomBar(
    items: List<BottomNavDestination>,
    selectedIndex: Int,
    backgroundColorBottomBar: Color,
    bottomBarHeight: Dp,
    bottomBarShape: Dp,
    paddingStartEndBottom: Dp,
    iconSelectedIndicator: DrawableResource,
    iconUnselectedIndicator: DrawableResource,
    colorSelectedIndicator: Color,
    colorUnselectedIndicator: Color,
    iconWidthSelectedIndicator: Dp,
    iconHeightSelectedIndicator: Dp,
    iconWidthUnselectedIndicator: Dp,
    iconHeightUnselectedIndicator: Dp,
    widthContainerIcon: Dp,
    heightContainerIcon: Dp,
    shapeBackgroundContainerIcon: Dp,
    backgroundColorContainerSelectedIndicator: Color,
    backgroundColorContainerUnselectedIndicator: Color,
    textColorSelected: Color,
    textColorUnselected: Color,
    onItemSelected: (Int) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(
                start = paddingStartEndBottom,
                end = paddingStartEndBottom,
                bottom = paddingStartEndBottom
            )
            .fillMaxWidth()
            .height(bottomBarHeight)
    ) {
        val itemWidth = maxWidth / items.size
        val indicatorOffset = itemWidth * selectedIndex

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = backgroundColorBottomBar,
                    shape = RoundedCornerShape(bottomBarShape)
                )
        )

        Box(
            modifier = Modifier
                .offset(x = indicatorOffset)
                .width(itemWidth)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            BottomBarItem(
                item = items[selectedIndex],
                selected = true,
                iconSelectedIndicator = iconSelectedIndicator,
                iconUnselectedIndicator = iconUnselectedIndicator,
                colorSelectedIndicator = colorSelectedIndicator,
                colorUnselectedIndicator = colorUnselectedIndicator,
                iconWidthSelectedIndicator = iconWidthSelectedIndicator,
                iconHeightSelectedIndicator = iconHeightSelectedIndicator,
                iconWidthUnselectedIndicator = iconWidthUnselectedIndicator,
                iconHeightUnselectedIndicator = iconHeightUnselectedIndicator,
                shapeBackgroundContainerIcon = shapeBackgroundContainerIcon,
                backgroundColorContainerSelectedIndicator = backgroundColorContainerSelectedIndicator,
                backgroundColorContainerUnselectedIndicator = backgroundColorContainerUnselectedIndicator,
                widthContainerIcon = widthContainerIcon,
                heightContainerIcon = heightContainerIcon,
                textColorSelected = textColorSelected,
                textColorUnselected = textColorUnselected
            )
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            }
                        ) {
                            onItemSelected(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (index != selectedIndex) {
                        BottomBarItem(
                            item = item,
                            selected = false,
                            iconSelectedIndicator = iconSelectedIndicator,
                            iconUnselectedIndicator = iconUnselectedIndicator,
                            colorSelectedIndicator = colorSelectedIndicator,
                            colorUnselectedIndicator = colorUnselectedIndicator,
                            iconWidthSelectedIndicator = iconWidthSelectedIndicator,
                            iconHeightSelectedIndicator = iconHeightSelectedIndicator,
                            iconWidthUnselectedIndicator = iconWidthUnselectedIndicator,
                            iconHeightUnselectedIndicator = iconHeightUnselectedIndicator,
                            shapeBackgroundContainerIcon = shapeBackgroundContainerIcon,
                            backgroundColorContainerSelectedIndicator = backgroundColorContainerSelectedIndicator,
                            backgroundColorContainerUnselectedIndicator = backgroundColorContainerUnselectedIndicator,
                            widthContainerIcon = widthContainerIcon,
                            heightContainerIcon = heightContainerIcon,
                            textColorSelected = textColorSelected,
                            textColorUnselected = textColorUnselected
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BottomBarItem(
    item: BottomNavDestination,
    selected: Boolean,
    iconSelectedIndicator: DrawableResource,
    iconUnselectedIndicator: DrawableResource,
    colorSelectedIndicator: Color,
    colorUnselectedIndicator: Color,
    iconWidthSelectedIndicator: Dp,
    iconHeightSelectedIndicator: Dp,
    iconWidthUnselectedIndicator: Dp,
    iconHeightUnselectedIndicator: Dp,
    widthContainerIcon: Dp,
    heightContainerIcon: Dp,
    shapeBackgroundContainerIcon: Dp,
    backgroundColorContainerSelectedIndicator: Color,
    backgroundColorContainerUnselectedIndicator: Color,
    textColorSelected: Color,
    textColorUnselected: Color
) {
    val icon = if (selected) {
        iconSelectedIndicator
    } else {
        iconUnselectedIndicator
    }

    val iconTint = if (selected) {
        colorSelectedIndicator
    } else {
        colorUnselectedIndicator
    }

    val widthIcon = if (selected) {
        iconWidthSelectedIndicator
    } else {
        iconWidthUnselectedIndicator
    }

    val heightIcon = if (selected) {
        iconHeightSelectedIndicator
    } else {
        iconHeightUnselectedIndicator
    }

    val textColor = if(selected) {
        textColorSelected
    } else {
        textColorUnselected
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = widthContainerIcon,
                    height = heightContainerIcon
                )
                .background(
                    color = if (selected) {
                        backgroundColorContainerSelectedIndicator
                    } else {
                        backgroundColorContainerUnselectedIndicator
                    },
                    shape = RoundedCornerShape(shapeBackgroundContainerIcon)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(
                    width = widthIcon,
                    height = heightIcon
                ),
                painter = painterResource(icon),
                contentDescription = item.navTitle,
                tint = iconTint
            )
        }

        Spacer(
            modifier = Modifier.height(Dimens.padding5)
        )

        TextSmallExtra(
            modifier = Modifier.fillMaxWidth(),
            fontSize = Dimens.textSizeExtraSmall10,
            fontWeight = FontWeight.Medium,
            color = textColor,
            text = item.navTitle
        )
    }
}