package com.example.appmvvmlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Database
import com.example.appmvvmlivedata.Data.EquiposDb
import com.example.appmvvmlivedata.Model.Equipo
import com.example.appmvvmlivedata.databinding.ActivityAddEquipoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddEquipo : AppCompatActivity() {

    private lateinit var binding: ActivityAddEquipoBinding
    private lateinit var database: EquiposDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = EquiposDb.getDatabase(this)

        binding.btnAddEquipo.setOnClickListener { addEquipo()}
    }

    private fun addEquipo() {
        val Nombre = binding.txtEquipo.editText?.text.toString()
        val Cantidad = binding.txtCantidad.editText?.text.toString()

        val equipo:Equipo = Equipo( Name = Nombre, ChampionsLeague = Cantidad)

        CoroutineScope(Dispatchers.IO).launch {
            this@AddEquipo.finish()
        }
        database.equipoDao().addEquipo(equipo)

    }
}