package com.tunix.kafkadatagenerator.mapper

fun interface Mappable<M, D> {
    fun toModel(d: D): M
}