//package com.example.kurniamotor
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class FormBookingActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_form_booking)
//
//        val btn_batal = findViewById<Button>(R.id.btn_batal)
//
//        btn_batal.setOnClickListener {
//            val i = Intent(this@FormBookingActivity, BookingFragment::class.java)
//            startActivity(i)
//            finish()
//        }
//    }
//
//}

package com.example.kurniamotor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormBookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_booking)

        val btn_batal = findViewById<Button>(R.id.btn_batal)

        btn_batal.setOnClickListener {
            val i = Intent(this@FormBookingActivity, BookingFragment::class.java)
            startActivity(i)
            finish()
        }

        val btn_ajukan = findViewById<Button>(R.id.btn_ajukan)

        btn_ajukan.setOnClickListener {
            val i = Intent(this@FormBookingActivity, StatusBookingActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}