package ru.evgenii.borodin.organizer.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import ru.evgenii.borodin.organizer.controller.dto.TaskListDTO
import ru.evgenii.borodin.organizer.controller.view.TaskListView
import ru.evgenii.borodin.organizer.service.TaskListService

@RestController
@RequestMapping("/api/task_list")
class TaskListController(
    private val service: TaskListService,
    private val viewMapper: ViewMapper
) {
    @Operation(summary = "Returns task list of interests")
    @GetMapping("/get/{id}")
    fun getTaskList(@PathVariable id: Long): TaskListView {
        return viewMapper.taskListToView(
            list = service.getById(id)
        )
    }

    @Operation(summary = "Returns all task lists")
    @GetMapping("/get/all")
    fun getAllTaskList(): List<TaskListView> {
        val lists = service.getAll()
        return lists.map {
            viewMapper.taskListToView(it)
        }
    }

    @Operation(summary = "Returns task list of interests")
    @PostMapping("/create")
    fun createTaskList(@RequestBody taskListDTO: TaskListDTO): TaskListView {
        val list = service.create(taskListDTO)
        return viewMapper.taskListToView(list)
    }
}