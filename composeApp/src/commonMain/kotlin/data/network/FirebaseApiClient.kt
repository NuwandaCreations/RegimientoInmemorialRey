package data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

interface FirebaseApiClient {
    suspend fun getDuties(): String {
        val client = HttpClient()
        return client.get("https://file-examples.com/storage/feed2327706616bd9a07caa/2017/10/file-sample_150kB.pdf").bodyAsText()
    }
}