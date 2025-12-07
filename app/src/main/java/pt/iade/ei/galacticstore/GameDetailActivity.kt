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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import pt.iade.ei.galacticstore.ui.components.DescriptionCard
import pt.iade.ei.galacticstore.ui.components.PurchasableItemCard

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
                title = {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                        )
                    {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                        Text("Game's name")
                         Icon(painter = painterResource(R.drawable.favorite_icon),
                             contentDescription = "Add to favorites")
                    }
                },
            )
        }
        ) { innerPadding ->
        Column (
            modifier = Modifier.padding(all = 8.dp)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()
                    )
        ){
            Row {
                DescriptionCard(gameImage = R.drawable.where_the_wind_meet, gameDescription = "Where Winds Meet is an epic Wuxia open-world action-adventure RPG set in ancient China at the tenth century.")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text("Purchasable Items",
                    fontSize = 30.sp,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            // add diferent images here on the items
            PurchasableItemCard(itemImage = R.drawable.helm,"Helm","This is a helm said to have belonged to emperor Zhu Wen", itemPrice = 12.99)
            Spacer(modifier = Modifier.height(10.dp))
            PurchasableItemCard( R.drawable.range_weapon,"Range Weapon","Inflict more damage on your enemy with this range weapon", itemPrice = 5.99)
            Spacer(modifier = Modifier.height(10.dp))
            PurchasableItemCard( R.drawable.magic_amulet,"Magic amulet","Gain the ability to be invisible by equipping this amulet", itemPrice = 15.95)
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
