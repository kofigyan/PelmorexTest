package com.example.pelmorextest.viewmodel.base

import androidx.lifecycle.ViewModel
import com.example.pelmorextest.util.DialogMessage
import com.example.pelmorextest.util.UiMessageDispatcher

open class BaseViewModel: ViewModel() {


    val dialogMessageDispatcher: UiMessageDispatcher<DialogMessage> =
        UiMessageDispatcher()



}