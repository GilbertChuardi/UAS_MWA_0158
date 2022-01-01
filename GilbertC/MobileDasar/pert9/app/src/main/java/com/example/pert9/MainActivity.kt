package com.example.pert9

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun myToast(Pesan : String,Waktu :Int =Toast.LENGTH_SHORT)
            = Toast.makeText(this,Pesan,Waktu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Button1.setOnClickListener {
            showToast()
        }
        ImageButton1.setOnLongClickListener {
            Button1.text = "Loong Klik"
            return@setOnLongClickListener true
        }
        ImageButton1.setOnClickListener {
            Button1.text = "Klik"
        }
        fab1.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_UP -> Button1.text = "UP"
                MotionEvent.ACTION_DOWN -> Button1.text = "Down"
            }
            return@setOnTouchListener true
        }
        fab1.setOnFocusChangeListener { view, b ->
            if(b){
                ImageButton1.setBackgroundColor(0xFF0000FF.toInt())
            }
            else{
                ImageButton1.setBackgroundColor(Color.YELLOW)
            }
        }
    }

    fun showToast() {
        myToast("hallo").apply {
            setGravity(Gravity.CENTER ,0,-500)
        }.show()
    }
}