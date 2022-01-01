package com.example.pert12_options

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun myToast(text: String, timw: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, text, timw).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.my_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.newFile -> myToast("Create New File Done")
            R.id.newFolder -> myToast("Create New Folder Done")
            R.id.help -> myToast("help")
            R.id.open ->{
            }
        }
        return true
    }
}

