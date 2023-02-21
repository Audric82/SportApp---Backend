package app.sport.coachapp.controller

import app.sport.coachapp.domain.AuthentService
import app.sport.coachapp.entities.Login
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("login/")
class AuthentController {

    @Autowired
    private lateinit var authentService : AuthentService

    @PostMapping("")
    fun login(@RequestBody credentials: Login) : ResponseEntity<String> {

        var userId = authentService.login(credentials)

        if (userId == -1L) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User unautorized");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("{ \"id\":$userId }")
        }
    }
}