package ru.evgenii.borodin.organizer.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import ru.evgenii.borodin.organizer.controller.dto.TaskDTO
import ru.evgenii.borodin.organizer.controller.view.TaskView
import ru.evgenii.borodin.organizer.service.TaskService

@RestController
@RequestMapping("/api/task")
class TaskController(
    private val service: TaskService,
    private val viewMapper: ViewMapper
) {
    @Operation(summary = "Returns the task of interests")
    @GetMapping("/get/{id}")
    fun getTask(@PathVariable id: Long): TaskView {
        return viewMapper.taskToView(
            task = service.getById(id)
        )
    }

    @Operation(summary = "Returns list of tasks")
    @PostMapping("/create")
    fun createTask(@RequestBody taskDTO: TaskDTO): TaskView {
        return viewMapper.taskToView(
            task = service.createTask(taskDTO)
        )
    }

    @Operation(summary = "Returns list of tasks")
    @DeleteMapping("/delete/{id}")
    fun deleteTask(@PathVariable id: Long) {
        service.deleteTask(id)
    }

    @Operation(summary = "Marks task as done")
    @PatchMapping("/markDone/{id}")
    fun taskDone(@PathVariable id: Long): TaskView {
        return viewMapper.taskToView(
           task = service.taskDone(id)
        )
    }

    @Operation(summary = "Marks task as InProgress")
    @PatchMapping("/markInProgress/{id}")
    fun taskInProgress(@PathVariable id: Long): TaskView {
        return viewMapper.taskToView(
            task = service.taskInProgress(id)
        )
    }
}