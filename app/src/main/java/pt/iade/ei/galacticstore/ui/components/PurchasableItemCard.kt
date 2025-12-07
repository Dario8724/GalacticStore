package pt.iade.ei.galacticstore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

@Composable
fun PurchasableItemCard(
    @DrawableRes itemImage : Int,
    itemName : String,
    itemDescription : String,
    itemPrice : Double
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp,
            pressedElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                Box() {
                    Image(painter = painterResource(itemImage),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(130.dp)
                    )
                }
            }
            Column (modifier = Modifier.padding(all = 6.dp)){
                Row {
                    Text(itemName,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(itemDescription)
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    Button(
                        // add navigation later
                        onClick = {} ) {
                        Text(
                            "$ " + itemPrice.toString()
                        )
                    }
                }
            }
        }

    }
}


// preview
@Preview(showBackground = true)
@Composable
fun PurchasableItemCardPreviw(){
    GalacticStoreTheme {
        PurchasableItemCard(itemImage = R.drawable.helm,"Helm","This is a helm said to have belonged to emperor Zhu Wen", itemPrice = 12.99)
    }
}