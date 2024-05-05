package data.network

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.network.parseGetRequest
import com.fleeksoft.ksoup.nodes.Document

class WebService {
    suspend fun getNewsDoc(): Document {
        return Ksoup.parseGetRequest(url = "https://ejercito.defensa.gob.es/unidades/Madrid/rinf1/Noticias/index.html")
    }
}

expect fun webIntent(url: String)

