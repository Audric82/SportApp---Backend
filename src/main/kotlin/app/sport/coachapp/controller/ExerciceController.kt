package app.sport.coachapp.controller

import app.sport.coachapp.domain.ExerciceServiceImpl
import app.sport.coachapp.entities.Exercice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("exercices/")
class ExerciceController {

    @Autowired
    private lateinit var exerciceServiceImpl: ExerciceServiceImpl

    @GetMapping("")
    fun getAllExercices() : List<Exercice> {
        return exerciceServiceImpl.getAll()
    }

    @GetMapping("sessions/{id}")
    fun getAllExercicesBySessionId(@PathVariable("id") id : Long) : List<Exercice> {
        return exerciceServiceImpl.getBySessionId(id)
    }

    @PostMapping("")
    fun postExercice(@RequestBody exercise: Exercice) : ResponseEntity<String> {
        if (exerciceServiceImpl.createExercice(exercise) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Exercise has been created")
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't add exercise")
    }

    @PutMapping("")
    fun updateExercise(@RequestBody exercise: Exercice) : ResponseEntity<String> {
        if (exerciceServiceImpl.updateExercise(exercise) != null ) {
            return ResponseEntity.status(HttpStatus.OK).body("Exercise has been updated")
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't add exercise")
    }

    @DeleteMapping("{id}")
    fun deleteExercice(@PathVariable("id") id : Long) : ResponseEntity<String> {
        exerciceServiceImpl.deleteExerciceById(id)
        return ResponseEntity.status(HttpStatus.OK).body("Exercise has been deleted")
    }

    @DeleteMapping("session/{id}")
    fun deleteAllExerciceBySessionId(@PathVariable("id") id : Long) : ResponseEntity<String> {
        exerciceServiceImpl.deleteAllExerciceBySessionId(id)
        return ResponseEntity.status(HttpStatus.OK).body("All exercices has been deleted")
    }
}