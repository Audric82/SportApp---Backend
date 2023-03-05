package app.sport.coachapp.repositories

import app.sport.coachapp.entities.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ISessionRepository : JpaRepository<Session, Long> {
    fun deleteAllSessionByProgramid(id: Long)
    @Query("SELECT * FROM sessions WHERE date >= :date", nativeQuery = true)
    fun findAllSinceDate(@Param("date") date: LocalDate) : List<Session>
}