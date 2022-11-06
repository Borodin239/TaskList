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
            name = task.name,
            status = task.status.name,
            deadline = task.deadline
        )
    }

    fun taskListToView(list: TaskList): TaskListView {
        val tasks = list.tasks.map { taskToView(it) }
        return TaskListView(list.name, tasks)
    }
}