package com.example.myass01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myass01.ui.main.MainFragment
import com.example.myass01.ui.main.github.GithubFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                //.replace(R.id.container, MainFragment.newInstance())
                .replace(R.id.container, GithubFragment.newInstance())
                .commitNow()
        }
    }
}