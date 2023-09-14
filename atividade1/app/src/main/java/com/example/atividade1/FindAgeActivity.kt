package com.example.atividade1

import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade1.databinding.ActivityFindAgeBinding
import com.example.atividade1.utils.ActivityUtils.areFieldsEmpty
import com.example.atividade1.utils.ActivityUtils.cleanTextFields
import com.example.atividade1.utils.ActivityUtils.createFieldToast
import com.example.atividade1.utils.ActivityUtils.createToast

class FindAgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFindAgeBinding

    private lateinit var ageValidationMessage: String
    private lateinit var ageMessage: String
    private lateinit var inputFields: List<EditText>

    private val link = "https://www.youtube.com/watch?v=pjd3E426dWQ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFindAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ageValidationMessage = getString(R.string.age_validation)
        ageMessage = getString(R.string.age_message)

        inputFields = listOf(
            binding.edtAnoNascimento
        )

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                createSurpriseIntent()
                binding.checkBox.isChecked = false
            }
        }

        binding.btnCalcular.setOnClickListener {
            if (areFieldsEmpty(inputFields)) {
                createFieldToast(this)

            } else if (!isBirthYearValid()) {
                createToast(this, ageValidationMessage)
                cleanTextFields(inputFields)

            } else {
                binding.edtIdade.text = String.format(ageMessage, calculateCurrentAge())
            }
        }

        binding.edtIdade.clearComposingText()
    }

    private fun calculateCurrentAge(): Int {
        return Calendar.YEAR - getBirthYear()
    }

    private fun isBirthYearValid(): Boolean {
        return getBirthYear() in 1900 downTo Calendar.YEAR
    }

    private fun getBirthYear(): Int {
        return inputFields[0].text.toString().toInt()
    }

    private fun createSurpriseIntent() {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }
}

