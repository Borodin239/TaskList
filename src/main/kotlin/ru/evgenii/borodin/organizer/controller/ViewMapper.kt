package ru.evgenii.borodin.organizer.controller

import org.springframework.stereotype.Component
import ru.evgenii.borodin.organizer.controller.view.TaskListView
import ru.evgenii.borodin.organizer.controller.view.TaskView
import ru.evgenii.borodin.organizer.entity.Task
import ru.evgenii.borodin.organizer.entity.TaskList

@Component
class ViewMapper {

    fun taskToView(task: Task): TaskView {
        return TaskView(
            id = task.id,
            name = task.name,
            status = task.status.name,
            deadline = task.deadline
        )
    }

    fun taskListToView(list: TaskList): TaskListView {
        val tasks = list.tasks.map { taskToView(it) }
        return TaskListView(
            id = list.id,
            name = list.name,
            tasks = tasks)
    }
}