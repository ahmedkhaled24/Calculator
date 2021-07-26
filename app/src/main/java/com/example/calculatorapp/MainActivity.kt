package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    var isNewOpe = true

    fun buNumberShow(view: View) {
        if(isNewOpe){
            tvZeroStart.text = ""
        }
        isNewOpe=false

        var tvNumber = tvZeroStart.text.toString()
        val buSelect = view as Button

        when(buSelect.id){
            idAC.id -> {tvNumber=""}
            idTopEight.id -> {tvNumber+="-"}
            id9.id -> {tvNumber+="9"}
            id8.id -> {tvNumber+="8"}
            id7.id -> {tvNumber+="7"}
            id6.id -> {tvNumber+="6"}
            id5.id -> {tvNumber+="5"}
            id4.id -> {tvNumber+="4"}
            id3.id -> {tvNumber+="3"}
            id2.id -> {tvNumber+="2"}
            id1.id -> {tvNumber+="1"}
            id0.id -> {tvNumber+="0"}
            idDot.id -> {tvNumber+="."}
        }

        tvZeroStart.setTextSize(82f)
        tvZeroStart.text = tvNumber

    }

    var oldNumber = ""
    var op = "+"
    fun buEvent(view: View) {
        oldNumber = tvZeroStart.text.toString()
        isNewOpe = true
        val buSelect = view as Button
        when(buSelect.id){
            idDivide.id -> {op = " / "}
            idX.id -> {op = " x "}
            idPlus.id -> {op = " + "}
            idMainas.id -> {op = " - "}
        }
        tvZeroStart.text= op
        tvZeroStart.setTextSize(32f)
    }

    fun buEqual(view: View) {
        val newNumber = tvZeroStart.text.toString()
        var finalNumber:Double? = null
        when(op){
            " / "->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }

            " x "->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }

            " + "->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }

            " - "->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }

        tvZeroStart.text = finalNumber.toString()
        isNewOpe = true
    }
}
