package com.example.pert11

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.EditText
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class MyPickerTime : DialogFragment(),
    TimePickerDialog.OnTimeSetListener
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var jam = c.get(Calendar.HOUR_OF_DAY)
        var menit = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity,this,jam, menit, true)
    }
    override fun onTimeSet(p0: TimePicker?, jam: Int, menit: Int) {
        var jam = LocalTime.of(jam,menit)
        var tv= activity?.findViewById<EditText>(R.id.inputUmur)
        tv?.setText("$jam")
    }
}