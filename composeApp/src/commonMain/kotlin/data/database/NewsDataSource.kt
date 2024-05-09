package data.database

import domain.model.News
import inmemorialDatabase.InmemorialDatabase

class NewsDataSource(private val database: InmemorialDatabase) {
    fun getNews(): List<News> =
        database.inmemorialDatabaseQueries.selectNews(::mapToNewsModel).executeAsList()

    fun insertNews(news: List<News>) = database.inmemorialDatabaseQueries.transaction {
        news.forEach { news ->
            insertSingleNews(news)
        }
    }

    fun clearNews() = database.inmemorialDatabaseQueries.removeNews()

    private fun insertSingleNews(news: News) {
        database.inmemorialDatabaseQueries.insertNews(
            news.title,
            news.photo,
            news.date,
            news.url
        )
    }

    private fun mapToNewsModel(
        title: String?,
        photo: String?,
        date: String?,
        url: String?
    ): News = News(title, photo, date, url)
}