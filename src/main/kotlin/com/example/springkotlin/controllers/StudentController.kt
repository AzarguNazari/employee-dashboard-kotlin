package com.example.springkotlin.controllers

import com.example.springkotlin.Student
import com.example.springkotlin.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/students")
class StudentController(var studentService: StudentService){

    @GetMapping
    fun getAllStudents(): Flux<Student> = studentService.getAllPersons()

    @GetMapping("/{studentId}")
    fun getStudentById(@PathVariable studentId: Int): Mono<Student> = Mono.just(studentService.getPersonById(studentId))

}