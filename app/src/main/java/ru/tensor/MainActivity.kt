package ru.tensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tensor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    lateinit var employeesAdapter: EmployeesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        employeesAdapter = EmployeesAdapter(viewModel::deleteEmployee)
        binding.recyclerView.adapter = employeesAdapter

        binding.recyclerView.apply {
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            addItemDecoration(DividerItemDecoration(context, LinearLayout.HORIZONTAL))
        }

        viewModel.employees.observe(this) {
            employeesAdapter.reload(it)
        }

        binding.fab.setOnClickListener {
            viewModel.addRandomEmployee()
        }

        setContentView(binding.root)
    }
}