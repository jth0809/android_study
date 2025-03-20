package com.example.myapplication

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
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    private lateinit var view: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        view = findViewById(R.id.view1)
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
            var n1:Int = Integer.parseInt(text1.text.toString())
            var n2:Int = Integer.parseInt(text2.text.toString())
            var result:Int? = null
            if (btn.text == "더하기") {
                result = n1 + n2
                view.text = "계산결과 : "+result.toString()
            }else if(btn.text == "빼기"){
                result = n1 - n2
                view.text = "계산결과 : "+result.toString()
            }else if(btn.text == "곱하기"){
                result = n1 * n2
                view.text = "계산결과 : "+result.toString()
            }else if(btn.text == "나누기"){
                if (n1 != 0 || n2 != 0)
                    view.text = "계산결과 : "+(n1 / n2).toString()
                else
                    Toast.makeText(applicationContext, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
            }else if(btn.text == "나머지"){
                if (n1 != 0 || n2 != 0)
                    view.text = "계산결과 : "+(n1 % n2).toString()
                else
                    Toast.makeText(applicationContext, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}