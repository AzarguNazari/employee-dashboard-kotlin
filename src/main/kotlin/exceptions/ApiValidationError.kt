package exceptions

data class ApiValidationError (
    val `object`: String,
    val message: String,
    val field: String? = null,
    val rejectedValue: Any? = null
)