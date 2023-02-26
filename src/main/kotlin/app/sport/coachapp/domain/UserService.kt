package app.sport.coachapp.domain

import app.sport.coachapp.entities.User

interface UserService {

    fun getAll() : List<User>
    fun getUserById(id : Long) : User
    fun updateUser(user: User) : User?
    fun createUser(user: User) : User
    fun deleteUserById(id: Long)
}