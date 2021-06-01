package dashboard.exceptions

import java.lang.RuntimeException

class UserNotFoundException : RuntimeException()
class TaskNotFoundException : RuntimeException()
class MessageNotFoundException : RuntimeException()
class EmployeeNotFoundException : RuntimeException()
class BadRequestException : RuntimeException()
class AttendanceNotFoundException : RuntimeException()
class AnnouncementNotFoundException : RuntimeException()
class InvalidInput(message: String) : RuntimeException(message)