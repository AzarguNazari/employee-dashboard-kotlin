package com.example.springkotlin.controllers

import com.example.springkotlin.Course
import com.example.springkotlin.CourseService
import com.example.springkotlin.Student
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
@RequestMapping("/api/courses")
class CourseController(val courseService: CourseService){

    var LOGGER = LoggerFactory.getLogger(CourseController::class.java)

    @GetMapping
    fun getAllCourses(): Flux<Course>{
        LOGGER.debug("all courses are requested")
        return courseService.getAllCourses()
    }

    @GetMapping("/{courseId}")
    fun getCourseById(@PathVariable courseId: Int): Mono<Course>? {
        val course : Course? = courseService.getCourseById(courseId)
        LOGGER.debug("course $course is retrieved")
        return course?.let { it.toMono() }
    }

    @DeleteMapping("/{courseId}")
    fun deleteCourse(@PathVariable courseId: Int) = courseService.delete(courseId)

    @PutMapping("/{courseId}")
    fun updateCourse(@PathVariable courseId: Int, @RequestBody course: Course) = courseService.update(courseId, course)

}
