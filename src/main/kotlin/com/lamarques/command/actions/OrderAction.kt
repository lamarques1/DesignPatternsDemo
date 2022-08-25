package com.lamarques.command.actions

import com.lamarques.command.Order

interface OrderAction {
    fun execute(order: Order)
}