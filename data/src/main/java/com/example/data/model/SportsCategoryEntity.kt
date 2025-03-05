package com.example.data.model

import androidx.annotation.DrawableRes

data class SportsCategoryEntity(
    val data : List<SportsCategoryData>)

data class SportsCategoryData(
    val sportsCategoryTitle:String,
    @DrawableRes
    val sportsCategoryImageUrl:Int,
    val sportsCategoryItem: List<SportsCategoryLists>?)


data class SportsCategoryLists(
    val sportsTitle: String,
    val sportsDescription: String,
    @DrawableRes
    val sportsImageUrl:Int,
)