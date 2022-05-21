package com.example.appmvvmlivedata.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.appmvvmlivedata.AddEquipo
import com.example.appmvvmlivedata.Data.EquiposDb
import com.example.appmvvmlivedata.Model.EquipoProvider
import com.example.appmvvmlivedata.R
import com.example.appmvvmlivedata.ViewModel.EquipoViewModel
import com.example.appmvvmlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val equipoViewModel: EquipoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val database = EquiposDb.getDatabase(this)

        database.equipoDao().getAll().observe(this, Observer {
            EquipoProvider.setEquipos(it)
        })

        equipoViewModel.modelEquipo.observe(this, Observer { equipoActual ->
            binding.tvEquipo.text = equipoActual.Name
            binding.tvCantidad.text = equipoActual.ChampionsLeague
        })

        binding.container.setOnClickListener { equipoViewModel.EquipoRandom() }


        binding.btnAddEquipo.setOnClickListener { addEquipo() }

    }

    private fun addEquipo() {
        val intent = Intent(this, AddEquipo::class.java)
        startActivity(intent)
    }
}