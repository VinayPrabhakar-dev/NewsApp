package com.example.getnotified.domain.usecases.news

import com.example.getnotified.data.local.NewsDao
import com.example.getnotified.domain.model.Article
import com.example.getnotified.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }

}