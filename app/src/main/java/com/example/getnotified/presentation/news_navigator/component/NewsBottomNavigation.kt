package com.example.getnotified.presentation.news_navigator.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.getnotified.R
import com.example.getnotified.domain.model.Article
import com.example.getnotified.domain.model.Source
import com.example.getnotified.presentation.Dimensions
import com.example.getnotified.presentation.common.ArticleCard
import com.example.getnotified.ui.theme.GetNotifiedTheme

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar (
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ){

        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = bottomNavigationItem.icon),
                            contentDescription = null,
                            modifier = Modifier.size(Dimensions.IconSize)
                        )
                        Spacer(modifier = Modifier.height(Dimensions.ExtraSmallPadding2))
                        Text(
                            text = bottomNavigationItem.text,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.md_theme_onPrimary),
                    selectedTextColor = colorResource(id = R.color.md_theme_onPrimary),
                    unselectedIconColor = colorResource(id = R.color.md_theme_onBackground),
                    unselectedTextColor = colorResource(id = R.color.md_theme_onBackground),
                    indicatorColor = colorResource(id = R.color.md_theme_onBackground)
                )
            )
        }

    }
}

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text: String
)

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NewsBottomNavigationPreview() {
    GetNotifiedTheme {
        Box(modifier = Modifier
            .background(color = colorResource(id = R.color.md_theme_background))
            .systemBarsPadding()
        ) {
            NewsBottomNavigation(
                items = listOf(
                    BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
                    BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
                    BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
                ),
                selected = 0,
                onItemClick = {}
            )
        }
    }
}