package com.example.pert11

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mengatur tombol aksi melalui koding
        inputUmur.imeOptions = EditorInfo.IME_ACTION_GO
        inputUmur.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEND){
                Toast.makeText(this,inputUmur.text.toString(),Toast.LENGTH_SHORT).show()
            }
            return@setOnEditorActionListener true
        }
        var pilihan = arrayOf("TIME","DATE")
        var adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            pilihan)
        mySpinner1.adapter = adapter

    }

    fun getUmur(view: View) {
        var umur = inputUmur.text.toString().toInt()
        inputUmur.setText("${umur+10}")
    }

    fun getAlertDialog(view: View) {
        var dialog = AlertDialog.Builder(this)
            .setTitle("Konfirmasi Email")
            .setMessage("Anda perlu konfirmasi email untuk melanjutkan" +
                    "proses daftar")
            .setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->
                //Apa yang harus dikerjakan ketika klik OK
                Toast.makeText(this,"Konfirmasi Berhasil", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                this.finish()
            })
            .setNeutralButton("Postpone", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Ingatkan dalam 5 menit", Toast.LENGTH_SHORT).show()
            })
        dialog.show()
    }

    fun getPicker(view: View) {
        if(mySpinner1.selectedItem.toString().equals("TIME",true)){
            var timePicker = MyPickerTime()
            timePicker.show(supportFragmentManager,mySpinner1.selectedItem.toString())
        }
        else{
            var datePicker = MyPickerDate()
            datePicker.show(supportFragmentManager,mySpinner1.selectedItem.toString())
        }
    }

    fun getCustomDialog(view: View) {
        var MyLayout = layoutInflater.inflate(R.layout.my_custom_dialog,null)
        val myDialogBuilder = AlertDialog.Builder(this).apply {
            setView(MyLayout)
            setTitle("Login")
        }
        var myDialog = myDialogBuilder.create()
        var ID = MyLayout.findViewById<EditText>(R.id.UserID)
        var Pass = MyLayout.findViewById<EditText>(R.id.UserPass)
        var BtnLogin = MyLayout.findViewById<Button>(R.id.login)
        BtnLogin.setOnClickListener {
            if(ID.text.toString().equals("123") and Pass.text.toString().equals("123"))
                Toast.makeText(this,"Login Sukses",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Login Gagal",Toast.LENGTH_SHORT).show()
            myDialog.cancel()
        }

        myDialog.show()
    }

}