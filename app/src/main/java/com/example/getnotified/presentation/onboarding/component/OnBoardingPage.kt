package com.example.getnotified.presentation.onboarding.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.getnotified.presentation.Dimensions
import com.example.getnotified.R
import com.example.getnotified.presentation.onboarding.Page
import com.example.getnotified.presentation.onboarding.pages
import com.example.getnotified.ui.theme.GetNotifiedTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column (
      modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimensions.MediumPadding2),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.md_theme_onPrimaryContainer)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimensions.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.md_theme_onPrimaryContainer)
        )
    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun OnBoardingPreview() {
    GetNotifiedTheme {
        Surface {
            OnBoardingPage(page = pages[0])
        }
    }
}