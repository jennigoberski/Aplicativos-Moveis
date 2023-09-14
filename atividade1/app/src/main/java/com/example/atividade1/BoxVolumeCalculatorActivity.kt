package com.example.atividade1

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityBoxVolumeCalculatorBinding
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.createFieldToast

class BoxVolumeCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoxVolumeCalculatorBinding

    private lateinit var defaultMessage: String
    private lateinit var inputFields: List<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoxVolumeCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultMessage = getString(R.string.inform_box_volume)

        inputFields = listOf(
            binding.edtAltura,
            binding.edtLargura,
            binding.edtComprimento
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
        return getHeight() * getWidth() * getLength()
    }

    private fun getHeight(): Double {
        return inputFields[0].text.toString().toDouble()
    }

    private fun getWidth(): Double {
        return inputFields[1].text.toString().toDouble()
    }

    private fun getLength(): Double {
        return inputFields[2].text.toString().toDouble()
    }
}