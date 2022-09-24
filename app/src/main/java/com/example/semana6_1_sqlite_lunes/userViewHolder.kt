package com.example.semana6_1_sqlite_lunes

import Beans.Usuarios
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class userViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val userId=view.findViewById<TextView>(R.id.tvId)
    val userNom=view.findViewById<TextView>(R.id.tvNombre)
    val userEdad=view.findViewById<TextView>(R.id.tvEdad)
    val userCorreo=view.findViewById<TextView>(R.id.tvCorreo)

    fun render(userModel: Usuarios){
        userId.text=userModel.cod.toString()
        userNom.text=userModel.nombre
        userEdad.text=userModel.edad.toString()
        userCorreo.text=userModel.mail
    }
}
