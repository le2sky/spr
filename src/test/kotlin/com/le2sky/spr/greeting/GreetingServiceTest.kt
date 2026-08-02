package com.le2sky.spr.greeting

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class GreetingServiceTest {
    private val greetingNameRepository = mock(GreetingNameRepository::class.java)
    private val greetingService = GreetingService(greetingNameRepository)

    @Test
    fun `returns the name provided by the repository`() {
        `when`(greetingNameRepository.findFirstByOrderByIdAsc())
            .thenReturn(GreetingName(name = "database-name", id = 7L))

        val name = greetingService.getName()

        assertThat(name).isEqualTo("database-name")
        verify(greetingNameRepository).findFirstByOrderByIdAsc()
    }

    @Test
    fun `fails when no name is stored`() {
        `when`(greetingNameRepository.findFirstByOrderByIdAsc()).thenReturn(null)

        assertThatThrownBy { greetingService.getName() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("Greeting name is not configured")
    }
}
