package data.network

import dev.gitlive.firebase.storage.FirebaseStorage
import dev.gitlive.firebase.storage.StorageReference

class StorageService(private val storage: FirebaseStorage) {
    fun getDuties(): StorageReference {
        return getReference("oficial_cuartel.pdf")
    }

    fun getDailyOrder(): StorageReference {
        return getReference("orden.pdf")
    }

    private fun getReference(doc: String): StorageReference {
        return storage.reference.child(doc)
    }
}