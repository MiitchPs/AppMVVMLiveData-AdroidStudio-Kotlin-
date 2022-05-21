package com.example.appmvvmlivedata.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmvvmlivedata.Model.EquipoProvider
import com.example.appmvvmlivedata.Model.Equipo

class EquipoViewModel : ViewModel() {

    val modelEquipo = MutableLiveData<Equipo>()

    fun EquipoRandom(){
        val EquipoActual = EquipoProvider.random()
        modelEquipo.postValue(EquipoActual)
    }

}