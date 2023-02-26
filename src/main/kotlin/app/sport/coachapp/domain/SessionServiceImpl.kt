package app.sport.coachapp.domain

import app.sport.coachapp.entities.Session
import app.sport.coachapp.repositories.ISessionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SessionServiceImpl : SessionService {

    @Autowired
    private lateinit var sessionRepository: ISessionRepository

    override fun getAll() : List<Session> {
        return sessionRepository.findAll()
    }

    override fun getSessionById(id: Long) : Session {
        return sessionRepository.findById(id).get()
    }

    override fun getAllSinceDate(date: LocalDate) : List<Session> {
        return sessionRepository.findAllSinceDate(date)
    }

    override fun updateSession(session: Session) : Session? {
        return if (sessionRepository.findByIdOrNull(session.id) != null) sessionRepository.save(session) else null
    }

    override fun createSession(session: Session) : Session {
        return sessionRepository.save(session)
    }

    override fun deleteSessionById(id: Long) {
        sessionRepository.deleteById(id)
    }

    override fun deleteAllSessionByProgramId(id: Long) {
        sessionRepository.deleteAllSessionByProgramid(id)
    }
}