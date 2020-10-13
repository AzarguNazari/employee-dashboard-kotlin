package com.employeeDashboard.documentation

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component


@OpenAPIDefinition
@Component
internal class SwaggerConfigs {

    @Bean
    fun openApi(): OpenAPI = OpenAPI().info(Info().title("Employee Dashboard API").version("1-SNAPSHOT").license(License().name("Licence")))

    @Bean
    fun userGroup(): GroupedOpenApi =  GroupedOpenApi.builder().setGroup("Users").pathsToMatch("/api/v1/users/**").build()

    @Bean
    fun employeeGroup(): GroupedOpenApi = GroupedOpenApi.builder().setGroup("Employees").pathsToMatch("/api/v1/employees/**").build()

    @Bean
    fun taskGroup(): GroupedOpenApi = GroupedOpenApi.builder().setGroup("Tasks").pathsToMatch("/api/v1/tasks/**").build()

    @Bean
    fun messageGroup(): GroupedOpenApi = GroupedOpenApi.builder().setGroup("Messages").pathsToMatch("/api/v1/messages/**").build()

    @Bean
    fun announcementGroup(): GroupedOpenApi = GroupedOpenApi.builder().setGroup("Announcements").pathsToMatch("/api/v1/announcements/**").build()

    @Bean
    fun attendanceGroup(): GroupedOpenApi = GroupedOpenApi.builder().setGroup("Attendance").pathsToMatch("/api/v1/attendance/**").build()
}
