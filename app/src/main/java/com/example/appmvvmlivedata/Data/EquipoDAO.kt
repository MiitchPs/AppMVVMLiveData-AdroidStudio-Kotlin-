package com.example.appmvvmlivedata.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appmvvmlivedata.Model.Equipo

@Dao
interface EquipoDAO {

    @Query("SELECT * FROM Equipos")
    fun getAll(): LiveData<List<Equipo>>

    @Insert
    fun addEquipo(vararg equipo:Equipo)

}