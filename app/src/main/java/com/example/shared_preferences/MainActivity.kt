package com.example.shared_preferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        saveBtn.setOnClickListener{
            val name=nameEt.text.toString().trim()
            var age=Integer.parseInt(ageEt.text.toString().trim())
            val experienced =switchh.isChecked

            val editor = sharedPreferences.edit()

            editor.putString("NAME",name)
            editor.putInt("AGE",age)
            editor.putBoolean("EXPERIENCED",experienced)

            editor.apply()

        }

        showInfoBtn.setOnClickListener{
            val name= sharedPreferences.getString("NAME","")
            val age= sharedPreferences.getInt("AGE",0)
            val experience= sharedPreferences.getBoolean("EXPERIENCED",false)

            infoTv.text="Name: $name \nAge: $age \nExperience: $experience"

        }





    }



}