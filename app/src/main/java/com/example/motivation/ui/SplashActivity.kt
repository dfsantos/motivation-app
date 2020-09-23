package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.AppConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var preferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        saveButton.setOnClickListener(this)
        preferences = SecurityPreferences(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        if (id.equals(R.id.saveButton)) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = nameEditText.text.toString()

        if (name.isNotBlank()) {
            preferences.storeString(AppConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }

}