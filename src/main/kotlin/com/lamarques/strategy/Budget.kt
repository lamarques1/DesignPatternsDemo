package com.lamarques.strategy

import com.lamarques.state.situation.Processing
import com.lamarques.state.situation.Situation

data class Budget(
    var value: Double,
    var situation: Situation = Processing()
) {
    fun approve() = situation.approve(this)

    fun reprove() = situation.reprove(this)

    fun finish() = situation.finish(this)
}
