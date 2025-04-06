package com.example.calc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    private lateinit var view: TextView
    private var oprationbtns: Array<Int> = arrayOf(R.id.button13,R.id.button14,R.id.button15,R.id.button16)
    private var numbtns: Array<Int> = arrayOf(R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10)
    private val buttons = mutableListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.editTextText)
        text2 = findViewById(R.id.editTextText2)
        view = findViewById(R.id.textView2)

        for (id in oprationbtns) {
            val button: Button = findViewById(id)
            buttons.add(button)
            showButton(button)
        }

        for (i in numbtns){
            val button: Button = findViewById(i)
            buttons.add(button)
            button.setOnClickListener {
                if (text1.isFocused){
                    text1.setText(text1.text.toString() + button.text.toString())
                }else if (text2.isFocused){
                    text2.setText(text2.text.toString() + button.text.toString())
                }else{
                    Toast.makeText(applicationContext,"먼저 텍스트 칸을 선택하세요",Toast.LENGTH_SHORT).show()
                }
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showButton(btn :Button){

        btn.setOnClickListener {
            val n1: Double = text1.text.toString().toDouble()
            val n2: Double = text2.text.toString().toDouble()
            var result: Double? = null

            when (btn.id) {
                R.id.button13 -> result = n1 + n2
                R.id.button14 -> result = n1 - n2
                R.id.button15 -> result = n1 * n2
                R.id.button16 -> {
                    if (n2 != 0.0) {
                        result = n1 / n2
                    } else {
                        Toast.makeText(applicationContext, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            if (result != null) {
                view.text = "계산결과 : $result"
            }
        }
    }
}