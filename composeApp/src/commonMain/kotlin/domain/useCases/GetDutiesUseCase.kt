package domain.useCases

import data.Repository
import dev.gitlive.firebase.storage.StorageReference


class GetDutiesUseCase(val repository: Repository) {
    operator fun invoke(): StorageReference {
        return repository.getDuties()
    }
}