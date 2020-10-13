package com.employeeDashboard.service


import com.employeeDashboard.Employee
import com.employeeDashboard.repository.EmployeeRepository
import com.employeeDashboard.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(val employeeRepository: EmployeeRepository,
                      val taskRepository: TaskRepository) : DAO<Employee> {
    override fun save(t: Employee) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, t: Employee) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Employee> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Employee {
        TODO("Not yet implemented")
    }

}