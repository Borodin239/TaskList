package ru.evgenii.borodin.organizer.controller.view

data class TaskListView (
    val id: Long,
    val name: String,
    val tasks: List<TaskView>
)