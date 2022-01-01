package com.example.pert6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSendButton(view: View) {
        //Intent Eksplisit
        var pesan = strMessageSend.text.toString()
        var intentReplay = Intent(this,ReplayActivity::class.java)
        //dengan Data
        //intentReplay.setData(Uri.parse("custom://$pesan"))
        //intentReplay.setData(Uri.parse("http://www.google.com"))
        //dengan Extra
        intentReplay.putExtra(EXTRA_MESSAGE, pesan)
        intentReplay.putExtra(EXTRA_NUMBER,10)
        startActivity(intentReplay)
    }
}