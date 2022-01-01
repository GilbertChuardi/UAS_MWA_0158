package com.example.uts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_replay.*

class ReplayActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_replay)

        //ambil data
        var intentExtra = intent

        textViewNameReplay.text     = "Name  : ${intentExtra.getStringExtra(EXTRA_MESSAGENAME)}"
        textViewClassReplay.text    = "Class : ${intentExtra.getStringExtra(EXTRA_MESSAGECLASS)}"
        textViewAgeReplay.text      = "Age   : ${intentExtra.getStringExtra(EXTRA_NUMBERAGE)}"


    }

    fun onBackButton(view: View) {
        finish()
    }

}



















