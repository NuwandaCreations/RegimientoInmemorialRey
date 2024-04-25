package core.interfaces

interface AudioPlayer {
    fun play()
    fun pause()
    fun stop()
}

expect fun buildAudioPlayer() : AudioPlayer