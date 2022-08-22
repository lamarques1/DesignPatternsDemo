package com.lamarques.state.situation

import com.lamarques.strategy.Budget

class Approved: Situation() {

    override fun calculateExtraDiscount(budget: Budget): Double {
        return budget.value * 0.02
    }

    override fun finish(budget: Budget) {
        budget.situation = Finished()
    }
}