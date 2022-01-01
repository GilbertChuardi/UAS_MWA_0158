package com.example.pert14

import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var MyAdapter : MyRecycleViewAdapter
    private var MyStock : MutableList<Barang> = mutableListOf(
        Barang("Gula"),
        Barang("Garam"),
        Barang("Tea",false),
        Barang("Merica")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyAdapter = MyRecycleViewAdapter(MyStock)
        MyRecycleView.adapter = MyAdapter
        MyRecycleView.layoutManager = LinearLayoutManager(this)

        btn1.setOnClickListener {
            var BuilderDialog = AlertDialog.Builder(this)
            var inflaterDialog = layoutInflater.inflate(R.layout.dialog_add_barang,null)
            BuilderDialog.setView(inflaterDialog)
            BuilderDialog.setPositiveButton("ADD"){ dialogInterface: DialogInterface, i: Int ->
                var NamaBarangBaru = inflaterDialog.findViewById<EditText>(R.id.InputNamaBarang)
                var StatusBarangBaru = inflaterDialog.findViewById<Switch>(R.id.InputStatus)
                MyStock.add(Barang(NamaBarangBaru.text.toString(),StatusBarangBaru.isChecked))
                MyAdapter.notifyItemInserted(MyAdapter.itemCount)
            }
            BuilderDialog.create().show()
        }

    }
}