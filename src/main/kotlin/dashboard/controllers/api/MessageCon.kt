package dashboard.controllers.api//package com.employeeDashboard.controller
//
//import com.dashboard.controller.interfaces.EmployeeControllerInterface
//import com.dashboard.exception.*
//import com.dashboard.model.Employee
//import dashboard.controller.interfaces.EmployeeControllerInterface
//import io.swagger.v3.oas.annotations.tags.Tag
//import lombok.extern.log4j.Log4j2
//import org.springframework.data.domain.Pageable
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//
//@RestController
//@RequestMapping("/api/v1/messages")
//@Tag(name = "Messages")
//class MessageController : EmployeeControllerInterface {
//
//
//    fun createEmployee(employee: Employee?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//
//    fun getAllEmployees(pageable: Pageable?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//
//    fun getEmployeeById(id: Int?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//
//    fun deleteEmployeeById(id: Int?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//
//    fun updateEmployee(employeeId: Int?, employee: Employee?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//
//    fun assignTask(employeeID: Int?, taskID: Int?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//
//    fun unassignTask(employeeID: Int?, taskID: Int?): ResponseEntity<*> {
//        return ResponseEntity<Any>(HttpStatus.NOT_IMPLEMENTED)
//    }
//}