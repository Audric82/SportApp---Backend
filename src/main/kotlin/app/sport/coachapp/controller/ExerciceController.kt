package app.sport.coachapp.controller

import app.sport.coachapp.domain.ExerciceService
import app.sport.coachapp.entities.Exercice
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
import java.util.*

@RestController
@RequestMapping("exercices/")
class ExerciceController {

    @Autowired
    private lateinit var exerciceService: ExerciceService

    @GetMapping("")
    fun getAllExercices() : List<Exercice> {
        return exerciceService.getAll()
    }

    @GetMapping("sessions/{id}")
    fun getAllExercicesBySessionId(@PathVariable("id") id : Long) : List<Exercice> {
        return exerciceService.getBySessionId(id)
    }

    @PostMapping("")
    fun postExercice(@RequestBody exercice: Exercice) : ResponseEntity<String> {
        if (exerciceService.updateExercice(exercice) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Exercise has been updated")
        } else {
            exerciceService.createExercice(exercice)
            return ResponseEntity.status(HttpStatus.CREATED).body("Exercise has been created")
        }
    }

    @DeleteMapping("{id}")
    fun deleteExercice(@PathVariable("id") id : Long) : ResponseEntity<String> {
        exerciceService.deleteExerciceById(id)
        return ResponseEntity.status(HttpStatus.OK).body("Exercise has been deleted")
    }

    @DeleteMapping("session/{id}")
    fun deleteAllExerciceBySessionId(@PathVariable("id") id : Long) : ResponseEntity<String> {
        exerciceService.deleteAllExerciceBySessionId(id)
        return ResponseEntity.status(HttpStatus.OK).body("All exercices has been deleted")
    }
}