package com.example.springkotlin

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StudentRepository : ReactiveMongoRepository<Student, String>

interface CourseRepository : ReactiveMongoRepository<Course, String>