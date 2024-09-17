package com.example.getnotified.domain.usecases.news

import com.example.getnotified.data.local.NewsDao
import com.example.getnotified.domain.model.Article
import com.example.getnotified.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article?{
        return newsRepository.selectArticle(url)
    }

}