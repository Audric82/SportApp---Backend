package app.sport.coachapp.entities

import jakarta.persistence.*
import lombok.Data

@Entity
@Data
@Table(name="exercices")
class Exercice(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        var name: String,

        var instructions : String,

        var result: String,

        var done: Boolean,

        var sessionid : Long
)