package com.example.atividade1

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityCarConsumptionBinding
import com.example.atividade1.utils.ActivityUtils
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.createFieldToast

class CarConsumptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarConsumptionBinding

    private lateinit var defaultMessage: String
    private lateinit var inputFields: List<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarConsumptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultMessage = getString(R.string.car_comsumption_message)

        inputFields = listOf(
            binding.edtKm,
            binding.edtLitros
        )

        binding.btnCalcular.setOnClickListener {
            if (areFieldsEmpty(inputFields)) {
                createFieldToast(this)

            } else {
                binding.edtConsumo.text = String.format(defaultMessage, calculateConsumption())
            }
        }

        binding.edtConsumo.clearComposingText()
    }

    private fun calculateConsumption(): Double {
        return getLiters() / getKm()
    }

    private fun getKm(): Double {
        return inputFields[0].text.toString().toDouble()
    }

    private fun getLiters(): Double {
        return inputFields[1].text.toString().toDouble()
    }
}