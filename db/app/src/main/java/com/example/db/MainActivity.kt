package com.example.db

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    lateinit var result: TextView
    lateinit var nameEdit: EditText
    lateinit var numEdit: EditText
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var db = Room.databaseBuilder(this, AppDatabase::class.java,"app_database").build()
        result = findViewById(R.id.textresult)
        nameEdit = findViewById(R.id.editname)
        numEdit = findViewById(R.id.editnum)
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        var dao = db.groupDBDao()
        btn2.setOnClickListener { unit ->
            dao.insert(GroupDB(nameEdit.text.toString(),numEdit.text.toString().toInt()))
            Toast.makeText(this,"입력되었습니다.",Toast.LENGTH_SHORT).show()
        }
        btn3.setOnClickListener { unit ->
            var data = dao.getall()

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}