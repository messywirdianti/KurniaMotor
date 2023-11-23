package com.example.kurniamotor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class DeliverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_deliver, container, false)

        val btn_daftarLayanan = view.findViewById<Button>(R.id.btn_daftarLayanan)
        btn_daftarLayanan.setOnClickListener {
            val i = Intent(this@DeliverFragment.context, PesanAntarJemput::class.java)
            startActivity(i)
        }
        return view
    }

    companion object {
        fun newIntance(): DeliverFragment {
            return DeliverFragment()
        }
    }

}