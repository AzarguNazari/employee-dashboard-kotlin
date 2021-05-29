//package com.dashboard.controllers;
//
//import com.dashboard.interfaces.controllerInterfaces.MessageControllerInterface;
//import com.dashboard.models.JPA.Message;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Log4j2
//@RestController
//@RequestMapping("/api/v1/messages")
//public class MessageController implements MessageControllerInterface {
//
//    @Override
//    public ResponseEntity<?> createMessage(Message message) {
//        return new ResponseEntity<>("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<?> getAllMessages() {
//        return new ResponseEntity<>("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<?> getMessageById(Integer messageID) {
//        return new ResponseEntity<>("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<?> deleteMessageById(Integer messageID) {
//        return new ResponseEntity<>("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<?> updateMessage(Integer messageID, Message Message) {
//        return new ResponseEntity<>("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED);
//    }
//}
