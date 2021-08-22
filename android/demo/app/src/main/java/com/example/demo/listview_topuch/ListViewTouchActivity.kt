package com.example.demo.listview_topuch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import com.example.demo.R

class ListViewTouchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_touch)
        val listview = findViewById<ListTouchView>(R.id.listview)
        val adapter = object : ArrayAdapter<String>(this,0) {

            override fun getCount(): Int {
                return 100
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                return TextView(this@ListViewTouchActivity).also{
                    it.setText("$position")
                }
            }
        }
        listview.adapter = adapter

    }
}