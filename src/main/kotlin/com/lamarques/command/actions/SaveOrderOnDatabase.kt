package com.lamarques.command.actions

import com.lamarques.command.Order

class SaveOrderOnDatabase {
    fun execute(order: Order) {
        println("Salvo no banco de dados")
    }

}