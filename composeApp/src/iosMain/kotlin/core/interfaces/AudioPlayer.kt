package core.interfaces

class IosAudioPlayer: AudioPlayer {
    override fun play() {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}

actual fun buildAudioPlayer(): AudioPlayer = IosAudioPlayer()