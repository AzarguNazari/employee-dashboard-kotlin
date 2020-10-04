package com.example.springkotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(var firstName: String,
                  var lastName: String,
                  @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int = 0){

}