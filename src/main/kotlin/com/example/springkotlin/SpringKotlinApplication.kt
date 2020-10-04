package com.example.springkotlin

import com.example.springkotlin.model.Person
import com.example.springkotlin.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinApplication(var personRepository: PersonRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val person = Person("Ahmad", "Mahmood")
        personRepository.save(person)

        personRepository.findAll().forEach {
            println(it)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringKotlinApplication>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
