import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
object EmployeeDashboardApplication {
    fun main(args: Array<String>) {
        SpringApplication.run(EmployeeDashboardApplication.javaClass, *args)
    }
}