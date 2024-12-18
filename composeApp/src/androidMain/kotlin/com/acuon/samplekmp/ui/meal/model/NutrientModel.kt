package com.acuon.samplekmp.ui.meal.model

data class NutrientModel(
    val label: String,
    val icon: Int? = null,
    val quantityInGm: Int? = null,
    val quantityInPercentage: Int? = null,
    val quantityInKcal: Int? = null,
    val nutrientBreakDown: List<NutrientBreakDown?>? = null
)

data class NutrientBreakDown(
    val label: String,
    val icon: Int? = null,
    val quantityInGm: Int? = null,
    val quantityInPercentage: Int? = null,
    val quantityInKcal: Int? = null,
)