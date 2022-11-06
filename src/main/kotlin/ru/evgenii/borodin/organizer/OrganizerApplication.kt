package ru.evgenii.borodin.organizer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class OrganizerApplication

fun main(args: Array<String>) {
    runApplication<OrganizerApplication>(*args)
}
