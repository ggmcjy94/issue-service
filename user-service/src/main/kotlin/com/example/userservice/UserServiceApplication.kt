package com.example.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@ConfigurationPropertiesScan
class UserServiceApplication {
}

fun main (args: Array<String>) {
    runApplication<UserServiceApplication>(*args)
}