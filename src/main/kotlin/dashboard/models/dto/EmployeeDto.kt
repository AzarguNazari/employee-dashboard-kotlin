package dashboard.models.dto

data class EmployeeDto(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password1: String,
    val password2: String,
    val salary: Int,
    val position: String)