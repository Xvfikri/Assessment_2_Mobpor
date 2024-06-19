package org.d3if0017.assesment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0017.asessment2.database.IboxDao
import org.d3if0017.assesment2.model.Ibox

class MainViewModel(dao: IboxDao) : ViewModel() {
    val data: StateFlow<List<Ibox>> = dao.getVehicle().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}