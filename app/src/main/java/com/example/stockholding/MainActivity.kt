package com.example.stockholding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stockholding.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private var _mainActivityBinding : ActivityMainBinding? = null
    private val mainActivityBinding: ActivityMainBinding
        get() = _mainActivityBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
    }
}