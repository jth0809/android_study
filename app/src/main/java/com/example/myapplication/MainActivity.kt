package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private var btnArray : ArrayList<Button> = arrayListOf(button1,button2,button3,button4)
    private var btnNameArray : ArrayList<Int> = arrayListOf(R.id.button1,R.id.button2,R.id.button3,R.id.button4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var i :Int = 0
        btnArray.forEach { button ->
            button = findViewById(btnNameArray.get(i))
            i++
        }
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        showButton(button1)
        showButton(button2)
        showButton(button3)
        showButton(button4)
        title = "chap1.four.button"
        Toast.makeText(applicationContext,title,Toast.LENGTH_SHORT).show()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun showButton(btn :Button){
        btn.setOnClickListener {
            Toast.makeText(applicationContext, btn.text, Toast.LENGTH_SHORT).show()
        }
    }
}