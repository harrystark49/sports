package com.example.sports.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sports.R
import com.example.sports.sport
import kotlinx.android.synthetic.main.sec.view.*

class adapter1(val context: Context,val sports: List<sport>) :RecyclerView.Adapter<adapter1.viewItem1>(){
    inner class viewItem1(view1:View):RecyclerView.ViewHolder(view1){
        fun setData(a: sport, pos:Int) {
            itemView.textView.text=a.sport
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewItem1 {
        val view=LayoutInflater.from(context).inflate(R.layout.sec,parent,false)
        return viewItem1(view)
    }
    override fun onBindViewHolder(holder: viewItem1, position: Int) {
        val data=sports[position]
        val pos=position
        holder.setData(data,pos)
    }

    override fun getItemCount(): Int {
        return sports.size
    }
}