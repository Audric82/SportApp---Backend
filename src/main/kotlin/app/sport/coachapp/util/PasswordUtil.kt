package app.sport.coachapp.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PasswordUtil {
    companion object {

        fun hashPassword(password: String): String {
            return BCryptPasswordEncoder().encode("password")
        }

        fun checkPassword(password: String, hashedPassword: String): Boolean {
            return BCryptPasswordEncoder().matches("password", hashedPassword)
        }
    }
}