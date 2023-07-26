package com.example.myass01.ui.main.github

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private var githubService: GithubService
): ViewModel() {

    init { // see whether the github service alive or not
        viewModelScope.launch{
            var response = githubService.users()
            var login = response.body()?.get(2)?.login // array of users
            if(login != null) {
                Log.d("GITHUB USER",login)
            }


        }
       // var users = githubService.users() --> to ignore this coroutine

    }
}