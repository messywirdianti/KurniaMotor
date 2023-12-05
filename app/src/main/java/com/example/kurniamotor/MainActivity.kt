package com.example.kurniamotor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<MeowBottomNavigation>(R.id.mbn_navigation)

        setFragment(HomeFragment.newIntance())

        navigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_home))
        navigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_booking))
        navigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_deliver))
        navigation.add(MeowBottomNavigation.Model(4,R.drawable.ic_settings))

        navigation.setOnClickMenuListener {
            when(it.id){
                1 -> setFragment(HomeFragment.newIntance())
                2 -> setFragment(BookingFragment.newIntance())
                3 -> setFragment(DeliverFragment.newIntance())
                4 -> setFragment(SettingsFragment.newIntance())

                else -> ""
            }
        }
        navigation.show(1)
    }

    fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout,fragment,"mainActivity")
            .commit()
    }
}