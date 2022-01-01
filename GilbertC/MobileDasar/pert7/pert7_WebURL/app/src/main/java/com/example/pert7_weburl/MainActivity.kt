package com.example.pert7_weburl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWeb(view: View) {
        var txt = inputText.text.toString()
        var googleSearch = Uri.parse("https://www.google.com/search?q=$txt")
        var googleIntent = Intent(Intent.ACTION_VIEW,googleSearch)
        if(googleIntent.resolveActivity(packageManager) != null)
            startActivity(googleIntent)
        else
            Log.e("Intent", "gagal dijalankan")
    }

}