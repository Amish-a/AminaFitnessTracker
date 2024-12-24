package ua.opu.aminafitnesstracker

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import androidx.core.content.ContextCompat

class StatisticsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TrainingAdapter
    private lateinit var periodSpinner: Spinner
    private lateinit var progressChart: LineChart
    private lateinit var showProgressButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        // Ініціалізація елементів UI
        recyclerView = findViewById(R.id.recyclerViewStatistics)
        periodSpinner = findViewById(R.id.spinnerTimePeriod)
        progressChart = findViewById(R.id.progressChart)
        showProgressButton = findViewById(R.id.buttonShowProgress)

        // Налаштування Spinner
        val periods = listOf("День", "Тиждень", "Місяць")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, periods)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        periodSpinner.adapter = spinnerAdapter

        // Обробник натискання кнопки для відображення графіка
        showProgressButton.setOnClickListener {
            // Зробити графік видимим
            progressChart.visibility = android.view.View.VISIBLE

            // Створити дані для графіка
            val entries = listOf(
                Entry(1f, 300f), // (x, y) значення
                Entry(2f, 350f),
                Entry(3f, 280f),
                Entry(4f, 400f)
            )

            // Створити набір даних для графіка
            val dataSet = LineDataSet(entries, "Calories Burned")

            // Налаштування вигляду графіка
            dataSet.color = ContextCompat.getColor(this, R.color.colorPrimary)
            dataSet.valueTextColor = ContextCompat.getColor(this, R.color.black)

            // Створення LineData та передача його у графік
            val lineData = LineData(dataSet)
            progressChart.data = lineData

            // Оновлення графіка
            progressChart.invalidate()
        }
    }
}
