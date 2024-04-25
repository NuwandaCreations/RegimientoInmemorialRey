package core.betaNetwork

import android.content.Intent
import android.net.Uri
import ui.RegimientoInmemorialReyApp

actual class BetaNetwork actual constructor() {
    actual fun externalOpen(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        val context = RegimientoInmemorialReyApp.appContext
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}