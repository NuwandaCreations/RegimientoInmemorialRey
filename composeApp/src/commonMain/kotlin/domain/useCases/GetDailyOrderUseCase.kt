package domain.useCases

import data.Repository
import dev.gitlive.firebase.storage.StorageReference

class GetDailyOrderUseCase(val repository: Repository) {
    operator fun invoke(): StorageReference {
        return repository.getDailyOrder()
    }
}