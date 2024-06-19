package org.d3if0017.assesment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0017.asessment2.database.IboxDao
import org.d3if0017.assesment2.model.Ibox

class DetailViewModel(private val dao: IboxDao) : ViewModel() {

    fun insert(namaPembeli: String, nomorTelephone: String, typeProduct: String){
        val ibox = Ibox(
            namePembeli = namaPembeli,
            nomorTelephone = nomorTelephone,
            typePruduct =  typeProduct,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(ibox)
        }
    }

    suspend fun getVehicle(id: Long): Ibox? {
        return dao.getVehicleById(id)
    }

    fun update(id: Long, namaPembeli: String, nomorTelephone: String, typeProduct: String){
        val ibox = Ibox(
            id = id,
            namePembeli = namaPembeli,
            nomorTelephone = nomorTelephone,
            typePruduct =  typeProduct,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(ibox)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}