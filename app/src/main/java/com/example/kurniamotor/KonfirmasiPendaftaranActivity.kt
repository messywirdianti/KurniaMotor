package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KonfirmasiPendaftaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi_pendaftaran)

        val btnMasuk = findViewById<Button>(R.id.btn_masuk)

        btnMasuk.setOnClickListener {
            val masuk = Intent (this@KonfirmasiPendaftaranActivity, LoginActivity::class.java)
            startActivity(masuk)
            finish()
        }
    }
}