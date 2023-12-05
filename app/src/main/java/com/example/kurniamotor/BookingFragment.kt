package com.example.kurniamotor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BookingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
    View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        val btn_booking = view.findViewById<Button>(R.id.btn_booking)
            btn_booking.setOnClickListener {
                val i = Intent(this@BookingFragment.context, FormBookingActivity::class.java)
                startActivity(i)
            }

        return view

//        View? {
//            val view = inflater.inflate(R.layout.fragment_booking, container, false)
//
//            val btn_booking = view.findViewById<Button>(R.id.btn_booking)
//            btn_booking.setOnClickListener {
//                val i = Intent(this@BookingFragment.context, FormBookingActivity::class.java)
//                startActivity(i)
//            }
//            return view
//            }

    }

    companion object {
        fun newIntance(): BookingFragment {
            return BookingFragment()
        }
    }

}