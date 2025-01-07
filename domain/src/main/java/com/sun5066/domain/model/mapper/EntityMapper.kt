package com.sun5066.domain.model.mapper

interface EntityMapper<in ENTITY : Any, out MODEL : Any> {
    fun toModel(entity: ENTITY): MODEL
}