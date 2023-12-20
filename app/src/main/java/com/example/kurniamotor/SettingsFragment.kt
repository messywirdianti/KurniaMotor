package com.example.kurniamotor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        auth = FirebaseAuth.getInstance()

        val btn_upprofile = view.findViewById<Button>(R.id.btn_upprofile)
        btn_upprofile.setOnClickListener {
            val i = Intent(this@SettingsFragment.context, EditProfil::class.java)
            startActivity(i)
        }
        val btn_about = view.findViewById<Button>(R.id.btn_about)
        btn_about.setOnClickListener {
            val i = Intent(this@SettingsFragment.context, TentangKami::class.java)
            startActivity(i)
        }
        val btn_hub = view.findViewById<Button>(R.id.btn_hub)
        btn_hub.setOnClickListener {
            val i = Intent(this@SettingsFragment.context, HubungiKami::class.java)
            startActivity(i)
        }
        val btn_keluar = view.findViewById<Button>(R.id.btn_keluar)
        btn_keluar.setOnClickListener {
            auth.signOut()
            Intent(this@SettingsFragment.context, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
        return view
    }

    companion object {
        fun newIntance(): SettingsFragment {
            return SettingsFragment()
        }
    }

}