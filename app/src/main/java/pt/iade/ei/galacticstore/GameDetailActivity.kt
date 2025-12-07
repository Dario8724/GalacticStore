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
import pt.iade.ei.galacticstore.controllers.GameController
import pt.iade.ei.galacticstore.models.PurchasableItem
import pt.iade.ei.galacticstore.ui.components.DescriptionCard
import pt.iade.ei.galacticstore.ui.components.PurchasableItemCard

import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val gameName = intent.getStringExtra("gameName") ?: return
        val gameImage = intent.getIntExtra("gameImage", -1)
        val gameDescription = intent.getStringExtra("gameDescription") ?: ""

        // buscar items
        val controller = GameController()
        val items = controller.getGameItem(gameName)
        setContent {

            GalacticStoreTheme {
                // todo : make it able to fetch info
                GameDetailView(
                    gameName = gameName,
                    gameImage = gameImage,
                    gameDescription = gameDescription,
                    items = items
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailView(
    gameName : String,
    gameImage : Int,
    gameDescription : String,
    items : List<PurchasableItem>
) {
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
                        Text(gameName)
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
                // change later
                DescriptionCard(gameImage = gameImage, gameDescription = gameDescription)
                //DescriptionCard(gameImage = R.drawable.where_the_wind_meet, gameDescription = "Where Winds Meet is an epic Wuxia open-world action-adventure RPG set in ancient China at the tenth century.")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text("Purchasable Items",
                    fontSize = 30.sp,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            // add diferent images here on the items
            for (item in items){
                PurchasableItemCard(
                    itemImage = item.itemImage,
                    itemName = item.itemName,
                    itemDescription = item.itemDescription,
                    itemPrice = item.itemPrice
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailActivityPreview() {
    GalacticStoreTheme {
        GameDetailView(
            gameName = "Halo",
            gameImage = R.drawable.halo_the_master_chief_collection,
            // change game description
            gameDescription = "Master Chief's legandary journey",
            items = listOf(
                PurchasableItem( R.drawable.halo_reach,"Halo: Reach","Experience the heroic story of Noble Team, a group of Spartans, who through great sacrifice and courage.", itemPrice = 34.95),
                PurchasableItem( R.drawable.master_chief_armor,"John-117","Master Chief Petty Officer John-117, a super-soldier of the UNSC's Spartan program", itemPrice = 18.50),
                PurchasableItem( R.drawable.hornet_skin,"Hornet skin - Black Rhine","Get the exact location of your enemies for 5 seconds with heat sensors", itemPrice = 3.99),
            )
        )
    }
}
