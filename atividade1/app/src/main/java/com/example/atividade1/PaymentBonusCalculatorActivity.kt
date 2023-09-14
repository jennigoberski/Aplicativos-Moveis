package com.example.atividade1

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityPaymentBonusCalculatorBinding
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.createFieldToast

class PaymentBonusCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBonusCalculatorBinding

    private lateinit var defaultMessage: String
    private lateinit var inputFields: List<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBonusCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultMessage = getString(R.string.default_salary_message)

        inputFields = listOf(
            binding.edtSalario,
            binding.edtPorcentagem
        )

        binding.btnCalcular.setOnClickListener {
            if (areFieldsEmpty(inputFields)) {
                createFieldToast(this)

            } else {
                binding.txtSalario.text =
                    String.format(defaultMessage, getSalaryRaise(), getNewSalary())
            }
        }

        binding.txtSalario.clearComposingText()
    }

    private fun getSalaryRaise(): Double {
        return (getCurrentSalary() * getRaisePercentage()) / 100.0
    }

    private fun getNewSalary(): Double {
        return getCurrentSalary() + getSalaryRaise()
    }

    private fun getCurrentSalary(): Double {
        return inputFields[0].text.toString().toDouble()
    }

    private fun getRaisePercentage(): Double {
        return inputFields[1].text.toString().toDouble()
    }
}