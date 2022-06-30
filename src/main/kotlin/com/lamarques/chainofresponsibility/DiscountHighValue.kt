package com.lamarques.chainofresponsibility

class DiscountHighValue: IDiscount {
    override fun evaluate(value: Double, quantity: Int): Double {
        if (value > 500.0) {
            return value * 0.1
        }
        return value
    }
}