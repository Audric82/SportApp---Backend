package app.sport.coachapp.domain

import app.sport.coachapp.entities.User
import app.sport.coachapp.repositories.IUserRepository
import app.sport.coachapp.util.PasswordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: IUserRepository

    fun getAll() : List<User> {
        return userRepository.findAll().toList()
    }

    fun getUserById(id : Long) : User {
        return userRepository.findById(id).get()
    }

    fun updateUser(user: User) : User? {
        user.password = PasswordUtil.hashPassword(user.password)
        return if (userRepository.findByIdOrNull(user.id) != null) userRepository.save(user) else null
    }

    fun createUser(user: User) : User {
        user.password = PasswordUtil.hashPassword(user.password)
        return userRepository.save(user)
    }

    fun deleteUserById(id: Long) {
        return userRepository.deleteById(id)
    }
}