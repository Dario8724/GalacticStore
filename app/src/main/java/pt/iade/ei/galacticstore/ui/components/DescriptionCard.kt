package pt.iade.ei.galacticstore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

@Composable
fun DescriptionCard(
    @DrawableRes gameImage : Int,
    gameDescription : String
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
                    Image(painter = painterResource(gameImage),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(130.dp)
                            .clip(
                                shape = RoundedCornerShape(16.dp)
                            ))
                }
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column (){
                Text(gameDescription)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DescriptionCardPreview(){
    GalacticStoreTheme {
        DescriptionCard(gameImage = R.drawable.where_the_wind_meet, gameDescription = "Where Winds Meet is an epic Wuxia open-world action-adventure RPG set in ancient China at the tenth century.")
    }
}