package com.example.springkotlin

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "students")
data class Student(var firstName: String,
                   var lastName: String,
                   @Id var id: String,
                   @DBRef(lazy = true) var courses_ids: List<Course> = mutableListOf<Course>())

@Document(collection = "courses")
data class Course(val courseName: String,
                  val ectc: Int,
                  @Id var id: String,
                  @DBRef(lazy = true) var students_ids: List<Student> = mutableListOf<Student>()
)

