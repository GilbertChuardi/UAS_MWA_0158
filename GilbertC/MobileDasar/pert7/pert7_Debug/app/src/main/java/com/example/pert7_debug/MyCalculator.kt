package com.example.pert7_debug

class MyCalculator {
    enum class Operator { Tambah, Kurang, Kali, Bagi };
    fun tambah(operan1: Int, operan2: Int) = operan1 + operan2
    fun kurang(operan1: Int, operan2: Int) = operan1 - operan2
    fun bagi(operan1: Int, operan2: Int) = operan1 / operan2
    fun kali(operan1: Int, operan2: Int) = operan1 * operan2
}
