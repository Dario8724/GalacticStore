package pt.iade.ei.galacticstore.models

import androidx.annotation.DrawableRes

data class GameItem (
    @DrawableRes var gameImage : Int,
    var gameName : String,
    var gameDescription : String,
)