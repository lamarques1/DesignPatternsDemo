package com.lamarques.command

import com.lamarques.strategy.Budget
import java.time.LocalDateTime

data class GenerateOrder(
    val user: String,
    val value: Double
) {
    fun execute() {
        val budget = Budget(value)
        val order = Order(user, LocalDateTime.now(), budget)

        println("Salvo no banco de dados")
        println("Disparo de email realizado.")
    }
}