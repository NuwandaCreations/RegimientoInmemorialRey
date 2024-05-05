package domain.useCases

import data.Repository
import domain.model.News

class GetNewsUseCase(private val repository: Repository) {
    suspend operator fun invoke(): List<News> {
        return repository.getNews()
    }
}