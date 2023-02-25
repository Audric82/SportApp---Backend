package app.sport.coachapp.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

@Entity
@Data
@Table(name="sessions")
class Session (

        @Id
        @Column(name="id")
        var id: Long,

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name="date")
        var date: Date,

        @Column(name="type")
        var type: String,

        @Column(name="done")
        var done: Boolean,

        @Column(name="programid")
        var programid: Long
)