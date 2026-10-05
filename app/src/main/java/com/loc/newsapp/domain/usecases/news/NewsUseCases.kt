package com.loc.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertNews: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle
)
