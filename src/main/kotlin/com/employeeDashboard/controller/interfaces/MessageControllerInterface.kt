package com.employeeDashboard.controller.interfaces

import com.employeeDashboard.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface MessageControllerInterface {
    @PostMapping
    fun createMessage(@RequestBody message: Message?): ResponseEntity<*>?

    @GetMapping
    fun getAllMessages(): ResponseEntity<*>?

    @GetMapping("/{messageID}")
    fun getMessageById(@PathVariable messageID: Int?): ResponseEntity<*>?

    @DeleteMapping("/{messageID}")
    fun deleteMessageById(@PathVariable messageID: Int?): ResponseEntity<*>?

    @PutMapping("/{messageID}")
    fun updateMessage(@PathVariable messageID: Int?, @RequestBody Message: Message?): ResponseEntity<*>?
}