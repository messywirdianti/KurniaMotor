package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        //Sudah Punya Akun
        val btnMasuk = findViewById<Button>(R.id.btn_masuk)
        val edt_email = findViewById<EditText>(R.id.edt_email)
        val edt_kataSandi= findViewById<EditText>(R.id.edt_kataSandi)

        btnMasuk.setOnClickListener {
            val email = edt_email.text.toString().trim()
            val kataSandi = edt_kataSandi.text.toString().trim()

            if (email.isEmpty()) {
                edt_email.error = "Email harus di isi"
                edt_email.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edt_email.error = "Email tidak valid"
                edt_email.requestFocus()
                return@setOnClickListener
            }

            if (kataSandi.isEmpty() || kataSandi.length < 8) {
                edt_kataSandi.error = "Kata sandi harus lebih dari 8 karakter"
                edt_kataSandi.requestFocus()
                return@setOnClickListener
            }

            LoginUser(email, kataSandi)
        }
        //Lupa Kata Sandi
        val tv_reset = findViewById<TextView>(R.id.tv_lupaKataSandi)
        val textReset = "Lupa kata sandi?"
        val spanStringReset = SpannableString(textReset)

        val accountReset = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@LoginActivity, LupaKataSandiActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        spanStringReset.setSpan(accountReset,0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_reset.text = spanStringReset
        tv_reset.movementMethod = LinkMovementMethod.getInstance()

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

    private fun LoginUser(email: String, kataSandi: String) {
        auth.signInWithEmailAndPassword(email, kataSandi)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Intent(this@LoginActivity, MainActivity::class.java).also {intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this@LoginActivity, MainActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}