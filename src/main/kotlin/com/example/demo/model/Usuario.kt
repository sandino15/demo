package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank


@Entity
class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

val id: Long,
    @NotBlank
    var nome: String,

    @NotBlank
    @Email
    var email: String,

    @NotBlank
    var nascimento:Int,

    @NotBlank
    var altura:Double,

    @NotBlank
    var peso:Double,

    @NotBlank
    var senha:String,
)
