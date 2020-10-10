package com.example.springkotlin

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class Config(val courseRepository: CourseRepository, val studentRepository: StudentRepository) : ApplicationRunner{

    override fun run(args: ApplicationArguments?) {
        val courses = listOf(Course("Mathmatics", 6), Course("Biology", 6))

        val students = listOf(Student("Ahmad", "Nazari"), Student("Kamal", "Nazari"))

        students.onEach { it.courses = courses }
        courses.onEach { it.students = students }

        studentRepository.saveAll(students)
        courseRepository.saveAll(courses)
    }

}