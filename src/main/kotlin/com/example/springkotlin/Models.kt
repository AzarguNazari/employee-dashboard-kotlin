package com.example.springkotlin

import javax.persistence.*

@Entity
data class Student(var firstName: String,
                   var lastName: String,
                   @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int = 0,
                   @ManyToMany(cascade = [CascadeType.ALL])
                   @JoinTable(name = "student_course",
                              joinColumns = [JoinColumn(name = "course_id", referencedColumnName = "id")],
                              inverseJoinColumns = [JoinColumn(name = "student_id", referencedColumnName = "id")])
                    var courses : List<Course> = mutableListOf<Course>()
                   )

@Entity
data class Course(val courseName: String,
                  val ectc: Int,
                  @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int = 0,
                  @ManyToMany(mappedBy = "courses")
                  var students : List<Student> = mutableListOf<Student>()
                  )

