package dashboard.interfaces.serviceInterfaces

import dashboard.models.dto.EmployeeDto

interface DashboardServiceInterface {
    fun createAccount(employeeDto: EmployeeDto)
}