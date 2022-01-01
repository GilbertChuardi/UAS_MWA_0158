package com.example.pert12_floating

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.app.ShareCompat
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(edit_text_1)
    }
    fun myToast(text: String, timw: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, text, timw).show()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var menuInflater = menuInflater
        menuInflater.inflate(R.menu.my_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.select_all -> edit_text_1.selectAll()
            R.id.delete -> edit_text_1.setText("")
            R.id.share ->{
                ShareCompat.IntentBuilder
                    .from(this)
                    .setType("text/plain")
                    .setChooserTitle("Share with....")
                    .setText(edit_text_1.text.toString())
                    .startChooser()
            }
        }
        return true
    }
}

