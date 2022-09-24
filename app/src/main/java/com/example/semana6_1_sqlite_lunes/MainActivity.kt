package com.example.semana6_1_sqlite_lunes

import Beans.Usuarios
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: OpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtNom:EditText=findViewById(R.id.txtNom)
        val txtEdad:EditText=findViewById(R.id.txtEdad)
        val txtCorreo:EditText=findViewById(R.id.txtCorreo)
        val txtId:EditText=findViewById(R.id.txtID)

        val btnGrabar:Button=findViewById(R.id.btnGrabar)
        val btnEliminar:Button=findViewById(R.id.btnEliminar)
        val btnEditar:Button=findViewById(R.id.btnEditar)

        val btnAcciones: Button =findViewById(R.id.btnAcciones)
        val btnListar: Button =findViewById(R.id.btnListar)

        val linear:LinearLayout=findViewById(R.id.linearAcciones)

        btnEliminar.setOnClickListener(){
            dbHelper= OpenHelper(this)

            dbHelper.deleteData(txtId.text.toString().toInt())
            txtId.text.clear()
            linear.visibility=View.INVISIBLE
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        btnEditar.setOnClickListener(){
            dbHelper= OpenHelper(this)
            val u=Usuarios(txtId.text.toString().toInt(),
                txtNom.text.toString(),
                txtEdad.text.toString().toInt(),
                txtCorreo.text.toString())

            dbHelper.editarUser(u)

            txtNom.text.clear()
            txtEdad.text.clear()
            txtCorreo.text.clear()
            txtId.text.clear()
            linear.visibility=View.INVISIBLE
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        btnGrabar.setOnClickListener(){
            dbHelper= OpenHelper(this)

            val u=Usuarios(txtNom.text.toString(),
            txtEdad.text.toString().toInt(),
            txtCorreo.text.toString())

            dbHelper.nuevoUser(u)

            txtNom.text.clear()
            txtEdad.text.clear()
            txtCorreo.text.clear()

        }

        btnAcciones.setOnClickListener(){
            if(linear.visibility==View.VISIBLE){
                linear.visibility=View.INVISIBLE
            }else{
                linear.visibility=View.VISIBLE
            }
        }

        btnListar.setOnClickListener(){
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }





}