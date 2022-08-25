package com.lamarques.command

import com.lamarques.command.actions.SaveOrderOnDatabase
import com.lamarques.command.actions.SendEmailOrder
import com.lamarques.strategy.Budget
import java.time.LocalDateTime

data class GenerateOrder(
    val user: String,
    val value: Double
) {
    fun execute() {
        val budget = Budget(value)
        val order = Order(user, LocalDateTime.now(), budget)

        val saveOrderOnDatabase = SaveOrderOnDatabase().run {
            execute(order)
        }
        val sendEmailOrder = SendEmailOrder().run {
            execute(order)
        }
    }
}