package com.employeeDashboard.config

import com.employeeDashboard.Employee
import com.employeeDashboard.Priority
import com.employeeDashboard.Task
import com.employeeDashboard.Title
import com.employeeDashboard.repository.RoleRepository
import com.employeeDashboard.repository.TaskRepository
import com.employeeDashboard.service.interfaces.EmployeeServiceInterface
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty("insertDataAuto")
internal class PostRunning(val employeeServiceInterface: EmployeeServiceInterface,
                           val taskRepository: TaskRepository,
                           val roleRepository: RoleRepository) : CommandLineRunner {


    @Throws(Exception::class)
    override fun run(vararg args: String) {

        // ROLES
//        Role admin = new Role("ADMIN");
//        Role user = new Role("USER");
//        roleRepository.save(admin);
//        roleRepository.save(user);

        // TASKS
        val task1 = Task("Task1", "Descriptoin1", Priority.LOW)
        val task2 = Task("Task2", "Descriptoin2", Priority.NORMAL)
        val task3 = Task("Task3", "Descriptoin3", Priority.HIGH)
        taskRepository.save(task1)
        taskRepository.save(task2)
        taskRepository.save(task3)

        // EMPLOYEES
        val employee1 = Employee("username1", "firstname1", "lastname1", "password1", 1000, Title.DEVELOPER)
        employeeServiceInterface.addNewEmployee(employee1)
        val employee2 = Employee("username2", "firstname2", "lastname2", "password2", 2000, Title.DEVELOPER)
        employeeServiceInterface.addNewEmployee(employee2)
        val employee3 = Employee("username3", "firstname3", "lastname3", "password3", 3000, Title.HR)
        employeeServiceInterface.addNewEmployee(employee3)
        val employee4 = Employee("username4", "firstname4", "lastname4", "password4", 4000, Title.MANAGER)
        employeeServiceInterface.addNewEmployee(employee4)
        val employee5 = Employee("username5", "firstname5", "lastname5", "password5", 5000, Title.DEVELOPER)
        employeeServiceInterface.addNewEmployee(employee5)
    }
}