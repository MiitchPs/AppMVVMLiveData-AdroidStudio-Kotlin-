package com.example.appmvvmlivedata.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appmvvmlivedata.Model.Equipo
import java.security.AccessControlContext


@Database(
    entities = [Equipo::class],
    version =  1

)
abstract class EquiposDb : RoomDatabase() {

    abstract fun equipoDao():EquipoDAO

    companion object{
        @Volatile
        private var INSTANCE:EquiposDb? = null

        fun getDatabase(context:Context):EquiposDb{
            val instance = INSTANCE
            if (instance != null){
                return instance
            }

            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    EquiposDb::class.java,
                    "EquiposDb"
                ).build()
                INSTANCE = newInstance
                return newInstance
            }
        }
    }

}