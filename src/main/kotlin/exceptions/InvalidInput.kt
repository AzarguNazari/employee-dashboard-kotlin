package exceptions

import java.lang.RuntimeException

class InvalidInput(message: String?) : RuntimeException(message)