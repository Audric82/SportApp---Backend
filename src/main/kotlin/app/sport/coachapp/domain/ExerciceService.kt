package app.sport.coachapp.domain

import app.sport.coachapp.entities.Exercice

interface ExerciceService {

    fun getAll() : List<Exercice>
    fun getById(id: Long) : Exercice?
    fun getBySessionId(sessionId: Long) : List<Exercice>
    fun createExercice(exercice: Exercice) : Exercice?
    fun updateExercise(exercice: Exercice) : Exercice?
    fun deleteExerciceById(id: Long)
    fun deleteAllExerciceBySessionId(id: Long)
}