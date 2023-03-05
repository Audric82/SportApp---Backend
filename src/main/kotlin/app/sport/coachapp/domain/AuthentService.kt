package app.sport.coachapp.domain

import app.sport.coachapp.entities.Login

interface AuthentService {

    fun login(login: Login) : Long
}