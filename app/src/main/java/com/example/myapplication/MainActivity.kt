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
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    private lateinit var view: TextView
    private val buttons = mutableListOf<Button>()
    private val buttonIds = arrayOf(
        R.id.button1,
        R.id.button2,
        R.id.button3,
        R.id.button4,
        R.id.button5,
        R.id.button6
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        for (id in buttonIds) {
            val button: Button = findViewById(id)
            buttons.add(button)
            showButton(button)
        }

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        view = findViewById(R.id.view1)
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
            var n1: Double = text1.text.toString().toDouble()
            var n2: Double = text2.text.toString().toDouble()
            var result: Double? = null

            when (btn.text) {
                "더하기" -> result = n1 + n2
                "빼기" -> result = n1 - n2
                "곱하기" -> result = n1 * n2
                "나누기" -> {
                    if (n2 != 0.0) {
                        result = n1 / n2
                    } else {
                        Toast.makeText(applicationContext, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                "나머지" -> {
                    if (n2 != 0.0) {
                        result = n1 % n2
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