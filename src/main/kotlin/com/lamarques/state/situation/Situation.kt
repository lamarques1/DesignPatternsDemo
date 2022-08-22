package com.lamarques.state.situation

import com.lamarques.exception.DomainException
import com.lamarques.strategy.Budget

abstract class Situation {

    open fun calculateExtraDiscount(budget: Budget): Double {
        throw DomainException("Orçamento não possui desconto válido.")
    }

    open fun approve(budget: Budget) {
        throw DomainException("Orcamento não pode ser aprovado")
    }

    open fun reprove(budget: Budget) {
        throw DomainException("Orcamento não pode ser reprovado")
    }

    open fun finish(budget: Budget) {
        throw DomainException("Orcamento não pode ser finalizado")
    }
}