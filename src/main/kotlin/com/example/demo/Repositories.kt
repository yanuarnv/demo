package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface ArticleRepository : JpaRepository<Article, Long> {
    fun findAllByOrderByCreateAtDesc(): Iterable<Article>
    fun findByTitleContainingIgnoreCase(keyword: String): Iterable<Article>
}
