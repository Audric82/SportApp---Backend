package app.sport.coachapp.domain

import app.sport.coachapp.entities.User
import app.sport.coachapp.repositories.IUserRepository
import app.sport.coachapp.util.PasswordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: IUserRepository

    override fun getAll() : List<User> {
        return userRepository.findAll()
    }

    override fun getUserById(id : Long) : User {
        return userRepository.findById(id).get()
    }

    override fun updateUser(user: User) : User? {
        user.password = PasswordUtil.hashPassword(user.password)
        return if (userRepository.findByIdOrNull(user.id) != null) userRepository.save(user) else null
    }

    override fun createUser(user: User) : User {
        user.password = PasswordUtil.hashPassword(user.password)
        return userRepository.save(user)
    }

    override fun deleteUserById(id: Long) {
        return userRepository.deleteById(id)
    }
}