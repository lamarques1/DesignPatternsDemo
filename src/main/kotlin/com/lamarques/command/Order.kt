package com.lamarques.command

import com.lamarques.strategy.Budget
import java.time.LocalDateTime

data class Order(
    val user: String,
    val date: LocalDateTime,
    val budget: Budget
)