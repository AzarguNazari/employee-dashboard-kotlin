package dashboard.config

import dashboard.models.jpa.Employee
import dashboard.models.jpa.Priority
import dashboard.models.jpa.Task
import dashboard.models.jpa.Title
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import dashboard.repositories.RoleRepository
import dashboard.repositories.TaskRepository
import dashboard.services.EmployeeService

@Configuration
@ConditionalOnProperty(value = ["insertDataAuto"], havingValue = "true")
class PostRunning(val employeeService: EmployeeService,
                  val taskRepository: TaskRepository,
                  val roleRepository: RoleRepository
) : CommandLineRunner {


    override fun run(vararg args: String) {

        // ROLES
//        Role admin = new Role("ADMIN");
//        Role user = new Role("USER");
//        roleRepository.save(admin);
//        roleRepository.save(user);

        // TASKS
        val task1 = Task(taskname = "Task1", description =  "Description 1", priority =  Priority.LOW)
        val task2 = Task(taskname = "Task2", description =  "Description 2")
        val task3 = Task(taskname = "Task3", description =  "Description 3", priority = Priority.HIGH)
        taskRepository.save(task1)
        taskRepository.save(task2)
        taskRepository.save(task3)


        // EMPLOYEES
        val employee1 = Employee(username = "username1", firstname = "firstname1", lastname = "lastname1", password =  "password1", salary = 1000, title = Title.DEVELOPER)
        employeeService.save(employee1)
        val employee2 = Employee(username = "username2",firstname =  "firstname2", lastname = "lastname2", password = "password2", salary =  2000, title = Title.DEVELOPER)
        employeeService.save(employee2)
        val employee3 = Employee(username = "username3",firstname =  "firstname3", lastname = "lastname3", password = "password3", salary =  3000, title = Title.HR)
        employeeService.save(employee3)
        val employee4 = Employee(username = "username4",firstname =  "firstname4", lastname = "lastname4", password = "password4", salary =  4000, title = Title.MANAGER)
        employeeService.save(employee4)
        val employee5 = Employee(username = "username5",firstname =  "firstname5", lastname = "lastname5", password = "password5", salary =  5000, title = Title.DEVELOPER)
        employeeService.save(employee5)
    }
}