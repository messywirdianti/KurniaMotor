package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView

class RegistrasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        //Button Daftar
        val btnDaftar = findViewById<Button>(R.id.btn_daftar)

        btnDaftar.setOnClickListener {
            val daftar = Intent (this@RegistrasiActivity, KonfirmasiPendaftaranActivity::class.java)
            startActivity(daftar)
            finish()
        }
        val tv_account = findViewById<TextView>(R.id.tv_sudahPunyaAkun)
        val text = "Sudah punya akun? Masuk"
        val spanString = SpannableString(text)

        val accountText = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@RegistrasiActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        spanString.setSpan(accountText,18, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_account.text = spanString
        tv_account.movementMethod = LinkMovementMethod.getInstance()
    }
}