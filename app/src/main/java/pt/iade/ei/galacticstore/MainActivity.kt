    package pt.iade.ei.galacticstore

    import android.content.Intent
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material3.BottomAppBar
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
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
    import androidx.compose.ui.graphics.Brush
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.Shape
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import pt.iade.ei.galacticstore.ui.components.GameCardItem
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
        // todo : add description to the top app bar icons

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
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                   // .background(color = Color(0xFF2be4dc))
                 // work on another backround color 
            ){
                // review later
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(
                        "Galactic Store ",
                        fontWeight = FontWeight.Black,
                        fontSize = 40.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                GameCard()
                Spacer(modifier = Modifier.height(4.dp))
                GameCard()
                Spacer(modifier = Modifier.height(4.dp))
                GameCard()
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        GalacticStoreTheme {
            GameListView()
            // change this name later
        }
    }


    // card for the games
    // i might not need this preview since i directly call it up there
    @Composable
    fun GameCard(){
        Card(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
            )
        {
            Box(
// add configuration of the box here
            ){

                Image(
                    painter = painterResource(R.drawable.where_the_wind_meet),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp)
                )
                Column(modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Text(
                        "Where Winds Meet",
                        color = Color.White,
                        fontSize = 30.sp)
                }
                }
            }
        }

    @Preview(showBackground = true)
    @Composable
    fun GameCardPreview(){
        GalacticStoreTheme {
           GameCard()
        }
    }