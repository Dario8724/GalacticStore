package pt.iade.ei.galacticstore.ui.components

import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.galacticstore.GameDetailActivity
import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme


@Composable
fun GameCard(
    gameName : String,
    @DrawableRes gameImage : Int
){
    Card(
        onClick = {val intent = Intent(context, GameDetailActivity::class.java)
                  intent.putExtra("gameName", gameName)
                  intent.putExtra("gameImage", gameImage)
                  intent.putExtra("gameDescription", gameDescription)
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    )
    {
        Box(
        ){

            Image(
                painter = painterResource(gameImage),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .height(200.dp)
            )
            Column(modifier = Modifier
                                     .align(Alignment.BottomStart)
                                     .padding(bottom = 10.dp, start = 4.dp)
            ) {
                Card {
                    Text(
                        text = gameName,
                        color = Color.Black,
                        fontSize = 30.sp) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameCardPreview(){
    GalacticStoreTheme {
        GameCard(gameImage = R.drawable.halo_the_master_chief_collection,
            gameName = "Halo")
    }
}