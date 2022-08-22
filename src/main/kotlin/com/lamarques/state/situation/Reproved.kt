package com.lamarques.state.situation

import com.lamarques.strategy.Budget

class Reproved: Situation() {
    override fun finish(budget: Budget) {
        budget.situation = Finished()
    }
}