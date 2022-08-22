package com.lamarques.state.situation

import com.lamarques.strategy.Budget

class Processing: Situation() {

    override fun calculateExtraDiscount(budget: Budget): Double {
        return budget.value * 0.05
    }

    override fun approve(budget: Budget) {
        budget.situation = Approved()
    }

    override fun reprove(budget: Budget) {
        budget.situation = Reproved()
    }
}