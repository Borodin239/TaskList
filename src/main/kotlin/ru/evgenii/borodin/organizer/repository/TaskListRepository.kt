package ru.evgenii.borodin.organizer.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.evgenii.borodin.organizer.entity.TaskList

@Repository
interface TaskListRepository: JpaRepository<TaskList, Long>