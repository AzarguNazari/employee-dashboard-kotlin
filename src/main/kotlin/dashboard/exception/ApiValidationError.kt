package dashboard.exception

class ApiValidationError(val data: String,
                         val message: String?,
                         val rejectedValue: Any? = null,
                         val field: String? = null
) : ApiSubError()

