package com.example.flash.data

import com.example.flash.R
import com.example.flash.ui.Item

object DataSource {
    fun dataLoad(): List<Categories>{
        return listOf(
            Categories(R.string.fresh_fruits,  R.drawable.fruity),
            Categories( R.string.bath_body,  R.drawable.fruity),
            Categories( R.string.bread_biscuits,  R.drawable.fruity),
            Categories( R.string.kitchen_essential,  R.drawable.fruity),
            Categories( R.string.munchies,  R.drawable.fruity),
            Categories( R.string.packaged_food,  R.drawable.fruity),
            Categories( R.string.stationary,  R.drawable.fruity),
            Categories( R.string.pet_food,  R.drawable.fruity),
            Categories( R.string.sweet_tooth,  R.drawable.fruity),
            Categories( R.string.vegetables,  R.drawable.fruity),
            Categories( R.string.beverages,  R.drawable.fruity),
            Categories( R.string.cleaning_essentials,  R.drawable.fruity)
        )
    }

    fun itemLoad(): List<Item> {
        return listOf(
            Item(R.string.banana_robusta,R.string.fresh_fruits,"1 kg",100,R.drawable.fruity),
            Item(R.string.shimla_apple,R.string.fresh_fruits,"1 kg",250,R.drawable.fruity),
            Item(R.string.papaya_semi_ripe,R.string.fresh_fruits,"1 kg",150,R.drawable.fruity),
            Item(R.string.pomogranate,R.string.fresh_fruits,"500 g",150,R.drawable.fruity),
            Item(R.string.pinepapple,R.string.fresh_fruits,"1 kg",130,R.drawable.fruity),
            Item(R.string.pepsi_can,R.string.beverages,"1 kg",40,R.drawable.fruity)
        )
    }
}