package com.example.getnotified.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.getnotified.R
import com.example.getnotified.domain.model.Article
import com.example.getnotified.domain.model.Source
import com.example.getnotified.presentation.Dimensions
import com.example.getnotified.ui.theme.GetNotifiedTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {

    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {
          AsyncImage(
              modifier = Modifier
                  .size(Dimensions.ArticleCardSize)
                  .clip(MaterialTheme.shapes.medium),
              contentScale = ContentScale.Crop,
              model = ImageRequest.Builder(context).data(article.urlToImage).build(),
              contentDescription = null
          )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimensions.ExtraSmallPadding)
                .height(
                    Dimensions.ArticleCardSize
                )
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.md_theme_onPrimaryContainer),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                article.source?.let {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.md_theme_onPrimaryContainer),
                    )
                }
                Spacer(modifier = Modifier.width(Dimensions.ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription =null,
                    modifier = Modifier.size(Dimensions.SmallIconSize),
                    tint = colorResource(id = R.color.md_theme_onPrimaryContainer)
                )
                Spacer(modifier = Modifier.width(Dimensions.ExtraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.md_theme_onPrimaryContainer),
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    GetNotifiedTheme {
        Box(modifier = Modifier
            .background(color = colorResource(id = R.color.md_theme_background))
            .systemBarsPadding()
        ) {
            ArticleCard(article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Her train broke down. Her phone died. And then she met her Saver in a",
                url = "",
                urlToImage = ""
            )) {

            }
        }
    }
}