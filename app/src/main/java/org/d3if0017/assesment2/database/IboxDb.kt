package org.d3if0017.assesment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0017.asessment2.database.IboxDao
import org.d3if0017.assesment2.model.Ibox

@Database(entities = [Ibox::class], version = 3, exportSchema = false)
abstract class IboxDb : RoomDatabase() {
    abstract val dao: IboxDao

    companion object {
        @Volatile
        private var INSTANCE: IboxDb? = null

        fun getInstance(context: Context): IboxDb{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        IboxDb::class.java,
                        "ibox3.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}