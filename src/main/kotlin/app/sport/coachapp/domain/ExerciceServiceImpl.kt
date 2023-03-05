package app.sport.coachapp.domain

import app.sport.coachapp.entities.Exercice
import app.sport.coachapp.repositories.IExerciceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExerciceServiceImpl : ExerciceService {

    @Autowired
    private lateinit var exerciceRepository: IExerciceRepository

    override fun getAll() : List<Exercice> {
        return exerciceRepository.findAll();
    }

    override fun getById(id: Long): Exercice? {

        return if (exerciceRepository.existsById(id)) exerciceRepository.getReferenceById(id) else null
    }

    override fun getBySessionId(sessionId: Long) : List<Exercice> {
        return exerciceRepository.findAllBySessionid(sessionId)
    }

    override fun createExercice(exercice: Exercice) : Exercice? {
        return if (exerciceRepository.findByIdOrNull(exercice.id) != null) exerciceRepository.save(exercice) else null
    }

    override fun updateExercise(exercice: Exercice) : Exercice? {
         if (exerciceRepository.existsById(exercice.id)) {
             return exerciceRepository.save(exercice);
         } else {
             return null
         }
    }

    override fun deleteExerciceById(id: Long) {
        return exerciceRepository.deleteById(id)
    }

    override fun deleteAllExerciceBySessionId(id: Long) {
        return exerciceRepository.deleteAllBySessionid(id)
    }
}