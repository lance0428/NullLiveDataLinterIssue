package com.example.nulllivedatalinterissue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val nonNullableValue = MutableLiveData<String>()
    val nullableValue = MutableLiveData<String?>()

    // This slightly different syntax but probably same root issue is also an unexpected lint error
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        // Good :)
        nonNullableValue.value = "I can never be null and the lint check should enforce this"

        // Bad :( This is failing lint test as fatal but should be allowed given it is defined as nullable (i.e. <String?>)
        nullableValue.value = null

        // Bad :( This is failing lint test as fatal but should be allowed given it is defined as nullable (i.e. <String?>)
        _error.value = null
    }
}