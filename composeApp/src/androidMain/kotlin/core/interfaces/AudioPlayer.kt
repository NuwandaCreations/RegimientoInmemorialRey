package core.interfaces

import android.media.MediaPlayer
import com.nuwandacreations.regimientoinmemorialreykmp.R
import ui.RegimientoInmemorialReyApp

class AndroidAudioPlayer : AudioPlayer {
    private var player: MediaPlayer? = null
    override fun play() {
        if (player != null) {
            player!!.start()
        } else {
            player = MediaPlayer.create(RegimientoInmemorialReyApp.appContext, R.raw.anthem)
            player!!.start()
        }
    }

    override fun pause() {
        if (player != null) {
            player!!.pause()
        }
    }

    override fun stop() {
        if (player != null) {
            player!!.stop()
            player = null
        }
    }
}

actual fun buildAudioPlayer(): AudioPlayer = AndroidAudioPlayer()