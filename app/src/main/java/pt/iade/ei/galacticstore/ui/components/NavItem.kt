package pt.iade.ei.galacticstore.ui.components

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.galacticstore.R


@Composable
fun NavBarItem (
    @DrawableRes barIcon : Int,
    label : String,
    onclick : () -> Unit = {}
){
    BottomAppBar(
        containerColor = Color(0xF3EDF7)
    ) {
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
                    Text(
                        text = label,
                        color = Color.DarkGray
                    )
                }
            }
    }
}
