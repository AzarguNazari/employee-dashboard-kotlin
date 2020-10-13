package com.employeeDashboard.dto

import com.employeeDashboard.Priority

class LoginUserDto(
    val username: String, val password: String
)

class TaskDTO(
    val taskname: String,
    val description: String,
    val priority: Priority,
    val percentage: Int
)

class TaskUpdateDTO(
    val description: String,
    val percentage: Int
)
