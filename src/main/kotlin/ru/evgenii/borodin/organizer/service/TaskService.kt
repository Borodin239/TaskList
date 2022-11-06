package ru.evgenii.borodin.organizer.service

import ru.evgenii.borodin.organizer.controller.dto.TaskDTO
import ru.evgenii.borodin.organizer.entity.Task

interface TaskService {
    fun createTask(taskDTO: TaskDTO): Task
    fun deleteTask(id: Long)
    fun getById(id: Long): Task
    fun taskDone(id: Long): Task
    fun taskInProgress(id: Long): Task
}