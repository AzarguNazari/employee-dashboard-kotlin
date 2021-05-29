package com.dashboard.apiDoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@OpenAPIDefinition
public class SwaggerConfig {

    @Value("${backend-version}")
    private String version;

    @Value("${openAPItitle}")
    private String openAPITitle;

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(new Info().title(openAPITitle).version(version).license(new License().name("Licence")));
    }

    @Bean
    public GroupedOpenApi userGroup(){
        return GroupedOpenApi.builder().group("Users").pathsToMatch("/api/v1/users/**").build();
    }

    @Bean
    public GroupedOpenApi employeeGroup(){
        return GroupedOpenApi.builder().group("Employees").pathsToMatch("/api/v1/employees/**").build();
    }

    @Bean
    public GroupedOpenApi taskGroup(){
        return GroupedOpenApi.builder().group("Tasks").pathsToMatch("/api/v1/tasks/**").build();
    }

    @Bean
    public GroupedOpenApi messageGroup(){
        return GroupedOpenApi.builder().group("Messages").pathsToMatch("/api/v1/messages/**").build();
    }

    @Bean
    public GroupedOpenApi announcementGroup(){
        return GroupedOpenApi.builder().group("Announcements").pathsToMatch("/api/v1/announcements/**").build();
    }

    @Bean
    public GroupedOpenApi attendanceGroup(){
        return GroupedOpenApi.builder().group("Attendance").pathsToMatch("/api/v1/attendance/**").build();
    }
}
