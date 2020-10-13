package com.employeeDashboard

import com.employeeDashboard.repository.CourseRepository
import com.employeeDashboard.repository.StudentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinApplication(val courseRepository: CourseRepository,
                              val studentRepository: StudentRepository) : CommandLineRunner{

    override fun run(vararg args: String?) {

        val courses = listOf(Course("Mathmatics", 6),
                             Course("Biology", 6))

        val students = listOf(Student("Ahmad", "Nazari"),
                              Student("Kamal", "Nazari"))

        studentRepository.saveAll(students)
        courseRepository.saveAll(courses)
    }

}

fun main(args: Array<String>) {
    runApplication<SpringKotlinApplication>(*args){
        //setBannerMode(Banner.Mode.OFF)
    }
}
