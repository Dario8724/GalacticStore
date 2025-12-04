package pt.iade.ei.galacticstore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.ui.theme.GalacticStoreTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test(){
    ModalBottomSheet(onDismissRequest = {}, // i don't know what its meant for
     sheetState = rememberModalBottomSheetState()
    ) {
        TestContent()
    }
}

@Composable
fun TestContent(){
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
                       fontWeight = FontWeight.Black
                    )
                }
                Row {
                    Text("Here goes a little description of the item")
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                   ) {
                    Text("$ 12.99 ")
                    Button(onClick = {} ) {
                        Text(
                            "Buy with 1 -click"
                        )
                    }
                }
            }
        }

    }
}


@Preview
@Composable
fun TestPreview (){
    GalacticStoreTheme {
        TestContent()
        //Test()
    }
}