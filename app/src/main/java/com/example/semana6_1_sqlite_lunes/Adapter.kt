package com.example.semana6_1_sqlite_lunes

import Beans.Usuarios
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val userList:List<Usuarios>):RecyclerView.Adapter<userViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return userViewHolder(layoutInflater.inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val item=userList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =userList.size
}