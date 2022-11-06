package ru.evgenii.borodin.organizer.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class TaskList (
    @Id
    @GeneratedValue
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "taskList")
    val tasks: List<Task>
)