package com.example.atividade1.utils

import android.content.Context
import android.widget.EditText
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

object ActivityUtils {

    public fun cleanTextFields(inputFields: List<EditText>) {
        inputFields.forEach { it.text.clear() }
    }

    public fun areFieldsEmpty(inputFields: List<EditText>): Boolean {

        if (inputFields.any { it.text.toString().isEmpty() }) {
            cleanTextFields(inputFields)
            return true
        }
        return false
    }

    public fun createFieldToast(context: Context) {
        makeText(context, "Todos os campos precisam ser informados!", LENGTH_LONG).show()
    }

    public fun createToast(context: Context, message: String) {
        makeText(context, message, LENGTH_LONG).show()
    }
}