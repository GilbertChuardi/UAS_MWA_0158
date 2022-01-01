package com.example.pert11

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.util.*

class MyPickerDate : DialogFragment(),
        DatePickerDialog.OnDateSetListener
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var tahun = c.get(Calendar.YEAR)
        var bulan = c.get(Calendar.MONTH)
        var hari = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity!!,this,tahun,bulan,hari)
    }

    override fun onDateSet(p0: DatePicker?, tahun: Int, bulan: Int, hari: Int) {
        var tanggal = LocalDate.of(tahun,bulan+1,hari)
        var tv= activity?.findViewById<EditText>(R.id.inputUmur)
        tv?.setText("$tanggal")

    }
}