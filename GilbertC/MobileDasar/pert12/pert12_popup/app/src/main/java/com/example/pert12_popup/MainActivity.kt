package com.example.pert12_popup

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var popupmenu = PopupMenu(this,btnMenuPop)
        popupmenu.menuInflater.inflate(R.menu.my_menu,popupmenu.menu)
        popupmenu.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when(it.itemId){
                R.id.select_all -> {
                    edit_text_1.selectAll()
                    true
                }
                R.id.share -> {
                    ShareCompat.IntentBuilder
                        .from(this@MainActivity)
                        .setType("text/plain")
                        .setText(edit_text_1.text.toString())
                        .startChooser()
                    true
                }
                R.id.delete ->{
                    edit_text_1.setText("")
                    true
                }
                else -> false
            }
        }
        btnMenuPop.setOnClickListener {
            popupmenu.show()
        }
    }

    fun myToast(text: String, timw: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, text, timw).show()
    }
}

