package com.le2sky.spr.greeting

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(
    private val greetingService: GreetingService,
) {
    @GetMapping("/hello", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun hello(): String = "hello, ${greetingService.getName()}"
}
