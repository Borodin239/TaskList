package ru.evgenii.borodin.organizer.controller.view

data class TaskListView (
    val name: String,
    val tasks: List<TaskView>
)