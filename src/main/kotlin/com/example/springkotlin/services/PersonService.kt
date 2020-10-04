package com.example.springkotlin.services

import com.example.springkotlin.model.Person
import com.example.springkotlin.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(var personRepository: PersonRepository){

    fun getAllPersons(): List<Person> = personRepository.findAll().toList()

    fun getPersonById(personId: Int): Person = personRepository.findById(personId).get()

}