package pt.iade.ei.galacticstore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme


@Composable
fun NavBarItem (
    @DrawableRes barIcon : Int,
    label : String,
    onclick : () -> Unit = {},
){
    // add selection identifier
            Button(
                onClick = onclick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xF3EDF7),
                    contentColor = Color.Unspecified
                )
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(painter = painterResource(barIcon),
                        contentDescription = label,
                        tint = Color.Black
                        )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = label,
                        color = Color.Black
                    )
                }
            }
    }

 @Composable
 fun NavBarItemView(){
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
 }

@Preview(showBackground = true)
@Composable
fun NavBarItemPreview(){
    GalacticStoreTheme {
        NavBarItemView()
    }
}
