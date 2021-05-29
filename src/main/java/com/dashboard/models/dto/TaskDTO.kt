package com.dashboard.models.dto

import com.dashboard.models.JPA.Priority

data class TaskDTO(val taskName: String, val description: String, val priority: Priority?, val percentage: Int)