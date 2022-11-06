package ru.evgenii.borodin.organizer.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Task (
    @Id
    @GeneratedValue
    val id: Long,

    @Column(nullable = false)
    var name: String,

    var status: Status,

    var deadline: LocalDateTime,

    @ManyToOne
    var taskList: TaskList
)