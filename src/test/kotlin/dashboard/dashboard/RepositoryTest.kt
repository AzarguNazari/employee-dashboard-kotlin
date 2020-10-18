package dashboard.dashboard

import dashboard.model.*
import dashboard.repository.EmployeeRepository
import dashboard.repository.TaskRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull


@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val employeeRepository: EmployeeRepository,
        val taskRepository: TaskRepository) {

    @Test
    fun `When findByIdOrNull then return Task`() {

        val createTestTask = Task(id = 1, taskname = "Create a new test", priority = Priority.HIGH, description = "Creating a new test for api", status = Status.READY)
        entityManager.persist(createTestTask)

        val ahmad = Employee(id = 1, username = "testUsername", title = Title.MANAGER, salary = 100, firstname = "Ahmad", lastname = "Nazari", password = "123")
        ahmad.tasks.plus(createTestTask)
        entityManager.persist(ahmad)
        entityManager.flush()

        val found = employeeRepository.findByIdOrNull(ahmad.id!!)
        assertThat(found).isEqualTo(ahmad)
    }
}