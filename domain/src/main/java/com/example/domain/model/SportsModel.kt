package com.example.domain.model

import androidx.annotation.DrawableRes


data class SportsModel(val data : List<SportsModelData>?)

data class SportsModelData(
    val sportsCategoryTitle:String,
    @DrawableRes
    val sportsCategoryImageUrl:Int,
    val sportsCategoryItem: List<SportsModelLists>?)


data class SportsModelLists(
    @DrawableRes
    val sportsImageUrl:Int,
    val sportsTitle: String,
    val sportsDescription: String
)