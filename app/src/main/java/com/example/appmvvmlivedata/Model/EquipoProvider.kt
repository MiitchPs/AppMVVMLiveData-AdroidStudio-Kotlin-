package com.example.appmvvmlivedata.Model

class EquipoProvider {

    companion object {

        fun random(): Equipo {
            if (equipos.size > 0){
                val position = (0..equipos.size-1).random()
                return equipos[position]

            }
            return Equipo(1, "Equipo de Ejemplo","10")
        }

        private var equipos = listOf<Equipo>()

        fun setEquipos(equipo:List<Equipo>){
            equipos = equipo


        }

    }
}