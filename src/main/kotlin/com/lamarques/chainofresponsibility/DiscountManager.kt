package com.lamarques.chainofresponsibility

class DiscountManager {
    private val discountTypes = mutableListOf<IDiscount>()

    fun register(discount: IDiscount) {
        discountTypes.add(discount)
    }

    fun verify(value: Double, quantity: Int): Double {
        discountTypes.forEach {
            val result = it.evaluate(value, quantity)
            if (result != value) {
                return result
            }
        }

        return value
    }
}