package app.sport.coachapp.domain

import app.sport.coachapp.entities.Login
import app.sport.coachapp.repositories.IUserRepository
import app.sport.coachapp.util.PasswordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class AuthentService() {

    @Autowired
    private lateinit var userRepository: IUserRepository

    fun login(body: Login) : Long {

        val user = userRepository.findByEmail(body.email)
        return if (!PasswordUtil.checkPassword(body.password, user.password)) -1 else user.id;
    }
}