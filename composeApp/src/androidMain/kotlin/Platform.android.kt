import OperatingSystem.Companion.ANDROID

class AndroidPlatform : Platform {
    override val name: String = ANDROID
}

actual fun getPlatform(): Platform = AndroidPlatform()