    package com.example.sports

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {

    var mainmenu: Menu? =null
        private lateinit var myadapter:adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var sports_list=ArrayList<sport>()
        sports_list.add(sport("football"))
        sports_list.add(sport("batmintton"))
        sports_list.add(sport("cricket"))
        sports_list.add(sport("vollyball"))
        sports_list.add(sport("basketball"))
        sports_list.add(sport("haki"))
        sports_list.add(sport("tennis"))
        sports_list.add(sport("kho-kho"))
        sports_list.add(sport("running"))
        sports_list.add(sport("chess"))
        sports_list.add(sport("table tennis"))
        sports_list.add(sport("swimming"))

        setContentView(R.layout.activity_main)

        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recycleView.layoutManager=layoutManager
      myadapter=adapter(this,sports_list){show -> showhiddendelete(show)}
        recycleView.adapter=myadapter
    }

    private fun showhiddendelete(show: Boolean) {

        mainmenu?.findItem(R.id.menu_delete)?.isVisible=show

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        mainmenu=menu
        showhiddendelete(false)
        menuInflater.inflate(R.menu.main_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.menu_delete->{

                    if(::myadapter.isInitialized){
                        myadapter.deleteseleteditem()
                        showhiddendelete(false)
                    }

                }
            }
            return super.onOptionsItemSelected(item)
        }
}