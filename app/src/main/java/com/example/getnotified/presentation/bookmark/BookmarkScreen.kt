package com.example.getnotified.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.getnotified.R
import com.example.getnotified.domain.model.Article
import com.example.getnotified.presentation.Dimensions
import com.example.getnotified.presentation.common.ArticlesList
import com.example.getnotified.presentation.navgraph.Route

@Composable
fun BookmarkScreen(

    state: BookmarkState,
    navigateToDetails: (Article) -> Unit

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                top = Dimensions.MediumPadding1,
                start = Dimensions.MediumPadding1,
                end = Dimensions.MediumPadding1
            )
    ) {

        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.md_theme_onSurface),
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))

        ArticlesList(articles = state.articles, onClick = {navigateToDetails(it)})

    }

}