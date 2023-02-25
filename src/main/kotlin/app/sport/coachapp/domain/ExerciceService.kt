package app.sport.coachapp.domain

import app.sport.coachapp.entities.Exercice
import app.sport.coachapp.entities.User
import app.sport.coachapp.repositories.IExerciceRepository
import app.sport.coachapp.util.PasswordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class ExerciceService {

    @Autowired
    private lateinit var exerciceRepository: IExerciceRepository

    fun getAll() : List<Exercice> {
        return exerciceRepository.findAll();
    }

    fun getBySessionId(sessionId: Long) : List<Exercice> {
        return exerciceRepository.findAllBySessionid(sessionId)
    }

    fun updateExercice(exercice: Exercice) : Exercice? {
        return if (exerciceRepository.findByIdOrNull(exercice.id) != null) exerciceRepository.save(exercice) else null
    }

    fun createExercice(exercice: Exercice) : Exercice {
        return exerciceRepository.save(exercice)
    }

    fun deleteExerciceById(id: Long) {
        return exerciceRepository.deleteById(id)
    }

    fun deleteAllExerciceBySessionId(id: Long) {
        return exerciceRepository.deleteAllBySessionid(id)
    }
}