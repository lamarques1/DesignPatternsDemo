package com.lamarques.command.actions

import com.lamarques.command.Order

class SendEmailOrder {
    fun execute(order: Order) {
        println("Disparo de email realizado.")
    }
}