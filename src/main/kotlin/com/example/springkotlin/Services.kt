package com.example.springkotlin

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux

@Service
class StudentService(val studentRepository: StudentRepository){
    fun getAllPersons(): Flux<Student> = studentRepository.findAll()
    fun getPersonById(personId: String): Student? = studentRepository.findById(personId).block()
    fun save(student: Student) = studentRepository.save(student)
}

@Service
class CourseService(val courseRepository: CourseRepository){
    fun getAllCourses(): Flux<Course> = courseRepository.findAll()
    fun getCourseById(courseId: String): Course? = courseRepository.findById(courseId).block()
    fun save(course: Course) = courseRepository.save(course)
    fun delete(courseId: String) = courseRepository.deleteById(courseId)
}