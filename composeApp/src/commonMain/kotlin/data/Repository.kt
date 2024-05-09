package data

import com.fleeksoft.ksoup.nodes.Document
import data.database.NewsDataSource
import data.network.StorageService
import data.network.WebService
import data.network.webIntent
import dev.gitlive.firebase.storage.StorageReference
import domain.model.News

class Repository(
    private val storageService: StorageService,
    private val webService: WebService,
    private val dataSource: NewsDataSource
) {
    fun getDuties(): StorageReference {
        return storageService.getDuties()
    }

    fun getDailyOrder(): StorageReference {
        return storageService.getDailyOrder()
    }

    fun startWebIntent(url: String) {
        webIntent(url)
    }

    suspend fun getNews(uploadNews: Boolean = false): List<News> {
        if (uploadNews) {
            dataSource.clearNews()
            return fetchNews()
        } else {
            val databaseNews = dataSource.getNews()
            if (databaseNews.isEmpty()) {
                return fetchNews()
            }
            return databaseNews
        }
    }

    private suspend fun fetchNews(): List<News> {
        val doc: Document = webService.getNewsDoc()
        val listOfNews: MutableList<News> = mutableListOf()
        val newsList = doc.getElementsByAttributeValueContaining(
            "class",
            match = "noticiasUnidades row"
        )

        newsList.forEach {
            val newsTitle = it.getElementsByAttributeValueContaining(
                key = "title",
                match = "Ampliar información"
            )

            val newsPhoto =
                it.getElementsByAttributeValueContaining(key = "class", match = "imagen-bbox")
            var newsPhotoUrl = newsPhoto.attr("href")
            newsPhotoUrl = "https://ejercito.defensa.gob.es${newsPhotoUrl.substring(11)}"

            val newsDate = it.getElementsByAttributeValueContaining(
                key = "class",
                match = "antetituloHome fechaNoticiaTexto mt-2"
            )

            var infoUrl = newsTitle.attr("href")
            infoUrl = "https://ejercito.defensa.gob.es/unidades/Madrid/rinf1/Noticias/$infoUrl"

            listOfNews.add(News(newsTitle.text(), newsPhotoUrl, newsDate.text(), infoUrl))
        }
        dataSource.insertNews(listOfNews.toList())
        return listOfNews.toList()
    }
}