package com.example.springkotlin.controllers

import com.example.springkotlin.Course
import com.example.springkotlin.CourseService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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

}
