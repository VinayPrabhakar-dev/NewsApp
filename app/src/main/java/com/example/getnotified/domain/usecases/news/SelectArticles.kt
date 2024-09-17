package com.example.getnotified.domain.usecases.news

import com.example.getnotified.data.local.NewsDao
import com.example.getnotified.domain.model.Article
import com.example.getnotified.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }

}