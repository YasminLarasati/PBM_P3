package com.example.pbm_p3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Listener1 : AppCompatActivity(), View.OnClickListener {
    //deklarasi variabel Input Output --> komponen (TextView, EditText, Button, dsb)
    
    //Global variabel
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        //apapun yang di deklarasikan disini, hanya bisa digunakan disini
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listener)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        //hubungkan kompnen XML layout dengan variabel di file kotlin
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        
        //memasang event listener pada button
        //1. di dalam method onCreate
        btn1.setOnClickListener {
            //button di click
            //logic program --> menjalankan apa
            //Notifikasi (mirip dengan JOptionPane >> Android: Toast
            Toast.makeText(this, "Tombol 1 Sudah Di Klik", Toast.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {
            Toast.makeText(this, "Tombol 2 Sudah Di Klik", Toast.LENGTH_LONG).show()
        }

        //2. Menggunakan implements class View.OnClickListener
        //di dalam onCreate harus deklarasi setListener
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //safe operator (?) >> aksesnya menggunakan if/when
        when (v?.id){
            //isi variabel v ini adalah id. onClick >> id >> button
            R.id.btn3 -> {
                //menjalankan apa...
                Toast.makeText(this, "Tombol 3 Sudah Di Klik", Toast.LENGTH_LONG).show()
            }
            R.id.btn4 -> {
                Toast.makeText(this, "Tombol 4 Sudah Di Klik", Toast.LENGTH_LONG).show()
            }
        }
    }
}