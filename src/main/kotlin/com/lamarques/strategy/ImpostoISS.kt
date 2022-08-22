package com.lamarques.strategy

class ImpostoISS: ImpostoStrategy {
    override fun calcular(budget: Budget): Double {
        return budget.value * 0.06
    }
}