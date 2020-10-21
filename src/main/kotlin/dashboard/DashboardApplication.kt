package dashboard

import dashboard.model.*
import dashboard.repository.EmployeeRepository
import dashboard.repository.RoleRepository
import dashboard.repository.TaskRepository
import dashboard.repository.UserRepository
import dashboard.service.interfaces.EmployeeServiceInterface
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DashboardApplication(val employeeRepository: EmployeeRepository,
						   val taskRepository: TaskRepository,
						   val roleRepository: RoleRepository,
val userRepository: UserRepository): ApplicationRunner{
	override fun run(args: ApplicationArguments?) {

//		// ROLES
//        val admin = Role(role ="ADMIN")
//        val user = Role(role = "USER")
//        roleRepository.save(admin);
//        roleRepository.save(user);
//
//		// TASKS
//		val task1 = Task(taskname = "Task1", description = "Descriptoin1", priority =  Priority.LOW)
//		val task2 = Task(taskname = "Task2", description = "Descriptoin2", priority =  Priority.NORMAL)
//		val task3 = Task(taskname = "Task3", description = "Descriptoin3", priority =  Priority.HIGH)
//		taskRepository.save(task1)
//		taskRepository.save(task2)
//		taskRepository.save(task3)
//		taskRepository.findAll().forEach(::println)
//
//
//
////		// EMPLOYEES
//		val employee1 = Employee(firstname =  "firstname1", lastname =  "lastname1",  salary = 1000, title =  Title.DEVELOPER)
//		employeeRepository.save(employee1)
//		val employee2 = Employee(firstname =  "firstname2", lastname =  "lastname2",  salary = 2000, title =  Title.DEVELOPER)
//		employeeRepository.save(employee2)
//		val employee3 = Employee(firstname =  "firstname3", lastname =  "lastname3",  salary = 3000, title =  Title.MANAGER)
//		employeeRepository.save(employee3)
//		val employee4 = Employee(firstname =  "firstname4", lastname =  "lastname4", salary = 4000, title =  Title.MANAGER)
//		employeeRepository.save(employee4)
//		val employee5 = Employee(firstname =  "firstname5", lastname =  "lastname5", salary = 5000, title =  Title.HR)
//		employeeRepository.save(employee5)
//		employeeRepository.findAll().forEach(::println)
//
//		val user1 = User(username = "user1", password = "pass1")
//		user1.employee = employee1
//		val user2 = User(username = "user2", password = "pass2")
//		val user3 = User(username = "user3", password = "pass3")
//
//		userRepository.save(user1)
//		userRepository.save(user2)
//		userRepository.save(user3)
	}

}

fun main(args: Array<String>) {
	runApplication<DashboardApplication>(*args)
}
