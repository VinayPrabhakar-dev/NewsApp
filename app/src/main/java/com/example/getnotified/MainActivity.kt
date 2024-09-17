package com.example.getnotified

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.getnotified.data.local.NewsDao
import com.example.getnotified.domain.model.Article
import com.example.getnotified.domain.model.Source
import com.example.getnotified.presentation.navgraph.NavGraph
import com.example.getnotified.ui.theme.GetNotifiedTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()


        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }
        setContent {
            GetNotifiedTheme {

                Scaffold (
                    content = { innerPadding ->

                        val isSystemInDarkMode = isSystemInDarkTheme()
                        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

                        SideEffect {
                            windowInsetsController.isAppearanceLightStatusBars = !isSystemInDarkMode
                            windowInsetsController.isAppearanceLightNavigationBars = !isSystemInDarkMode
                        }

                        Box(modifier = Modifier
                            .background(color = colorResource(id = R.color.md_theme_background))
                            .padding(innerPadding)
                            .systemBarsPadding()
                        ){
                            val startDestination = viewModel.startDestination
                            NavGraph(startDestination = startDestination)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    GetNotifiedTheme {
        Greeting("Android")
    }
}