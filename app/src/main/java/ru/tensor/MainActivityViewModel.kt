package ru.tensor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val employees = MutableLiveData(Employee.getMockEmployees())

    fun addRandomEmployee() {
        employees.value = employees.value?.toMutableList()?.apply {
            add(Employee.getMockEmployees().random())
        }
    }

    fun deleteEmployee(employee: Employee) {
        employees.value = employees.value?.toMutableList()?.apply {
            remove(employee)
        }
    }
}