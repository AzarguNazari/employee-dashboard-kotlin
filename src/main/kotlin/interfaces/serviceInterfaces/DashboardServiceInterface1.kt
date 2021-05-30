package interfaces.serviceInterfaces

import models.jpa.EmployeeDto

interface DashboardServiceInterface {
    fun createAccount(employeeDto: EmployeeDto)
}