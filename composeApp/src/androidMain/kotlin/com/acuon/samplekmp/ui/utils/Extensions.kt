package com.acuon.samplekmp.ui.utils


fun Float?.toPercentage(): Int {
    this ?: return 0
    return (this * 100).toInt()
}

fun calculateProgress(value: Int, total: Int): Float {
    return (value.toFloat() / total.toFloat())
}