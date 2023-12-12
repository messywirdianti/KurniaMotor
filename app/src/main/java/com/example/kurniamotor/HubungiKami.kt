package com.example.kurniamotor

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class HubungiKami : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hubungi_kami)

        val btn_noTel = findViewById<Button>(R.id.btn_noTel)

        btn_noTel.setOnClickListener {
            val contact = "6281222579975" // use country code with your phone number

            val url = "https://api.whatsapp.com/send?phone=$contact"
            try {
                val pm: PackageManager = applicationContext.getPackageManager()
                pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(
                    this,
                    "Whatsapp app not installed in your phone",
                    Toast.LENGTH_SHORT
                ).show()
                e.printStackTrace()
            }
        }
    }
}