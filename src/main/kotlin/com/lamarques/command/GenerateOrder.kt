package com.lamarques.command

import com.lamarques.command.actions.OrderAction
import com.lamarques.strategy.Budget
import java.time.LocalDateTime

data class GenerateOrder(
    val user: String,
    val value: Double,
    val orderActions: List<OrderAction>
) {
    fun execute() {
        val budget = Budget(value)
        val order = Order(user, LocalDateTime.now(), budget)

        orderActions.forEach {
            it.execute(order)
        }
    }
}