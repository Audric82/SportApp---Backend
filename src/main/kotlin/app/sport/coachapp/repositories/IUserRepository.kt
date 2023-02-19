package app.sport.coachapp.repositories

import app.sport.coachapp.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String) : User
}