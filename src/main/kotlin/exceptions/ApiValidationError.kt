package exceptions

data class ApiValidationError (
    val entity: String? = null,
    val message: String? = null,
    val field: String? = null,
    val rejectedValue: Any? = null
): ApiSubError()