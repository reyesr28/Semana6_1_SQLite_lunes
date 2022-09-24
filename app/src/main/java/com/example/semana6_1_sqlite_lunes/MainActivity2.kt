package com.example.semana6_1_sqlite_lunes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    lateinit var dbHelper: OpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        getAllUser()
    }

    fun getAllUser(){
        dbHelper= OpenHelper(this)
        var data=dbHelper.leerData()

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerUsers)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext)
        recyclerView.adapter=Adapter(data)

    }


}











