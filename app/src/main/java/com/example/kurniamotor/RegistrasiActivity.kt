package com.example.kurniamotor

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        auth = FirebaseAuth.getInstance()

        //Button Daftar
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)
        val edt_email = findViewById<EditText>(R.id.edt_email)
        val edt_kataSandi= findViewById<EditText>(R.id.edt_kataSandi)

        btnDaftar.setOnClickListener {
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

            registerUser(email, kataSandi)
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

    private fun registerUser(email: String, kataSandi: String) {
        auth.createUserWithEmailAndPassword(email, kataSandi)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    showLoading("Membuat Akun ...")
                    Intent(this@RegistrasiActivity, LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        Toast.makeText(this, "Akun berhasil di buat", Toast.LENGTH_SHORT).show()
                    }
                }else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this@RegistrasiActivity, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
    private fun showLoading(msg:String) {
        progressDialog = ProgressDialog.show(this, null, msg, true)
    }
}