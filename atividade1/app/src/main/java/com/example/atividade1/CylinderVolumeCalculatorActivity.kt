package com.example.atividade1

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityCylinderVolumeCalculatorBinding
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.createFieldToast

class CylinderVolumeCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCylinderVolumeCalculatorBinding

    private val PI = 3.14

    private lateinit var defaultMessage: String
    private lateinit var inputFields: List<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCylinderVolumeCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultMessage = getString(com.example.atividade1.R.string.cylinder_volume_message)

        inputFields = listOf(
            binding.edtAltura,
            binding.edtRaio
        )

        binding.btnCalcular.setOnClickListener {
            if (areFieldsEmpty(inputFields)) {
                createFieldToast(this)

            } else {
                binding.edtVolume.text = String.format(defaultMessage, calculateVolume())
            }
        }

        binding.edtVolume.clearComposingText()
    }

    private fun calculateVolume(): Double {
        return getHeight() * getRadius() * PI
    }

    private fun getHeight(): Double {
        return inputFields[0].text.toString().toDouble()
    }

    private fun getRadius(): Double {
        return inputFields[1].text.toString().toDouble()
    }
}