package com.example.pert6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_replay.*

class ReplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_replay)
        //Ambil Data
        //var intentData = intent.data
        //Ambil Extra
        var intentExtra = intent
        isiPesanTerkirim.text =
            "Pesan : ${intentExtra.getStringExtra(EXTRA_MESSAGE)}" +
            " Number ${intentExtra.getIntExtra(EXTRA_NUMBER,-1)}"
    }

    fun onReplayButton(view: View) {
        finish()
    }
}