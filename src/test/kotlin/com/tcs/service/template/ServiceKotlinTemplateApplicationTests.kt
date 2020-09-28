package com.tcs.service.template

import com.tcs.service.template.model.BaseModel
import io.mockk.MockKAnnotations
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServiceKotlinTemplateApplicationTests(@Autowired private val testRestTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @BeforeEach
    fun `start Test`() {
        println(">> start test <<")
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @AfterEach
    fun `end Test`() {
        println(">> end test <<")
    }

    @Test
    fun `when called should Return BaseModel`() {
        println("Return BaseModel(1,Basic) object when accessing /api/v1/getModel.....")
        val result = testRestTemplate.getForEntity("/api/v1/getModel", BaseModel::class.java)
        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertEquals(result?.body, BaseModel("1", "Basic"))
    }

    @Test
    fun contextLoads() {
        println("CONTEXT LOADED.....")
    }

    @Test
    fun `Mockk check`() {
        println(">> TODO <<")
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}
