package dashboard.apiDoc

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
@OpenAPIDefinition
class SwaggerConfig {

    @Value("\${backend-version}")
    private val version: String? = null

    @Value("\${openAPItitle}")
    private val openAPITitle: String? = null

    @Bean
    fun openApi() = OpenAPI().info(Info().title(openAPITitle).version(version).license(License().name("Licence")))

    @Bean
    fun userGroup() = GroupedOpenApi.builder().group("Users").pathsToMatch("/api/v1/users/**").build()

    @Bean
    fun employeeGroup() = GroupedOpenApi.builder().group("Employees").pathsToMatch("/api/v1/employees/**").build()

    @Bean
    fun taskGroup() = GroupedOpenApi.builder().group("Tasks").pathsToMatch("/api/v1/tasks/**").build()

    @Bean
    fun messageGroup() = GroupedOpenApi.builder().group("Messages").pathsToMatch("/api/v1/messages/**").build()


    @Bean
    fun announcementGroup() = GroupedOpenApi.builder().group("Announcements").pathsToMatch("/api/v1/announcements/**").build()

    @Bean
    fun attendanceGroup() = GroupedOpenApi.builder().group("Attendance").pathsToMatch("/api/v1/attendance/**").build()

}