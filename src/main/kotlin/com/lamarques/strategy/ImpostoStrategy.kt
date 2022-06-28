package com.lamarques.strategy

interface ImpostoStrategy {
    fun calcular(orcamento: Orcamento): Double
}