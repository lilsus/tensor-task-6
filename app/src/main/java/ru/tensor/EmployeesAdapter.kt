package ru.tensor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.tensor.databinding.EmployeesListItemBinding

class EmployeesAdapter(private val deleteAction: (Employee) -> (Unit)) : RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>() {
    private val employees = mutableListOf<Employee>()

    class EmployeesViewHolder(val binding: EmployeesListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        val binding = EmployeesListItemBinding.inflate(LayoutInflater.from(parent.context))
        return EmployeesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        val employee = employees[position]
        with(holder) {
            binding.fullName.text = employee.fullName
            binding.department.text = employee.department

            Glide.with(binding.photo.context)
                .load(employee.photoURL)
                .centerCrop()
                .into(binding.photo)

            binding.likeButton.setOnClickListener {
                employee.isLiked = !employee.isLiked

                val likeImage = if (employee.isLiked)
                    R.drawable.like_button_on
                else
                    R.drawable.like_button
                binding.likeButton.setImageResource(likeImage)
            }

            binding.deleteButton.setOnClickListener {
                deleteAction(employee)
            }
        }
    }

    override fun getItemCount(): Int = employees.size

    fun reload(data: List<Employee>) {
        val employeesDiffUtilCallback = EmployeesDiffUtilCallback(employees, data)
        val difference = DiffUtil.calculateDiff(employeesDiffUtilCallback)

        employees.clear()
        employees.addAll(data)

        difference.dispatchUpdatesTo(this)
    }
}