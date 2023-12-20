package com.example.kurniamotor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment()  {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val ivProfile = view.findViewById<ImageView>(R.id.iv_profile)
        ivProfile.setOnClickListener {
            val i = Intent(this@HomeFragment.context, EditProfil::class.java)
            startActivity(i)
        }

        val lihatbooking = view.findViewById<ImageView>(R.id.lihatpesananbook)
        lihatbooking.setOnClickListener {
            val i = Intent(this@HomeFragment.context, LihatstatusbookingActivity::class.java)
            startActivity(i)
        }

        val lihatbookingantar = view.findViewById<ImageView>(R.id.lihatstatusantar)
        lihatbookingantar.setOnClickListener {
            val i = Intent(this@HomeFragment.context, LihatstatusantarActivity::class.java)
            startActivity(i)
        }
        return view

    }


    companion object {
        fun newIntance(): HomeFragment {
            return HomeFragment()
        }
    }

}