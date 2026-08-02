package com.le2sky.spr.greeting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class GreetingNameRepositoryTest @Autowired constructor(
    private val greetingNameRepository: GreetingNameRepository,
) {
    @Test
    fun `finds the default name stored in H2`() {
        val greetingName = greetingNameRepository.findFirstByOrderByIdAsc()

        assertThat(greetingName?.name).isEqualTo("world")
    }
}
