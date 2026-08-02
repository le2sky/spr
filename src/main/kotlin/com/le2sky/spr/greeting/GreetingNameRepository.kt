package com.le2sky.spr.greeting

import org.springframework.data.jpa.repository.JpaRepository

interface GreetingNameRepository : JpaRepository<GreetingName, Long> {
    fun findFirstByOrderByIdAsc(): GreetingName?
}
