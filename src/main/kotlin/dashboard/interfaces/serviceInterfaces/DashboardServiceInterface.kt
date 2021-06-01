package dashboard.interfaces.serviceInterfaces

import dashboard.models.jpa.EmployeeDto

interface DashboardServiceInterface {
    fun createAccount(employeeDto: EmployeeDto)
}