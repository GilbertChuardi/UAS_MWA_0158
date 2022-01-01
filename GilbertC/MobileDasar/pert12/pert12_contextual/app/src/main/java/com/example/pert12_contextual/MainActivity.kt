package com.example.pert12_contextual

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
    var actionMode: ActionMode? = null
    var actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
            var inflater = p0?.menuInflater
            inflater?.inflate(R.menu.my_menu, p1)
            return true
        }

        override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
            when (p1?.itemId) {
                R.id.select_all -> {
                    edit_text_1.selectAll()
                    p0?.finish()
                }
                R.id.delete -> {
                    edit_text_1.setText("")
                    p0?.finish()
                }
                R.id.share -> {
                    ShareCompat.IntentBuilder
                        .from(this@MainActivity)
                        .setType("text/plain")
                        .setText(edit_text_1.text.toString())
                        .startChooser()
                    p0?.finish()
                }
            }
            return true
        }

        override fun onDestroyActionMode(p0: ActionMode?) {
            actionMode = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_text_1.setOnLongClickListener {
            when (actionMode) {
                null -> {
                    actionMode = this.startActionMode(actionModeCallback)
                    true
                }
                else -> false
            }
        }
    }

    fun myToast(text: String, timw: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, text, timw).show()
    }


}

