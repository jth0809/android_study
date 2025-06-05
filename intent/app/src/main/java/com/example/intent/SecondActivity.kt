package com.example.intent

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "투표결과"
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName.size)
        var tvID = arrayOf(R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5,R.id.textView6,R.id.textView7,R.id.textView8,R.id.textView9)
        var rbarID = arrayOf(R.id.ratingBar1,R.id.ratingBar2,R.id.ratingBar3,R.id.ratingBar4,R.id.ratingBar5,R.id.ratingBar6,R.id.ratingBar7,R.id.ratingBar8,R.id.ratingBar9)
        for (i in voteResult!!.indices){
            tv[i] = findViewById(tvID[i])
            rbar[i] = findViewById(rbarID[i])
        }
        for (i in voteResult.indices){
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.rating = voteResult[i].toFloat()
        }
        var btnReturn = findViewById<Button>(R.id.backbtn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}