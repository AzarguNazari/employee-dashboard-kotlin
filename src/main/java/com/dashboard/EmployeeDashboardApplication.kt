package com.dashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication

@SpringBootApplication
object EmployeeDashboardApplication {
    fun main(args: Array<String>) {
        SpringApplication.run(EmployeeDashboardApplication.javaClass, *args)
    }
}