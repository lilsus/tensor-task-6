package ru.tensor

data class Employee(
    val id: Long,
    val fullName: String,
    val photoURL: String,
    val department: String,
    var isLiked: Boolean = false
) {
    companion object {
        fun getMockEmployees() = listOf(
            Employee(1, "Иван Иванов", "https://cdn.icon-icons.com/icons2/582/PNG/512/man-2_icon-icons.com_55041.png", "1", true),
            Employee(2, "Вася Пупкин", "https://cdn.icon-icons.com/icons2/582/PNG/512/worker_icon-icons.com_55029.png", "2"),
            Employee(3, "Илья Иванов", "https://cdn.icon-icons.com/icons2/582/PNG/512/spy_icon-icons.com_55034.png", "3")
        )
    }
}