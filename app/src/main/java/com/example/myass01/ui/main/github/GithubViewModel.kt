package com.example.myass01.ui.main.github

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private var githubService: GithubService
): ViewModel() {

    private val _users = MutableLiveData<List<GithubUser>>()//after binding
    val users = _users

    init { // see whether the github service alive or not
        viewModelScope.launch{
            var response = githubService.users()   //get the response from user and assign it below
            _users.value = response.body()   //after binding
//            var login = response.body()?.get(2)?.login // array of users
//            if(login != null) {
//                Log.d("GITHUB USER",login)
//            }


        }
       // var users = githubService.users() --> to ignore this coroutine

    }
}