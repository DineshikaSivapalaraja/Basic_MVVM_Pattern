package com.example.myass01.ui.main

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var result = MutableLiveData<Double>(0.0)

    fun add(number1:Double,number2:Double){
        /*var _result = number1.plus(number2)
        result.value = _result*/

        result.value = number1.plus(number2)
        //println(result.value)
        Log.d("Add Result",result.value.toString())
    }

//    fun addAntiFunction(number1:Double,number2:Double):Double {
//        return number1.plus(number2)
//
//    } ----->ANTI OBSERVER PATTERN


//    fun addAntiFunction(number1:Double,number2:Double,message:TextView){
//        result.value = number1.plus(number2)
//        message.text = result.value.toString()
//        Log.d("Add Result",result.value.toString())
//    }   // 2nd anti pattern ---> here we used text view as a view component in ViewModel
}