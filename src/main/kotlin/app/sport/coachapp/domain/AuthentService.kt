package app.sport.coachapp.domain

import app.sport.coachapp.entities.Login
import app.sport.coachapp.repositories.IUserRepository
import app.sport.coachapp.util.PasswordUtil
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class AuthentService() {

    @Autowired
    private lateinit var userRepository: IUserRepository

    fun authenticate(body: Login) : Long {

        var user = userRepository.findByEmail(body.email)

        if (user == null || !PasswordUtil.checkPassword(body.password, user.password)) {
            -1;
        } else {
            return user.id;
        }
    }
}