package com.lamarques.strategy

class ImpostoICMS: ImpostoStrategy {
    override fun calcular(budget: Budget): Double {
        return budget.value * 0.1
    }
}