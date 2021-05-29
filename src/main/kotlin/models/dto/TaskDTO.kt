package dashboard.models.dto

import dashboard.models.jpa.Priority

data class TaskDTO(val taskName: String, val description: String, val priority: Priority?, val percentage: Int)