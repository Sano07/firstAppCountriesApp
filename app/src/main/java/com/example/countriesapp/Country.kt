package com.example.countriesapp

data class Country (
    val name: Name,
    val capital: List<String>,
    val population: Long,
    val area: Double,
    val languages: Map<String, String>,
    val flags: Map<String, String>
)

data class Name(
    val common: String,
    val official: String
)