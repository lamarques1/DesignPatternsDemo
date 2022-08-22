package com.lamarques.strategy

interface ImpostoStrategy {
    fun calcular(budget: Budget): Double
}