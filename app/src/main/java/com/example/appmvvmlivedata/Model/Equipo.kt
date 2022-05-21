package com.example.appmvvmlivedata.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Equipos")
data class Equipo (
    @PrimaryKey(autoGenerate = true)
    val EquipoId:Int = 0,
    val Name:String,
    val ChampionsLeague:String) : Serializable
