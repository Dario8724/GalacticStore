package pt.iade.ei.galacticstore.models

import androidx.annotation.DrawableRes

data class PurchasableItem(
    @DrawableRes val itemImage : Int,
    var itemName : String,
    var itemDescription : String,
    var itemPrice : Double
)