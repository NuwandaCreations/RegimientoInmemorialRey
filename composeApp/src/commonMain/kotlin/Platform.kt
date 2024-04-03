interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

class OperatingSystem {
    companion object {
        const val IOS = "iOS"
        const val ANDROID = "Android"
    }
}