package com.lamarques.chainofresponsibility

interface IDiscount {
    fun evaluate(value: Double, quantity: Int): Double
}