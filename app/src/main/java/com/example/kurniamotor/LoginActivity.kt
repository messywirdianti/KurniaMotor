package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Sudah Punya Akun
        val btnMasuk = findViewById<Button>(R.id.btn_masuk)

        btnMasuk.setOnClickListener {
            val home = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(home)
            finish()
        }
        //Belum Punya Akun
        val tv_account = findViewById<TextView>(R.id.tv_belumPunyaAkun)
        val text = "Belum punya akun? Daftar"
        val spanString = SpannableString(text)

        val accountText = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@LoginActivity, RegistrasiActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        spanString.setSpan(accountText,18, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_account.text = spanString
        tv_account.movementMethod = LinkMovementMethod.getInstance()
    }
}