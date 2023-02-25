package app.sport.coachapp.repositories

import app.sport.coachapp.entities.Exercice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface IExerciceRepository : JpaRepository<Exercice, Long> {

    fun findAllBySessionid(sessionId: Long) : List<Exercice>
    fun deleteAllBySessionid(sessionId: Long)
}