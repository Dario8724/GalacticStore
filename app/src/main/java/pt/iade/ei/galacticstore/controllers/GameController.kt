package pt.iade.ei.galacticstore.controllers

import pt.iade.ei.galacticstore.R
import pt.iade.ei.galacticstore.models.GameItem
import pt.iade.ei.galacticstore.models.PurchasableItem
import pt.iade.ei.galacticstore.ui.components.PurchasableItemCard

class GameController {
    fun getGames() : List<GameItem>{
        return listOf(
            GameItem(
                gameImage = R.drawable.where_the_wind_meet,
                gameName = "Where winds meet",
                gameDescription = "Where Winds Meet is an epic Wuxia open-world action-adventure RPG set in ancient China at the tenth century. Players will assume the role of a young sword master as they embark on a journey to uncover the mysteries of their own identity.",
            ),
            GameItem(
                gameImage = R.drawable.halo_the_master_chief_collection,
                gameName = "Halo",
                gameDescription = "The Master Chief’s iconic journey includes six games, built for PC and collected in a single integrated experience. Whether you’re a long-time fan or meeting Spartan 117 for the first time, The Master Chief Collection is the definitive Halo gaming experience.",
            ),
            GameItem(
                gameImage = R.drawable.marvel_rivals,
                gameName = "Marvel Rivals",
                gameDescription = "Marvel Rivals is a Super Hero Team-Based PVP Shooter! Assemble an all-star Marvel squad, devise countless strategies by combining powers to form unique Team-Up skills and fight in destructible, ever-changing battlefields across the continually evolving Marvel universe!",
            )
        )
    }
    fun getGameItem(gameName : String ) : List<PurchasableItem>{
        return when ( gameName) {
             "Where winds meet"  -> listOf(
                 PurchasableItem( R.drawable.helm,"Ancient Helm","This is a helm said to have belonged to emperor Zhu Wen", itemPrice = 12.99),
                 PurchasableItem( R.drawable.range_weapon,"Range Weapon","Inflict more damage on your enemy with this range weapon", itemPrice = 5.99),
                 PurchasableItem( R.drawable.magic_amulet,"Moon amulet","Gain the ability to be invisible by equipping this amulet", itemPrice = 15.95)
             )
            "Halo"  -> listOf(
                PurchasableItem( R.drawable.halo_reach,"Halo: Reach","Experience the heroic story of Noble Team, a group of Spartans, who through great sacrifice and courage.", itemPrice = 12.99),


                )
            "Marvel Rivals"  -> listOf(

            )
            // might need to change
            else -> emptyList()
        }
    }
}