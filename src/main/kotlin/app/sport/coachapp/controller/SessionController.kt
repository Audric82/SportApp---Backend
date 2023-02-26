package app.sport.coachapp.controller

import app.sport.coachapp.domain.SessionServiceImpl
import app.sport.coachapp.entities.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("sessions/")
class SessionController {

    @Autowired
    private lateinit var sessionServiceImpl: SessionServiceImpl

    @GetMapping("")
    fun GetAllSessions() : List<Session> {
        return sessionServiceImpl.getAll()
    }

    @GetMapping("{id}")
    fun GetSessionById(@PathVariable("id") id : Long) : Session {
        return sessionServiceImpl.getSessionById(id)
    }

    @GetMapping("date/{date}")
    fun getAllSessionSinceDate(@PathVariable("date") date : String) : List<Session> {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var dateParsed = LocalDate.parse(date, formatter)
        return sessionServiceImpl.getAllSinceDate(dateParsed)
    }

    @PostMapping("")
    fun PostSession(@RequestBody session: Session) : ResponseEntity<String> {
        if (sessionServiceImpl.updateSession(session) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Session has been updated")
        } else {
            sessionServiceImpl.createSession(session)
            return ResponseEntity.status(HttpStatus.CREATED).body("Session has been created")
        }
    }

    @DeleteMapping("{id}")
    fun DeleteSession(@PathVariable("id") id: Long ) : ResponseEntity<String> {
        sessionServiceImpl.deleteSessionById(id)
         return ResponseEntity.status(HttpStatus.OK).body("Session has been deleted")
    }

    @DeleteMapping("program/{id}")
    fun deleteAllExerciceBySessionId(@PathVariable("id") id : Long) : ResponseEntity<String> {
        sessionServiceImpl.deleteAllSessionByProgramId(id)
        return ResponseEntity.status(HttpStatus.OK).body("All sessions has been deleted")
    }
}