package app.sport.coachapp.controller

import app.sport.coachapp.domain.AuthentService
import app.sport.coachapp.entities.Login
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("login/")
class AuthentController {

    @Autowired
    private lateinit var authentService : AuthentService

    @PostMapping("")
    fun authenticate(@RequestBody credentials: Login) : Long {
        return authentService.authenticate(credentials)
    }
}