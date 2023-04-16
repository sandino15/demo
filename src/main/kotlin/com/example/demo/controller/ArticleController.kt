package com.example.demo.controller

import com.example.demo.model.Usuario
import com.example.demo.repository.ArticleRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class ArticleController (private val articleRepository: ArticleRepository){
    @Autowired
    lateinit var repository: ArticleRepository

    @GetMapping("/articles")
    fun getAllArticles(): List<Usuario> {
        return articleRepository.findAll()
    }
    @PostMapping
    fun create(@Valid @RequestBody usuario: Usuario): Usuario {
        return  articleRepository.save(usuario)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable ("id") articleId: Long, @Valid @RequestBody newUsuario: Usuario): Usuario {
    val article= articleRepository.findById(articleId).orElseThrow { EntityNotFoundException() }
     return articleRepository.save(article)
    }

@DeleteMapping("/{id}")
fun delete(@PathVariable ("id") articleId: Long,){
    val article =repository.findById(articleId).orElseThrow { EntityNotFoundException() }
    repository.delete(article)
}
}