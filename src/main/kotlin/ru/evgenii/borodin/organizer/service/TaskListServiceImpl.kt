package ru.evgenii.borodin.organizer.service

import org.springframework.stereotype.Service
import ru.evgenii.borodin.organizer.controller.dto.TaskListDTO
import ru.evgenii.borodin.organizer.entity.TaskList
import ru.evgenii.borodin.organizer.repository.TaskListRepository
import java.lang.RuntimeException

@Service
class TaskListServiceImpl(
    private val repository: TaskListRepository
): TaskListService {

    override fun getById(id: Long): TaskList = repository
        .findById(id)
        .orElseThrow { RuntimeException("Can't find taskList with id: $id") }

    override fun getAll(): List<TaskList> = repository.findAll()

    override fun create(dto: TaskListDTO): TaskList {
        val taskList = TaskList(
            id = 0,
            name = dto.name,
            tasks = listOf()
        )
        return repository.save(taskList)
    }

    override fun delete(id: Long) {
        val list = getById(id)
        repository.delete(list)
    }
}