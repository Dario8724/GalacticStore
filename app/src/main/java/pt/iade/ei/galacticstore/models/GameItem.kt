package pt.iade.ei.galacticstore.models

import androidx.annotation.DrawableRes

data class GameItem (
    @DrawableRes var gameImage : Int,
    var gameName : String,
    var gameDescription : String,
    var gameItemName : String,
    var itemDescription : String,
    var itemPrice : String,
    @DrawableRes var itemImage : Int,
)