package com.example.ricardo.cursokotlinlevel2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculadora.*

class MainActivity : AppCompatActivity() {

    var value:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        btnmas.setOnClickListener(this::operar)// se realiza asi para llamar una funcion
        btnsub.setOnClickListener(this::operar)
        btndiv.setOnClickListener(this::operar)
        btnmul.setOnClickListener(this::operar)

        value = savedInstanceState?.getString("value") ?: "00"
        tvRes.text = value
    }

    override fun onSaveInstanceState(outState: Bundle) { // permite guardar estados al momento de girar pantalla
        outState.putString("Value", value)
        super.onSaveInstanceState(outState)
    }

    fun operar(view:View){
        val n1 = "0 ${num1.text}".toInt()
        val n2 = "0 ${num2.text}".toInt()

       value = when(view.id){
            R.id.btnmas -> n1 + n2
            R.id.btnsub -> n1 - n2
            R.id.btnmul -> n1 * n2
           else -> n1 / n2
        }.toString()

        tvRes.text = "$value"



    }
}
