package com.le2sky.spr.greeting

import org.springframework.stereotype.Service

@Service
class GreetingService(
    private val greetingNameRepository: GreetingNameRepository,
) {
    fun getName(): String =
        greetingNameRepository.findFirstByOrderByIdAsc()?.name
            ?: throw IllegalStateException("Greeting name is not configured")
}
