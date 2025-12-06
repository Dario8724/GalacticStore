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

        ) { innerPadding ->
        Column (
            modifier = Modifier.padding(all = 8.dp)
            //  .background(color = Color.Black)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()
                    )
        ){
            Row {
                DescriptionCard()
            }
            Row {
                Text("Purchasable Items",
                    fontSize = 30.sp,

                )
            }
            // add diferent images here on the items
            PurchasableItemCard()
            Spacer(modifier = Modifier.height(10.dp))
            PurchasableItemCard()
            Spacer(modifier = Modifier.height(10.dp))
            PurchasableItemCard()
        }
    }
}
// testing something
@Composable
fun DescriptionCard(
    // this here receives an game image and a game  description
){
    Card (
       modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xF3EDF7)
        )
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Box(){
                    Image(painter = painterResource(R.drawable.where_the_wind_meet),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(130.dp)
                            .clip(
                                shape = RoundedCornerShape(12.dp)
                            ))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column (){
                Text("Esse jogo é a melhor coisa já criada nesse mundo ")
            }

        }
    }

}


// fix now
//function that contains the items
// change function's name
@Composable
fun PurchasableItemCard(){
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
                        .size(150.dp, 110.dp))
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
        PurchasableItemCard()
    }
}