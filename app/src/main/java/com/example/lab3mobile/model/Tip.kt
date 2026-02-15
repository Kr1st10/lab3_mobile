package com.example.lab3mobile.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val id: Int,
    @StringRes val titleRes: Int,
    @StringRes val shortDescRes: Int,
    @StringRes val fullDescRes: Int,
    @DrawableRes val imageRes: Int
)