package com.employeeDashboard.restApi

import com.employeeDashboard.Course
import com.employeeDashboard.Student
import com.employeeDashboard.service.StudentService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/students")
class StudentController(val studentService: StudentService){

    var LOGGER = LoggerFactory.getLogger(StudentController::class.java)

    @GetMapping
    fun getAllStudents(): Flux<Student> = studentService.getAllPersons()

    @GetMapping("/{studentId}")
    fun getStudentById(@PathVariable studentId: Int): Mono<Student>? = studentService.getPersonById(studentId)?.let { Mono.just(it) }

    @PostMapping
    fun saveStudent(student: Student) = studentService.save(student)

    @DeleteMapping("/{studentId}")
    fun deleteStudent(@PathVariable studentId: Int) = studentService.delete(studentId)

    @PutMapping("/{studentId}")
    fun updateStudent(@PathVariable studentId: Int, @RequestBody student: Student) = studentService.update(studentId, student)

    @PostMapping("/{studentId}/register")
    fun registerCourse(@PathVariable studentId: Int, @RequestBody course: Course) = studentService.registerCourse(studentId, course)


    @PostMapping("/{studentId}/deregister")
    fun deregisterCourse(@PathVariable studentId: Int, @RequestBody course: Course) = studentService.deregisterCourse(studentId, course)

}