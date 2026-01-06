package com.example.counterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterModel: ViewModel() {
    private val _counter= MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    fun increment(){
        _counter.value=_counter.value?:0
        _counter.value=_counter.value?.plus(1)
    }
}