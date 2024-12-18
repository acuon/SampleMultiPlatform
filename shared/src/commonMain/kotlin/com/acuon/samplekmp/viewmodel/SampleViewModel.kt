package com.acuon.samplekmp.viewmodel

import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SampleViewModel : ViewModel() {

    val sample: MutableStateFlow<String> = MutableStateFlow("").cMutableStateFlow()
}