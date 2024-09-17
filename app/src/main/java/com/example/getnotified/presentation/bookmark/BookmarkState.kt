package com.example.getnotified.presentation.bookmark

import com.example.getnotified.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
