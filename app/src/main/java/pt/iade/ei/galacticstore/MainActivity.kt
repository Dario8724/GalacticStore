    package pt.iade.ei.galacticstore

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.material3.BottomAppBar
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import pt.iade.ei.galacticstore.ui.components.NavBarItem
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
        // todo : fix the placement of the icons on the top app bar
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = Color(0xF3EDF7),
                    ),
                    title = {
                        Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Absolute.Left){
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.outline_notifications_icon),
                                contentDescription = "")
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(painter = painterResource(R.drawable.outline_settings_icon),
                                contentDescription = "")
                        }
                        }
                            },
                )
            },
            bottomBar = {
                BottomAppBar(
                ) {
                    Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        NavBarItem(
                            barIcon = R.drawable.featured_icon ,
                            label = "Featured",
                            onclick = {}
                        )
                        NavBarItem(
                            barIcon = R.drawable.history_icon,
                            label = "History",
                            onclick = {}
                        )
                        NavBarItem(
                            barIcon = R.drawable.profile_icon,
                            label = " Prolfile",
                            onclick = {}
                        )
                    }
                }

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