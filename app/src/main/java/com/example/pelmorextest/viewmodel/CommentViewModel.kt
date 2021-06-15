package com.example.pelmorextest.viewmodel

import android.util.Patterns
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import com.example.pelmorextest.constant.MIN_VALID_NAME_LENGTH
import com.example.pelmorextest.constant.TEXT_TYPING_DELAY_MS
import com.example.pelmorextest.repository.CommentRepository
import com.example.pelmorextest.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CommentViewModel @Inject constructor(
    private val commentRepository: CommentRepository
) : BaseViewModel() {

    private val _name = MutableStateFlow("")
    private val _email = MutableStateFlow("")
    private val _phoneNumber = MutableStateFlow("")


    fun setName(name: String) {
        _name.value = name
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPhoneNumber(phoneNumber: String) {
        _phoneNumber.value = phoneNumber
    }


    private val _nameTypedValidResult: Flow<String> =
        _name.debounce(TEXT_TYPING_DELAY_MS).mapLatest {
            if (it.isEmpty()) {
                return@mapLatest "Please enter your name"
            } else if (!isLetters(it.trim())) {
                return@mapLatest "Name must not contain a number"
            } else if (it.trim().length < MIN_VALID_NAME_LENGTH) {
                return@mapLatest "Name must be at least 5 characters"
            } else {
                return@mapLatest ""
            }
        }

    private val nameTypedResult = _nameTypedValidResult.asLiveData()


    private val _emailTypedValidResult: Flow<String> =
        _email.debounce(TEXT_TYPING_DELAY_MS).mapLatest {
            if (it.isEmpty()) {
                return@mapLatest "Please enter your email address"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(it).matches()) {
                return@mapLatest "Email address is invalid"
            } else {
                return@mapLatest ""
            }
        }

    private val emailTypedResult = _emailTypedValidResult.asLiveData()


    private val _phoneNumberTypedValidResult: Flow<String> =
        _phoneNumber.debounce(TEXT_TYPING_DELAY_MS).mapLatest {
            if (it.isEmpty()) {
                return@mapLatest "Please enter your phone number"
            } else if (!it.isDigitsOnly()) {
                return@mapLatest "Phone number should be all numbers"
            } else {
                return@mapLatest ""
            }
        }

    private val phoneNumberTypedResult = _phoneNumberTypedValidResult.asLiveData()

    val allTypedResults = MediatorLiveData<String>()


    val isSubmitBtnEnabled: Flow<Boolean> =
        combine(_name, _email, _phoneNumber) { name, email, phoneNumber ->
            val isNameValid = !name.isNullOrEmpty() && name.length > 4
            val isEmailValid =
                !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
            val isPhoneNumberValid = !phoneNumber.isNullOrEmpty() && phoneNumber.isDigitsOnly()

            return@combine isNameValid and isEmailValid and isPhoneNumberValid
        }


    private suspend fun simulateNetworkOperation(request: String): String =
        withContext(Dispatchers.Default) {
            delay(1000)
            "simulate network delay of 3s : $request"
        }


    private fun setValue(newValue: String) {
        if (allTypedResults.value != newValue) {
            allTypedResults.value = newValue
        }
    }

    private fun isLetters(string: String): Boolean {
        for (c in string) {
            if (c.isDigit()) {
                return false
            }
        }
        return true
    }


    init {

        allTypedResults.addSource(phoneNumberTypedResult) { newValue ->
            setValue(newValue)
        }

        allTypedResults.addSource(emailTypedResult) { newValue ->
            setValue(newValue)
        }


        allTypedResults.addSource(nameTypedResult) { newValue ->
            setValue(newValue)
        }

    }


}