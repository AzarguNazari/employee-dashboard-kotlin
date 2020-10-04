package com.example.springkotlin.repository

import com.example.springkotlin.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Int>