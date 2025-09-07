package com.example.demo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    var title: String,
    var content: String,
    @Column(name = "created_at")
    val createAt: LocalDateTime = LocalDateTime.now(),
)



