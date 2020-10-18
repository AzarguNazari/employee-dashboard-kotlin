package dashboard.service


import dashboard.exception.EmployeeNotFoundException
import dashboard.model.Employee
import dashboard.repository.EmployeeRepository
import dashboard.repository.TaskRepository
import dashboard.service.DAO
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class EmployeeService(val employeeRepository: EmployeeRepository,
                      val taskRepository: TaskRepository) : DAO<Employee> {

    override fun save(employee: Employee) {
        employeeRepository.save(employee)
    }

    override fun delete(id: Int) {
        employeeRepository.deleteById(id)
    }

    override fun update(id: Int, employee: Employee) {
        if(exist(id)){
            employee.id = id
            employeeRepository.deleteById(id)
            employeeRepository.save(employee)
        }
        throw EmployeeNotFoundException()
    }

    override fun getAll() = employeeRepository.findAll().toList()

    override fun getById(id: Int) = employeeRepository.findById(id)?.get()

    override fun exist(id: Int) = employeeRepository.existsById(id)

}
