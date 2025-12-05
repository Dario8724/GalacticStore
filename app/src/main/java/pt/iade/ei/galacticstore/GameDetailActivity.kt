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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
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

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalacticStoreTheme {
                            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailView() {
    // todo : add description to the top app bar icons
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xF3EDF7),
                ),
                // fix later
                title = {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                        //horizontalArrangement = Arrangement.End
                        )
                    {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                        Text("Game's name"
                        )
                         Icon(painter = painterResource(R.drawable.favorite_icon),
                             contentDescription = "")
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
            //  .background(color = Color.Black)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()
                    )
        ){
            Row {
                test010()
            }
            Row {
                Text("Purchasable Items",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            // add diferent images here on the items
            GameCheck()
            Spacer(modifier = Modifier.height(10.dp))
            GameCheck()
            Spacer(modifier = Modifier.height(10.dp))
            GameCheck()
        }
    }
}
// testing something
@Composable
fun test010(){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color(0xF3EDF7)
        )
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(R.drawable.where_the_wind_meet),
                contentDescription = "")

            Text("pequena descrição do jogo")
        }
    }

}



//function that contains the items
// change function's name
@Composable
fun GameCheck(){
    Card(
        colors = CardDefaults.cardColors(
                containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                Image(painter = painterResource(R.drawable.helm),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                        .size(150.dp, 150.dp))
            }
            Column (modifier = Modifier.padding(all = 6.dp)){
                Row {
                    Text("Item name",
                        fontSize = 30.sp,
                       // fontWeight = FontWeight.Black
                    )
                }
               Row {
                   Text("Here goes a little description of the item")
               }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Button(onClick = {} ) {
                        Text(
                            "$ 12.99 "
                        )
                    }
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GameDetailActivityPreview() {
    GalacticStoreTheme {
        GameDetailView()
    }
}

// delete later
@Preview(showBackground = true)
@Composable
fun GameCheckPreviw(){
    GalacticStoreTheme {
        GameCheck()
    }
}