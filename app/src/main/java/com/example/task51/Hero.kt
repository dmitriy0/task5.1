package com.example.task51

import com.squareup.moshi.Json

data class Hero (
    @Json(name = "localized_name")
    val name: String,
    @Json(name = "icon")
    val iconUrl: String,
    @Json(name = "base_health")
    val health: Int,
    @Json(name = "base_mana")
    val mana: Int,
    @Json(name = "img")
    val imageUrl: String,
    val roles: Array<String>,
    @Json(name = "attack_type")
    val attackType: String
)
