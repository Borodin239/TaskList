package ru.evgenii.borodin.organizer.service

import ru.evgenii.borodin.organizer.controller.dto.TaskListDTO
import ru.evgenii.borodin.organizer.entity.TaskList

interface TaskListService {
    fun getById(id: Long): TaskList
    fun getAll(): List<TaskList>
    fun create(dto: TaskListDTO): TaskList
    fun delete(id: Long)
}