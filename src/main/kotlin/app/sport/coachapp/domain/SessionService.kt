package app.sport.coachapp.domain

import app.sport.coachapp.entities.Session
import java.time.LocalDate

interface SessionService {

    fun getAll() : List<Session>
    fun getSessionById(id: Long) : Session?
    fun getAllSinceDate(date: LocalDate) : List<Session>
    fun updateSession(session: Session) : Session?
    fun createSession(session: Session) : Session
    fun deleteSessionById(id: Long)
    fun deleteAllSessionByProgramId(id: Long)
}