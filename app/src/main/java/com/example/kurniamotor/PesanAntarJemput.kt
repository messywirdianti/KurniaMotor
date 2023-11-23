package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PesanAntarJemput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_antar_jemput)

        val btn_batal = findViewById<Button>(R.id.btn_batal)

        btn_batal.setOnClickListener {
            val i = Intent(this@PesanAntarJemput, DeliverFragment::class.java)
            startActivity(i)
            finish()
        }
    }
}