package com.example.atividade1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityTemperatureConverterBinding
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.createFieldToast

class TemperatureConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemperatureConverterBinding

    private lateinit var defaultMessage: String
    private lateinit var inputFields: List<EditText>

    private val link = "https://www.youtube.com/watch?v=QHZ8HSlAp_o"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTemperatureConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputFields = listOf(
            binding.edtCTemp
        )

        defaultMessage = getString(R.string.temperature_message)

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                createSurpriseIntent()
                binding.switch1.isChecked = false
            }
        }

        binding.btnCalcular.setOnClickListener {
            if (areFieldsEmpty(inputFields)) {
                createFieldToast(this)

            } else {
                binding.edtFTemp.text = String.format(defaultMessage, convertToFahrenheit())
            }
        }

        binding.edtFTemp.clearComposingText()

    }

    private fun convertToFahrenheit(): Double {
        return (9 * getCTemperature() + 160) / 5
    }

    private fun getCTemperature(): Double {
        return inputFields[0].text.toString().toDouble()
    }

    private fun createSurpriseIntent() {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }
}