package com.example.springkotlin

import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, Int>

interface CourseRepository : CrudRepository<Course, Int>