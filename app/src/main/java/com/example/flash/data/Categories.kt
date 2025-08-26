package com.example.flash.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Categories(
    @StringRes val name: Int,
    @DrawableRes val imageResource: Int
)
