package app.sport.coachapp.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data

@Entity
@Data
@Table(name = "programs")
class Program (
        @Id
        var id: Long,

        var type : String,

        var user: Long
)