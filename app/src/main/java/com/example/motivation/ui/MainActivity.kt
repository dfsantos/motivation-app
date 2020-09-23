package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivation.AppConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = SecurityPreferences(this)

        nameTextView.text = preferences.getString(AppConstants.KEY.PERSON_NAME)
    }

}