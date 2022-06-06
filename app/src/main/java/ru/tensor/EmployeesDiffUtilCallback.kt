package ru.tensor

import androidx.recyclerview.widget.DiffUtil

class EmployeesDiffUtilCallback(
    private val oldList: List<Employee>,
    private val newList: List<Employee>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = oldList[oldItemPosition]
        val newEmployee= newList[newItemPosition]
        return oldEmployee.id == newEmployee.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = oldList[oldItemPosition]
        val newEmployee= newList[newItemPosition]
        return oldEmployee == newEmployee
    }
}