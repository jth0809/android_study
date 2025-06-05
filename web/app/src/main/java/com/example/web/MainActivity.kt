package com.example.web

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var button2: Button
    lateinit var baselayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button2 = findViewById(R.id.btn2)
        baselayout = findViewById(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mf = menuInflater
        mf.inflate(R.menu.menu1,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> {
                baselayout.setBackgroundColor(Color.RED)
                return true
            }
            R.id.item2 -> {
                baselayout.setBackgroundColor(Color.BLUE)
                return true
            }
            R.id.item3 -> {
                baselayout.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.item5 -> {
                button2.rotation = 45f
                return true
            }
            R.id.item6 -> {
                button2.scaleX = 2f
                return true
            }
        }
        return false
    }
}
