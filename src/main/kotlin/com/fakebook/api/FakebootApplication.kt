package com.fakebook.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakebootApplication

fun main(args: Array<String>) {
	runApplication<FakebootApplication>(*args)
}
