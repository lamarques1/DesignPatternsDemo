package com.lamarques

import com.lamarques.chainofresponsibility.DiscountHighValue
import com.lamarques.chainofresponsibility.DiscountManager
import com.lamarques.chainofresponsibility.DiscountMultipleItems
import com.lamarques.chainofresponsibility.Product
import com.lamarques.command.GenerateOrder
import com.lamarques.command.actions.OrderAction
import com.lamarques.command.actions.SaveOrderOnDatabase
import com.lamarques.command.actions.SendEmailOrder
import com.lamarques.strategy.Budget
import com.lamarques.strategy.ImpostoICMS
import com.lamarques.strategy.ImpostoISS

fun main(args : Array<String>) {
    executeStrategy()
    executeChainOfResponsibility()
    executeState()
    executeCommand()
}

private fun executeStrategy() {
    val budget = Budget(100.0)
    val icms = ImpostoICMS().calcular(budget)
    val iss = ImpostoISS().calcular(budget)

    println("### Strategy ###")
    println("ICMS: $icms")
    println("ISS: $iss")
    println("######")
}

private fun executeChainOfResponsibility() {
    val discountHighValue = DiscountHighValue()
    val discountMultipleItems = DiscountMultipleItems()
    val discountManager = DiscountManager().apply {
        register(discountHighValue)
        register(discountMultipleItems)
    }

    val productOne = Product(100.0, 10)
    val discountOne = discountManager.verify(productOne.value, productOne.quantity)
    val productTwo = Product(1000.0, 1)
    val discountTwo = discountManager.verify(productTwo.value, productTwo.quantity)
    println("### Chain Of Responsibility ###")
    println("Discount by quantity: $discountOne")
    println("Discount  by value: $discountTwo")
    println("######")
}

fun executeState() {
    val budget = Budget(100.0)
    println("### State ###")
    val processingDiscount = budget.situation.calculateExtraDiscount(budget)
    println(budget.value - processingDiscount)
    budget.approve()
    val approvedDiscount = budget.situation.calculateExtraDiscount(budget)
    println(budget.value - approvedDiscount)
    println("######")
}

fun executeCommand() {
    val user = "Lamarques"
    val value = 100.0
    val orderActions = mutableListOf(SaveOrderOnDatabase(), SendEmailOrder())
    val generator = GenerateOrder(user, value, orderActions)
    println("### Command ###")
    generator.execute()
    println("######")
}