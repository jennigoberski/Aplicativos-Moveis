package com.example.atividade1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.atividade1.databinding.ActivityMainBinding
import com.example.atividade1.ui.theme.Atividade1Theme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalario.setOnClickListener {
            createIntent(PaymentBonusCalculatorActivity::class.java)
        }

        binding.btnVolumeCaixa.setOnClickListener {
            createIntent(BoxVolumeCalculatorActivity::class.java)
        }

        binding.btnIdade.setOnClickListener {
            createIntent(FindAgeActivity::class.java)
        }

        binding.btnCarro.setOnClickListener {
            createIntent(CarConsumptionActivity::class.java)
        }

        binding.btnMedia.setOnClickListener {
            createIntent(FinalScoreCalculatorActivity::class.java)
        }

        binding.btnTemperatura.setOnClickListener {
            createIntent(TemperatureConverterActivity::class.java)
        }

        binding.btnVolumeCilindro.setOnClickListener {
            createIntent(CylinderVolumeCalculatorActivity::class.java)
        }

        binding.btnSurpresa.setOnClickListener {
            createSurpriseIntent()
        }

    }

    private fun createIntent(activityClass: Class<*>) {
        intent = Intent(this, activityClass)
        startActivity(intent)
    }

    private fun createSurpriseIntent() {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }

}