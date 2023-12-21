package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LupaKataSandiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_kata_sandi)

        val btnAturUlang = findViewById<Button>(R.id.btn_aturUlangSandi)
        val edt_email = findViewById<EditText>(R.id.edt_email)

        btnAturUlang.setOnClickListener {
            val email = edt_email.text.toString().trim()

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

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful) {
                    Toast.makeText(this, "Silahkan cek email untuk mengganti kata sandi", Toast.LENGTH_SHORT).show()
                    Intent(this@LupaKataSandiActivity, LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}