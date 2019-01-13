package com.example.functionalspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FunctionalSpringApplication {

	@Bean
	fun giveMeFoo() = Foo()

	@Bean
	fun giveMeBar() = Bar()
}


class Foo

class Bar

fun main(args: Array<String>) {
	runApplication<FunctionalSpringApplication>(*args)
}

