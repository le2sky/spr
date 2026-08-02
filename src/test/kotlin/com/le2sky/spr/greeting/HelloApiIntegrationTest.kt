package com.le2sky.spr.greeting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloApiIntegrationTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val greetingNameRepository: GreetingNameRepository,
) {
    @Test
    fun `loads the H2 name through JPA and returns hello world`() {
        val storedName = greetingNameRepository.findFirstByOrderByIdAsc()

        assertThat(storedName?.name).isEqualTo("world")

        mockMvc.get("/hello")
            .andExpect {
                status { isOk() }
                content { contentTypeCompatibleWith(MediaType.TEXT_PLAIN) }
                content { string("hello, world") }
            }
    }
}
