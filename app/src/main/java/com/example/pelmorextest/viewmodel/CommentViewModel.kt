package com.example.pelmorextest.viewmodel

import android.util.Patterns
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pelmorextest.repository.CommentRepository
import com.example.pelmorextest.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CommentViewModel @Inject constructor(
    private val commentRepository: CommentRepository
) : BaseViewModel() {

    private val _name = MutableStateFlow("")
    private val _email = MutableStateFlow("")
    private val _phoneNumber = MutableStateFlow("")

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage


    fun setName(name: String) {
        _name.value = name
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPhoneNumber(phoneNumber: String) {
        _phoneNumber.value = phoneNumber
    }


    val isSubmitBtnEnabled: Flow<Boolean> =
        combine(_name, _email, _phoneNumber) { name, email, phoneNumber ->
            val isNameValid = !name.isNullOrEmpty() && name.length > 4
            val isEmailValid = !email.isNullOrEmpty() &&  Patterns.EMAIL_ADDRESS.matcher(email).matches()
            val isPhoneNumberValid = !phoneNumber.isNullOrEmpty() && phoneNumber.isDigitsOnly()

            return@combine isNameValid and isEmailValid and isPhoneNumberValid
        }


    private suspend fun simulateNetworkOperation(request: String): String =
        withContext(Dispatchers.Default) {
            delay(1000)
            "simulate network delay of 3s : $request"
        }

}