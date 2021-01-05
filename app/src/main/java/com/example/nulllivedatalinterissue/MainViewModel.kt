package com.example.nulllivedatalinterissue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _nonNullableValue = MutableLiveData<String>()
    val nonNullableValue: LiveData<String> = _nonNullableValue

    private val _nullableValue = MutableLiveData<String?>()
    val nullableValue: LiveData<String?> = _nullableValue

    init {
        // Good
        _nonNullableValue.value = "I can never be null and the lint check should enforce this"

        // Bad This is failing lint test as fatal but should be allowed given it is defined as nullable (i.e. <String?>)
        _nullableValue.value = null
    }
}