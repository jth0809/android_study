package com.example.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

class ItemAdapter:RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    var ListData: MutableList<memo> = mutableListOf()

    inner class ViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val textView3: TextView = itemView.findViewById(R.id.textView3)

        fun setmemo(memo: memo){
            textView.text = memo.number
            textView2.text = memo.title
            val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale(memo.time))
        }

    }

    override fun getItemCount(): Int {
        return ListData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val itemText = ListData[position]
        ViewHolder
    }
}