package com.example.getnotified.data.remote.dto

import com.example.getnotified.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)