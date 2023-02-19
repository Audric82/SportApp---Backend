package app.sport.coachapp.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data

@Entity
@Data
@Table(name = "users")
class User(

    @Id

    var id: Long,

    var email: String,

    var password: String
)
