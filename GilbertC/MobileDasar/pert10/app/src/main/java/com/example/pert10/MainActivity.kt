package com.example.pert10

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSubmit.setOnClickListener {
            getMyCheckBox()
        }
        onoff.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                MyRL.setBackgroundColor(Color.WHITE)
            else
                MyRL.setBackgroundColor(Color.BLACK)
        }

        val adapter = ArrayAdapter.createFromResource(this, R.array.spinner_item,
                android.R.layout.simple_spinner_dropdown_item)
        MySpinner.adapter = adapter
        MySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?,
                                        position: Int, id: Long) {
                if (adapterView != null) {
                    mySnackBar(adapterView.getItemAtPosition(position).toString())
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }
    }

    private fun getMyCheckBox() {
        var text = ""
        if (jelly_bean.isChecked) {
            text += jelly_bean.text.toString() + " "
        }
        if (kitkat.isChecked) {
            text += kitkat.text.toString() + " "
        }
        if (lolipop.isChecked) {
            text += lolipop.text.toString() + " "
        }

        Snackbar.make(parent_layout, "$text", Snackbar.LENGTH_INDEFINITE)
                .setAction("Done", View.OnClickListener {
                    jelly_bean.isChecked = false
                    kitkat.isChecked = false
                    lolipop.isChecked = false
                })
                .show()

    }

    fun setBGLayoutColor(view: View) {
        if (red.isChecked)
            parent_layout.setBackgroundColor(Color.RED)
        else if (green.isChecked)
            parent_layout.setBackgroundColor(Color.GREEN)
        else
            parent_layout.setBackgroundColor(Color.BLUE)
    }

    fun mySnackBar(text: String, time: Int = Snackbar.LENGTH_INDEFINITE) {
        Snackbar.make(parent_layout, text, time)
                .setAction("OK", View.OnClickListener {

                })
                .show()
    }

}