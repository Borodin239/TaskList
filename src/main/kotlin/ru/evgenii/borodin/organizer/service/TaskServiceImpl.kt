package ru.evgenii.borodin.organizer.service

import org.springframework.stereotype.Service
import ru.evgenii.borodin.organizer.controller.dto.TaskDTO
import ru.evgenii.borodin.organizer.entity.Status
import ru.evgenii.borodin.organizer.entity.Task
import ru.evgenii.borodin.organizer.repository.TaskRepository
import java.lang.RuntimeException

@Service
class TaskServiceImpl (
    private val repository: TaskRepository,
    private val taskListService: TaskListService
): TaskService {

    override fun createTask(taskDTO: TaskDTO): Task {
        val taskList = taskListService.getById(taskDTO.listId)
        // TODO: по-хорошему тут ещё фабрику добавить надо
        val task = Task(
            id = 0, // Значение не важно, так как при сохранении в БД id выдадут
            name = taskDTO.name,
            status = Status.TO_BE_DONE,
            deadline = taskDTO.deadline,
            taskList = taskList
        )
        return repository.save(task)
    }

    override fun deleteTask(id: Long) {
        val task = getById(id)
        repository.delete(task)
    }

    override fun getById(id: Long): Task = repository
        .findById(id)
        .orElseThrow { RuntimeException("Can't find task with id: $id") }

    override fun taskDone(id: Long): Task = setStatus(id, Status.DONE)

    override fun taskInProgress(id: Long): Task = setStatus(id, Status.IN_PROGRESS)

    private fun setStatus(id: Long, status: Status): Task {
        val task = getById(id)
        task.status = status
        return repository.save(task)
    }
}