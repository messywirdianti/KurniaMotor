package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        //Button Masuk
        val btnMasuk = findViewById<Button>(R.id.btn_masuk)

        btnMasuk.setOnClickListener {
            val masuk = Intent (this@RegistrasiActivity, LoginActivity::class.java)
            startActivity(masuk)
            finish()
        }
        //Button Daftar
        val btnDaftar = findViewById<Button>(R.id.btn_daftar)

        btnDaftar.setOnClickListener {
            val daftar = Intent (this@RegistrasiActivity, KonfirmasiPendaftaranActivity::class.java)
            startActivity(daftar)
            finish()
        }
    }
}