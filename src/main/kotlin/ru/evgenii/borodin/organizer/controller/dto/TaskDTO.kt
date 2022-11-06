package ru.evgenii.borodin.organizer.controller.dto

import java.time.LocalDateTime

data class TaskDTO (
    val name: String,
    val deadline: LocalDateTime,
    val listId: Long
)