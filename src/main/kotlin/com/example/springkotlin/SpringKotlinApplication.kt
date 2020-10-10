package com.example.springkotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

@SpringBootApplication
class SpringKotlinApplication(val courseRepository: CourseRepository,
                              val studentRepository: StudentRepository) : CommandLineRunner{

    override fun run(vararg args: String?) {

        val courses = listOf(Course("Mathmatics", 6, "1"),
                             Course("Biology", 6, "2"))

        val students = listOf(Student("Ahmad", "Nazari", "1"),
                              Student("Kamal", "Nazari", "2"))

        studentRepository.saveAll(students)
        courseRepository.saveAll(courses)
    }

}

fun main(args: Array<String>) {
    runApplication<SpringKotlinApplication>(*args){
        //setBannerMode(Banner.Mode.OFF)
    }
}
