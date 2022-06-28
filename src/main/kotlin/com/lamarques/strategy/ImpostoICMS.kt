package com.lamarques.strategy

class ImpostoICMS: ImpostoStrategy {
    override fun calcular(orcamento: Orcamento): Double {
        return orcamento.valor * 0.1
    }
}