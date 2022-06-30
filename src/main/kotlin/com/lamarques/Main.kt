package com.lamarques

import com.lamarques.chainofresponsibility.DiscountHighValue
import com.lamarques.chainofresponsibility.DiscountManager
import com.lamarques.chainofresponsibility.DiscountMultipleItems
import com.lamarques.chainofresponsibility.Product
import com.lamarques.strategy.ImpostoICMS
import com.lamarques.strategy.ImpostoISS
import com.lamarques.strategy.Orcamento

fun main(args : Array<String>) {
    executeStrategy()
    executeChainOfResponsibility()

}

private fun executeStrategy() {
    val orcamento = Orcamento(100.0)
    val icms = ImpostoICMS().calcular(orcamento)
    val iss = ImpostoISS().calcular(orcamento)

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