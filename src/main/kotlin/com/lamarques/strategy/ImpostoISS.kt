package com.lamarques.strategy

class ImpostoISS: ImpostoStrategy {
    override fun calcular(orcamento: Orcamento): Double {
        return orcamento.valor * 0.06
    }
}