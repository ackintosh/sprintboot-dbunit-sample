package com.github.ackintosh.sprintbootdbunit

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BillionaireTest() {
    @Autowired
    lateinit var billionaireMapper: BillionaireMapper

    @Test
    fun foo() {
        Assertions.assertEquals(
            Billionaire(id = 2, career = "Billionaire Tech Entrepreneur"),
            billionaireMapper.selectById(2)
        )
    }
}