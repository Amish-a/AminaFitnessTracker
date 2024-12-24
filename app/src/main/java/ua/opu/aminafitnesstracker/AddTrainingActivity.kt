package ua.opu.aminafitnesstracker

import ua.opu.aminafitnesstracker.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class AddTrainingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_training)

        val trainingNameEditText = findViewById<EditText>(R.id.editTextTrainingName)
        val categorySpinner = findViewById<Spinner>(R.id.spinnerCategory)
        val caloriesEditText = findViewById<EditText>(R.id.editTextCalories)
        val addButton = findViewById<Button>(R.id.buttonAddTraining)

        // Встановлюємо адаптер для Spinner
        val categories = resources.getStringArray(R.array.categories)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = spinnerAdapter

        addButton.setOnClickListener {
            val trainingName = trainingNameEditText.text.toString()
            val trainingCategory = categorySpinner.selectedItem.toString()
            val calories = caloriesEditText.text.toString().toIntOrNull() ?: 0

            if (trainingName.isNotEmpty()) {
                // Отримуємо поточну дату
                val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

                // Повертаємо дані назад до MainActivity
                val resultIntent = Intent().apply {
                    putExtra("trainingName", trainingName)
                    putExtra("trainingCategory", trainingCategory)
                    putExtra("calories", calories)
                    putExtra("date", currentDate)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Введіть назву тренування", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
