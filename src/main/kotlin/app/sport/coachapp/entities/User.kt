package app.sport.coachapp.entities

import jakarta.persistence.*
import lombok.Data

@Entity
@Data
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var email: String,

    var password: String,

    var username: String,

    var userrole: Int
)
