package com.example.sports

import android.content.Context
import android.content.Intent
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.sports.extensions.Toast_msg
import kotlinx.android.synthetic.main.sport_name.view.*

class adapter(val context:Context, val sport:ArrayList<sport>, val showdeleteitem:(Boolean)->Unit):RecyclerView.Adapter<adapter.viewitem> (){

//    var currentseletedIndex=-1
    var selectedlist= mutableListOf<Int>()
    inner class viewitem(var item:View):RecyclerView.ViewHolder(item){

        var current_position:Int?=null
        var current_sport:sport?=null


        init{
            item.setOnClickListener{
                context.Toast_msg("you've have selected $current_sport")

            }
            item.img.setOnClickListener {
                var msg:String="you have choose the + $current_sport"
                val intent=Intent()
                intent.action=Intent.ACTION_SEND
                intent.type="text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,msg)
                context.startActivity(Intent.createChooser(intent,"choose your app to share the sport"))
            }
        }
        fun markselectedItem(index:Int): Boolean {
            for(item in sport){
                item.isseleted=false
            }
            if(!selectedlist.contains(index)){
                selectedlist.add(index)
            }
            selectedlist.forEach{
                sport[it].isseleted=true
            }
            showdeleteitem(true)
            notifyDataSetChanged()
            return true
        }

        fun deselectitem(index: Int){
            if(selectedlist.contains(index)){
                selectedlist.remove(index)
                sport[index].isseleted=false
                notifyDataSetChanged()
                showdeleteitem(selectedlist.isNotEmpty())
            }
        }


        fun setData(sport: sport?,pos:Int){

            item.textView2.text=sport!!.sport
            this.current_position=pos
            this.current_sport=sport
            itemView.linear.setOnLongClickListener{
                markselectedItem(pos)

            }
            itemView.linear.setOnClickListener (){

                deselectitem(pos)

            }
            if(sport.isseleted==true){
                itemView.iv_check_box.visibility=View.VISIBLE
            }
            else{
                itemView.iv_check_box.visibility=View.GONE
            }

        }

    }

    fun deleteseleteditem(){
        if(selectedlist.isNotEmpty()){
            sport.removeAll {item -> item.isseleted==true }
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewitem {
        var view=LayoutInflater.from(context).inflate(R.layout.sport_name,parent,false)
        return viewitem(view)
    }

    override fun onBindViewHolder(holder: viewitem, position: Int) {
          var spt=sport[position]

        holder.setData(spt,position)
    }

    override fun getItemCount(): Int {
        return sport.size
    }



}