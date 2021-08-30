package com.example.sports.extensions

import android.app.Activity
import android.content.Context
import java.time.Duration

fun Context.Toast_msg(msg:String,length:Int= android.widget.Toast.LENGTH_SHORT){
    android.widget.Toast.makeText(this,msg,length).show()
}