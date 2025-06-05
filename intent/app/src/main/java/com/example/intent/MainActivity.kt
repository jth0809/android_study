package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var finishbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        title = "투표"
        var voteCount = IntArray(9)
        var image = arrayOfNulls<ImageView>(9)
        var imageId = arrayOf(R.id.imageView,R.id.imageView2,R.id.imageView3,R.id.imageView7,R.id.imageView8,R.id.imageView9,R.id.imageView10,R.id.imageView11,R.id.imageView12)
        var imgName = arrayOf("별1","별2","별3","시계","저장","전화","마이크1","마이크2","마이크3")
        for(i in imageId.indices){
            image[i] = findViewById(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext,imgName[i] + ": 총 " + voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }
        finishbtn = findViewById(R.id.finishbtn)
        finishbtn.setOnClickListener {
            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName",imgName)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}