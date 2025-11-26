package pt.iade.ei.galacticstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalacticStoreTheme {
                GameListView()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameListView() {
     // todo : change the top app bar color
    // todo: add notification and setings icon on the top app bar
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF7CCE6B),
                ),
                title = {}
            )
        },
        bottomBar = {

        },

    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
            Text( "olá mundo ")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GalacticStoreTheme {
        GameListView()
    }
}