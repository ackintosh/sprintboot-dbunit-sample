package com.github.ackintosh.sprintbootdbunit

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SprintbootdbunitApplication

@RestController
class Home(val mapper: BillionaireMapper) {
    @GetMapping("/")
    fun home(): String {
        val billionaire = mapper.selectById(2)
        println(billionaire)
        return "Hi!"
    }
}

@Mapper
@Component
interface BillionaireMapper {
    @Select("SELECT id, career FROM BILLIONAIRES WHERE ID = #{id}")
    fun selectById(id: Int): Billionaire
}

data class Billionaire(val id: Int, val career: String)

fun main(args: Array<String>) {
    runApplication<SprintbootdbunitApplication>(*args)
}
