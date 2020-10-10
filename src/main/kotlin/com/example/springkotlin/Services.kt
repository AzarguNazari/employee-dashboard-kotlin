package com.example.springkotlin

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux

@Service
class StudentService(val studentRepository: StudentRepository){
    fun getAllPersons(): Flux<Student> = studentRepository.findAll().toFlux()
    fun getPersonById(personId: Int): Student = studentRepository.findById(personId).get()
}

@Service
class CourseService(val courseRepository: CourseRepository){
    fun getAllCourses(): Flux<Course> = courseRepository.findAll().toFlux()
    fun getCourseById(courseId: Int): Course? = courseRepository.findById(courseId).get()
}