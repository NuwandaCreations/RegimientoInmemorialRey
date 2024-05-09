package domain.useCases

import data.Repository
import domain.model.News

class GetNewsUseCase(private val repository: Repository) {
    suspend operator fun invoke(uploadNews: Boolean = false): List<News> {
        return repository.getNews(uploadNews)
    }
}