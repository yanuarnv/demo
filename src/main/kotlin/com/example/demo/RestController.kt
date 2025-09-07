package com.example.demo

import org.apache.juli.logging.Log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.optionals.getOrElse

@RestController
@RequestMapping("/api/v1/articles")
class RestController(val repository: ArticleRepository) {

    @GetMapping
    fun articles() = repository.findAllByOrderByCreateAtDesc()

    @GetMapping("/search")
    fun searchArticles(@RequestParam(required = false, defaultValue = "") title: String): Iterable<Article> {
        val article = repository.findByTitleContainingIgnoreCase(title)
        return article
    }

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        repository.save(article)
        return article
    }

    @PutMapping("/{id}")
    fun updateArticle(@RequestBody article: Article, @PathVariable id: Long): ResponseEntity<ApiResponse<Article>> {
        val exsistingArticle = repository.findById(id).getOrElse { throw ResponseStatusException(HttpStatus.NOT_FOUND) }
        exsistingArticle.content = article.title
        exsistingArticle.title = article.content
        val entity = repository.save(exsistingArticle)
        return ResponseEntity.ok(ApiResponse(true, "Success Update", entity))
    }

    @DeleteMapping("/{id}")
    fun deleteArticles(@PathVariable id: Long): Article {
        val exsistingArticle = repository.findById(id).getOrElse { throw ResponseStatusException(HttpStatus.NOT_FOUND) }
        repository.delete(exsistingArticle)
        return exsistingArticle
    }
}