package domain.useCases

import data.Repository

class StartWebIntent(private val repository: Repository) {
    operator fun invoke(url: String) {
        repository.startWebIntent(url)
    }
}