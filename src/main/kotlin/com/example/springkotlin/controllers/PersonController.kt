package com.example.springkotlin.controllers

import com.example.springkotlin.model.Person
import com.example.springkotlin.repository.PersonRepository
import com.example.springkotlin.services.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

@RestController
@RequestMapping("/api")
class PersonController(var personService: PersonService){

    @GetMapping("/persons")
    fun getAllPersons(): Flux<Person> = personService.getAllPersons().toFlux()

    @GetMapping("/persons/{personId}")
    fun getPersonById(@PathVariable personId: Int): Mono<Person>{
        return Mono.just(personService.getPersonById(personId))
    }
}