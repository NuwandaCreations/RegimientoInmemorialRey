package data

import data.network.StorageService
import dev.gitlive.firebase.storage.StorageReference

class Repository(private val storageService: StorageService) {
    fun getDuties(): StorageReference {
        return storageService.getDuties()
    }

    fun getDailyOrder(): StorageReference {
        return storageService.getDailyOrder()
    }
}