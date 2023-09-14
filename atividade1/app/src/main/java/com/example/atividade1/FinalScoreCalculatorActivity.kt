package com.example.atividade1

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityFinalScoreCalculatorBinding
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.cleanTextFields
import com.example.atividade1.utils.ActivityUtils.createFieldToast
import com.example.atividade1.utils.ActivityUtils.createToast

class FinalScoreCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalScoreCalculatorBinding

    private lateinit var defaultMessage: String
    private lateinit var scoreValidationMessage: String
    private lateinit var inputFields: List<EditText>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinalScoreCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultMessage = getString(R.string.final_score)
        scoreValidationMessage = getString(R.string.grade_validation)

        inputFields = listOf(
            binding.edtNota1,
            binding.edtNota2,
            binding.edtNota3,
            binding.edtNota4
        )

        binding.btnCalcular.setOnClickListener {
            if (areFieldsEmpty(inputFields)) {
                createFieldToast(this)

            } else if (!areAllGradesValid()) {
                createToast(this, scoreValidationMessage)
                cleanTextFields(inputFields)

            } else {
                binding.edtMedia.text = String.format(defaultMessage, calculateFinalScore())
            }
        }

        binding.edtMedia.clearComposingText()
    }

    private fun calculateFinalScore(): Double {
        return (getGrade(inputFields[0]) +
                getGrade(inputFields[1]) +
                getGrade(inputFields[2]) +
                getGrade(inputFields[3])) / 4
    }

    private fun areAllGradesValid() = inputFields.all { field ->
        val grade = getGrade(field)
        grade in 0.0..10.0
    }

    private fun getGrade(inputField: EditText): Double {
        return inputField.text.toString().toDouble()
    }
}

