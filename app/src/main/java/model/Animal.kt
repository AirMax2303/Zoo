package model

import androidx.annotation.DrawableRes
//import androidx.compose.ui.tooling.data.EmptyGroup
import com.example.zoo.R

data class Animal(
    val name: String,
    @DrawableRes val image: Int?,
    val description: String
)

class Repo(

    val tabs: List<String> = listOf("Home", "About", "Settings"),

    val animalList01: List<Animal> = listOf(
        Animal(
            name = "Жираф", image = R.drawable.giraffe, description = "Парнокопытное млекопитающее относится к семейству жирафовых. Животное является самым высоким на планете."
        ), Animal(
            name = "Зебра", image = R.drawable.zebra, description = "Непарнокопытные млекопитающие относятся к семейству лошадиных. Длина тела зебры приблизительно 2 м, вес – максимум 360 кг."
        ), Animal(
            name = "name03", image = R.drawable.image2, description = "description"
        ), Animal(
            name = "name04", image = R.drawable.image3, description = "description"
        ), Animal(
            name = "name05", image = R.drawable.image4, description = "description"
        ), Animal(
            name = "name06", image = R.drawable.image5, description = "description"
        ), Animal(
            name = "name07", image = R.drawable.image6, description = "description"
        ), Animal(
            name = "name08", image = R.drawable.image7, description = "description"
        ), Animal(
            name = "name09", image = R.drawable.image8, description = "description"
        ), Animal(
            name = "name10", image = R.drawable.image9, description = "description"
        ), Animal(
            name = "name01", image = R.drawable.image10, description = "description"
        )
    ),

    val animalList02: List<Animal> = listOf(
        Animal(
            name = "02name01", image = R.drawable.dice_1, description = "description"
        ), Animal(
            name = "02name02", image = R.drawable.dice_2, description = "description"
        ), Animal(
            name = "02name03", image = R.drawable.dice_3, description = "description"
        ), Animal(
            name = "02name04", image = R.drawable.dice_4, description = "description"
        ), Animal(
            name = "02name05", image = R.drawable.dice_5, description = "description"
        ), Animal(
            name = "02name06", image = R.drawable.dice_6, description = "description"
        ), Animal(
            name = "02name07", image = R.drawable.image6, description = "description"
        ), Animal(
            name = "02name08", image = R.drawable.image7, description = "description"
        ), Animal(
            name = "02name09", image = R.drawable.image8, description = "description"
        ), Animal(
            name = "02name10", image = R.drawable.image9, description = "description"
        ), Animal(
            name = "02name01", image = R.drawable.image10, description = "description"
        )
    ),

    val animalList03: List<Animal> = listOf(
        Animal(
            name = "03name01", image = R.drawable.image1, description = "description"
        ),
        Animal(
            name = "03name02", image = R.drawable.image1, description = "description"
        ),
        Animal(
            name = "03name03", image = R.drawable.image2, description = "description"
        ),
        Animal(
            name = "03name04", image = R.drawable.image3, description = "description"
        ),
        Animal(
            name = "03name05", image = R.drawable.image4, description = "description"
        ),
        Animal(
            name = "03name06", image = R.drawable.image5, description = "description"
        ),
        Animal(
            name = "03name07", image = R.drawable.image6, description = "description"
        ),
        Animal(
            name = "03name08", image = R.drawable.image7, description = "description"
        ),
    ),

    val animalsList: List<List<Animal>> = listOf(animalList01, animalList02, animalList03),

    )


