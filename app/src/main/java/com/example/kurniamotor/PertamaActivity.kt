package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PertamaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertama)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            val intent = Intent(this@PertamaActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}