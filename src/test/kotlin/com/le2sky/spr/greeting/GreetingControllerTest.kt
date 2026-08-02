package com.le2sky.spr.greeting

import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(GreetingController::class)
class GreetingControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    @MockitoBean
    private lateinit var greetingService: GreetingService

    @Test
    fun `returns a plain text greeting from the service`() {
        `when`(greetingService.getName()).thenReturn("repository-name")

        mockMvc.get("/hello")
            .andExpect {
                status { isOk() }
                content { contentTypeCompatibleWith(MediaType.TEXT_PLAIN) }
                content { string("hello, repository-name") }
            }

        verify(greetingService).getName()
    }
}
