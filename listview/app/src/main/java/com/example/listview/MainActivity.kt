package com.example.listview

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var lv = findViewById<View>(R.id.listview) as ListView
        var lAdapter = MyListAdapter(this)
        lv.adapter = lAdapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    inner class MyListAdapter(var context: Context): BaseAdapter(){
        var posterID = arrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
        override fun getCount(): Int {
            TODO("Not yet implemented")
        }

        override fun getItem(position: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(position: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var imageview = findViewById<View>(R.id.list_item_view)
            var textview = findViewById<View>(R.id.textView)
            return
        }
    }
}