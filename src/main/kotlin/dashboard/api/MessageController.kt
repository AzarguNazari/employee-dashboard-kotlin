package dashboard.api

import dashboard.interfaces.controllerInterfaces.MessageControllerInterface
import dashboard.models.jpa.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping


@RestController
@RequestMapping("/api/v1/messages")
class MessageController : MessageControllerInterface {

    private val LOGGER: Logger = LoggerFactory.getLogger(MessageController::class.java)

    override fun createMessage(message: Message): ResponseEntity<*> {
        return ResponseEntity("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED)
    }

    override fun allMessages(): ResponseEntity<*> = ResponseEntity("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED)

    override fun getMessageById(messageID: Int): ResponseEntity<*> {
        return ResponseEntity("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED)
    }

    override fun deleteMessageById(messageID: Int): ResponseEntity<*> {
        return ResponseEntity("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED)
    }

    override fun updateMessage(messageID: Int, Message: Message): ResponseEntity<*> {
        return ResponseEntity("NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED)
    }
}