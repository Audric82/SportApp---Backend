package app.sport.coachapp.controller

import app.sport.coachapp.domain.UserServiceImpl
import app.sport.coachapp.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users/")
class UserController {

    @Autowired
    private lateinit var userServiceImpl: UserServiceImpl

    @GetMapping("")
    fun GetAllUsers() : List<User> {
        return userServiceImpl.getAll()
    }

    @GetMapping("{id}")
    fun GetUserById(@PathVariable("id") id : Long) : User {
        return userServiceImpl.getUserById(id)
    }

    @PostMapping("")
    fun PostUser(@RequestBody user : User) : ResponseEntity<String> {
        if (userServiceImpl.updateUser(user) != null) {
            return ResponseEntity.status(HttpStatus.OK).body( "User has been updated")
        } else {
            userServiceImpl.createUser(user)
            return ResponseEntity.status(HttpStatus.CREATED).body("User has been created")
        }
    }

    @DeleteMapping("{id}")
    fun DeleteUserById(@PathVariable("id") id : Long) : ResponseEntity<String> {
        userServiceImpl.deleteUserById(id)
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted")
    }
}