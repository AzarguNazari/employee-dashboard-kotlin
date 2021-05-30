package models.dto

import models.jpa.Priority

data class TaskDTO(val taskName: String, val description: String, val priority: Priority?, val percentage: Int)