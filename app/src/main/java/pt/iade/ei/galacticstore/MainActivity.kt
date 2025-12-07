    package pt.iade.ei.galacticstore


    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge

    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.verticalScroll
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
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import pt.iade.ei.galacticstore.models.GameItem
    import pt.iade.ei.galacticstore.ui.components.GameCard
    import pt.iade.ei.galacticstore.ui.components.NavBarItem
    import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                GalacticStoreTheme {
                    MainActivityView()
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainActivityView() {
        val item = GameItem(
            gameImage = R.drawable.where_the_wind_meet,
            gameName = "Where winds meet",
            gameDescription = "Where Winds Meet is an epic Wuxia open-world action-adventure RPG set in ancient China at the tenth century. Players will assume the role of a young sword master as they embark on a journey to uncover the mysteries of their own identity.",
        )
        val item1 = GameItem(
            gameImage = R.drawable.halo_the_master_chief_collection,
            gameName = "Halo",
            gameDescription = "The Master Chief’s iconic journey includes six games, built for PC and collected in a single integrated experience. Whether you’re a long-time fan or meeting Spartan 117 for the first time, The Master Chief Collection is the definitive Halo gaming experience.",
        )
        val item3 = GameItem(
            gameImage = R.drawable.marvel_rivals,
            gameName = "Marvel Rivals",
            gameDescription = "Marvel Rivals is a Super Hero Team-Based PVP Shooter! Assemble an all-star Marvel squad, devise countless strategies by combining powers to form unique Team-Up skills and fight in destructible, ever-changing battlefields across the continually evolving Marvel universe!",
        )
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = Color(0xF3EDF7),
                    ),
                    title = {
                        Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End){
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.outline_notifications_icon),
                                contentDescription = "Notifications icon")
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(painter = painterResource(R.drawable.outline_settings_icon),
                                contentDescription = "Settings icon")
                        }
                        } },
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
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())

            ){

                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(
                        "Galactic Store ",
                        fontWeight = FontWeight.Black,
                        fontSize = 40.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                GameCard(gameName = item.gameName, gameImage = item.gameImage)
                Spacer(modifier = Modifier.height(4.dp))
                GameCard(gameImage = item1.gameImage, gameName = item1.gameName)
                Spacer(modifier = Modifier.height(4.dp))
                GameCard(gameName = item3.gameName, gameImage = item3.gameImage)
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        GalacticStoreTheme {
            MainActivityView()
        }
    }

