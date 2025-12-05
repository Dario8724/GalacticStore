package pt.iade.ei.galacticstore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

@Composable
fun GameItem(
    @DrawableRes gameImage : Int,
    gameDescription : String
){

}

// function for detail page header card
@Composable
fun GameCardItem(){
    Card(colors = CardDefaults.cardColors(
        // add backround color
    ),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(all = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(shape = RoundedCornerShape(14.dp)) {
                Image(
                    painter = painterResource(R.drawable.where_the_wind_meet),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth(0.35f)
                )
            }


            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp)) {
                Text(
                    "Where Winds Meet is an epic Wuxia open-world action-adventure RPG set in ancient China at the tenth century",
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GameCardPreview(){
    GalacticStoreTheme {
        GameCardItem()
    }
}