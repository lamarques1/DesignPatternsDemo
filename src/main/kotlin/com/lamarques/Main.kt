package com.lamarques

import com.lamarques.strategy.ImpostoICMS
import com.lamarques.strategy.ImpostoISS
import com.lamarques.strategy.Orcamento

fun main(args : Array<String>) {
    val orcamento = Orcamento(100.0)
    val icms = ImpostoICMS().calcular(orcamento)
    val iss = ImpostoISS().calcular(orcamento)

    println("### Strategy ###")
    println("ICMS: $icms")
    println("ISS: $iss")
    println("######")

}