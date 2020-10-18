package dashboard

import dashboard.model.Employee
import dashboard.model.Priority
import dashboard.model.Task
import dashboard.model.Title
import dashboard.repository.EmployeeRepository
import dashboard.repository.RoleRepository
import dashboard.repository.TaskRepository
import dashboard.service.interfaces.EmployeeServiceInterface
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DashboardApplication(val employeeRepository: EmployeeRepository,
						   val taskRepository: TaskRepository,
						   val roleRepository: RoleRepository): ApplicationRunner{
	override fun run(args: ApplicationArguments?) {

		// ROLES
//        Role admin = new Role("ADMIN");
//        Role user = new Role("USER");
//        roleRepository.save(admin);
//        roleRepository.save(user);

		// TASKS
//		val task1 = Task(taskname = "Task1", description = "Descriptoin1", priority =  Priority.LOW)
//		val task2 = Task(taskname = "Task2", description = "Descriptoin2", priority =  Priority.NORMAL)
//		val task3 = Task(taskname = "Task3", description = "Descriptoin3", priority =  Priority.HIGH)
//		taskRepository.save(task1)
//		taskRepository.save(task2)
//		taskRepository.save(task3)
//		taskRepository.findAll().forEach(::println)
//
//		// EMPLOYEES
//		val employee1 = Employee(username = "username1", firstname =  "firstname1", lastname =  "lastname1", password =  "password1", salary = 1000, title =  Title.DEVELOPER)
//		employeeRepository.save(employee1)
//		val employee2 = Employee(username = "username2", firstname =  "firstname2", lastname =  "lastname2", password =  "password2", salary = 2000, title =  Title.DEVELOPER)
//		employeeRepository.save(employee2)
//		val employee3 = Employee(username = "username3", firstname =  "firstname3", lastname =  "lastname3", password =  "password3", salary = 3000, title =  Title.MANAGER)
//		employeeRepository.save(employee3)
//		val employee4 = Employee(username = "username4", firstname =  "firstname4", lastname =  "lastname4", password =  "password4", salary = 4000, title =  Title.MANAGER)
//		employeeRepository.save(employee4)
//		val employee5 = Employee(username = "username5", firstname =  "firstname5", lastname =  "lastname5", password =  "password5", salary = 5000, title =  Title.HR)
//		employeeRepository.save(employee5)
//		employeeRepository.findAll().forEach(::println)
	}

}

fun main(args: Array<String>) {
	runApplication<DashboardApplication>(*args)
}
