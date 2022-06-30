package com.lamarques.chainofresponsibility

class DiscountMultipleItems: IDiscount {
    override fun evaluate(value: Double, quantity: Int): Double {
        if (quantity > 5) {
            return value * 0.05
        }
        return value
    }
}