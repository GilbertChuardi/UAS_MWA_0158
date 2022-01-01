package com.example.pert7_debug


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var hitung: MyCalculator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hitung = MyCalculator()
    }
    //Jawaban nomor 1
    fun getOperand(tmpTextView: TextView) = tmpTextView.text.toString().toInt()

    fun compute(operator: MyCalculator.Operator) {
        var operand1 = getOperand(Angka1)
        var operand2 = getOperand(Angka2)
        when (operator) {
            MyCalculator.Operator.Tambah ->
                textHasil.text = "${hitung.tambah(operand1, operand2)}"
            MyCalculator.Operator.Kurang ->
                textHasil.text = "${hitung.kurang(operand1, operand2)}"
            MyCalculator.Operator.Kali ->
                textHasil.text = "${hitung.kali(operand1, operand2)}"
            MyCalculator.Operator.Bagi ->
                textHasil.text = "${hitung.bagi(operand1, operand2)}"
        }
    }

    fun add(view: View) {
        compute(MyCalculator.Operator.Tambah)
    }

    fun sub(view: View) {
        compute(MyCalculator.Operator.Kurang)
    }

    fun div(view: View) {
        compute(MyCalculator.Operator.Bagi)
    }

    fun mul(view: View) {
        compute(MyCalculator.Operator.Kali)
    }
}

