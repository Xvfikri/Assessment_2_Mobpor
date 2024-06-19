package org.d3if0017.assesment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ibox")
data class Ibox(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val namePembeli: String,
    val nomorTelephone: String,
    val typePruduct: String,
)