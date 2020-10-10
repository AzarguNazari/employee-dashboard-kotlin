package com.example.springkotlin

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.kotlin.core.publisher.toFlux

@Service
class StudentService(val studentRepository: StudentRepository){
    fun getAllPersons(): Flux<Student> = studentRepository.findAll().toFlux()
    fun getPersonById(personId: Int): Student? = studentRepository.findById(personId).get()
    fun save(student: Student) = studentRepository.save(student)
    fun delete(studentId: Int) = studentRepository.deleteById(studentId)
    fun update(studentId: Int, student: Student) = studentRepository.findById(studentId).let{
            if (it.isEmpty) {
                student.id = studentId
                studentRepository.deleteById(studentId)
                studentRepository.save(student)
            }
        }
}

@Service
class CourseService(val courseRepository: CourseRepository){
    fun getAllCourses(): Flux<Course> = courseRepository.findAll().toFlux()
    fun getCourseById(courseId: Int): Course? = courseRepository.findById(courseId).get()
    fun save(course: Course) = courseRepository.save(course)
    fun delete(courseId: Int) = courseRepository.deleteById(courseId)
    fun update(courseId: Int, course: Course) {
        courseRepository.findById(courseId).let{
            if (it.isEmpty) {
                course.id = courseId
                courseRepository.deleteById(courseId)
                courseRepository.save(course)
            }
        }
    }
}