package ui.screens.anthem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import core.UIInterface

class AnthemScreen : Screen, UIInterface {
    @Composable
    override fun Content() {
        Column (
            Modifier.fillMaxSize().background(Color(0xFF998B86)).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(25)
            Text(
                "Hijos somos del ínclito Marte\n" +
                        "y a la Patria ofrecemos la vida\n" +
                        "nos recuerda la Ensaña querida\n" +
                        "que juramos su honor defender\n" +
                        "Esa ilustre y gloriosa Bandera\n" +
                        "de la Patria es el símbolo amado\n" +
                        "con cariño a ese lienzo sagrado\n" +
                        "nuestra sangre debemos verter.\n" +
                        "\n" +
                        "No hay soldado que en ruda campaña\n" +
                        "vacilante se quede detrás\n" +
                        "siempre digno y en honra de España\n" +
                        "ni aún vencido se humilla jamás.\n" +
                        "Si la Patria lo exige, sabemos\n" +
                        "en la lucha alcanzar alta prez\n" +
                        "cuanto más en peligro la vemos\n" +
                        "crece más nuestra fiera altivez\n" +
                        "\n" +
                        "Nietos somos de aquellos valientes\n" +
                        "que tan alto renombre alcanzaron\n" +
                        "y animosos con furia lucharon\n" +
                        "por librarnos del fiero invasor.\n" +
                        "Derramando su sangre a torrentes\n" +
                        "por la Patria, esa intrépida raza\n" +
                        "con su ejemplo, el sendero nos traza\n" +
                        "que debemos seguir en su honor\n" +
                        "\n" +
                        "Defender a dos madres queridas\n" +
                        "la misión del soldado ha de ser\n" +
                        "ofreciendo por ella cien vidas\n" +
                        "si cien vidas pudiera tener\n" +
                        "al amor de esas madres juremos\n" +
                        "en el alma elevar un altar\n" +
                        "cuanto más a la Patria adoremos\n" +
                        "la otra más orgullosa ha de estar\n" +
                        "\n" +
                        "Si hay quien dude Patria amada de tu historia\n" +
                        "si hay quien sueñe mancillar tu eterna gloria\n" +
                        "romperá el Inmemorial del Rey el fuego\n" +
                        "y el ejército español te salvará.\n" +
                        "\n" +
                        "¡ Todo por la Patria !\n" +
                        "¡ Todo por la Patria !\n" +
                        "¡ Inmemorial del Rey !.",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
            Spacer(25)
        }
    }
}