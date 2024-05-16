package com.example.pbm_p3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class BMI_Activity : AppCompatActivity() {
    //deklarasi dan relasi id layout (val)
    //primitif
    //obj = String, Array, dst

    lateinit var edBerat: EditText
    lateinit var edTinggi : EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edBerat = findViewById(R.id.numberWeight)
        edTinggi = findViewById(R.id.numberHeight)
        btn = findViewById(R.id.btnCalculate)




        //set event listener
        btn.setOnClickListener {
            //convert kw float/double
            val isiBerat = edBerat.text.toString()
            val isiTinggi = edTinggi.text.toString()
            val result: TextView = findViewById(R.id.result)

            //validasi jika isian kosong
            when {
                isiBerat.isNullOrEmpty() ->{
                    Toast.makeText(this, "Harus Diisi", Toast.LENGTH_LONG).show()
                }
                isiTinggi.isNullOrEmpty() ->{
                    Toast.makeText(this, "Harus Diisi", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val hitungMI = isiBerat.toFloat()/((isiTinggi.toFloat()/100)*(isiTinggi.toFloat()/100))
                    result.text = hitungMI.toString()
                }
            }

        }
    }

    private fun resultBMI(bmi : Float) {
        val result: TextView = findViewById(R.id.result)
        result.text = bmi.toString()
        when {
            bmi < 18.5 -> {
                Toast.makeText(this, "Underweight", Toast.LENGTH_LONG).show()
            }
            bmi in 18.5 .. 24.9 -> {
                Toast.makeText(this, "Healthy", Toast.LENGTH_LONG).show()
            }
        }
    }
}