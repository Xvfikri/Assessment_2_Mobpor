package org.d3if0017.asessment2.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0017.assesment2.model.Ibox

@Dao
interface IboxDao {
    @Insert
    suspend fun insert(ibox: Ibox)

    @Update
    suspend fun update(ibox: Ibox)

    @Query("SELECT * FROM ibox ORDER BY namePembeli DESC")
    fun getVehicle(): Flow<List<Ibox>>

    @Query("SELECT * FROM ibox WHERE id = :id")
    suspend fun getVehicleById(id: Long): Ibox

    @Query("DELETE FROM ibox WHERE id = :id")
    suspend fun deleteById(id: Long)
}