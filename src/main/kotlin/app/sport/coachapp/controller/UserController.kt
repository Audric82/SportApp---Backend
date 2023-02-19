package app.sport.coachapp.controller

import app.sport.coachapp.domain.UserService
import app.sport.coachapp.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users/")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("")
    fun GetAllUsers() : List<User> {
        return userService.getAll()
    }

    @GetMapping("{id}")
    fun GetUserById(@PathVariable("id") id : Long) : User {
        return userService.getUserById(id)
    }

    @PostMapping("")
    fun PostUser(@RequestBody user : User) : ResponseEntity<String> {
        if (userService.updateUser(user) != null) {
            return ResponseEntity.status(HttpStatus.OK).body( "User has been updated")
        } else {
            userService.createUser(user)
            return ResponseEntity.status(HttpStatus.CREATED).body("User has been created")
        }
    }

    @DeleteMapping("{id}")
    fun DeleteUserById(@PathVariable("id") id : Long) : ResponseEntity<String> {
        userService.deleteUserById(id)
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted")
    }
}