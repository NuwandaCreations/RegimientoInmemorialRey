package data.network

import dev.gitlive.firebase.storage.FirebaseStorage
import dev.gitlive.firebase.storage.StorageReference

class StorageService(private val storage: FirebaseStorage) {
    fun getDuties(): StorageReference {
        return storage.reference.child("oficial_cuartel.pdf")
    }

    fun getDailyOrder(): StorageReference {
        return storage.reference.child("orden.pdf")
    }
}