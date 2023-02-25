package app.sport.coachapp.domain

import app.sport.coachapp.entities.Exercice
import app.sport.coachapp.entities.Session
import app.sport.coachapp.entities.User
import app.sport.coachapp.repositories.ISessionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class SessionService {

    @Autowired
    private lateinit var sessionRepository: ISessionRepository

    fun getAll() : List<Session> {
        return sessionRepository.findAll()
    }

    fun getSessionById(id: Long) : Session {
        return sessionRepository.findById(id).get()
    }

    fun getAllSinceDate(date: LocalDate) : List<Session> {
        return sessionRepository.findAllSinceDate(date)
    }

    fun updateSession(session: Session) : Session? {
        return if (sessionRepository.findByIdOrNull(session.id) != null) sessionRepository.save(session) else null
    }

    fun createSession(session: Session) : Session {
        return sessionRepository.save(session)
    }

    fun deleteSessionById(id: Long) {
        sessionRepository.deleteById(id)
    }

    fun deleteAllSessionByProgramId(id: Long) {
        sessionRepository.deleteAllSessionByProgramid(id)
    }
}